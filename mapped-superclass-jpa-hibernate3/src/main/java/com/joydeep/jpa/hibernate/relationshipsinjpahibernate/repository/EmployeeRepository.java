package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Employee;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.FullTimeEmployee;
import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	EntityManager entityManager;
	private Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

	public EmployeeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Employee employee) {
		entityManager.persist(employee);
	}

	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}
