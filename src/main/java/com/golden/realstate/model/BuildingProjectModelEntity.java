package com.golden.realstate.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class BuildingProjectModelEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private Long projectId;
	
	@Column(name="building_name")
	private String buildingName;

	@Column(name="building_description")
	private String buildingDescription;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingDescription() {
		return buildingDescription;
	}

	public void setBuildingDescription(String buildingDescription) {
		this.buildingDescription = buildingDescription;
	}

	
	
}
	