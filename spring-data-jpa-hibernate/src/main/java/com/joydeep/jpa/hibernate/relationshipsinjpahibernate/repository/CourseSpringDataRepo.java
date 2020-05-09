package com.joydeep.jpa.hibernate.relationshipsinjpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joydeep.jpa.hibernate.relationshipsinjpahibernate.model.Course;

public interface CourseSpringDataRepo extends JpaRepository<Course, Long> {
	public List<Course> findAllByOrderByNameAsc();
}
