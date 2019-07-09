package com.dl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.pojo.Menu;
import com.dl.util.DBUtil;
import com.dl.util.Pager;

public class MenuDAO implements BaseDAO<Menu>{

	@Override
	public void insert(Menu t) {
		// TODO Auto-generated method stub
		String sql="insert into menu values(null,'"+t.getTitle()+"','"+t.getType()+"',"+(t.getMenu()==null?null:t.getMenu().getId())+",'"+t.getUrl()+"')";
		DBUtil.execute(sql);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from menu where id="+id;
		DBUtil.execute(sql);
	}

	@Override
	public void update(Menu t) {
		// TODO Auto-generated method stub
		String sql="update menu set title='"+t.getTitle()+"',type='"+t.getType()+"',mid="+(t.getMenu()==null?null:t.getMenu().getId())+",url='"+t.getUrl()+"' where id="+t.getId();
		DBUtil.execute(sql);
	}

	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		String sql="select * from menu";
		return findBySql(sql);
	}

	@Override
	public Menu findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from menu where id="+id;
		List<Menu> menus = findBySql(sql);
		return menus.size()>0?menus.get(0):null;
	}

	@Override
	public List<Menu> findBySomething(String name) {
		// TODO Auto-generated method stub
		String sql="select * from menu where title like '%"+name+"%'";
		return findBySql(sql);
	}

	@Override
	public List<Menu> findBySql(String sql) {
		// TODO Auto-generated method stub
		List<Menu> menus = new ArrayList<>();
		Connection conn = DBUtil.getConn();
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Menu m = new Menu();
				m.setId(rs.getInt(1));
				m.setTitle(rs.getString(2));
				m.setType(rs.getString(3));
				m.setMenu(findById(rs.getInt(4)));
				m.setUrl(rs.getString(5));
				menus.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}

	public List<Menu> findParentMenu() {
		// TODO Auto-generated method stub
		String sql="select * from menu where mid is null and type in('导航菜单','栏目菜单')";
		return findBySql(sql);
	}
	 public List<Menu> findByPage(HttpServletRequest request) {
			String url="MenuServlet?flag=findAll";
			int size=7;
			int rows=10;
			int cpage=request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
			String pager=Pager.getPagerStr(url, size, rows, cpage, 1);
			request.setAttribute("pager", pager);
			String sql="select * from menu order by id desc limit "+(cpage-1)*size+","+size;
			   return findBySql(sql);
			}
	 public List<Menu> findBySearchPage(HttpServletRequest request,String name) {
			String url="MenuServlet?flag=findBySomething";
			int size=7;
			int rows=findBySomething(name).size();
			int cpage=request.getParameter("pager")==null?1:Integer.parseInt(request.getParameter("pager"));
			String pager=Pager.getPagerStr(url, size, rows, cpage, 1);
			request.setAttribute("pager", pager);
			String sql="select * from menu where title like '%"+name+"%' limit "+(cpage-1)*size+","+size;
			   return findBySql(sql);
			}

	public List<Menu> findSecondLevelMenu() {
		// TODO Auto-generated method stub
		String sql="select * from menu where mid is not null";
		return findBySql(sql);
	}

	public void deleteByMid(int id) {
		// TODO Auto-generated method stub
		String sql="delete from menu where mid="+id;
		DBUtil.execute(sql);
	}

	public List<Menu> findByMid(int id) {
		// TODO Auto-generated method stub
		String sql ="select * from menu where mid="+id;
		return findBySql(sql);
	}

	public void deleteByIds(String strs) {
		// TODO Auto-generated method stub
				String sql="delete from menu where id in("+strs+")";
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

	public List<Menu> findMenus01() {
		// TODO Auto-generated method stub
		String sql ="select * from menu where mid is null";
		return findBySql(sql);
	}

	public List<Menu> findMenus02() {
		// TODO Auto-generated method stub
		String sql ="select * from menu where mid is not null";
		return findBySql(sql);
	}

	public Menu findMenuByName(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from menu where title='"+name+"'";
		List<Menu> menus = findBySql(sql);
		return menus.size()>0?menus.get(0):null;
	}

	public Menu findByEqName(String string) {
		// TODO Auto-generated method stub
		String sql="select * from menu where title='"+string+"'";
		List<Menu> menus = findBySql(sql);
		return menus.size()>0?menus.get(0):null;
	}

	



	

	

}
