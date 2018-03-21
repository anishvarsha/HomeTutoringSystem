package com.data.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.data.hibernate.Job;
import com.data.hibernate.ParentTutor;
import com.data.hibernate.Subject;
import com.data.queries.JobQueries;

public class SubjectOperations {
	
	/**
	 * returns a subject for subjectId
	 * @param parentId
	 * @return
	 */
	public static Subject getSubjectBySubjectId(int subjectId) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Subject.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(Subject.class, subjectId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void addSubject(String subjectName, String subjectCategory) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Subject.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Subject subject = new Subject();
		subject.setSubjectName(subjectName);
		subject.setCategory(subjectCategory);
		
		Transaction TR = ss.beginTransaction();
		ss.save(subject);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}

	public static void main(String args[]){
		/*SubjectOperations.addSubject("Discrete Maths","Mathematics" );
		System.out.println("added subject");*/
		
		Subject subject = SubjectOperations.getSubjectBySubjectId(1);
		System.out.println(subject.getSubjectName());
		
	}
}
