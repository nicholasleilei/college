package com.dl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.pojo.SubMenu;
import com.dl.util.DBUtil;
import com.dl.util.Pager;

public class SubMenuDAO implements BaseDAO<SubMenu>{
    private MenuDAO mdao =new MenuDAO();
    private UserDAO udao =new UserDAO();
	@Override
	public void insert(SubMenu t) {
		// TODO Auto-generated method stub
		String sql = "insert into submenu values(null,'" + t.getTitle() + "','"+t.getImg()+"','" + t.getType() + "','"
				+ t.getMenu().getId() + "','" + t.getTime() + "'," + t.getUser().getId() + ",'" + t.getContent() + "')";
	     DBUtil.execute(sql);
	}

	@Override
	public void update(SubMenu t) {
		// TODO Auto-generated method stub
		var image=t.getImg()==null?",img='"+t.getImg()+"'":"";
		String sql = "update submenu set title='" + t.getTitle() + "'"+image+",type='" + t.getType() + "',mid=" + t.getMenu().getId()
				+ ",time='" + t.getTime() + "',uid=" + t.getUser().getId() + ",content='" + t.getContent()
				+ "' where id=" + t.getId();
		System.out.println(sql);
		DBUtil.execute(sql);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from submenu where id=" + id;
		DBUtil.execute(sql);
	}

	@Override
	public List<SubMenu> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from submenu";
		return findBySql(sql);
	}

	@Override
	public List<SubMenu> findBySomething(String s) {
		// TODO Auto-generated method stub
		String sql = "select * from submenu where title like '%" + s + "%'";
		return findBySql(sql);
	}

	@Override
	public List<SubMenu> findBySql(String sql) {
		List<SubMenu> subs = new ArrayList<>();
		Connection conn = DBUtil.getConn();
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SubMenu s = new SubMenu();
				s.setId(rs.getInt(1));
				s.setTitle(rs.getString(2));
				s.setImg(rs.getString(3));
				s.setType(rs.getString(4));
				s.setMenu(mdao.findById(rs.getInt(5)));
				s.setTime(rs.getString(6));
				s.setUser(udao.findById(rs.getInt(7)));
				s.setContent(rs.getString(8));
				subs.add(s);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subs;
	}

	@Override
	public SubMenu findById(int id) {
		// TODO Auto-generated method stub
		String sql="select * from submenu where id="+id;
		List<SubMenu> menus = findBySql(sql);
		return menus.size() > 0 ? menus.get(0) : null;
	}

	public List<SubMenu> findByPage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String url = "SubMenuServlet?flag=findAll";
		int size = 7;
		int rows = findAll().size();
		int cpage = request.getParameter("pager") == null ? 1 : Integer.parseInt(request.getParameter("pager"));
		String pager = Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql = "select * from submenu  order by id desc limit " + (cpage - 1) * size + "," + size;
		return findBySql(sql);
	}

	public List<SubMenu> findBySearchPage(HttpServletRequest request, String title) {
		String url = "SubMenuServlet?flag=findByTitle";
		int size = 7;
		int rows = findBySomething(title).size();
		int cpage = request.getParameter("pager") == null ? 1 : Integer.parseInt(request.getParameter("pager"));
		String pager = Pager.getPagerStr(url, size, rows, cpage, 1);
		request.setAttribute("pager", pager);
		String sql = "select * from submenu where title like '%" + title + "%' limit " + (cpage - 1) * size + "," + size;
		return findBySql(sql);
	}
	public void deleteByIds(String strs) {
		// TODO Auto-generated method stub
				String sql="delete from submenu where id in("+strs+")";
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
}
