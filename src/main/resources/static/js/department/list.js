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
//查询部门信息按钮点击事件
$("#btn-selectDept").click(function(){
	$.ajax({
		url:"/department/query.do",
		data:$("#form-queryDept").serialize(),
		dataType:"json",
		type:"get",
		success:function(result){
			if(result.code==200){
				//登录成功后页面跳转至指定地址
				window.location.href=result.url;
			}else{
				alert(result.message);
				$(".p_erroLoginFail").text(result.message);
				$(".p_erroLoginFail").show();
			}
		}
	});
});
//显示添加部门弹出层,并给部门级别信息下拉框赋值
$("#btn-addDept").click(function(){
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
//全局变量，跳转至指定页码地址
var locationHref = "http://localhost:8080/department/list.do?";
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
			alert("请输入正确的页码！")
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


