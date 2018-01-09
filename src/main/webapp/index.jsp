<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!--  Light Bootstrap Dashboard core CSS    -->
    <link href="<%=basePath%>css/light-bootstrap-.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />
        <!--     Fonts and icons     -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet">
    <link href='<%=basePath%>css/common.css' rel='stylesheet' type='text/css'>
    <link href="<%=basePath%>css/pe-icon-7-stroke.css" rel="stylesheet" />
    
  </head>
  
  <body>

<div class="wrapper">
    <div class="sidebar" data-color="orange" >
        <!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

        <div class="logo">
            <a href="javascript:void(0)" class="logo-text">
                优翔医疗后台管理系统
            </a>
        </div>
        <div class="logo logo-mini">
            <a href="javascript:void(0)" class="logo-text">
                优翔医疗
            </a>
        </div>
        <div class="sidebar-wrapper" style="    overflow: hidden;">
            <div class="user">
                <div class="photo">
                   <img src="picture/default-avatar.png" /> 
                    <!-- <img src="picture/ logo-1.gif" /> -->
                    
                   
                </div>
                <div class="info">
                    <a  class="collapsed">
                        欢迎&nbsp;<shiro:principal/>
                        <a href="${pageContext.request.contextPath}/logout">退出</a>
                    </a>

                </div>
            </div>

            <ul class="nav">
					<c:forEach items="${menus}" var="m">
						<c:choose>
							<c:when test="${m.id== 71}">
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/${m.url}"
									target="right"> <i class="${m.classType }"></i>
										<p>${m.name}</p>
								</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</ul>
        </div>
    </div>
    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-minimize">
                    <button id="minimizeSidebar" class="btn btn-warning btn-fill btn-round btn-icon">
                        <i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i>
                        <i class="fa fa-navicon visible-on-sidebar-mini"></i>
                    </button>
                </div>
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Back-stage management</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="javascript:void(0)">
                                <i class="fa fa-line-chart"></i>
                                <p>Stats</p>
                            </a>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-gavel"></i>
                                <p class="hidden-md hidden-lg">
                                    Actions
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="javascript:void(0)">Create New Post</a></li>
                                <li><a href="javascript:void(0)">Manage Something</a></li>
                                <li><a href="javascript:void(0)">Do Nothing</a></li>
                                <li><a href="javascript:void(0)">Submit to live</a></li>
                                <li class="divider"></li>
                                <li><a href="javascript:void(0)">Another Action</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-bell-o"></i>
                                <span class="notification">5</span>
                                <p class="hidden-md hidden-lg">
                                    Notifications
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="javascript:void(0)">Notification 1</a></li>
                                <li><a href="javascript:void(0)">Notification 2</a></li>
                                <li><a href="javascript:void(0)">Notification 3</a></li>
                                <li><a href="javascript:void(0)">Notification 4</a></li>
                                <li><a href="javascript:void(0)">Another notification</a></li>
                            </ul>
                        </li>

                        <li class="dropdown dropdown-with-icons">
                            <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-list"></i>
                                <p class="hidden-md hidden-lg">
                                    More
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu dropdown-with-icons">
                           
                                <li>
                                    <a href="javascript:void(0)">
                                        <i class="pe-7s-help1"></i> Help Center
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0)">
                                        <i class="pe-7s-tools"></i> Settings
                                    </a>
                                </li>
                                <li class="divider"></li>
                              
                                <li>
                                    <a href="/medical_treatment2/logout" class="text-danger">
                                        <i class="pe-7s-close-circle"></i>
                                        Log out
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--end  header+siderbar-->

        <!--start content-->
        <iframe src="<%=basePath%>/welcome.jsp" name="right" id="right" width="100%" height="500%" frameborder="0" scrolling="no">
        </iframe>
        <!--end content-->
    </div>
</div>
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

<!--  Select Picker Plugin -->
<script src="<%=basePath%>js/bootstrap-selectpicker.js"></script>

<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
<script src="<%=basePath%>js/bootstrap-checkbox-radio-switch-tags.js"></script>

<!--  Charts Plugin -->
<script src="<%=basePath%>js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="<%=basePath%>js/bootstrap-notify.js"></script>

<!-- Sweet Alert 2 plugin -->
<script src="<%=basePath%>js/sweetalert2.js"></script>

<!-- Vector Map plugin -->
<script src="<%=basePath%>js/jquery-jvectormap.js"></script>

<!--  Google Maps Plugin    -->
<script src="<%=basePath%>js/aa.js"></script>

<!-- Wizard Plugin    -->
<script src="<%=basePath%>js/jquery.bootstrap.wizard.min.js"></script>

<!--  Bootstrap Table Plugin    -->
<script src="<%=basePath%>js/bootstrap-table.js"></script>

<!--  Plugin for DataTables.net  -->
<script src="<%=basePath%>js/jquery.datatables.js"></script>
<!--  Full Calendar Plugin    -->
<script src="<%=basePath%>js/fullcalendar.min.js"></script>

<!-- Light Bootstrap Dashboard Core javascript and methods -->
<script src="<%=basePath%>js/light-bootstrap-dashboard.js"></script>
<!--   Sharrre Library    -->
<script src="<%=basePath%>js/jquery.sharrre.js"></script>
</html>
