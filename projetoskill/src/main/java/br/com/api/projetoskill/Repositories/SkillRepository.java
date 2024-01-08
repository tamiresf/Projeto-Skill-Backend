package br.com.api.projetoskill.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.projetoskill.entities.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}