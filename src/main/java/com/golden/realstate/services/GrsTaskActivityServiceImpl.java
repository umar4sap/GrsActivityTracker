package com.golden.realstate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golden.realstate.exception.GrsException;
import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.repository.GrsRepository;

@Service
@Transactional
public class GrsTaskActivityServiceImpl implements GrsTaskActivityService{

	@Autowired
	private GrsRepository grsRepository;
	


	@Override
	public GrsTaskActivityModelEntity createTask(GrsTaskActivityModelEntity entity) {
		
		return grsRepository.save(entity);
	}

	@Override
	public GrsTaskActivityModelEntity updateTask(GrsTaskActivityModelEntity entity) {
	
		Optional <GrsTaskActivityModelEntity> tasks=this.grsRepository.findById(entity.getTaskId());
		if(tasks.isPresent()) {
			GrsTaskActivityModelEntity taskUpdate=tasks.get();
			taskUpdate.setTaskName(entity.getTaskName());
			taskUpdate.setStatus(entity.getStatus());
			grsRepository.save(taskUpdate);
			return taskUpdate;
			
		}else
		{
			throw new GrsException("not found");
		}
	}

	@Override
	public List<GrsTaskActivityModelEntity> getAllTask() {
	
		return (List<GrsTaskActivityModelEntity>) this.grsRepository.findAll();
	}

	@Override
	public GrsTaskActivityModelEntity getTaskById(long taskId) {
	
		Optional <GrsTaskActivityModelEntity> task=this.grsRepository.findById(taskId);
		if(task.isPresent()) {
		
			return task.get();
			
		}else
		{
			throw new GrsException("task not exist");
		}
	}

}
