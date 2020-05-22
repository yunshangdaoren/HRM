<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/department/departmentList.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">部门详情</span>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/department/departmentList.do">
					<div class="form-group">
    					<label for="exampleInputName2">部门ID</label>
    					<input type="text" class="form-control" name="deptId" id="input-selectDeptId" value="${deptIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">部门名称</label>
    					<input type="text" class="form-control"  name="deptName" id="input-selectDeptName" value="${deptNameStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputEmail2">部门主管人姓名</label>
    					<input type="text" class="form-control"  name="manageEmpName" id="input-selectDeptManageName" value="${manageEmpNameStr }">
  					</div>
  					<div class="form-group">
  						<label for="exampleInputEmail2">部门级别</label>
    					<select class="form-control" id="input-selectDeptLevel"  name="dlId">
    						<option value="" disabled selected>请选择</option>
    						<c:forEach items="${departmentLevelList }" var="departmentLevel">
    							<c:choose>
    								<c:when test="${dlIdStr == departmentLevel.dlId }">
    									<option value="${dlIdStr }" selected = "selected">${departmentLevel.level }级</option>
    								</c:when>
    								<c:otherwise>
    								<option value="${departmentLevel.dlId }">${departmentLevel.level }级</option>
    							</c:otherwise>
    							</c:choose>
    						</c:forEach>
						</select>
  					</div>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectDept" type="submit" class="btn btn-danger">查询</button>
  					<button id="btn-addDept" type="button" class="btn btn-success">添加部门</button>
				</form>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>部门ID</th>
						<th>部门名称</th>
						<th>部门级别</th>
						<th>部门主管职位</th>
						<th>部门主管人</th>
						<th>部门人数</th>
						<th>上级部门</th>
						<th>状态</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="department">
						<tr>
							<td>${department.deptId }</td>
							<td>${department.deptName }</td>
							<td>${department.dlLeve }级</td>
							<td>
								<a href="#" class="a-managePositionName">${department.managePositionName }</a>
								<i style="display:none;">${department.managePositionid }</i>
							</td>
							<td>
								<a href="#" class="a-manageEmpName">${department.manageEmpName }</a>
								<i style="display:none;">${department.manageEmpJobId }</i>
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
					    		<a class="a_departmentDetail" href="#">
					    			<span class="label label-primary">详情</span>
					    		</a>
								<a class="a_updateDepartment" href="#" style="text-decoration:none;">
					    			<span class="label label-primary">修改</span>
					    		</a>
					    		<a class="a_deleteDepartment" href="#">
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
	
	<!-- 弹出遮罩层，用于添加部门信息 -->
	<div class="panel_addDepartment">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>添加部门信息</label>
    				<button id="btn-hidePanelAddDepartment" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form style="width:100%;" id="form-addDept" class="form-horizontal" role="form">
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">部门名称</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="deptName" id="input-addDeptName">
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="firstname" class="col-sm-3 control-label">部门级别</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="dlId" id="select-addDeptLevel">
      								<option value="" disabled selected hidden>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">上级部门</label>
    						<div class="col-sm-8" id="div-parentDeptName">
      							<input type="text" class="form-control" name="deptName" id="input-addParentDeptName" placeholder="请输入上级部门名称">
      							<input type="text" style="display:none;" name="parentId" id="input-addParentId">
    							<select multiple class="form-control" id="select-deptId" name="deptId">
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">部门主管职位</label>
    						<div class="col-sm-8" id="div-managePositionName">
      							<input type="text" class="form-control" name="managePositionName" id="input-addManagePositionName" placeholder="请输入部门主管职位名称">
      							<input type="text" style="display:none;" name="managePositionid" id="input-addManagePositionid">
    							<select multiple class="form-control" id="select-positionId" name="positionId" >
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">部门状态</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="statusId" id="select-addDeptStatus">
      								<option value="" disabled selected hidden>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">部门描述</label>
    						<div class="col-sm-8">
      							<textarea class="form-control" name="deptDesc" id="input-addDeptDesc" rows="5"></textarea>
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-3 col-sm-9">
      							<button id="btn-submitEditSC" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
    			</div>
			</div>
		</div>
		
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
		
		<!-- 弹出遮罩层，用于显示部门详细信息 -->
		<div class="panel_departmentDetail" style="display:none;">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>部门详细信息</label>
    				<button id="btn-hidePanelDepartmentDetail" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        				<li class="list-group-item"><label>部门id：</label><span class="span-deptId"></span></li>
        				<li class="list-group-item"><label>部门名称：</label><span class="span-deptName"></span></li>
        				<li class="list-group-item"><label>部门级别：</label><span class="span-dlLevel"></span></li>
        				<li class="list-group-item"><label>部门主管人：</label><span class="span-manageEmpName"></span></li>
        				<li class="list-group-item"><label>部门人数：</label><span class="span-deptEmpnum"></span></li>
       					<li class="list-group-item"><label>上级部门：</label><span class="span-parentDeptName"></span></li>
       					<li class="list-group-item"><label>部门描述：</label><span class="span-deptDesc"></span></li>
       					<li class="list-group-item"><label>最后一次操作时间：</label><span class="span-lastOperatorDate"></span></li>
       					<li class="list-group-item"><label>操作人：</label><span class="span-operatorEmpName"></span></li>
   					</ul>
    			</div>
			</div>
		</div>
		
	<!-- 弹出遮罩层，用于修改部门信息 -->
	<div class="panel_updateDepartment">
		<div class="div-panel">
    		<div class="panel-heading">
    			<label>修改部门信息</label>
    			<button id="btn-hidePanelUpdateDepartment" type="button" class="btn btn-success">退出</button>
    		</div>
    		<div class="panel_body">
    			<form style="width:100%;" id="form-updateDept" class="form-horizontal" role="form">
    				<input type="text" style="display:none;" class="form-control" name="deptId" id="input-updateDeptId">
  					<div class="form-group" style="margin-top:10px;">
    					<label for="firstname" class="col-sm-3 control-label">部门名称</label>
    					<div class="col-sm-8">
      						<input type="text" class="form-control" name="deptName" id="input-updateDeptName">
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="firstname" class="col-sm-3 control-label">部门级别</label>
    					<div class="col-sm-8">
      						<select class="form-control" name="dlId" id="select-updateDeptLevel">
      							<option value="" disabled selected hidden>请选择</option>
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">上级部门</label>
    					<div class="col-sm-8" id="div-updateParentDeptName">
      						<input type="text" class="form-control" name="deptName" id="input-updateParentDeptName" placeholder="请输入上级部门名称">
      						<input type="text" style="display:none;" name="parentId" id="input-updateParentId">
    						<select multiple class="form-control" id="select-updateDeptId" name="deptId">
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">部门主管职位</label>
    					<div class="col-sm-8" id="div-updateManagePositionName">
      						<input type="text" class="form-control" name="managePositionName" id="input-updateManagePositionName" placeholder="请输入部门主管职位名称">
      						<input type="text" style="display:none;" name="managePositionid" id="input-updateManagePositionid">
    						<select multiple class="form-control" id="select-updatePositionId" name="positionId" >
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">部门状态</label>
    					<div class="col-sm-8">
      						<select class="form-control" name="statusId" id="select-updateDeptStatus">
      							<option value="" disabled selected hidden>请选择</option>
							</select>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="lastname" class="col-sm-3 control-label">部门描述</label>
    					<div class="col-sm-8">
      						<textarea class="form-control" name="deptDesc" id="input-updateDeptDesc" rows="5"></textarea>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-3 col-sm-9">
      						<button id="btn-submitUpdateDepartment" type="button" class="btn btn-primary">提交</button>
    					</div>
 	 				</div>
				</form>
    		</div>
		</div>
	</div>
		
</body>
	<script type="text/javascript" src="/static/js/department/departmentList.js"></script>
</html>