package com.classmates.classmates;

public class get_home_details {
	
	private final  String email;
	private final String password;
	private final String name;
	public get_home_details(String email,String password,String name){
		//super();
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
}
