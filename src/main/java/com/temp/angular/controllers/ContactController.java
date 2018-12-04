package com.temp.angular.controllers;
import java.util.Optional;
import com.temp.angular.models.Contact;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.temp.angular.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

 	@CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method=RequestMethod.GET, value="/contacts")
    public Iterable<Contact> contact() {

        return contactRepository.findAll();
    }
 @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method=RequestMethod.POST, value="/contacts")
    public Contact save(@RequestBody Contact contact) {
        contactRepository.save(contact);

        return contact;
    }
 @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method=RequestMethod.GET, value="/contacts/{id}")
    public Contact show(@PathVariable String id) {
	Optional<Contact> cont = contactRepository.findById(id);
Contact con =new Contact();	
if (cont.isPresent()){
	     con = cont.get();
	  
	}
        return con;
    }
 @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
	Optional<Contact> cont = contactRepository.findById(id);
Contact c =new Contact();	
if (cont.isPresent()){
		     c = cont.get();
		  
		}
        if(contact.getName() != null)
            c.setName(contact.getName());
        if(contact.getAddress() != null)
            c.setAddress(contact.getAddress());
        if(contact.getCity() != null)
            c.setCity(contact.getCity());
        if(contact.getPhone() != null)
            c.setPhone(contact.getPhone());
        if(contact.getEmail() != null)
            c.setEmail(contact.getEmail());
        contactRepository.save(c);
        return contact;
    }
 @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
    public String delete(@PathVariable String id) {
	Optional<Contact> cont = contactRepository.findById(id);
Contact c =new Contact();		
if (cont.isPresent()){
			     c = cont.get();
			  
			}
        contactRepository.delete(c);

        return "";
    }
}
