package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	public static final Log LOG = LogFactory.getLog(CourseController.class);

	public static final String COURSES_VIEW = "courses";
	public static final String EDIT_COURSES_VIEW = "editcourse";

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("listAllCourses - Getting all courses!! ");
		ModelAndView maView = new ModelAndView(COURSES_VIEW);
		maView.addObject("course", new CourseModel());
		maView.addObject("courses", courseService.listAllCourses());
		return maView;
	}

	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		String logIdent = new StringBuilder("COURSE=[").append(courseModel.toString()).append("]").toString();
		LOG.info(new StringBuilder("addCourse - Adding course ").append(logIdent).toString());
		courseService.addCourse(courseModel, logIdent);
		return "redirect:/courses/listcourses";
	}

	@PutMapping("/updatecourse")
	public String updateCourse(@ModelAttribute(name = "course") CourseModel courseModel) {
		String logIdent = new StringBuilder("COURSE=[").append(courseModel.toString()).append("]").toString();
		LOG.info(new StringBuilder("updateCourse - Updating course ").append(logIdent).toString());
		courseService.updateCourse(courseModel, logIdent);
		return "redirect:/courses/listcourses";
	}

	@PostMapping("/actioncourse")
	public ModelAndView redirectUpdateView(@ModelAttribute("course") CourseModel courseModel, @ModelAttribute("action") String action) {
		String logIdent = new StringBuilder("COURSE=[").append(courseModel.toString()).append("]").toString();
		LOG.info(new StringBuilder("redirectUpdateView - action course ").append(logIdent).toString());

		switch (action) {
		case "obtain":
			LOG.info(new StringBuilder("redirectUpdateView - Getting course ").append(logIdent).toString());
			return listAllCourses().addObject("course", courseService.findByID(courseModel.getId()));
		case "update":
			LOG.info(new StringBuilder("redirectUpdateView - Updating course ").append(logIdent).toString());
			courseService.updateCourse(courseModel, logIdent);
			break;
		case "delete":
			LOG.info(new StringBuilder("redirectUpdateView - Deliting course ").append(logIdent).toString());
			courseService.removeCourse(courseModel.getId());
			break;
		}
		return listAllCourses();
	}

}
