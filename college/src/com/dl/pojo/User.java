package com.dl.pojo;

public class User {
  private int id;
  private String username;
  private String password;
  private String logtime;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLogtime() {
	return logtime;
}
public void setLogtime(String logtime) {
	this.logtime = logtime;
}
public User(String username, String password, String logtime) {
	super();
	this.username = username;
	this.password = password;
	this.logtime = logtime;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
  

}
