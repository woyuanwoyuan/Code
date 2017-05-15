<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="admin/css/base.css" />
	<style> 
body{ text-align:center;} 
.firstdiv{ margin:0 auto; align:"center";width:98%;height:30px; }
.firstspan{font-size: 18px} 
/* css注释：为了观察效果设置宽度 边框 高度等样式 */ 
</style>
  </head>
  
  <body>
   <div class="firstdiv">
  <span class="firstspan">上传文件说明:
			用户上传自己设计的算法，或者内河船舶运动视频，经管理员审核通过后，加入平台对应的算法库以及视频库</span>
  </div>
     <!-- enctype 默认是 application/x-www-form-urlencoded -->
    <form name="uploadCode" method="post" enctype="multipart/form-data" action="UploadServlet?flag=2">
	<table width="98%" border="0" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td colspan="2" class="tableTitle"><span id="Label1">上传文件</span></td>
		</tr>
		<tr>
			<td>
				<table width="100%"  bgcolor="#CCCCCC" border="0" cellspacing="1" cellpadding="1" class="contTable">
					
					<tr>
						<td><font face="宋体"> <span id="Label5">文件名称</span></font></td>
						<td><input name="algName" type="text" id="algName"/>
							<span id="Label3" style="color:Red;">*英文简写不要超过15个字符</span></td>
					</tr>
					
					<tr>
						<td><font face="宋体"> <span id="Label5">文件简介</span></font></td>
						<td><input name="algIntroduce" type="text" id="algIntroduce" />
							<span id="Label3" style="color:Red;">*最多不要超过50个字</span></td>
					</tr>
					<tr>
						<td><font face="宋体"> <span id="Label5">上传文件</span></font></td>
						<td><input name="uploadAlg" type="file" id="uploadAlg" />
							</td>
					</tr>
					<tr>
						<td ></td>
						<td><input type="submit" name="btnOk" value="提交文件" id="btnOk" /></td>
					</tr>
				</table></td>
				
		</tr>
	</table>
</form>
     
  </body>
</html>
