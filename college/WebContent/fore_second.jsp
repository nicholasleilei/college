<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta charset="UTF-8">
		<title>吉林农业科技学院</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css" />
</head>
<body>
<header>
			<img src="img/logo.png" class="img_logo" height="110"/>
			<ul class="header_link">
                 <li><div class="link_icon1"><a href="">智慧农苑</a></div></li>
                  <li><div class="link_icon2"><a href="">邮件系统</a></div></li>
                   <li><div class="link_icon3"><a href="">办公平台</a></div></li>
                    <li><div class="link_icon4"><a href="">校友在线</a></div></li>
			</ul>
			<div class="header_search">
				<div><a href="">学生</a>|
					<a href="">教职工</a>|
					<a href="">校友</a>|
					<a href="">考生及访客</a></div>
				<form action="" method="post">
				<input type="text" name="mess" placeholder="搜索"/>
			    </form>
			</div>
			
		
			<ul class="nav">
			<c:forEach items="${m1s }" var="m" begin="0" end="8">
			     <li><a href="">${m.title}</a>
					<ul>
					<c:forEach items="${m2s }" var="n">
					<c:if test="${m.id==n.menu.id }">
					  <li><a href="${n.url }">>&nbsp;&nbsp;${n.title}</a></li>
					</c:if>
					</c:forEach>
					</ul>
				</li>
			</c:forEach>
		
			</ul>
		
		</header>
		 <div class="sec_banner">
		    <img src="${pageContext.request.contextPath }/img/banner_shennei.jpg"> 
		 </div>
		 <div class="sec_main">
		    <div class="sec_main_left">
		       <div class="topa"><a href="IndexServlet?flag=findIndex">学校主页&nbsp;&nbsp;</a>>&nbsp;&nbsp;<a href="Second">学校概况</a></div>
		       <div class="top_img">
		         <img alt="" src="${pageContext.request.contextPath }/img/xy_03.png">
		       </div>
		       <ul class="top">
		          <li><a href="">学生</a></li>
		          <li><a href="">教职工</a></li>
		          <li><a href="">校友</a></li>
		          <li><a href="">考生及访客</a></li>
		       </ul>
		    </div>
		    <div class="sec_main_right">
		       <div class="top">学校概况</div>
		       <div class="bot" style="clear:both;">1<br>
		       1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br>1<br></div>
		    </div>
		    <br style="clear:both;" />
		    <!-- <div class="clear"></div> -->
		 </div>
		 <br style="clear:both;" />
				<footer>
			   <ul>
					<li style="width:60px; border:none;">快速通道:</li>
					<li style="width:60px;"><a href="http://218.62.80.51/tmweb">在线选课</a></li>
					<li style="width:50px;"><a href="http://tsg.jlnku.edu.cn/">图书馆</a></li>
					<li style="width:120px;"><a href="http://bchzz.jlnku.edu.cn/">有害生物诊治系统</a></li>
					<li style="width:60px;"><a href="http://tcgb.cbpt.cnki.net/EditorDN/quit.aspx">学报投稿</a></li>
					<li><a href="http://www.jlnku.com/opinion/?14_1.html">机关工作意见箱</a></li>
					<li><a href="http://125.223.252.157:8081/">心理健康测试</a></li>
					<li><a href="http://125.223.252.158/">心理危机干预</a></li>
					<li style="width:120px;border:none;"><a href="http://saap.jlnku.edu.cn:8882/">财务自助报账系统</a></li>
				</ul>
				 <ul>
					<li style="width:60px;border:none;">快速通道:</li>
					<li style="width:60px;"><a href="http://www.moe.edu.cn/">教育部</a></li>
					<li style="width:85px;"><a href="http://www.moe.edu.cn/">吉林省教育厅</a></li>
					<li style="width:85px;"><a href="http://www.edu-gov.cn/index.html">中华教育网</a></li>
					<li style="width:85px;"><a href="http://www.gx211.com/">中国高校之窗</a></li>
					<li style="width:85px;"><a href="http://www.chinazszx.com.cn/">中国招生在线</a></li>
					<li style="width:120px;"><a href="http://www.jlipedu.cn/">吉林省教育信息网</a></li>
					<li><a href="http://www.jlhe.cn/">吉林高教教学网</a></li>
					<li style="width:85px;border:none;"><a href="http://wm.jlnku.edu.cn/">校园文明网</a></li>
				</ul>
				<ul class="footer_info">
					<li >版权所有：吉林农业科技学院  吉公网安备：22020202000145号 吉ICP备：05002128号</li>
					<li>九站校区地址：吉林市吉林经济技术开发区翰林路77号  邮编：132101</li>
					<li>左家校区地址：吉林市昌邑区左家镇学府路1号  邮编：132109</li>
				</ul>
				<div class="footer_erweima"><img src="img/liantu.png"/>
				<span>进入手机版</span></div>
		</footer>
		
		<script type="text/javascript" src="js/jquery-3.4.1.min.js" ></script>
		<script>
			$(function(){
				//鼠标移入导航栏 字变为黑色
				$(".nav>li").mouseover(function(){
					$(this).children("a").css("color","grey");
					$(this).children("ul").show();
				}).mouseout(function(){
					$(this).children("a").css("color","white");
					$(this).children("ul").hide();
				});
				
			
				
				
			})
			
		</script>
</body>
</html>