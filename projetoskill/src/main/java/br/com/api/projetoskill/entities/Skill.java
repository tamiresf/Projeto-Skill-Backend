package br.com.api.projetoskill.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "habilidade")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String skill;

	@OneToMany(mappedBy = "skill")
	private Set<UsuarioSkill> usuario_Skill;

	public Skill() {
		super();
	}

	public Skill(Long id, String skill, Set<UsuarioSkill> usuario_Skill) {
		super();
		this.id = id;
		this.skill = skill;
		this.usuario_Skill = usuario_Skill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Set<UsuarioSkill> getUsuario_Skill() {
		return usuario_Skill;
	}

	public void setUsuario_Skill(Set<UsuarioSkill> usuario_Skill) {
		this.usuario_Skill = usuario_Skill;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", skill=" + skill + ", usuario_Skill=" + usuario_Skill + "]";
	}

}
