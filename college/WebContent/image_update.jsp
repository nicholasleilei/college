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
                            更新轮播图
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                  
                                    <form role="form" action="ImageServlet?flag=update" method="post"id="ff" enctype="multipart/form-data">
                                        <div class="form-group col-xs-6">
                                          ${img.id }<input type="hidden" name="id" value="${img.id }"/>
                                            <input type="file" name="img" style="margin:20px 0px;"/>
                                            
                                            <button type="submit" class="btn btn-info" style="width:230px;">更新</button>
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