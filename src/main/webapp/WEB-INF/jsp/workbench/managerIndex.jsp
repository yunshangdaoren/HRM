<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/workbench/managerIndex.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right">
			<div class="div-title" style="height:30px;margin-bottom:20px;">
				<span class="title">工作台</span>
			</div>
			<div class="div-content">
				<div class="content-left">
					<div class="div1">
						<div class="panel panel-primary" onclick="window.open('')">
  							<div class="panel-heading">
    							<h3 class="panel-title">合同待审批</h3>
  							</div>
  							<div class="panel-body" title="待入职">
    							<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:53px;">0</span>
    								<span class="ren" style="line-height:70px;font-size:20px;color:#888;">人</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/entry.png" style="width:52px;height:52px;">
    							</div>
  							</div>
						</div>
						<div class="panel panel-success" onclick="window.open('')">
  							<div class="panel-heading">
    							<h3 class="panel-title">合同待入职</h3>
  							</div>
  							<div class="panel-body" title="待转正">
    							<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:53px;">0</span>
    								<span class="ren" style="line-height:70px;font-size:20px;color:#888;">人</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/regular.png">
    							</div>
  							</div>
						</div>
					</div>
					<div class="div2">
						<div class="panel">
  							<div class="panel-heading">
    							<span class="panel-title">待办理事项</span>
  							</div>
  							<div class="panel-body">
    							<div class="div-thing1" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/birthday.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">生日提醒</p>
    								</div>
    							</div>
    							<div class="div-thing2" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/experationOfContact.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">合同到期提醒</p>
    								</div>
    							</div>
    							<div class="div-thing3" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/holiday.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">假期审批</p>
    								</div>
    							</div>
    							<div class="div-thing4" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/overtime.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">加班审批</p>
    								</div>
    							</div>
  							</div>
						</div>
					</div>
					<div class="div3"></div>
				</div>
				<div class="content-center">
					<div class="div1">
						<div class="panel panel-warning" onclick="window.open('')">
  							<div class="panel-heading" >
    							<h3 class="panel-title">待调动</h3>
  							</div>
  							<div class="panel-body" title="待调动">
    							<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:53px;">0</span>
    								<span class="ren" style="line-height:70px;font-size:20px;color:#888;">人</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/transfer.png">
    							</div>
  							</div>
						</div>
						<div class="panel panel-danger" onclick="window.open('')">
  							<div class="panel-heading">
    							<h3 class="panel-title">待离职</h3>
  							</div>
  							<div class="panel-body" title="待离职">
  								<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:53px;">0</span>
    								<span class="ren" style="line-height:70px;font-size:20px;color:#888;">人</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/quit.png">
    							</div>
  							</div>
						</div>
					</div>
					<div class="div2">
						<div class="panel">
  							<div class="panel-heading">
    							<span class="panel-title">待办理事项</span>
  							</div>
  							<div class="panel-body">
    							<div class="div-thing1" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/birthday.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">生日提醒</p>
    								</div>
    							</div>
    							<div class="div-thing2" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/experationOfContact.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">合同到期提醒</p>
    								</div>
    							</div>
    							<div class="div-thing3" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/holiday.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">假期审批</p>
    								</div>
    							</div>
    							<div class="div-thing4" onclick="window.open('')">
    								<div class="div-img">
    									<img src="/static/img/overtime.png">
    								</div>
    								<div class="div-num">
    									<span class="num" style="font-size:21px;">0</span>
    									<span>人</span>
    								</div>
    								<div class="div-desc">
    									<p style="font-">加班审批</p>
    								</div>
    							</div>
  							</div>
						</div>
					</div>
					<div class="div3"></div>
				</div>
				<div class="content-right">
					<div class="div1"></div>
					<div class="div2"></div>
					<div class="div3"></div>
				</div>
			</div>
			
		
			
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	

		
</body>
	
</html>