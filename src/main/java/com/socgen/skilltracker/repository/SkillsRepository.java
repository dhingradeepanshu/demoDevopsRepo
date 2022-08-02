package com.socgen.skilltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgen.skilltracker.entity.SkillsEntity;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsEntity, Long>{
	SkillsEntity findBySkillNameIgnoreCase(String skillName);
}
