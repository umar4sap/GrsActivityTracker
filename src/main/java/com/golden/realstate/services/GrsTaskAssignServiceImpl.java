package com.golden.realstate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.golden.realstate.exception.GrsException;
import com.golden.realstate.model.EmployeeModelEntity;
import com.golden.realstate.repository.GrsEmployeeRepository;
import com.golden.realstate.repository.GrsRepository;

@Service
@Transactional
public class GrsTaskAssignServiceImpl implements GrsTaskAssignService{

	@Autowired
	private GrsEmployeeRepository grsRepository;
	


	@Override
	public EmployeeModelEntity createEmployee(EmployeeModelEntity entity) {
		
		return grsRepository.save(entity);
	}

	@Override
	public EmployeeModelEntity updateEmployee(EmployeeModelEntity entity) {
	
		Optional <EmployeeModelEntity> tasks=this.grsRepository.findById(entity.getEmpId());
		if(tasks.isPresent()) {
			EmployeeModelEntity taskUpdate=tasks.get();
			taskUpdate.setEmpName(entity.getEmpName());
			taskUpdate.setShiftDetails(entity.getShiftDetails());
			grsRepository.save(taskUpdate);
			return taskUpdate;
			
		}else
		{
			throw new GrsException("not found");
		}
	}

	@Override
	public List<EmployeeModelEntity> getAllEmployee() {
	
		return (List<EmployeeModelEntity>) this.grsRepository.findAll();
	}

	@Override
	public EmployeeModelEntity getEmployeeById(long taskId) {
	
		Optional <EmployeeModelEntity> task=this.grsRepository.findById(taskId);
		if(task.isPresent()) {
		
			return task.get();
			
		}else
		{
			throw new GrsException("task not exist");
		}
	}

}
