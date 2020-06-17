package com.golden.realstate.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.golden.realstate.model.GrsTaskActivityModel;
import com.golden.realstate.repository.GrsRepository;

@Service
public class GrsDao {
	
	@Autowired
	GrsRepository TaskRepo;
  
	public GrsTaskActivityModel save(GrsTaskActivityModel task) {
		return TaskRepo.save(task);
	}
     
	public Iterable<GrsTaskActivityModel> findAll() {
		return TaskRepo.findAll();
	}
	public Optional<GrsTaskActivityModel> findOne(Long taskId) {
		return TaskRepo.findById(taskId);
		
	}
	public void delete(Long taskId) {
		TaskRepo.deleteById(taskId);
		
	}
	
}
