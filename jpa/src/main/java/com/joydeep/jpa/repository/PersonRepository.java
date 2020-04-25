package com.joydeep.jpa.repository;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joydeep.jpa.model.Person;


@Repository
@Transactional
public class PersonRepository 
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public Person findById(int id)
	{
	return entityManager.find(Person.class, id);
	}
	
	public List<Person> findAll()
	{
		TypedQuery<Person> namedQuery=entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
	
	public Person insert(Person p)
	{
		return entityManager.merge(p);
	}
	
	
	public Person update(Person p)
	{
		return entityManager.merge(p);
	}
	
	public void deleteById(int id)
	{
	 entityManager.remove(entityManager.find(Person.class, id));
	}
}
