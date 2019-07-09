<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>吉林农业科技学院</title>
		<link rel="stylesheet" href="css/index.css" />
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
			     <li><a href="IndexServlet?flag=findSecond&mid=${m.id }">${m.title}</a>
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
		<section>
			<div class="lunbo_left"></div>
			<div class="lunbo_left_on"></div>
			<div class="lunbo_main">
				<div class="turn_left"></div>
				<div class="turn_right"></div>
			</div>
			<div class="lunbo_right"></div>
			<div class="lunbo_right_on"></div>
		</section>
		<aside>
			<section>
				<article>
					<div class="art_top">
						<span class="art_top_left">吉农新闻</span>
						<a class="art_top_right" href="">查看更多>></a>
					</div>
					<div class="art_main">
						<div class="art_main_left">
							<div class="art_main_left_img">
								<img src="/i/${jinong1.img }" />
							</div>
							<div class="art_main_left_title"><a href="" style="font-size: 14px;">${jinong1.title }</a></div>
						    <div class="art_main_left_content">${jinong1.content}</div> 
						</div>
						<ul class="art_main_right">
						<c:forEach items="${jinongs}" var="jn" begin="0" end="7">
						  <li><a href="">${fn:length(jn.title)>20?fn:substring(jn.title,0,20).concat('...'):jn.title }(${fn:substring(jn.time,5,11)})</a></li>
						</c:forEach>
						</ul>
					</div>
				</article>
				<ul class="art_list">
				<c:forEach items="${hongs }" var="h">
				   <li><a href="${h.url }" ${fn:length(h.title)>=13?'style="font-size:13px;"':'' }>${h.title }</a></li>
				</c:forEach>
				</ul>
			</section>
		</aside>
		<div class="arti">
			<div class="art_left">
				<ul class="art_left_top">
					<li id="l1"><a href="">基层动态</a></li>
					<li id="l2"><a href="">媒体吉农</a></li>
				</ul>
				<ul class="art_left_list" id="u1">
				<c:forEach items="${jicengs }" var="jc">
				<li><div class="art_left_list_date">
						<span>${fn:substring(jc.time,11,17)}</span>
						<div class="art_left_list_date_bottom">
                            ${fn:substring(jc.time,5,11)}					
						</div>
					</div>
					  <div class="art_left_list_content">
					  	 <div class="art_left_list_content_title"><a href="">${fn:length(jc.title)>20?fn:substring(jc.title,0,20).concat("..."):jc.title}</a></div>
					  	  <div class="art_left_list_content_message">${jc.content}</div>
					  </div>
					</li>
				</c:forEach>
				</ul>
		<ul class="art_left_change" id="u2">
		<c:forEach items="${meitis }" var="mt">
				    <li class="art_left_list_lis"><a href="">${fn:length(mt.title)>20?fn:substring(mt.title,0,20).concat("..."):mt.title }<span>${fn:substring(mt.time,0,11) }</span></a></li>
		</c:forEach>
				</ul>
			</div>
			<div class="art_right">
				<ul class="art_left_top">
					<li><a href="" >通知公告</a></li>
					<li><a href="" >信息公开</a></li>
					<li><a href="" >查看更多>></a></li>
				</ul>
				<ul class="art_left_list">
				<c:forEach items="${tongzhis }" var="tz">
					<li><a href="">${fn:length(tz.title)>28?fn:substring(tz.title,0,28).concat("..."):tz.title }<span>${fn:substring(tz.time,0,10) }</span></a></li>
				</c:forEach>
				</ul>
			</div>
		</div>
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
				 var imgs = ["a.jpg","b.jpg","c.jpg"];
				//轮播图左
				var i=1;
				
				$(".turn_left").click(function(){
					i++; //i=2
					if(i==imgs.length){
                          i=0;
                     }
					$(".lunbo_left").css({"background":"url(img/"+imgs[(i-1)==-1?imgs.length-1:i-1]+")","background-size":"300% 100%","background-position":"-518px 0px"});
					$(".lunbo_main").css({"background":"url(img/"+imgs[i]+")","background-size":"100% 100%"});
					$(".lunbo_right").css({"background":"url(img/"+imgs[(i+1)==imgs.length?0:i+1]+")","background-size":"300% 100%","background-position":"518px 0px"});
				});
				$(".turn_right").click(function(){
					i--;
					if(i==-1){
						i=imgs.length-1;
					}
					$(".lunbo_left").css({"background":"url(img/"+imgs[(i-1)==-1?imgs.length-1:i-1]+")","background-size":"300% 100%","background-position":"-518px 0px"});
					$(".lunbo_main").css({"background":"url(img/"+imgs[i]+")","background-size":"100% 100%"});
					$(".lunbo_right").css({"background":"url(img/"+imgs[(i+1)==imgs.length?0:i+1]+")","background-size":"300% 100%","background-position":"518px 0px"});
				});
				
				//选项卡
				$("#l1").mouseover(function(){
					$("#u1").show();
					$("#u2").hide();
				});
				$("#l2").mouseover(function(){
					$("#u2").show();
					$("#u1").hide();
				});
				
			})
			
		</script>
	</body>
</html>
