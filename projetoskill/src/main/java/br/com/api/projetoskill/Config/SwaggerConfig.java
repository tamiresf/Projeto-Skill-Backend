package br.com.api.projetoskill.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiKey apiKey() {
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}

	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	
	private List<SecurityReference> defaultAuth() {
		List<SecurityReference> securityReferences = new ArrayList<>();
		securityReferences.add(new SecurityReference("JWT", new AuthorizationScope[0]));
		return securityReferences;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securityContexts(Collections.singletonList(securityContext())).securitySchemes(Arrays.asList(apiKey()))

				.select().apis(RequestHandlerSelectors.basePackage("br.com.api.projetoskill.Controllers"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Documentação da Api")
				.description("Projeto skill - Desafio Técnico").license("Apache license version 2.0").version("4.0.0")
				.build();
		return apiInfo;
	}
}
