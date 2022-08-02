package com.socgen.skilltracker.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.entity.EngineerSkills;
import com.socgen.skilltracker.entity.EngineerSkillsID;
import com.socgen.skilltracker.entity.SkillsEntity;

@Repository
public interface EngineerSkillsRepository extends JpaRepository<EngineerSkills, EngineerSkillsID> {
	EngineerSkills findByEngineerEntityAndSkillsEntity(EngineerEntity engineerEntity, SkillsEntity skillsEntity);
	List<EngineerSkills> findAllByEngineerEntity(EngineerEntity engineerEntity, Sort sort);
	List<EngineerSkills> findAllBySkillsEntity(SkillsEntity skillsEntity, Sort sort);
}
