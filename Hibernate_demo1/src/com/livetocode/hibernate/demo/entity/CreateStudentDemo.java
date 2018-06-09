package com.livetocode.hibernate.demo.entity;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating the student object");
			String dateOfBirth="28/06/1995";
			Date dob=DateUtil.parseDate(dateOfBirth);
			Student temp = new Student("karthikeyan", "Thanikachalam", "tkarthikchennai@gmail.com",dob);
			Student temp1 = new Student("karthikeyan", "Thanikachalam", "tkarthikchennai@gmail.com",dob);
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
