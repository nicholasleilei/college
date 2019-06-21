package com.dl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dl.dao.ImageDAO;
import com.dl.pojo.Image;
import com.dl.pojo.SubMenu;
import com.dl.pojo.User;

public class ImageService implements IBaseService<Image>{
   private ImageDAO imgDAO  = new ImageDAO();

   


@Override
public void insert(Image t) {
	imgDAO.insert(t);
}


@Override
public void update(Image t) {
	// TODO Auto-generated method stub
	imgDAO.update(t);
}


@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	imgDAO.delete(id);
}


@Override
public List<Image> findAll() {
	return imgDAO.findAll();
}


@Override
public List<Image> findBySomething(String s) {
	// TODO Auto-generated method stub
	return imgDAO.findBySomething(s);
}


@Override
public Image findById(int id) {
	// TODO Auto-generated method stub
	return imgDAO.findById(id);
}


public void deleteByIds(String strs) {
	// TODO Auto-generated method stub
	imgDAO.deleteByIds(strs);
}


public List<Image> findByPage(HttpServletRequest request) {
	// TODO Auto-generated method stub
	return imgDAO.findByPage(request);
}


}
