package com.udemy.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entities.CourseEntity;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<CourseEntity, Serializable> {
	
	public abstract CourseEntity findByPrice(int price);
	
	public abstract CourseEntity findByPriceAndName(int price, String name);
	
	public abstract List<CourseEntity> findByNameOrderByHours(String name);
	
	public abstract CourseEntity findByNameOrPrice(String name, int price);

	public abstract CourseEntity findById(int id);
}
