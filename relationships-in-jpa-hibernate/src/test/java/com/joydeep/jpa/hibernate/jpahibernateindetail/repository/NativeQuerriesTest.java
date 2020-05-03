package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateInDetailApplication.class)
class NativeQuerriesTest {
	 private Logger logger=LoggerFactory.getLogger(NativeQuerriesTest.class);
     @Autowired
	 private EntityManager entityManager;
	
	
	@Test
	public void native_querries_basic()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNativeQuery("SELECT * FROM COURSE_TABLE",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	
	@Test
	public void native_querries_advanced()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNativeQuery("SELECT * FROM COURSE_TABLE where COURSE_NAME LIKE '%SPRING%'",Course.class);
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	
	@Test
	public void native_querries_with_params()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNativeQuery("SELECT * FROM COURSE_TABLE where COURSE_NAME=?",Course.class);
		query.setParameter(1,"SPRING SECURITY");
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	@Test
	public void native_querries_with_named_params()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNativeQuery("SELECT * FROM COURSE_TABLE where COURSE_NAME=:name",Course.class);
		query.setParameter("name","SPRING BOOT");
		List<Course> courseList=query.getResultList();
		logger.info("Select c from Course c -> {}",courseList);
		
	}
	
	@Test
	@Transactional
	public void native_querries_to_update()
	{
		//Query query=entityManager.createQuery("Select c from Course c");
		Query query=entityManager.createNativeQuery("UPDATE COURSE_TABLE SET CREATED_DATE=SYSDATE()");
		int updateFlag=query.executeUpdate();
		logger.info("UPDATE COURSE_TABLE SET CREATED_DATE=SYSDATE()   rows updated -> {} ", updateFlag);
		
	}
}
