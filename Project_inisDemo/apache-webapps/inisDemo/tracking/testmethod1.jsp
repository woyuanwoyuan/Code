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
<script src="js/base-loading.js"></script>
<script language="javascript" type="text/javascript">
function check() { 
	  var check =  checkut() && checkGender() ; 
	  return check; 
	 } 
function checkGender(){
	  var check; 
	  var gender = "";
	  //获取所有名称为sex的标签
	  var sex = document.getElementsByName("alg_name1");
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

function checkut(){
	var check;
	 if(document.getElementById("selUser").selectedIndex == 0)
	   {
	    alert("请选择视频属性！");
	    document.getElementById("selUser").focus();
	    check = false; 
	   }else{
	    document.getElementById("Label3").innerHTML = "* 请选择用户类型 √"; 
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
var form = document.MissionForm; 
form.action = href;//传想要跳转的路径 
form.submit(); 
} 
</script>

</head>
<body target="main">
<div class="firstdiv">
  <span class="firstspan">实验说明:
			使用平台的算法，使用平台提供的视频开展视频跟踪实验</span>
  </div>
 <form   name="MissionForm" method="post"  action=""   >
<table width="98%" bgcolor="#fff" border="0" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td colspan="2" class="tableTitle"><span id="Label1" class="bitemdl">算法选择</span></td>
		</tr>
			<tr><td colspan="2">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" align="center">
		
		<tr>
			<td >
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
							<td><input type="radio" name="alg_name1" value="${alginfo.alg_name}" onchange="checkGender()"/></td>
							
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
		<td>
		<div class="blank10"></div>
		</td>
		</tr>
		
		
	</table>
	</td></tr>
	<tr><td>
	      <table width="100%"  border="0" cellspacing="0" cellpadding="0" class="contTable"  align="center">
					<tr>
						<td ><span id="Label1">视频选择</span> <span id="Label10" style="color:Red;">*</span></td>
						</tr>
						<tr>
						
						<td width="85%" align="left" noWrap>
						<select name="dropSecondLevel" id="selUser" onblur="checkut()"onChange="changeTrirdLevel(this.value,MissionForm.dropThirdLevelTemp,MissionForm.dropThirdLevel);" style="height:20px;width:225px;">
								<option value="">请选择</option>
								<option value="b">桥上</option>
								<option value="a">岸边</option>
								<option value="c">单条船舶</option>
								<option value="d">多条船舶</option>
								<option value="e">晴天</option>
								<option value="f">阴雨天气</option>
								<option value="g">光照无变化</option>
								<option value="h">光照有变化</option>
								<option value="i">尺度无变化</option>
								<option value="j">尺度有变化</option>
								<option value="k">无遮挡</option>
								<option value="l">有遮挡</option>
								<option value="m">船舶速度慢</option>
								<option value="n">船舶速度快</option>
								<option value="p">背景杂乱</option>
								<option value="o">背景不杂乱</option>
								<option value="t">平面内有旋转</option>
								<option value="s">平面内无旋转</option>
							</select>
							<span id="Label3" style="color:Red;">*选择视频属性</span>
						</td>	
						
					</tr>
					<tr>
						
						<td width="85%" align="left" noWrap><div style="display: none;">
								<select name="dropThirdLevelTemp" style="height:30px;width:225px;" onchange="chose('ThirdLevelTemp')">
									<option value="0001_adzegikmoqs">0001_01000000000</option>
									<option value="0002_aczegjkmoqt">0002_00000100001</option>
									<option value="0003_adzegilmoqs">0003_01000010000</option>
									<option value="0004_adzegiknoqs">0004_01000001000</option>
									<option value="0005_adzegiknoqs">0005_01000001000</option>
									<option value="0006_adzegikmoqs">0006_01000000000</option>
									<option value="0007_adzegikmoqs">0007_01000000000</option>
									<option value="0008_aczegikmoqs">0008_00000000000</option>
									<option value="0009_aczegiknoqs">0009_00000001000</option>
									<option value="0010_adzegilmoqs">0010_01000010000</option>
									
									<option value="0021_aczegjkmoqs">0021_00000100000</option>
									<option value="0022_aczegjkmoqs">0022_00000100000</option>
									<option value="0023_aczegjkmoqs">0023_00000100000</option>
									<option value="0024_aczegjlmoqt">0024_00000110001</option>
									<option value="0025_aczegjlmoqs">0025_00000110000</option>
									<option value="0026_aczegjkmoqs">0026_00000100000</option>
									<option value="0027_aczegjkmoqs">0027_00000100000</option>
									<option value="0028_adzegjkmoqs">0028_01000100000</option>
									<option value="0029_adzegjkmoqs">0029_01000100000</option>
									<option value="0030_adzegjlmoqs">0030_01000110000</option>
									
									<option value="0051_adzegjkmoqt">0051_01000100001</option>
									<option value="0052_adzegjkmoqt">0052_01000100001</option>
									<option value="0053_aczegikmoqs">0053_00000000000</option>
									<option value="0054_aczegjkmpqt">0054_00000100101</option>
									<option value="0055_adzegjlmpqt">0055_01000110101</option>
									<option value="0056_aczegiknoqs">0056_00000001000</option>
									<option value="0057_adzegjkmpqt">0057_01000100101</option>
									<option value="0058_adzegiknoqs">0058_01000001000</option>
									<option value="0059_adzegikmoqs">0059_01000000000</option>
									<option value="0060_adzegjkmpqt">0060_01000100101</option>
									<option value="0061_adzegjkmpqt">0061_01000100101</option>
									<option value="0062_adzegjlmoqs">0062_01000110000</option>
									<option value="0063_adzegjkmoqs">0063_01000100000</option>
									<option value="0064_aczegjkmoqs">0064_00000100000</option>
									<option value="0065_aczegjkmoqs">0065_00000100000</option>
									<option value="0066_adzegjkmoqs">0066_01000100000</option>
									<option value="0067_aczegjkmoqs">0067_00000100000</option>
									<option value="0068_adzegjkmpqs">0068_01000100100</option>
									<option value="0069_aczegjkmoqs">0069_00000100000</option>
									<option value="0070_adzegjkmoqs">0070_01000100000</option>
									<option value="0071_aczegjkmoqs">0071_00000100000</option>
									<option value="0072_adzegjkmoqs">0072_01000100000</option>
									<option value="0073_adzegjkmpqs">0073_01000100100</option>
									<option value="0074_adzegjkmpqs">0074_01000100100</option>
									<option value="0075_aczegjkmpqs">0075_00000100100</option>
									<option value="0076_aczegjkmpqs">0076_00000100100</option>
									<option value="0077_aczegjkmpqs">0077_00000100100</option>
									<option value="0078_aczegjkmoqs">0078_00000100000</option>
									<option value="0079_aczegjkmpqs">0079_00000100100</option>
									<option value="0080_adzegjkmpqs">0080_01000100100</option>
									<option value="0081_aczegjkmpqs">0081_00000100100</option>
									<option value="0082_aczegjkmoqs">0082_00000100000</option>
									<option value="0083_aczegjkmoqt">0083_00000100001</option>
									<option value="0084_adzegjkmoqs">0084_01000100000</option>
									<option value="0085_adzegjkmoqs">0085_01000100000</option>
									<option value="0086_aczegjkmpqs">0086_00000100100</option>
									<option value="0087_aczegikmoqs">0087_00000000000</option>
									<option value="0088_aczegikmoqs">0088_00000000000</option>
									<option value="0089_aczegikmpqs">0089_00000000100</option>
									<option value="0090_aczegikmoqs">0090_00000000000</option>
									<option value="0091_aczehikmoqs">0091_00001000000</option>
									<option value="0092_aczehikmpqs">0092_00001000100</option>
									<option value="0093_aczegikmoqs">0093_00000000000</option>
									<option value="0094_aczegikmoqs">0094_00000000000</option>
									<option value="0095_aczehikmoqs">0095_00001000000</option>
									<option value="0096_aczegikmpqs">0096_00000000100</option>
									<option value="0097_adzegikmoqs">0097_01000000000</option>
									<option value="0098_aczegikmoqs">0098_00000001000</option>
									<option value="0099_aczegikmoqs">0099_00000000000</option>
									<option value="0100_aczegikmpqs">0100_00000000100</option>
									<option value="0101_adzegikmpqs">0101_01000000100</option>
									<option value="0102_aczegikmpqs">0102_00000000100</option>
									<option value="0103_adzegikmpqs">0103_01000000100</option>
									<option value="0104_aczegikmpqs">0104_00000000100</option>
									<option value="0105_aczegikmpqs">0105_00000000100</option>
									<option value="0106_adzegikmoqs">0106_01000000000</option>
									<option value="0107_aczegikmpqs">0107_00000000100</option>
									<option value="0108_aczegikmoqs">0108_00000000000</option>
									<option value="0109_aczegikmoqs">0109_00000000000</option>
									<option value="0110_aczegikmoqs">0110_00000000000</option>
									<option value="0111_aczegikmoqs">0111_00000000000</option>
									<option value="0112_adzegikmoqs">0112_01000000000</option>
									<option value="0113_aczegikmoqs">0113_00000000000</option>
									<option value="0114_adzegjkmoqs">0114_01000100000</option>
									<option value="0115_adzegjkmoqs">0115_01000100000</option>
									<option value="0116_adzegjkmpqs">0116_01000100100</option>
									<option value="0117_aczegjkmoqt">0117_00000100001</option>
									<option value="0118_adzegjlmoqt">0118_01000110001</option>
									<option value="0119_adzegjkmpqs">0119_01000100100</option>
									<option value="0120_adzegjkmpqs">0120_01000100100</option>
									<option value="0121_adzegjkmpqs">0121_01000100100</option>
									<option value="0122_adzegjkmpqs">0122_01000100100</option>
									<option value="0123_aczegjkmpqs">0123_00000100100</option>
									<option value="0124_adzegjkmpqs">0124_01000100100</option>
									<option value="0125_aczegjkmoqs">0125_00000100000</option>
									<option value="0126_adzegjkmoqs">0126_01000100000</option>
									<option value="0127_aczegjkmoqs">0127_00000100000</option>
									<option value="0128_aczegjkmoqs">0128_00000100000</option>
									<option value="0129_aczegjkmoqs">0129_00000100000</option>
									<option value="0130_adzegjkmoqs">0130_01000100100</option>
									
									<option value="0151_bdzegjkmoqs">0151_11000100000</option>
									<option value="0152_bczegjkmoqs">0152_10000100000</option>
									<option value="0153_bczegjkmoqs">0153_10000100000</option>
									<option value="0154_bdzegjkmoqs">0154_11000100000</option>
									<option value="0155_bdzegjkmoqs">0155_11000100000</option>
									<option value="0156_bdzegjkmoqs">0156_11000100000</option>
									<option value="0157_bdzegjlmoqs">0157_11000110000</option>
									<option value="0158_bczegjkmoqs">0158_10000100000</option>
									<option value="0159_adzegikmpqs">0159_01000000100</option>
									<option value="0160_adzegjlmpqt">0160_01000110101</option>
									
								</select>
							</div>
							<select name="dropThirdLevel" style="height:20px;width:225px;"  >
							</select>
							<input onClick="AddItem(MissionForm.dropThirdLevel,MissionForm.videoName1)" type="button" style="WIDTH: 40px; HEIGHT: 24px" value="添加"  name="tianjia"/>
						<span id="Label3" style="color:Red;">*选择视频名称</span>
						</td>
					</tr>
					<tr>
						
						<td width="85%" align="left" noWrap>
						
						<input name="videoName1" type="text" id="videoName1" style="height: 30px;width:225px;" readonly="true"/>
						</td>	
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div class="blank10"></div>
							
					</tr>
					
				<tr>
		    <td>
		<input type="button" name="btnOk1" value="跟踪实验" id="btnOk1" onclick="manySend('UploadServlet?flag=3&testmethod=1&testType=normaltrack')" style="width: 89px; height: 31px" />&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="btnOk2" value="对比实验" id="btnOk2" onclick="manySend('UploadServlet?flag=3&testmethod=1&testType=comparetrack')" style="width: 89px; height: 31px" />
		<!--  <input type="button" name="btnOk2" value="测试" id="btnOk2" onclick="manySend('UploadServlet?flag=5')" style="width: 89px; height: 31px" />
		-->
			</td>
			</tr>	
			</table>	
				
			</td>
			
			</tr>
			</table>

</form>			

</body>
</html>
