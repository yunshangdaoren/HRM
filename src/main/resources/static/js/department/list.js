//------ 查询条件前的全局变量
//分页地址全局变量
var locationHref = "http://localhost:8080/department/query.do?";
//当前页码
var pageNum;
//总页码
var totalPages;
//------ 未加查询条件前的分页地址全局变量
//首页
var aIndexPageHref = $(".a-indexPage").attr("href");
//上一页
var aPrePageHref = $(".a-prePage").attr("href");
//下一页
var aNextPageHref = $(".a-nextPage").attr("href");
//尾页
var aEndPageHref = $(".a-endPage").attr("href");

//查询部门信息非空判断
function selectDeptFormEmptyCheck(){
	var deptId = $("#input-selectDeptId").val();
	var deptName = $("#input-selectDeptName").val();
	var deptManageName = $("#input-selectDeptManageName").val();
	var deptLevel = $("#input-selectDeptLevel").val();
	if(deptId == '' && deptName=='' && deptManageName=='' && deptLevel==null){
		//查询条件为空
		return false;
	}
	//上面判断无误则返回true
	return true;
}
//查询部门信息按钮点击事件
$("#btn-selectDept").click(function(){
	if(selectDeptFormEmptyCheck()){
		$.ajax({
			url:"/department/query.do?",
			data:$("#form-queryDept").serialize(),
			dataType:"json",
			type:"get",
			async:false,
			success:function(result){
				if(result.code==200){
					//设置当前页码
					pageNum = result.pageResult.pageNum;
					//设置总页码
					totalPages = result.pageResult.totalPages;
					ajaxSetTableInfo(result.pageResult.content);
					//为分页跳转绑定点击事件
					bindPageClick();
				}else{
					alert(result.message);
				}
			}
		});
	}else{
		//无查询条件，则前往查询出所有部门信息
		locationHref = "localhost:8080/department/list.do?";
		window.location.href = "localhost:8080/department/list.do?";
	}
});
//跳转至首页点击事件
function aIndexPageClick(){
	$.ajax({
		url:locationHref+"&pageNum=1",
		data:$("#form-queryDept").serialize(),
		dataType:"json",
		type:"get",
		async:false,
		success:function(result){
			if(result.code==200){
				if(result.code==200){
					ajaxSetTableInfo(result.pageResult.content);
				}else{
					alert(result.message);
				}
			}
		}
	});
};
//跳转至前一页点击事件
function aPrePageClick(){
	$.ajax({
		url:locationHref+"&pageNum="+(pageNum-1),
		data:$("#form-queryDept").serialize(),
		dataType:"json",
		type:"get",
		async:false,
		success:function(result){
			if(result.code==200){
				if(result.code==200){
					ajaxSetTableInfo(result.pageResult.content);
				}else{
					alert(result.message);
				}
			}
		}
	});
};
//跳转至后一页点击事件
function aNextPageClick(){
	$.ajax({
		url:locationHref+"&pageNum="+(pageNum+1),
		data:$("#form-queryDept").serialize(),
		dataType:"json",
		type:"get",
		async:false,
		success:function(result){
			if(result.code==200){
				if(result.code==200){
					ajaxSetTableInfo(result.pageResult.content);
				}else{
					alert(result.message);
				}
			}
		}
	});
}
//跳转至尾页点击事件
function aEndPageClick(){
	$.ajax({
		url:locationHref+"&pageNum="+totalPages,
		data:$("#form-queryDept").serialize(),
		dataType:"json",
		type:"get",
		async:false,
		success:function(result){
			if(result.code==200){
				if(result.code==200){
					ajaxSetTableInfo(result.pageResult.content);
				}else{
					alert(result.message);
				}
			}
		}
	});
};
//有查询条件时，为表格动态赋值方法
function ajaxSetTableInfo(list){
	//表格赋值
	//清空表格
	$("#table-deptDtail tr:not(:first)").empty();
	//var list = result.pageResult.content;
	var tableHtml = "";
	for(var i = 0; i < list.length; i++){
		tableHtml += "<tr>"+
						"<td>"+list[i].deptId+"</td>"+
						"<td>"+list[i].deptName+"</td>"+
						"<td>"+list[i].dlLeve+"级</td>"+
						"<td>"+list[i].manageEmpName+"</td>"+
						"<td>"+list[i].deptEmpnum+"</td>"+
						"<td>"+list[i].deptDesc+"</td>"+
						"<td>"+list[i].parentDeptName+"</td>"+
						"<td>"+list[i].statusName+"</td>"+
						"<td><fmt:formatDate value='"+list[i].lastOperatorDate+"' type='both'/></td>"+
						"<td><a href='#'>"+list[i].operatorEmpName+"</a></td>"+
						"<td>"+
							"<a class='a_deptDetail' href='#'>"+
								"<span class='label label-primary'>详情</span>"+
							"</a>"+
						"</td>"+
						"<td>"+
							"<a class='a_deptStatus' href='#' style='text-decoration:none;'>"+
								"<span class='label label-primary'>状态管理</span>"+
							"</a>"+
						"</td>"+
						"</tr>";
	}
	$("#table-deptDtail").append(tableHtml);
};
//为分页跳转绑定点击事件
function bindPageClick(){
	//给a标签绑定点击事件
	$(".a-indexPage").attr("onclick", "aPrePageClick();");
	$(".a-prePage").attr("onclick", "aPrePageClick();");
	$(".a-nextPage").attr("onclick", "aNextPageClick();");
	$(".a-endPage").attr("onclick", "aEndPageClick();");
	//----   用于修改a标签href属性
	//首页
	$(".a-indexPage").attr("href", "#");
	//上一页
	$(".a-prePage").attr("href", "#");
	//下一页
	$(".a-nextPage").attr("href",  "#");
	//尾页
	$(".a-endPage").attr("href", "#");
	//---- 用于修改全局页码跳转地址
	//查询的部门id
	var deptId = $("#input-selectDeptId").val();
	//查询的部门名称
	var deptName = $("#input-selectDeptName").val();
	//查询的部门主管名称
	var manageEmpName = $("#input-selectDeptManageName").val();
	//查询的部门级别
	var dlId = $("#input-selectDeptLevel").val();
	//修改全局页码跳转地址
	locationHref += "deptId="+deptId+"&deptName="+deptName+"&manageEmpName="+manageEmpName+"&dlId="+dlId;
}
//为分页跳转移除绑定点击事件
function removeBindPageClick(){
	$(".a-indexPage").removeAttr("onclick");
	$(".a-prePage").removeAttr("onclick");
	$(".a-nextPage").removeAttr("onclick");
	$(".a-endPage").removeAttr("onclick");
	//首页
	$(".a-indexPage").attr("href", aIndexPageHref);
	//上一页
	$(".a-prePage").attr("href", aPrePageHref);
	//下一页
	$(".a-nextPage").attr("href",  aNextPageHref);
	//尾页
	$(".a-endPage").attr("href", aEndPageHref);
}
//显示添加部门弹出层,并给部门级别信息下拉框赋值
$("#btn-addDept").click(function(){
	alert("此时的地址:"+locationHref);
	$(".shadeDiv").show();
	$(".panel_addDepartment").show();
	$.ajax({
		url:"/departmentLevel/list.do",
		data:$("#form-addDept").serialize(),
		dataType:"json",
		success:function(result){
			if(result.code==200){
				//先清空值
				$("#input-addDeptLevel").empty();
				//添加值
				$("#input-addDeptLevel").append("<option value='' disabled selected hidden>请选择</option>");
				for(var i =0; i < result.data.length; i++){
					$("#input-addDeptLevel").append("<option value='"+result.data[i].level+"'>"+result.data[i].levelDesc+"</option>")
				}
			}else{
				alert("获取信息失败！");
			}
		}
	});
});
//关闭添加部门弹出层
$("#btn-hidePanelAddDepartment").click(function(){
	$(".shadeDiv").hide();
	$(".panel_addDepartment").hide();
});
//添加部门信息弹出层提交按钮点击事件
$("#btn-submitEditSC").click(function(){
	if(addDeptFormEmptyCheck()){
		$.ajax({
			url:"/department/addDepartment.do",
			data:$("#form-addDept").serialize(),
			dataType:"json",
			success:function(result){
				if(result.code==200){
					alert(result.message);
					$(".shadeDiv").hide();
					$(".panel_addDepartment").hide();
				}else{
					alert(result.message);
				}
			}
		});
	};
});
//跳转至指定页码
$("#span-jumPageNum").click(function(){
	//获取要跳转到指定页码
	var pageNum = $("#input-pageNum").val();
	//获取总页码
	var totalPage = $(".span-totalPages").text().replace(/[^0-9]/ig,"");
	if($.isNumeric(pageNum)){
		totalPage = parseInt(totalPage);
		//alert("pageNum:"+pageNum+"  totalPage"+totalPage);
		if(pageNum > totalPage || pageNum <= 0){
			alert("请输入正确的页码！");
		}else{
			window.location.href = locationHref+"pageNum="+pageNum;
		}
	}else{
		alert("请输入正确的页码！")
	}
});
//监听添加部门信息弹出层中部门名称输入框输入值，并动态查找指定部门信息赋值给下拉选项列表
$("#input-addParentDeptName").bind("input propertychange", function(event){
	alert($("#input-addParentDeptName").val());
});
//添加部门弹出层非空判断
function addDeptFormEmptyCheck(){
	if($("#input-addDeptName").val()==''){
		alert("部门名称不能为空！");
		$("#addDeptName").focus();
		return false;
	}
	if($("#input-addDeptLevel").val()==null){
		alert("部门级别不能为空！");
		$("#input-addDeptLevel").focus();
		return false;
	}
	if($("#input-addDeptStatus").val()==null){
		alert("部门状态不能为空！");
		$("#input-addDeptStatus").focus();
		return false;
	}
	//上面判断无误则返回true
	return true;
}

