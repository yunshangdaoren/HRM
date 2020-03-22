<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="top">
	<span>欢迎账户：${session_loginUser.userAccount }(${session_loginUser.userName })</span>
	<div class="btn-group">
	<button type="button" class="btn btn-primary dropdown-toggle" 
			data-toggle="dropdown">
		设置 <span class="caret"></span>
	</button>
	<ul class="dropdown-menu" role="menu">
		<li><a href="#">个人中心</a></li>
		<li><a href="#">账号设置</a></li>
		<li><a href="#">联系管理员</a></li>
		<li class="divider"></li>
		<li><a href="#">帮助</a></li>
		<li><a href="/login/logout">退出登录</a></li>
	</ul>
</div>
</div>