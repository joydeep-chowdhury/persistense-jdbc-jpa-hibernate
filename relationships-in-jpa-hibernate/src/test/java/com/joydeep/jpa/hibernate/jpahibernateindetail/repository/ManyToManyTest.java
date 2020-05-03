package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class ManyToManyTest {
	private Logger logger = LoggerFactory.getLogger(ManyToManyTest.class);
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 100092L);
		logger.info("Student 100092L -> {}", student);
		logger.info("Courses for student 100092L -> {}", student.getCourses());
	}

	@Test
	@Transactional
	public void retrieveCoursesAndStudent() {
		Course course = em.find(Course.class, 10003L);
		logger.info("Course 10003L -> {}", course);
		logger.info("Course 10003L student -> {}", course.getStudents());
	}

}
