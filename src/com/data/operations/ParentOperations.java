package com.data.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.data.hibernate.ParentTutor;
import com.data.hibernate.StudentTutor;
import com.data.queries.ParentQueries;

public class ParentOperations {
	
	/**
	 * this method returns a parentTutor's details by the parentId
	 * @param parentId
	 * @return
	 */
	public static ParentTutor findParentById(int parentId){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(ParentTutor.class, parentId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	/**
	 * this method returns a parentTutor's details by the parent's firstName
	 * @param parentId
	 * @return
	 */
	public static List<ParentTutor> findParentByFirstName(String firstName) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<ParentTutor> parents = ss.getNamedQuery(ParentQueries.FETCH_PARENT_BY_FIRSTNAME)
					.setString("firstName", firstName).list();
			return parents;
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	/**
	 * this method returns a parentTutor's details by the parent's lastname
	 * @param parentId
	 * @return
	 */
	public static List<ParentTutor> findParentByLastName(String lastName) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<ParentTutor> parents = ss.getNamedQuery(ParentQueries.FETCH_PARENT_BY_LASTNAME)
					.setString("lastName", lastName).list();
			return parents;
		} finally {
			ss.close();
			sf.close();
		}
	}
	/**
	 * creates a parent 
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneno
	 * @param streetNumber
	 * @param doorNumber
	 * @param zipCode
	 * @param city
	 * @param state
	 */
	/*
	public static void addParent(String password, String firstName, String lastName,
			String email, int phoneno,int streetNumber, int doorNumber, int zipCode, String city, String state) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		ParentTutor parent = new ParentTutor();
		parent.setFirstName(firstName);
		parent.setLastName(lastName);
		parent.setCity(city);
		parent.setDoorNumber(doorNumber);
		parent.setState(state);
		parent.setEmail(email);
		parent.setPassword(password);
		parent.setPhone(phoneno);
		parent.setZipCode(zipCode);
		parent.setStreetNumber(streetNumber);
		
		Transaction TR = ss.beginTransaction();
		ss.save(parent);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}*/
	public static void addParent(String password, String firstName, String lastName,
			String email, int phoneno) {
		
		System.out.println("Here*****************8");
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		ParentTutor parent = new ParentTutor();
		parent.setFirstName(firstName);
		parent.setLastName(lastName);
		//parent.setCity(city);
		//parent.setDoorNumber(doorNumber);
		//parent.setState(state);
		parent.setEmail(email);
		parent.setPassword(password);
		parent.setPhone(phoneno);
		//parent.setZipCode(zipCode);
		//parent.setStreetNumber(streetNumber);
		
		Transaction TR = ss.beginTransaction();
		ss.save(parent);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}
	/**
	 * this method returns all the parents in the db
	 * @param parentId
	 * @return
	 */
	public static List<ParentTutor> findAllParents(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(ParentTutor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.getNamedQuery(ParentQueries.FETCH_ALL_PARENTS).list();
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void main(String args[]){
		/*ParentOperations.addParent("pqrUna", "Norma", "Richadson", "nrich", 123451, 123, 34, 75080, "Richardson", "Tx");
		System.out.println("Parent has been added");
		
		List<ParentTutor> parent = ParentOperations.findAllParents();
		for(int i = 0 ; i<parent.size();i++){
			System.out.println(parent.get(i).getFirstName());
		}*/
	}
}
