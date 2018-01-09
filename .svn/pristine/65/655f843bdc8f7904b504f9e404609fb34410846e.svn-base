<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="zhangfn" uri="http://github.com/zhangkaitao/tags/zhang-functions" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'robots.jsp' starting page</title>
	<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
	<!--layer-->
    <script src="<%=basePath%>js/layer/layer.js" type="text/javascript"></script>
    <link href="<%=basePath%>js/layer/theme/default/layer.css" rel="stylesheet" />
	<!--pagenation start -->
	<script type="text/javascript" src="<%=basePath%>css/pagination/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>css/pagination/kkpager.js"></script>
	<script type="text/javascript" src="<%=basePath%>css/pagination/kkpager.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pagination/kkpager_orange.css" />
	<!--pagenation end-->
	
  	<!-- Bootstrap core CSS     -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
    <!--  Light Bootstrap Dashboard core CSS    -->
    <link href="<%=basePath%>css/light-bootstrap-dashboard.css" rel="stylesheet"/>
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="<%=basePath%>css/demo.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href='<%=basePath%>css/common.css' rel='stylesheet' type='text/css'>
    <link href="<%=basePath%>css/pe-icon-7-stroke.css" rel="stylesheet" />
	 <script type="text/javascript">
        function addRobot(){
       	 	$("#title").text("机器人添加");
            layer.open({
                type:1,
                title: false,
                closeBtn: 1,
                area: '516px',
                shadeClose: false,
                content: $('#addRobot'),
                end: function(){
                    $("#addRobot")[0].style.display="none";
                }
            });
        };
        function deleteById(id){
        	layer.confirm("你确定删除选中的信息吗?", function(){  
		            window.location.href="<%=basePath%>robot/delRobotsById?id="+ id;
		        });  
        }
		function deleteRobotAll(id){      
		    if(id==undefined)  
		    {  
		      var len = 0;  
		      var cks=$("input[name='btSelectItem']");  
		      for(var i=0;i<cks.length;i++){  
		        if(cks[i].checked){  
		          ++len;  
		        };  
		      }  
		      if(len==0){  
		        layer.alert("请选择要删除的信息！");  
		        return;  
		      }  
		      var ids=[];  
		      for(var i=0;i<cks.length;i++){  
		        if(cks[i].checked){  
		          var id=$(cks[i]).val();  
		          ids.push(id);  
		        };  
		      }  
		      var delId=ids.join(",");  
		      layer.confirm("你确定删除选中的信息吗?", function(){  
		            location.href="<%=basePath%>robot/deleterobot?id="+ delId;  
		        });  
		    };  
		}; 
    //全选、全不选
	function DoCheck(){
		var ch=document.getElementsByName("btSelectItem");
		if(document.getElementsByName("btSelectAll")[0].checked==true){
			for(var i=0;i<ch.length;i++){
				ch[i].checked=true;
			}
		}else{
			for(var i=0;i<ch.length;i++){
				ch[i].checked=false;
			}
		}
	};
    </script>

  </head>
  
