package com.temp.angular.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temp.angular.models.FriendList;
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
	@RequestMapping(method=RequestMethod.GET,value="/addFriend/{user}/{name}")
	public void addFriend(@PathVariable String user,@PathVariable String name) {
		User user1=null;
		User user2=null;
		user1 = userRepository.findByName(user);
		user2 = userRepository.findByName(name);
		 Set<FriendList> friends = new HashSet<>();
		 // added friend for 1st person  
		 friends = user1.getFriendList();
		 if(friends==null) {
			 friends = new HashSet<>();
		 }
		 friends.add(new FriendList(name,"0" ));
		 user1.setFriendList(friends);
		 userRepository.save(user1);
		 
		// added friend for 2nd person 
		 friends = new HashSet<>();
		 friends = user2.getFriendList();
		 if(friends==null) {
			 friends = new HashSet<>();
			 }
		 friends.add(new FriendList(user,"0" ));
		 user2.setFriendList(friends);
		 userRepository.save(user2);
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.PUT,value="/reqApproved")
	public void reqApproved(@RequestBody User a) {
		 userRepository.save(a);

	}
	
}

