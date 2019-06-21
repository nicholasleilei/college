package com.dl.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dl.pojo.Menu;
import com.dl.pojo.SubMenu;
import com.dl.pojo.User;
import com.dl.service.SubMenuService;
@WebServlet("/SubMenuServlet")
@MultipartConfig
public class SubMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SubMenuService ss = new SubMenuService();
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
		case "yinsert":
			yinsert(request,response);
			break;
		case "deleteSome":
			deleteSome(request,response);
			break;
		default:
			break;
		}
	}
	private void deleteSome(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String mess=request.getParameter("mess");
		System.out.println(mess);
			if((mess!=null) && (!mess.equals(""))) {
			String[] strs= mess.split(",");
			  ss.deleteByIds(mess);
			  response.getWriter().print(strs.length);
			}else {
				response.getWriter().print(0);
			}
			
	}
	private void yinsert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Menu> menus =ss.findAllMenu();
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("submenu_insert.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void findParentMenu(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
//		List<Menu> menus = mdao.findParentMenu();
//		//JSONObject json = JSONObject.fromObject(menus);
//		JSONArray json = JSONArray.fromObject(menus);
//		try {
//			response.getWriter().print(json);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	private void findByTitle(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		List<SubMenu> subs = ss.findBySearchPage(request, title);//.findByName(title);
		request.setAttribute("subs", subs);
		try {
			request.getRequestDispatcher("submenu_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String mid = request.getParameter("mid");
		String content =request.getParameter("content");
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		User user = (User) request.getSession().getAttribute("loginUser");
		 String image=upload(request);
		
		  System.out.println(mid+"  "+id); 
		  SubMenu s = new SubMenu(Integer.parseInt(id),title,image,"文章",ss.findByMId(Integer.parseInt(mid)),time,user,content); 
		  ss.update(s);
		 
		findAll(request, response);
	}
	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		SubMenu s = ss.findById(Integer.parseInt(id));
		request.setAttribute("submenu", s);
		
		List<Menu> menus = ss.findAllMenu();
		request.setAttribute("menus", menus);
		try {
			request.getRequestDispatcher("submenu_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String mid = request.getParameter("mid");
		String content =request.getParameter("content");
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		User user = (User) request.getSession().getAttribute("loginUser");
		String upfile=upload(request);
		SubMenu s = new SubMenu(title,upfile,"文章",ss.findByMId(Integer.parseInt(mid)),time,user,content);
		ss.insert(s);
		findAll(request, response);
	}
	public String upload(HttpServletRequest request) {
		String newname="";
		String suffix="";
		try {
			Part part = request.getPart("upfile");//获得用户选择的图片的路径
			String path =  part.getHeader("content-disposition");//获得头部信息
			System.out.println(path);
			if(!path.endsWith("filename=\"\"")) {
			  suffix =path.substring(path.lastIndexOf("."),path.length()-1);//截取得到文件后缀
			
			File f = new File("d://dl//imgs");//判断文件是否存在  不存在就创建一个
			if(!f.exists())
				f.mkdirs();
			 newname = UUID.randomUUID()+suffix;//随机生成文件名+后缀
			part.write("d://dl//imgs//"+newname);//上传：使用流的方式上传到磁盘
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newname;
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		ss.delete(Integer.parseInt(id));
		findAll(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<SubMenu> subs = ss.findByPage(request);//.findAll();
		request.setAttribute("subs", subs);
		try {
			request.getRequestDispatcher("submenu_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}