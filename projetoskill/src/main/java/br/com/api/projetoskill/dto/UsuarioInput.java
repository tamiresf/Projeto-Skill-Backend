package br.com.api.projetoskill.dto;

import java.util.Set;

import br.com.api.projetoskill.entities.UsuarioSkill;

public class UsuarioInput {

	private String nome;

	private String login;

	private String senha;

	private Set<UsuarioSkill> usuario_Skill;

	public UsuarioInput() {
		super();
	}

	public UsuarioInput(String nome, String login, String senha, Set<UsuarioSkill> usuario_Skill) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.usuario_Skill = usuario_Skill;
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
}
