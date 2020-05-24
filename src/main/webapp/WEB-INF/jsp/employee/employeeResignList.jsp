<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职工离职申请信息</title>
	<link href="/static/css/employee/employeeResignList.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation" class="active"><a href="/employeeResign/toEmployeeResignList.do">所有离职申请单列表</a></li>
  				<li role="presentation"><a href="/employeeResign/toEmployeeResignCheckList.do">待审批离职单列表</a></li>
			</ul>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/employeeResign/toEmployeeResignList.do">
					<div class="form-group">
    					<label for="exampleInputName2">申请单ID</label>
    					<input type="text" class="form-control" name="resignId" id="input-selectResignId" value="${resignIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">职工工号</label>
    					<input type="text" class="form-control"  name="empJobId" id="input-selectEmpJobId" value="${empJobIdStr }">
  					</div>
  					<div class="form-group">
  						<label for="exampleInputEmail2">申请单状态</label>
    					<select class="form-control" id="input-selectEmployeeResignStatusId"  name="statusId">
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
  					<button id="btn-selectEmployeeResign" type="submit" class="btn btn-danger">查询</button>
				</form>
			</div>
			<table class="table table-hover" id="table-employeeResignDtail">
				<thead>
					<tr>
						<th>申请单ID</th>
						<th>职工工号</th>
						<th>职工姓名</th>
						<th>所属部门</th>
						<th>所属职位</th>
						<th>离职日期</th>
						<th>申请日期</th>
						<th>状态</th>
						<th>审批日期</th>
						<th>审批人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="employeeResign">
						<tr>
							<td>${employeeResign.resignId }</td>
							<td>${employeeResign.empJobid }</td>
							<td><a href="#" class="a_detailEmployee">${employeeResign.empName }</a></td>
							<td>
								<label>${employeeResign.deptName }</label>
								<label style="display:none;">${employeeResign.deptId }</label>
							</td>
							<td>
								<label>${employeeResign.positionName }</label>
								<label style="display:none;">${employeeResign.positionId }</label>
							</td>
							<td><fmt:formatDate value="${employeeResign.applyDate }" type="both"/></td>
							<td><fmt:formatDate value="${employeeResign.resignDate }" type="both"/></td>
							<c:choose>
								<c:when test="${contremployeeResignact.statusName =='已审批' }">
									<td style="color:black;">${employeeResign.statusName }</td>
    							</c:when>
    							<c:otherwise>
    								<td style="color:red;">${employeeResign.statusName }</td>
    							</c:otherwise>	
							</c:choose>
							<td><fmt:formatDate value="${employeeResign.checkDate }" type="both"/></td>
							<td>
								<a href="#" class="a-checkEmpName">${employeeResign.checkEmpName }</a>
								<i style="display:none;">${employeeResign.checkEmpjobid }</i>
							</td>
					    	<td>
					    		<a style="text-decoration:none" class="a_detailEmployeeResign" href="#">
					    			<span class="label label-primary">申请单详情</span>
					    		</a>
					    		<a style="text-decoration:none" class="a_detailContract" href="#">
					    			<span class="label label-primary">合同详情</span>
					    		</a>
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
		
</body>
	<script type="text/javascript" src="/static/js/employee/employeeResignList.js"></script>
</html>