package com.livetocode.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Updating the student object");
			session.beginTransaction();
			
			Student std = session.get(Student.class, 1);
			std.setLastName("T");
			session.getTransaction().commit();
			
			//New	
			session = factory.getCurrentSession();
			System.out.println("Updating the student object");
			session.beginTransaction();
			session.createQuery("update Student set email='karthik@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			
			System.out.println("Done");
		} finally {
			factory.close();
		}
	}

}
