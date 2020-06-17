package com.golden.realstate.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golden.realstate.dao.GrsDao;
import com.golden.realstate.model.GrsTaskActivityModel;
import com.golden.realstate.repository.GrsRepository;

@RestController
@RequestMapping("/test")
public class GrsController {
    @Autowired
	GrsDao taskdao;
    
	
	@PostMapping("/tasks")
	public GrsTaskActivityModel createTask(@Valid @RequestBody GrsTaskActivityModel task) {
		return taskdao.save(task);
	}
	
	@GetMapping("/gettasks")
	public Iterable<GrsTaskActivityModel> getTasks() 
	{
		System.out.println(taskdao.findAll());
		return taskdao.findAll();
	}
	
	@GetMapping("/gettask/{taskId}")
	public ResponseEntity getTask(@PathVariable(value="taskId") Long taskId) 
	{
		Optional<GrsTaskActivityModel> task= taskdao.findOne(taskId);
		if(task==null) {
			return ResponseEntity.notFound().build();
		}
		 return ResponseEntity.ok().body(task);
		
	}
	
	
	
	

}
