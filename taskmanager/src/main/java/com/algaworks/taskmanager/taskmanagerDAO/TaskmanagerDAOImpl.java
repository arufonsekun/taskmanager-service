package com.algaworks.taskmanager.taskmanagerDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.algaworks.taskmanager.ApplicationDBConnection;
import com.algaworks.taskmanager.model.Task;
import java.util.List;

/*
 * DAO (Data Access Object) behavior is defined in this class.
 * */

@Repository(value="basicDAO")
public class TaskmanagerDAOImpl implements TaskmanagerDAO {

	private Session session;

	@Override
	public void saveTaskObj(Task task) {
		try {
			SessionFactory sessionFactory = ApplicationDBConnection.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(task);
			session.getTransaction().commit();
			session.close();
		}catch(Exception e) {

		}

	}

	@Override
	public Task getTaskById(String id) {
		SessionFactory sessionFactory = ApplicationDBConnection.getSessionFactory();
		session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		Task task = (Task) session.find(Task.class, Long.parseLong(id));
		t.commit();
		session.close();
		return task;
	}

	public List<Task> getTasks() {

		SessionFactory sessionFactory = ApplicationDBConnection.getSessionFactory();
		session = sessionFactory.openSession();
		List<Task> tasks = session.getSession().createCriteria(Task.class).list();

		session.close();
		return tasks;
	}



}
