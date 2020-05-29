<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>部门详细信息</title>
	<link href="/static/css/employee/employeeDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">部门详细信息</span>
			<div class="div_search">
  				<button id="btn-reback" type="button" class="btn btn-success">返回</button>
  				<button id="btn-updateEmployee" type="submit" class="btn btn-danger">修改</button>
			</div>
			<div class="div_employeeDetail">
				<c:forEach items="${departmentList }" var="department">
					<ul class="list-group" style="width:100%;height:100%;overflow:auto;margin-top:10px;border-top:2px solid blue;">
        				<li class="list-group-item"><label>部门id：</label><span class="span-deptId">${department.deptId }</span></li>
        				<li class="list-group-item"><label>部门名称：</label><span class="span-deptName">${department.deptName }</span></li>
        				<li class="list-group-item"><label>部门级别：</label><span class="span-dlLevel">${department.dlLeve }级</span></li>
        				<li class="list-group-item"><label>部门主管人：</label><span class="span-manageEmpName">${department.manageEmpName }</span></li>
        				<li class="list-group-item"><label>部门人数：</label><span class="span-deptEmpnum">${department.deptEmpnum }</span></li>
       					<li class="list-group-item"><label>上级部门：</label><span class="span-parentDeptName">${department.parentDeptName }</span></li>
       					<li class="list-group-item"><label>部门描述：</label><span class="span-deptDesc">${department.deptDesc }</span></li>
       					<li class="list-group-item"><label>最后一次操作时间：</label><span><fmt:formatDate value="${department.lastOperatorDate }" type="both"/></span></li>
       					<li class="list-group-item"><label>操作人：</label><span class="span-operatorEmpName">${department.operatorEmpName }</span></li>
   					</ul>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/employee/employeeDetail.js"></script>
</html>