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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tables</title>
<link href="<%=staticPath%>/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<%=staticPath%>/css/bootstrap/bootstrap-table.css" />
<link rel="stylesheet" href="<%=staticPath%>/css/adminStyles.css" />
<style>
#editor {
	overflow: scroll;
	max-height: 500px;
}
</style>

</head>

<body>
	<jsp:include page="top.jsp" />
	<jsp:include page="menuLeft.jsp" />
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a>
				</li>
				<li class="active">博文信息</li>
			</ol>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">博文信息</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">博文信息</div>
					<div class="panel-body">
						<table data-toggle="table" data-show-columns="true"
							data-search="true">
							<thead>
								<tr>
									<th data-checkbox="true">ID</th>
									<th data-sortable="true">标题</th>
									<th data-sortable="true">作者</th>
									<th data-sortable="true">发布时间</th>
									<th data-sortable="true">阅读量</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${blogList }" var="blog">
									<tr>
										<td>${blog.bId }</td>
										<td>${blog.title }</td>
										<td>${blog.author }</td>
										<td>${blog.createtime }</td>
										<td>${blog.readcount }</td>
										<td><a class="btn btn-warning btn-sm"
											href="<%=path%>/blog/${blog.bId}"><span
												class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
											onclick="return confirm('确定删除吗？')"
											class="btn btn-danger btn-sm"
											href="<%=path%>/blog/${blog.bId}?method=deleteBlog"><span
												class="glyphicon glyphicon-remove"></span>&nbsp;删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!--/.main-->
	<script src="<%=staticPath%>/js/jquery/jquery-3.3.1.min.js"></script>
	<script src="<%=staticPath%>/js/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="<%=staticPath%>/js/bootstrap/bootstrap-table.js"></script>
</body>
<script type="text/javascript">
	window.onload = function() {
		var msg = '${msg}';
		if (msg != null && msg != "" && msg != undefined) {
			alert(msg);
		}
	};
</script>
</html>