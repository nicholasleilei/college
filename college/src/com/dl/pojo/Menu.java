package com.dl.pojo;

public class Menu {
  private int id;
  private String title;
  private String type;
  private String url;
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

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Menu(String title, String type, Menu menu,String url) {
	super();
	this.title = title;
	this.type = type;
	this.menu = menu;
	this.url=url;
}
public Menu() {
	super();
	// TODO Auto-generated constructor stub
}
public Menu(int id, String title, String type, Menu menu,String url) {
	super();
	this.id = id;
	this.title = title;
	this.type = type;
	this.menu = menu;
	this.url=url;
}
  
}
