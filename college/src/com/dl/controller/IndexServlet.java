package com.dl.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.html.HTMLUListElement;

import com.dl.pojo.Menu;
import com.dl.pojo.SubMenu;
import com.dl.service.MenuService;
import com.dl.service.SubMenuService;
import com.dl.util.HTMLUtil;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	private SubMenuService sms = new SubMenuService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag =request.getParameter("flag");
		switch (flag) {
		case "findIndex":
			findIndex(request,response);
			break;
		case "findSecond":
			findSecond(request,response);
			break;

		default:
			break;
		}
		
		
	}
	private void findSecond(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mid = request.getParameter("mid");
		
		List<Menu> m1s =ms.findMenus01();//�������˵�
		request.setAttribute("m1s", m1s);
		List<Menu> m2s =ms.findMenus02();//�����˵�
		request.setAttribute("m2s", m2s);
		
		
		request.getRequestDispatcher("fore_second.jsp").forward(request, response);
	}
	private void findIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Menu> m1s =ms.findMenus01();//�������˵�
		request.setAttribute("m1s", m1s);
		List<Menu> m2s =ms.findMenus02();//�����˵�
		request.setAttribute("m2s", m2s);
		//��ũ����--����
		SubMenu jinong1 = sms.findByEqName1("��ũ����");
		String content = jinong1.getContent();
		
		content=HTMLUtil.getText(content, 130);
		jinong1.setContent(content);
		request.setAttribute("jinong1", jinong1);
		
		//��ũ����--list
		List<SubMenu> jinongs = sms.findByEqName2("��ũ����",jinong1);
		request.setAttribute("jinongs", jinongs);
		
		//�Ҳ��ɫ����
		List<Menu> hongs = ms.findByEqName("��ɫ");
		request.setAttribute("hongs", hongs);
		
		
		//���㶯̬
		List<SubMenu> jicengs =sms.findByMenuTitle("���㶯̬");
		request.setAttribute("jicengs", sms.changeContent(jicengs, 30));
		
		
		//ý�弪ũ
		List<SubMenu> meitis =sms.findByMenuTitle("ý�弪ũ");
		request.setAttribute("meitis", meitis);
		
		
		//֪ͨ����
		List<SubMenu> tongzhis = sms.findByMenuTitle("֪ͨ����");
		request.setAttribute("tongzhis", tongzhis);
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
