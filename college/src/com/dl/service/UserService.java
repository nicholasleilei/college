package com.dl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.dao.UserDAO;
import com.dl.pojo.User;

public class UserService implements IBaseService<User>{
   private UserDAO userDAO  = new UserDAO();

   
   public User login(User user) {
	  return userDAO.login(user);
   }


@Override
public void insert(User t) {
	userDAO.insert(t);
}


@Override
public void update(User t) {
	// TODO Auto-generated method stub
	userDAO.update(t);
}


@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	userDAO.delete(id);
}


@Override
public List<User> findAll() {
	return userDAO.findAll();
}


@Override
public List<User> findBySomething(String s) {
	// TODO Auto-generated method stub
	return userDAO.findBySomething(s);
}


@Override
public User findById(int id) {
	// TODO Auto-generated method stub
	return userDAO.findById(id);
}


public void deleteByIds(String strs) {
	// TODO Auto-generated method stub
	userDAO.deleteByIds(strs);
}


public List<User> findByPage(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return userDAO.findByPage(request);
}


public List<User> findByNameInPage(HttpServletRequest request, String name) {
	// TODO Auto-generated method stub
	return userDAO.finByNameInPage(request,name);
}
}
