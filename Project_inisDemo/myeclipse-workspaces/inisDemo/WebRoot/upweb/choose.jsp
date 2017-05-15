<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>" />
<title></title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="upweb/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="upweb/images/login.js"></script>
<link href="upweb/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>内河船舶视频处理平台</h1>


    
      
  
    
    
               
               
               
            
			<div style="position:fixed;left:43%;top:45%;margin-left:width/2;
"><input type="button" value="跟踪平台" style="width:250px;" class="button_blue" onclick="location.href='<%=basePath%>bootcms/system_index.jsp'"/></div>
                
            <div style="position:fixed;left:43%;top:55%;margin-left:width/2;
"><input type="button" value="检测平台" style="width:250px;" class="button_blue" onclick="location.href='<%=basePath%>/bootcms/system1_index.jsp'"/></div>
			
              
               
               
              
            
               
            



      
</body>
</html>