package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class JoinTest {
	private Logger logger = LoggerFactory.getLogger(JoinTest.class);
	@Autowired
	private EntityManager entityManager;

	@Test
	public void join() {
		Query query = entityManager.createQuery("Select c,s from Course c join c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result list size-> {}", resultList.size());
		for (Object[] object : resultList) {
			logger.info("Course-> {}", object[0]);
			logger.info("Student-> {}", object[1]);
		}
	}

	@Test
	public void leftjoin() {
		Query query = entityManager.createQuery("Select c,s from Course c left join c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result list size-> {}", resultList.size());
		for (Object[] object : resultList) {
			logger.info("Course-> {}", object[0]);
			logger.info("Student-> {}", object[1]);
		}
	}

	@Test
	public void crossjoin() {
		Query query = entityManager.createQuery("Select c,s from Course c,Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Result list size-> {}", resultList.size());
		for (Object[] object : resultList) {
			logger.info("Course-> {}", object[0]);
			logger.info("Student-> {}", object[1]);
		}
	}
}
