<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>组织架构</title>
	<link href="/static/css/workbench/employeeIndex.css" rel="stylesheet" />
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
						<div class="panel panel-primary" id="div_attendanceEmployee">
  							<div class="panel-heading">
    							<h3 class="panel-title">上班打卡</h3>
  							</div>
  							<div class="panel-body" title="上班打卡">
    							<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:25px;color:green;">今日已打</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/signSuccess.png" style="width:52px;height:52px;">
    							</div>
  							</div>
						</div>
						<div class="panel panel-success" onclick="window.open('')">
  							<div class="panel-heading">
    							<h3 class="panel-title">下班打卡</h3>
  							</div>
  							<div class="panel-body" title="下班打卡">
    							<div class="div-personNum">
    								<span class="num" style="line-height:70px;font-size:25px;color:red;">今日未打</span>
    							</div>
    							<div class="div-img">
    								<img src="/static/img/signFail.png">
    							</div>
  							</div>
						</div>
					</div>
					<div class="div2">
						<div class="panel">
  							<div class="panel-heading">
    							<span class="panel-title" style="font-size:23px;color:black;margin-left:0px;">打卡日历</span>
  							</div>
  							<div class="panel-body">
    							<div class="calendar">
        							<div class="date">
            							<h3>2020-05</h3>
            							<div class="days">
                							<div class="day">日</div>
                							<div class="day">一</div>
                							<div class="day">二</div>
                							<div class="day">三</div>
               								<div class="day">四</div>
                							<div class="day">五</div>
                							<div class="day">六</div>
                							<div class="number"></div>
                							<div class="number"></div>
                							<div class="number">1</div>
                							<div class="number">2</div>
                							<div class="number  active">3</div>
                							<div class="number">4</div>
                							<div class="number">5</div>
                							<div class="number">6</div>
                							<div class="number">7</div>
                							<div class="number">8</div>
                							<div class="number">9</div>
                							<div class="number active">10</div>
                							<div class="number">11</div>
                							<div class="number">12</div>
                							<div class="number">13</div>
                							<div class="number">14</div>
                							<div class="number">15</div>
                							<div class="number">16</div>
                							<div class="number">17</div>
                							<div class="number">18</div>
                							<div class="number">19</div>
                							<div class="number">20</div>
                							<div class="number">21</div>
                							<div class="number">22</div>
                							<div class="number">23</div>
                							<div class="number">24</div>
                							<div class="number">25</div>
                							<div class="number">26</div>
                							<div class="number">27</div>
                							<div class="number">28</div>
                							<div class="number">29</div>
                							<div class="number">30</div>
                							<div class="number">31</div>
           		 						</div>
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
					<div class="div2"></div>
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
	<script type="text/javascript" src="/static/js/workbench/employeeIndex.js"></script>
</html>