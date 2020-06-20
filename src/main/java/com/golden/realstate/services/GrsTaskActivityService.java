package com.golden.realstate.services;

import java.util.List;

import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.repository.GrsRepository;

public interface GrsTaskActivityService {

	GrsTaskActivityModelEntity createTask(GrsTaskActivityModelEntity entity);
	GrsTaskActivityModelEntity  updateTask(GrsTaskActivityModelEntity entity);
	List<GrsTaskActivityModelEntity>  getAllTask();
	GrsTaskActivityModelEntity getTaskById(long taskId);
	
	List<GrsTaskActivityModelEntity>  getAllTaskByProjectId(String projectId);
	List<GrsTaskActivityModelEntity> getAllTaskByEmpId(String empId);
	
	
	
	
}
