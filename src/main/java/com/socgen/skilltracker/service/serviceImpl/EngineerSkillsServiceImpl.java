package com.socgen.skilltracker.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.SkillsEntity;
import com.socgen.skilltracker.repository.EngineerSkillsRepository;
import com.socgen.skilltracker.service.EngineerSkillsService;


@Service
public class EngineerSkillsServiceImpl implements EngineerSkillsService{
	@Autowired
	EngineerSkillsRepository engineerSkillsRepository;

	@Override
	public EngineerSkills addEngineerSkills(EngineerEntity engineerEntity, SkillsEntity skillsEntity,
			Long expertiseLevel) {
		EngineerSkills engineerSkills = new EngineerSkills(engineerEntity, skillsEntity, expertiseLevel);
		
		return engineerSkillsRepository.save(engineerSkills);
	}

	@Override
	public EngineerSkills findByEngineerEntityAndSkillsEntity(EngineerEntity engineerEntity,
			SkillsEntity skillsEntity) {
		// TODO Auto-generated method stub
		EngineerSkills engineerSkills = engineerSkillsRepository.findByEngineerEntityAndSkillsEntity(engineerEntity, skillsEntity);
		return engineerSkills;
	}

	@Override
	public EngineerSkills updateEngineerSkills(EngineerSkills engineerSkills) {
		// TODO Auto-generated method stub
		return engineerSkillsRepository.save(engineerSkills);
	}

	@Override
	public List<EngineerSkills> findskills(EngineerEntity engineerEntity) {
		// TODO Auto-generated method stub
		return engineerSkillsRepository.findAllByEngineerEntity(engineerEntity, Sort.by("expertiseLevel").descending());
	}

	@Override
	public List<EngineerSkills> findAllBySkillEntity(SkillsEntity skillsEntity) {
		// TODO Auto-generated method stub
		return engineerSkillsRepository.findAllBySkillsEntity(skillsEntity, Sort.by("expertiseLevel").descending());
	}
	
	
	
}
