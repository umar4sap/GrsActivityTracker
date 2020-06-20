package com.golden.realstate.services;

import java.util.List;

import com.golden.realstate.model.EmployeeModelEntity;

public interface GrsTaskAssignService {

	EmployeeModelEntity createEmployee(EmployeeModelEntity entity);
	EmployeeModelEntity  updateEmployee(EmployeeModelEntity entity);
	List<EmployeeModelEntity>  getAllEmployee();
	EmployeeModelEntity getEmployeeById(long taskId);
	
	
	
}
