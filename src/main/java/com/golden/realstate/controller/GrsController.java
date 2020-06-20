package com.golden.realstate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.golden.realstate.model.BuildingProjectModelEntity;
import com.golden.realstate.model.EmployeeModelEntity;
import com.golden.realstate.model.GrsTaskActivityModelEntity;
import com.golden.realstate.services.GrsProjectService;
import com.golden.realstate.services.GrsTaskActivityService;
import com.golden.realstate.services.GrsTaskAssignService;

@RestController
@RequestMapping("/grs/apis/v1/")
public class GrsController {
    @Autowired
    GrsTaskActivityService grsTaskActivityService;
    
    @Autowired
    GrsTaskAssignService grsTaskAssignService;
    
    @Autowired
    GrsProjectService grsProjectService;
    
	
    //Tasks Apis
    
    @CrossOrigin(origins = "*")
	@PostMapping("/tasks")
	public ResponseEntity<GrsTaskActivityModelEntity> createTask(@Valid @RequestBody GrsTaskActivityModelEntity task) {
		 return ResponseEntity.ok().body(this.grsTaskActivityService.createTask(task));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tasks")
	public ResponseEntity<List<GrsTaskActivityModelEntity>> getTasks() 
	{
		 return ResponseEntity.ok().body(grsTaskActivityService.getAllTask());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tasks/project/{projectId}")
	public ResponseEntity<List<GrsTaskActivityModelEntity>> getAllTaskByProject(@PathVariable(value="projectId") String projectId) 
	{
		 return ResponseEntity.ok().body(grsTaskActivityService.getAllTaskByProjectId(projectId));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tasks/employee/{empId}")
	public ResponseEntity<List<GrsTaskActivityModelEntity>> getAllTaskByEmployee(@PathVariable(value="empId") String empId) 
	{
		 return ResponseEntity.ok().body(grsTaskActivityService.getAllTaskByEmpId(empId));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity getTask(@PathVariable(value="taskId") Long taskId) 
	{
		 return ResponseEntity.ok().body(this.grsTaskActivityService.getTaskById(taskId));
		
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<GrsTaskActivityModelEntity> updateTask(@PathVariable(value="taskId") Long taskId, @RequestBody GrsTaskActivityModelEntity task) {
		task.setTaskId(taskId);
		 return ResponseEntity.ok().body(this.grsTaskActivityService.updateTask(task));
	}
	
	
	
//	Employee API
	
	@CrossOrigin(origins = "*")
	@PostMapping("/employees/new")
	public ResponseEntity<EmployeeModelEntity> createTask(@Valid @RequestBody EmployeeModelEntity employee) {
		 return ResponseEntity.ok().body(this.grsTaskAssignService.createEmployee(employee));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeModelEntity>> getEmployees() 
	{
		 return ResponseEntity.ok().body(grsTaskAssignService.getAllEmployee());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/employees/{empId}")
	public ResponseEntity getEmployee(@PathVariable(value="empId") Long empId) 
	{
		 return ResponseEntity.ok().body(this.grsTaskAssignService.getEmployeeById(empId));
		
	}
	
	
	@CrossOrigin(origins = "*")
	@PutMapping("/employees/{empId}")
	public ResponseEntity<EmployeeModelEntity> updateEmployee(@PathVariable(value="empId") Long empId, @RequestBody EmployeeModelEntity employee) {
		employee.setEmpId(empId);
		 return ResponseEntity.ok().body(this.grsTaskAssignService.updateEmployee(employee));
	}
	
	
	
//	Project API
	@CrossOrigin(origins = "*")
	@PostMapping("/projects")
	public ResponseEntity<BuildingProjectModelEntity> createProject(@Valid @RequestBody BuildingProjectModelEntity project) {
		 return ResponseEntity.ok().body(this.grsProjectService.createProject(project));
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/projects")
	public ResponseEntity<List<BuildingProjectModelEntity>> getProjects() 
	{
		 return ResponseEntity.ok().body(grsProjectService.getAllProject());
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/projects/{projectId}")
	public ResponseEntity getProject(@PathVariable(value="projectId") Long projectId) 
	{
		 return ResponseEntity.ok().body(this.grsProjectService.getProjectById(projectId));
		
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/projects/{projectId}")
	public ResponseEntity<BuildingProjectModelEntity> updateProject(@PathVariable(value="projectId") Long projectId, @RequestBody BuildingProjectModelEntity project) {
		project.setProjectId(projectId);
		 return ResponseEntity.ok().body(this.grsProjectService.updateProject(project));
	}
	
	
	
	
	

}
