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
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Address;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.CourseSpringDataRepo;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.StudentDataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateInDetailApplication.class)
class AddressTest {
	@Autowired
	private CourseSpringDataRepo csdrepo;
	@Autowired
	private StudentDataRepository sdrepo;
	private Logger logger = LoggerFactory.getLogger(AddressTest.class);

	@Test
	@Transactional
	public void addAddress() {
		Student s = sdrepo.findById(100092L).get();
		s.setAddress(new Address("CL266 ", "Sector 2", "Kolkata"));
		sdrepo.save(s);
		Student s2 = sdrepo.findById(100092L).get();
		logger.info("100092L address -> {}", s2.getAddress());
	}
}
