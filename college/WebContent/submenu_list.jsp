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
               <a href="SubMenuServlet?flag=yinsert" class="btn btn-success" style="float:left;height:30px;width:30px;padding:3px;margin-right:20px;"><span class="glyphicon glyphicon-plus "></span></a>
               <a id="del_batch" class="btn btn-danger" style="height:30px;width:30px;padding:3px;"><span class="glyphicon glyphicon-remove"></span></a>
            <form action="SubMenuServlet?flag=findByTitle" method="post"  style="float:right;width:30%;">
           <div class="row" >
  <div class="col-lg-12" >
    <div class="input-group" style="margin-bottom:10px;">
   
      <input type="text" class="form-control" placeholder="按标题查询..." name="title">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">查询</button>
      </span>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
      </form>
    
           <table class="table table-striped table-hover table-bordered" id="table-list">
               <tr id="table-head">
                 <td width="50"><input type="checkbox" name="cb" id="chx_all"/></td>
                 <td width="50">编号</td>
                 <td width="300">标题</td>
                 <td>类型</td>
                 <td width="120">上级菜单编号</td>
                 <td width="300">上级菜单标题</td>
                 <td>操作</td>
              </tr>
                <c:forEach items="${subs }" var="s">
              <tr>
               <td><input type="checkbox" name="cb"/></td>
                 <td>${s.id }</td>
                 <td>${s.title }</td>
                 <td>${s.type }</td>
                 <td>${s.menu.id }</td>
                 <td>${s.menu.title }</td>
                 <td><a href="SubMenuServlet?flag=yupdate&id=${s.id }" class="btn btn-warning" style="height:30px;width:30px;padding:3px;"><span class="glyphicon glyphicon-folder-open"></span></a>
                  <a href="SubMenuServlet?flag=delete&id=${s.id }" class="btn btn-danger" style="margin-left:30px;height:30px;width:30px;padding:4px;"><span class="glyphicon glyphicon-remove"></span></a>
                  </td>
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
    				url:"MenuServlet?flag=deleteSome",
    				type:"post",
    				data:{"mess":str},
    				success:function(d){
    					if(d==0)
    						alert("并未删除任何数据");
    					else
    					    alert("成功删除"+d+"条数据");
    					location="MenuServlet?flag=findAll";
    				}
    			}) 
    			//$(".findbox").attr('action','GoodsServlet?flag=deledeSome&ids='+str); 
    			//$(".findbox").submit(); 
        	});
        	/* //删除之前，查询有没有下级菜单，有提示用户，没有不提示
        	$("a[href='']").click(function(){
        		var id=$(this).attr("id");
        		$.ajax({
        			url:"MenuServlet?flag=checkMenu",
        			type:"post",
        			data:{"id":id},
        			success:function(d){
        				if(d!=0){
        					if(confirm("是否连同下级菜单一起删除？")){
        						location.href="MenuServlet?flag=delete&did="+id;
        					}
        			}else{
        				location="MenuServlet?flag=delete&did="+id;
        			}
        			}
        		});
        	}); */
        })
    </script>

</body>
</html>