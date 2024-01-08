package br.com.api.projetoskill.Controllers;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.projetoskill.Config.JWTUtil;
import br.com.api.projetoskill.Repositories.UsuarioRepository;
import br.com.api.projetoskill.Service.UsuarioService;
import br.com.api.projetoskill.dto.LoginDTO;
import br.com.api.projetoskill.dto.UsuarioInput;
import br.com.api.projetoskill.entities.Usuario;
import br.com.api.projetoskill.exceptions.NegocioException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	JWTUtil jWTUtil;

	@PostMapping("/cadastrar")
	public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioInput usuario) {
		if (usuarioRepository.existsByLogin(usuario.getLogin())) {
			return new ResponseEntity<>("Login já está sendo utilizado!", HttpStatus.BAD_REQUEST);
		}
		usuarioService.salvarUsuario(mapper.map(usuario, Usuario.class));
		return new ResponseEntity<>("Login cadastrado!", HttpStatus.OK);

	}


//	@PostMapping("/login")
//	public ResponseEntity<?> AutenticarUsuario(@RequestBody Map<String, String> credentials) {
//		String login = credentials.get("login");
//		String senha = credentials.get("senha");
//
////		Usuario usuario = usuarioRepository.findByLogin(login);
//////		if (usuario == null || !usuario.getSenha().equals(senha)) {
//////			return new ResponseEntity<>("Nome de usuário ou senha inválidos", HttpStatus.UNAUTHORIZED);
//////		}
//		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(login, senha);
//		Authentication auth = authenticationManager.authenticate(authRequest);
//		
//		String jwt = jWTUtil.generateToken(login);
//		
//		SecurityContextHolder.getContext().setAuthentication(auth);
//
//		return new ResponseEntity<>("Logado com sucesso!", HttpStatus.OK);
//		
//		
//	}

	// Login de usuario
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody LoginDTO body) {

		try {
			// Criando o token que sera usado no processo de autenticacao
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getLogin(), body.getSenha());
			// Autenticando as credenciais de login
			authenticationManager.authenticate(authInputToken);

			// Se o processo de autenticacao foi concluido com sucesso - etapa anterior,
			// eh gerado o JWT


			Optional<Usuario> usuario = usuarioRepository.findByLogin(body.getLogin());
			String token = "";
			if (usuario.isEmpty()) {

			} else {
				Usuario usuario2 = usuario.get();
				Usuario usuarioResumido = new Usuario();
				usuarioResumido.setNome(usuario2.getNome());
				usuarioResumido.setLogin(usuario2.getLogin());
				usuarioResumido.setId(usuario2.getId());
				token = jwtUtil.generateTokenWithUsuarioData(usuarioResumido);
			}
			// Gerando o token JWT a partir dos dados do Usuario
			// Responde com o JWT
			return Collections.singletonMap("jwt-token", token);
		} catch (AuthenticationException authExc) {
			throw new NegocioException("Credenciais Invalidas", authExc);
		}
	}
}
