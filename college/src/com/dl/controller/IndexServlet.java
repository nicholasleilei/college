package com.dl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dl.pojo.Menu;
import com.dl.service.MenuService;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> m1s =ms.findMenus01();//导航栏菜单
		request.setAttribute("m1s", m1s);
		List<Menu> m2s =ms.findMenus02();//下拉菜单
		request.setAttribute("m2s", m2s);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
