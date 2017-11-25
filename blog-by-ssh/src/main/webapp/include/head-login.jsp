<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


</head>

<body>
	<ul class="nav navbar-nav">
		<li><a href="${pageContext.request.contextPath }/index.jsp">首页</a></li>
		<li><a href="${pageContext.request.contextPath }/home.jsp">我的主页</a></li>
		<li><a href="${pageContext.request.contextPath }/pages_article_editor.action">新随笔</a></li>
		<li><a href="${pageContext.request.contextPath }/manage.jsp">管理</a></li>
		<li><a href="${pageContext.request.contextPath }/contact.jsp">订阅我</a></li>
		<li><a href="${pageContext.request.contextPath }/about.jsp">关于我</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="${pageContext.request.contextPath }/set.jsp">设置</a></li>
		<li><a href="${pageContext.request.contextPath }/userAction_logout.action">退出</a></li>
	</ul>
</body>
</html>

