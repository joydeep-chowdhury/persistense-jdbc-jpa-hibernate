package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Student;

@RepositoryRestResource(path = "students")
public interface StudentDataRepository extends JpaRepository<Student, Long> {
	public List<Student> findByName(String name);

	public int countByName(String name);

	@Query("Select s from Student s where name like '%Kumar'")
	List<Student> studentsWithKumarInName();

	@Query(value = "Select * from STUDENT_TABLE  where STUDENT_NAME like 'S%'", nativeQuery = true)
	List<Student> studentsNameStartingWithS();
}