<body>
<div class="wrapper">
    <!--start  content-->
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h4 class="title">机器人管理</h4>
                        </div>
                        <div class="bootstrap-table">
                            <div class="fixed-table-toolbar">
                                <div class="bars pull-left">
                                    <div class="toolbar">
                                        <!--        Here you can write extra buttons/actions for the toolbar              -->
                                    </div>
                                </div>
                                <div class="pull-left search">
                                  <!--  <input class="form-control" type="text" placeholder="Search">-->
                                    <button class="btn btn-default" type="button" id="add" name="add" title="Toggle"  onclick="addRobot()"><!-- -->
                                        <i class="glyphicon fa fa-user-plus"></i>添加
                                    </button>

                                    <!-- <button class="btn btn-default" type="button" onclick="deleteRobotAll();"  name="delete" title="Toggle">
                                        <i class="glyphicon fa fa-trash-o"></i>删除
                                    </button> -->
                                </div>

                                <div class="title_right">
                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="param" value="${param.param }" placeholder="Search for floor...">
                                            <span class="input-group-btn">
                                              <button class="btn btn-default" onclick="searchRobot()" type="button">Go!</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="fixed-table-container" style="padding-bottom: 0px;">
                                <div class="fixed-table-header" style="display: none;">
                                    <table>
                                    </table>
                                </div>
                                <div class="fixed-table-body">
                                    <div class="fixed-table-loading" style="top: 42px;">
                                        Loading, please wait...
                                    </div>
                                    <table id="bootstrap-table" class="table table-hover">
                                        <thead>
                                        <tr>
                                            <th class="bs-checkbox " style="width: 36px; " data-field="state">
                                                <div class="th-inner ">
                                                    <input name="btSelectAll" type="checkbox" onclick="DoCheck()">
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th class="text-center" style="" data-field="id">
                                                <div class="th-inner ">
                                                    ID
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                             <th>
                                                <div class="th-inner">
                                                    	名字
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	职位
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	楼层
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	用户姓名
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	状态
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th class="td-actions text-right" style="" data-field="actions">
                                                <div class="th-inner ">
                                                    	操作
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        
                                        <c:forEach items="${robotList.resultList}" var="robots" varStatus="r">
                                        <tr data-index="${r.index+1 }">
                                            <td class="bs-checkbox">
                                                <input data-index="7" value="${robots.id}" name="btSelectItem" type="checkbox">
                                            </td>
                                            <td class="text-center" style="">
                                                ${r.index+1 }
                                            </td>
                                            <td style="">
                                                	${robots.robotname}
                                            </td>
                                            <td style="">
                                                <c:if test="${robots.robotrole == '1'}">
         												客服
         										</c:if>
         										<c:if test="${robots.robotrole == '2'}">
         												表单录入
         										</c:if>
                                            </td>
                                            <td style="">
                                                	${robots.robotaddr}
                                            </td>
                                            <td style="">
                                                	${robots.robotusername}
                                            </td>
                                            <td style="">
                                                <c:if test="${robots.robotstatus == '1'}">
         												在线
         										</c:if>
         										<c:if test="${robots.robotstatus == '2'}">
         												离线
         										</c:if>
                                            </td>
                                              <td class="td-actions text-right" style="">
                                              	<a href="javascript:void(0)" onclick="bindingUser('${robots.id}')">绑定</a>
                                              	<a href="javascript:void(0)" onclick="unbindUser('${robots.id}')">解绑</a>
                                                <a rel="tooltip" title="详情" class="btn btn-simple btn-warning btn-icon table-action edit"  onclick="updateRobots('${robots.id}')" data-original-title="Edit"><i class="fa fa-edit"></i></a>
                                                <%-- <a  title="" class="btn btn-simple btn-danger btn-icon table-action remove" onclick="deleteById('${robots.id}')" data-original-title="Remove"><i class="fa fa-remove"></i></a> --%>
                                            </td>																									
                                        </tr>                                  						            
        								</c:forEach>
        								
                                        </tbody>
                                    </table>
                                </div>
                                <div class="fixed-table-footer" style="display: none;">
                                    <table>
                                        <tbody>
                                        <tr>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="fixed-table-pagination">
                                    <div class="pull-left pagination-detail">
                                        <span class="pagination-info"></span>
                                    </div>
                                    <div class="pull-right pagination">
                                     <!-- pagenation start -->
									<div id="kkpager"></div>
									 <!-- pagenation end -->
                                    </div> 
                                    
                                </div>
                            </div>
                        </div>
                    </div><!--  end card  -->
                </div> <!-- end col-md-12 -->
            </div> <!-- end row -->
		  <!--addRobot.jsp-->
            <div class="" style="display: none;" id="addRobot">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title">机器人添加</h4>
                    </div>
                    <div class="content">
                        <form method="post" action="robot/createrobot" onsubmit="return onSub();">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" id="robotid"  onblur="selectRobot()" name="id" required="true" placeholder="ID"  class="form-control" >
                            </div>
                             <div class="form-group" id="seleRobot" style="color:red; display: none;">
                               
                            </div> 
                            <div class="form-group">
                                <label>名字</label>
                                <input type="text"  id="roname" name="robotname" onblur="selectRobotName()" required="true" placeholder="名字" class="form-control">
                            </div>
                            <div class="form-group" id="rname" style="color:red; display: none;">
                               
                            </div>
                            <div class="form-group">
                                <label>职位</label>
                                 <div>
                                    <select class="form-control" name="robotrole" >
                                    	<option value="0">-请选择-</option> 
                                        <option value="1">客服</option>
                                        <option value="2">表单录入</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>楼层</label>
                                <input type="text" name="robotaddr" required="true" placeholder="楼层" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>密码</label>
                                <input type="text" name="robotpwd" required="true" placeholder="密码" class="form-control">
                            </div>
                            <button type="submit" class="btn btn-fill btn-info">确定</button>
                            <!-- <button class="btn  btn-default">取消</button> -->
                        </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end addRobot  -->
            
            <!--updateRobot.jsp-->
            <div class="" style="display: none;" id="updateRobot">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title">机器人修改</h4>
                    </div>
                    <div class="content">
                        <form method="post" action="robot/updaterobot">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text"  id="updaterobotId" placeholder="ID" name="id"  class="form-control" readOnly>
                            </div>
                            <div class="form-group">
                                <label>名字</label>
                                <input type="text" id="updaterobotname" name="robotname" required="true" placeholder="名字" class="form-control" readOnly>
                            </div>
                            <div class="form-group">
                                <label>职位</label>
                                 <div>
                                    <select id="updaterobotrole" name="robotrole" class="form-control">             	                            
                                        <option value="1">客服</option>
                                        <option value="2">表单录入</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>楼层</label>
                                <input type="text" id="updaterobotaddr" name="robotaddr" required="true" placeholder="楼层" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>密码</label>
                                <input type="text" id="updaterobotpwd" name="robotpwd" required="true" placeholder="密码 "class="form-control" readOnly>
                            </div>
                            <button type="submit" class="btn btn-fill btn-info">确定</button>
                            <button class="btn  btn-default">取消</button>
                        </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end updateRobot  -->
            
        </div>
    </div>
