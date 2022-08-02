package com.socgen.skilltracker.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/skill-tracker/api/v1/admin")
public class AdminController {

	@Autowired
	private EngineerService engineerService;
	
	@Autowired
	private SkillsService skillsService;
	
	@Autowired
	private EngineerSkillsService engineerSkillsService;
	
	@GetMapping("/{criteria}/{criteraValue}")
	public ResponseEntity<?> search(@PathVariable String criteria, @PathVariable String criteraValue){
		try {
			if(criteria.equalsIgnoreCase("Name")) {
				EngineerEntity engineerEntity = engineerService.findByName(criteraValue);
				EngineerDto engineerDto = engineerEntity.toEngineerDto();
				List<EngineerSkills> engineerSkillsList = engineerSkillsService.findskills(engineerEntity);
				List<SkillsJson> skills = new ArrayList<>();
				System.out.println("here in admin "+engineerSkillsList);
				for(int i=0; i<engineerSkillsList.size(); i++) {
					EngineerSkills engineerSkills = engineerSkillsList.get(i);
					String skillName = engineerSkills.getSkillsEntity().getSkillName();
					Long expertiseLevel = engineerSkills.getExpertiseLevel();
					System.out.println("level "+skillName + expertiseLevel);
					skills.add(new SkillsJson(skillName, expertiseLevel));
				}
				System.out.println(skills);
				engineerDto.setSkills(skills);
				return new ResponseEntity<EngineerDto>(engineerDto, HttpStatus.ACCEPTED);
			}else if (criteria.equalsIgnoreCase("AssociateId")) {
				EngineerEntity engineerEntity = engineerService.findByAssociateID(criteraValue);
				System.out.println("Searched engi  "+ engineerEntity + criteraValue);
				EngineerDto engineerDto = engineerEntity.toEngineerDto();
				List<EngineerSkills> engineerSkillsList = engineerSkillsService.findskills(engineerEntity);
				List<SkillsJson> skills = new ArrayList<>();
				System.out.println("here in admin "+engineerSkillsList);
				for(int i=0; i<engineerSkillsList.size(); i++) {
					EngineerSkills engineerSkills = engineerSkillsList.get(i);
					String skillName = engineerSkills.getSkillsEntity().getSkillName();
					Long expertiseLevel = engineerSkills.getExpertiseLevel();
					System.out.println("level "+skillName + expertiseLevel);
					skills.add(new SkillsJson(skillName, expertiseLevel));
				}
				System.out.println(skills);
				engineerDto.setSkills(skills);
				return new ResponseEntity<EngineerDto>(engineerDto, HttpStatus.ACCEPTED);
			}else if (criteria.equalsIgnoreCase("Skill")) {
				SkillsEntity skillsEntity = skillsService.findBySkillName(criteraValue);
				List<EngineerSkills> engineerSkills = engineerSkillsService.findAllBySkillEntity(skillsEntity);
				List<EngineerDto> engineerDtos = new ArrayList<>();
			
				for(int i=0;i<engineerSkills.size();i++) {
					Long expertiseLevel = engineerSkills.get(i).getExpertiseLevel();
					if(expertiseLevel>10) {
						List<SkillsJson> skills = new ArrayList<>();
						EngineerDto engineerDto = engineerSkills.get(i).getEngineerEntity().toEngineerDto();
						
						skills.add(new SkillsJson(skillsEntity.getSkillName(), expertiseLevel));
						engineerDto.setSkills(skills);
						engineerDtos.add(engineerDto);
					}
					
				}
				
				return new ResponseEntity<List<EngineerDto>>(engineerDtos, HttpStatus.ACCEPTED);
				
			}else {
				return null;
			}
			
		}catch (Exception e) {
			
			return new ResponseEntity<Exception>(e, HttpStatus.BAD_REQUEST);
			// TODO: handle exception
		}
		
	}
}
