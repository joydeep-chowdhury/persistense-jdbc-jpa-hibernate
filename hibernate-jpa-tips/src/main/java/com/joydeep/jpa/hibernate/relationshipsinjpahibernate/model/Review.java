package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEW_TABLE")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REVIEW_ID")
	private long id;

	@Enumerated
	@Column(name = "REVIEW_RATING")
	private ReviewRating rating;
	@Column(name = "REVIEW_DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	public Review() {
		super();
	}

	public Review(ReviewRating rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

}
