package com.socgen.skilltracker.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.SkillsJson;

public class EngineerDto {
	private Long userID;
	
	@NotNull(message = "Associate ID should be not null")
	@Size(min = 5, max=30, message = "Associate ID should have min 5 and max 30 chars")
	@Pattern(regexp = "^CTS[a-zA-Z0-9]{2,27}$", message = "Associate ID should start with CTS")
	private String associateID;
	
	@NotNull(message = "Name should be not null")
	@Size(min = 5, max=30, message = "Name should have min 5 and max 30 chars")
	private String name;

	@Email(message = "Invalid Email")
	private String email;

	@NotNull(message = "Mobile should be not null")
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number")
	@Size(min = 10, max = 10, message = "Length of phone number should be 10")
	private String mobile;

	private LocalDateTime dateAdded;

	private LocalDateTime dateUpdated;
	
	private List<SkillsJson> skills;

	
	public EngineerDto() {
		super();
	}



	public EngineerDto(Long userID,
			@NotNull(message = "Associate ID should be not null") @Size(min = 5, max = 30, message = "Associate ID should have min 5 and max 30 chars") @Pattern(regexp = "^CTS[a-zA-z0-9]{2,27}$", message = "Associate ID should start with CTS") String associateID,
			@NotNull(message = "Name should be not null") @Size(min = 5, max = 30, message = "Name should have min 5 and max 30 chars") String name,
			@Email(message = "Invalid Email") String email,
			@NotNull(message = "Mobile should be not null") @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number") @Size(min = 10, max = 10, message = "Length of phone number should be 10") String mobile,
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
	
	
	
	public EngineerDto(
			@NotNull(message = "Associate ID should be not null") @Size(min = 5, max = 30, message = "Associate ID should have min 5 and max 30 chars") @Pattern(regexp = "^CTS[a-zA-z0-9]{2,27}$", message = "Associate ID should start with CTS") String associateID,
			@NotNull(message = "Name should be not null") @Size(min = 5, max = 30, message = "Name should have min 5 and max 30 chars") String name,
			@Email(message = "Invalid Email") String email,
			@NotNull(message = "Mobile should be not null") @Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number") @Size(min = 10, max = 10, message = "Length of phone number should be 10") String mobile) {
		super();
		this.associateID = associateID;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
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
		return "EngineerDto [userID=" + userID + ", associateID=" + associateID + ", name=" + name + ", email=" + email
				+ ", mobile=" + mobile + ", dateAdded=" + dateAdded + ", dateUpdated=" + dateUpdated + ", skills="
				+ skills + "]";
	}
	
	public EngineerEntity toEngineerEntity() {
		EngineerEntity engineer = new EngineerEntity(this.userID, this.associateID, this.name, this.email, this.mobile, this.dateAdded, this.dateUpdated);
		return engineer;
	}



	public List<SkillsJson> getSkills() {
		return skills;
	}



	public void setSkillsinList(SkillsJson skills) {
		this.skills.add(skills);
	}



	public void setSkills(List<SkillsJson> skills) {
		this.skills = skills;
	}
	
	
	
}
