<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职工花名册</title>
	<link href="/static/css/employee/employeeList.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">职工花名册</span>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/employee/toEmployeeList.do">
					<div class="form-group">
    					<label for="exampleInputName2">职工工号</label>
    					<input type="text" class="form-control" name="empJobId" id="input-selectDeptId" value="${empJobIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">职工名称</label>
    					<input type="text" class="form-control"  name="empName" id="input-selectDeptName" value="${empNameStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputEmail2">所属部门名称</label>
    					<input type="text" class="form-control"  name="deptName" id="input-selectDeptManageName" value="${deptNameStr }">
  					</div>
  					<div class="form-group">
  						<label for="exampleInputEmail2">职工状态</label>
    					<select class="form-control" id="input-selectDeptLevel"  name="statusId">
    						<option value="" disabled selected>请选择</option>
    						<c:forEach items="${statusList }" var="status">
    							<c:choose>
    								<c:when test="${statusIdStr == status.statusId }">
    									<option value="${statusIdStr }" selected = "selected">${status.statusName }</option>
    								</c:when>
    								<c:otherwise>
    								<option value="${status.statusId }">${status.statusName }</option>
    							</c:otherwise>
    							</c:choose>
    						</c:forEach>
						</select>
  					</div>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectDept" type="submit" class="btn btn-danger">查询</button>
  					<c:if test="${roles.roleId!=3 }">
  						<button id="btn-entryContract" type="button" class="btn btn-success">职工入职</button>
  					</c:if>
				</form>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>职工工号</th>
						<th>职工姓名</th>
						<th>职工性别</th>
						<th>职工联系方式</th>
						<th>职工所属部门</th>
						<th>职工职位</th>
						<th>职工入职时间</th>
						<th>状态</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="employee">
						<tr>
							<td>${employee.empJobid }</td>
							<td>${employee.empName }</td>
							<td>${employee.empSex==0?"女":"男" }</td>
							<td>${employee.empPhone }</td>
							<%-- <c:choose>
    							<c:when test="${employee.departmentList!=null && fn:length(employee.departmentList) > 1 }">
    								<td>
    									<a class="a_moreDetailEmployeeDeptName" href="#" style="text-decoration:none;">
					    				<span class="label label-primary" id="span_seeDetailEmployeeDeptName">查看</span>
					    			</a>
    								</td>
    							</c:when>
    							<c:otherwise>
    								<td>${employee.deptNameListStr }</td>
    							</c:otherwise>
    						</c:choose> --%>
    						<td><a class="a_departmentDetail" href="#" style="text-decoration:none;">${employee.deptNameListStr }</a></td>
							<td><a class="a_positionDetail" href="#" style="text-decoration:none;">${employee.positionNameListStr }</a></td>
							<td><fmt:formatDate value="${employee.entryTime }" type="both"/></td>
							<td class="td-hideContent">${employee.statusName }</td>
							<td><fmt:formatDate value="${employee.lastOperatorDate }" type="both"/></td>
							<td>
								<c:choose>
									<c:when test="${roles.roleId==3 }">
										<a href="#" class="a_detailOperatorEmployeeByNormalEmployee">${employee.operatorEmpName }</a>
									</c:when>
									<c:otherwise>
										<a href="#" class="a_detailOperatorEmployeeByManagerEmployee">${employee.operatorEmpName }</a>
									</c:otherwise>
								</c:choose>
								<i style="display:none;">${employee.operatorEmpjobid }</i>
							</td>
					    	<td>
					    		<c:choose>
									<c:when test="${roles.roleId==3 }">
										<a class="a_detailEmployeeByNormalEmployee" href="#">
					    					<span class="label label-primary">详情</span>
					    				</a>
									</c:when>
									<c:otherwise>
										<a class="a_detailEmployeeByManagerEmployee" href="#">
					    					<span class="label label-primary">详情</span>
					    				</a>
									</c:otherwise>
								</c:choose>
					    		<c:if test="${roles.roleId!=3 }">
  									<a class="a_updateDepartment" href="#" style="text-decoration:none;">
					    				<span class="label label-primary">修改</span>
					    			</a>
  								</c:if>
					    	</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- 查询内容为空提示 -->
			<%@ include file="../prompt_empty.jsp" %>
			<!-- 分页代码 -->
			<div class="pageNav">
				<ul class="pagination">
					<li>
    					<a href="#" class="a-indexPage">首页</a>
					</li>
    				<li>
    					<a href="#" class="a-prePage">上一页</a>
    				</li>
    				<li>
    					<span style="line-height:1.42857143;" class="span-currentPage">当前第${pageResult.pageNum }页</span>
    					<i style="display:none;" class="i-pageNum">${pageResult.pageNum }</i>
    				</li> 
    				<li>
    					<a href=#" class="a-nextPage">下一页</a>
    				</li>
    				<li>
    					<a href="#" class="a-endPage">尾页</a>
    					<i style="display:none;" class="i-totalPages">${pageResult.totalPages }</i>
    				</li>
    				<li>
    					<span style="line-height:1.42857143;" class="span-totalPages">共${pageResult.totalPages }页</span>
    				</li>
				</ul>
				<div class="input-group" style="width:146px;float:right;">
					<input id="input-pageNum" type="text" class="form-control" style="z-index:0;">
        			<span id="span-jumPageNum" class="input-group-addon" style="cursor:pointer;" >跳转至该页</span>
 				</div>
			</div>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
		
		<!-- 弹出遮罩层，用于显示职工详细信息 -->
		<div class="panel_employeeDetail" style="display:none;">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>职工详细信息</label>
    				<button id="btn-hidePanelEmployeeDetail" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        				<li class="list-group-item"><label>工号：</label><span class="span-empJobId"></span></li>
        				<li class="list-group-item"><label>姓名：</label><span class="span-empName"></span></li>
        				<li class="list-group-item"><label>性别：</label><span class="span-empSex"></span></li>
        				<li class="list-group-item"><label>联系电话：</label><span class="span-empPhone"></span></li>
        				<li class="list-group-item"><label>入职时间：</label><span class="span-empEntryTime"></span></li>
       					<li class="list-group-item"><label>所属部门：</label><span class="span-deptName"></span></li>
       					<li class="list-group-item"><label>状态：</label><span class="span-empStatus"></span></li>
   					</ul>
    			</div>
			</div>
		</div>
		
</body>
	<script type="text/javascript" src="/static/js/employee/employeeList.js"></script>
</html>