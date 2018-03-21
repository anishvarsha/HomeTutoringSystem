package com.data.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name="student_ratings")
public class StudentRating {
	
	@Id
	@Column(name="student_id")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="StudentTutor")
	private StudentTutor studentId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="begin_rating")
	private int initialRating;

	public StudentTutor getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentTutor studentId) {
		this.studentId = studentId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getInitialRating() {
		return initialRating;
	}

	public void setInitialRating(int initialRating) {
		this.initialRating = initialRating;
	}
	

	
	

}
