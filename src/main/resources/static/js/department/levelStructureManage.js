//定义全局部门查询要跳转的地址
var href = "http://localhost:8080/departmentLevel/positionList.do?pageNum=";
//当前页码
var pageNum = parseInt($(".i-pageNum").text());
//总页码
var totalPages = parseInt($(".i-totalPages").text());
//首页点击事件
$(".a-indexPage").click(function(){
	window.location.href = href+"0&"+$("#form-queryDept").serialize();
});
//上一页点击事件
$(".a-prePage").click(function(){
	if(pageNum-1 <= 0){
		window.location.href = href+"0&"+$("#form-queryDept").serialize();
	}else{
		window.location.href = href+""+(pageNum-1)+"&"+$("#form-queryDept").serialize();
	}
});
//下一页点击事件
$(".a-nextPage").click(function(){
	if(pageNum+1 > totalPages){
		window.location.href = href+""+totalPages+"&"+$("#form-queryDept").serialize();
	}else{
		window.location.href = href+""+(pageNum+1)+"&"+$("#form-queryDept").serialize();
	}
});
//尾页点击事件
$(".a-endPage").click(function(){
	window.location.href = href+""+totalPages+"&"+$("#form-queryDept").serialize();
});
//跳转至指定页码
$("#span-jumPageNum").click(function(){
	//获取要跳转到指定页码
	var pageNum = $("#input-pageNum").val();
	//获取总页码
	var totalPage = $(".span-totalPages").text().replace(/[^0-9]/ig,"");
	if($.isNumeric(pageNum)){
		totalPage = parseInt(totalPage);
		if(pageNum > totalPage || pageNum <= 0){
			alert("请输入正确的页码！");
		}else{
			window.location.href = "/position/positionList.do?pageNum="+pageNum+"&"+$("#form-queryDept").serialize();
		}
	}else{
		alert("请输入正确的页码！")
	}
});

//显示添加职位弹出层面板
$("#btn-addDepartmentLevel").click(function(){
	//显示弹出层面板
	$(".shadeDiv").show();
	$(".panel_addDepartmentLevel").show();
});
//添加部门级别信息弹出层面板提交按钮点击事件
$("#btn-submitEditDepartmentLevel").click(function(){
	if(addPositionFormEmptyCheck()){
		$.ajax({
			url:"/departmentLevel/add.do",
			data:$("#form-addDepartmentLevel").serialize(),
			dataType:"json",
			success:function(result){
				if(result.code==200){
					alert(result.msg);
					$(".shadeDiv").hide();
					$(".panel_addDepartmentLevel").hide();
					location.reload();
				}else{
					alert(result.msg);
				}
			}
		});
	};
});
//关闭添加职位信息弹出层面板
$("#btn-hidePanelAddPosition").click(function(){
	$(".shadeDiv").hide();
	$(".panel_addPosition").hide();
});

//监听添加职位信息弹出层中职位所属部门名称输入框输入值，并动态查找指定部门信息赋值给下拉选项列表
$("#input-addDeptName").bind("input propertychange", function(){
	//部门名称
	var deptName = $("#input-addDeptName").val();
	$("#select-infoDeptName").empty();
	$("#select-infoDeptName").show();
	$.ajax({
		url:"/department/queryLikeDeptName.do?deptName="+deptName,
		dataType:"json",
		success:function(result){
			if(result.code==200){
				$.each(result.data, function(i, item){
					$("#select-infoDeptName").append("<option>"+item.deptName+"</option>");
				});
			}
		}
	});
});
//监听添加职位信息弹出层中职位的上级职位信息输入框输入值，并动态查找指定上级职位信息赋值给下拉选项列表
$("#input-addParentPositionName").bind("input propertychange", function(){
	//部门名称
	var parentPositionName = $("#input-addParentPositionName").val();
	$("#select-parentPositionName").empty();
	$("#select-parentPositionName").show();
	$.ajax({
		url:"/position/queryLikePosition.do?parentPositionName="+parentPositionName,
		dataType:"json",
		success:function(result){
			if(result.code==200){
				$.each(result.data, function(i, item){
					$("#select-parentPositionName").append("<option>"+item.positionName+"</option>");
				});
			}
		}
	});
});
//监听职位所属部门、上级职位信息输入框鼠标光标移除事件
$("#input-addDeptName").focus(function(){
	$("#select-infoDeptName").show();
})
//添加职位信息弹出层：职位所属部门、上级职位信息输入框鼠标移出
$("#div-infoDeptName").mouseover(function(){
	//鼠标移入
	$("#select-infoDeptName").show();
}).mouseout(function(){
	//鼠标移出
	$("#select-infoDeptName").hide();
});
$("#div-parentPositionName").mouseover(function(){
	//鼠标移入
	$("#select-parentPositionName").show();
}).mouseout(function(){
	//鼠标移出
	$("#select-parentPositionName").hide();
});


//添加职位信息弹出层的下拉列表部门信息双击事件
$("#select-infoDeptName").dblclick(function(){
	//获取到选择的下拉列表的值
	var options = $("#select-infoDeptName option:selected");
	$("#select-infoDeptName").hide();
	$("#input-addDeptName").empty();
	$("#input-addDeptName").val(options.val());
});

//添加职位信息弹出层面板非空判断
function addPositionFormEmptyCheck(){
	if($("#input-addPositionName").val()==''){
		alert("职位名称不能为空！");
		$("#addPositionName").focus();
		return false;
	}
	if($("#select-addPositionLevel").val()==null){
		alert("职位级别不能为空！");
		$("#selec-addPositionLevel").focus();
		return false;
	}
	if($("#select-addPositionStatus").val()==null){
		alert("职位状态不能为空！");
		$("#select-addPositionStatus").focus();
		return false;
	}
	//上面判断无误则返回true
	return true;
}

//重置查询条件按钮点击事件
$("#btn-resetSelect").click(function(){
	$("#form-queryPosition :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");
});

//职位信息操作人名称点击事件：弹出显示层，显示指定职工的详细信息
$(".a-operatorEmpName").click(function(){
	//获取到要查看的职工工号
	var manageEmpjobid = $(this).next().text();
	//获取到职工所属部门id
	var deptId = $(this).parent().parent().children().first().text();
	//显示面板
	$(".shadeDiv").show();
	$(".panel_employeeDetail").show();
	//发送Ajax请求
	$.ajax({
		url:"/employee/get.do?empJobid="+manageEmpjobid+"&deptId="+deptId,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.code==200){
				//填充职工信息
				$(".span-empJobId").text(result.data.empJobid);
				$(".span-empName").text(result.data.empName);
				$(".span-empSex").text(result.data.empSexName);
				$(".span-empPhone").text(result.data.empPhone);
				$(".span-empEntryTime").text(result.data.entryTime);
				var deptName = "";
				for(var i = 0; i < result.data.deptNameList.length; i++){
					deptName += result.data.deptNameList[i]+" ";
				}
				$(".span-deptName").text(deptName);
				$(".span-empStatus").text(result.data.statusName);
			}else{
				alert(result.msg);
			}
		}
	});
});
//关闭职工详细信息弹出层面板
$("#btn-hidePanelEmployeeDetail").click(function(){
	$(".shadeDiv").hide();
	$(".panel_employeeDetail").hide();
});