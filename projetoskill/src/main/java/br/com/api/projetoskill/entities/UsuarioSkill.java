package br.com.api.projetoskill.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_skill")
public class UsuarioSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int level;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	public UsuarioSkill() {
		super();
	}

	public UsuarioSkill(Long id, int level, Usuario usuario, Skill skill) {
		super();
		this.id = id;
		this.level = level;
		this.usuario = usuario;
		this.skill = skill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Usuario_Skill [id=" + id + ", level=" + level + ", usuario=" + usuario + ", skill=" + skill + "]";
	}

}
