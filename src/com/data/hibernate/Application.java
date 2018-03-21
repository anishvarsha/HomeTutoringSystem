package com.data.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * Author: Shivika Prasanna
 * Date: Sept 22, 2017
 * Course: CS6359.001
 * Purpose: Entities that map to the database for 'Student Tutors can apply for jobs'
 */

public class Application {

	//Job ID is the Primary Key
	@Id
	@Column(name="job_id", nullable =false)
	private Job jobId;

	@Id
	@Column(name="student_id", nullable =false)
	private StudentTutor netId;
	
	@Column(name="apply_status")
	private boolean applyStatus;
	
	@Column(name="accepted")
	private boolean accepted;

	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Job")
	public Job getJobId() {
		return jobId;
	}

	public void setJobId(Job jobId) {
		this.jobId = jobId;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StudentTutor")
	public StudentTutor getNetId() {
		return netId;
	}

	public void setNetId(StudentTutor netId) {
		this.netId = netId;
	}

	public boolean isApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(boolean applyStatus) {
		this.applyStatus = applyStatus;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
}
