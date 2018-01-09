<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                            <form id="wizardForm" >
                            <div class="text-center">
                                <img src="<%=basePath%>picture/yx.png" style="width:200px;">
                            </div>
            					    <div class="tab-pane active" id="tab1">
                                        <h5 class="text-center">美式整脊问诊表</h5>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">姓名</label>
                                                    <input class="form-control" type="text" name="first_name" placeholder="请输入姓名">
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">性别</label>
                                                    <input class="form-control" type="text" name="last_name"  placeholder="请输入性别" ><!-- aria-required="true" -->
                                                </div>
                                            </div>
                                             <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">年龄</label>
                                                    <input class="form-control" type="text" name="last_name"  placeholder="请输入年龄" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                           <div class="col-md-3 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">身高</label>
                                                    <input class="form-control" type="text" name="last_name"  placeholder="请输入身高" >
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">体重</label>
                                                    <input class="form-control" type="text" name="last_name"  placeholder="请输入体重" >
                                                </div>
                                            </div>
                                              <div class="col-md-3">
                                                <div class="form-group">
                                                    <label class="control-label">测试时间</label>
                                                    <input type="text"  class="table-input form-control"  id="beginTime" value=""  name="beginTime"  onClick="datePick_begin00('beginTime')">
                                                </div>
                                            </div>
                                        </div>
                                        <div id="addtext">
            					    	<div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">1.	1.目前是否有困扰您的身体疼痛症状？疼痛等级？(1-10： 1为最微弱，10为最强)</label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                  <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="">开始录入</button>
                                                    <button class="btn btn-sm">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">2.如果有疼痛症状，疼痛的部位和第一次出现疼痛时的情况？</label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                    <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="">开始录入</button>
                                                    <button class="btn btn-sm">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">3.	除此之外是否还有其他困扰您的症状？</label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                    <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="">开始录入</button>
                                                    <button class="btn btn-sm">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">4.	为解决现在困扰您的症状，您是否为此做过治疗？何种治疗？ </label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                    <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="">开始录入</button>
                                                    <button class="btn btn-sm">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">5.	是否有加重/减轻您疼痛的姿势或时间段？   </label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                    <div class="btn-right">
                                                  	 <button class="btn btn-sm" onclick="">开始录入</button>
                                                    <button class="btn btn-sm">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-10 col-md-offset-1">
                                                <div class="form-group">
                                                    <label class="control-label">6.	平时运动频率和强度（如每周跑步三次、每周高尔夫两次 )？</label>
                                                   <textarea name="" id="" cols="67" rows="1"></textarea>
                                                    <div class="btn-right">
                                                  	 <button class="btn" onclick="addprogram()">开始录入</button>
                                                    <button class="btn ">结束录入</button>
                                                  </div>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
            					    </div>
            				<div class="footer">
                                <button type="button" class="btn btn-default btn-fill btn-wd btn-back pull-left disabled" style="display: none;">Back</button>

                                <button type="button" class="btn btn-info btn-fill btn-wd btn-next pull-right" onclick="addItems()">问题添加</button>
                                <button type="button" class="btn btn-info btn-fill btn-wd btn-finish pull-right" onclick="onFinishWizard()">Finish</button>

                                <div class="clearfix"></div>
            				</div>
                            </form>
                            <!--addItems-->
				            <div  style="display: none;" id="program">
				                <div class="card">
				                    <div class="header">
				                        <h4 class="title">问题添加</h4>
				                    </div>
				                    <div class="content">
				                        <form method="post" action="">
				                            <div class="form-group">
				                                <label>请输入你的问题</label>
				                                <textarea name="" id="programitem" cols="67" rows="1"></textarea>
				                            </div>
				                           <div style="padding:10px;">
				                           	 <button  class="btn btn-fill btn-info" onclick="addprogram()">添加</button>
				                            <button  class="btn  btn-default">取消</button>
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
            $("#program")[0].style.display="none"

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
} 
</script>

</html>