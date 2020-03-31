<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/department/departmentDetail.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">部门管理</span>
			<div class="div_search">
				<button id="btn-selectDept" type="submit" class="btn btn-danger">查询</button>
  				<button id="btn-addDept" type="submit" class="btn btn-success">添加部门</button>
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
	
	
</body>
</html>