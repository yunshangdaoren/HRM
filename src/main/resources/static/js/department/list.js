//定义全局部门查询要跳转的地址
var href = "http://localhost:8080/department/list.do?pageNum=";
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
			window.location.href = "/department/list.do?pageNum="+pageNum+"&"+$("#form-queryDept").serialize();
		}
	}else{
		alert("请输入正确的页码！")
	}
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
//监听添加部门信息弹出层中部门名称输入框输入值，并动态查找指定部门信息赋值给下拉选项列表
$("#input-addParentDeptName").bind("input propertychange", function(event){
	alert($("#input-addParentDeptName").val());
});
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

