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
    <script type="text/javascript" src="/static/js/jquery.min.js"></script>  
    <script type="text/javascript" src="/static/js/loginFormCheck.js"></script> 
</head>
<body  class="login-page sidebar-collapse">
	<%
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("userAccount")){
					username = c.getValue();
				}
				if(c.getName().equals("userPwd")){
					password = c.getValue();
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
                    <form class="form" action="<%=request.getContextPath() %>/login/login.do"  method="get" onsubmit="return loginFormEmptyCheck()">
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
                                <input type="text" id="userPwd" name="userPwd" placeholder="Enter your password..." class="form-control" value="<%=password %>" />
                            </div>
                        </div>
                        <!-- 如果登录不成功，则提示用户，>账户或密码错误 -->
                        <p style="color:red;font-size:16px;margin:0px;padding:0px;">${msg_loginFail }</p>
                        <div class="footer text-center" style="padding-top:0px;">
                        	<div>
                        		<div style="float:left;width:50%;text-align: center;">
                        			<input class="remember" type="checkbox" name="remember" value="1" checked="checked"/><b>记住密码？</b>
                        		</div>
                        		<div style="float:right;width:50%;">
                        			<a href="#pablo" class="link" style="font-size:14px;" >忘记密码?</a>
                        		</div>
                        	</div>
                            <input style="margin-top:4px;" type="submit" id="loginSubmit" class="btn btn-primary btn-round btn-lg btn-block" value="登录"/>
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
</body>
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
