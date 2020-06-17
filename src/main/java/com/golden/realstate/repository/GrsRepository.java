package com.golden.realstate.repository;

import org.springframework.data.repository.CrudRepository;

import com.golden.realstate.model.GrsTaskActivityModel;

public interface GrsRepository extends CrudRepository<GrsTaskActivityModel,Long>
{

}
