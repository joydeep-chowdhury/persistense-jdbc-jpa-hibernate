package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PASSPORT_TABLE")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PASSPORT_ID")
	private long id;
	@Column(name = "PASSPORT_NO",nullable=false)
	private String no;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="passport")
    private Student student;
	public Passport() {
		super();
	}

	public Passport(String no) {
		this.no = no;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", no=" + no + "]";
	}

	

}
