<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<!-- 
修改了 style2.css：1222 行
.port.effect-1 img {
    transition: 0.5s;
    position: relative;
    /* width: 100%; *
    left: 0;
} 
修改了 bootstrap.css:1118行
.img-responsive, {
    display: block;
    /* max-width: 100%; */
    height: auto;
}

 -->


	<head>
	 <base href="<%=basePath%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>INIS &mdash; family </title>



	
	</head>
	<body>
	 

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
		<script>
		$(function(){
			window.location.href="SystemServlet?flag=7";
			
		});
	   
</script>
	
	
	
	
	</body>
</html>





