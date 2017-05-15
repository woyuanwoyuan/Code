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
    
    <title>STC算法对比实验</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="admin/css/base.css" />
	<script> 
  
	function mouseOver(obj)
	{
		obj.className = "bgLine";
	}
	function mouseOut(obj){
		obj.className = "";
	}
	function testDeleteUser(id){
		if(confirm("删除后不能恢复,确认删除?")){
			window.location.href = "/inis_videoProcess/SystemServlet?flag=5&id=" + id;
		}
		
	}
	function testupdate(id,role_id){
	 
		if(confirm("确认更改?")){
			window.location.href = "/inis_videoProcess/SystemServlet?flag=6&id=" + id+"&role_id="+role_id;
		}}
		
</script>
  </head>
  
  <body>
     <!-- enctype 默认是 application/x-www-form-urlencoded -->
   <form  method="post"  action="RunTrackerServlet?flag=1">
	<table width="40%" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td class="tableTitle"><span id="Label1">跟踪实验</span></td>
		</tr>
		<tr>
			<td>
				<table width="100%" bgcolor="#CCCCCC" align="center" border="0" cellspacing="1" cellpadding="1" class="contTable">
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
				<td>几倍上下文区域：</td>
				<td><input type="text" name="paddingval" value="1.0" /></td>
			</tr>
			<tr>
				<td>学习参数：</td>
				<td><input type="text" name="rhoval" value="0.075" /></td>
			</tr>
			<tr>
				<td>初始尺度：</td>
				<td><input type="text" name="scaleval" value="1.0" /></td>
			</tr>
			<tr>
				<td>形状参数1：</td>
				<td><input type="text" name="lambdaval" value="0.25" /></td>
			</tr>
			<tr>
				<td>平均求尺度帧数：</td>
				<td><input type="text" name="numval" value="5.0" /></td>
			</tr>
			<tr>
				<td>形状参数2：</td>
				<td><input type="text" name="alaphaval" value="2.25" /></td>
			</tr>
			
			<tr align="center">
				<td colspan="2"><input type="submit" value="开始实验" />*实验所需时间较长，请耐心等待，不要关闭网页</td>
			</tr>
			
		
		</table></td>
		</tr>
		<tr>
		<td>
		<div class="blank10"></div>
		</td>
		</tr>
		<tr><td>
	</table>
	<div style="display:none;">
		<input type="text" name="imgpath" value="${requestScope.imgpath}" />
		<input type="text" name="testmethod" value="${requestScope.testmethod}" />
		<input type="text" name="testType" value="${requestScope.testType}" />
		</div>
</form>
     
  </body>
</html>
