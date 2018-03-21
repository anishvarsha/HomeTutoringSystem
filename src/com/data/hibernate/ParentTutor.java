package com.data.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.data.queries.JobQueries;
import com.data.queries.ParentQueries;

@NamedQueries({
	@NamedQuery(name = ParentQueries.FETCH_PARENT_BY_FIRSTNAME, query = ParentQueries.FETCH_PARENT_BY_FIRSTNAME_QUERY), 
	@NamedQuery(name = ParentQueries.FETCH_PARENT_BY_LASTNAME, query = ParentQueries.FETCH_PARENT_BY_LASTNAME_QUERY),
	@NamedQuery(name = ParentQueries.FETCH_ALL_PARENTS, query = ParentQueries.FETCH_ALL_PARENTS_QUERY),
	/*@NamedQuery(name = ParentQueries.FETCH_PARENT_BY_PARENTID, query = ParentQueries.FETCH_PARENT_BY_PARENTID_QUERY)*/})
@Entity
@Table(name="parent_tutor")
public class ParentTutor {
	
	@Id
	@Column(name = "parent_id" , nullable = false)
	private int parentId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "given_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "street_number")
	private int streetNumber;
	
	@Column(name = "door_number")
	private int doorNumber;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name ="state")
	private String state;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
