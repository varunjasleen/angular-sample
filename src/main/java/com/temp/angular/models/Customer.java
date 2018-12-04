package com.temp.angular.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="customer")
public class Customer {

	@Id
	String id;
	private String name;
	private String address;
	private String contect;
	private String age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getContect() {
		return contect;
	}
	public Customer() {
	}
	public Customer(String id, String name, String address, String contect, String age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.contect = contect;
		this.age = age;
	}
	public void setContect(String contect) {
		this.contect = contect;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
