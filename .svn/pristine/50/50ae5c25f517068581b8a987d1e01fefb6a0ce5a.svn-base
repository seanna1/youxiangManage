
function compareDateById(startTime,endTime){
	var startTime = document.getElementById(startTime).value;
	var endTime = document.getElementById(endTime).value;
	return compareCalendar(startTime, endTime);      
}
//比较日前大小
function compareDate(checkStartDate, checkEndDate) {   
		var arys1= new Array();   
		var arys2= new Array();   
	if(checkStartDate != null && checkEndDate != null) {   
		arys1=checkStartDate.split('-');   
	      var sdate=new Date(arys1[0],parseInt(arys1[1]-1),arys1[2]);   
		arys2=checkEndDate.split('-');   
		var edate=new Date(arys2[0],parseInt(arys2[1]-1),arys2[2]);   
	if(sdate > edate) {   
		alert("日期开始时间大于结束时间");      
		return false;      
	}  else {
		return true;   
		}
	 }   
}  

       //判断日期，时间大小
function compareTime(startDate, endDate) {
	 if (startDate.length > 0 && endDate.length > 0) {
		var startDateTemp = startDate.split(" ");
		var endDateTemp = endDate.split(" ");
					
		var arrStartDate = startDateTemp[0].split("-");
		var arrEndDate = endDateTemp[0].split("-");
	
		var arrStartTime = startDateTemp[1].split(":");
		var arrEndTime = endDateTemp[1].split(":");
	
	var allStartDate = new Date(arrStartDate[0], arrStartDate[1], arrStartDate[2], arrStartTime[0], arrStartTime[1], arrStartTime[2]);
	var allEndDate = new Date(arrEndDate[0], arrEndDate[1], arrEndDate[2], arrEndTime[0], arrEndTime[1], arrEndTime[2]);
					
	if (allStartDate.getTime() >= allEndDate.getTime()) {
			alert("开始时间不能大于结束时间");
			return false;
	} else {
		return true;
	       }
	} else {
		alert("时间不能为空");
		return false;
	      }
}
//比较日期，时间大小
function compareCalendar(startDate, endDate) {
	if (startDate.indexOf(" ") != -1 && endDate.indexOf(" ") != -1 ) {
		//包含时间，日期
	        compareTime(startDate, endDate);			
	} else {
		//不包含时间，只包含日期
		compareDate(startDate, endDate);
	}
}



//加载资源//////////////////////////////////////////////////////
 function loadResources_t(fileName, type) {
		var _script = 'script' , _css = 'css';
		
		var _head = document.getElementsByTagName('HEAD').item(0);
		
		var resource ;
		
		if(typeof(type) == 'undefined' || type == '') {
			alert('文件类型缺失! (script or css)');
			return false;
		}
		
		if(_script == type.toLocaleLowerCase()) {
			resource = document.createElement("script");
			resource.setAttribute('type', 'text/javascript');
			resource.setAttribute('src', fileName);
		}
		else if(_css == type.toLocaleLowerCase()) {
			resource = document.createElement("link");
			resource.setAttribute('type', 'text/css');
			resource.setAttribute('rel', 'stylesheet');
			resource.setAttribute('href', fileName);
		}
		
		_head.appendChild(resource);
}


( function(){
	var _fn = function(){
		if(window.WdatePicker) return false;
		//loadResources('scripts/datePicker/WdatePicker.js', 'script');
		loadResources_t('scripts/datePicker/WdatePicker.js', 'script');
		try{
			window.WdatePicker;
		}catch(e){
			alert(e);
		}
	};
	
	if(window.document.all){
		window.attachEvent('onload', _fn);
	}
	else{
		window.addEventListener('load', _fn, false);
	}
})();
///////////////////////////////////////////////////////////////////

/*
  -------------------时间范围  yyyy-MM-dd HH:mm:ss 格式  statrt------------------------
                     datePick_begin函数和datePick_end函数用来取时间范围 
                     HH:mm:ss 为当前系统时间 例：2012-09-18 10:31:55
*/

    // 开始时间函数： endObj 参数为结束时间的元素的id属性值
    function datePick_begin(endObj){
	  var dpEnd=$dp.$(endObj);
	  WdatePicker({onpicked:function(){dpEnd.focus();}, dateFmt: 'yyyy-MM-dd HH:mm:ss', autoPickDate: true});
    }
    // 结束时间函数： beginObj 参数为开始时间的元素的id属性值
    function datePick_end(beginObj){
	   WdatePicker({minDate:'#F{$dp.$D(\''+beginObj+'\')}', dateFmt: 'yyyy-MM-dd HH:mm:ss', autoPickDate: true});
    }		

// -------------------时间范围  yyyy-MM-dd HH:mm:ss 格式 end ------------------------



/*
  -------------------时间范围  yyyy-MM-dd 00:00:00 ---- yyyy-MM-dd 23:59:59  格式  statrt------------------------
                     datePick_begin00函数和datePick_end00函数用来取时间范围 
                     HH:mm:ss   例：2012-09-18 00:00:00
*/

    // 开始时间函数： endObj 参数为结束时间的元素的id属性值;
    function datePick_begin00(endObj){
	  var dpEnd=$dp.$(endObj);
	  WdatePicker({onpicked:function(){dpEnd.focus();}, dateFmt: 'yyyy-MM-dd HH:mm:ss',startDate:'%y-%M-%d 00:00:00',alwaysUseStartDate:false, autoPickDate: true});
    }
    // 结束时间函数： beginObj 参数为开始时间的元素的id属性值
    function datePick_end00(beginObj){
       WdatePicker({minDate:'#F{$dp.$D(\''+beginObj+'\')}', dateFmt: 'yyyy-MM-dd HH:mm:ss',startDate:'%y-%M-%d 23:59:59',alwaysUseStartDate:false, autoPickDate: true});
    }		

// -------------------时间范围  yyyy-MM-dd 00:00:00 ---- yyyy-MM-dd 23:59:59  格式  end ------------------------


/*
  -------------------时间范围  yyyy-MM-dd 格式  statrt------------------------
                     datePick_beginYMD函数和datePick_endYMD函数用来取时间范围 
                         例：2012-09-18  
*/

    // 开始时间函数： endObj 参数为结束时间的元素的id属性值;
    function datePick_beginYMD(endObj){
	  var dpEnd=$dp.$(endObj);
	 // WdatePicker({maxDate:'#F{$dp.$D(\''+endObj+'\')||\'2020-10-01\'}'});
	    WdatePicker({onpicked:function(){dpEnd.focus();}, dateFmt: 'yyyy-MM-dd', autoPickDate: true});
    }
   
    // 结束时间函数： beginObj 参数为开始时间的元素的id属性值
    function datePick_endYMD(beginObj){
	   WdatePicker({minDate:'#F{$dp.$D(\''+beginObj+'\')}',maxDate:'2020-10-01', autoPickDate: true});
    }		

// -------------------时间范围  yyyy-MM-dd   格式  end ------------------------

/*
  -------------------时间   yyyy-MM-dd 格式  statrt------------------------
                     datePickYMD函数 
                         例：2012-09-18  
*/
   function datePickYMD(){
           WdatePicker();
   }
 //-------------------时间   yyyy-MM-dd 格式  end------------------------


//----------------------------------------------------------------------

// 开始时间函数： endObj 参数为结束时间的元素的id属性值;
    function datePick_DateTime(){
	 
	  WdatePicker({dateFmt: 'yyyy-MM-dd',alwaysUseStartDate:true, autoPickDate: true});
    }
