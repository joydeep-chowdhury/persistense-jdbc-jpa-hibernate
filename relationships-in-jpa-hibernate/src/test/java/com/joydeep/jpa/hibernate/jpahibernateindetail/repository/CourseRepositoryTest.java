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
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Review;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseRepository;

import jdk.internal.org.jline.utils.Log;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpaHibernateInDetailApplication.class)
class CourseRepositoryTest {
	 private Logger logger=LoggerFactory.getLogger(CourseRepositoryTest.class);
     @Autowired
	 private CourseRepository courseRepo;
     @Autowired
     private EntityManager em;
//	@Test
//	public void findByIdTestCase() 
//	    {
//		Course course=courseRepo.findById(10005);
//		assertEquals("SPRING SECURITY", course.getName());
//	    }
	
//	@Test
//	@DirtiesContext
//	public void deleteByIdBasic()
//	{
//		courseRepo.deleteById(10001);
//		assertNull(courseRepo.findById(10001));
//	}

	
//	@Test
//	@DirtiesContext
//	public void saveTest()
//	{
//		Course course=courseRepo.findById(1);
//		assertEquals("Design patterns in java and Software architecture principles", course.getName());
//		course.setName("Design patterns in java and Software architecture principles and engineering design");
//		courseRepo.save(course);
//		assertEquals("Design patterns in java and Software architecture principles and engineering design", courseRepo.findById(1).getName());
//	}
//	
	
	@Test
	public void playWithEM()
	{
		
		//courseRepo.playWithEntityManager();
		courseRepo.save(new Course("Angular JS"));
	}
	@Test
	@Transactional
    public void retrieveReviewsForCourse()
    {
    	Course course=courseRepo.findById(10003L);
    	logger.info("Course with course id 10003L -> {}",course.getReviews());
    }
	
	@Test
	@Transactional
    public void retrieveCourseFromReviews()
    {
    	Review review=em.find(Review.class, 60004L);
    	logger.info("Review  with review id 60004L -> {}",review);
    	logger.info("Course  with review id 60004L -> {}",review.getCourse());
    }
	
	
}
