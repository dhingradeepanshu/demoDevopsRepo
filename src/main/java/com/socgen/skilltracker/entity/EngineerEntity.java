package com.socgen.skilltracker.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.socgen.skilltracker.dto.EngineerDto;

@Entity
@Table(name = "engineers")
public class EngineerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	
	@Column(unique=true)
	private String associateID;
	
	private String name;
	
	private String email;
	
	private String mobile;
	
	@CreationTimestamp
	private LocalDateTime dateAdded;
	
	@UpdateTimestamp
	private LocalDateTime dateUpdated;
	
	@OneToMany(
	        mappedBy = "engineerEntity",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	)
	private List<EngineerSkills> skillsEnginner = new ArrayList<>();

	public EngineerEntity() {
		super();
	}

	public EngineerEntity(Long userID, String associateID, String name, String email, String mobile,
			LocalDateTime dateAdded, LocalDateTime dateUpdated) {
		super();
		this.userID = userID;
		this.associateID = associateID;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.dateAdded = dateAdded;
		this.dateUpdated = dateUpdated;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getAssociateID() {
		return associateID;
	}

	public void setAssociateID(String associateID) {
		this.associateID = associateID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDateTime getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public LocalDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	@Override
	public String toString() {
		return "EngineerEntity [userID=" + userID + ", associateID=" + associateID + ", name=" + name + ", email="
				+ email + ", mobile=" + mobile + ", dateAdded=" + dateAdded + ", dateUpdated=" + dateUpdated + "]";
	}
	
	public EngineerDto toEngineerDto() {
		EngineerDto engineerDto = new EngineerDto(this.userID, this.associateID, this.name, this.email, this.mobile, this.dateAdded, this.dateUpdated);
		return engineerDto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(associateID, dateAdded, dateUpdated, email, mobile, name, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineerEntity other = (EngineerEntity) obj;
		return Objects.equals(associateID, other.associateID) && Objects.equals(dateAdded, other.dateAdded)
				&& Objects.equals(dateUpdated, other.dateUpdated) && Objects.equals(email, other.email)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
				&& Objects.equals(userID, other.userID);
	}
	
	public void addSkills(SkillsEntity skill, Long expertiseLevel) {
        EngineerSkills engineerSkills = new EngineerSkills(this, skill, expertiseLevel);
        skillsEnginner.add(engineerSkills);
        skill.getEngineerSkills().add(engineerSkills);
    }
	
	public int findSkills(EngineerSkills engineerSkills) {
		return skillsEnginner.indexOf(engineerSkills);
	}
	
	public void updateSkills(int index, EngineerSkills engineerSkills) {
		skillsEnginner.set(index, engineerSkills);
	}
	
}
