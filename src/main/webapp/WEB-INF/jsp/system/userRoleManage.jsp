<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>权限管理</title>
	<link href="/static/css/department/levelStructureManage.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation"><a href="/userRole/toUserRoleList.do">用户角色列表</a></li>
  				<li role="presentation" class="active"><a href="/userRole/toUserRoleManage.do">用户角色管理</a></li>
			</ul>
			<div class="div_search">
				<button id="btn-addDepartmentLevel" type="button" class="btn btn-success">添加角色</button>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>角色ID</th>
						<th>角色名字</th>
						<th>角色描述</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="roles">
						<tr>
							<td>${roles.roleId }</td>
							<td>${roles.roleName }</td>
							<td>${roles.roleDesc }</td>
							<td><fmt:formatDate value="${roles.lastOperatorDate }" type="both"/></td>
							<td>
								<a href="#" class="a_detailOperatorEmployeeByManagerEmployee">${roles.operatorEmpName }</a>
								<i style="display:none;">${roles.operatorEmpjobid }</i>
							</td>
							<td>
								<a href="#" class="a-updateDepartmentLevel" style="text-decoration:none;">
					    			<span class="label label-primary">修改</span>
					    		</a>
					    		<a href="#" class="a-deleteDepartmentLevel" href="#" style="text-decoration:none;">
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
	
	<!-- 弹出遮罩层，用于添加部门级别信息 -->
	<div class="panel_addDepartmentLevel">
		<div class="div-panel">
    		<div class="panel-heading">
    			<label>添加级别信息</label>
    			<button id="btn-hidePanelAddDepartmentLevel" type="button" class="btn btn-success">退出</button>
    		</div>
    		<div class="panel_body">
    			<form style="width:100%;" id="form-addDepartmentLevel" class="form-horizontal" role="form">
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">级别值</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="level" id="input-addLevel">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">级别描述</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="levelDesc" id="input-addLevelDesc" rows="4"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">备注</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="levelNote" id="input-addLevelNote" rows="7"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-3 col-sm-9">
      						<button id="btn-submitAddDepartmentLevel" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
    		</div>
		</div>
	</div>
		
	<!-- 弹出遮罩层，用于显示职职工详细信息 -->
	<div class="panel_employeeDetail">
		<div class="div-panel">
    		<div class="panel-heading">
    			<label>职工详细信息</label>
    			<button id="btn-hidePanelEmployeeDetail" type="button" class="btn btn-success">退出</button>
    		</div>
    		<div class="panel_body">
    			<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        			<li class="list-group-item"><label>职工工号：</label><span class="span-empJobId"></span></li>
        			<li class="list-group-item"><label>职工姓名：</label><span class="span-empName"></span></li>
        			<li class="list-group-item"><label>职工性别：</label><span class="span-empSex"></span></li>
        			<li class="list-group-item"><label>职工联系电话：</label><span class="span-empPhone"></span></li>
        			<li class="list-group-item"><label>职工入职时间：</label><span class="span-empEntryTime"></span></li>
       				<li class="list-group-item"><label>职工所属部门：</label><span class="span-deptName"></span></li>
       				<li class="list-group-item"><label>职工状态：</label><span class="span-empStatus"></span></li>
   				</ul>
    		</div>
		</div>
	</div>
		
	<!-- 弹出遮罩层，用于修改部门级别信息 -->
	<div class="panel_updateDepartmentLevel">
		<div class="div-panel">
    		<div class="panel-heading">
    			<label>修改级别信息</label>
    			<button id="btn-hidePanelUpdateDepartmentLevel" type="button" class="btn btn-success">退出</button>
    		</div>
    		<div class="panel_body">
    			<form style="width:100%;" id="form-updateDepartmentLevel" class="form-horizontal" role="form">
    				<input type="text" style="display:none;" name="dlId" id="input-updateDlId">
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">级别值</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="level" id="input-updateLevel">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">级别描述</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="levelDesc" id="input-updateLevelDesc" rows="4"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">备注</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="levelNote" id="input-updateLevelNote" rows="7"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-3 col-sm-9">
      						<button id="btn-submitUpdateDepartmentLevel" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
    		</div>
		</div>
	</div>
</body>
	<script type="text/javascript" src="/static/js/department/levelStructureManage.js"></script>
</html>