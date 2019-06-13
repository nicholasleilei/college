package com.dl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.dao.MenuDAO;
import com.dl.pojo.Menu;

public class MenuService implements IBaseService<Menu>{
private MenuDAO mdao = new MenuDAO();
	@Override
	public void insert(Menu t) {
		// TODO Auto-generated method stub
		mdao.insert(t);
	}

	@Override
	public void update(Menu t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Menu> findBySomething(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Menu findById(int id) {
		// TODO Auto-generated method stub
		return mdao.findById(id);
	}

	public List<Menu> findByPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return mdao.findByPage(request);
	}

	public List<Menu> findBySearchPage(HttpServletRequest request, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Menu> findParentMenu() {
		// TODO Auto-generated method stub
		return mdao.findParentMenu();
	}


}
