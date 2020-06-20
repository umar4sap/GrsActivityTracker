package com.golden.realstate.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="taskActivities")
@NamedQueries({
 
    @NamedQuery(name="GrsTaskActivityModelEntity.findByProjectId",
                query="SELECT t FROM GrsTaskActivityModelEntity t WHERE t.projectId=:projectId"),
    @NamedQuery(name="GrsTaskActivityModelEntity.findByEmpId",
    query="SELECT t FROM GrsTaskActivityModelEntity t WHERE t.assignedTo=:empId"),
})
public class GrsTaskActivityModelEntity{

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long taskId;

@Column(name="project_id")
private String projectId;

@Column(name="task_name")
private String taskName;

@Column(name="task_Description")
private String taskDescription;

@Column(name="created_at")
private Date createdAt;


@Column(name="last_Status_Updated")
private Date lastStatusUpdated;


@Column(name="status")
private String status;


//@OneToOne(targetEntity=EmployeeModelEntity.class,fetch=FetchType.EAGER)
//@JoinColumn(name="Assigned_FK",referencedColumnName="emp_id")

@Column(name="assigned_to")
private String assignedTo;


public Long getTaskId() {
	return taskId;
}

public void setTaskId(Long taskId) {
	this.taskId = taskId;
}

public String getTaskName() {
	return taskName;
}

public void setTaskName(String taskName) {
	this.taskName = taskName;
}

public String getTaskDescription() {
	return taskDescription;
}

public void setTaskDescription(String taskDescription) {
	this.taskDescription = taskDescription;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getLastStatusUpdated() {
	return lastStatusUpdated;
}

public void setLastStatusUpdated(Date lastStatusUpdated) {
	this.lastStatusUpdated = lastStatusUpdated;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getProjectId() {
	return projectId;
}

public void setProjectId(String projectId) {
	this.projectId = projectId;
}

public String getAssignedTo() {
	return assignedTo;
}

public void setAssignedTo(String assignedTo) {
	this.assignedTo = assignedTo;
}






}
