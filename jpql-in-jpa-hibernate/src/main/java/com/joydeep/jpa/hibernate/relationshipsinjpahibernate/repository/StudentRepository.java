package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Passport;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;

@Repository
@Transactional
public class StudentRepository {
	EntityManager entityManager;

	public StudentRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Student findById(long studentId) {
		return entityManager.find(Student.class, studentId);
	}

	public void deleteById(long studentId) {
		entityManager.remove(findById(studentId));
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("AXBPC9740T");
		entityManager.persist(passport);
		Student student = new Student("Kumar Shailendra");
		student.setPassport(passport);
		entityManager.persist(student);
	}

	public void someDummyOperation() {
		Student student = entityManager.find(Student.class, 100094L);
		Passport passport = student.getPassport();
		passport.setNo("AXBPC9740MU");
		student.setName("Ankit Chandra Bhattacharjee");
	}

	public void addStudentAndCourse() {
		Student student = new Student("Boloram Patoary");
		Course course1 = new Course("JSP");
		Course course2 = new Course("Servlet");
		Student student2 = new Student("Nituraj Patoary");
		Course course3 = new Course("Thymeleaf");
		student.addCourse(course1);
		course1.addStudent(student);
		student.addCourse(course3);
		course3.addStudent(student);
		student2.addCourse(course2);
		course2.addStudent(student2);
		student2.addCourse(course3);
		entityManager.persist(student);
		entityManager.persist(student2);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		course3.addStudent(student2);
	}
}
