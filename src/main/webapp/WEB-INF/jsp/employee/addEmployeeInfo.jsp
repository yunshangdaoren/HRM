<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职工信息填写</title>
	<link href="/static/css/employee/addEmployeeInfo.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">职工信息填写</span>
			<div class="div_addEmployeeInfo">
				<form style="width:100%;" id="form-addEmployeeInfo" class="form-horizontal" role="form">
					<input type="text" style="display:none;" class="form-control" name="conId" value="${contract.conId }">
    				<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工姓名</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="empName" value="${contract.empName }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工性别</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="empSexName" value="${contract.empSexName }">
      						<input type="text" style="display:none;" class="form-control" name="empSex" value="${contract.empSex }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工所属部门</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="deptName" value="${contract.deptName }">
      						<input type="text" style="display:none;" class="form-control" name="deptId" value="${contract.deptId }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工所属职位</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="positionName" value="${contract.positionName }">
      						<input type="text" style="display:none;" class="form-control" name="positionId" value="${contract.positionId }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工出生日期</label>
    					<div class="col-sm-8">
    						<input type="text" readonly="readonly" class="form-control" name="empBirthday" value="${empBirthdayStr }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工身份证号码</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="empIdcard" value="${contract.empIdcard }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工联系电话</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="empPhone">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工邮箱</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="empEmail">
    					</div>
  					</div>
  					
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工学历</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="empEducation">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工家庭住址</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="empAddress">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-2 control-label">职工状态</label>
    					<div class="col-sm-8">
      						<select class="form-control" name="statusId" id="select-addDeptStatus">
      							<c:forEach items="${statusList }" var="status">
    								<option value="${status.statusId }">${status.statusName }</option>
    							</c:forEach>
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-2 control-label">备注</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="empNote" id="input-addEmpNote" rows="5"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button id="btn-submitAddEmployeeInfo" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/employee/addEmployeeInfo.js"></script>
</html>