<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<script src="<%=basePath%>js/jquery-2.1.1.min.js"></script>
	
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
    <!-- tree -->
    <link rel="stylesheet" href="<%=basePath%>css/zTree/css/demo.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>css/zTree/css/zTreeStyle/zTreeStyle.css"	type="text/css">
    <script type="text/javascript">
        var setting = {  
        		async : {
    				enable : true,//开启异步加载处理
    				url : encodeURI(encodeURI("<%=basePath%>formInput")),
    				/* autoParam : [ "id" ], */
    				dataFilter : filter,
    				contentType : "application/json",
    				type : "POST"
    			},
    			view : {
    				expandSpeed : "",//折叠速度
    				addHoverDom : addHoverDom,//当鼠标移动到节点上时，显示用户自定义控件  
    				removeHoverDom : removeHoverDom,//离开节点时的操作  
    				selectedMulti : false//是否多选
    			},
    			edit : {
    				enable : true
    			},
    			data : {
    				simpleData : {
    					enable : true
    				}
    			},
            callback: {  
            	beforeRemove : beforeRemove,
    			beforeRename : beforeRename,
                beforeAsync: beforeAsync,  
                onAsyncSuccess: onAsyncSuccess  
            }  
        };  
  
        function filter(treeId, parentNode, childNodes) {  
            if (!childNodes) return null;  
            for (var i=0, l=childNodes.length; i<l; i++) {  
                childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');  
            }  
            return childNodes;  
        }  
  
    	function beforeRemove(treeId, treeNode) {
    		if (confirm("确认删除节点--" + treeNode.name + "--吗?")) {
    			var param = "?id=" + treeNode.id;
    			$.post(encodeURI(encodeURI("<%=basePath%>/formInput/deletePatientFrom"
    					+ param)));
    		} else {
    			return false;
    		}
    	}
    	
    	function beforeRename(treeId, treeNode, newName) {
    		if (newName.length == 0) {
    			alert("节点名称不能为空.");
    			return false;
    		}
    		var param = "?id=" + treeNode.id + "&name=" + newName;
    		$.post(encodeURI(encodeURI("<%=basePath%>/formInput/updatePatientFrom"
    				+ param)));
    		return true;
    	}
    	function addHoverDom(treeId, treeNode) {
    		var sObj = $("#" + treeNode.tId + "_span");
    		if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
    			return;
    		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
    				+ "' title='add node' onfocus='this.blur();'></span>";
    		sObj.after(addStr);
    		var btn = $("#addBtn_" + treeNode.tId);
    		if (btn)
    			btn.bind("click", function() {
    				var Ppname = prompt("请输入新节点名称");
    				if (Ppname == null) {
    					return;
    				} else if (Ppname == "") {
    					alert("节点名称不能为空");
    				} else {
    					var param ="?pId="+ treeNode.id + "&name=" + Ppname;
    					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    					$.post(
    							encodeURI(encodeURI("<%=basePath%>/formInput/addPatientFrom"
    									+ param)), function(data) {
    								if ($.trim(data) != null) {
    									var treenode = $.trim(data);
    									zTree.addNodes(treeNode, {
    										pId : treeNode.id,
    										name : Ppname
    									}, true);
    								}
    								window.location.reload();
    							})
    				}
    			});
    	};
    	function removeHoverDom(treeId, treeNode) {
    		$("#addBtn_" + treeNode.tId).unbind().remove();
    	};
        function beforeAsync() {  
            curAsyncCount++;  
        }  
          
        function onAsyncSuccess(event, treeId, treeNode, msg) {  
            curAsyncCount--;  
            if (curStatus == "expand") {  
                expandNodes(treeNode.children);  
            } else if (curStatus == "async") {  
                asyncNodes(treeNode.children);  
            }  
  
            if (curAsyncCount <= 0) {  
                curStatus = "";  
            }  
        }  
  
        var curStatus = "init", curAsyncCount = 0, goAsync = false;  
        function expandAll() {  
            if (!check()) {  
                return;  
            }  
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
            expandNodes(zTree.getNodes());  
            if (!goAsync) {  
                curStatus = "";  
            }  
        }  
        function expandNodes(nodes) {  
            if (!nodes) return;  
            curStatus = "expand";  
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
            for (var i=0, l=nodes.length; i<l; i++) {  
                zTree.expandNode(nodes[i], true, false, false);//展开节点就会调用后台查询子节点  
                if (nodes[i].isParent && nodes[i].zAsync) {  
                    expandNodes(nodes[i].children);//递归  
                } else {  
                    goAsync = true;  
                }  
            }  
        }  
  
        function check() {  
            if (curAsyncCount > 0) {  
                return false;  
            }  
            return true;  
        }  
  
        $(document).ready(function(){  
            $.fn.zTree.init($("#treeDemo"), setting);  
            setTimeout(function(){  
                expandAll("treeDemo");  
            },800);//延迟加载  
        });  
       
    </script> 
</head>
<body>
		<!-- 用于页面跳转传递ID   style="display: none;" -->
		<span id="getPid" style="display: none;">${param.id}</span>
		
<div class="wrapper">
    <!--start  content-->
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                  <div class="col-md-12">
                        <div class="card">
                            <div class="header" style="background-color: rgba(228, 224, 224, 0.38);">
                                <i class="pe-7s-back icon-pe-7s-back-lg"></i>
                            	<span class="header">表单录入</span>
                            </div>
                        </div>
          			</div>
                    <div class="col-md-3">
                        <div class="card">
                            <div class="header" >
                            	<span class="header">表单种类</span>
                            </div>
                            <div  class="content">
                            <div class="content_wrap">
								<div class="zTreeDemoBackground left">
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
                            </div>
                        </div>
                    </div>
            		<div class="col-md-9">
                        <div class="card">
                            <div class="header">
                            	<span class="header">表单录入</span>
                            </div>																					<!-- &uid=${param.id} -->
                            <iframe src="<%=basePath%>formInput/selectquestInfo?formid=21" name="content" id="content" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- tree -->
<script type="text/javascript" src="<%=basePath%>css/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="<%=basePath%>css/zTree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="<%=basePath%>css/zTree/js/jquery.ztree.exedit.js"></script>
<script src="<%=basePath%>js/userback.js"></script>
<script type="text/javascript">
function part(){
	var id=${id};
	return id;
}
</script>
</html>
