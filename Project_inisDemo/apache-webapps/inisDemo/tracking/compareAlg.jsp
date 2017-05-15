<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上传算法结果txt</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="admin/css/base.css" />
  </head>
  
  <body>
     <!-- enctype 默认是 application/x-www-form-urlencoded -->
    <form name="uploadCode" method="post" enctype="multipart/form-data" action="AlgDemoServlet?flag=3">
	<table width="98%" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td class="tableTitle"><span id="Label1">跟踪算法 &gt; 对比实验结果</span></td>
		</tr>
		<tr>
			<td>
				<table width="100%" bgcolor="#CCCCCC" border="0" cellspacing="1" cellpadding="1" class="contTable">
					
					<tr>
						<td><font face="宋体"> <span id="Label5">上传跟踪目标的真实轨迹</span></font></td>
						<td><input name="groundtruth" type="file" id="groundtruth"/>
							<span id="Label3" style="color:Red;">*文件格式为txt，命名为groundtruth.txt</span></td>
					</tr>
					
					<tr>
						<td><font face="宋体"> <span id="Label5">上传实验结果1</span></font></td>
						<td><input name="algResult1" type="file" id="algResult1" />
							<span id="Label3" style="color:Red;">*文件格式为txt,文件名长度为6个英文字符</span></td>
					</tr>
					<tr>
						<td><font face="宋体"> <span id="Label5">上传实验结果2</span></font></td>
						<td><input name="algResult2" type="file" id="algResult2" />
							<span id="Label3" style="color:Red;">*文件格式为txt,文件名长度为6个英文字符</span></td>
					</tr>
					<tr>
						<td ></td>
						<td><input type="submit" name="btnOk" value="对比实验结果" id="btnOk" />*实验所需时间较长，请耐心等待，不要关闭网页</td>
					</tr>
				</table></td>
		</tr>
	</table>
</form>
     
  </body>
</html>
