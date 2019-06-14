package com.dl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.pojo.User;
import com.dl.util.DBUtil;
import com.dl.util.Pager;

public class UserDAO implements BaseDAO<User>{
    
	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		String sql="insert into user values(null,'"+t.getUsername()+"','"+t.getPassword()+"','')";
		DBUtil.execute(sql);
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		String sql="update user set username='"+t.getUsername()+"' ,password='"+t.getPassword()+"' where id="+t.getId();
		DBUtil.execute(sql);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from user where id="+id;
		DBUtil.execute(sql);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		String sql ="select * from user";
		return findBySql(sql);
	}

	@Override
	public List<User> findBySomething(String s) {
		// TODO Auto-generated method stub
		String sql="select * from user where username like '%"+s+"%'";
		return findBySql(sql);
	}

	@Override
	public List<User> findBySql(String sql) {
		List<User> users = new ArrayList<>();
		try {
			Connection conn = DBUtil.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		     while(rs.next()) {
		    	 User u = new User();
		    	 u.setId(rs.getInt(1));
		    	 u.setUsername(rs.getString(2));
		    	 u.setPassword(rs.getString(3));
		    	 u.setLogtime(rs.getString(4));
		    	 users.add(u);
		     }
		     rs.close();
		     ps.close();
		     conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from user where id="+id;
		List<User> users = findBySql(sql);
		return users.size()>0?users.get(0):null;
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		List<User> users =findBySql(sql);
		return users.size()>0?users.get(0):null;
	}

	public void deleteByIds(String strs) {
		// TODO Auto-generated method stub
		String sql="delete from user where id in("+strs+")";
		System.out.println(sql);
		try {
			Connection conn = DBUtil.getConn();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> findByPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url="UserServlet?flag=findAll";
		int size=8;
		int rows=findAll().size();
		int cpage=request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager=Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql="select * from user order by id desc limit "+(cpage-1)*size+","+size;
		 return findBySql(sql);
	}

	public List<User> finByNameInPage(HttpServletRequest request, String name) {
		// TODO Auto-generated method stub
		String url="UserServlet?flag=findByName";
		int size=8;
		int rows=findBySomething(name).size();
		int cpage=request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
		String pager=Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql="select * from user where username like '%"+name+"%' limit "+(cpage-1)*size+","+size;
		   return findBySql(sql);
	}

}
