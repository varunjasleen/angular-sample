package com.temp.angular.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temp.angular.models.Contact;
import com.temp.angular.models.Customer;
import com.temp.angular.repositories.CustomerRepositories;

@RestController
public class CustomerControler {

	@Autowired
	CustomerRepositories contactRepository; 


	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET,value="/customer")
	public Iterable<Customer> getCustomer() {
		
		return contactRepository.findAll();
		
	}	
	/* @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET,value="/customer/{id}")
	public Optional<Customer> getOneCustomer(@PathVariable String id){
		return contactRepository.findById(id);
	}*/
	
	 @CrossOrigin(origins = "http://localhost:4200")
	    @RequestMapping(method=RequestMethod.GET, value="/customer/{Id}")
	    public Customer show(@PathVariable String Id) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		 Optional<Customer> cont = contactRepository.findById(Id);
		Customer con =new Customer();	
	if (cont.isPresent()){
		     con = cont.get();
		  
		}
	        return con;
	    }
	
}
