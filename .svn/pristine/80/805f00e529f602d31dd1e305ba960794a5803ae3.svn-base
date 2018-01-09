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
    
    <title>My JSP 'userQuery.jsp' starting page</title>
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
    <!-- 时间段 -->
    <script src="<%=basePath%>css/wdatePicker/lang/zh-cn.js" charset="UTF-8"></script><!-- 时间段 -->
	<script type="text/javascript" src="<%=basePath%>css/wdatePicker/datepicker.js"></script><!-- 时间段 -->
	<script type="text/javascript" src="<%=basePath%>css/wdatePicker/WdatePicker.js"></script><!-- 时间段 -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/wdatePicker/skin/default/datepicker.css"><!-- 时间段 -->
	<!-- 全选 -->
	<script src="<%=basePath%>js/CheckBox.js"></script>
	
	<script type="text/javascript">
	
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
                            <h4 class="title">角色管理</h4>
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
                                    <button class="btn btn-default" type="button" id="add" name="add" title="Toggle"  onclick="addPatient()"><!-- -->
                                        <i class="glyphicon fa fa-user-plus"></i>添加
                                    </button>

                                    <!-- <button class="btn btn-default" type="button" name="delete" title="Toggle">
                                        <i class="glyphicon fa fa-trash-o"></i>删除
                                    </button> -->
                                </div>

                                <div class="title_right">
                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="params" value="${map.param }" placeholder="Search for...">
                                            <span class="input-group-btn">
                                              <button class="btn btn-default" onclick="searchPatient()" type="button">Go!</button>
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
                                                    	角色名称
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	基本权限
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
                                     		<c:forEach items="${map.page.resultList}" var="role" varStatus="ro">
									            <tr data-index="${ro.index+1 }">
                                            		<td class="bs-checkbox">
                                                		<input data-index="7" name="btSelectItem" type="checkbox">
                                            		</td>
                                            		 <td class="text-center">${ro.index+1 }</td>
									                <td>${role.role}</td>
									               <%--  <td>${role.description}</td> --%>
									                <td>${zhangfn:resourceNames(role.resourceIds)}</td>
									                <td class="td-actions text-right" style="">
		                                                <a rel="tooltip" title="详情" class="btn btn-simple btn-warning btn-icon table-action edit" onclick="updatePatient(${role.id})" data-original-title="Edit"><i class="fa fa-edit"></i></a>
		                                                <!-- <a  title="" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" data-original-title="Remove"><i class="fa fa-remove"></i></a>  -->                                             
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
									<div style="width:800px;margin:0 auto;">
									<div id="kkpager"></div>
									</div>
									 <!-- pagenation end -->
                                    </div> 
                                    
                                </div>
                            </div>
                        </div>
                    </div><!--  end card  -->
                </div> <!-- end col-md-12 -->
            </div> <!-- end row -->
		  <!--addPatient.jsp-->
            <div class="" style="display: none;" id="addPatient">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title">角色添加</h4>
                    </div>
                    <div class="content">
                      <form method="POST" action="role/create">
                            <div class="form-group">
                                <label>角色名称</label>
                                <input type="text" id="role" name="role" required="true" placeholder="角色名称" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>角色简介</label>
                                <input type="text" name="description" required="true" placeholder="角色简介" class="form-control">
                            </div>
                            <div class="form-group" style="color:red;display: none">                               
                                <input type="text" name="resourceIds" id="resourceIds" value="">
                            </div>
                            <div class="form-group">
                                <label>基础权限</label>
                              <div>
                                    <label class="checkbox" name="btSelectAlls" onclick="Check()">全选
                                         <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                        <span class="second-icon fa fa-check-square-o"></span> </span>
                                        <input type="checkbox"   data-toggle="checkbox" value="">
                                    </label>
                             </div>
							  </div>
                                   <div class="form-group">
                                   <div style="float:left;width:50%;">
                                   	 <label class="checkbox" name="btSelectItems">用户查询
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="11">
                                     </label>
                                     <label class="checkbox" name="btSelectItems">账号管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="21">
                                     </label>
                                     <label class="checkbox" name="btSelectItems">机器人管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="51">
                                     </label>
                                     <label class="checkbox" name="btSelectItems">表单管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="71">
                                     </label>
                                   </div>
                                 
                                   <div style="float:right;width:50%;">
                                   	   <label class="checkbox" style="width:80px" name="btSelectItems">部门管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="61">
                                            </label>
                                              <label class="checkbox" name="btSelectItems">角色管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="41">
                                            </label>
                                                <label class="checkbox" name="btSelectItems">客服管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="81">
                                            </label>
                                             </label>
                                                <label class="checkbox" name="btSelectItems">翻译管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="91">
                                            </label>
                                   </div>
							  </div>
                
                            <button type="submit" class="btn btn-fill btn-info" onclick="return getresources()">确定</button>
                            <!-- <button type="text" class="btn  btn-default">取消</button> -->
                         </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end addPatient  -->
            <!--  start updatePatient -->
            <div class="" style="display: none;" id="updatePatient">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title">角色更新</h4>
                    </div>
                    <div class="content">
                      <form method="POST" action="role/update2">
                            <div class="form-group">
                                <label>角色名称</label>
                                <input type="text" id="updaterole" name="role" required="true" placeholder="角色名称" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>角色简介</label>
                                <input type="text" id="updatedescription" name="description" required="true" placeholder="角色简介" class="form-control">
                            </div>
                            <div class="form-group" style="display: none">                               
                                <input type="text" name="id" id="updateId" value="">
                            </div>
                            <div class="form-group" style="color:red;display: none">                               
                                <input type="text" name="resourceIds" id="updateresourceIds" value="">
                            </div>
                            <div class="form-group">
                                <label>基础权限</label>
                              <div>
                                    <label class="checkbox" name="updatebtSelectAlls" onclick="updateCheck()">全选
                                         <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                        <span class="second-icon fa fa-check-square-o"></span> </span>
                                        <input type="checkbox"   data-toggle="checkbox" value="">
                                    </label>
                             </div>
							  </div>
                                   <div class="form-group">
                                   <div style="float:left;width:50%;">
                                   	 <label class="checkbox" name="updatebtSelectItems">用户查询
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="11">
                                     </label>
                                     <label class="checkbox" name="updatebtSelectItems">账号管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="21">
                                     </label>
                                     <label class="checkbox" name="updatebtSelectItems">机器人管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="51">
                                     </label>
                                     <label class="checkbox" name="updatebtSelectItems">表单管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="71">
                                     </label>
                                   </div>
                                 
                                   <div style="float:right;width:50%;">
                                   	   <label class="checkbox" style="width:80px" name="updatebtSelectItems">部门管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="61">
                                            </label>
                                              <label class="checkbox" name="updatebtSelectItems">角色管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="41">
                                            </label>
                                                <label class="checkbox" name="updatebtSelectItems">客服管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="81">
                                            </label>
                                            </label>
                                                <label class="checkbox" name="updatebtSelectItems">翻译管理
                                                <span class="icons"><span class="first-icon fa fa-square-o"></span>
                                                <span class="second-icon fa fa-check-square-o"></span>
                                                </span><input type="checkbox" data-toggle="checkbox" value="91">
                                            </label>
                                   </div>
							  </div>
                
                            <button type="submit" class="btn btn-fill btn-info" onclick="return updateresources()">确定</button>
                            <!-- <button type="text" class="btn  btn-default">取消</button> -->
                         </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!-- end updatePatient -->
        </div>
    </div>
