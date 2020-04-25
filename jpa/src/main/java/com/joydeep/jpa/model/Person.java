package com.joydeep.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_TABLE")
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PER_ID")
	private int id;
	@Column(name = "PER_NAME")
	private String name;
	@Column(name = "PER_LOC")
	private String location;
	@Column(name = "PER_BIRTHDATE")
	private Date birthDate;

	public Person() {
	}

	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public Person(int id,String name, String location, Date birthDate) {
		super();
		this.id=id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return System.lineSeparator() + "Person [id=" + id + ", name=" + name + ", location=" + location
				+ ", birthDate=" + birthDate + "]";
	}

}
