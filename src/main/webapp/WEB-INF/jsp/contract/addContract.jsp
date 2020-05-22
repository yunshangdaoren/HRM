<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>添加合同</title>
	<link href="/static/css/contract/addContract.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">添加合同</span>
			<div class="div_addContract">
				<form style="width:100%;" id="form-addContract" class="form-horizontal" role="form">
    					<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职工姓名</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="empName" id="input-empName">
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职工性别</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="empSex" >
      								<option value="1" selected="selected">男</option>
      								<option value="0">女</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职工身份证号</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="empIdcard" id="input-empIdcard">
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">合同所属部门</label>
    						<div class="col-sm-8" id="div-infoDeptName">
      							<input type="text" class="form-control" name="deptName" id="input-addDeptName" placeholder="请输入合同所属部门名称">
      							<input type="text" style="display:none;" name="deptId" id="input-addDeptId">
    							<select multiple class="form-control" id="select-deptId" name="deptId">
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">合同所属职位</label>
    						<div class="col-sm-8" id="div-parentPositionName">
      							<input type="text" class="form-control" name="positionName" id="input-addPositionName" placeholder="请输入合同所属职位名称">
      							<input type="text" style="display:none;" name="positionId" id="input-addPositionId">
    							<select multiple class="form-control" id="select-positionId" name="positionId" >
								</select>
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">合同开始日期</label>
    						<div class="col-sm-8">
      							<input type="date" class="form-control" name="beginDate" id="input-beginDate">
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">合同结束日期</label>
    						<div class="col-sm-8">
      							<input type="date" class="form-control" name="endDate" id="input-endDate">
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">合同月薪</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="monthlySalary"id="input-monthlySalary" >
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">合同签订日期</label>
    						<div class="col-sm-8">
      							<input type="date" class="form-control" name="signDate"id="input-signDate" >
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">备注</label>
    						<div class="col-sm-8">
      							<textarea class="form-control" name="note" id="input-addNote" rows="5"></textarea>
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-3 col-sm-9">
      							<button id="btn-submitAddContract" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/contract/addContract.js"></script>
</html>