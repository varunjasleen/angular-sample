package com.temp.angular.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temp.angular.models.Chat;
import com.temp.angular.repositories.ChatRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ChatController {
	@Autowired
	ChatRepository chatrepository;
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/getChat/{user}/{receiver}")
	public List<Chat> getChat(@PathVariable String user,@PathVariable String receiver) {
		List<Chat> chatData = new ArrayList<>();
		Iterable<Chat> chat1 =chatrepository.findAllBySenderAndReceiver(user,receiver);
		Iterable<Chat> chat2 =chatrepository.findAllBySenderAndReceiver(receiver,user);
		for (Chat chat : chat1) {
			chatData.add(chat);
		}
		for (Chat chat : chat2) {
			chatData.add(chat);
		}
		return chatData;
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/saveChat/{user}/{receiver}")
	public void saveChat(@PathVariable String user,@PathVariable String receiver,@RequestBody String chatMsg) {
		Calendar calendar = Calendar.getInstance();
	    Date now = calendar.getTime();
	    Timestamp currentTimestamp = new Timestamp(now.getTime());
		Chat chat = new Chat(user,receiver,chatMsg,currentTimestamp.toString());
		chatrepository.save(chat);
	}

}
