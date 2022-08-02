package com.socgen.skilltracker.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.skilltracker.entity.SkillsEntity;
import com.socgen.skilltracker.repository.SkillsRepository;
import com.socgen.skilltracker.service.SkillsService;

@Service
public class SkillsServiceImpl implements SkillsService {
	@Autowired
	SkillsRepository skillsRepository;

	@Override
	public SkillsEntity findBySkillName(String skillName) {
		return skillsRepository.findBySkillNameIgnoreCase(skillName);
	}
	
	
	
}
