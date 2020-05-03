package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Passport;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseRepository;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentRepository;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student = em.find(Student.class, 100094L);
		logger.info("Student 100094-> {}", student);
		logger.info("Student 100094 Passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndStudent() {
	     Passport passport=em.find(Passport.class, 40008L);
	     logger.info("Passport 40008L-> {}",passport);
	     logger.info("Passport 40008L student -> {}",passport.getStudent());
	}

	@Test
	public void someTest() {
		studentRepo.someDummyOperation();
	}

}
