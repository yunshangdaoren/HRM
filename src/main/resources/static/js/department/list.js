//查询部门信息非空判断
function selectDeptFormEmptyCheck(){
	var deptName = $("#input-selectDeptName").val();
	var deptManageName = $("#input-selectDeptManageName").val();
	var deptLevel = $("#input-selectDeptLevel").val();
	if(deptName=='' && deptManageName=='' && deptLevel==null){
		alert("查询条件为空！")
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
//查询部门信息
$("#btn-selectDept").click(function(){
	
	if(selectDeptFormEmptyCheck()){
		
	};
});
//显示添加部门弹出层
$("#btn-addDept").click(function(){
	$(".shadeDiv").show();
	$(".panel_addDepartment").show();
});
//关闭添加部门弹出层
$("#btn-hidePanelAddDepartment").click(function(){
	$(".shadeDiv").hide();
	$(".panel_addDepartment").hide();
});
//添加部门信息提交按钮点击事件
$("#btn-submitEditSC").click(function(){
	if(addDeptFormEmptyCheck()){
		$.ajax({
			url:"/department/addDepartment.do",
			data:$("#form-addDept").serialize(),
			dataType:"json",
			success:function(result){
				if(result.statusCode==1){
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

//跳转至指定页
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
			window.location.href = "http://localhost:8080/department/list.do?pageNum="+pageNum;
		}
	}else{
		alert("请输入正确的页码！")
	}
});

