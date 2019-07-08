package com.dl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dl.pojo.Menu;
import com.dl.pojo.SubMenu;
import com.dl.service.MenuService;
import com.dl.service.SubMenuService;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	private SubMenuService sms = new SubMenuService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Menu> m1s =ms.findMenus01();//�������˵�
		request.setAttribute("m1s", m1s);
		List<Menu> m2s =ms.findMenus02();//�����˵�
		request.setAttribute("m2s", m2s);
		//��ũ����--����
		SubMenu jinong1 = sms.findByEqName1("��ũ����");
		String content = jinong1.getContent();
		String newc = content.substring(content.indexOf(";\">")+3,content.indexOf("</span>"));
		jinong1.setContent(newc.length()>130?newc.substring(0,130).concat("..."):newc);
		request.setAttribute("jinong1", jinong1);
		
		//��ũ����--list
		List<SubMenu> jinongs = sms.findByEqName2("��ũ����",jinong1);
		request.setAttribute("jinongs", jinongs);
		
		//�Ҳ��ɫ����
		List<Menu> hongs = ms.findByEqName("��ɫ");
		request.setAttribute("hongs", hongs);
		
		
		//���㶯̬
		List<SubMenu> jicengs =sms.findByMenuTitle("���㶯̬");
		request.setAttribute("jicengs", jicengs);
		
		
		//ý�弪ũ
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
