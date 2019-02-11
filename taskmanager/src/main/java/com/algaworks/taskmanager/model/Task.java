package com.algaworks.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/*
 * Class that model a java abstract type named 'tasks'. This class is mapped into the
 * database. The instances hold the data send by the front-end application*/

@Entity(name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	private String type;
	
	@Column
	private String description;
	
	@Column
	private String title;
	
	@Column
	private String dead_line;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeadLine() {
		return dead_line;
	}
	public void setDeadLine(String deadLine) {
		this.dead_line = deadLine;
	}
	
	
}
