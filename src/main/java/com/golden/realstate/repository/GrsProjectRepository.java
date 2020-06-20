package com.golden.realstate.repository;

import org.springframework.data.repository.CrudRepository;

import com.golden.realstate.model.BuildingProjectModelEntity;

public interface GrsProjectRepository extends CrudRepository<BuildingProjectModelEntity,Long>
{

}
