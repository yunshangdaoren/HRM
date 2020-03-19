//登录页面账户和密码非空判断
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

//显示重置密码遮罩层
$(".span_fogetPwd").click(function(){
	$(".shadeDiv").show();
});