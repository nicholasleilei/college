package com.dl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dl.pojo.User;
import com.dl.service.UserService;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String flag = request.getParameter("flag");
	   System.out.println("flag:"+flag);
	   switch (flag) {
	case "login":
		login(request,response);
		break;
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
	case "findByName":
		findByName(request,response);
		break;
	case "deleteSome":
		deleteSome(request,response);
		break;
	default:
		break;
	}
	}
	private void deleteSome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mess=request.getParameter("mess");
		String[] strs = mess.split(",");
		us.deleteByIds(mess);
		response.getWriter().print(strs.length);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password,"");
		User loginUser = us.login(user);
		try {
		if(loginUser!=null) {
			request.getSession().setAttribute("loginUser", loginUser);
			PrintWriter out =response.getWriter();
			out.print("ok");
		}else {
			response.getWriter().print("no");
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void findByName(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("username");
		List<User> users = us.findByNameInPage(request, name);//us.findBySomething(name);////
		request.setAttribute("users", users);
		try {
			request.getRequestDispatcher("user_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		User u  = new User(Integer.parseInt(id),username,password,"");
		us.update(u);
		findAll(request, response);
		
	}
	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		User u = us.findById(Integer.parseInt(id));
		request.setAttribute("user", u);
		try {
			request.getRequestDispatcher("user_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		User u  = new User(username,password,"");
		us.insert(u);
		findAll(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		us.delete(Integer.parseInt(id));
		findAll(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = us.findByPage(request);//us.findAll();
		request.setAttribute("users", users);
		
		
		try {
			request.getRequestDispatcher("user_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
