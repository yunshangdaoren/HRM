<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/workbench/index.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<div class="div-title" style="height:50px;">
				<span class="title">工作台</span>
			</div>
			<div class="div-content">
				<div class="content-left">
					<div class="div1">
						<div class="panel panel-primary" style="width:48%;float:left;">
  							<div class="panel-heading">
    							<h3 class="panel-title">待入职</h3>
  							</div>
  							<div class="panel-body">
    							Panel content
  							</div>
						</div>
						<div class="panel panel-success" style="width:48%;float:right;">
  							<div class="panel-heading">
    							<h3 class="panel-title">待转正</h3>
  							</div>
  							<div class="panel-body">
    							Panel content
  							</div>
						</div>
					</div>
					<div class="div2"></div>
					<div class="div3"></div>
				</div>
				<div class="content-center">
					<div class="div1">
						<div class="panel panel-warning" style="width:48%;float:left;">
  							<div class="panel-heading">
    							<h3 class="panel-title">待调动</h3>
  							</div>
  							<div class="panel-body">
    							Panel content
  							</div>
						</div>
						<div class="panel panel-danger" style="width:48%;float:right;">
  							<div class="panel-heading">
    							<h3 class="panel-title">待离职</h3>
  							</div>
  							<div class="panel-body">
    							Panel content
  							</div>
						</div>
					</div>
					<div class="div2"></div>
					<div class="div3"></div>
				</div>
				<div class="content-right">
					<div class="div1"></div>
					<div class="div2"></div>
					<div class="div3"></div>
				</div>
			</div>
			
		
			
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	

		
</body>
	
</html>