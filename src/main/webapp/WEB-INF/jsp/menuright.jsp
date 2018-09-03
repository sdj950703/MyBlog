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
	<div class="container">
		<div class="row">
			
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
								<b>史东杰</b><br /> 
								
								<c:forTokens items="${sessionScope.admin.tag}" delims=","
									var="t">
									<label class="label label-info">  ${t}
									</label>

								</c:forTokens>
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
									<c:forEach items="${sessionScope.blogListByReadCount}"
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
		</div>
	</div>

</body>
<script type="text/javascript"
	src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>

</html>