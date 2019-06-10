package com.dl.pojo;

public class Image {
  private int id;
  private String loc;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
public Image(String loc) {
	super();
	this.loc = loc;
}
public Image() {
	super();
	// TODO Auto-generated constructor stub
}
  
}
