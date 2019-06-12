<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<div id="wrapper">
        
      <jsp:include page="header.jsp"></jsp:include>  
            
           	<div id="page-wrapper" style="height:91%;">
			<div id="page-inner" style="height:92%;padding:30px 50px;">
			
			 <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            新增用户
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                  
                                    <form role="form" action="UserServlet?flag=insert" method="post">
                                        <div class="form-group col-xs-6">
                                            <label for="username" class="sr-only"></label>
                                            <input class="form-control input-lg " placeholder="用户名" id="username" name="username" />
                                            
                                            <label for="password" class="sr-only"></label>
                                            <input class="form-control input-lg " style="margin:30px 0px;" placeholder="密码"  type="password" id="password" name="password" />
                                            
                                            <button type="submit" class="btn btn-info" style="width:230px;">新增</button>
                                        </div>
                                     
   
                                    </form>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>
			</div>
			<footer><p>Copyright &copy; 2019.    DLXY-Lei 版权所有</p></footer>
			</div></div>
</body>
</html>