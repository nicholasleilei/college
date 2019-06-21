package com.dl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.pojo.Image;
import com.dl.pojo.SubMenu;
import com.dl.pojo.User;
import com.dl.util.DBUtil;
import com.dl.util.Pager;

public class ImageDAO implements BaseDAO<Image>{

	@Override
	public void insert(Image t) {
		// TODO Auto-generated method stub
		String sql="insert into image values(null,'"+t.getLoc()+"')";
		DBUtil.execute(sql);
	}

	@Override
	public void update(Image t) {
		// TODO Auto-generated method stub
		if(t.getLoc()!=null&&!t.getLoc().equals("")) {
			String sql="update image set loc='"+t.getLoc()+"' where id="+t.getId() ;
			DBUtil.execute(sql);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from image where id="+id;
		DBUtil.execute(sql);
	}

	@Override
	public List<Image> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from image";
		return findBySql(sql);
	}

	@Override
	public List<Image> findBySomething(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> findBySql(String sql) {
		List<Image> imgs = new ArrayList<>();
		try {
			Connection conn = DBUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		     while(rs.next()) {
		    	 Image i = new Image();
		    	 i.setId(rs.getInt(1));
		    	 i.setLoc(rs.getString(2));
		    	 imgs.add(i);
		     }
		     rs.close();
		     ps.close();
		     conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgs;
	}

	@Override
	public Image findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from image where id="+id;
		List<Image> imgs = findBySql(sql);
		return imgs.size()>0?imgs.get(0):null;
	}

	public void deleteByIds(String strs) {
		// TODO Auto-generated method stub
		String sql="delete from image where id in("+strs+")";
		DBUtil.execute(sql);
	}

	public List<Image> findByPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url="ImageServlet?flag=findAll";
		int size=5;
		int rows=findAll().size();
		int cpage=request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager=Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql="select * from image order by id desc limit "+(cpage-1)*size+","+size;
		 return findBySql(sql);
	}



}
