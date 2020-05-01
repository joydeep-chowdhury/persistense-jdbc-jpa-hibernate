package com.joydeep.jpa.hibernate.jpahibernateindetail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joydeep.jpa.hibernate.jpahibernateindetail.model.Course;
import com.joydeep.jpa.hibernate.jpahibernateindetail.repository.CourseRepository;

@SpringBootApplication
public class JpaHibernateInDetailApplication implements CommandLineRunner{

	private CourseRepository courseRepo;
	 private Logger logger=LoggerFactory.getLogger(JpaHibernateInDetailApplication.class);
	public JpaHibernateInDetailApplication(CourseRepository courseRepo) {
		this.courseRepo = courseRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDetailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		logger.info("COURSE WITH COURSE ID 10005 IS -> {}",courseRepo.findById(10005));
//		logger.info("Deleting id 10005");
//		courseRepo.deleteById(10004);
//		logger.info("Inserting -> {}",courseRepo.save(new Course("Design patterns in java")));
//		Course course=courseRepo.findById(1);
//		course.setName("Design patterns in java and Software architecture principles");
//		courseRepo.save(course);
		courseRepo.playWithEntityManager();
		
		
	}

}
