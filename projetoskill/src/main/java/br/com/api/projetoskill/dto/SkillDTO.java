package br.com.api.projetoskill.dto;

public class SkillDTO {

	private Long id;
	private String skill;

	public SkillDTO() {
		super();
	}

	public SkillDTO(Long id, String skill) {
		super();
		this.id = id;
		this.skill = skill;
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

}
