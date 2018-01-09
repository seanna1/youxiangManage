<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
 <script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=basePath%>css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <link href="css/demo.css" rel="stylesheet" />
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href='<%=basePath%>css/common.css' rel='stylesheet' type='text/css'>
    <link href="<%=basePath%>css/pe-icon-7-stroke.css" rel="stylesheet" />
    <!--layer-->
    <script src="<%=basePath%>js/layer/layer.js" type="text/javascript"></script>
    <link href="<%=basePath%>js/layer/theme/default/layer.css" rel="stylesheet" />
      <!-- 时间段 -->
    <script src="<%=basePath%>css/wdatePicker/lang/zh-cn.js" charset="UTF-8"></script><!-- 时间段 -->
	<script type="text/javascript" src="<%=basePath%>css/wdatePicker/datepicker.js"></script><!-- 时间段 -->
	<script type="text/javascript" src="<%=basePath%>css/wdatePicker/WdatePicker.js"></script><!-- 时间段 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/wdatePicker/skin/default/datepicker.css"><!-- 时间段 -->
</head>
<body>
                    <div class="col-md-8 col-md-offset-2">
                        <div class="card card-wizard" id="wizardCard">
                           <!--  <form id="wizardForm" > -->
                            <div class="text-center">
                                <img src="<%=basePath%>picture/yx.png" style="width:200px;">
                            </div>
            					    <div class="tab-pane active" id="tab1">
                                        <h5 id="tablename" class="text-center">${from.name }</h5>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">姓名</label>
                                                    <input id="formname"  name="name" class="form-control" type="text"  placeholder="请输入姓名" readOnly>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">性别</label>
                                                    <input id="formgender" name="gender" class="form-control" type="text"   placeholder="请输入性别" readOnly><!-- aria-required="true" -->
                                                </div>
                                            </div>
                                             <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">年龄</label>
                                                    <input id="formage" name="age" class="form-control" type="text"  placeholder="请输入年龄" readOnly>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                           <div class="col-md-3 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">身高</label>
                                                    <input id="formheight" name="height" class="form-control" type="text"  placeholder="请输入身高" readOnly>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">体重</label>
                                                    <input id="formweight" name="weight" class="form-control" type="text"  placeholder="请输入体重" readOnly>
                                                </div>
                                            </div>
                                              <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">测试时间</label>																						<!-- onClick="datePick_begin00('beginTime')"  -->
                                                    <input id="formcreateTime" name="createTime" type="text"  class="table-input form-control"  id="beginTime" value=""  name="beginTime"  readOnly>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="addtext">
                                        <c:forEach items="${list}" var="l" varStatus="va">
                                        	<div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label id="labelid" class="control-label">${va.index+1}.${l.questionName }</label><button class="btn btn-sm" onclick="deleQuestion1(${l.questionId},${l.qFromId})">删除</button>
	                                                   <!-- 导出word时传递问题id -->
	                                                   <span name="spanname" style="display: none;">${l.questionId}</span>
	                                                   <!-- 遍历答案 -->
	                                                   <textarea name="answer" id="${l.questionId}" cols="70" rows="2" required="true" ></textarea>
                                                  <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="formIn(${l.questionId});">开始录入</button>
                                                    <button class="btn btn-sm" onclick="formInto(${l.questionId});" >结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                        </c:forEach>
                                        </div>
            					    </div>
            				<div class="footer">
                                <button type="button" class="btn btn-default btn-fill btn-wd btn-back pull-left disabled" style="display: none;">Back</button>
                                <button type="button" class="btn btn-info btn-fill btn-wd btn-next pull-right" onclick="addItems()">问题添加</button>
                                <button type="button" id="exp_word" class="btn btn-info btn-fill btn-wd btn-next pull-right" onclick="outputword()">下载</button>
                                <button type="button" class="btn btn-info btn-fill btn-wd btn-finish pull-right" onclick="onFinishWizard()">Finish</button>
                                <div class="clearfix"></div>
            				</div>
                            <!--addItems-->
				            <div  style="display: none;" id="program">
				                <div class="card">
				                    <div class="header">
				                        <h4 class="title">问题添加</h4>
				                    </div>
				                    <div class="content">
				                        <form method="post" action="formInput/createquestInfo">
				                        <input name="formid" value="${from.id }" style="display: none;">
				                            <div class="form-group">
				                                <label>请输入你的问题</label>
				                                <textarea name="questionname" id="programitem" cols="70" rows="2"></textarea>
				                            </div>
				                           <div style="padding:10px;">
				                           	 <button  class="btn btn-fill btn-info" onclick="addprogram()">添加</button>
				                           </div>
				                        </form>
				                    </div>
				                </div> <!-- end card -->
				            </div>
				            <!--end addItems  -->
                        </div>
                    </div>
