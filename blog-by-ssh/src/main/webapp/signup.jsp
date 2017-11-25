<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath }/css/mycss.css" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/index.jsp">YOUNG</a>
			</div>

			<jsp:include page="/include/head-logout.jsp"></jsp:include>

		</div>
	</div>
	<div class="container container-small">
		<h1>
			注册 <small>已有账号？<a
				href="${pageContext.request.contextPath }/login.jsp">登录</a></small>
		</h1>
		<form id="signupform" action="${pageContext.request.contextPath }/userAction_signup.action" method="post">
			<div class="form-group">
				<label>手机</label> <input name="username" type="text" class="form-control">
			</div>
			<div class="form-group">
				<label>验证码</label>
				<div class="input-group">
					<input type="text" class="form-control">
					<div class="input-group-btn">
						<div class="btn btn-default">获取验证码</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>密码</label> <input name="password" type="password" class="form-control">
			</div>
			<div class="form-group">
				<label>再次输入密码</label> <input name="repassword" type="password" class="form-control">
			</div>
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">注册</button>
			</div>
			<div class="form-group">
				注册YOUNG博客即代表您同意<a href="#">YOUNG博客的服务条款</a>
			</div>
		</form>
	</div>
	<div class="footer">© 2017 YOUNG博客 中国互联网举报中心京ICP证1401号京ICP备125439号-3京公网安备</div>
</body>
</html>
