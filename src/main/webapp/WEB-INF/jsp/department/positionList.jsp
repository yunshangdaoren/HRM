<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>职位详情</title>
	<link href="/static/css/department/positionList.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<span class="title">职位详情</span>
			<div class="div_search">
				<form class="form-inline" id="form-queryPosition" method="get" action="/position/positionList.do">
					<div class="form-group">
    					<label for="exampleInputName2">职位ID</label>
    					<input type="text" class="form-control" name="positionId" id="input-selectDeptId" value="${positionIdStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">职位名称</label>
    					<input type="text" class="form-control"  name="positionName" id="input-selectDeptName" value="${dpositionNameStr }">
  					</div>
  					<div class="form-group">
    					<label for="exampleInputName2">所属部门名称</label>
    					<input type="text" class="form-control"  name="deptName" id="input-selectDeptName" value="${deptNameStr }">
  					</div>
  					<div class="form-group">
  						<label for="exampleInputEmail2">职位级别</label>
    					<select class="form-control" id="input-selectPositionLevel"  name="plId">
    						<option value="" disabled selected>请选择</option>
    						<c:forEach items="${positionLevelList }" var="positionLevel">
    							<c:choose>
    								<c:when test="${plIdStr == positionLevel.plId }">
    									<option value="${positionIdStr }" selected = "selected">${positionLevel.level }级</option>
    								</c:when>
    								<c:otherwise>
    								<option value="${positionLevel.plId }">${positionLevel.level }级</option>
    							</c:otherwise>
    							</c:choose>
    						</c:forEach>
						</select>
  					</div>
  					<button id="btn-resetSelect" type="button" class="btn btn-danger">重置</button>
  					<button id="btn-selectPosition" type="submit" class="btn btn-danger">查询</button>
  					<button id="btn-addPosition" type="button" class="btn btn-success">添加职位</button>
				</form>
			</div>
			<table class="table table-hover" id="table-positionDtail">
				<thead>
					<tr>
						<th>职位ID</th>
						<th>职位名称</th>
						<th>职位级别</th>
						<th>职位所属部门</th>
						<th>上级职位</th>
						<th>状态</th>
						<th>最后一次操作时间</th>
						<th>操作人</th>
						<th>详情</th>
						<th style="width:150px;">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pageResult.content }" var="position">
						<tr>
							<td>${position.positionId }</td>
							<td>${position.positionName }</td>
							<td>${position.plLeve }级</td>
							<td>
								<a href="#" class="a-manageEmpName">${position.deptName }</a>
								<i style="display:none;">${position.deptId }</i>
							</td>
							<td>${position.parentPositionName }</td>
							<td class="td-hideContent">${position.statusName }</td>
							<td><fmt:formatDate value="${position.lastOperatorDate }" type="both"/></td>
							<td>
								<a href="#" class="a-operatorEmpName">${position.operatorEmpName }</a>
								<i style="display:none;">${position.operatorEmpjobid }</i>
							</td>
							<td>
								<a class="a_positionDetail" href="/position/detail.do">
					    			<span class="label label-primary">详情</span>
					    		</a>
					    	</td>
					    	<td>
								<a class="a_positionStatus" href="#" style="text-decoration:none;">
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
	
	<!-- 弹出遮罩层，用于添加职位信息 -->
	<div class="panel_addPosition">
			<div class="div-panel">
    			<div class="panel-heading">
    				<label>添加职位信息</label>
    				<button id="btn-hidePanelAddPosition" type="button" class="btn btn-success">退出</button>
    			</div>
    			<div class="panel_body">
    				<form style="width:100%;" id="form-addPosition" class="form-horizontal" role="form">
  						<div class="form-group" style="margin-top:10px;">
    						<label for="firstname" class="col-sm-3 control-label">职位名称</label>
    						<div class="col-sm-8">
      							<input type="text" class="form-control" name="positionName" id="input-addPositionName">
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="firstname" class="col-sm-3 control-label">职位级别</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="plId" id="input-addPositionLevel">
      								<option value="" disabled selected>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">职位所属部门</label>
    						<div class="col-sm-8">
      							<input type="text" list="list-deptName" class="form-control" name="deptName" id="input-addDeptName" placeholder="请输入部门名称或id">
    							<datalist id="list-deptName" style="height:50px;overflow:auto;">
  									<option value="BMW">
								</datalist>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">上级职位</label>
    						<div class="col-sm-8">
      							<input type="text" list="list-parentPositionName" class="form-control" name="parentPositionName" id="input-addParentPositionName" placeholder="请输入上级职位名称或id">
    							<datalist id="list-parentPositionName" style="height:50px;overflow:auto;">
  									<option value="BMW">
								</datalist>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">职位状态</label>
    						<div class="col-sm-8">
      							<select class="form-control" name="statusId" id="input-addPositionStatus">
      								<option value="" disabled selected hidden>请选择</option>
								</select>
    						</div>
  						</div>
  						<div class="form-group">
    						<label for="lastname" class="col-sm-3 control-label">职位描述</label>
    						<div class="col-sm-8">
      							<textarea class="form-control" name="positionDesc" id="input-addPositionDesc" rows="5"></textarea>
    						</div>
  						</div>
  						<div class="form-group">
    						<div class="col-sm-offset-3 col-sm-9">
      							<button id="btn-submitEditPosition" type="button" class="btn btn-primary">提交</button>
    						</div>
 	 					</div>
					</form>
    			</div>
			</div>
		</div>
		
		<!-- 弹出遮罩层，用于显示职位详细信息 -->
		<div class="panel_employeeDetail" style="display:none;">
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
		
</body>
	<script type="text/javascript" src="/static/js/department/positionList.js"></script>
</html>