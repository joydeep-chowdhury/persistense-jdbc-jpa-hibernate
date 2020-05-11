package com.joydeep.jpa.hibernate.jpahibernateindetail;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.JpaHibernateInDetailApplication;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseSpringDataRepo;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class SoftDeleteTest {
	@Autowired
	private CourseSpringDataRepo csdrepo;
	@Autowired
	private StudentDataRepository sdrepo;
	private Logger logger = LoggerFactory.getLogger(SoftDeleteTest.class);

	@Test
	public void soft_delete() {
		sdrepo.deleteById(100094L);
		assertNull(sdrepo.findById(100094L).get());
	}
}
