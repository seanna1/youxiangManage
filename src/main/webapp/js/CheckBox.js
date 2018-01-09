/*
 * author：gq
 * desc:checkbox(全选和不全选)
 */

function DoCheck()
{
var ch=document.getElementsByName("btSelectItem");
if(document.getElementsByName("btSelectAll")[0].checked==true)
{
for(var i=0;i<ch.length;i++)
{
ch[i].checked=true;
}
}else{
for(var i=0;i<ch.length;i++)
{
ch[i].checked=false;
}
}
}


/*
 * 角色添加  多选负值样式
 */
function Check()
{
var ch=document.getElementsByName("btSelectItems");
var all=document.getElementsByName("btSelectAlls")[0].className;
var arr=[];
if(all.indexOf("checked")>0){
    for(var i=0;i<ch.length;i++)
    {
    ch[i].className=("checkbox");
    }
    }else{
    for(var i=0;i<ch.length;i++)
    {
    ch[i].className=("checkbox checked");
    arr.push( ch[i].childNodes[3].value);
    }
}
}

/*dialog*/
function addPatient(){
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        area: '516px',
        shadeClose: false,
        content: $('#addPatient'),
        end: function(){
            $("#addPatient")[0].style.display="none"

        }
    });
};

function updateCheck()
{
var ch=document.getElementsByName("updatebtSelectItems");
var all=document.getElementsByName("updatebtSelectAlls")[0].className;
var arr=[];
if(all.indexOf("checked")>0){
    for(var i=0;i<ch.length;i++)
    {
    ch[i].className=("checkbox");
    }
    }else{
    for(var i=0;i<ch.length;i++)
    {
    ch[i].className=("checkbox checked");
    arr.push( ch[i].childNodes[3].value);
    }
}
}

function updatePatient(id){
	 $.ajax({
  		type : "POST",
  		url  : "role/update",
  		data : {"id":id},
  		datatype : "json",
  		success : function(data) {     			
  			$("#updateId").val(data.id);
  			$("#updaterole").val(data.role);
  			$("#updatedescription").val(data.description);
  			var resources=data.resources;
  			var items=document.getElementsByName("updatebtSelectItems");
  		 	for(var i=0;i<items.length;i++){  				
  				if(resources.indexOf(items[i].childNodes[3].value)>=0){
  					items[i].className=("checkbox checked");
  				}else{
  					items[i].className=("checkbox");
  				}
  			}  			
  		}, 		
  	}); 
    layer.open({
        type: 1,
        title: false,
        closeBtn: 1,
        area: '516px',
        shadeClose: false,
        content: $('#updatePatient'),
        end: function(){
            $("#updatePatient")[0].style.display="none"

        }
    });
}

