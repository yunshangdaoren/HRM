<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>部门考勤统计</title>
	<link href="/static/css/attendance/countDepartmentAttendance.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<ul class="nav nav-tabs">
  				<li role="presentation"><a href="/attendanceEmployee/toAttendanceEmployeeList.do">职工考勤详情列表</a></li>
  				<li role="presentation" class="active"><a href="/attendanceEmployee/countDepartmentAttendance.do">部门考勤统计</a></li>
			</ul>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/attendanceEmployee/countDepartmentAttendance.do">
  					<div class="form-group">
    					<label for="exampleInputName2">部门名称</label>
    					<input type="text" class="form-control"  name="deptName" id="input-selectDeptName" value="${deptNameStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">考勤日期</label>
    					<input type="date" style="width:160px;" class="form-control" name="date" id="input-selectDate" value="${dateStr }">
  					</div>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectContract" type="submit" class="btn btn-danger">查询</button>
  					<button id="btn-addContract" type="button" class="btn btn-success">考勤补录</button>
				</form>
			</div>
			<table class="table table-hover" id="table-deptDtail">
				<thead>
					<tr>
						<th>部门ID</th>
						<th>部门名称</th>
						<th>职工数量</th>
						<th>未签到人数</th>
						<th>签到且未签退人数</th>
						<th>签到且早退人数</th>
						<th>迟到且未签退人数</th>
						<th>迟到且早退人数</th>
						<th>到勤人数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="departmentAttendanceCount">
						<tr>
							<td>${departmentAttendanceCount.deptId }</td>
							<td><a class="a_departmentDetail" href="#" style="text-decoration:none;">${departmentAttendanceCount.deptName }</a></td>
							<td>${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.notSignNum }/${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.signNotLogoutNum}/${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.signLeaveEarlyNum}/${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.lateNotLeaveNum}/${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.lateLeaveEarlyNum}/${departmentAttendanceCount.deptEmpNum }</td>
							<td>${departmentAttendanceCount.normalNum}/${departmentAttendanceCount.deptEmpNum }</td>
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
		
		<!-- 弹出遮罩层，用于显示职位详细信息 -->
		<div class="panel_positionDetail" style="display:none;">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>职位详细信息</label>
    				<button id="btn-hidePanelPositionDetail" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<ul class="list-group" style="width:100%;height:100%;overflow:auto;">
        				<li class="list-group-item"><label>职位id：</label><span class="span-positionId"></span></li>
        				<li class="list-group-item"><label>职位名称：</label><span class="span-positionName"></span></li>
        				<li class="list-group-item"><label>职位级别：</label><span class="span-plLevelDesc"></span></li>
        				<li class="list-group-item"><label>职位所属部门：</label><span class="span-deptName"></span></li>
        				<li class="list-group-item"><label>上级职位：</label><span class="span-parentPositionName"></span></li>
       					<li class="list-group-item"><label>状态：</label><span class="span-statusName"></span></li>
       					<li class="list-group-item"><label>职位描述：</label><span class="span-positionDesc"></span></li>
       					<li class="list-group-item"><label>最后一次操作时间：</label><span class="span-lastOperatorDate"></span></li>
       					<li class="list-group-item"><label>操作人：</label><span class="span-operatorEmpName"></span></li>
   					</ul>
    			</div>
			</div>
		</div>
		
</body>
	<script type="text/javascript" src="/static/js/attendance/countDepartmentAttendance.js"></script>
</html>