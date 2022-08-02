package com.socgen.skilltracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.SkillsEntity;

@Service
public interface EngineerSkillsService {
	public EngineerSkills addEngineerSkills(EngineerEntity engineerEntity, SkillsEntity skillsEntity, Long expertiseLevel);
	public EngineerSkills findByEngineerEntityAndSkillsEntity(EngineerEntity engineerEntity, SkillsEntity skillsEntity);
	public EngineerSkills updateEngineerSkills(EngineerSkills engineerSkills);
	public List<EngineerSkills> findskills(EngineerEntity engineerEntity);
	public List<EngineerSkills> findAllBySkillEntity(SkillsEntity skillsEntity);
}
