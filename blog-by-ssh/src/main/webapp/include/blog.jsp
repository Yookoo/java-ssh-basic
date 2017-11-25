<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div class="page-header">
			<h3 id ='blog-title'></h3>
			<h6 id ='blog-desc'></h6>
		</div>
	<script type="text/javascript">
	$(function(){
		$.post("blogAction_findById.action", {}, function(data, textStatus, req) {
			$("#blog-title").html(data.title);
			$("#blog-desc").html(data.description);
		}, "json")
	});	
	</script>
</body>