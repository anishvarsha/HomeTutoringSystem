package com.data.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.data.hibernate.ParentTutor;
import com.data.hibernate.StudentTutor;
import com.data.queries.ParentQueries;
import com.data.queries.StudentQueries;

public class StudentOperations {
	
	/**
	 * this method return a student's detail according to the studentId
	 * @param studentId
	 * @return
	 */
	public static StudentTutor findStudentById(int studentId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(StudentTutor.class, studentId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	/**
	 * this method returns a studentTutor details by the student firstName
	 * @param parentId
	 * @return
	 */
	public static List<StudentTutor> findStudentByFirstName(String firstName) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<StudentTutor> students = ss.getNamedQuery(StudentQueries.FETCH_STUDENT_BY_FIRSTNAME)
					.setString("firstName", firstName).list();
			return students;
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	/**
	 * this method returns a studentTutor details by the student firstName
	 * @param parentId
	 * @return
	 */
	public static List<StudentTutor> findStudentByLastName(String lastName) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<StudentTutor> student =ss.getNamedQuery(StudentQueries.FETCH_STUDENT_BY_LASTNAME)
					.setString("lastName", lastName).list();
			return student;
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void addStudent(int netId, String password, String firstName, String lastName,
			String email, long phoneno, String resume) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(StudentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		StudentTutor provider = new StudentTutor();
		provider.setEmail(email);
		provider.setFirstName(firstName);
		provider.setLastName(lastName);
		provider.setPassword(password);
		provider.setPhoneno(phoneno);
		provider.setResume(resume);
		provider.setNetId(netId);
		
		
		Transaction TR = ss.beginTransaction();
		ss.save(provider);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}



public static void main(String args[]){
	
	//StudentOperations.addStudent( 2021310411, "Jiale", "jiale", "yang", "abcdf@gmail.com", 123445665, "myresumelink");
	//System.out.println("work is done");
	List<StudentTutor> st = StudentOperations.findStudentByFirstName("jiale");
	//System.out.println(st.getFirstName()+ "name of the user");
	if(st.size()!=0){
		System.out.println(st.get(0).getEmail());
	}
}
}
