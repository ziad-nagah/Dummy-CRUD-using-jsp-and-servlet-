package com.user.model;

public class User {
	private String userName;
	private String password ;
	
public User(){
	
}

public User(String UserName , String pssword){
	this.userName = UserName ;
	this.password = pssword ;
}

public void setUserName(String userName) {
	this.userName = userName ;
}

public void setPassword(String password) {
	this.password = password ;
}
public String getUserName() {
	return userName ;
}
public String getPassword() {
	return password ;
}
}
