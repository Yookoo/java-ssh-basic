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

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.pagination.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/user.pagination.js"></script>

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
			<li class="active">关于我</li>
		</ol>
		<div class="row">
			<div class="col-sm-2">
				<div class="panel panel-info">
					<div class="panel-heading">个人资料</div>
					<div class="panel-body">
						<img
							src="${pageContext.request.contextPath }/image/user-photo.png" />

					</div>
					<div class="panel-footer">yangxiaofan</div>
				</div>


				<div class="panel panel-info">
					<div class="panel-heading">博客资料</div>
					<div class="panel-body">
						<p>博客等级：17</p>
						<p>博客积分：1,359</p>
						<p>博客访问：12,138</p>
						<p>关注人气：33</p>
					</div>

				</div>
			</div>
			<div class="col-sm-10">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">个人档案</div>
					<div class="panel-body">
						<p>自我介绍。。。。。。。。。。 巴拉巴拉..................</p>
					</div>

				</div>
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne" aria-expanded="true"
									aria-controls="collapseOne"> 基本资料 </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">Anim pariatur cliche reprehenderit,
								enim eiusmod high life accusamus terry richardson ad squid. 3
								wolf moon officia aute, non cupidatat skateboard dolor brunch.
								Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
								tempor, sunt aliqua put a bird on it squid single-origin coffee
								nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
								craft beer labore wes anderson cred nesciunt sapiente ea
								proident. Ad vegan excepteur butcher vice lomo. Leggings
								occaecat craft beer farm-to-table, raw denim aesthetic synth
								nesciunt you probably haven't heard of them accusamus labore
								sustainable VHS.</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseTwo"
									aria-expanded="false" aria-controls="collapseTwo"> 个人经历 </a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">Anim pariatur cliche reprehenderit,
								enim eiusmod high life accusamus terry richardson ad squid. 3
								wolf moon officia aute, non cupidatat skateboard dolor brunch.
								Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
								tempor, sunt aliqua put a bird on it squid single-origin coffee
								nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
								craft beer labore wes anderson cred nesciunt sapiente ea
								proident. Ad vegan excepteur butcher vice lomo. Leggings
								occaecat craft beer farm-to-table, raw denim aesthetic synth
								nesciunt you probably haven't heard of them accusamus labore
								sustainable VHS.</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapseThree"
									aria-expanded="false" aria-controls="collapseThree"> 学旅生涯 </a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="headingThree">
							<div class="panel-body">Anim pariatur cliche reprehenderit,
								enim eiusmod high life accusamus terry richardson ad squid. 3
								wolf moon officia aute, non cupidatat skateboard dolor brunch.
								Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon
								tempor, sunt aliqua put a bird on it squid single-origin coffee
								nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica,
								craft beer labore wes anderson cred nesciunt sapiente ea
								proident. Ad vegan excepteur butcher vice lomo. Leggings
								occaecat craft beer farm-to-table, raw denim aesthetic synth
								nesciunt you probably haven't heard of them accusamus labore
								sustainable VHS.</div>
						</div>
					</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">留言版</div>
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label>给我留言</label>
								<textarea class="form-control" placeholder="留下想给我说的话吧"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">发送</button>
						</form>
					</div>

				</div>

			</div>

		</div>
	</div>
</html>