package com.dl.pojo;

public class SubMenu {
  private int id;
  private String title;
  private String img;
  private String type;
  private Menu menu;
  private String time;
  private User user;
  private String content;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Menu getMenu() {
	return menu;
}
public void setMenu(Menu menu) {
	this.menu = menu;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public SubMenu(String title, String img, String type, Menu menu, String time, User user, String content) {
	super();
	this.title = title;
	this.img = img;
	this.type = type;
	this.menu = menu;
	this.time = time;
	this.user = user;
	this.content = content;
}
public SubMenu() {
	super();
	// TODO Auto-generated constructor stub
}
public SubMenu(int id, String title, String img, String type, Menu menu, String time, User user, String content) {
	super();
	this.id = id;
	this.title = title;
	this.img = img;
	this.type = type;
	this.menu = menu;
	this.time = time;
	this.user = user;
	this.content = content;
}
  
}
