package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Review;

@Repository
@Transactional
public class CourseRepository {
	EntityManager entityManager;
	 private Logger logger=LoggerFactory.getLogger(CourseRepository.class);
	public CourseRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Course findById(long courseId) {
		return entityManager.find(Course.class, courseId);
	}

	public void deleteById(long courseId) {
		entityManager.remove(findById(courseId));
	}

	public Course save(Course course) {
		if (course.getId() == null) {
			entityManager.persist(course);
			return course;
		} else {
			return entityManager.merge(course);
		}
	}

	public void playWithEntityManager() {
//	  Course course=new Course("Python in data science");
//	  entityManager.persist(course);
//	  entityManager.flush();

//	  entityManager.clear();
//	 
//	  entityManager.flush();
//	  Course course2=new Course("R in data science");
//	  entityManager.persist(course2);
//	  entityManager.flush();
//	  entityManager.detach(course2);
//	  course.setName("Python in data science updated");
//	  course2.setName("R in data science updated");
//	  entityManager.refresh(course);
//	  entityManager.flush();
		Course course = new Course("Introduction to Angular");
		entityManager.persist(course);
		Course course2 = findById(10003);
		course2.setName("SPRING BOOT ADVANCED");

	}

	public void addReviewsForCourse() {
         Course course=entityManager.find(Course.class,10006L);
         logger.info("Course 10006L -> {}",course);
         logger.info("Course 10006L reviews -> {}",course.getReviews());
         Review newReview1=new Review("5","Awesomeness to the power infinity");
         Review newReview2=new Review("4","Greatness unbeatable");
         course.addReviews(newReview1);
         newReview1.setCourse(course);
         course.addReviews(newReview2);
         newReview2.setCourse(course);
         entityManager.persist(newReview1);
         entityManager.persist(newReview2);
	}
	
	
	public void addReviewsForCourseId(Long courseId,List<Review> reviews) {
        Course course=entityManager.find(Course.class,courseId);
        logger.info("Course "+courseId+" -> {}",course);
        logger.info("Course "+courseId+" reviews -> {}",course.getReviews());
        for(Review review:reviews)
        {
        	course.addReviews(review);
        	review.setCourse(course);
        	entityManager.persist(review);
        }
	}

}
