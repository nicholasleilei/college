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

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		System.out.println(flag);
		switch (flag) {
		case "findAll":
			findAll(request,response);
			break;
		case "checkMenu":
			checkMenu(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "deleteSome":
			deleteSome(request,response);
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
		

		default:
			break;
		}
	}
	private void deleteSome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mess=request.getParameter("mess");
	System.out.println(mess);
		if((mess!=null) && (!mess.equals(""))) {
		String[] strs= mess.split(",");
		  ms.deleteByIds(mess);
		  response.getWriter().print(strs.length);
		}else {
			response.getWriter().print(0);
		}
		
	}
	private void checkMenu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
			try {
				List<Menu> menus =ms.findByMid(Integer.parseInt(id));
				response.getWriter().print(menus.size());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			request.getRequestDispatcher("menu_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String type =request.getParameter("type");
		String url="";
		Menu menu = new Menu();
		menu.setId(Integer.parseInt(id));
		menu.setTitle(title);
		menu.setType(type);
		if("列表菜单".equals(type)) {
			String mid = request.getParameter("mid");
			menu.setMenu(ms.findById(Integer.parseInt(mid)));
			url=request.getParameter("list_url");
		} /*
			 * else if("栏目菜单".equals(type)) { url=request.getParameter("art_url"); }
			 */
		menu.setUrl(url);
		/*
		 * String mid = request.getParameter("mid"); String isHomePage
		 * =request.getParameter("isHomePage"); String url=request.getParameter("url");
		 * Menu menu=null; if(type==null) { if(isHomePage==null) type="栏目菜单"; else
		 * type="首页菜单"; }else { type="列表菜单"; menu=ms.findById(Integer.parseInt(mid)); }
		 * Menu m = new Menu(Integer.parseInt(id),title,type,menu,url);
		 */
		ms.update(menu);
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
		String type =request.getParameter("type");
		String url="";
		Menu menu = new Menu();
		menu.setTitle(title);
		menu.setType(type);
		if("列表菜单".equals(type)) {
			String mid = request.getParameter("mid");
			menu.setMenu(ms.findById(Integer.parseInt(mid)));
			url=request.getParameter("list_url");
		} /*
			 * else if("栏目菜单".equals(type)) { url=request.getParameter("art_url"); }
			 */
		menu.setUrl(url);

		ms.insert(menu);
		findAll(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int  id = Integer.parseInt(request.getParameter("did"));
		System.out.println("id:"+id);
		ms.delete(id);
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