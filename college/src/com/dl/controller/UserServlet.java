package com.dl.controller;

import java.io.IOException;

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

	default:
		break;
	}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password,"");
		User loginUser = us.login(user);
		try {
		if(loginUser!=null) {
			request.setAttribute("loginUser", loginUser);
			response.getWriter().print("ok");
		}else {
			response.getWriter().print("no");
		}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
