<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath }/css/mycss.css" rel="stylesheet">
</head>
<body>
  <div class="navbar navbar-default">
    <div class="container">
      <div class="navbar-header">
        <a class="navbar-brand" href="${pageContext.request.contextPath }/index.jsp">YOUNG</a>
      </div>
      <label id="toggle-label" class="visible-xs-inline-block" for="toggle-checkbox">MENU</label>
      <input class="hidden" id="toggle-checkbox" type="checkbox">
      <div class="hidden-xs">
        <jsp:include page="/include/head-logout.jsp"></jsp:include>
      </div>
    </div>
  </div>
  <div class="container container-small">
    <h1>登录
      <small>没有账号？<a href="${pageContext.request.contextPath }/signup.jsp">注册</a></small>
    </h1>
    <form id="loginform" action="${pageContext.request.contextPath }/userAction_login.action" method="post">
      <div class="form-group">
        <label>用户名</label>
        <input name="username" type="text" class="form-control">
      </div>
      <div class="form-group">
        <label>密码</label>
        <input name="password" type="password" class="form-control">
      </div>
      <div class="form-group">
        <button class="btn btn-primary btn-block" type="submit">登录</button>
      </div>
      <div class="form-group">
        <a href="#">忘记密码？</a>
      </div>
    </form>
  </div>
  <div class="footer">
    © 2017 YOUNG博客 中国互联网举报中心京ICP证1401号京ICP备125439号-3京公网安备
  </div>
</body>
</html>
