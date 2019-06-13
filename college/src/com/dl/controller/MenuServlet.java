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

import net.sf.json.JSONArray;

//import net.sf.json.JSONArray;
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
//	private MenuDAO mdao = new MenuDAO();
//	private SubMenuDAO subdao = new SubMenuDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		switch (flag) {
		case "findAll":
			findAll(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "insert":
			insert(request,response);
			break;
		case "yupdate":
			yupdate(request,response);
			break;
		case "update":
			update(request,response);
			break;
		case "findByTitle":
			findByTitle(request,response);
			break;
		case "findParentMenu":
			findParentMenu(request,response);
			break;
		case "checkDel":
			checkDel(request,response);
			break;

		default:
			break;
		}
	}
	private void checkDel(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		String id = request.getParameter("id");
//			try {
//				response.getWriter().print(subdao.findByMid(Integer.parseInt(id)));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}
	private void findParentMenu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Menu> menus = ms.findParentMenu();
		JSONArray json = JSONArray.fromObject(menus);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void findByTitle(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		List<Menu> menus = ms.findBySearchPage(request, title);//.findByName(title);
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("menu_show.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String type =request.getParameter("type");
		String mid = request.getParameter("mid");
		String isHomePage =request.getParameter("isHomePage");
		Menu menu=null;
		if(type==null) {
			if(isHomePage==null)
				type="导航菜单";
			else
				type="首页菜单";
		}else {
			type="列表菜单";
			menu=ms.findById(Integer.parseInt(mid));
		}
		Menu m = new Menu(Integer.parseInt(id),title,type,menu);
		ms.update(m);
		findAll(request, response);
	}
	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Menu m = ms.findById(Integer.parseInt(id));
		request.setAttribute("menu", m);
		
		List<Menu> menus = ms.findParentMenu();
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("menu_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String type =request.getParameter("type");//是否有上级菜单=是：导航菜单 否列表菜单
		String mid = request.getParameter("mid");
		String isHomePage =request.getParameter("isHomePage");//是否在首页显示成栏目框
		Menu menu=null;
		if(type==null) {
			if(isHomePage==null)
				type="导航菜单";
			else
				type="首页菜单";
		}else {
			type="列表菜单";
			menu=ms.findById(Integer.parseInt(mid));
		}
		Menu m = new Menu(title,type,menu);
		ms.insert(m);
		findAll(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int  id = Integer.parseInt(request.getParameter("id"));
//		
//		List<Menu> menus = mdao.findByMid(id);
//		for(Menu m:menus) {
//			//将二级菜单下 所有对应的三级菜单删除
//			subdao.deleteByMid(m.getId());
//		}
//		
		ms.delete(id);//删菜单表 id完全匹配
	//	mdao.deleteByMid(id);//删菜单表 如果该菜单是一级菜单并存在二级子菜单 按mid删除
		//并且需要查询该id下所有的二级菜单
	
	//	subdao.deleteByMid(id);//删除子菜单表，与一级菜单直接关联的三级菜单	
		findAll(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Menu> menus = ms.findByPage(request);//.findAll();
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("menu_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}