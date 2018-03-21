package com.data.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.data.queries.JobQueries;
import com.data.queries.SubjectQueries;

@NamedQueries({
	@NamedQuery(name = SubjectQueries.FETCH_ALL_SUBJECTS, query = SubjectQueries.FETCH_ALL_SUBJECTS_QUERY), 
	@NamedQuery(name = SubjectQueries.FETCH_SUBJECT_BY_SUBJECTID, query = SubjectQueries.FETCH_SUBJECT_BY_SUBJECTID_QUERY)})
	
@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@Column(name="subject_id", nullable = false)
	@GeneratedValue
	private int subjectId;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "category")
	private String category;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
