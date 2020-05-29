<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>账户信息修改</title>
	<link href="/static/css/system/updateUserInfo.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">账户信息修改</span>
			<div class="div_search">
  				<button id="btn-reback" type="button" class="btn btn-success">返回</button>
			</div>
			<div class="div_addEmployeeInfo">
				<form style="width:100%;" id="form-updateUserInfo" class="form-horizontal" role="form">
    				<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">账户</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="userAccount" value="${user.userAccount }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">密码</label>
    					<div class="col-sm-8">
      						<input type="text"  class="form-control" name="userPwd" value="${user.userPwd }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">用户名称</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="userName" value="${user.userName }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">安全邮箱</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="securityMail" value="${user.securityMail }">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">账户状态</label>
    					<div class="col-sm-8">
      						<select class="form-control" name="statusId" id="select-userStatus">
      							<c:forEach items="${statusList }" var="status">
    								<option value="${status.statusId }">${status.statusName }</option>
    							</c:forEach>
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-3 col-sm-10">
      						<button id="btn-submitUpdateUserInfo" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/system/updateUserInfo.js"></script>
</html>