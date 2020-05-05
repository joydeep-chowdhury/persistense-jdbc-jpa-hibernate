package com.joydeep.jpa.hibernate.relationshipsinjpahibernate;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.FullTimeEmployee;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.PartTimeEmployee;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository.EmployeeRepository;

@SpringBootApplication
public class JpaHibernateInDetailApplication implements CommandLineRunner {

	private EmployeeRepository employeeRepo;
	private Logger logger = LoggerFactory.getLogger(JpaHibernateInDetailApplication.class);

	public JpaHibernateInDetailApplication(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDetailApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeRepo.insert(new PartTimeEmployee("Soumya Ranjan Barik", new BigDecimal("312.5")));
		employeeRepo.insert(new FullTimeEmployee("Joydeep Chowdhury", new BigDecimal("49787.5")));
		logger.info("Full Time Employee list -> {}", employeeRepo.retrieveAllFullTimeEmployees());
		logger.info("Part Time Employee list -> {}", employeeRepo.retrieveAllPartTimeEmployees());
	}

}
