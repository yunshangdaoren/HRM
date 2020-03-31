<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/department/departmentDetail.css" rel="stylesheet" />
	<link href="/static/css/shadeDiv.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">部门详情</span>
			<div class="div_search">
				<form class="form-inline">
  					<div class="form-group">
    					<label for="exampleInputName2">部门名称</label>
    					<input type="text" class="form-control" id="input-selectDeptName">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputEmail2">部门主管</label>
    					<input type="email" class="form-control" id="input-selectDeptManageName">
  					</div>
  					<div class="form-group">
  						<label for="exampleInputEmail2">部门级别</label>
    					<select class="form-control" id="input-selectDeptLevel">
    						<option value="" disabled selected hidden>请选择</option>
  							<option value="1">1</option>
  							<option value="2">2</option>
  							<option value="3">3</option>
  							<option value="4">4</option>
  							<option value="5">5</option>
						</select>
  					</div>
  					<button id="btn-selectDept" type="button" class="btn btn-danger">查询</button>
  					<button id="btn-addDept" type="button" class="btn btn-success">添加部门</button>
				</form>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>部门ID</th>
						<th>部门名称</th>
						<th>部门主管</th>
						<th>部门人数</th>
						<th>部门描述</th>
						<th>上级部门</th>
						<th>下级部门</th>
						<th>创建人</th>
						<th>创建时间</th>
						<th>状态</th>
						<th>详情</th>
						<th style="width:150px;">操作</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
			<!-- 查询内容为空提示 -->
			<%@ include file="../prompt_empty.jsp" %>
			<!-- 分页代码 -->
			<div class="pageNav">
				<ul class="pagination">
					<li><a href="#" style="pointer-events:none;">首页</a></li>
    				<li><a href="#">上一页</a></li>
    				<li><a href="#">1</a></li>
    				<li><a href="#">2</a></li>
    				<li><a href="#">3</a></li>
    				<li><a href="#">4</a></li>
    				<li><a href="#">...</a></li>
    				<li><a href="#">下一页</a></li>
    				<li><a href="#">尾页</a></li>
    				<li><span style="line-height:1.42857143;">共26页</span></li>
				</ul>
				<div class="input-group" style="width:130px;float:right;">
					<input type="text" class="form-control" style="z-index:0;">
        			<span class="input-group-addon" style="cursor:pointer;" >跳转至</span>
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
  									<option value="1">1级(最高)</option>
  									<option value="2">2级</option>
  									<option value="3">3级</option>
  									<option value="4">4级</option>
  									<option value="5">5级(最低)</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-2 control-label">上级部门</label>
    						<div class="col-sm-8">
      							<input type="text" list="list-parentDeptName" class="form-control" name="parentDeptName" id="input-addParentDeptName" placeholder="请输入上级部门名称">
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
	<script type="text/javascript" src="/static/js/department/departmentDetail.js"></script>
</html>