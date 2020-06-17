package com.golden.realstate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taskActivities")
public class GrsTaskActivityModel{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long taskId;
	
@Column(name="task_name")
private String taskName;

@Column(name="task_Description")
private String tasDescription;

@Column(name="created_at")
private Date createdAt;


@Column(name="last_Status_Updated")
private Date lastStatusUpdated;


@Column(name="status")
private String status;


@Column(name="assign_to")
private String assignTo;

@Column(name="resport_to")
private String reportedTo;


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

public String getTasDescription() {
	return tasDescription;
}

public void setTasDescription(String tasDescription) {
	this.tasDescription = tasDescription;
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

public String getAssignTo() {
	return assignTo;
}

public void setAssignTo(String assignTo) {
	this.assignTo = assignTo;
}

public String getReportedTo() {
	return reportedTo;
}

public void setReportedTo(String reportedTo) {
	this.reportedTo = reportedTo;
}







}
