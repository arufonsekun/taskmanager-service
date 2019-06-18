package com.algaworks.taskmanager.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.algaworks.taskmanager.model.Task;
import com.algaworks.taskmanager.service.TaskServiceImpl;
import java.util.List;

/*
 * Class that handles the HTTP requisitions*/

@RestController
public class TaskmanagerController {

	@Autowired
	private TaskServiceImpl taskService;

	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createTask(@RequestBody Task task) {
		Task newTask = new Task();
		BeanUtils.copyProperties(task, newTask);
		taskService.saveTaskObj(newTask);
		return "200 OK";

	}

	@GetMapping(value = "/task/{id}")
	public Task getTask(@PathVariable("id") String id) {
		Task task = taskService.getTask(id);
		return task;
	}

	@CrossOrigin
	@GetMapping(value="/tasks")
	public List<Task> getTasks() {
		List<Task> tasks = taskService.getTasks();
		return tasks;
	}

}
