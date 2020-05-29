<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>我的账户信息</title>
	<link href="/static/css/system/myUserInfo.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">我的账户信息</span>
			<div class="div_search">
  				<button id="btn-updateMyUserInfo" type="button" class="btn btn-danger">修改</button>
			</div>
			<div class="div_employeeDetail">
				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
					<li class="list-group-item"><label>账户：</label><span class="span-userAccount">${user.userAccount }</span></li>
        			<li class="list-group-item"><label>密码：</label><span class="span-empName">${user.userPwd }</span></li>
        			<li class="list-group-item"><label>用户名称：</label><span class="span-empName">${user.userName }</span></li>
        			<li class="list-group-item"><label>安全邮箱：</label><span class="span-empName">${user.securityMail }</span></li>
        			<li class="list-group-item"><label>账户状态：</label><span class="span-empName">${user.statusName }</span></li>
        			<li class="list-group-item"><label>账户创建人：</label><span class="span-empName">${user.createEmpName }</span></li>
        			<li class="list-group-item"><label>最后一次登录时间：</label><span class="span-empName"><fmt:formatDate value="${user.lastLoginTime }" type="both"/></span></li>
       				<li class="list-group-item"><label>登录次数：</label><span class="span-empName">${user.loginCount }</span></li>
       				<li class="list-group-item"><label>最后一次操作时间：</label><span class="span-empName"><fmt:formatDate value="${user.lastOperatorDate }" type="both"/></span></li>
       				<li class="list-group-item"><label>操作人：</label><span class="span-empName">${user.operatorEmpName }</span></li>
   				</ul>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/system/myUserInfo.js"></script>
</html>