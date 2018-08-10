<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String staticPath = path + "/static";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="<%=staticPath%>/css/bootstrap/mystyle.css" />
<title>Hello World</title>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 组件复用 -->
	<div class="container">
		<div class="row">
			<!-- 博客列表 -->
			<div class="col-lg-8">
				<div class="row">
					<div class="panel panel-orange">
						<div class="panel-heading">
							<div class="text-center">
								<h3 class="color-gray">
									<a href="#" class="blogTitle">${blog.title }</a>
								</h3>
								<h5>
									<span class="glyphicon glyphicon-user color-orange"></span><span>${requestScope.blog.author
										}</span> <span class="glyphicon glyphicon-time color-orange"></span><span>${requestScope.blog.createtime
										}</span> <span class="glyphicon glyphicon-eye-open color-orange"></span><span>${requestScope.blog.readcount
										}</span>
								</h5>
							</div>
						</div>
						<div class="panel-body">
							<div class="content col-lg-10 col-lg-offset-1">
								<div class="row">${requestScope.blog.content}</div>
							</div>
							<div>
								<button class="btn btn-default pull-right love">
									<span class="glyphicon glyphicon-heart love-icon"></span> 喜欢</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 组件复用 -->
			<div class="col-lg-3" style="margin-left: 30px;">
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3>博主</h3>
							<div class="title-line">
								<h4></h4>
							</div>
							<div class="row">
								<img src="<%=path%>${sessionScope.admin.img}"
									class="img-circle col-lg-5 col-lg-offset-3" />
							</div>
							<div class="row text-center">
								<b>王大可</b><br /> <span class="label label-primary">Java</span>
								<span class="label label-success">Python</span> <span
									class="label label-info">大数据</span> <span
									class="label label-warning">闲置码农</span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3>热门文章</h3>
							<div class="row">
								<table class="table table-hover">
									<c:forEach items="${requestScope.blogListByReadCount}"
										var="blog">
										<tr>
											<td><a href="<%=path %>/main/blogDetail/${blog.bId}"
												class="blogTitle"><span
													class="glyphicon glyphicon-menu-right"></span>${blog.title
													}</a></td>
										</tr>
									</c:forEach>
								</table>
							</div>
							<a class="pull-right" href="<%=path%>/main/toBlogList">>>更多</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 组件复用 -->
		</div>
	</div>

	<jsp:include page="foot.jsp"></jsp:include>
</body>
<script type="text/javascript"
	src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>
</html>