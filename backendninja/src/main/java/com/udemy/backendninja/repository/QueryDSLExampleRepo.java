package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entities.CourseEntity;
import com.udemy.backendninja.entities.QCourseEntity;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourseEntity qCourseEntity = QCourseEntity.courseEntity;
	
	@PersistenceContext
	private EntityManager em;
	
	public CourseEntity find(boolean exist) {
		
		JPAQuery<CourseEntity> query = new JPAQuery<CourseEntity>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourseEntity.description.endsWith("OP"));
		
		if (exist) {
			Predicate predicate2 = qCourseEntity.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourseEntity.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		CourseEntity courseEntity = query.select(qCourseEntity).from(qCourseEntity).where(predicateBuilder).fetchOne();
		
		List<CourseEntity> courseEntities = query.select(qCourseEntity).from(qCourseEntity).where(qCourseEntity.hours.between(20, 50)).fetch();
		
		return courseEntity;
	}

}
