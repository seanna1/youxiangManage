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
	 <script type="text/javascript">
        function addUser(){
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                area: '516px',
                shadeClose: false,
                content: $('#addUser'),
                end: function(){
                    $("#addUser")[0].style.display="none"

                }
            });
        }
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
                            <h4 class="title">账号管理</h4>
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
                                    <button class="btn btn-default" type="button" id="add" name="add" title="Toggle"  onclick="addUser()"><!-- -->
                                        <i class="glyphicon fa fa-user-plus"></i>添加
                                    </button>

                                    <button class="btn btn-default" type="button" name="delete" title="Toggle">
                                        <i class="glyphicon fa fa-trash-o"></i>删除
                                    </button>
                                </div>

                                <div class="title_right">
                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="param" value="${param.param }" placeholder="Search for...">
                                            <span class="input-group-btn">
                                              <button class="btn btn-default" onclick="searchUser()" type="button">Go!</button>
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
                                                    	用户名
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	真实姓名
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	部门
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner ">
                                                    	角色名称
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
										<c:forEach items="${userList.resultList}" var="user" varStatus="u">
                                        
                                        <tr data-index="${u.index+1 }">
                                            <td class="bs-checkbox">
                                                <input data-index="6" name="btSelectItem" type="checkbox">
                                            </td>
                                            <td class="text-center" style="">
                                                ${u.index+1 }
                                            </td>
                                            <td style="">
                                                	${user.username}
                                            </td>
                                            <td style="">
                                               	${user.username}
                                            </td>
                                            <td style="">
                                                	${zhangfn:organizationName(user.organizationId)}
                                            </td>
                                            <td style="">
                                                	${zhangfn:roleNames(user.roleIds)}
                                            </td>
                                            <td class="td-actions text-right" style="">
                                               <!--  <a  title="" class="btn btn-simple btn-info btn-icon table-action view" href="javascript:void(0)" data-original-title="View"><i class="fa fa-image"></i></a> -->
                                                <a  title="" class="btn btn-simple btn-warning btn-icon table-action edit" href="javascript:void(0)" data-original-title="Edit"><i class="fa fa-edit"></i></a>
                                                <a  title="" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" data-original-title="Remove"><i class="fa fa-remove"></i></a>
                                            </td>
                                        </tr>                                  						            
        								</c:forEach>
                                        <!-- <tr data-index="0">
                                            <td class="bs-checkbox">
                                                <input data-index="6" name="btSelectItem" type="checkbox">
                                            </td>
                                            <td class="text-center" style="">
                                                A007
                                            </td>
                                            <td style="">
                                                	小王
                                            </td>
                                            <td style="">
                                               	吴丽丽
                                            </td>
                                            <td style="">
                                                	技术部
                                            </td>
                                            <td style="">
                                                	普通用户
                                            </td>
                                            <td class="td-actions text-right" style="">
                                                <a  title="" class="btn btn-simple btn-info btn-icon table-action view" href="javascript:void(0)" data-original-title="View"><i class="fa fa-image"></i></a>
                                                <a  title="" class="btn btn-simple btn-warning btn-icon table-action edit" href="javascript:void(0)" data-original-title="Edit"><i class="fa fa-edit"></i></a>
                                                <a  title="" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" data-original-title="Remove"><i class="fa fa-remove"></i></a>
                                            </td>
                                        </tr>
                                        <tr data-index="1">
                                            <td class="bs-checkbox">
                                                <input data-index="7" name="btSelectItem" type="checkbox">
                                            </td>
                                            <td class="text-center" style="">
                                                A008
                                            </td>
                                            <td style="">
                                                	王丽
                                            </td>
                                            <td style="">
                                                	王丽丽
                                            </td>
                                            <td style="">
                                               	产品部
                                            </td>
                                            <td style="">
                                               	超级管理员
                                            </td>
                                            <td class="td-actions text-right" style="">
                                                <a  title="" class="btn btn-simple btn-info btn-icon table-action view" href="javascript:void(0)" data-original-title="View"><i class="fa fa-image"></i></a>
                                                <a  title="" class="btn btn-simple btn-warning btn-icon table-action edit" href="javascript:void(0)" data-original-title="Edit"><i class="fa fa-edit"></i></a>
                                                <a  title="" class="btn btn-simple btn-danger btn-icon table-action remove" href="javascript:void(0)" data-original-title="Remove"><i class="fa fa-remove"></i></a>
                                            </td>
                                        </tr> -->
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
		  <!--addUser.jsp-->
            <div class="" style="display: none;" id="addUser">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title">账号添加</h4>
                    </div>
                    <div class="content">
                        <form method="#" action="#">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" placeholder="ID" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>用户名</label>
                                <input type="password" placeholder="用户名" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>真实姓名</label>
                                <input type="password" placeholder="真实姓名" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>部门名称</label>
                                 <div>
                                    <select class="form-control">
                                        <option value="">fad</option>
                                        <option value="">fa</option>
                                        <option value="">df</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>角色名称</label>
                                 <div>
                                    <select class="form-control">
                                        <option value="">fad</option>
                                        <option value="">fa</option>
                                        <option value="">df</option>
                                    </select>
                                </div>
                            </div>
                           
                            <button type="submit" class="btn btn-fill btn-info">确定</button>
                            <button type="text" class="btn  btn-default">取消</button>
                        </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end addUser  -->
        </div>
    </div>
</div>
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
	var param=$("#param").val();
	var totalPage = ${userList.totalPages};
	var totalRecords = ${userList.totalNumber};
	//var pageNo = getParameter('pno');
	var pageNo = ${userList.page};
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
        hrefFormer : 'user',
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

function searchUser(){
	var param=$("#param").val();
	var pageNo = ${userList.page};
	location.href="<%=basePath%>user?pageCount="+pageNo+"&param="+param;
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


<!--  Forms Validations Plugin -->
<script src="<%=basePath%>js/jquery.validate.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="<%=basePath%>js/moment.min.js"></script>
<!--  Date Time Picker Plugin is included in this js file -->
<script src="<%=basePath%>js/bootstrap-datetimepicker.js"></script>
<!-- 全选 -->
<script src="<%=basePath%>js/CheckBox.js"></script>
</html>
