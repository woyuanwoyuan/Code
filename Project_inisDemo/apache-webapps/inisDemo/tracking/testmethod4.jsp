<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>menu.html</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" type="text/css" href="admin/css/base.css" >
<base target="main" />
<style type="text/css">
body{

 text-align:center;
 background-color:#F1F3F5;
 overflow:scroll;
 overflow-x:hidden;

}

.bitemdl {
	clear:both;
	color:#FFFFFF;
	
}



ul{padding-top:3px;}

.sitemu li {
	height:22px;
	padding:0px 0px 0px 18px;
	line-height:22px;
	background:url(admin/css/arr4.gif) no-repeat 5px 8px;
	border-bottom:dashed 1px #f8f8f8;
}

#mainct
{
	padding-top:8px;background: url(admin/css/idnbg1.gif) repeat-y;
}
.firstdiv{ margin:0 auto; align:"center";width:98%;height:30px; }
.firstspan{font-size: 18px} 
</style>
<script language="javascript" type="text/javascript">

function showTime(){
		var date = new Date();
		document.getElementById("first").innerHTML = date.toLocaleString();
		setTimeout("showTime()",1000);
	}
	
function AddItem(fromObj,toObj){
	    
		 var fromStr = fromObj.options[fromObj.selectedIndex].text;
	     if(fromStr!=null&&fromStr!=""){
			toObj.value = fromStr;
	     }
	  }

	  
	/*通过ajax异步通信*/
	function loadXMLDoc(){
	    var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
	    }
	  }
	  var videoName = document.getElementById("videoName").value;
	  var videoPath = "E:/inis_videolib/tracking_lib/"+videoName+"/"+videoName+".avi";
	  //var videoPath = "resultImg/"+videoName+".avi";
	  alert(videoPath);
	  	xmlhttp.open("get","web/avi.txt",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send();

	 }		
	 
	 function changeTrirdLevel(changeValue,tempObj,resultObj){
	   if(resultObj!=null&&resultObj.options.length>0){
	      for(var i=resultObj.options.length;i>-1;i--){
	           resultObj.options.remove(i);
	      }
	   }
	   var tempStr;
	   if(changeValue!=null&&changeValue!=""){
	       
	        var j=0;
		for(var i = 0;i<tempObj.options.length; i++){
		 tempStr = tempObj.options[i].value;
	          
			  if(tempStr.indexOf(changeValue) > 0 )   
	          {
	             resultObj.options[j]=new Option(tempObj.options[i].text,tempObj.options[i].value);
	             j=j+1;
	          }
		}
	   }
	 }
	 function manySend(href){ 
var form = document.MissionForm3; 
form.action = href;//传想要跳转的路径 
form.submit(); 
} 
</script>

</head>
<body target="main">
<div class="firstdiv">
  <span class="firstspan">实验说明:
			用户自行设计跟踪算法，用户提供跟踪视频，研究用户算法的有效性，以及用户算法能否适应用户提供的视频进行跟踪
	</span>
  </div>
<form   name="MissionForm3" method="post" enctype="multipart/form-data" action="UploadServlet?flag=3&testmethod=4">	
	<table width="98%" border="0" cellpadding="1" cellspacing="1" align="center"  class="contTable">
		<tr>
			<td colspan="2" class="tableTitle"><span id="Label1" class="bitemdl">实验</span></td>
		</tr>
		
			<tr><td>
				
					<table width="98%" border="0" cellpadding="0" cellspacing="0" align="center">
		
		<tr>
		<td>
		<div class="blank10"></div>
		</td>
		</tr>
		<tr><td>
		
		       
               上传算法文件：<input type="file" name="inputalg"><span id="Label3" style="color:Red;">*上传的文件格式为.exe的可执行文件</span><br/>
           <div class="blank10"></div>
             
		</td></tr>
		<tr><td>
		
		       
               上传视频文件：<input type="file" name="inputVideo"><span id="Label3" style="color:Red;">*上传的视频格式为.avi</span><br/>
           <div class="blank10"></div>
           
             <div class="blank10"></div>
              <input type="submit" name="btnOk" value="开始实验" id="btnOk" style="width: 89px; height: 31px" />
		</td></tr>
	</table>
			</td>
			
			</tr>	
				
</table>			
	
</form>	
</body>
</html>
