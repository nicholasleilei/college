package com.dl.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dl.pojo.Image;
import com.dl.pojo.SubMenu;
import com.dl.service.ImageService;
@WebServlet("/ImageServlet")
@MultipartConfig
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImageService is = new  ImageService();
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
			if((mess!=null) && (!mess.equals(""))) {
			String[] strs= mess.split(",");
			  is.deleteByIds(mess);
			  response.getWriter().print(strs.length);
			}else {
				response.getWriter().print(0);
			}
			
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		 String image=upload(request);
		 Image img = new Image(Integer.parseInt(id),image);
		  is.update(img);
		 
		findAll(request, response);
	}
	private void yupdate(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		Image img = is.findById(Integer.parseInt(id));
		
		request.setAttribute("img", img);
		try {
			request.getRequestDispatcher("image_update.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		String upfile=upload(request);
		Image img = new Image(upfile);
		is.insert(img);
		findAll(request, response);
	}
	public String upload(HttpServletRequest request) {
		String newname="";
		String suffix="";
		try {
			Part part = request.getPart("img");//获得用户选择的图片的路径
			String path =  part.getHeader("content-disposition");//获得头部信息
			if(!path.endsWith("filename=\"\"")) {
			  suffix =path.substring(path.lastIndexOf("."),path.length()-1);//截取得到文件后缀
			
			File f = new File("d://dl//lunbo");//判断文件是否存在  不存在就创建一个
			if(!f.exists())
				f.mkdirs();
			 newname = UUID.randomUUID()+suffix;//随机生成文件名+后缀
			part.write("d://dl//lunbo//"+newname);//上传：使用流的方式上传到磁盘
			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newname;
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		is.delete(Integer.parseInt(id));
		findAll(request, response);
	}
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		List<Image> imgs = is.findByPage(request);//.findAll();
		request.setAttribute("imgs", imgs);
		try {
			request.getRequestDispatcher("image_list.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
