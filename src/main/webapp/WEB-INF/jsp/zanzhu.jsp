<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String staticPath = path + "/static";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赞助作者</title>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="col-lg-8">
<div style="margin-left: 50px;" class="row">
<img alt="" src="<%=staticPath%>/img/1.jpg" style="width: 300px;height: 400px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img alt="" src="<%=staticPath%>/img/2.jpg" style="width: 300px;height: 400px;">
</div>
</div>
<jsp:include page="menuright.jsp"></jsp:include>
<jsp:include page="foot.jsp"></jsp:include>

</body>
</html>