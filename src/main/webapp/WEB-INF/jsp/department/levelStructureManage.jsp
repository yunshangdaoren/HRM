<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>部门架构管理</title>
	<link href="/static/css/department/levelStructureManage.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation"><a href="/departmentLevel/departmentStructureManage.do">部门架构管理</a></li>
  				<li role="presentation" class="active"><a href="/departmentLevel/levelStructureManage.do"">级别架构管理</a></li>
			</ul>
			<div class="div_search">
				<button id="btn-addDept" type="button" class="btn btn-success">添加级别</button>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>级别ID</th>
						<th>级别值</th>
						<th>级别描述</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th style="width:150px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="departmentLevel">
						<tr>
							<td>${departmentLevel.dlId }</td>
							<td>${departmentLevel.level }</td>
							<td>${departmentLevel.levelDesc }</td>
							<td><fmt:formatDate value="${departmentLevel.lastOperatorDate }" type="both"/></td>
							<td>
								<a href="#" class="a-operatorEmpName">${departmentLevel.operatorEmpName }</a>
								<i style="display:none;">${departmentLevel.operatorEmpjobid }</i>
							</td>
							<td>
								<a class="a_deptDetail" href="/department/detail.do">
					    			<span class="label label-primary">修改</span>
					    		</a>
					    		<a class="a_deptStatus" href="#" style="text-decoration:none;">
					    			<span class="label label-primary">删除</span>
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