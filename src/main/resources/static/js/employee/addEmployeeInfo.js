//添加合同信息弹出层面板提交按钮点击事件
$("#btn-submitAddEmployeeInfo").click(function(){
	$.ajax({
		url:"/employee/addEmployeeInfo.do",
		data:$("#form-addEmployeeInfo").serialize(),
		dataType:"json",
		success:function(result){
			if(result.code==200){
				alert(result.msg);
				window.location.href="/contract/needEntryContractList.do";
			}else{
				alert(result.msg);
			}
		}
	});
});

//添加职工信息非空判断
//function addContractFormEmptyCheck(){
//	if($("#input-empName").val()==''){
//		alert("职工姓名不能为空！");
//		$("#input-empName").focus();
//		return false;
//	}
//	if($("#input-empIdcard").val()==''){
//		alert("职工身份证号不能为空！");
//		$("#input-empIdcard").focus();
//		return false;
//	}
//	if($("#input-addDeptName").val()==''){
//		alert("合同所属部门不能为空！");
//		$("#input-addDeptName").focus();
//		return false;
//	}
//	if($("#input-addPositionName").val()==''){
//		alert("合同所属职位不能为空！");
//		$("#input-addPositionName").focus();
//		return false;
//	}
//	if($("#input-beginDate").val()==''){
//		alert("合同开始日期不能为空！");
//		$("#input-beginDate").focus();
//		return false;
//	}
//	if($("#input-endDate").val()==''){
//		alert("合同结束日期不能为空！");
//		$("#input-endDate").focus();
//		return false;
//	}
//	if($("#input-signDate").val()==''){
//		alert("合同签订日期不能为空！");
//		$("#input-signDate").focus();
//		return false;
//	}
//	if($("#input-monthlySalary").val()==''){
//		alert("合同月薪不能为空！");
//		$("#input-monthlySalary").focus();
//		return false;
//	}
//	//上面判断无误则返回true
//	return true;
//}
