<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>用户角色列表</title>
	<link href="/static/css/system/userRoleList.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation" class="active"><a href="/userRole/toUserRoleList.do">用户角色列表</a></li>
  				<!-- <li role="presentation"><a href="/userRole/toUserRoleManage.do">用户角色管理</a></li> -->
			</ul>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/userRole/toUserRoleList.do">
					<div class="form-group">
    					<label for="exampleInputName2">职工工号</label>
    					<input type="text" class="form-control" name="empJobId" id="input-selectDeptId" value="${empJobIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">角色ID</label>
    					<input type="text" class="form-control"  name="roleId" id="input-selectDeptName" value="${roleIdStr }">
  					</div>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectDept" type="submit" class="btn btn-danger">查询</button>
				</form>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>用户工号</th>
						<th>用户姓名</th>
						<th>角色ID</th>
						<th>角色名称</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="userRole">
						<tr>
							<td>${userRole.userAccount }</td>
							<td>${userRole.userName }</td>
							<td>${userRole.roleId }</td>
							<td>${userRole.roleName }</td>
							<td><fmt:formatDate value="${userRole.lastOperatorDate }" type="both"/></td>
							<td>
								<a href="#" class="a_detailOperatorEmployeeByManagerEmployee">${userRole.operatorEmpName }</a>
								<i style="display:none;">${userRole.operatorEmpjobid }</i>
							</td>
					    	<td>
  								<a class="a_updateUserRole" href="#" style="text-decoration:none;">
					    			<span class="label label-primary">修改</span>
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
		
		<!-- 弹出遮罩层，用于修改职工角色信息 -->
	<div class="panel_updateUserRole">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>修改用户角色信息</label>
    				<button id="btn-hidePanelUpdateUserRole" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form style="width:100%;margin-top:20px;" id="form-updateUserRole" class="form-horizontal" role="form">
    					<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职工工号</label>
    						<div class="col-sm-8">
      							<input type="text" readonly="readonly" class="form-control" name="empJobId" id="input-empJobId">
    						</div>
  						</div>
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职工姓名</label>
    						<div class="col-sm-8">
      							<input type="text" readonly="readonly" class="form-control" name="empName" id="input-empName">
    						</div>
  						</div>
  						<input type="text" readonly="readonly" style="display:none;" class="form-control" name="oldRoleId" id="input-oldRoleId">
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">角色类型</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="roleId" id="select-updateUserRole">
      								<option value="" disabled selected hidden>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-3 col-sm-9">
      							<button id="btn-submitUpdateUserRole" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
    			</div>
			</div>
		</div>
		
</body>
	<script type="text/javascript" src="/static/js/system/userRoleList.js"></script>
</html>