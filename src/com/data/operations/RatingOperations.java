package com.data.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.data.hibernate.Application;
import com.data.hibernate.ParentRating;
import com.data.hibernate.StudentRating;

public class RatingOperations {

	public static StudentRating getRatingByStudentId(int studentId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentRating.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(StudentRating.class, studentId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	public static ParentRating getRatingByParentId(int parentId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentRating.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(ParentRating.class, parentId);
		} finally {
			ss.close();
			sf.close();
		}
	}
}
