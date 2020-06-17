package com.golden.realstate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.repository.GrsRepository;

@Service
public class GrsDao {
	
	@Autowired
	GrsRepository TaskRepo;
  
	public GrsTaskActivityModelEntity save(GrsTaskActivityModelEntity task) {
		return TaskRepo.save(task);
	}
     
	public Iterable<GrsTaskActivityModelEntity> findAll() {
		return TaskRepo.findAll();
	}
	public Optional<GrsTaskActivityModelEntity> findOne(Long taskId) {
		return TaskRepo.findById(taskId);
		
	}
	public void delete(Long taskId) {
		TaskRepo.deleteById(taskId);
		
	}
	
}
