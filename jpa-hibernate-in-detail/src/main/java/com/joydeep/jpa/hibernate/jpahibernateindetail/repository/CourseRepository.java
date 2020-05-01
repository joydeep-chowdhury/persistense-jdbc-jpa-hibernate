package com.joydeep.jpa.hibernate.jpahibernateindetail.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.joydeep.jpa.hibernate.jpahibernateindetail.model.Course;

@Repository
@Transactional
public class CourseRepository {
  EntityManager entityManager;
  public CourseRepository(EntityManager entityManager)
  {
	  this.entityManager=entityManager;
  }
  
  public Course findById(long courseId)
  {
	  return entityManager.find(Course.class, courseId);
  }
  
  public void deleteById(long courseId)
  {
	  entityManager.remove(findById(courseId));
  }
  
  public Course save(Course course)
  {
	  if(course.getId()==null)
	  {
		entityManager.persist(course);
		return course;
	  }
	  else
	  {
		  return entityManager.merge(course);
	  }
  }
  
  public void playWithEntityManager()
  {
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
	  Course course=new Course("Introduction to Angular");
	  entityManager.persist(course);
	  Course course2=findById(10003);
	  course2.setName("SPRING BOOT ADVANCED");
	  
	  
	  
  }
  
  
}
