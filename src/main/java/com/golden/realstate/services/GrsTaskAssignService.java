package com.golden.realstate.services;

import java.util.List;

import com.golden.realstate.model.EmployeeModelEntity;
import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.repository.GrsRepository;

public interface GrsTaskAssignService {

	EmployeeModelEntity createEmployee(EmployeeModelEntity entity);
	EmployeeModelEntity  updateEmployee(EmployeeModelEntity entity);
	List<EmployeeModelEntity>  getAllEmployee();
	EmployeeModelEntity getEmployeeById(long taskId);
	
	
	
}
