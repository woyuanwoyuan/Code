<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    <base href="<%=basePath%>">
    
    <title>算法对比图</title>
    	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	<link rel="stylesheet" type="text/css" href="admin/css/base.css" />
	-->
  </head>
  
  <body>
    
   <div class="content">

			<div class="imgBox">
				<img alt="中心误差图片" id="Frame1" src="" width="60%" height="500px" />
				<script language="javascript">
			            var url= "<%=(String)request.getAttribute("img1")%>";
			            document.getElementById("Frame1").src = url;    		   
			     </script>	 
				
				</div>
		<div class="imgBox">
					<img alt="重合率图片" id="Frame2" src="" width="60%" height="500px" />
					 <script language="javascript">
			            var url= "<%=(String)request.getAttribute("img2")%>";
			            document.getElementById("Frame2").src = url;    		   
			     </script>
				
		</div>
</div>
     
  </body>
</html>
