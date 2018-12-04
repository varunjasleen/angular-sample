package com.temp.angular.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temp.angular.models.User;
import com.temp.angular.repositories.UserRepositories;

@RestController
public class UserController {
	
	 @Autowired
	    UserRepositories userRepository;
	
	@CrossOrigin(origins ="http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public User saveUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

}
