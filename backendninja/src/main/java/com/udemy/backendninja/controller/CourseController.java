package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	public static final Log LOG = LogFactory.getLog(CourseController.class);
	
	public static final String COURSES_VIEW = "courses";
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Getting all courses!! ");
		ModelAndView maView = new ModelAndView(COURSES_VIEW);
		maView.addObject("course", new CourseModel());
		maView.addObject("courses", courseService.listAllCourses());
		return maView;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		String logIdent = new StringBuilder("COURSE=[").append(courseModel.toString()).append("]").toString();
		LOG.info(new StringBuilder("Adding course").append(logIdent).toString());
		courseService.addCourse(courseModel, logIdent);
		return "redirect:/courses/listcourses";
	}
	

}
