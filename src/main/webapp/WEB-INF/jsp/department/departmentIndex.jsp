<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">	
		table{
			border-top:3px solid #11C2EE;
			overflow: hidden;
			margin-top:6px;
			table-layout: fixed;
		}
		.table th{
			font-size:15px;
		}
		.table tbody tr td{
			font-size:12px;
			word-break:keep-all;/* 不换行 */
    		white-space:nowrap;/* 不换行 */
    		overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
    		text-overflow:ellipsis;
    		vertical-align: middle;
		}
		td a{
			color:blue;
			font-weight: bold;
			margin-top:-7px;
			cursor:pointer;
			text-decoration:none;
		}
		.title{
			color:#FF0000;
		}
		.shadeDisSC, .shadeSCInfo, .shadeEditSC{
			width:100%;
			height:100%;
			position: absolute;
			background:rgb(0,0,0,0.3);
			top:0px;
			left:0px;
			line-height:100%;
			display:none;
		}
		.shadeDisSC .disSCBox{
			width:350px;
			height:250px;
			margin:auto;
			background:white;
			margin-top:130px;
			position:relative;
			padding-top:20px;
		}
		.shadeDisSC .disSCBox .form-group{
			width:70%;
			margin-left:20px;
			line-height:30px;
		}
		.shadeDisSC .disSCBox .form-group .title{
			color:black;
			line-height:30px;
		}
	    .shadeDisSC .disSCBox .form-group .title .left{
			width:50%;
			float:left;
		}
	    .shadeDisSC .disSCBox .form-group .title .right{
			width:50%;
			right;
			background:white;
		}
	   .shadeDisSC .disSCBox .button{
			text-align:center;
			position:absolute;
			bottom:20px;
			left:100px;
		}
		.shadeDisSC .disSCBox .button #sure,#cancel{
			width:70px;
		}
		.shadeDisSC .disSCBox .button #sure{
			margin-left:10px;
		}
		.shadeSCInfo label{
			color:#EE1196;
			font-weight:bold;
		}
	</style>
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div id="center">
		<%@ include file="../leftNav.jsp" %>
		<div id="right" style="text-align:center;">
			<p style="font-size:38px;color:red;margin-top:50px;">欢迎登陆HRM管理系统</p>
		</div>
	</div>
	<%@ include file="../bottom.jsp" %>
	
	
</body>
</html>