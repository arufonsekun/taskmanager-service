package com.algaworks.taskmanager.taskmanagerDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.algaworks.taskmanager.ApplicationDBConnection;
import com.algaworks.taskmanager.model.Task;

/*
 * DAO (Data Access Object) behavior is defined in this class.
 * */

@Repository(value="basicDAO") 
public class TaskmanagerDAOImpl implements TaskmanagerDAO {

	//private static final long serialVersionUID = 1L;
	
	private Session session;
	
	//@PersistenceContext @Autowired
    //protected EntityManager entityManager;
	//private Session session = null;
	//private static Logger logger = Logger.getLogger(TaskmanagerDAOImpl.class);
	
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

	public Task getTaskByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
