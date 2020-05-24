<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>离职申请单详细信息</title>
	<link href="/static/css/contract/detailContract.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">离职申请单详细信息</span>
			<div class="div_search">
  				<button id="btn-reback" type="button" class="btn btn-success">返回</button>
  				<button id="btn-updateContract" type="submit" class="btn btn-danger">修改</button>
			</div>
			<div class="div_detailContract">
				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        			<li class="list-group-item"><label>申请单Id：</label><span class="span-empName">${employeeResign.resignId }</span></li>
        			<li class="list-group-item"><label>职工工号：</label><span class="span-empIdcard">${employeeResign.empJobid }</span></li>
        			<li class="list-group-item"><label>职工姓名：</label><span class="span-deptName">${employeeResign.empName }</span></li>
        			<li class="list-group-item"><label>所属部门：</label><span class="span-positionName">${employeeResign.deptName }</span></li>
        			<li class="list-group-item"><label>所属职位：</label><span class="span-beginDate">${employeeResign.positionName }</span></li>
        			<li class="list-group-item"><label>离职日期：</label><span class="span-endDate"><fmt:formatDate value="${employeeResign.resignDate }" type="both"/></span></li>
       				<li class="list-group-item"><label>申请日期：</label><span class="span-endDate"><fmt:formatDate value="${employeeResign.applyDate }" type="both"/></span></li>
       				<li class="list-group-item"><label>离职原因：</label><span class="span-deptName">${employeeResign.resignReason }</span></li>
       				<li class="list-group-item"><label>备注：</label><span class="span-signDate"><fmt:formatDate value="${employeeResign.note }" type="both"/></span></li>
       				<li class="list-group-item"><label>状态：</label>
       					<c:choose>
								<c:when test="${employeeResign.statusName =='已审批' }">
									<span style="color:green;">${employeeResign.statusName }</span>
    							</c:when>
    							<c:otherwise>
    								<span class="span-statusName" style="color:red;">${employeeResign.statusName }</span>
    							</c:otherwise>	
							</c:choose>
       				</li>
       				<li class="list-group-item"><label>审批日期：</label><span class="span-checkDate"><fmt:formatDate value="${employeeResign.checkDate }" type="both"/></span></li>
   					<li class="list-group-item"><label>审批人：</label><span class="span-note"></span>${employeeResign.checkEmpName }</li>
   				</ul>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/contract/detailContract.js"></script>
</html>