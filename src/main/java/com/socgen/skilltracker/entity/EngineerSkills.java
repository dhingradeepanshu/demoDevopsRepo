package com.socgen.skilltracker.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class EngineerSkills {
	
	@EmbeddedId
	private EngineerSkillsID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userID")
    private EngineerEntity engineerEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("skillID")
    private SkillsEntity skillsEntity;
	
	@Min(value = 0, message = "Expertise Level must be greater than 0")
	@Max(value = 20, message = "Expertise Level must be greater than 20")
	private Long expertiseLevel;

	public EngineerSkills() {
		super();
	}

	public EngineerSkills(EngineerEntity engineerEntity, SkillsEntity skillsEntity,
			@Min(value = 0, message = "Expertise Level must be greater than 0") @Max(value = 20, message = "Expertise Level must be greater than 20") Long expertiseLevel) {
		super();
		this.engineerEntity = engineerEntity;
		this.skillsEntity = skillsEntity;
		this.id = new EngineerSkillsID(engineerEntity.getUserID(), skillsEntity.getSkillID());
		this.expertiseLevel = expertiseLevel;
	}
	
	public EngineerSkillsID getId() {
		return id;
	}

	public void setId(EngineerSkillsID id) {
		this.id = id;
	}

	public EngineerEntity getEngineerEntity() {
		return engineerEntity;
	}

	public void setEngineerEntity(EngineerEntity engineerEntity) {
		this.engineerEntity = engineerEntity;
	}

	public SkillsEntity getSkillsEntity() {
		return skillsEntity;
	}

	public void setSkillsEntity(SkillsEntity skillsEntity) {
		this.skillsEntity = skillsEntity;
	}

	public Long getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(Long expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(engineerEntity, expertiseLevel, id, skillsEntity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineerSkills other = (EngineerSkills) obj;
		return Objects.equals(engineerEntity, other.engineerEntity)
				&& Objects.equals(expertiseLevel, other.expertiseLevel) && Objects.equals(id, other.id)
				&& Objects.equals(skillsEntity, other.skillsEntity);
	}

	@Override
	public String toString() {
		return "EngineerSkills [id=" + id + ", engineerEntity=" + engineerEntity + ", skillsEntity=" + skillsEntity
				+ ", expertiseLevel=" + expertiseLevel + "]";
	}
	
	
	
}
