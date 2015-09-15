package br.unisinos.aso.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
	protected static SessionFactory factory;
	protected Session session;
	protected Transaction transaction;

	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}
	
	protected void openConnection(){
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	protected void commitAndCloseConnection(){
		transaction.commit();
		session.close();
		factory.close();
	}
}