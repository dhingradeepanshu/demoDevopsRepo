package com.socgen.skilltracker.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class SkillsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long skillID;
	
	private String skillName;

	@OneToMany(
	        mappedBy = "skillsEntity",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private List<EngineerSkills> engineerSkills = new ArrayList<>();
	
	public Long getSkillID() {
		return skillID;
	}

	public void setSkillID(Long skillID) {
		this.skillID = skillID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "SkillsEntity [skillID=" + skillID + ", skillName=" + skillName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(skillID, skillName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkillsEntity other = (SkillsEntity) obj;
		return Objects.equals(skillID, other.skillID) && Objects.equals(skillName, other.skillName);
	}

	public List<EngineerSkills> getEngineerSkills() {
		return engineerSkills;
	}
	
	
	
	
}
