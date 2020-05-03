package com.joydeep.jpa.hibernate.relationshipsinjpahibernate;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Review;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseRepository;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateInDetailApplication implements CommandLineRunner {

	private StudentRepository studentRepo;
	private CourseRepository courseRepo;
	private Logger logger = LoggerFactory.getLogger(JpaHibernateInDetailApplication.class);

	public JpaHibernateInDetailApplication(StudentRepository studentRepo, CourseRepository courseRepo) {
		this.studentRepo = studentRepo;
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
		// courseRepo.playWithEntityManager();
		// studentRepo.saveStudentWithPassport();
		courseRepo.addReviewsForCourseId(10005L, Arrays.asList(new Review[] { new Review("4", "Superb"),
				new Review("5", "Very Very Impressive"), new Review("4", "Preety much good") }));

		studentRepo.addStudentAndCourse();

	}

}
