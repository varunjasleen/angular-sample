package com.temp.angular.repositories;

import org.springframework.data.repository.CrudRepository;

import com.temp.angular.models.Customer;

public interface CustomerRepositories extends CrudRepository<Customer, String>{

	
    @Override
    void delete(Customer deleted);
}
