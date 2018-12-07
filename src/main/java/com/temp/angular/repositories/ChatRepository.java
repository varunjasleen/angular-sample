package com.temp.angular.repositories;

import org.springframework.data.repository.CrudRepository;

import com.temp.angular.models.Chat;

public interface ChatRepository extends CrudRepository<Chat, String>{

	Iterable<Chat> findAllBySenderAndReceiver(String user, String receiver);

}
