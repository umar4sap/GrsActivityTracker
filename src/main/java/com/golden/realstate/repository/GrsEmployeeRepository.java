package com.golden.realstate.repository;

import org.springframework.data.repository.CrudRepository;

import com.golden.realstate.model.EmployeeModelEntity;

public interface GrsEmployeeRepository extends CrudRepository<EmployeeModelEntity,Long>
{

}
