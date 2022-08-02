package com.socgen.skilltracker.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.skilltracker.dto.EngineerDto;
import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.SkillsEntity;
import com.socgen.skilltracker.entity.SkillsJson;
import com.socgen.skilltracker.service.EngineerService;
import com.socgen.skilltracker.service.EngineerSkillsService;
import com.socgen.skilltracker.service.SkillsService;

@RestController
@RequestMapping("/skill-tracker/api/v1/engineer")
public class EngineerController {
	
	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private SkillsService skillsService;
	
	@Autowired
	private EngineerSkillsService engineerSkillsService;
	
	@PostMapping("/add-profile")
	public ResponseEntity<?> addprofile(@RequestBody @Valid EngineerDto engineerDto){
//		System.out.println(engineerDto);
		List<SkillsJson> skillset = engineerDto.getSkills();
		EngineerEntity engineerEntity = engineerDto.toEngineerEntity();
		
		for (int i = 0; i < skillset.size(); i++) {
//			System.out.println(skillset.get(i).getSkillName());
//			System.out.println(skillset.get(i).getExpertiseLevel());
			String skillName = skillset.get(i).getSkillName();
			Long expertiseLevel = skillset.get(i).getExpertiseLevel();
			SkillsEntity skillsEntity = skillsService.findBySkillName(skillName);
			engineerEntity.addSkills(skillsEntity, expertiseLevel);
//			engineerSkillsService.addEngineerSkills(engineerEntity, skillsEntity, expertiseLevel);	
		}
		
		engineerService.updateprofile(engineerEntity);
		System.out.println(engineerEntity);

		return new ResponseEntity<EngineerEntity>(engineerEntity,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/update-profile/{userId}")
	public ResponseEntity<?> updateProfile(@PathVariable Long userId,@RequestBody @Valid List<SkillsJson> skills){
//		System.out.println("User Id: "+userId);
//		System.out.println("Skills: "+ skills);
		try {
			EngineerEntity engineerEntity = engineerService.findByUserID(userId);
			int days = Period.between(LocalDate.now(),engineerEntity.getDateUpdated().toLocalDate() ).getDays();
			if(days<10) {
				throw new Exception("Can only be updated once in 10 days");
			}
			for (int i = 0; i < skills.size(); i++) {

//				System.out.println(skills.get(i).getSkillName());
//				System.out.println(skills.get(i).getExpertiseLevel());
				String skillName = skills.get(i).getSkillName();
				Long expertiseLevel = skills.get(i).getExpertiseLevel();
				SkillsEntity skillsEntity = skillsService.findBySkillName(skillName);
				EngineerSkills engineerSkills = engineerSkillsService.findByEngineerEntityAndSkillsEntity(engineerEntity, skillsEntity);
				System.out.println("ESkills"+engineerSkills);
				System.out.println("Index of "+skillName + engineerEntity.findSkills(engineerSkills));
				int index = engineerEntity.findSkills(engineerSkills);
				engineerSkills.setExpertiseLevel(expertiseLevel);
				engineerEntity.updateSkills(index, engineerSkills);
//				System.out.println(engineerSkills);
				EngineerSkills updatedEngineerSkills = engineerSkillsService.updateEngineerSkills(engineerSkills);	
				System.out.println(updatedEngineerSkills);
			}
			engineerEntity.setDateUpdated(LocalDateTime.now());
			engineerService.updateprofile(engineerEntity);
//			engineerEntity.setDateUpdated(LocalDateTime.now());
//			EngineerEntity updatedEngineerEntity = engineerService.addprofile(engineerEntity.toEngineerDto()).toEngineerEntity();
			return new ResponseEntity<String>("Helloo",HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Errroorrr"+ e);
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
