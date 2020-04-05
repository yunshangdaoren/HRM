<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/department/list.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">部门详情${deptIdStr }</span>
			<div class="div_search">
				<form class="form-inline" id="form-queryDept" method="get" action="/department/list.do">
					<div class="form-group">
    					<label for="exampleInputName2">部门id</label>
    					<input type="text" class="form-control" name="deptId" id="input-selectDeptId" value="${deptIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">部门名称</label>
    					<input type="text" class="form-control"  name="deptName" id="input-selectDeptName" value="${deptNameStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputEmail2">部门主管名称</label>
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
						<th>部门主管</th>
						<th>部门人数</th>
						<th>部门描述</th>
						<th>上级部门</th>
						<th>状态</th>
						<th>最后一次操作间</th>
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
							<td><a href="#">${department.manageEmpName }</a></td>
							<td>${department.deptEmpnum }</td>
							<td>${department.deptDesc }</td>
							<td>${department.parentDeptName }</td>
							<td>${department.statusName }</td>
							<td><fmt:formatDate value="${department.lastOperatorDate }" type="both"/></td>
							<td><a href="#">${department.operatorEmpName }</a></td>
							<td>
								<a class="a_deptDetail" href="#">
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
    					<a href="#" class="a-currentPage">当前第${pageResult.pageNum }页</a>
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
			<div class="panel">
    			<div class="panel-heading">
    				<label>添加部门信息</label>
    				<button id="btn-hidePanelAddDepartment" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form style="width:100%;" id="form-addDept" class="form-horizontal" role="form">
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-2 control-label">部门名称</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="deptName" id="input-addDeptName">
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="firstname" class="col-sm-2 control-label">部门级别</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="level" id="input-addDeptLevel">
      								<option value="" disabled selected hidden>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-2 control-label">上级部门</label>
    						<div class="col-sm-8">
      							<input type="text" list="list-parentDeptName" class="form-control" name="parentDeptName" id="input-addParentDeptName" placeholder="请输入上级部门名称或id">
    							<datalist id="list-parentDeptName" style="height:50px;overflow:auto;">
  									<option value="BMW">
								</datalist>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-2 control-label">部门主管</label>
    						<div class="col-sm-8">
      							<input type="text" list="list-deptManageName" class="form-control" name="deptManageName" id="input-addDeptManageName" placeholder="请输入员工工号进行查询">
    							<datalist id="list-deptManageName" style="height:50px;overflow:auto;">
  									<option value="BMW">
								</datalist>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-2 control-label">部门状态</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="status" id="input-addDeptStatus">
      								<option value="" disabled selected hidden>请选择</option>
  									<option>正常</option>
  									<option>冻结</option>
  									<option>停用</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-2 control-label">部门描述</label>
    						<div class="col-sm-8">
      							<textarea class="form-control" name="deptDesc" id="input-addDeptDesc" rows="5"></textarea>
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-2 col-sm-10">
      							<button id="btn-submitEditSC" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
    			</div>
			</div>
		</div>
</body>
	<script type="text/javascript" src="/static/js/department/list.js"></script>
</html>