<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="/static/js/jquery.min.js"></script>
	<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/static/bootstrap/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/static/css/base.css" />
	<link rel="stylesheet" href="/static/css/leftNav.css" />
	<link rel="stylesheet" href="/static/css/top.css" />
	<script type="text/javascript" src="/static/js/top.js"></script>
</head>
<body>

<!-- 左侧导航栏 -->
<div id="leftNav">
	<div class="modu">
		<div class="modu-head">
			<p><a href="/workbench/index.do" style=" text-decoration:none;color:white;">工作台</a></p>
		</div>
		<div class="modu-content">
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>组织管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<a href="/department/departmentList.do" >部门详情</a>
				<a href="/departmentLevel/departmentLevelList.do" >部门架构管理</a>
				<a href="/position/positionList.do" >职位管理</a>
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>职工信息管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<a href="/department/list.do" >职工花名册</a>
				<a href="/department/list.do" >职工入职</a>
				<a href="/department/list.do" >职工离职</a>
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>考勤管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>绩效管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				
			</div>
		</div>
	</div>
	
	<div class="modu">
		<div class="modu-head">
			<p>薪资管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				
			</div>
		</div>
	</div>
	
	<div class="modu">
		<div class="modu-head">
			<p>合同管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				
			</div>
		</div>
	</div>
		<div class="modu">
			<div class="modu-head">
				<p>系统管理</p>
			</div>
			<div class="modu-content">
				<div class="content-body">
					<a href="/user/toAddUser.do" >消息管理</a>
					<a href="/user/listSaleManager.do" >系统用户列表</a>
					<a href="/user/toAddUser.do" >创建系统用户</a>
					<a href="/user/toAddUser.do" >权限管理</a>
				</div>
			</div>
		</div>	
</div>
<script type="text/javascript" src="/static/js/leftNav.js"></script>
</body>
</html>