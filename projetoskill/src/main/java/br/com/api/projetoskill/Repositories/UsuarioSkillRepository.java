package br.com.api.projetoskill.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projetoskill.entities.UsuarioSkill;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long> {

	List<UsuarioSkill> findByUsuarioId(Long usuarioId);
}
