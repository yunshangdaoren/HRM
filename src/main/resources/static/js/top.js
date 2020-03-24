//退出
$(".a_logout").click(function(){
	
});
//显示修改密码弹出框
$(".a_changeUserPwd").click(function(){
	$(".shadeDiv").show();
});
//修改密码对话框非空判断
function changeUserPwdFormEmptyCheck(){
	if($("#currentUserPwd").val()==''){
		alert("当前密码不能为空！");
		$("#currentUserPwd").focus();
		return false;
	}
	if($("#newUserPwd").val()==''){
		alert("新密码不能为空！");
		$("#newUserPwd").focus();
		return false;
	}
	if($("#confirmPwd").val()==''){
		alert("确认密码不能为空！");
		$("#confirmPwd").focus();
		return false;
	}
	//两次密码是否一致判断
	if($("#newUserPwd").val()!=$("#confirmPwd").val()){
		alert("新密码和确认密码不一致！");
		return false;
	}
	//上面判断无误则返回true
	return true;
}
//提交修改密码点击事件
$("#btn_submitChangeUserPwd").click(function(){
	//调用方法判断两次输入的密码是否一致
	if(changeUserPwdFormEmptyCheck()){
		$.ajax({
			url:"/user/changeUserPwd.do",
			data:$("#form_changeUserPwd").serialize(),
			dataType:"json",
			success:function(result){
				if(result.statusCode==1){
					alert("修改成功！");
					$(".shadeDiv").hide();
					$("input").val("");
				}else{
					alert(result.message);
					$(".span_erroCurrentPwd").text(result.message);
					$(".span_erroCurrentPwd").show();
				}
			}
		});
	}
});
//输入框内容改变时，将错误提示隐藏
$("#currentUserPwd").change(function(){
	$(".span_erroCurrentPwd").hide();
});