<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职工离职申请</title>
	<link href="/static/css/employee/addEmployeeResignInfo.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">职工离职申请</span>
			<div class="div_search">
  				<button id="btn-reback" type="button" class="btn btn-success">返回</button>
  				<button id="btn-updateEmployee" type="submit" class="btn btn-danger">修改</button>
			</div>
			<div class="div_addEmployeeResignInfo">
				<form style="width:100%;" id="form-addEmployeeResignInfo" class="form-horizontal" role="form">
    				<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工工号</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="empJobId" value="${employee.empJobid }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工姓名</label>
    					<div class="col-sm-8">
      						<input type="text" readonly="readonly" class="form-control" name="empSexName" value="${employee.empName }">
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工所属部门</label>
    					<div class="col-sm-8">
    						<select class="form-control" id="input-selectDeptLevel"  name="deptId">
    							<c:forEach items="${employee.departmentList }" var="department">
    								<option value="${department.deptId }">${department.deptName }</option>
    							</c:forEach>
							</select>
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">职工所属职位</label>
    					<div class="col-sm-8">
      						<div class="col-sm-8">
    						<select class="form-control" id="input-selectDeptLevel"  name="positionId">
    							<c:forEach items="${employee.positionList }" var="position">
    								<option value="${position.positionId }">${position.positionName }</option>
    							</c:forEach>
							</select>
    					</div>
    					</div>
  					</div>
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-2 control-label">离职日期</label>
    					<div class="col-sm-8">
    						<input type="date" class="form-control" name="resignDate">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-2 control-label">离职原因</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="resignReason" id="input-addEmpNote" rows="5"></textarea>
    					</div>
  					</div>
  					
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button id="btn-submitAddEmployeeResignInfo" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/employee/addEmployeeResignInfo.js"></script>
</html>