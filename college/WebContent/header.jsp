<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap Styles-->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="${pageContext.request.contextPath }/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="${pageContext.request.contextPath }/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="${pageContext.request.contextPath }/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
   <!--  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' /> -->
</head>
<body>

<nav class="navbar navbar-default top-navbar" role="navigation">
                <a class="" href="index.html">
                   <img alt="" src="${pageContext.request.contextPath }/img/logo.png" width="200" height="70" style="margin-left:20px;" >
                </a>

            <ul class="nav  navbar-right" style="margin-right:30px;">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> ${loginUser.username}
                    </a>
                </li>
                <li><a href="bgindex.jsp"><i class="fa fa-sign-out fa-fw"></i> 退出</a></li>
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a href="UserServlet?flag=findAll"><i class="glyphicon glyphicon-user"></i>用户管理</a>
                    </li>
                    <li>
                        <a href="MenuServlet?flag=findAll"><i class="fa fa-sitemap"></i> 菜单管理</a>
                    </li>
					<li>
                        <a href="SubMenuServlet?flag=findAll"><i class="fa fa-edit"></i> 子菜单管理</a>
                    </li>
                    <li>
                        <a href="ImageServlet?flag=findAll"><i class="glyphicon glyphicon-film"></i> 轮播图管理</a>
                    </li>
                    
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->




    <script src="${pageContext.request.contextPath }/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	 
    <!-- Metis Menu Js -->
    <script src="${pageContext.request.contextPath }/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="${pageContext.request.contextPath }/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/morris/morris.js"></script>
	
	
	<script src="${pageContext.request.contextPath }/assets/js/easypiechart.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/easypiechart-data.js"></script>
	
	
    <!-- Custom Js -->
    <script src="${pageContext.request.contextPath }/assets/js/custom-scripts.js"></script>
</body>
</html>