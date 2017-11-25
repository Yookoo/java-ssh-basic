<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>YOUNG的博客</title>
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
			<li class="active">我的主页</li>
		</ol>
		<div class="row">
			<div class="col-sm-2">Sunday's Coming I Wanna Drive My Car To
				Your Apartment With Present Like A Star Forecaster Said The Weather
				May Be Rainy Hard But I Know The Sun Will Shine For Us Oh Lazy
				Seagull Fly Me From The Dark I Dress My Jeans And Feed My Monkey
				Banana Then I Think My Age How Old Skyline How Far Or We Need Each
				Other In California You Show Me Your Body Before Night Comes Down I
				Touch Your Face And Promise To Stay Ever Young On This Ivory Beach
				We Kissed So Long It Seems That The Passion's Never Gone You Sing Me
				Your Melody And I Feel So Please I Want You To Want Me To Keep Your
				Dream Together We'll Run Wild By A Summer Symphony This Is What We
				Enjoyed Not A Fantasy The Tin-man's Surfing I Wanna Try My Luck To
				The Top Of Tide Rip Like Just Have Some Drugs I Know You Have No
				Blame For My Proud Moonish Heart Welcome To The Golden Beatnik Park
				Oh Diamond Seashore Drag Me From The Yard Incredible Sunward I Watch
				As You're In Photograph For Camera Your Smile's So Sweet Palm Trees
				So Lush Would You Believe My Honey It's Califonia You Show Me Your
				Body Before Night Comes Down I Touch Your Face And Promise To Stay
				Ever Young On This Ivory Beach We Kissed So Long It Seems That The
				Passion's Never Gone You Sing Me Your Melody And I Feel So Please I
				Want You To Want Me To Keep Your Dream Together We'll Run Wild By A
				Summer Symphony This Is What We Enjoyed Not A Fantasy Yeahhh
				Ahhhhhh~~~</div>
			<div class="col-sm-7">
				<div class="art-list" id ="user-art-list">
			
				</div>
				<center><div id="pager"></div></center>
			</div>
			<div class="col-sm-3">Sunday's Coming I Wanna Drive My Car To
				Your Apartment With Present Like A Star Forecaster Said The Weather
				May Be Rainy Hard But I Know The Sun Will Shine For Us Oh Lazy
				Seagull Fly Me From The Dark I Dress My Jeans And Feed My Monkey
				Banana Then I Think My Age How Old Skyline How Far Or We Need Each
				Other In California You Show Me Your Body Before Night Comes Down I
				Touch Your Face And Promise To Stay Ever Young On This Ivory Beach
				We Kissed So Long It Seems That The Passion's Never Gone You Sing Me
				Your Melody And I Feel So Please I Want You To Want Me To Keep Your
				Dream Together We'll Run Wild By A Summer Symphony This Is What We
				Enjoyed Not A Fantasy The Tin-man's Surfing I Wanna Try My Luck To
				The Top Of Tide Rip Like Just Have Some Drugs I Know You Have No
				Blame For My Proud Moonish Heart Welcome To The Golden Beatnik Park
				Oh Diamond Seashore Drag Me From The Yard Incredible Sunward I Watch
				As You're In Photograph For Camera Your Smile's So Sweet Palm Trees
				So Lush Would You Believe My Honey It's Califonia You Show Me Your
				Body Before Night Comes Down I Touch Your Face And Promise To Stay
				Ever Young On This Ivory Beach We Kissed So Long It Seems That The
				Passion's Never Gone You Sing Me Your Melody And I Feel So Please I
				Want You To Want Me To Keep Your Dream Together We'll Run Wild By A
				Summer Symphony This Is What We Enjoyed Not A Fantasy Yeahhh
				Ahhhhhh~~~</div>
		</div>

	</div>
</body>

</html>