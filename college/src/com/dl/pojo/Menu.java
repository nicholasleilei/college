package com.dl.pojo;

public class Menu {
  private int id;
  private String title;
  private String type;
  private Menu menu;
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
public Menu(String title, String type, Menu menu) {
	super();
	this.title = title;
	this.type = type;
	this.menu = menu;
}
public Menu() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
