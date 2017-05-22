package Mysql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class Teste {
	public static void main ( String [] args ) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
	EntityManager manager = factory.createEntityManager();	
	addObject(manager);
	close(factory,manager);
	}
	
	public static void addObject(EntityManager manager){
		Banco info = new Banco();
		info.setNome(JOptionPane.showInputDialog("Qual é o seu nome? "));
		info.setEmail(JOptionPane.showInputDialog("Qual é o seu email? "));
		manager.getTransaction().begin();
		manager.persist(info);
		manager.getTransaction().commit();
	}
	
	public static void close(EntityManagerFactory factory, EntityManager manager){
		manager.close();
		factory.close();
	}
	
	public static void getInfo(){
		
	}
}
