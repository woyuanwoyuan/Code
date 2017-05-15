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
	width:100%;
	margin:0px 0px 5px 20px;
	background:url(admin/css/tbg.gif) repeat-x;
}

.bitemdl dt{
  height:30px;
  text-align:center;
  color:#FFFFFF;
  font-weight:bold;
  line-height:30px;
  cursor:pointer;
}

.bitemdl dd{
  padding:3px 3px 3px 3px;
  background-color:#fff;
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
function check() { 
	  var check =  checkGender() ; 
	  return check; 
	 } 
function checkGender(){
	  var check; 
	  var gender = "";
	  //获取所有名称为sex的标签
	  var sex = document.getElementsByName("alg_name");
	  //遍历这些名称为sex的标签
	  for(var i=0;i<sex.length;++i){
	   //如果某个sex被选中，则记录
	   if(sex[i].checked)
	    gender = sex[i].value;  
	  }
	  if(gender == "")
	   {
	    alert("请选择算法！");
	    check = false;
	   }else{
	    document.getElementById("checktext5").innerHTML = "* 请选择算法 √"; 
	    check = true; 
	   } 
	  return check;
	 }




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
		var form = document.MissionForm2; 
		form.action = href;//传想要跳转的路径 
		form.submit(); 
		} 
</script>

</head>
<body target="main">
	<div class="firstdiv">
  <span class="firstspan">实验说明:
			使用平台的算法，用户提供跟踪视频，测试平台算法是否适合用于该视频跟踪</span>
  </div>		
 <form   name="MissionForm2" method="post" enctype="multipart/form-data" action="">	
 <table width="98%"  border="0" cellpadding="1" cellspacing="1" align="center">		
		<tr>
			<td colspan="2" class="tableTitle"><span id="Label1" class="bitemdl">算法选择</span></td>
		</tr>
			<tr><td>
		<table width="100%" border="0" cellpadding="1" cellspacing="1" align="center">
		
		<tr>
			<td colspan="2">
		<table width="100%" bgcolor="#CCCCCC" align="center" border="0" cellspacing="1" cellpadding="1" class="contTable">
		<tr class="slt_label_style" align="center">
			<th></th>
			<th>算法名称</th>
			<th>算法简介</th>
			<th>算法提供者</th>
			<th>算法上传时间</th>
			
		</tr>
		<c:choose>
			<c:when test=""></c:when>
				<c:otherwise>
					<c:forEach var="alginfo" items="${alginfolist}" varStatus="strs">
						<tr align="center" onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)">
							<td><input type="radio" name="alg_name" value="${alginfo.alg_name}" onchange="checkGender()"></td>
							<td>${alginfo.alg_name}</td>
							<td>${alginfo.content}</td>
							<td>${alginfo.provider}</td>
							<td>${alginfo.addtime}</td>
							
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>	
		
		</table></td>
		<td id="checktext5" style="color:Red;font-size：25px">* 请选择你的算法</td>
		</tr>
		<tr>
		<td colspan="2">
		<div class="blank10"></div>
		</td>
		</tr>
		
		<tr>
		
		<td>
		       
               上传视频文件：<input type="file" name="inputVideo"><span id="Label3" style="color:Red;">*上传的视频格式为.avi</span><br/>
          
           
		</td>
		
		</tr>
	</table>
	       <div class="blank10"></div>
	
			
		<input type="button" name="btnOk1" value="跟踪实验" id="btnOk1" onclick="manySend('UploadServlet?flag=1&testmethod=2&testType=normaltrack')" style="width: 89px; height: 31px" />&nbsp;&nbsp;&nbsp;&nbsp;
				
		</td>
		
		</tr>
		</table>
	</form>

</body>
</html>
