<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职位详细信息</title>
	<link href="/static/css/employee/employeeDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation"><a href="/position/positionList.do">职位详情</a></li>
  				<c:if test="${roles.roleId!=1 }">
  					<li role="presentation"  class="active"><a href="/position/toMyPositionDetail.do">我的职位信息</a></li>
  				</c:if>
			</ul>
			<div class="div_employeeDetail">
				<c:forEach items="${positionList }" var="position">
					<ul class="list-group" style="width:100%;height:100%;overflow:auto;margin-top:10px;border-top:2px solid blue;">
        				<li class="list-group-item"><label>职位id：</label><span class="span-positionId">${position.positionId }</span></li>
        				<li class="list-group-item"><label>职位名称：</label><span class="span-positionName">${position.positionName }</span></li>
        				<li class="list-group-item"><label>职位级别：</label><span class="span-plLevelDesc">${position.plLeve }级</span></li>
        				<li class="list-group-item"><label>职位所属部门：</label><span class="span-deptName">${position.deptName }</span></li>
        				<li class="list-group-item"><label>上级职位：</label><span class="span-parentPositionName">${position.parentPositionName }</span></li>
       					<li class="list-group-item"><label>状态：</label><span class="span-statusName">${position.statusName }</span></li>
       					<li class="list-group-item"><label>职位描述：</label><span class="span-positionDesc">${position.positionDesc }</span></li>
       					<li class="list-group-item"><label>最后一次操作时间：</label><span><fmt:formatDate value="${position.lastOperatorDate }" type="both"/></span></li>
       					<li class="list-group-item"><label>操作人：</label><span class="span-operatorEmpName">${position.operatorEmpName }</span></li>
   					</ul>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
</body>
	<script type="text/javascript" src="/static/js/employee/employeeDetail.js"></script>
</html>