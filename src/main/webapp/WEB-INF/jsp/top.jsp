<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--

//-->
</script>
<div id="top">
	<div class="div_title">HRM管理系统<span></span></div>
	<span>欢迎账户：${session_loginUser.userAccount }(${session_loginUser.userName })</span>
	<div class="btn-group">
		<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
			设置 <span class="caret"></span>
		</button>
		<ul class="dropdown-menu dropdown-menu-right" role="menu">
			<li><a href="#">个人中心</a></li>
			<li><a href="#" class="a_changeUserPwd">修改密码</a></li>
			<li><a href="#">联系管理员</a></li>
			<li class="divider"></li>
			<li><a href="#">帮助</a></li>
			<li><a class="a_logout" href="/login/logout.do">退出登录</a></li>
		</ul>
	</div>
	<img id="img_headPortrait" src="/static/img/head.jpg" alt="头像" class="img-circle">
</div>

  <!-- 遮罩层，用于修改密码 -->
	<div class="shadeDiv">
		<div class="panel_changeUserPwd">
			<div class="panel">
    			<div class="panel-heading">
    				<label>修改密码</label>
    				<button id="btn_hideShadeDiv" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form id="form_changeUserPwd">
  						<div class="form-group">
    						<input type="password" name="currentUserPwd" class="form-control" id="currentUserPwd" placeholder="请输入当前的密码">
  						</div>
  						<!-- 如果当前密码输入错误，则提示用户当前密码输入错误 -->
                        <span class="span_erroCurrentPwd">当前密码错误</span>
  						<div class="form-group">
    						<input type="password" name="newUserPwd" class="form-control" id="newUserPwd" placeholder="请输入新密码">
  						</div>
  						<div class="form-group">
    						<input type="password" name="confirmPwd" class="form-control" id="confirmPwd" placeholder="请再次确认密码">
  						</div>
  						<button type="button" id="btn_submitChangeUserPwd" class="btn btn-default">提交</button>
					</form>
    			</div>
			</div>
		</div>
	</div>