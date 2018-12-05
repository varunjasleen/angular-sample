package com.temp.angular.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	 
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/user")
	public User saveUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET,value="/getUser/{name}")
	public User getUser(@PathVariable String name) {
		User user=null;
		user = userRepository.findByName(name);
		return user;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET,value="/users")
	public Iterable<User> getUser() {
		System.out.println(userRepository.findAll());
		return userRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public boolean ValidateUser(@RequestBody User user) {
		User userdata = null ;
		userdata= userRepository.findByName(user.getName());
 		if(userdata!=null && userdata.getPassword().equalsIgnoreCase(user.getPassword())) {
			return true;	
		}else {
			return false;
		}
	}

}