</body>
<script type="text/javascript">
function addItems(){
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        area: '516px',
        shadeClose: false,
        content: $('#program'),
        end: function(){
            $("#program")[0].style.display="none";
        }
    });
}
function addprogram(){
	var text=$("#programitem")[0].value;
	var item='';
	var childLen=$("#addtext")[0].children.length+1;	
	item+='<div class="row">'
	+' <div class="col-md-10 col-md-offset-1">'
	+' <div class="form-group">'
	+'<label class="control-label">'+childLen+'.'+text+'</label>'
	+'<textarea name="" id="" cols="67" rows="1"></textarea>'
	+'<div class="btn-right">'
	+' <button class="btn btn-sm" onclick="addItems()">开始录入</button>'
	+'<button class="btn btn-sm">结束录入</button>'
	+' </div>'
	+' </div>'
	+' </div>'
	+' </div>';
	$("#addtext").append(item);	
}; 

function deleQuestion1(id,formId){
	location.href="<%=basePath%>formInput/deletequestInfo?formid="+formId+"&questionId="+id;
}

//回显用户信息
$(document).ready(function(){
	//alert(window.parent.part());
	var pid=window.parent.part();
	$.ajax({
         		type : "POST",
         		url  : "patient/selectupdatePatient",
         		data : {"id":pid},
         		datatype : "json",
         		success : function(data) {
         			$("#formname").val(data.patientname); 
         			if(data.gender==true){
         				$("#formgender").val("男");
         			}
         			else if(data.gender==false){
         				$("#formgender").val("女");
         			}
         			$("#formage").val(data.age);
         			$("#formheight").val(data.height);
         			$("#formweight").val(data.weight);
         			$("#formcreateTime").val(data.createTime);
         		},
         		error : function() {
         		alert("服务异常！");
         		}
         	}); 
});

// 定时器,动态回显答案
function updateDate(qid){
	var uid=window.parent.part();
    $.ajax({
    	type:"POST",
    	url:"answer/quarts",
		data:{"qid":qid,"uid":uid},
		datatype : "json",
		success : function(data) {
         	//alert(data.keywords);
         	document.getElementById(qid).value=data.keywords;
    	},
    	error:function(){
    		clearInterval("updateDate("+qid+")");
    	}
    });
}

var num="";//多次点击异常变量声明
var t1=null;
function formIn(qid){
	num++;
	if(num>=2){
		alert("请先结束当前录入操作");
		return false;
	}else{
		var uid=window.parent.part();
		//alert(uid);
		$.ajax({
	         type : "POST",
	         url  : "answer/sendmessage",
	         data : {"qid":qid,"uid":uid},
	         datatype : "json",
	         success : function(data) {
	         	//alert(data.message);
	         	document.getElementById(qid).value=data.message;
	         	//console.log("已发送请求！");
	         	t1=setInterval("updateDate("+qid+")",4000);  
	         }
	     });
	}
}	

function formInto(qid){
	num=0;
	var uid=window.parent.part();
	$.ajax({
		type:"POST",
		url:"answer/endFormInto",
		data:{"qid":qid,"uid":uid},
		datatype : "json",
		success : function(date) {
         		//document.getElementById(qid).value=date.keyword;
         		if(t1!=null){
         			window.clearInterval(t1);
         		}
         	}
	});
} 
//离开当前页提示并发送结束录入消息到C
window.onbeforeunload = function(){
	formInto(1);
};
//导出word并更新答案到数据库
function outputword(){
	//用户id
	var uid=window.parent.part();
	//console.log(uid);  
	var tablename = document.getElementById("tablename");
	var fname = document.getElementById("formname");
	var fgender = document.getElementById("formgender");
	var fage = document.getElementById("formage");
	var fheight = document.getElementById("formheight");
	var fweight = document.getElementById("formweight");
	var fcreatetime = document.getElementById("formcreateTime");
	//问题-答案 传参
	var arr = document.getElementsByName("answer");
	var ids = document.getElementsByName("spanname");
	var leng = arr.length;
	//var myArray=new Array(leng);
	var myString="";
	for(var i = 0;i < leng; i++) { 
		if(arr[i].value!=null||arr[i].value==""){
			//console.log(ids[i].innerText+"---"+arr[i].value);
			//myArray[i]=ids[i].innerText+"#"+arr[i].value;
			myString=ids[i].innerText+"#"+arr[i].value+"@"+myString;
			//console.log(myString);
		}
		else {
			alert("请完整录入表单！");
		}
	}
	//console.log(JSON.stringify(myArray)); 
	$.ajax({
		type:"POST",
		url:"answer/outword",
		data:{"tablename":tablename.innerText,"uid":uid,"fname":fname.value,"fgender":fgender.value,"fage":fage.value,"fheight":fheight.value,"fweight":fweight.value,"fcreatetime":fcreatetime.value,"myString":myString},
		datatype : "json",
		success : function(data) {
			//console.log(data.url);
			//下载word
			//window.location.href="http://"+data.url;
			window.location.href=data.url;
         },
         error : function() {
         	alert("导出失败！");
         }
	});
}
</script>
</html>