</div>
<script type="text/javascript">
//用户绑定机器人
function bindingUser(id){
	$.ajax({
 		type : "POST",
 		url  : "robot/bindingUsers",
 		data : {"id":id},
 		datatype : "json",
 		success : function(data) {
 			//console.log(data.msg);
 			alert(data.msg);
 			updateRobot();
 		}
 	});
 	
}
//用户解除机器人绑定
function unbindUser(id){
	$.ajax({
 		type : "POST",
 		url  : "robot/unbindUsers",
 		data : {"id":id},
 		datatype : "json",
 		success : function(data) {
 			//console.log(data.msg);
 			alert(data.msg);
 			updateRobot();
 		}
 	});
 	
}
//绑定后刷新页面
function updateRobot(){
	var param=$("#param").val();
	var pageNo = ${robotList.page};
    window.location.href="<%=basePath%>robot?pageCount="+pageNo+"&param="+param;
}

function selectRobot(){
	$.ajax({
 		type : "POST",
 		url  : "robot/selectrobotid",
 		data : {"id":$("#robotid").val()},
 		datatype : "json",
 		success : function(data) {
 			var result = eval('(' + data + ')');
 			if(result==2){
 				$("#seleRobot").text("请输入ID");
 			}else if(result==0){
 				$("#seleRobot").text("ID重复");
 			}else{
 				$("#seleRobot").text("ID可用");
 			}
 			$("#seleRobot").show();
 		},
 		error : function() {
 		alert("操作有误");
 		}
 	});
};

