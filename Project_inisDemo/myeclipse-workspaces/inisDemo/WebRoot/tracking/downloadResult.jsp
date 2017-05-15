<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script src="js/base-loading.js"></script>
<script language="javascript">
function clk() //定义function函数
{
var a=document.getElementById("button");
if(window.document.form1.button.click){
a.style.backgroundColor="#ccc";
window.document.form1.button.disabled=true;
return;
}
}

</script>
  </head>
  
  <body >
  <form name="form1" method="post" action="">
  <table width="50%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td height="28" class="tableTitle">下载试验数据</td>
	</tr>
	<tr>
		<td bgcolor="#FFFFFF" width="100%">
				<table width="100%" bgcolor="#CCCCCC" border="0" cellspacing="1" cellpadding="1" class="contTable">
					 <tr bgcolor="#FFFFFF" height="25">
						<td align="center" width="80%" height="18">${txtName}</td>
						<td align="center" width="20%">  <a href="DownloadServlet?type=trackingresult&filename=${txtName}&testType=${testType}">下载</a></td>
					</tr>
					<tr align="center" style="display: ${testType.equals('comparetrack')?'block':'none'}" id="tmpRow0" bgcolor="#FFFFFF" height="25" >
						
						<td colspan="2" > <a href="CompareServlet?flag=1&testmethod=${requestScope.testmethod}&initstr=${requestScope.initstr}"> <input type="button" name="button" id="button" value="加入对比结果分析" /></a></td>
					
					</tr>
								
				</table>
		</td>
	</tr>
</table>
		<div style="display:none;">
		<input type="text" name="initstr" value="${requestScope.initstr}" />
		</div>
   </form>  
  </body>
</html>



     