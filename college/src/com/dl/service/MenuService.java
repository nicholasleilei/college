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
		mdao.update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		mdao.delete(id);
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
		return mdao.findBySearchPage(request, title);
	}

	public List<Menu> findParentMenu() {
		// TODO Auto-generated method stub
		return mdao.findParentMenu();
	}

	public List<Menu> findByMid(int parseInt) {
		// TODO Auto-generated method stub
		return mdao.findByMid(parseInt);
	}

	public void deleteByIds(String strs) {
		// TODO Auto-generated method stub
		mdao.deleteByIds(strs);
	}

	public List<Menu> findMenus01() {
		// TODO Auto-generated method stub
		return mdao.findMenus01();
	}

	public List<Menu> findMenus02() {
		// TODO Auto-generated method stub
		return mdao.findMenus02();
	}

	public List<Menu> findByEqName(String string) {
		// TODO Auto-generated method stub
		Menu m =mdao.findByEqName(string);
		
		return findByMid(m.getId());
	}

	


}
