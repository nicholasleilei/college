package com.dl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.dao.MenuDAO;
import com.dl.dao.SubMenuDAO;
import com.dl.pojo.Menu;
import com.dl.pojo.SubMenu;

public class SubMenuService implements IBaseService<SubMenu>{

	private SubMenuDAO smdao =new SubMenuDAO();
	private MenuDAO mdao = new MenuDAO();
	@Override
	public void insert(SubMenu t) {
		// TODO Auto-generated method stub
		smdao.insert(t);
	}

	@Override
	public void update(SubMenu t) {
		// TODO Auto-generated method stub
		smdao.update(t);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		smdao.delete(id);
	}

	@Override
	public List<SubMenu> findAll() {
		// TODO Auto-generated method stub
		return smdao.findAll();
	}

	@Override
	public List<SubMenu> findBySomething(String s) {
		// TODO Auto-generated method stub
		return smdao.findBySomething(s);
	}

	@Override
	public SubMenu findById(int id) {
		// TODO Auto-generated method stub
		return smdao.findById(id);
	}

	public List<Menu> findAllMenu() {
		// TODO Auto-generated method stub
		return mdao.findAll();
	}

	public List<SubMenu> findByPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return smdao.findByPage(request);
	}

	public Menu findByMId(int parseInt) {
		// TODO Auto-generated method stub
		return mdao.findById(parseInt);
	}

}
