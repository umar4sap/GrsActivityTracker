package com.golden.realstate.services;

import java.util.List;

import com.golden.realstate.model.BuildingProjectModelEntity;

public interface GrsProjectService {

	BuildingProjectModelEntity createProject(BuildingProjectModelEntity entity);
	BuildingProjectModelEntity  updateProject(BuildingProjectModelEntity entity);
	List<BuildingProjectModelEntity>  getAllProject();
	BuildingProjectModelEntity getProjectById(long taskId);
	
	
	
}
