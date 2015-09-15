package br.unisinos.aso.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		
		Exam exam = new Exam();
		exam.setName("Raio X");

		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(exam);
		tx.commit();
		session.close();
		factory.close();
	}

}
