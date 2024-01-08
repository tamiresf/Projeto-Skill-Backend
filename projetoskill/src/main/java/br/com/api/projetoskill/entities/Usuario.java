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
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_usuario", nullable = false)
	private String nome;

	@Column(name = "login_usuario", nullable = false)
	private String login;

	@Column(name = "senha_usuario", nullable = false)
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private Set<UsuarioSkill> usuario_Skill;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String login, String senha, Set<UsuarioSkill> usuario_Skill) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.usuario_Skill = usuario_Skill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<UsuarioSkill> getUsuario_Skill() {
		return usuario_Skill;
	}

	public void setUsuario_Skill(Set<UsuarioSkill> usuario_Skill) {
		this.usuario_Skill = usuario_Skill;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", usuario_Skill="
				+ usuario_Skill + "]";
	}

}
