package com.socgen.skilltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socgen.skilltracker.entity.EngineerEntity;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Repository
public interface EngineerRepository extends JpaRepository<EngineerEntity, Long>{
	public EngineerEntity findByNameIgnoreCase(String name);
	public EngineerEntity findByAssociateID(String AssociateId);
}
