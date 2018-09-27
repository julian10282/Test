package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entities.CourseEntity;
import com.udemy.backendninja.model.CourseModel;

public interface CourseService {

	public List<CourseModel> listAllCourses();
	public CourseEntity addCourse(CourseModel course, String logIndet);
	public int removeCourse(int id);
	public CourseEntity updateCourse(CourseEntity course);
	
}
