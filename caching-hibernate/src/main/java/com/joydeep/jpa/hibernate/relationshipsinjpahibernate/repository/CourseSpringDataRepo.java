package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {
	public List<Course> findAllByOrderByNameAsc();
}
