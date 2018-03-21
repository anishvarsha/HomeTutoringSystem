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
import com.data.queries.ParentQueries;

public class JobOperations {

	/**
	 * returns a list of all the jobs posted by a parent
	 * @param parentId
	 * @return
	 */
	/*public static List<Job> getJobByParentId(int parentId) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<Job> jobs = ss.getNamedQuery(JobQueries.FETCH_JOBS_BY_PARENTID).setInteger("parent_id", parentId).list();
			return jobs;
		} finally {
			ss.close();
			sf.close();
		}
	}*/

	/**
	 * returns a list of jobs that have been offered to a student
	 * @param studentId
	 * @return
	 *//*
	public static List<Job> getJobByStudentId(int studentId) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			List<Job> jobs = ss.getNamedQuery(JobQueries.FETCH_JOBS_BY_SUBJECTID).setInteger("student_id", studentId).list();
			return jobs;
		} finally {
			ss.close();
			sf.close();
		}
	}*/

	/**
	 * return a job by the jobId
	 * @param jobId
	 * @return
	 */
	public static Job getJobByJobId(int jobId) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.get(Job.class, jobId);
		} finally {
			ss.close();
			sf.close();
		}
	}
	
	public static void addJob(String jobDescription, String payRate, String payType,
			String jobTime, int subjectId, Boolean jobStatus, int parentId) {
		
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		Job job = new Job();
		Subject subject = SubjectOperations.getSubjectBySubjectId(subjectId);
		ParentTutor parent = ParentOperations.findParentById(parentId);
		job.setSubject(subject);
		job.setJobDescription(jobDescription);
		job.setJobStatus(jobStatus);
		job.setJobTime(jobTime);
		job.setPayRate(payRate);
		job.setPayType(payType);
		job.setParent(parent);
	
		Transaction TR = ss.beginTransaction();
		ss.save(job);
		System.out.println("Object saved successfully");
		TR.commit();
		ss.close();
		sf.close();
	}
	
	public static void main(String args[]){
	JobOperations.addJob("Teacher needed for maths", "12", "1", "Wed-Fri", 1, true, 2);
		System.out.println("Job is created");
	}

	public static List<Job> getAllJobs(){
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml").addAnnotatedClass(Job.class);
		SessionFactory sf = con.buildSessionFactory();
		Session ss = sf.openSession();
		try {
			return ss.getNamedQuery(JobQueries.FETCH_All_JOBS).list();
		} finally {
			ss.close();
			sf.close();
		}
	}
}
