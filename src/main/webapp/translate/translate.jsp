<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  contentType="text/html; charset=UTF-8"%>
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
    
    <title>My JSP 'patient.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
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
  	 <script type="text/javascript">
        function deleteById(id){
        	layer.confirm("你确定删除选中的信息吗?", function(){  
		            window.location.href="<%=basePath%>translate/deleteTranslateById?id="+ id;
		        });  
        }
         function updateTranslate(id,send){
         	//console.log(send);
        	 $.ajax({
         		type : "POST",
         		url  : "translate/selectupdateTranslate",
         		data : {"id":id,"send":send},
         		datatype : "json",
         		success : function(data) {
					//console.log(data.msg); 
         		},
         		error : function() {
         		alert("服务异常");
         		}
         	}); 
        }
		function deleteTranslateAll(id){      
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
		            location.href="<%=basePath%>translate/deletetranslate?id="+ delId;  
		        });  
		    };  
		} 
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
                            <h4 class="title">翻译</h4>
                        </div>
                        <div class="bootstrap-table">
                            <div class="fixed-table-toolbar">
                                <div class="bars pull-left">
                                    <div class="toolbar">
                                      
                                    </div>
                                </div>
                                <div class="pull-left search">
                                    <button class="btn btn-default" type="button" onclick="beginTranslate();">
                                        <i class="glyphicon fa fa-hourglass-start" ></i>开始
                                    </button>

                                    <button class="btn btn-default" type="button" onclick="endTranslate();">
                                        <i class="glyphicon fa fa-hourglass-end" ></i>结束
                                    </button>
                                    <button class="btn btn-default" type="button" onclick="deleteTranslateAll();"  name="delete" title="Toggle">
                                        <i class="glyphicon fa fa-trash-o"></i>删除
                                    </button>
                                </div>

                                <div class="title_right">
                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="params" value="${params.params }" placeholder="Search for translateSource...">
                                            <span class="input-group-btn">
                                              <button class="btn btn-default" onclick="searchTranslate()" type="button">Go!</button>
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
                                                    	原始语音
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	翻译语音
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
                                      <c:forEach items="${translateList.resultList}" var="translate" varStatus="t">
                                        <tr data-index="${t.index+1 }">
                                            <td class="bs-checkbox">
                                                <input data-index="7" value="${translate.id }" name="btSelectItem" type="checkbox">
                                            </td>
                                            
                                            <td class="text-center" style="">
                                                ${t.index+1 }
                                            </td>
                                            <td style="">
                                               	${translate.accept}
                                            </td>
                                            <td style="">
                                               	${translate.send}
                                            </td>
                                            <td class="td-actions text-right">
                                               <%--  <a  title="" class="btn btn-simple btn-warning btn-icon table-action edit" onclick="updateTranslate(${translate.id},${translate.send})" data-original-title="Edit"><i class="fa fa-edit"></i></a> --%>
                                                <a  rel="tooltip" title="删除" class="btn btn-simple btn-danger btn-icon table-action remove" onclick="deleteById(${translate.id});" data-original-title="Remove"><i class="fa fa-remove"></i></a>
                                                <%-- <a  title="" class="btn btn-simple btn-info btn-icon table-action " href="<%=basePath%>formInput?id=${translate.id}" data-original-title="View" ><i class="fa fa-user" ></i></a> --%>
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
                    </div>
                </div> 
            </div> 
        </div>
    </div>
</div>
<script type="text/javascript">
function getParameter(name) { 
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r!=null) return unescape(r[2]); return null;
}

//init
$(function(){
	var params=$("#params").val();
	var totalPage = ${translateList.totalPages};
	var totalRecords = ${translateList.totalNumber};
	//var pageNo = getParameter('pno');
	var pageNo = ${translateList.page};
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
        hrefFormer : 'translate',
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
    //定时刷新
    t1=setInterval("updateDates()",3000); 
});

function searchTranslate(){
	var params=$("#params").val();
	var pageNo = ${translateList.page};
	location.href="<%=basePath%>translate?pageCount="+pageNo+"&params="+params;
 }
// 定时器,动态查询翻译结果
function updateDates(){
    var params=$("#params").val();
	var pageNo = ${translateList.page};
    window.location.href="<%=basePath%>translate?pageCount="+pageNo+"&params="+params;
    
}
//var num="";//多次点击异常变量声明
var t1=null;
function beginTranslate(){
	/* num++;
	if(num>=2){
		alert("请先结束当前录入操作");
		return false;
	}else{ */
		$.ajax({
	         type : "POST",
	         url  : "translate/beginsendmsg",
	         data : {"tobeg":"beg"},
	         datatype : "json",
	         success : function(data) {
	         	//console.log(data.msg);
	         }
		});
	//}
}
function endTranslate(){
	//num=0;
	$.ajax({
	         type : "POST",
	         url  : "translate/toendsendmesgs",
	         data : {"toend":"end"},
	         datatype : "json",
	         success : function(data) {
	         	//console.log(data.msg);
	         	if(t1!=null){
         			window.clearInterval(t1);
         		}
	         }
	});
}

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
<%-- <script src="<%=basePath%>js/CheckBoxSelect.js"></script> --%>
</html>
