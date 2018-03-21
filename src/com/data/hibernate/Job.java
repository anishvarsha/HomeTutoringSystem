package com.data.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.data.queries.JobQueries;

@NamedQueries({
	@NamedQuery(name = JobQueries.FETCH_All_JOBS, query = JobQueries.FETCH_All_JOBS_QUERY), 
	@NamedQuery(name = JobQueries.FETCH_JOBS_BY_JOBID, query = JobQueries.FETCH_JOBS_BY_JOBID_QUERY),
	/*@NamedQuery(name = JobQueries.FETCH_JOBS_BY_PARENTID, query = JobQueries.FETCH_JOBS_BY_PARENTID_QUERY)*/
	/*@NamedQuery(name = JobQueries.FETCH_JOBS_BY_SUBJECTID, query = JobQueries.FETCH_JOBS_BY_SUBJECTID_QUERY)*/})

@Entity
@Table(name="create_job")
public class Job {
	
	@Id
	@Column(name="job_id")
	@GeneratedValue
	private int jobId;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="pay_rate")
	private String payRate;
	
	@Column(name="pay_type")
	private String payType;
	
	@Column(name="job_time")
	private String jobTime;
	
	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@Column(name="job_status")
	private Boolean jobStatus;
	
	@OneToOne
	@JoinColumn(name = "parent_id")
	private ParentTutor parent;
	 

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getPayRate() {
		return payRate;
	}

	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public Boolean getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(Boolean jobStatus) {
		this.jobStatus = jobStatus;
	}

	public ParentTutor getParent() {
		return parent;
	}

	public void setParent(ParentTutor parent) {
		this.parent = parent;
	}

}
