package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	public static final Log LOG = LogFactory.getLog(ExampleService.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Julian", 28));
		people.add(new Person("Santiago", 28));
		people.add(new Person("Luisga", 30));
		people.add(new Person("Juanfe", 34));
		LOG.info("HELLO FROM SERVICE -- LIST: '" + people + "'");
		return people;
	}

}
