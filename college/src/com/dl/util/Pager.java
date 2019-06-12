package com.dl.util;



public class Pager{
	private String url;
	private int cpage;
	private int pagers;
	private int nums;
	
	private Pager(String url,int size,int rows,int cpage,int nums) {
		this.url = url.indexOf("?")>-1?url+"&pager=":url+"?pager=";
		this.pagers = rows%size>0?rows/size+1:rows/size;
		this.cpage = cpage<1?1:cpage>this.pagers?this.pagers:cpage;
		this.nums = nums<5?5:nums;
	}
	
	
	/**
	 * 获得分页字符串
	 * @param url 链接
	 * @param size 每页显示数量
	 * @param cpage	当前页数
	 * @param rows 总数据行数
	 * @return 分页字符串
	 */
	public static String getPagerStr(String url,int size,int rows,int cpage,int nums) {
		StringBuffer page=new StringBuffer();
		Pager pager=new Pager(url,size,rows,cpage,nums);
		page.append("<nav aria-label=\"Page navigation\"><ul class=\"pagination\"><li><a href=\""+pager.url+pager.getPrivior()+"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		
		for(int i= pager.getStart(); i<pager.getEnd()+1; i++) {
			if(i==pager.cpage)
				page.append("<li><a href=\"#\">"+i+"</a></li>");
			else
				page.append("<li><a href=\""+pager.url+i+"\">"+i+"</a></li>");
		}
		page.append("<li><a href=\""+pager.url+pager.getNext()+"\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		return page.toString();
	}
	
	/**
	 * 本页开始数字
	 * @return 数字
	 */
	private int getStart() {
		return this.cpage%this.nums>0?this.cpage/this.nums*this.nums+1:(this.cpage-1)/this.nums*this.nums+1;
	}
	
	/**
	 * 本页结束数字
	 * @return 数字
	 */
	private int getEnd() {
		int temp = (this.cpage/this.nums+1)*this.nums;
		return this.cpage%this.nums>0?temp>this.pagers?this.pagers:temp:this.cpage;
	}
	/**
	 * 上一页
	 * @return 上一页页码
	 */
	private int getPrivior() {
		return cpage>1?cpage-1:1;
	}
	/**
	 * 下一页
	 * @return 下一页页码
	 */
	private int getNext() {
		return cpage<this.pagers?cpage+1:this.pagers;
	}
	
	
}

