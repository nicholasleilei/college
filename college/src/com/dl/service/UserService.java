package com.dl.service;

import java.util.List;

import com.dl.dao.UserDAO;
import com.dl.pojo.User;

public class UserService implements IBaseService<User>{
   private UserDAO userDAO  = new UserDAO();

   
   public User login(User user) {
	  return userDAO.login(user);
   }


@Override
public void insert(User t) {
	// TODO Auto-generated method stub
	
}


@Override
public void update(User t) {
	// TODO Auto-generated method stub
	
}


@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	
}


@Override
public List<User> findAll() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public List<User> findBySomething(String s) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public User findById(int id) {
	// TODO Auto-generated method stub
	return null;
}
}
