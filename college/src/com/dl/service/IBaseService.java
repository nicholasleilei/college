package com.dl.service;

import java.util.List;

public interface IBaseService<T> {
	  public void insert(T t);
	  public void update(T t);
	  public void delete(int id);
	  public List<T> findAll();
	  public List<T> findBySomething(String s);
	  public T findById(int id);
}
