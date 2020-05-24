<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职工详细信息</title>
	<link href="/static/css/employee/employeeDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">职工详细信息</span>
			<div class="div_search">
  				<button id="btn-reback" type="button" class="btn btn-success">返回</button>
  				<button id="btn-updateEmployee" type="submit" class="btn btn-danger">修改</button>
			</div>
			<div class="div_employeeDetail">
				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
					<li class="list-group-item"><label>职工工号：</label><span class="span-empName">${employee.empJobid }</span></li>
        			<li class="list-group-item"><label>职工姓名：</label><span class="span-empName">${employee.empName }</span></li>
        			<li class="list-group-item"><label>职工性别：</label><span class="span-empName">${employee.empSexName }</span></li>
        			<li class="list-group-item"><label>职工所属部门：</label><span class="span-empName">${employee.deptNameListStr }</span></li>
        			<li class="list-group-item"><label>职工所属职位：</label><span class="span-empName">${employee.positionNameListStr }</span></li>
        			<li class="list-group-item"><label>职工出生日期：</label><span class="span-empName">${employee.empBirthday }</span></li>
        			<li class="list-group-item"><label>职工身份证号码：</label><span class="span-empName">${employee.empIdcard }</span></li>
       				<li class="list-group-item"><label>职工联系电话：</label><span class="span-empName">${employee.empPhone }</span></li>
       				<li class="list-group-item"><label>职工邮箱：</label><span class="span-empName">${employee.empEmail }</span></li>
       				<li class="list-group-item"><label>职工学历：</label><span class="span-empName">${employee.empEducation }</span></li>
       				
       				<li class="list-group-item"><label>职工家庭住址：</label><span class="span-empName">${employee.empAddress }</span></li>
       				<li class="list-group-item"><label>职工状态：</label><span class="span-empName">${employee.statusName }</span></li>
       				<li class="list-group-item"><label>备注：</label><span class="span-empName">${employee.empNote }</span></li>
   				</ul>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/employee/employeeDetail.js"></script>
</html>