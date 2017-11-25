<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/mycss.css">

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pagination.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user.pagination.js"></script>
	
<!--[if lt IE 9]>
		    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
<title>Insert title here</title>
</head>
<body>
<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/index.jsp">YOUNG</a>
			</div>
			<jsp:include page="/include/head-login.jsp"></jsp:include>
		</div>
	</div>
	
	<div class="container">
	<jsp:include page="/include/blog.jsp"></jsp:include>
		<ol class="breadcrumb">
			<li><a href="#">首页</a></li>
			<li class="active">博客管理</li>
		</ol>
		<div class="row">
			<div class="col-sm-2">
				<div class="hidden-xs list-group side-bar">
					<a href="#" class="list-group-item active">操作</a> <a href="#"
						class="list-group-item">添加新随笔</a> <a href="#"
						class="list-group-item">设置默认编辑器</a> <a href="#"
						class="list-group-item">博客客户端</a> <a href="#"
						class="list-group-item">博客签名</a> <a href="#"
						class="list-group-item">博客备份</a> <a href="#"
						class="list-group-item">博客搬家</a> <a href="#"
						class="list-group-item">item</a>
				</div>
				<div class="hidden-xs list-group side-bar">
					<a href="#" class="list-group-item active">分类</a> <a href="#"
						class="list-group-item">[未分类]</a> <a href="#"
						class="list-group-item">[编辑分类]</a> <a href="#"
						class="list-group-item">随笔</a> <a href="#" class="list-group-item">心情</a>
					<a href="#" class="list-group-item">日记</a>
				</div>
			</div>
			<div class="col-sm-10">
				<table class="table table-striped">

					<thead>
						<tr>
						<td>标题</td>
						<td>发布状态</td>
						<td>阅读数</td>
						<td>评论数</td>
						<td colspan="2">操作</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Sunday's Coming I Wanna Drive My Car To Your Apartment
								With Present</td>
							<td>已发布</td>
							<td>100</td>
							<td>20</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Sunday's Coming I Wanna Drive My Car To Your Apartment
								With Present</td>
							<td>已发布</td>
							<td>100</td>
							<td>20</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Sunday's Coming I Wanna Drive My Car To Your Apartment
								With Present</td>
							<td>已发布</td>
							<td>100</td>
							<td>20</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
						<tr>
							<td>4</td>
							<td>Sunday's Coming I Wanna Drive My Car To Your Apartment
								With Present</td>
							<td>已发布</td>
							<td>100</td>
							<td>20</td>
							<td>编辑</td>
							<td>删除</td>
						</tr>
					</tbody>
				</table>
				<center>
					<nav aria-label="Page navigation">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
					</nav>
				</center>
			</div>
		</div>
	</div>
</html>