function loginFormEmptyCheck(){
	if($("#userAccount").val()==''){
		alert("账户不能为空！");
		$("#userAccount").focus();
		return false;
	}
	
	if($("#userPwd").val()==''){
		alert("密码不能为空！");
		$("#userPwd").focus();
		return false;
	}
}