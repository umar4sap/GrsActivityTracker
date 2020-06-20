package com.golden.realstate.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.golden.realstate.exception.GrsException;
import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.repository.GrsRepository;

@Service
@Transactional
public class GrsTaskActivityServiceImpl implements GrsTaskActivityService{

	@Autowired
	private GrsRepository grsRepository;
	@PersistenceContext
	private EntityManager em;


	@Override
	public GrsTaskActivityModelEntity createTask(GrsTaskActivityModelEntity entity) {
		entity.setLastStatusUpdated(new Date());
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
			throw new GrsException("task not found");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<GrsTaskActivityModelEntity> getAllTaskByProjectId(String projectId) {
		
		Query query = em.createNamedQuery("GrsTaskActivityModelEntity.findByProjectId",GrsTaskActivityModelEntity.class);
		query.setParameter("projectId", projectId.toString());
		if(query.getResultList()!=null&& !CollectionUtils.isEmpty(query.getResultList())) {
			return (List<GrsTaskActivityModelEntity>) query.getResultList();
		}else {
			throw new GrsException("tasks not exist");
		}
		
	
	}

	@Override
	public List<GrsTaskActivityModelEntity> getAllTaskByEmpId(String empId) {
		// TODO Auto-generated method stub
		Query query = em.createNamedQuery("GrsTaskActivityModelEntity.findByEmpId",GrsTaskActivityModelEntity.class);
		query.setParameter("empId", empId.toString());
		if(query.getResultList()!=null&& !CollectionUtils.isEmpty(query.getResultList())) {
			return (List<GrsTaskActivityModelEntity>) query.getResultList();
		}else {
			throw new GrsException("tasks not exist");
		}
	}

}
