<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>合同信息</title>
	<link href="/static/css/contract/addContract.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">合同信息</span>
			<div class="div_addContract">
				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        			<li class="list-group-item"><label>职工姓名：</label><span class="span-empName">${contract.empName }</span></li>
        			<li class="list-group-item"><label>职工身份证号：</label><span class="span-empIdcard">${contract.empIdcard }</span></li>
        			<li class="list-group-item"><label>合同所属部门：</label><span class="span-deptName">${contract.deptName }</span></li>
        			<li class="list-group-item"><label>合同所属职位：</label><span class="span-positionName">${contract.positionName }</span></li>
        			<li class="list-group-item"><label>合同开始日期：</label><span class="span-beginDate"><fmt:formatDate value="${contract.beginDate }" type="both"/></span></li>
        			<li class="list-group-item"><label>合同结束日期：</label><span class="span-endDate"><fmt:formatDate value="${contract.endDate }" type="both"/></span></li>
       				<li class="list-group-item"><label>合同月薪：</label><span class="span-monthlySalary">${contract.monthlySalary }</span></li>
       				<li class="list-group-item"><label>合同签订日期：</label><span class="span-signDate"><fmt:formatDate value="${contract.entryTime }" type="both"/></span></li>
   					<li class="list-group-item"><label>备注：</label><span class="span-note"></span>${contract.note }</li>
   				</ul>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/contract/addContract.js"></script>
</html>