</div>
<script type="text/javascript">
/*
 * desc:单选取值
 */
function getresources(){	 
	var items=document.getElementsByName("btSelectItems");
	var arr=[];
 	for(var i=0;i<items.length;i++){
		var classname=items[i].className;
		if(classname.indexOf("checked")>0){
			arr.push(items[i].childNodes[3].value);
		}
	}
 	var role=$("#role").val();
 	if(role=null||role==""){
 		alert("请输入用户名");
 		return false;
 	}		
 	if(arr.length==0){
 		alert("请选择权限");
 		return false;
 	}else{
 		$("#resourceIds").val(arr);
 		return true;
 	}	
};
function updateresources(){	 
	var items=document.getElementsByName("updatebtSelectItems");
	var arr=[];
 	for(var i=0;i<items.length;i++){
		var classname=items[i].className;
		if(classname.indexOf("checked")>0){
			arr.push(items[i].childNodes[3].value);
		}
	}
 	var role=$("#updaterole").val();
 	if(role=null||role==""){
 		alert("请输入用户名");
 		return false;
 	}		
 	if(arr.length==0){
 		alert("请选择权限");
 		return false;
 	}else{
 		$("#updateresourceIds").val(arr);
 		return true;
 	}			
	
}
</script>
<script type="text/javascript">




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
	var params=$("#params").val();
	var totalPage = ${map.page.totalPages};
	var totalRecords = ${map.page.totalNumber};
	//var pageNo = getParameter('pno');
	var pageNo = ${map.page.page};
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
        hrefFormer : 'role',
        //链接尾部
        hrefLatter : '',
        getLink : function(n){
            return this.hrefFormer + this.hrefLatter + "?pageCount="+n+"&params="+params;
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

function searchPatient(){
	var params=$("#params").val();
	var pageNo = ${map.page.page};
	location.href="<%=basePath%>role?pageCount="+pageNo+"&param="+params;
 }
 
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

<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
	<script src="js/bootstrap-checkbox-radio-switch-tags.js"></script>
<!--  Forms Validations Plugin -->
<script src="<%=basePath%>js/jquery.validate.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="<%=basePath%>js/moment.min.js"></script>
<!--  Date Time Picker Plugin is included in this js file -->
<script src="<%=basePath%>js/bootstrap-datetimepicker.js"></script>

</html>
