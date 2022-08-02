package com.socgen.skilltracker.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class EngineerSkillsID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userID;
	
	private Long skillID;
	
	
	public EngineerSkillsID() {
		super();
	}

	public EngineerSkillsID(Long userID, Long skillID) {
		super();
		this.userID = userID;
		this.skillID = skillID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getSkillID() {
		return skillID;
	}

	public void setSkillID(Long skillID) {
		this.skillID = skillID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(skillID, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineerSkillsID other = (EngineerSkillsID) obj;
		return Objects.equals(skillID, other.skillID) && Objects.equals(userID, other.userID);
	}
	
}
