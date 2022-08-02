package com.socgen.skilltracker.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.skilltracker.dto.EngineerDto;
import com.socgen.skilltracker.entity.EngineerEntity;
import com.socgen.skilltracker.repository.EngineerRepository;
import com.socgen.skilltracker.service.EngineerService;

@Service
public class EngineerServiceImpl implements EngineerService{
	@Autowired
	private EngineerRepository engineerRepository;
	
	@Override
	public EngineerEntity addprofile(EngineerDto engineerDto) {
		EngineerEntity engineerEntity = engineerRepository.save(engineerDto.toEngineerEntity());
		return engineerEntity;
	}

	@Override
	public EngineerEntity findByUserID(Long userID) throws Exception {
		if(engineerRepository.existsById(userID)) {
			EngineerEntity engineerEntity = engineerRepository.findById(userID).get();
			return engineerEntity;
		}else {
			throw new Exception("User Not Found");
		}
		
	}

	@Override
	public EngineerEntity updateprofile(EngineerEntity engineerEntity) {
		// TODO Auto-generated method stub
		return engineerRepository.save(engineerEntity);
	}

	@Override
	public EngineerEntity findByName(String name) {
		// TODO Auto-generated method stub
		return engineerRepository.findByNameIgnoreCase(name);
	}

	@Override
	public EngineerEntity findByAssociateID(String AssociateId) {
		// TODO Auto-generated method stub
		return engineerRepository.findByAssociateID(AssociateId);
	}

}
