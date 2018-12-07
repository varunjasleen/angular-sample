package com.temp.angular.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="chat")
public class Chat {
	
	@Id
	String id;
	String sender;
	String receiver;
	String msg;
	String timestamp;
	
	
	public Chat() {
		
	}
	
	public Chat(String sender,String receiver,String msg,String timestamp) {
		this.sender=sender;
		this.receiver=receiver;
		this.msg=msg;
		this.timestamp=timestamp;
			
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
