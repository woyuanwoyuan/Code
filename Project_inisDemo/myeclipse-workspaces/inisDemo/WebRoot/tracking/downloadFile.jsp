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
    
    <title>下载专区</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="admin/css/base.css" >
<style> 
body{ text-align:center} 
.firstdiv{ margin:0 auto; align:"center";width:98%;height:30px; } 
.firstspan{font-size: 18px}
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style> 
  </head>
  
  <body>
  <div class="firstdiv">
  <span class="firstspan">下载文件说明：GT_OK是检验跟踪效果的程序，用户下载该程序之后，将跟踪结果与对应视频结合，可得到显示跟踪方框的视频</span>
  </div>
  <form name="downloadFile" method="post" enctype="multipart/form-data" action="">
  <table width="98%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td height="28" class="tableTitle">下载专区</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF" width="100%">
				<table width="100%" bgcolor="#CCCCCC" border="0" cellspacing="1" cellpadding="1" class="contTable">
					<tr bgcolor="#FFFFFF" height="25">
						
						<th>文件名</th>
						<th>文件描述</th>
						<th>上传者</th>
						<th>上传时间</th>
						<th>下载</th>
					</tr>
					<!-- <tr  align="center" onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)">
							<td>GT_OK</td>
							<td>检验跟踪效果算法</td>
							<td>admin</td>
							<td>2016-05-15</td>
							<td><a href="DownloadServlet?type=alginfo&filename=GT_OK">下载</a></td>
					</tr>	 -->
					<c:choose>
					<c:when test=""></c:when>
					<c:otherwise>
					<c:forEach var="alginfo" items="${trackinglist}" varStatus="strs">
					<tr align="center" onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)">
					
									
									<td>${alginfo.alg_name}</td>
									<td>${alginfo.content}</td>
									<td>${alginfo.provider}</td>
									<td>${alginfo.addtime}</td>
									<td><a href="DownloadServlet?type=alginfo&filename=${alginfo.alg_name}">下载</a></td>
								</tr>
								</c:forEach>
								</c:otherwise>
								</c:choose>	
														
				</table>
		</td>
	</tr>
</table>
 </form>
  </body>
</html>
