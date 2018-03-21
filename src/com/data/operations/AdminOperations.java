package com.data.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.data.hibernate.Job;
import com.data.hibernate.ParentTutor;
import com.data.hibernate.StudentTutor;
import com.data.queries.JobQueries;
import com.data.queries.ParentQueries;
import com.data.queries.StudentQueries;

public class AdminOperations {
	
	public static List<Job> getAllJobs(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		List<Job> jobs = ss.getNamedQuery(JobQueries.FETCH_All_JOBS).list();
	   return jobs;	
	}
	
	public static List<ParentTutor> getAllParents(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		List<ParentTutor> parents = ss.getNamedQuery(ParentQueries.FETCH_ALL_PARENTS).list();
	   return parents;	
	}
	
	public static List<StudentTutor> getAllStudents(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		List<StudentTutor> students = ss.getNamedQuery(StudentQueries.FETCH_ALL_STUDENTS).list();
	   return students;	
	}
	
}
