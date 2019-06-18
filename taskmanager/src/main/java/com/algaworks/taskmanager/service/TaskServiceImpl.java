package com.algaworks.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.taskmanager.model.Task;
import com.algaworks.taskmanager.taskmanagerDAO.TaskmanagerDAOImpl;
import java.util.List;

/*This class provides the access to DAO methods. TaksService is instantiated just
 * on class controllers */

@Service
public class TaskServiceImpl implements TaskInterface {

	@Autowired
	private TaskmanagerDAOImpl taskDAO;

	@Override
	public void saveTaskObj(Task task) {
		taskDAO.saveTaskObj(task);
	}

	public Task getTask(String id) {
		return taskDAO.getTaskById(id);
	}

	public List<Task> getTasks() {
		return taskDAO.getTasks();
	}


}
