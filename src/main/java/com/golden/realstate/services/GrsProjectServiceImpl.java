package com.golden.realstate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golden.realstate.exception.GrsException;
import com.golden.realstate.model.BuildingProjectModelEntity;
import com.golden.realstate.repository.GrsProjectRepository;

@Service
@Transactional
public class GrsProjectServiceImpl implements GrsProjectService{

	@Autowired
	private GrsProjectRepository grsRepository;
	


	@Override
	public BuildingProjectModelEntity createProject(BuildingProjectModelEntity entity) {
		
		return grsRepository.save(entity);
	}

	@Override
	public BuildingProjectModelEntity updateProject(BuildingProjectModelEntity entity) {
	
		Optional <BuildingProjectModelEntity> projects=this.grsRepository.findById(entity.getProjectId());
		if(projects.isPresent()) {
			BuildingProjectModelEntity projectUpdate=projects.get();
			projectUpdate.setBuildingName(entity.getBuildingName());
			projectUpdate.setBuildingDescription(entity.getBuildingDescription());
			grsRepository.save(projectUpdate);
			return projectUpdate;
			
		}else
		{
			throw new GrsException("not found");
		}
	}

	@Override
	public List<BuildingProjectModelEntity> getAllProject() {
	
		return (List<BuildingProjectModelEntity>) this.grsRepository.findAll();
	}

	@Override
	public BuildingProjectModelEntity getProjectById(long projectId) {
	
		Optional <BuildingProjectModelEntity> project=this.grsRepository.findById(projectId);
		if(project.isPresent()) {
		
			return project.get();
			
		}else
		{
			throw new GrsException("project not exist");
		}
	}

}
