package com.golden.realstate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModelEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long empId;
	
	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_contact_details")
	private String empContactDetails;

	@Column(name="shift_details")
	private String shiftDetails;
	
	@OneToMany(targetEntity=GrsTaskActivityModelEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="Assigned_task_FK",referencedColumnName="emp_id")
	private List<GrsTaskActivityModelEntity> assignedTasks;

	public String getShiftDetails() {
		return shiftDetails;
	}

	public void setShiftDetails(String shiftDetails) {
		this.shiftDetails = shiftDetails;
	}

	public List<GrsTaskActivityModelEntity> getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(List<GrsTaskActivityModelEntity> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpContactDetails() {
		return empContactDetails;
	}

	public void setEmpContactDetails(String empContactDetails) {
		this.empContactDetails = empContactDetails;
	}



}
