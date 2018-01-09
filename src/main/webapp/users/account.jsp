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
        function addPatient(){
        	$("#title").text("用户添加");
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                area: '516px',
                shadeClose: false,
                content: $('#addPatient'),
                end: function(){
                    $("#addPatient")[0].style.display="none";
                }
            });
        }
        function deleteById(id){
        	layer.confirm("你确定删除选中的信息吗?", function(){  
		            window.location.href="<%=basePath%>patient/deletePatientById?id="+ id;
		        });  
        }
         function updatePatients(id){
        	 $.ajax({
         		type : "POST",
         		url  : "patient/selectupdatePatient",
         		data : {"id":id},
         		datatype : "json",
         		success : function(data) {
         			/* var result = eval('(' + data + ')'); */
         			$("#updatepatientId").val(data.id);        			
         			$("#updatepatientnumber").val(data.patientnumber);
         			$("#updatepatientname").val(data.patientname); 
         			if(data.gender==true){
         				$("#updatepatientgender").val("男");
         			}
         			else if(data.gender==false){
         				$("#updatepatientgender").val("女");
         			}
         			$("#updatepatientheight").val(data.height);
         			$("#updatepatientweight").val(data.weight);
         			$("#updatepatientbirthday").val(data.birthday);
					$("#updatepatientnation").val(data.nation);
					$("#updatepatientphone").val(data.phone);
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
                    content: $('#updatePatients'),
                    end: function(){
                        $("#updatePatients")[0].style.display="none";				
                    }	
                });
        };
		function deletePatientAll(id){      
		    if(id==undefined){  
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
		            location.href="<%=basePath%>patient/deletepatient?id="+ delId;  
		        });  
		    };  
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
                            <h4 class="title">用户查询</h4>
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

                                    <button class="btn btn-default" type="button" onclick="deletePatientAll();"  name="delete" title="Toggle">
                                        <i class="glyphicon fa fa-trash-o"></i>删除
                                    </button>
                                </div>

                                <div class="title_right">
                                    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="params" value="${params.params }" placeholder="Search for name...">
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
                                                    	病历号
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	姓名
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	性别
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner">
                                                    	身高/cm
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                             <th>
                                                <div class="th-inner">
                                                    	体重/kg
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner ">
                                                    	出生日期
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                             <th>
                                                <div class="th-inner ">
                                                    	民族
                                                </div>
                                                <div class="fht-cell">
                                                </div>
                                            </th>
                                            <th>
                                                <div class="th-inner ">
                                                    	联系方式
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
                                      <c:forEach items="${patientList.resultList}" var="patients" varStatus="p">
                                        <tr data-index="${p.index+1 }">
                                            <td class="bs-checkbox">
                                                <input data-index="7" value="${patients.id }" name="btSelectItem" type="checkbox">
                                            </td>
                                            
                                            <td class="text-center" style="">
                                                ${p.index+1 }
                                            </td>
                                            <td style="">
                                               	${patients.patientnumber}
                                            </td>
                                            <td style="">
                                               	${patients.patientname}
                                            </td>
                                            <td style="">
												<c:if test="${patients.gender== true}">
         												男
         										</c:if>
         										<c:if test="${patients.gender== false}">
         												女
         										</c:if>
                                            </td>
                                            <td style="">
                                               	${patients.height}
                                            </td>
                                            <td style="">
                                               	${patients.weight}
                                            </td>
                                            <td style="">
                                               	${patients.birthday}
                                            </td>
                                            <td style="">
                                               	${patients.nation}
                                            </td>
                                            <td style="">
                                               	${patients.phone}
                                            </td>
                                            <td class="td-actions text-right">
                                                <a  rel="tooltip" title="详情" class="btn btn-simple btn-warning btn-icon table-action edit" onclick="updatePatients(${patients.id})" ><i class="fa fa-edit"></i></a>
                                                <a rel="tooltip" title="删除" class="btn btn-simple btn-danger btn-icon table-action remove" onclick="deleteById(${patients.id});"><i class="fa fa-remove"></i></a>
                                                <a  rel="tooltip" title="表单录入" class="btn btn-simple btn-info btn-icon table-action " href="<%=basePath%>formInput?id=${patients.id}" ><i class="fa fa-user" ></i></a>
                                        </tr> 																											<%-- href="patient/${patients.id}/delete"  --%>
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
		  <!--addPatient.jsp-->
            <div class="" style="display: none;" id="addPatient">
                <div class="card">
                    <div class="header">
                        <!--<i class="pe-7s-back"></i>-->
                        <h4 class="title" id="title">用户添加</h4>
                    </div>
                    <div class="content">
                        <form method="post" action="patient/createpatient"  id="submit"  onsubmit="return toSubmit();">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" placeholder="ID" name="id" class="form-control" readOnly>
                            </div>
                            <div class="form-group">
                                <label>病历号</label>
                                <input type="text"  id="patientnumber" onblur="selectPatient()" name="patientnumber" required="true"  placeholder="病历号" class="form-control" >
                            </div>
                            <div class="form-group" id="selePatient" style="color:red; display: none;">
                               
                            </div> 
                            <div class="form-group">
                                <label>姓名</label>
                                <input type="text"  id="patientname" name="patientname"  required="true" placeholder="姓名"  class="form-control">
                            </div>
                            <div class="form-group" id="pname" style="color:red; display: none;">
                               
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <input type="text"  id="patientgender" name="gender" required="true"  placeholder="性别 男/女" class="form-control">
                            	<div class="form-group" id="pgender" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                            <div class="form-group">
                                <label>身高/cm</label>
                                 <input type="text"  id="patientheight" name="height" required="true" maxlength="3" placeholder="身高" class="form-control">
                            	<div class="form-group" id="pheight" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                            <div class="form-group">
                                <label>体重/kg</label>
                                 <input type="text"  id="patientweight"name="weight" required="true" maxlength="3" placeholder="体重" class="form-control">
                            	<div class="form-group" id="pweight" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                            <div class="form-group">
                                <label>出生日期</label>
                                <input type="text" id="patientbirthday" name="birthday" required="true"  placeholder="出生日期" class="form-control"   value=""  autocomplete="off" onClick="datePick_beginYMD('lastTime')">
                            	<div class="form-group" id="pbirthday" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                             <div class="form-group">
                                <label>民族</label>
                                 <input type="text"  id="patientnation"name="nation" required="true"  placeholder="民族" class="form-control">
                            	<div class="form-group" id="pnation" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                            <div class="form-group">
                                <label>联系方式</label>
                                 <input type="text" id="patientphone" name="phone" required="true"  maxlength="11" placeholder="联系方式" class="form-control">
                            	<div class="form-group" id="pphone" style="color:red; display: none;">
                               
                            	</div>
                            </div>
                            <input type="submit" value="确定" class="btn btn-fill btn-info">
                            <!-- <button type="submit" class="btn btn-fill btn-info">确定</button>
                            <button type="text" class="btn  btn-default">取消</button> -->
                        </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end addPatient  -->
            
            <!--updatePatient.jsp-->
            <div class="" style="display: none;" id="updatePatients">
                <div class="card">
                    <div class="header">
                        <h4 class="title" id="title">用户修改</h4>
                    </div>
                    <div class="content">
                        <form method="post" action="patient/updatepatient">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text"  id="updatepatientId" placeholder="ID" name="id" class="form-control" readOnly>
                            </div>
                            <div class="form-group">
                                <label>病历号</label>
                                <input type="text"  id="updatepatientnumber"  name="patientnumber" placeholder="病历号" class="form-control" readOnly>
                            </div> 
                            <div class="form-group">
                                <label>姓名</label>
                                <input type="text"  id="updatepatientname" name="patientname" required="true" placeholder="姓名" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <input type="text"  id="updatepatientgender"  name="gender" required="true" placeholder="性别 男/女" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>身高(unit：cm)</label>
                                <input type="text"  id="updatepatientheight"  name="height" required="true" maxlength="3" placeholder="身高" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>体重(unit：kg)</label>
                                <input type="text"  id="updatepatientweight"  name="weight" required="true" maxlength="3" placeholder="体重" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>出生日期</label>
                                <input type="text" id="updatepatientbirthday"   name="birthday" required="true" placeholder="出生日期" class="form-control"   value=""  autocomplete="off" onClick="datePick_beginYMD('lastTime')">
                               
                            </div>
                             <div class="form-group">
                                <label>民族</label>
                                 <input type="text"  id="updatepatientnation" name="nation" required="true"  placeholder="民族" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>联系方式</label>
                                 <input type="text"  id="updatepatientphone" name="phone" required="true" maxlength="11" placeholder="联系方式" class="form-control">
                            </div>
                            <!-- <input type="submit" value="确定" class="btn btn-fill btn-info"> -->
                            <button type="submit" class="btn btn-fill btn-info">确定</button>
                            <button type="text" class="btn  btn-default">取消</button>
                        </form>
                    </div>
                </div> <!-- end card -->
            </div>
            <!--end updatePatient  -->
        </div>
    </div>
