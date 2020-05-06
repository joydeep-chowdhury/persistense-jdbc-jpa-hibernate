package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(JPQLTest.class);
	@Autowired
	private EntityManager entityManager;

	@Test
	public void jpql_where_courses_without_student() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.students is empty",
				Course.class);
		List<Course> courseList = query.getResultList();
		logger.info("select c from Course c where c.students is empty -> {}", courseList);

	}

	@Test
	public void jpql_where_courses_without_atleast_two_students() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c where size(c.students) >=2",
				Course.class);
		List<Course> courseList = query.getResultList();
		logger.info("select c from Course c where size(c.students) >=2 -> {}", courseList);

	}

	@Test
	public void jpql_where_courses_order_by_students() {
		TypedQuery<Course> query = entityManager.createQuery("select c from Course c order by size(c.students) desc",
				Course.class);
		List<Course> courseList = query.getResultList();
		logger.info("select c from Course c order by size(c.students) -> {}", courseList);

	}

	@Test
	public void jpql_students_with_passport_ending_with_M() {
		TypedQuery<Student> query = entityManager.createQuery("select s from Student s where s.passport.no like '%M'",
				Student.class);
		List<Student> studentList = query.getResultList();
		logger.info("select s from Student s where s.passport.no like '%M' -> {}", studentList);

	}
}
