package com.udemy.backendninja.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import com.udemy.backendninja.entities.CourseEntity;
import com.udemy.backendninja.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	public static final Log LOG = LogFactory.getLog(CourseConverter.class);
	
	//Entity to model
	public CourseModel entityToModel(CourseEntity courseEntity) {
		LOG.info(new StringBuilder("Changin entity to model: COURSE=[").append(courseEntity.toString()).append("]"));
		CourseModel courseModel = new CourseModel();
		courseModel.setName(courseEntity.getName());
		courseModel.setDescription(courseEntity.getDescription());
		courseModel.setPrice(courseEntity.getPrice());
		courseModel.setHours(courseEntity.getHours());
		return courseModel;
	}
	
	//Model to entity
	public CourseEntity modelToEntity(CourseModel courseModel) {
		LOG.info(new StringBuilder("Changin model to entity: COURSE=[").append(courseModel.toString()).append("]"));
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setName(courseModel.getName());
		courseEntity.setDescription(courseModel.getDescription());
		courseEntity.setPrice(courseModel.getPrice());
		courseEntity.setHours(courseModel.getHours());
		return courseEntity;
	}

}
