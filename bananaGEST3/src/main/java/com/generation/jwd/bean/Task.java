package com.generation.jwd.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="date_start")
	private String date_start;
	
	@Column(name="state")
	private String state;
	
	@Column(name="hours")
	private int hours;
	
	@Column(name="id_user")
	private int id_user;
	
	@Column(name="id_project")
	private int id_project;
	
	public Task() {};
	
	public Task(int id, String name, String description, String date_start,String state, int hours, 
				 int id_user,int id_project) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_start = date_start;
		this.state = state;
		this.hours = hours;
		this.id_user = id_user;
		this.id_project = id_project;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_start() {
		return date_start;
	}

	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_project) {
		this.id_project = id_project;
	}
	public int getId_project() {
		return id_project;
	}

	public void setId_project(int id_project) {
		this.id_project = id_project;
	}
}

