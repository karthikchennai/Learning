package com.livetocode.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating the student object");
			Student temp = new Student("karthikeyan", "Thanikachalam", "tkarthikchennai@gmail.com");
			Student temp1 = new Student("karthikeyan", "Thanikachalam", "tkarthikchennai@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the student");
			session.save(temp);
			session.save(temp1);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
