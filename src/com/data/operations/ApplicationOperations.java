package com.data.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.data.hibernate.Application;

public class ApplicationOperations {
	
	public static Application getApplicationByStudentId(int studentId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Application.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(Application.class, studentId);
		} finally {
			ss.close();
			sf.close();
		}
	}

	public static Application getApplicationByJobId(int jobId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Application.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(Application.class, jobId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	

}
