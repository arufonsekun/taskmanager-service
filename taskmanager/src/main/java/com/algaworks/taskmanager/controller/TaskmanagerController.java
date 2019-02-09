package com.algaworks.taskmanager.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.taskmanager.model.Task;
import com.algaworks.taskmanager.service.TaskServiceImpl;

/*
 * Class that handles the HTTP requisitions*/

@RestController
public class TaskmanagerController {
	
	@Autowired
	private TaskServiceImpl taskService;
	
	/*@RequestMapping(value="/sendData")
	public String sendData() {
		Tasks task = new Tasks();
		task.setId(1);
		task.setTitle("CURUI");
		task.setType("Danger");
		task.setDescription("setar essa merda de uma vez");
		task.setDeadLine("25/02/2019");
		
		taskService.saveTaskObj(task);
		
		return "I supposed the data it's been saved";
	}*/
	
	@PostMapping(value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createTask(/*@PathVariable("id") String id, */ @RequestBody Task task) {
		Task newTask = new Task();
		BeanUtils.copyProperties(task, newTask);
		/*newTask.setId(task.getId());
		newTask.setTitle(task.getTitle());
		newTask.setType(task.getType());
		newTask.setDescription(task.getDescription());
		newTask.setDeadLine(task.getDeadLine());*/
		
		taskService.saveTaskObj(newTask);
		return "200 OK";
		
	}
	
}
