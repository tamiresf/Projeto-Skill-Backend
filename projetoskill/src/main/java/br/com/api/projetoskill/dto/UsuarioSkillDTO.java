package br.com.api.projetoskill.dto;

public class UsuarioSkillDTO {

	private Long id;

	private int level;

	private SkillDTO skill;

	public UsuarioSkillDTO() {
		super();
	}

	public UsuarioSkillDTO(Long id, int level, SkillDTO skill) {
		super();
		this.id = id;
		this.level = level;
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

	public SkillDTO getSkill() {
		return skill;
	}

	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}
}
