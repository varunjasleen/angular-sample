package com.temp.angular.models;

public class FriendList {
	
	private String name ;
	private String staus;
	
	
	public FriendList() {
		
	}
	
	public FriendList(String name,String staus) {
		super();
		this.name=name ;
		this.setStaus(staus);
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	public String getStaus() {
		return staus;
	}



	public void setStaus(String staus) {
		this.staus = staus;
	}

}
