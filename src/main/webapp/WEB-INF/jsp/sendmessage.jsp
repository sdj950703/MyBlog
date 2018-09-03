<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String staticPath = path+"/static";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=staticPath %>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="<%=staticPath %>/css/bootstrap/mystyle.css" />
<title>留言</title>
</head>

<body>
	<!-- 组件复用 -->
	<div class="container-fluid">
		<div class="row topimg"></div>
		<div class="row">
			<jsp:include page="top.jsp"></jsp:include>
		</div>
	</div>
	<!-- 组件复用 -->
	<div class="container">
		<div class="row">
			<!-- 博客列表 -->
			<div class="col-lg-8">

				<div class="row">
					<div class="panel panel-orange">
						<div class="panel-body">

							<form class="form-horizontal" action="#" method="post">
								<div class="form-group col-lg-5">
									<label class="control-label">姓名：</label><br /> <input
										name="name" type="input" class="form-control"
										placeholder="您的姓名" required="required" />
								</div>
								<div class="form-group col-lg-12">
									<label class="control-label">留言：</label><br />
									<textarea name="content" class="form-control" rows="4"
										required="required"></textarea>
								</div>
								<div class="form-group col-lg-5">
									<label class="control-label">若方便，请留下您的联系方式：</label> <input
										name="email" type="email" class="form-control"
										placeholder="您的邮箱" /> <br /> <input name="phone"
										type="input" class="form-control" placeholder="您的联系方式" />

								</div>
								<div class="form-group col-lg-12">
									<button type="submit" class="btn btn-warning">提交</button>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
			<!-- 组件复用 -->
			<jsp:include page="menuright.jsp"></jsp:include>
			<!-- 组件复用 -->
		</div>
	</div>

	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript"
	src="<%=staticPath %>/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath %>/js/bootstrap/bootstrap.min.js"></script>
<script>
		$(function(){
			$(".love").click(function(){
				$(this).children(".love-icon").toggleClass("color-red");
			});
		});
	</script>
</html>