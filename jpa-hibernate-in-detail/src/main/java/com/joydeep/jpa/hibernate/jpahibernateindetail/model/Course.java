package com.joydeep.jpa.hibernate.jpahibernateindetail.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="COURSE_TABLE")
//@NamedQuery(name="query_get_all_courses",query="select c from Course c")
@NamedQueries(value= {@NamedQuery(name="query_get_all_courses",query="select c from Course c"),
@NamedQuery(name="query_get_courses_having_T",query="Select c from Course c where name like '%T%'")})
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="COURSE_ID")
	private Long id;
    @Column(name="COURSE_NAME",nullable=false)
    private String name;
    @UpdateTimestamp
    @Column(name="LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    @Column(name="CREATED_DATE")
    private LocalDateTime createdDate;
    
    public Course() {}
	public Course(String name) {
		
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
    
}
