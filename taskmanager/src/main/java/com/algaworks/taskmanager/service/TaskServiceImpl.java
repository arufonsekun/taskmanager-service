package com.algaworks.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.taskmanager.model.Task;
import com.algaworks.taskmanager.taskmanagerDAO.TaskmanagerDAOImpl;

/*This class provides the access to DAO methods. TaksService is instantiated just 
 * on class controllers */

@Service
public class TaskServiceImpl implements TaskInterface {

	@Autowired
	private TaskmanagerDAOImpl taskDAO;
	
	@Override @Transactional
	public void saveTaskObj(Task task) {
		taskDAO.saveTaskObj(task);
	}
	
	
	
}
