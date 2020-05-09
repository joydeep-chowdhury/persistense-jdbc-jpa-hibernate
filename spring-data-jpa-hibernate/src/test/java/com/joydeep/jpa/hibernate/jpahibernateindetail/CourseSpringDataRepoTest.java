package com.joydeep.jpa.hibernate.jpahibernateindetail;

import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseSpringDataRepo;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class CourseSpringDataRepoTest {
	@Autowired
	private CourseSpringDataRepo csdrepo;
	@Autowired
	private StudentDataRepository sdrepo;
	private Logger logger = LoggerFactory.getLogger(CourseSpringDataRepoTest.class);

	@Test
	public void presenceOfCourse() {
		Optional<Course> optCourse = csdrepo.findById(10024L);
		logger.info("Course 10024L  is present -> {} ", optCourse.isPresent());
		assertFalse(optCourse.isPresent());
	}

	@Test
	public void findById() {
		Optional<Course> optCourse = csdrepo.findById(10004L);
		logger.info("Course 10004L -> {} ", optCourse.get());
	}

	@Test
	public void playWithSpringDataRepo() {
		Optional<Course> optCourse = csdrepo.findById(10004L);
		logger.info("Course 10004L -> {} ", optCourse.get());
		Course course = new Course("Linear Regression");
		csdrepo.save(course);
		Course course2 = new Course("Logistic Regression");
		csdrepo.save(course2);
		logger.info("All courses -> {}", csdrepo.findAll());
		logger.info("Course count -> {}", csdrepo.count());
	}

	@Test
	public void sort() {
		logger.info("Sorted courses-> {}", csdrepo.findAllByOrderByNameAsc());
	}

	@Test
	public void pagination() {
		for (int page_no = 0; page_no < 5; page_no++) {
			PageRequest pagerequest = PageRequest.of(page_no, 2);
			logger.info("$$$$$$$$$Student Page no " + page_no + " -> {} ", sdrepo.findAll(pagerequest).getContent());
		}
	}

	@Test
	public void findByName() {
		logger.info("Find by name Shibo Mukherjee -> {}", sdrepo.findByName("Shibo Mukherjee"));
		logger.info("Count by name Shibo Mukherjee -> {}", sdrepo.countByName("Shibo Mukherjee"));
	}

	@Test
	public void findStudentsByNameWithKumar() {
		logger.info("Name with kumar -> {}", sdrepo.studentsWithKumarInName());
	}

	@Test
	public void findStudentsByNameStartingWithS() {
		logger.info("Name startind with S -> {}", sdrepo.studentsNameStartingWithS());
	}
}
