//定义全局部门查询要跳转的地址
var href = "http://localhost:8080/department/departmentList.do?pageNum=";
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
			window.location.href = "/department/departmentList.do?pageNum="+pageNum+"&"+$("#form-queryDept").serialize();
		}
	}else{
		alert("请输入正确的页码！")
	}
});

//显示添加部门弹出层面板,并给部门级别和部门状态信息下拉框赋值
$("#btn-addDept").click(function(){
	//显示弹出层面板
	$(".shadeDiv").show();
	$(".panel_addDepartment").show();
	//发送Ajax请求获取部门级别信息
	$.ajax({
		url:"/departmentLevel/list.do",
		dataType:"json",
		async:false,
		success:function(result){
			if(result.code==200){
				//先清空值（除了第一个）
				$("#select-addDeptLevel option:not(:first)").remove();
				//添加值
				for(var i =0; i < result.data.length; i++){
					$("#select-addDeptLevel").append("<option value='"+result.data[i].dlId+"'>"+result.data[i].levelDesc+"</option>")
				}
				//alert("开始获取部门状态信息");
				//发送Ajax请求获取部门状态信息
				$.ajax({
					url:"/status/listDepartment.do",
					dataType:"json",
					async:false,
					success:function(result){
						//alert("开始获取部门状态信息成功");
						if(result.code==200){
							//先清空值（除了第一个）
							$("#select-addDeptStatus option:not(:first)").remove();
							//添加值
							for(var i =0; i < result.data.length; i++){
								$("#select-addDeptStatus").append("<option value='"+result.data[i].statusId+"'>"+result.data[i].statusName+"</option>")
							}
						}else{
							alert("获取信息失败！");
						}
					}
				});
			}else{
				alert("获取信息失败！");
			}
		}
	});
});
//添加部门信息弹出层面板提交按钮点击事件
$("#btn-submitEditSC").click(function(){
	if(addDeptFormEmptyCheck()){
		$.ajax({
			url:"/department/add.do",
			data:$("#form-addDept").serialize(),
			dataType:"json",
			success:function(result){
				if(result.code==200){
					alert(result.msg);
					$(".shadeDiv").hide();
					$(".panel_addDepartment").hide();
					location.reload();
				}else{
					alert(result.msg);
				}
			}
		});
	};
});
//关闭添加部门信息弹出层面板
$("#btn-hidePanelAddDepartment").click(function(){
	$(".shadeDiv").hide();
	$(".panel_addDepartment").hide();
});

//监听添加部门信息弹出层中部门名称输入框输入值，并动态查找指定部门信息赋值给下拉选项列表
$("#input-addParentDeptName").bind("input propertychange", function(event){
	//alert($("#input-addParentDeptName").val());
});
//添加部门弹出层面板非空判断
function addDeptFormEmptyCheck(){
	if($("#input-addDeptName").val()==''){
		alert("部门名称不能为空！");
		$("#addDeptName").focus();
		return false;
	}
	if($("#select-addDeptLevel").val()==null){
		alert("部门级别不能为空！");
		$("#select-addDeptLevel").focus();
		return false;
	}
	if($("#select-addDeptStatus").val()==null){
		alert("部门状态不能为空！");
		$("#select-addDeptStatus").focus();
		return false;
	}
	//上面判断无误则返回true
	return true;
}

//重置查询条件按钮点击事件
$("#btn-resetSelect").click(function(){
	$("#form-queryDept :input").not(":button, :submit, :reset, :hidden").val("").removeAttr("checked").remove("selected");
});

//部门主管人名称点击事件：弹出显示层，显示指定职工的详细信息
$(".a-manageEmpName").click(function(){
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

//部门操作人名称点击事件：弹出显示层，显示指定职工的详细信息
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

//弹出显示层，显示指定部门的详细信息
$(".a_departmentDetail").click(function(){
	//获取到部门id
	var deptId = $(this).parent().parent().children().first().text();
	//显示面板
	$(".shadeDiv").show();
	$(".panel_departmentDetail").show();
	//发送Ajax请求
	$.ajax({
		url:"/department/get.do?deptId="+deptId,
		dataType:"json",
		type:"post",
		success:function(result){
			if(result.code==200){
				//填充部门信息
				$(".span-deptId").text(result.data.deptId);
				$(".span-deptName").text(result.data.deptName);
				$(".span-dlLevel").text(result.data.dlLeve+"级");
				$(".span-manageEmpName").text(result.data.manageEmpName);
				$(".span-deptEmpnum").text(result.data.deptEmpnum);
				$(".span-parentDeptName").text(result.data.parentDeptName);
				$(".span-deptDesc").text(result.data.deptDesc);
				$(".span-lastOperatorDate").text(result.data.lastOperatorDate);
				$(".span-operatorEmpName").text(result.data.operatorEmpName);
			}else{
				alert(result.msg);
			}
		}
	});
});
//关闭职工详细信息弹出层面板
$("#btn-hidePanelDepartmentDetail").click(function(){
	$(".shadeDiv").hide();
	$(".panel_departmentDetail").hide();
});
