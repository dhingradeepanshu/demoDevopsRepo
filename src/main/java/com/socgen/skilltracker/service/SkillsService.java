package com.socgen.skilltracker.service;

import org.springframework.stereotype.Service;

import com.socgen.skilltracker.entity.SkillsEntity;

@Service
public interface SkillsService {
	SkillsEntity findBySkillName(String skillName);
}