/* 
 *author：gq 
 *desc:pagenation start
 */
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}

//init
$(function(){
	var param=$("#param").val();
	var totalPage = ${robotList.totalPages};
	var totalRecords = ${robotList.totalNumber};
	//var pageNo = getParameter('pno');
	var pageNo = ${robotList.page};
	if(!pageNo){
		pageNo = 1;
	}
    //生成分页
    //有些参数是可选的，比如lang，若不传有默认值
    kkpager.generPageHtml({
        pno : pageNo,
        //总页码
        total : totalPage,
        //总数据条数
        totalRecords : totalRecords,
        //链接前部
        hrefFormer : 'robot',
        //链接尾部
        hrefLatter : '',
        getLink : function(n){
            return this.hrefFormer + this.hrefLatter + "?pageCount="+n+"&param="+param;
        },
        lang : {
            firstPageText : '&laquo',
            lastPageText : '&raquo',
            prePageText : '上一页',
            nextPageText : '下一页',
            totalPageBeforeText : '共',
            totalPageAfterText : '页',
            totalRecordsAfterText : '条数据',
            gopageBeforeText : '转到',
            gopageButtonOkText : 'Go',
            gopageAfterText : '页',
            buttonTipBeforeText : '第',
            buttonTipAfterText : '页'
        }
    });
});

function searchRobot(){
	var param=$("#param").val();
	var pageNo = ${robotList.page};
	location.href="<%=basePath%>robot?pageCount="+pageNo+"&param="+param;
 }
 
 function updateRobots(id){
        	 $.ajax({
         		type : "POST",
         		url : "robot/selectupdateRobot",
         		data : {"id":id},
         		datatype : "json",
         		success : function(data) {
         			$("#updaterobotId").val(data.id);   
         			$("#updaterobotname").val(data.robotname);
         			$("#updaterobotrole option[value='"+data.robotrole+"']").attr("selected", true);     
					$("#updaterobotaddr").val(data.robotaddr);
					$("#updaterobotcount").val(data.robotcount);
					$("#updaterobotpwd").val(data.robotpwd);
         		},
         		error : function() {
         		alert("服务异常");
         		}
         	}); 
           	 layer.open({
                    type: 1,
                    title: false,
                    closeBtn: 1,
                    area: '516px',
                    shadeClose: false,
                    content: $("#updateRobot"),
                    end: function(){
                        $("#updateRobot")[0].style.display="none" ;					
                    }	
                });
        };
        
function selectRobotName(){
	$.ajax({
 		type : "POST",
 		url  : "robot/selectRobotName",
 		data : {"robotname":$("#roname").val(),"id":$("#robotid").val()},
 		datatype : "json",
 		success : function(data) {
 			var result = eval('(' + data + ')');
 			if(result==2){
 				$("#rname").text("请输入名字");
 			}else if(result==0){
 				$("#rname").text("名字重复");			
 			}else if(result==1){
 				$("#rname").text("名字可用");
 			}
 			$("#rname").show();
 		},
 		error : function() {
 			alert("操作有误");
 		}
 	});
}

 function onSub(){
 	var rs=$("#seleRobot").text();
 	var rn =$("#rname").text();
 	if(rs=="ID可用" && rn=="名字可用"){
 		return true;
 	}else if(rs=="ID重复" || rs=="请输入ID"){
 		return false;
 	}
};
/* 
 *author：gq 
 *desc:pagenation end 
 */
</script>
</body>
<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
<script src="<%=basePath%>js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery-ui.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/bootstrap.min.js" type="text/javascript"></script>


<!--  Forms Validations Plugin -->
<script src="<%=basePath%>js/jquery.validate.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="<%=basePath%>js/moment.min.js"></script>
<!--  Date Time Picker Plugin is included in this js file -->
<script src="<%=basePath%>js/bootstrap-datetimepicker.js"></script>
<!-- 全选 -->
<%-- <script src="<%=basePath%>js/CheckBox.js"></script> --%>
</html>
