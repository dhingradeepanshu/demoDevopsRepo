package com.socgen.skilltracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.socgen.skilltracker.dto.EngineerDto;
import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.SkillsEntity;

@Service
public interface EngineerService {
	public EngineerEntity addprofile(EngineerDto engineerDto);
	public EngineerEntity findByUserID(Long userID) throws Exception;
	public EngineerEntity updateprofile(EngineerEntity engineerEntity);
	public EngineerEntity findByName(String name);
	public EngineerEntity findByAssociateID(String AssociateId);
}
