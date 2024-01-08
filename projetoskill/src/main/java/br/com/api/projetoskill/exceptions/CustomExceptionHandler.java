package br.com.api.projetoskill.exceptions;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		

		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento corretamente e tente novamente ");

		return handleExceptionInternal(ex, problema, headers, status, request);
	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		

		Problema problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo(ex.getMessage());
		

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}

}