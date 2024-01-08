package br.com.api.projetoskill.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.api.projetoskill.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	boolean existsByLogin(String login);

	Optional<Usuario> findByLogin(String email);
	

}