</div>
<script type="text/javascript">
function selectPatient(){
	$.ajax({
 		type : "POST",
 		url  : "patient/selectpatientnumber",
 		data : {"patientnumber":$("#patientnumber").val()},
 		datatype : "json",
 		success : function(data) {
 			var result = eval('(' + data + ')');
 			if(result==2){
 				$("#selePatient").text("请输入病历号");
 			}else if(result==0){
 				$("#selePatient").text("病历号重复");			
 			}else if(result==1){
 				$("#selePatient").text("病例号可用");
 			}
 			$("#selePatient").show();
 		},
 		error : function() {
 			alert("操作有误");
 		}
 	});
}		
function checkname(){
	var vname=$('#patientname').val();
	if(vname.length<=0){
		//$('#pname').text('请输入姓名').show();
		return false;
	}else{
		//$('#pname').text('可用').show();
		return true;
	}
}
function checkgender(){
	var vgender=$('#patientgender').val();	
	if(vgender==null || vgender==""){
		return false;
	}else{
		return true;
	}
}
function checkbirthday(){
	var vbirthday=$('#patientbirthday').val();	
	if(vbirthday==null || vbirthday==""){
		return false;
	}else{
		return true;
	}
}
function checknation(){
	var vnation=$('#patientnation').val();	
	if(vnation==null || vnation==""){
		return false;
	}else{
		return true;
	}
}
function checkphone(){
	var vphone=$('#patientphone').val();	
	if(vphone.length==11){
		return true;
	}else{
		return false;
	}
}
		//验证提交
        function toSubmit(){
        	var ve = $("#selePatient").text();
			var res=[checkname(),checkgender(),checkbirthday(),checknation(),checkphone()];
			if(ve == "病例号可用"){
				/* for(idx in res){
					if(res[idx]){
						return true;
					}
				} */
				return true;
			}else if(ve=="病历号重复"||ve=="请输入病历号"){
				/* for(idx in res){
					if(!res[idx]){
						return false;
					}
				} */
				return false;
			 }
        }
		$(function(){
			$('#patientname').blur(checkname);
			$('#patientgender').blur(checkgender);
			$('#patientbirthday').blur(checkbirthday);
			$('#patientnation').blur(checknation);
			$('#patientphone').blur(checkphone);
		});
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
	var totalPage = ${patientList.totalPages};
	var totalRecords = ${patientList.totalNumber};
	//var pageNo = getParameter('pno');
	var pageNo = ${patientList.page};
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
        hrefFormer : 'patient',
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
	var pageNo = ${patientList.page};
	location.href="<%=basePath%>patient?pageCount="+pageNo+"&params="+params;
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
<%-- <script src="<%=basePath%>js/CheckBoxSelect.js"></script> --%>

</html>
