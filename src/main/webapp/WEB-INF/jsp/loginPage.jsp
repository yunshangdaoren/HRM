<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!--登录页面-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Login Page</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="/static/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/static/assets/css/now-ui-kit.css?v=1.1.0" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="/static/assets/css/demo.css" rel="stylesheet" /> 
    <link href="/static/css/loginPage.css" rel="stylesheet" />  
    <link href="/static/css/shadeDiv.css" rel="stylesheet" />
</head>
<body  class="login-page sidebar-collapse">
	<%
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().length()>14){
					if(c.getName().substring(0, 14).equals("HRMUserAccount")){
						username = c.getName().replaceAll("HRMUserAccount", "");
						password = c.getValue();
					}
				}
			}
		}
	%>

	 <!-- Navbar -->
    <nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
        <div class="container" style="margin-top: 50px;">
           <h1 style="margin: auto;">人力资源管理系统 </h1>
        </div>
    </nav>
    
    <!-- End Navbar -->
    <div class="page-header" filter-color="orange">
        <div class="page-header-image" style="background-image:url(/static/assets/img/login.jpg)"></div>
        <div class="container">
            <div class="col-md-6 content-center">
                <div class="card card-login card-plain" style="width:410px;">
                    <form class="form" id="form_login">
                        <div class="content" style="margin:0px;padding:0px;">
                            <div class="input-group form-group-no-border input-lg" style="margin-bottom:15px;">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
                                <input type="text" id="userAccount" name="userAccount" class="form-control" placeholder="Enter your account..." value="<%=username %>">
                            </div>
                            <div class="input-group form-group-no-border input-lg" style="margin-bottom:15px;">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
                                <input type="password" id="userPwd" name="userPwd" placeholder="Enter your password..." class="form-control" value="<%=password %>" />
                            </div>
                        </div>
                        <!-- 如果登录不成功，则提示用户，账户或密码错误 -->
                        <p class="p_erroLoginFail" style="color:red;font-size:16px;margin:0px;padding:0px;"></p>
                        <div class="footer text-center" style="padding-top:0px;">
                        	<div>
                        		<div style="float:left;width:50%;text-align: center;">
                        			<input class="remember" type="checkbox" name="remember" value="1" checked="checked"/><b>记住密码</b>
                        		</div>
                        		<div style="float:right;width:50%;">
                        			<span class="span_fogetPwd">忘记密码？</span>
                        		</div>
                        	</div>
                            <input style="margin-top:4px;" type="button" id="loginSubmit" class="btn btn-primary btn-round btn-lg btn-block" value="登录"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <div class="copyright" style="font-size: 15px;">
                    &copy;
                    <script>
                        document.write(new Date().getFullYear())
                    </script> luckylas@163.com All Rights Reserved
                   <!--  <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> -->
                </div>
            </div>
        </footer>
    </div>
    
    <!-- 遮罩层，用于编辑联系人信息 -->
	<div class="shadeDiv">
		<div class="panel_resetPwd">
			<div class="panel">
    			<div class="panel-heading">
    				<label>找回密码</label>
    				<button id="btn_hideShadeDiv" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form id="form_retrievePwd" class="form-horizontal" role="form">
    					<div class="form-group">
    						<div class="col-sm-12">
      							<input type="text" name="userAccount" id="find_UserAccount" placeholder="请输入账户">
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-12">
      							<input type="text" name="securityMail" id="securityMail" placeholder="请输入绑定的安全邮箱">
    						</div>
  						</div>
      					<span style="color:red;">如果没有邮箱，请联系管理员。</span>
    					<div class="form-group">
    						<div class="col-sm-12">
      							<input type="text" name="emailVerificationCode" id="emailVerificationCode" style="width:180px;display:inline-block;" placeholder="请输入邮箱验证码">
      							<div id="btn_sendEmailVerificationCode" class="btn btn-primary">发送验证码</div>
    						</div>
  						</div>
      					<div class="form-group">
    						<div class="col-sm-12">
      							<input type="password" name="newUserPwd" id="newUserPwd" placeholder="请输入新密码">
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-12">
      							<input type="password" name="confirmPwd" id="confirmPwd" placeholder="请再次确认密码">
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-6 col-sm-6">
      							<button id="btn_submitRetrievePwd" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
    			</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/js/loginPage.js"></script> 
<script type="text/javascript" src="/static/js/shadeDiv.js"></script> 
<!--   Core JS Files   -->
<script src="/static/assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="/static/assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="/static/assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="/static/assets/js/plugins/bootstrap-switch.js"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/static/assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Plugin for the DatePicker, full documentation here: https://github.com/uxsolutions/bootstrap-datepicker -->
<script src="/static/assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
<!-- Share Library etc -->
<script src="/static/assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<!-- Control Center for Now Ui Kit: parallax effects, scripts for the example pages etc -->
<script src="/static/assets/js/now-ui-kit.js?v=1.1.0" type="text/javascript"></script>

</html>
