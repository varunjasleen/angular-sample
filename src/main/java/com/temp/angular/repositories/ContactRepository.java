package com.temp.angular.repositories;

import com.temp.angular.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, String> {
   
   
    @Override
    void delete(Contact deleted);
}
