<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path=request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#editor{
overflow: scroll;
}
</style>
</head>
<body>
<div id="editor"></div>
<textarea id="text1" style="width:100%; height:200px;"></textarea>
<button id="btn1">获取html内容</button>
<button id="btn2">获取文本内容</button>
<script type="text/javascript" src="<%=path %>/static/js/wangEditor.min.js"></script>
<script src="<%=path%>/static/js/jquery/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
var E = window.wangEditor;
var editor = new E('#editor');
var $text1=$("#text1");
editor.customConfig.uploadImgServer = '<%=path%>/admin/imgUpload';
editor.customConfig.uploadFileName = 'img'
editor.customConfig.onchange = function (html) {
    // 监控变化，同步更新到 textarea
    $text1.val(html);
};
editor.create();
// 初始化 textarea 的值
$text1.val(editor.txt.html());
</script>
</body>
</html>