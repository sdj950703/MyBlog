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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="<%=staticPath%>/css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="<%=staticPath%>/css/bootstrap/mystyle.css" />
<title>博客列表</title>
</head>
<body>
	<!--top -->
	<jsp:include page="top.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<!-- 博客列表 -->
			<div class="col-lg-8">

				<div class="row">
					<div class="panel panel-orange">
						<div class="panel-body">
							<form class="form-horizontal">
								<div class="form-group">
									<label class="control-label sr-only">按条件排序</label>
									<div class="col-lg-3">
										<select class="form-control" id="conditionSearch">
											<option>时间</option>
											<option>作者</option>
											<option selected="selected">阅读量</option>
											<option>分类</option>
										</select>
									</div>
								</div>
							</form>
							<table class="table table-hover">
								<c:forEach items="${requestScope.allBlog }" var="blog">
									<tr>
										<td><a class="blogTitle"
											href="<%=path %>/main/blogDetail/${blog.bId}">${blog.title
												}</a> <span class="pull-right"> <span
												class="glyphicon glyphicon-user color-orange"></span><span>${blog.author
													}</span> <span class="glyphicon glyphicon-time color-orange"></span><span>${blog.createtime
													}</span> <span class="glyphicon glyphicon-eye-open color-orange"></span><span>${blog.readcount
													}</span>
										</span></td>
									</tr>
								</c:forEach>
							</table>

						</div>
					</div>
				</div>
			</div>
			<!-- 组件复用 -->
			<jsp:include page="menuright.jsp"></jsp:include>
			<!-- 组件复用 -->
		</div>
	</div>



	<!-- footer -->
	<jsp:include page="foot.jsp"></jsp:include>

</body>
<script type="text/javascript"
	src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#conditionSearch").change(function() {
			$(this).attr("selected", "selected");
			var option = $("#conditionSearch option:selected").val();
			window.location.href = "/MyBlog/main/toBlogList?option=" + option;
		});
	});
</script>
</html>
