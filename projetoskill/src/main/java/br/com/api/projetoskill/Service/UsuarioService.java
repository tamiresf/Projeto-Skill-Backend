package br.com.api.projetoskill.Service;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.projetoskill.Config.JWTUtil;
import br.com.api.projetoskill.Config.UserDetailsServiceImpl;
import br.com.api.projetoskill.Repositories.UsuarioRepository;
import br.com.api.projetoskill.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UsuarioService {
	
	@Autowired
	UserDetailsService userDetailsService;
		
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetail;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void salvarUsuario(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}

}
