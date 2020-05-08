<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>部门架构管理</title>
	<link href="/static/css/department/departmentDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation" class="active"><a href="#">部门架构</a></li>
  				<li role="presentation"><a href="#">级别架构</a></li>
			</ul>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/department/departmentList.do">
					<c:forEach items="${departmentLevelList }" var="departmentLevel">
						<label>${departmentLevel.levelDesc }</label>
						<select class="form-control" id="input-selectDeptLevel"  name="dlId">
    						<option value="" disabled selected hidden>请选择</option>
    						<c:forEach items="${firstDepartmentList }" var="firstDepartment">
    							<c:choose>
    								<c:when test="${dlIdStr == firstDepartment.dlId }">
    									<option value="${dlIdStr }" selected = "selected">${firstDepartment.deptName }</option>
    								</c:when>
    								<c:otherwise>
    								<option value="${firstDepartment.deptId }">${firstDepartment.deptName }</option>
    							</c:otherwise>
    							</c:choose>
    						</c:forEach>
						</select>
					</c:forEach>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectDept" type="submit" class="btn btn-danger">查询</button>
  					<button id="btn-addDept" type="button" class="btn btn-success">添加部门</button>
  					<button id="btn-addDept" type="button" class="btn btn-success">部门级别管理</button>
				</form>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>部门ID</th>
						<th>部门名称</th>
						<th>部门级别</th>
						<th>部门主管</th>
						<th>部门人数</th>
						<th>上级部门</th>
						<th>状态</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>详情</th>
						<th style="width:150px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="department">
						<tr>
							<td>${department.deptId }</td>
							<td>${department.deptName }</td>
							<td>${department.dlLeve }级</td>
							<td>
								<a href="#" class="a-manageEmpName">${department.manageEmpName }</a>
								<i style="display:none;">${department.manageEmpjobid }</i>
							</td>
							<td>${department.deptEmpnum }</td>
							<td>${department.parentDeptName }</td>
							<td class="td-hideContent">${department.statusName }</td>
							<td><fmt:formatDate value="${department.lastOperatorDate }" type="both"/></td>
							<td>
								<a href="#" class="a-operatorEmpName">${department.operatorEmpName }</a>
								<i style="display:none;">${department.operatorEmpjobid }</i>
							</td>
							<td>
								<a class="a_deptDetail" href="/department/detail.do">
					    			<span class="label label-primary">详情</span>
					    		</a>
					    	</td>
					    	<td>
								<a class="a_deptStatus" href="#" style="text-decoration:none;">
					    			<span class="label label-primary">状态管理</span>
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
</html>