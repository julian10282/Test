package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entities.CourseEntity;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	public static final Log	LOG	= LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseRepository")
	private CourseRepository courseRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Finding all courses !!");
		List<CourseEntity> courseEntities = courseRepository.findAll();
		List<CourseModel> courseModels = new ArrayList<>();
		for (CourseEntity courseEntity : courseEntities) {
			courseModels.add(courseConverter.entityToModel(courseEntity));
		}
		return  courseModels;
	}

	@Override
	public CourseEntity addCourse(CourseModel courseModel, String logIdent) {
		LOG.info(new StringBuilder("Saving course: ").append(logIdent).toString());
		return courseRepository.save(courseConverter.modelToEntity(courseModel));
	}

	@Override
	public int removeCourse(int id) {
		courseRepository.deleteById(id);
		return 0;
	}

	@Override
	public CourseEntity updateCourse(CourseModel courseModel, String logIdent) {
		LOG.info(new StringBuilder("Updating course: ").append(logIdent).toString());
		return courseRepository.save(courseConverter.modelToEntity(courseModel));
	}

	@Override
	public CourseModel findByID(int id) {
		LOG.info(new StringBuilder("finding course by id: ").append(id).toString());
		CourseModel courseModel = courseConverter.entityToModel(courseRepository.findById(id));
		LOG.info(new StringBuilder("Course found: ").append(courseModel).toString());
		return courseModel;
	}

}
