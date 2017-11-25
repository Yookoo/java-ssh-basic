<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>成功啦!</title>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="${pageContext.request.contextPath }/index.jsp">YOUNG</a>
			</div>
			<c:choose>
				<c:when test="${empty user}">
					<jsp:include
						page="/include/head-logout.jsp"></jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include
						page="/include/head-login.jsp"></jsp:include>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="span12">
				<h1 class="text-center lead text-success">
					<em><strong>太棒了!成功了!</strong></em>
				</h1>
			</div>
		</div>
	</div>
</body>

</html>
