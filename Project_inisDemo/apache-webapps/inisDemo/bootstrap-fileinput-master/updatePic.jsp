<%@page import="whut.inis.show.dao.ShareSpaceDao"%>
<%@page import="whut.inis.show.po.ShareSpaceInfo"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
<base href="<%=basePath%>bootstrap-fileinput-master/"">  
  
  
<title>编辑主页背景图</title>  
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0">  
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
<meta http-equiv="description" content="This is my page">  
<link href="css/bootstrap.min.css" rel="stylesheet">  
<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />  
  
  
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.min.js" type="text/javascript"></script>  
<script src="js/locales/zh.js" type="text/javascript"></script>  
 
  
  
</head>  
  
  
<body>  
<a class="btn btn-primary pull-right "  href="../index.jsp" style="margin:2em 2em 0 0">
	返回主页
</a>
<div class="clearfix"></div>
<h4 style="text-align:center">编辑主页背景图</h4>
	
    	 <div class="container kv-main" style="height:60%;margin:50px auto" >  
  
  
        <form enctype="multipart/form-data">  
 		
						
            <input id="file-1" class="file" type="file" multiple
                data-min-file-count="1"> <br>  
         
        </form>  
  
    </div>  
	<script>  

   $(document).ready(function(){
	
	$(".fileinput-upload-button").on("click",function () {
		
	window.a=$(".file-caption-name").attr('title');
	window.b= parseInt(a.substring(0,1));
		alert(window.b);
	 $(".fileinput-upload-button").href="servlet/UploadServlert?flag=7&number="+b;
	});
	
	});


    
    $("#file-1").fileinput({   
   uploadCount:'6',
        language: 'zh',  
        uploadUrl: '../servlet/UploadServlert?number=3'+'&flag=7', // you must set a valid URL here else you will get an error  
        allowedFileExtensions : ['jpg'],  
        maxFileCount: 3,   //同时最多上传3个文件  
        //allowedFileTypes: ['image', 'video', 'flash'],  这是允许的文件类型 跟上面的后缀名还不是一回事  
        //这是文件名替换  
    slugCallback: function(filename) {  
            return filename.replace('(', '_').replace(']', '_');  
        }  
    });   

          //这是提交完成后的回调函数    
     $("#file-1").on("fileuploaded", function (event, data, previewId, index) {  
     	a=$(".file-caption-name").attr('title');
     	if(isNaN(a.substring(0,1))){
	b= 1;
	}else{
	b= parseInt(a.substring(0,1));
	}
   $.ajax({
				type:"post",// 指定是post还是get
				data:"type=1",//发送到服务器的数据 
				url:"../servlet/UploadServlert?flag=3&number="+b,//发送请求的地址
				dataType:"json",
				error:function(err){//如果确定能正确运行,可不写
					alert("错误");
				},
				success:ajaxSendCallBack
			});
     });  
      function ajaxSendCallBack(data){};
     $(document).ready(function(){
	
	//显示共上传几张图片
	//$("Button[name='tijiao']").bind("click",function () {
		
	//	var a=$(".file-caption-name").attr('title');
	//	alert(a);
	//});
	
	});
</script>  
</body>
</html>