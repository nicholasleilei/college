<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath }/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath }/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>吉林农业科技学院</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/assets/css/now-ui-kit.css?v=1.1.0" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="${pageContext.request.contextPath }/assets/css/demo.css" rel="stylesheet" />
    <!-- Canonical SEO -->
    <link rel="canonical" href="" />
    <!--  Social tags      -->
    <meta name="keywords" content="">
    <meta name="description" content="">
    
    
    
</head>

<body class="login-page sidebar-collapse">

    <!-- End Navbar -->
    <div class="page-header" filter-color="blue">
        <div class="page-header-image" style="background-image:url(assets/img/bg.jpg)"></div>
        <div class="container">
            <div class="col-md-4 content-center">
                <div class="card card-login card-plain">
                    <form class="form" method="post" action="" id="form_login">
                        <div class="header header-primary text-center">
                            <div class="logo-container">
                                <img src="assets/img/now-logo.png" alt="">
                            </div>
                        </div>
                        <div class="content">
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
                                <input type="text" class="form-control" placeholder="用户名..." name="username">
                            </div>
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
                                <input type="password" placeholder="密码..." class="form-control" name="password"/>
                            </div>
                        </div>
                        <div class="footer text-center">
                            <a href="#pablo" id="btn_login" class="btn btn-primary btn-round btn-lg btn-block">登  &nbsp;&nbsp;&nbsp;录</a>
                        </div>
                       
                    </form>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
               
                <div class="copyright">
                    &copy;
                    <script>
                        document.write(new Date().getFullYear())
                    </script>, Designed by Lei. Coded by Lei 
                </div>
            </div>
        </footer>
    </div>
</body>
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath }/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="${pageContext.request.contextPath }/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="${pageContext.request.contextPath }/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
<script src="${pageContext.request.contextPath }/assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
<!-- Share Library etc -->
<script src="${pageContext.request.contextPath }/assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
<script src="${pageContext.request.contextPath }/assets/js/now-ui-kit.js?v=1.1.0" type="text/javascript"></script>
<script type="text/javascript">
  $(function(){
	  $("#btn_login").click(function(){
		 $.ajax({
			 url:"UserServlet?flag=login",
			 type:"post",
			 data:$("#form_login").serialize(),
			 success:function(d){
				if(d=="ok")
				 location="backmain.jsp";
			 }
		 });
	  });
  })
</script>
</html>