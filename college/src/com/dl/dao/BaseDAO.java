package com.dl.dao;

import java.util.List;

public interface BaseDAO <T>{
  public void insert(T t);
  public void update(T t);
  public void delete(int id);
  public List<T> findAll();
  public List<T> findBySomething(String s);
  public List<T> findBySql(String sql);
  public T findById(int id);
}
