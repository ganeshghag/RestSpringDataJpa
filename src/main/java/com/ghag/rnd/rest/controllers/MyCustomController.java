package com.ghag.rnd.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ghag.rnd.rest.repository.PersonRepository;


@RestController
@RequestMapping("/custom")
public class MyCustomController {
	
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(value="/sayHello/{input}", method=RequestMethod.GET)
	public String sayHello(@PathVariable String input){
		
		System.out.println("findall="+personRepository.findAll());
		personRepository.deleteAll();
		return "Hello!"+input;
	}

}
