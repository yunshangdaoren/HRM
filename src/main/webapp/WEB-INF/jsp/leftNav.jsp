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
			<p><a href="/workbench/toIndex.do" style=" text-decoration:none;color:white;">工作台</a></p>
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
				<c:choose>
					<c:when test="${roles.roleId==3 }">
						<a href="/department/toDepartmentList.do" >部门详情</a>
						<a href="/position/positionList.do" >职位详情</a>
					</c:when>
					<c:otherwise>
						<a href="/department/toDepartmentList.do" >部门详情</a>
						<a href="/departmentLevel/departmentStructureManage.do" >部门架构管理</a>
						<a href="/position/positionList.do" >职位详情</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>职工信息管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<c:choose>
					<c:when test="${roles.roleId==1 }">
						<a href="/employee/toEmployeeList.do" >职工花名册</a>
						<a href="/contract/needEntryContractList.do" >合同入职</a>
						<a href="/employeeResign/toEmployeeResignList.do" >离职申请列表</a>
					</c:when>
					<c:when test="${roles.roleId==2 }">
						<a href="/employee/toEmployeeList.do" >职工花名册</a>
						<a href="/contract/needEntryContractList.do" >合同入职</a>
						<a href="/employeeResign/toEmployeeResignList.do" >离职申请列表</a>
						<a href="/employee/toMyEmployeeDetail.do">个人信息</a>
						<a href="/employeeResign/toMyEmployeeResignList.do" >我的转岗申请</a>
						<a href="/employeeResign/toMyEmployeeResignList.do" >我的离职申请</a>
					</c:when>
					<c:otherwise>
						<a href="/employee/toEmployeeList.do" >职工花名册</a>
						<a href="/employee/toMyEmployeeDetail.do">个人信息</a>
						<a href="/employeeResign/toMyEmployeeResignList.do" >我的转岗申请</a>
						<a href="/employeeResign/toMyEmployeeResignList.do" >我的离职申请</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>考勤管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<c:choose>
					<c:when test="${roles.roleId==3 }">
						<a href="/attendanceEmployee/toMyAttendanceEmployeeList.do" >个人考勤信息查看</a>
						<a href="/department/list.do" >请假申请</a>
					</c:when>
					<c:otherwise>
						<a href="/attendanceEmployee/toAttendanceEmployeeList.do" >考勤查看与统计</a>
						<a href="/attendanceEmployee/toMyAttendanceEmployeeList.do" >个人考勤信息查看</a>
						<a href="/department/list.do" >请假申请</a>
						<a href="/department/list.do" >审批</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<div class="modu">
		<div class="modu-head">
			<p>绩效管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<c:choose>
					<c:when test="${roles.roleId==3 }">
						<a href="#" >我的个人绩效</a>
					</c:when>
					<c:otherwise>
						<a href="#" >绩效制定</a>
						<a href="#" >绩效查看与统计</a>
						<a href="#" >我的个人绩效</a>
						<a href="#" >下属考评</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<div class="modu">
		<div class="modu-head">
			<p>薪资管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<c:choose>
					<c:when test="${roles.roleId==3 }">
						<a href="#" >我的薪资</a>
					</c:when>
					<c:otherwise>
						<a href="#" >薪资查看与统计</a>
						<a href="#" >我的薪资</a>
						<a href="#" >审批</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<div class="modu">
		<div class="modu-head">
			<p>合同管理</p>
		</div>
		<div class="modu-content">
			<div class="content-body">
				<c:choose>
					<c:when test="${roles.roleId==3 }">
						<a href="/employeeContract/myContractList.do" >我的合同</a>
					</c:when>
					<c:otherwise>
						<a href="/contract/toAllContractList.do" >合同列表</a>
						<a href="/contract/toAddContract.do" >添加合同</a>
						<a href="/employeeContract/myContractList.do" >我的合同</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
		<div class="modu">
			<div class="modu-head">
				<p>系统管理</p>
			</div>
			<div class="modu-content">
				<div class="content-body">
					<c:if test="${roles.roleId!=3 }">
						<a href="#" >消息管理</a>
						<a href="/user/toUserList.do" >系统用户列表</a>
						<a href="/userRole/toUserRoleList.do" >角色管理</a>
					</c:if>
					<a href="/user/toMyUserInfo.do" >个人账户信息管理</a>
				</div>
			</div>
		</div>	
</div>
<script type="text/javascript" src="/static/js/leftNav.js"></script>
</body>
</html>