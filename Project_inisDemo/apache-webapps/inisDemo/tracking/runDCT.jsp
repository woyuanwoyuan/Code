<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>DCT跟踪算法演示</title>

<link rel="stylesheet" href="tracking/css/jcrop/common.css"	type="text/css" />
<link rel="stylesheet" href="tracking/css/jcrop/jquery.Jcrop.css" type="text/css" />
<script type="text/javascript" src="tracking/js/jcrop/jquery-1.3.2-min.js"></script>
<script type="text/javascript" src="tracking/js/jcrop/jquery.Jcrop.js"></script>
<style type="text/css">
.img_pos {
	padding: 0 0 20px 12%;
	font-family: Verdana, Geneva, sans-serif;
}
</style>
<script src="Js/base-loading.js"></script>
<script language="javascript" type="text/javascript">

 
	$(document).ready(function() {
		//记得放在jQuery(window).load(...)内调用，否则Jcrop无法正确初始化
		$("#firstFrame").Jcrop({
			onChange : showCoords,
			onSelect : showCoords
		});
		//简单的事件处理程序，响应自onChange,onSelect事件，按照上面的Jcrop调用
		function showCoords(obj) {
			$("#x").val(obj.x);
			$("#y").val(obj.y);
			$("#w").val(obj.w);
			$("#h").val(obj.h);
		}
	});
</script>
</head>

<body>

	<img id="firstFrame" src="" />
	 <script language="javascript">
            var url= "<%=(String)request.getAttribute("firstimgpath")%>";
            document.getElementById("firstFrame").src = url;    		   
     </script>
    
	<br />
	<form action="RunTrackerServlet?flag=3" method="post">
		
		<table align="left">
			<tr>
				<td colspan="2"><b>x</b><input type="text" size="4" id="x" name="x_num" /> <b
			class="ml5">y</b><input type="text" size="4" id="y" name="y_num" /> <b
			class="ml5">w</b><input type="text" size="4" id="w" name="w_num" /> <b
			class="ml5">h</b><input type="text" size="4" id="h" name="h_num" />
				</td>
			</tr>
			<tr>
				<td>视频文件名称：</td>
				<td><input type="text" name="fileName" value="${requestScope.videoname}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>图像帧数：</td>
				<td><input type="text" name="imgFrameNum" value="${requestScope.imgFrameNum}" readonly="readonly"/></td>
			</tr>
				
			<tr>
				<td colspan="2"><input type="submit" value="开始实验" />*实验所需时间较长，请耐心等待，不要关闭网页</td>
			</tr>
		</table>
		<div style="display:none;">
		<input type="text" name="imgpath" value="${requestScope.imgpath}" />
		<input type="text" name="testmethod" value="${requestScope.testmethod}" />
		<input type="text" name="testType" value="${requestScope.testType}" />
		</div>
		
	</form>
</body>
</html>