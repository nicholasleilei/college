package com.dl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dl.pojo.User;
import com.dl.util.DBUtil;

public class UserDAO implements BaseDAO<User>{

	@Override
	public void insert(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findBySomething(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findBySql(String sql) {
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement ps = DBUtil.getConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		     while(rs.next()) {
		    	 User u = new User();
		    	 u.setId(rs.getInt(1));
		    	 u.setUsername(rs.getString(2));
		    	 u.setPassword(rs.getString(3));
		    	 u.setLogtime(rs.getString(4));
		    	 users.add(u);
		     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where username='"+user.getUsername()+"' and password='"+user.getPassword()+"'";
		List<User> users =findBySql(sql);
		return users.size()>0?users.get(0):null;
	}

}
