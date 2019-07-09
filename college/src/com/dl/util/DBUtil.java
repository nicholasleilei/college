package com.dl.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.alibaba.druid.pool.DruidDataSource;

public class DBUtil {
   private static final String driver="com.mysql.jdbc.Driver";
   private static final String url="jdbc:mysql://localhost:3306/collegedb";
   private static final String username="root";
   private static final String password="root";
   private static DruidDataSource dds =null;
   
   public static Connection getConn() {
	   if(dds==null) {
		   dds = new DruidDataSource(); 
	   }
	  
	   dds.setDriverClassName(driver);
	   dds.setUrl(url);
	   dds.setUsername(username);
	   dds.setPassword(password);
	   //dds.setMaxPoolPreparedStatementPerConnectionSize(20);
	   //dds.setMaxActive(10);
	   try {
		return dds.getConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return null;
   }
   
   public static void execute(String sql) {
	  	try {
				Connection conn = getConn();
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
}
