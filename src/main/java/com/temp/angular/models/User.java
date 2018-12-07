package com.temp.angular.models;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="user")
public class User {
	@Id
	String id;
	String name;
	String address;
	String city;
	String phone;
	String email;
	String rollRequested;
	String rollassign;
	 String password;
	 private Set<FriendList> friendList;
	
	public User(){
		
		}
	
	
	public User(String id, String name, String address, String city, String phone, String email, String rollRequested,
			String rollassign, String password,Set<FriendList> friendList) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.rollRequested = rollRequested;
		this.rollassign = rollassign;
		this.password = password;
		this.setFriendList(friendList);
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRollRequested() {
		return rollRequested;
	}
	public void setRollRequested(String rollRequested) {
		this.rollRequested = rollRequested;
	}
	public String getRollassign() {
		return rollassign;
	}
	public void setRollassign(String rollassign) {
		this.rollassign = rollassign;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<FriendList> getFriendList() {
		return friendList;
	}


	public void setFriendList(Set<FriendList> friendList) {
		this.friendList = friendList;
	}


	

}
