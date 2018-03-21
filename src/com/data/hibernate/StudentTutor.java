package com.data.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.data.queries.ParentQueries;
import com.data.queries.StudentQueries;

/**
 * Student tutor contains all the information regarding student tutor
 * @author Unnati
 *
 */
@NamedQueries({
	@NamedQuery(name = StudentQueries.FETCH_ALL_STUDENTS, query = StudentQueries.FETCH_ALL_STUDENTS_QUERY), 
	@NamedQuery(name = StudentQueries.FETCH_STUDENT_BY_FIRSTNAME, query = StudentQueries.FETCH_STUDENT_BY_FIRSTNAME_QUERY),
	@NamedQuery(name = StudentQueries.FETCH_STUDENT_BY_LASTNAME, query = StudentQueries.FETCH_STUDENT_BY_LASTNAME_QUERY)})

@Entity
@Table(name ="student_tutor")
public class StudentTutor {
	
	@Id
	@Column(name="netid", nullable =false)
	private int netId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="given_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private long phoneno;
	
	public int getNetId() {
		return netId;
	}

	public void setNetId(int netId) {
		this.netId = netId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column(name="resume")
	private String resume;
	

}
