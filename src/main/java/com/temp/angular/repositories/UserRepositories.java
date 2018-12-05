package com.temp.angular.repositories;
import org.springframework.data.repository.CrudRepository;

import com.temp.angular.models.User;

public interface UserRepositories extends 
CrudRepository<User, String> {
	
	
	public default User getUserByName() {
		User user = new User();
		return user;
	}

	public User findByName (String string);

}
