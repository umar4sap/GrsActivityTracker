package com.golden.realstate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golden.realstate.model.EmployeeModelEntity;
import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.services.GrsTaskActivityService;
import com.golden.realstate.services.GrsTaskAssignService;

@RestController
@RequestMapping("/grs/apis/v1/")
public class GrsController {
    @Autowired
    GrsTaskActivityService grsTaskActivityService;
    
    @Autowired
    GrsTaskAssignService grsTaskAssignService;
    
	
	@PostMapping("/tasks/newtask")
	public ResponseEntity<GrsTaskActivityModelEntity> createTask(@Valid @RequestBody GrsTaskActivityModelEntity task) {
		 return ResponseEntity.ok().body(this.grsTaskActivityService.createTask(task));
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<List<GrsTaskActivityModelEntity>> getTasks() 
	{
		 return ResponseEntity.ok().body(grsTaskActivityService.getAllTask());
	}
	
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity getTask(@PathVariable(value="taskId") Long taskId) 
	{
		 return ResponseEntity.ok().body(this.grsTaskActivityService.getTaskById(taskId));
		
	}
	
	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<GrsTaskActivityModelEntity> updateTask(@PathVariable(value="taskId") Long taskId, @RequestBody GrsTaskActivityModelEntity task) {
		task.setTaskId(taskId);
		 return ResponseEntity.ok().body(this.grsTaskActivityService.updateTask(task));
	}
	
	
	
	
	
	
	@PostMapping("/employees/new")
	public ResponseEntity<EmployeeModelEntity> createTask(@Valid @RequestBody EmployeeModelEntity employee) {
		 return ResponseEntity.ok().body(this.grsTaskAssignService.createEmployee(employee));
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeModelEntity>> getEmployees() 
	{
		 return ResponseEntity.ok().body(grsTaskAssignService.getAllEmployee());
	}
	
	@GetMapping("/employees/{empId}")
	public ResponseEntity getEmployee(@PathVariable(value="empId") Long empId) 
	{
		 return ResponseEntity.ok().body(this.grsTaskAssignService.getEmployeeById(empId));
		
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<EmployeeModelEntity> updateEmployee(@PathVariable(value="empId") Long empId, @RequestBody EmployeeModelEntity employee) {
		employee.setEmpId(empId);
		 return ResponseEntity.ok().body(this.grsTaskAssignService.updateEmployee(employee));
	}
	
	
	
	
	
	

}
