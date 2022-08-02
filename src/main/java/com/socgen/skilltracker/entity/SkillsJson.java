package com.socgen.skilltracker.entity;

public class SkillsJson {
	private String skillName;
	private Long expertiseLevel;
	
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public Long getExpertiseLevel() {
		return expertiseLevel;
	}
	public void setExpertiseLevel(Long expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}
	@Override
	public String toString() {
		return "SkillsJson [skillName=" + skillName + ", expertiseLevel=" + expertiseLevel + "]";
	}
	public SkillsJson(String skillName, Long expertiseLevel) {
		super();
		this.skillName = skillName;
		this.expertiseLevel = expertiseLevel;
	}
}
