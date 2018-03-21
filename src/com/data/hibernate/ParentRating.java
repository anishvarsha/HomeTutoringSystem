package com.data.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name="child_ratings")
public class ParentRating {
	
	@Id
	@Column(name="parent_id")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ParentTutor")
	private int parentId;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="begin_rating")
	private int intitalRatings;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getIntitalRatings() {
		return intitalRatings;
	}

	public void setIntitalRatings(int intitalRatings) {
		this.intitalRatings = intitalRatings;
	}
	
}
