function loginFormEmptyCheck(){
	if($("#uAccount").val()==''){
		alert("账户不能为空！");
		$("#uAccount").focus();
		return false;
	}
	
	if($("#uPassword").val()==''){
		alert("密码不能为空！");
		$("#uPassword").focus();
		return false;
	}
}