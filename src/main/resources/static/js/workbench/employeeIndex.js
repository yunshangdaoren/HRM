//职工签到打卡点击事件
$("#div_attendanceEmployee").click(function(){
	$.ajax({
		url:"/attendanceEmployee/sign.do",
		dataType:"json",
		success:function(result){
			if(result.code==200){
				alert(result.msg);
				location.reload();
			}else{
				alert(result.msg);
			}
		}
	});
});
