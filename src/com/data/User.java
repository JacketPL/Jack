package com.data;

public class User {
	private String userId;
	private String userName;
	private String userSex;
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public String getUserPassword() {
		return userPassword;
	}
	private String userPassword;
	/**
	 * 
	 */
	public User(){
		
	}
	public User(String userId,String userName,String userPassword,String userSex){
		this.userId=userId;
		this.userName=userName;
		this.userSex=userSex;
		this.userPassword=userPassword;
	}
}
