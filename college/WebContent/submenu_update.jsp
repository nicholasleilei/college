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
/* #mid{display: none;} */
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
 /* $(function(){
	 var flag=true;
	$("#upfile").change(function(){
		var name=$(this).val();
		var suffix=name.substring(name.indexOf("."));
		if(name!=".jpg" || name!=".jpeg" ||name!=".gif" ||name!=".png"){
			$("#sp").html("格式不正确");
			flag=false;
		}else{
			flag=true;
		}
	}).click(function(){
		$("#sp").html("");
	});
 }) */
	
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
							<div class="panel-heading">更新文章信息</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-6">

										<form role="form" action="SubMenuServlet?flag=update"
											method="post" id="ff" enctype="multipart/form-data">
											<div class="form-group col-xs-6">
											<input type="hidden" name="id" value="${submenu.id }"/>
												<label for="title" class="sr-only"></label> <input
													class="form-control input-lg " placeholder="标题" id="title"
													name="title" value="${submenu.title }"/>
												<select class="form-control" id="mid" name="mid" style="margin:30px 0px;">
												<option>--请选择--</option>
												<c:forEach items="${menus }" var="m">
												   <option value="${m.id }" <c:if test="${m.id eq submenu.menu.id}">selected</c:if>>${m.title }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${m.type}</option>
												</c:forEach>
												</select>
                                                <input type="file" id="upfile" name="upfile" style="margin-bottom:20px;" ><span id="sp" style="color:red;"></span>
												<textarea id="content" name="content" style="width:700px;height:200px;">${submenu.content}</textarea>
												<button type="submit" class="btn btn-info" style="margin-top:20px;">更新</button>
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
<script charset="utf-8" src="${pageContext.request.contextPath }/editor/kindeditor-all-min.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath }/editor/lang/zh-CN.js"></script>
		<script charset="utf-8" src="${pageContext.request.contextPath }/editor/plugins/code/prettify.js"></script>
		<script>
			KindEditor.ready(function(K) {
				var editor1 = K.create('textarea[name="content"]', {
					cssPath : '${pageContext.request.contextPath }/editor/plugins/code/prettify.css',
					uploadJson : '${pageContext.request.contextPath }/editor/jsp/upload_json.jsp',
					fileManagerJson : '${pageContext.request.contextPath }/editor/jsp/file_manager_json.jsp',
					allowFileManager : true,
					afterCreate : function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
							document.forms['ff'].submit();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
							document.forms['ff'].submit();
						});
					}
				});
				prettyPrint();
			});
		</script> 


</body>
</html>

