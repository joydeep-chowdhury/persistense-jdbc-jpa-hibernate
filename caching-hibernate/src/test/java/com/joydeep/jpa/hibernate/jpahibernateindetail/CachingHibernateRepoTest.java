package com.joydeep.jpa.hibernate.jpahibernateindetail;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseSpringDataRepo;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class CachingHibernateRepoTest {
	@Autowired
	private CourseSpringDataRepo csdrepo;
	@Autowired
	private StudentDataRepository sdrepo;
	private Logger logger = LoggerFactory.getLogger(CachingHibernateRepoTest.class);

	@Test
	@Transactional
	public void primary_cache() {
		Student student = sdrepo.findById(100096L).get();
		logger.info("Student details  -> {}", student);
		Student student2 = sdrepo.findById(100096L).get();
		logger.info("Student details again -> {}", student2);
	}
}
