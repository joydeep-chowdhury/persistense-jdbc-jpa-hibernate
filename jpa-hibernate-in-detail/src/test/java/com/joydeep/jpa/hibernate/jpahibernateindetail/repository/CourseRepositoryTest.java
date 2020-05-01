package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
class CourseRepositoryTest {
	 private Logger logger=LoggerFactory.getLogger(CourseRepositoryTest.class);
     @Autowired
	 private CourseRepository courseRepo;
	@Test
	public void findByIdTestCase() 
	    {
		Course course=courseRepo.findById(10005);
		assertEquals("SPRING SECURITY", course.getName());
	    }
	
	@Test
	@DirtiesContext
	public void deleteByIdBasic()
	{
		courseRepo.deleteById(10001);
		assertNull(courseRepo.findById(10001));
	}

	
	@Test
	@DirtiesContext
	public void saveTest()
	{
		Course course=courseRepo.findById(1);
		assertEquals("Design patterns in java and Software architecture principles", course.getName());
		course.setName("Design patterns in java and Software architecture principles and engineering design");
		courseRepo.save(course);
		assertEquals("Design patterns in java and Software architecture principles and engineering design", courseRepo.findById(1).getName());
	}
	
	
	@Test
	public void playWithEM()
	{
		
		//courseRepo.playWithEntityManager();
		courseRepo.save(new Course("Angular JS"));
	}
	
}
