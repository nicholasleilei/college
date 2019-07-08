<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>后台管理系统</title>
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' /> -->
<style type="text/css">
.nav>li {
	padding-left: 20px;
}

#table-list {
	margin-top: 55px;
	text-align: center;
}

#table-list tr {
	height: 40px;
}

#table-head {
	background-color: gray;
	color: white;
	font-size: 16px;
	font-weight: 600;
}

input {
	margin-top: 20px;
	margin-left: 30px;
}

button {
	margin-top: 20px;
	margin-left: 30px;
	width: 230px;
}
#mid{display: none;}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		//网页加载时判断 
		if($("#nav_menu").is(":checked")){
			$("#mid").hide();
			$("#list_url").hide();
			//$("#art_url").hide();
		}else if($("#list_menu").is(":checked")){
			$("#mid").show();
			$("#url").show();
			//$("#art_url").hide();
		}else if($("#art_menu").is(":checked")){
			$("#mid").hide();
			$("#list_url").hide();
			//$("#art_url").show();
		}
		
		//网页加载时判断 是否有上级菜单被选中 如果被选中 显示下拉列表项 用户修改
		
		
		$("#list_menu").click(function(){
			if($(this)[0].checked){
				$.ajax({
					url:'MenuServlet?flag=findParentMenu',
					type:'post',
					success:function(d){
						var list = eval(d);
						$("#mid").empty();
						$(list).each(function(i){
							$("#mid").append("<option value='"+list[i].id+"'>"+list[i].title+"</option>");
						});
					}
				});
				$("#mid").show();
				$("#list_url").show();
			}else{
				$("#mid").hide();
				$("#list_url").hide();
				
			}
			//$("#art_url").hide();
			
		});
		$("#nav_menu").click(function(){
			$("#mid").hide();
			$("#list_url").hide();
			//$("#art_url").hide();
		});
		$("#art_menu").click(function(){
			$("#mid").hide();
			$("#list_url").hide();
			//$("#art_url").show();
		});
		
	});
</script>
</head>
<body style="height: 723px; margin-bottom: 0; padding-bottom: 0;">
	<div id="wrapper" style="height: 100%;">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="page-wrapper" style="min-height: 30px; height: 91%; ">
			<div id="page-inner"
				style="min-height: 30px; height: 92%; padding: 30px 50px;">

				<div class="row" style="height:100%;">
					<div class="col-md-12" style="height:100%;">
						<!-- Form Elements -->
						<div class="panel panel-default" style="height:100%;">
							<div class="panel-heading">更新菜单</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">

										<form role="form" action="MenuServlet?flag=update"
											method="post">
											<input type="hidden" name="id" value="${menu.id }">
											<div class="form-group col-xs-6">
											<label for="title" class="sr-only"></label> <input
													class="form-control input-lg " placeholder="标题" id="title"
													name="title" value="${menu.title }"/>
												<div class="checkbox" style="margin:20px 40px;">
													<label style="margin:5px 0px;"><input type="radio" name="type" value="导航菜单"  id="nav_menu" ${menu.type eq '导航菜单'?'checked':'' }/><span style="color:gray;margin-left:10px;">设置为导航菜单</span></label>
													<label style="margin:5px 0px;"><input type="radio" name="type" value="列表菜单" id="list_menu" ${menu.type eq '列表菜单'?'checked':'' }/><span style="color:gray;margin-left:10px;">设置为列表菜单</span></label>
													<select class="form-control" id="mid" name="mid" style="margin:30px 30px;">
												</select>
												<input
													class="form-control input-lg " placeholder="URL" id="list_url"
													name="list_url" style="margin-bottom:20px;display:none;height:30px;margin-left:30px;"/>
													<label style="margin:5px 0px;">
													<input type="radio" name="type" value="栏目菜单" id="art_menu" ${menu.type eq '栏目菜单'?'checked':'' }/>
													<span style="color:gray;margin-left:10px;">设置为栏目菜单</span></label>
													<input
													class="form-control input-lg " placeholder="URL" id="art_url"
													name="art_url" style="margin-bottom:20px;display:none;height:30px;margin-left:30px;"/>
													  
												</div>
												
												 
												<button type="submit" class="btn btn-info">新增</button>
											</div>


										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>



			<footer><p>Copyright &copy; 2019.    DLXY-Lei 版权所有</p></footer>
			</div>
		</div>
	</div>



</body>
</html>

