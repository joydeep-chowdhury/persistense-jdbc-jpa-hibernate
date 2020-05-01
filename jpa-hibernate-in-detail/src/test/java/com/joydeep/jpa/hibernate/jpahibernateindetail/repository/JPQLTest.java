package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.jpahibernateindetail.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.jpahibernateindetail.model.Course;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateInDetailApplication.class)
class JPQLTest {
	 private Logger logger=LoggerFactory.getLogger(JPQLTest.class);
     @Autowired
	 private EntityManager entityManager;
	
	
	@Test
	public void jpql_basic()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNamedQuery("query_get_all_courses");
		List courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	@Test
	public void jpql_typed()
	{
		TypedQuery<Course> query=entityManager.createNamedQuery("query_get_all_courses",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	
	@Test
	public void jpql_where()
	{
		TypedQuery<Course> query=entityManager.createNamedQuery("query_get_courses_having_T",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	
}
