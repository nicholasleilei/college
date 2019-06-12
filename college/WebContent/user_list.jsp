<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
        
      <jsp:include page="header.jsp"></jsp:include>  
            
           	<div id="page-wrapper" style="height:91%;">
			<div id="page-inner" style="height:92%;padding:30px 50px;">
               <a href="user_insert.jsp" class="btn btn-success" style="float:left;height:30px;width:30px;padding:3px;margin-right:20px;"><span class="glyphicon glyphicon-plus "></span></a>
               <a id="del_batch" class="btn btn-danger" style="height:30px;width:30px;padding:3px;"><span class="glyphicon glyphicon-remove"></span></a>
            <form action="UserServlet?flag=findByName" method="post"  style="float:right;width:30%;">
           <div class="row" >
  <div class="col-lg-12" >
    <div class="input-group" style="margin-bottom:10px;">
   
      <input type="text" class="form-control" placeholder="按用户名查询..." name="username">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">查询</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
      </form>
    
           <table class="table table-striped table-hover table-bordered" id="table-list">
              <tr id="table-head">
                 <td><input type="checkbox" name="cb" id="chx_all"/></td>
                 <td>编号</td>
                 <td>用户名</td>
                 <td>密码</td>
                 <td>操作</td>
              </tr>
              <c:forEach items="${users }" var="u">
              <tr>
                 <td><input type="checkbox" name="cb"/></td>
                 <td>${u.id }</td>
                 <td>${u.username }</td>
                 <td>${u.password }</td>
                 <td><a href="UserServlet?flag=yupdate&id=${u.id }" class="btn btn-warning" style="height:30px;width:30px;padding:3px;"><span class="glyphicon glyphicon-folder-open"></span></a>
                  <a href="UserServlet?flag=delete&id=${u.id }" class="btn btn-danger" style="margin-left:30px;height:30px;width:30px;padding:4px;"><span class="glyphicon glyphicon-remove"></span></a></td>
              </tr>
              </c:forEach>
           </table>
           <div style="text-align: center;margin-top:-10px;">${pager}</div> 
           </div>
				<footer><p>Copyright &copy; 2019.    DLXY-Lei 版权所有</p></footer>
            </div>
        </div>
    <script src="${pageContext.request.contextPath }/assets/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath }/assets/js/custom-scripts.js"></script>
    <script src="${pageContext.request.contextPath }/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
        	$("#chx_all").click(function(){
        		$("input[name=cb]").prop('checked',$(this).is(":checked"));
        	});
        	$("#del_batch").click(function(){
         		var checks = $("input[name=cb]");
    			var str="";
    			 $.each(checks,function(index,value){
    				 if(value.checked && index!=0){
    					str+=$(this).parent().next().html()+',';
    				 }
    			});
    			 str=str.substring(0,str.length-1);
    			 $.ajax({
    				url:"UserServlet?flag=deleteSome",
    				type:"post",
    				data:{"mess":str},
    				success:function(d){
    					alert("成功删除"+d+"条数据");
    					location="UserServlet?flag=findAll";
    				}
    			}) 
    			//$(".findbox").attr('action','GoodsServlet?flag=deledeSome&ids='+str); 
    			//$(".findbox").submit(); 
        	});
        })
    </script>

</body>
</html>