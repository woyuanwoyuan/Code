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

  </head>
  
  <body>
  <form name="compare1" method="post" enctype="multipart/form-data" action="CompareServlet?flag=2">
  <table width="98%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td height="28" class="tableTitle">跟踪算法 &gt; 实验结果对比</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF" width="100%">
				<table width="100%" bgcolor="#CCCCCC" border="0" cellspacing="1" cellpadding="1" class="contTable">
					<tr bgcolor="#FFFFFF" height="25">
						<th width="10%" >选择实验结果进行对比</th>
						<th width="90%" >文件名</th>
						
					</tr>
					
					<c:choose>
					<c:when test=""></c:when>
					<c:otherwise>
					<c:forEach var="algresult" items="${textnamelist}" varStatus="strs">
					<tr align="center" onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)">
						<td><input type="checkbox" name="alg_result" value="${algresult}"></td>
						<td>${algresult}</td>
						
					</tr>
								</c:forEach>
								</c:otherwise>
								</c:choose>	
	<tr align="center">
	<td><font face="宋体"> <span id="Label5">填写进行对比的视频名称</span></font></td>
	<td ><input type="text" name="videoname" value=""/>
	<span id="Label3" style="color:Red;">*必须与视频库中的视频名一致，不得修改，不添加后缀名，如“.avi”等</span></td>
	</tr>
	<tr align="center">
	<td colspan="2"><a href="TestMethodServlet?flag=1"><input type="button" name="goback" value="返回继续实验"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" name="compareResult" value="对比实验结果"/></td>
	</tr>					
				</table>
		</td>
	</tr>
				
</table>
 </form>
  </body>
</html>
