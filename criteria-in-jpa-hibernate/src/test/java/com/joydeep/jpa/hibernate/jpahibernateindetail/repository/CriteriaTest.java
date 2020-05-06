package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class CriteriaTest {
	private Logger logger = LoggerFactory.getLogger(CriteriaTest.class);
	@Autowired
	private EntityManager entityManager;

	@Test
	public void criteria_basic() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> courseList = query.getResultList();
		logger.info("Criteria selection -> {}", courseList);
	}

	@Test
	public void allCoursesWithT() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Predicate likeT = cb.like(courseRoot.get("name"), "%T%");
		cq.where(likeT);
		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> courseList = query.getResultList();
		logger.info("Criteria selection with predicate name having T-> {}", courseList);
	}

	@Test
	public void allCoursesWithoutStudents() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Predicate likeT = cb.isEmpty(courseRoot.get("students"));
		cq.where(likeT);
		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> courseList = query.getResultList();
		logger.info("Criteria selection with predicate students being empty -> {}", courseList);
	}

	@Test
	public void join() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Join<Object, Object> join = courseRoot.join("students");
		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> courseList = query.getResultList();
		logger.info("Criteria selection with join -> {}", courseList);
	}

	@Test
	public void leftjoin() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
		TypedQuery<Course> query = entityManager.createQuery(cq.select(courseRoot));
		List<Course> courseList = query.getResultList();
		logger.info("Criteria selection with join -> {}", courseList);
	}

}
