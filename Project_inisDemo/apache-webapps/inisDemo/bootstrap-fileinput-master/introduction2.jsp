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



<!DOCTYPE html>
<html>

<!-- Head -->
<head>
 <base href="<%=basePath%>bootstrap-fileinput-master/">
<title>${introduction.uname}的个人空间</title>

<!-- For-Mobile-Apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Capture a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //For-Mobile-Apps -->

<!-- Custom-Stylesheet-Links -->
<!-- Bootstrap-Core-CSS --> 	<link rel="stylesheet"	href="css/bootstrap.min.css" 	type="text/css" media="all" />

<!-- Index-Page-CSS --> 	<link rel="stylesheet"	href="css/style.css" 		type="text/css" media="all" />
<!-- //Custom-Stylesheet-Links -->

<!-- Web-Fonts -->

<!-- //Web-Fonts -->
	<link rel="stylesheet" type="text/css" href="css/easy-responsive-tabs.css " />
<!-- Gallery-CSS --> 		<link rel="stylesheet" 	href="css/swipebox.css"				type="text/css" media="all">

<link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css" />  
 

          <link href="css/bootstrapValidator.min.css" rel="stylesheet" />

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.min.js" type="text/javascript"></script>  
<script src="js/locales/zh.js" type="text/javascript"></script>  
          <script src="js/bootstrapValidator.min.js"></script>

<style>
	.about p{
	font-size:1.8em;
	line-height:1.5em;
	}
	.share-grid{
	padding:10px;
	}
textarea:focus{
    background-color:#fff;/*这里你可以自己调节边框样式*/
}
@media (min-width: 768px){
.modal1 {
    width: 600px;

    margin: 30px auto;
}
.w3l-grids-about {
width:45%;
  
    
}
.kv-main{
width:550px;
}
}
@media (min-width: 1200px){
.modal1 {
    width: 800px;
	
    margin: 30px auto;
}
.w3l-grids-about {
width:39%;
  
    
}
.kv-main{
width:750px;

}

}
.@media (min-width: 1900px){
.modal1 {
    width: 900px;
	
    margin: 30px auto;
}
.w3l-grids-about {
width:37%;
  
    
}
.kv-main{
width:850px;
}
}

.about-grid1, .about-grid2, .about-grid3 {
    width: 60%;
    margin: 50px auto;
    padding:5px;
    background-color: #EEE;
}
.about-image{
margin:20px 0;
}
/*-- /me--*/

.w3ls-agile-left-info {
width:100%;
    padding: 0.5em 0;
    border-bottom: 1px dashed #fff; 
}
.w3ls-agile-left-info h4,.w3ls-agile-left-info span, .social-info h4 {
text-align: left;
    font-size: 1.0em;
    font-weight:bold;
    margin: 0;
    color: #fff;
    text-transform: uppercase;
    letter-spacing: 2px;
}
.w3ls-agile-left-info p {
    color: #fff;
    font-size: 0.95em;
}
.agile-about-right-img img {
    width: 100%;
}

h3.w3l_head {
    text-align: center;
    color: #fff;
    font-size: 3.5em;
    letter-spacing: 2px;
}
h3.w3l_head.three {
    color: #fff;
}
p.w3ls_head_para {
    color: #fff;
    text-align: center;
    text-transform: uppercase;
    letter-spacing: 7px;
}
.w3l-grids-about {

    margin: 2em auto;
    
}
.w3ls-agile-left-info a {
    color: #fff;
}
/*-- //about --*/
.pie-title-center {
  display: inline-block;
  position: relative;
  text-align: center;
}
h3.tittle:after, h3.tittle:before {
    border: 4px double #c2c2c2;
    width: 120px;
    display: inline-block;
    content: "";
    margin: 9px 10px;
}

.pie-value {
    display: block;
    position: absolute;
    font-size:20px;
  top: 35%;
    left: 0;
    right: 0;
    color: #eb5424;
}
.abt-gd-left h4 {
    margin-top: 40px;
    color: #10A7AF;
    font-weight: 100;
    font-size: 22px;
}
.abt-left {
    padding: 120px 100px 0;
	min-height:610px;
}

.fixed{
    width:150px;
    height:100px;
	
	position:fixed;
    bottom:30%;
    right:0;
    
    
}

</style>

<script>
	//网页载入完后使装图片的div宽高保1.25:1；
	   $(document).ready(function(){
	  
	    var width=$(".content-grid-effect").width();
	    
	    $(".content-grid-effect").height(width/1.25);
	    
	    	    $('.img-circle').error(function(){
		    $(this).attr('src',"images/tx.jpg");
		});
	//    alert($(".content-grid-effect").width());
	//    alert($(".content-grid-effect").height());
	   });
	     //改变分辨率后使装图片的div宽高保1.25:1；
	     $(window).resize(function() {
		   //设置图片宽高比例
		
		  var width=$(".content-grid-effect").width();
	    
	    $(".content-grid-effect").height(width/1.25);
	    
		 }); 
		 
	
</script>

</head>
<!-- //Head -->



	<!-- Body -->
	<body>
	<c:if test="${not empty alertInfo }">   
<div class="alert alert-${alertInfo.infoLei} alert-dismissable">
	<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">
		&times;
	</button>
	${alertInfo.infoContent}
</div>
</c:if>
		<!-- Header -->
		<div class="header">

			<div class="col-md-5 header-right">

				<div class="navigation">
					<!-- Navbar -->
					<nav class="navbar navbar-default">
						<div class="container-fluid">

							<div class="navbar-header">
								<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div>

							

						</div>
					</nav>
					<!-- //Navbar -->
				</div>

				<div class="logo">
					<h1><a href="../servlet/ShowServlet?flag=4&uname=${introduction.uname}">CAPTURE</a></h1>
					<img src="images/logo-style.png" alt="Capture">
				</div>

				<div class="header-info">
					<div class="w3l-grids-about " >
			
				
				<div class="w3ls-agile-left-info">
					
						<span class="name">${introduction.uname}</span>&nbsp;&nbsp;<span class="xingbie">${introduction.xingbie}</span>
						
					</div>
					
				
						<div class="w3ls-agile-left-info">
						
						<span class="birthday">${introduction.birthday.substring(0,10)}</span>
					</div>
					
					
					<div class="w3ls-agile-left-info">
						
						<span class="homeAddress">${introduction.address}</span>
					</div>
					<div class="w3ls-agile-left-info">
					
						<h4 class="email"><a href="mailto:984554@qq.com">${introduction.email}</a></h4>
					</div>
					<div class="w3ls-agile-left-info">
					
						<h4 class="tel"><a href="mailto:984554@qq.com">${introduction.tel}</a></h4>
					</div>
					
						<p class="startyear hidden">${introduction.startyear.substring(0,10)}</p>
				</div>
				</div>

			
				<div class="clearfix"></div>

			</div>

			<div class="col-md-7 header-left">

				<div class="header-slider">
					<div class="slider-1" style=" background:url(images/slide-1.jpg) no-repeat; background-size:100% 100%;">
						<!-- Slider -->
						<div class="slider" >
							
							<ul class="rslides" id="slider1">
							<li>
									<img src="images/slide-1.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-2.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-3.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-4.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-5.jpg" alt="Sportive">
								</li>
							</ul>
			
							
						</div>
						<!-- //Slider -->
					</div>
					<div class="slider-2">
						<!-- Slider -->
						<div class="slider">
							<ul class="rslides" id="slider2">
								<li>
									<img src="/inisDemo/${introduction.fileurl}/touxiang.jpg" alt="Sportive" class="tx">
								</li>
								
							</ul>
						</div>
						<!-- //Slider -->
					</div>
				</div>

			</div>
			<div class="clearfix"></div>

		</div>
		<!-- //Header -->
      <div class="fixed">             
<button class="btn btn-primary pull-right ${classinfo}"  data-toggle="modal" data-target="#myModal2" id="bianji"  title="${title }" style="margin-bottom:0.5em">
	我要编辑
</button>
<div class="clearfix"></div>

		<a type="button" class="btn btn-primary pull-right ${classinfo}" data-toggle="collapse" 
		data-target="#about1" title="点击分享上传" >
			
	我要分享
</a>
<div class="clearfix"></div>
<button class="btn btn-primary pull-right ${classinfo}"  data-toggle="modal" data-target="#myModal3" id="bianji"  title="${title }" style="margin-top:0.5em">
	修改密码
</button>
<div class="clearfix"></div>
</div>



	<!-- About -->
		<div class="about collapse" id="about1">
			<h2>About Me</h2>
		<div class="about-grid1 w3layouts">
			<div class="share-grid about-info">
				<form class="form" role="form" name="uploadCode" method="post" action="../servlet/UploadServlert?flag=1">
				
					<div class="form-group" >
						
						<textarea class="form-control" rows="6"  name="content" type="text" id="shuoshuo"></textarea>
					</div>
						
									<!-- 按钮触发模态框 -->
<a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
	添加图片
</a>
					<button type="submit" class="btn btn-default">提交</button>
				</form>

			</div>
		</div>
		</div>
		<!-- //About -->
		


<!-- 模态框（Modal） -->
<div class="modal  fade " id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal1">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					上传图片
				</h4>
			</div>
			<div class="modal-body">
					 <div class="container kv-main"  >  
  
  
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
	 $(".fileinput-upload-button").href="servlet/UploadServlert?flag=2&number="+b;
	});
	
	});


    
    $("#file-1").fileinput({   
   uploadCount:'6',
        language: 'zh',  
        uploadUrl: '../servlet/UploadServlert?number=9'+'&flag=2', // you must set a valid URL here else you will get an error  
        allowedFileExtensions : ['xls','jpg', 'png','gif'],  
        maxFileCount: 9,   //同时最多上传3个文件  
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
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao" data-dismiss="modal">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
		

		<!-- About -->
		<div class="about" id="about">
			<h2>About Me</h2>
	
	  <!-- 说说循环开始 -->
         		<c:choose>
			<c:when test=""></c:when>
				<c:otherwise>
					<c:forEach items="${shuoshuolist}" var="str" varStatus="strs">
	
			<div class="about-grid${(strs.index)%2+1} w3layouts">
				
				<div class="col-md-12 col-sm-12 about-grid about-info">
					<div style="margin:1em 0.5em">
					<div class="col-md-1 col-sm-1">
						<img src="/inisDemo/${introduction.fileurl}/touxiang.jpg"  class="touxiang img-circle" style="width:75px;height:75px; margin-left:1em 1em"/>
					</div>
					<div class="col-md-10 col-sm-10">
						<p>${str.username}</p>
						<p>${(str.publishtime).substring(0,10)}</p>
					</div>
					<div class="clearfix"></div>
					</div>
					
					<p>${str.content}</p>
				</div>
				
				<div class="col-md-12 col-sm-12 about-grid about-image">
					
					<div class="gallery agileits w3layouts" id="gallery">
									
						<c:forEach var="i" begin="1" end="${str.picnum}" step="1">   
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect agileits w3layouts slow-zoom vertical text-center">
											<a href= "../${str.purl}/${i}.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox" >
												<div class="img-box agileits w3layouts">
												<!--	<img src="../${str.purl}/${i}.jpg"    alt="image" class="img-responsive agileits w3layouts zoom-img" > -->
											 <img src="../${str.purl}/${i}.jpg"    alt="image" class="img-responsive agileits w3layouts zoom-img"  style="width:100%;max-height:120%;height:120%">  	
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									</c:forEach>  
									<div class="clearfix"></div>
									
							
							<!-- //Gallery -->
           </div>
				</div>
				<div class="clearfix"></div>
			</div>
      <!--shuos循环结束 -->
    
      
        
      		</c:forEach>
				</c:otherwise>
			</c:choose>	
			
			  <jsp:include page="../pagination.jsp">
			<jsp:param value="../servlet/ShowServlet?flag=4" name="url"/>
		</jsp:include>
			<c:if test="${empty shuoshuolist}"> 
	<div class="about-grid3 w3layouts">
			<div class="col-md-12 col-sm-12 about-grid about-info">
					<div style="margin:15px 10px">
					<div class="col-md-2 col-sm-2">
						<img src="images/team-2.jpg" class="touxiang" style="width:75px;height:75px;"/>
					</div>
					<div class="col-md-10 col-sm-10">
						<p>王小波</p>
						<p>2017-2-23</p>
					</div>
					<div class="clearfix"></div>
					</div>
					
					<p>这个世界自始至终只有两种人：一种是像我这样的人，一种是不像我这样的人。(分享模板，一起来分享你的学习生活吧！)</p>
				</div>
				
				<div class="col-md-12 col-sm-12 about-grid about-image">
					
					<div class="gallery agileits w3layouts" id="gallery">
									
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect agileits w3layouts slow-zoom vertical text-center">
											<a href="images/gallery-1.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-1.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect agileits w3layouts slow-zoom vertical text-center">
											<a href="images/gallery-2.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-2.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
											<a href="images/gallery-3.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-3.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
											<a href="images/gallery-4.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-4.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
											<a href="images/gallery-5.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-5.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
											<a href="images/gallery-6.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-6.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
											<a href="images/gallery-7.jpg" class="b-link-stripe b-animate-go agileits w3layouts swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-7.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
											<a href="images/gallery-8.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-8.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									<div class="col-md-4 col-sm-4 agileits w3layouts gal-left">
										<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
											<a href="images/gallery-9.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
												<div class="img-box agileits w3layouts">
													<img src="images/gallery-9.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
												</div>
												<div class="info-box agileits w3layouts">
													<div class="info-content agileits w3layouts">
														<span class="separator agileits w3layouts"></span>
													</div>
												</div>
											</a>
										</div>
									</div>
									
									<div class="clearfix"></div>
									
							
							<!-- //Gallery -->
           </div>
				</div>
				<div class="clearfix"></div>
			</div>
</c:if>
		</div>
		<!-- //About -->



		



		
		
	
<!-- 个人信息编辑模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					编辑个人信息
				</h4>
			</div>
			<div class="modal-body">
				 <form role="form" name="uploadCode" method="post" enctype="multipart/form-data" action="../servlet/UploadServlert?flag=5">
				  <div class="form-group">
				    <label for="name">姓名</label>
				    <input type="text" class="form-control" id="name" placeholder="请输入姓名" name="name">
				  </div>
	
				   <div class="form-group">
				     <label>姓别</label>
				    <div class="radio">
				      
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios1" value="男" checked> 男
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="女">女
						</label>
					</div>
					<div class="radio">
						<label>
							<input type="radio" name="optionsRadios" id="optionsRadios2" value="啦啦">未定
						</label>
					</div>
				  </div>
				    <div class="form-group">
				    <label for="time2">入学年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
			
				     <div class="form-group">
				     <label for="name">选择列表</label>
		<select class="form-control selector" name="xuewei">
			<option value="硕士研究生">硕士研究生</option>
			<option value="博士研究生">博士研究生</option>
		
		</select>
				
				  </div>
				   <div class="form-group">
				    <label for="time">出生日期</label>
				    <input type="date" class="form-control" id="time" placeholder="请输入日期" name="time">
				  </div>
				   <div class="form-group">
				    <label for="address">家庭地址</label>
				    <input type="text" class="form-control" id="address" placeholder="请输入家庭地址" name="address">
				  </div>
				    <div class="form-group">
				    <label for="email">邮箱</label>
				    <input type="text" class="form-control" id="email" placeholder="请输入邮箱" name="email">
				  </div>
				    <div class="form-group">
				    <label for="tel">联系方式</label>
				    <input type="text" class="form-control" id="tel" placeholder="请输入联系方式" name="tel">
				  </div>
			
				  <div class="form-group">
				    <label for="inputfile">上传头像</label>
				    <input type="file" id="inputfile" name="inputfile" accept=".jpg,">
				  
				  </div>
				
				  <button type="submit" class="btn  btn-primary pull-right" style="margin-right:0.5em">提交</button>
				  <div class="clearfix"></div>
				</form>
  

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao" data-dismiss="modal">
					确定
				</button>
		</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
 <!-- /.modal结束 -->


<!-- 修改密码模态框（Modal） -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					修改密码
				</h4>
			</div>
			<div class="modal-body">
				 <form role="form" name="uploadCode" method="post" action="../SystemServlet?flag=2">
				  <div class="form-group">
				    <label for="oldPassword">旧密码</label>
				    <input type="password" class="form-control"  placeholder="请输入旧密码" name="oldPassword">
				  </div>
	 			 <div class="form-group">
				    <label for="newPassword">新密码</label>
				    <input type="password" class="form-control" placeholder="请输入新密码" name="newPassword">
				  </div>
				
				  <button type="submit" class="btn  btn-primary pull-right" style="margin-right:0.5em">提交</button>
				  <div class="clearfix"></div>
				</form>
  

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao" data-dismiss="modal">
					确定
				</button>
		</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	</div>
 <!-- /.modal结束 -->

		



		



		<!-- Footer -->
		<div class="footer agileits-w3layouts">
					<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6 animate-box">
						<div class="fh5co-footer-widget">
							<p>&copy; 版权所有© 武汉理工大学INIS实验室 </p>
							<p><a href="mailto:986670851@qq.com">&copy; 意见、反馈：986670851@qq.com</a> </p>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 animate-box">
						<div class="fh5co-footer-widget">
						<p >友情链接</p>
						 <div class="clearfix"> </div>
							<ul style="list-style:none">
								<li>
									<a href="http://i.whut.edu.cn/" target="_blank" >武汉理工大学</a>
								</li>
								<li>
									<a href="http://i.whut.edu.cn/" target="_blank" >武汉理工大学自动化学院</a>
								</li>
							
							</ul>
						<div class="fh5co-footer-widget">
					</div>
				</div>
			</div>
		</div>
<!-- footer -->
	</div> <!-- END fh5co-page -->
		</div>
		<!-- //Footer -->



	<!-- Custom-JavaScript-File-Links -->

		

		<!-- Banner-Slider-JavaScript -->
		<script src="js/responsiveslides.min.js"></script>
		<script>
			$(function () {
				$("#slider1, #slider2, #slider3, #slider4").responsiveSlides({
					auto: true,
					nav: true,
					speed: 800,
					namespace: "callbacks",
					pager: true,
				});
			});
		</script>
		<!-- //Banner-Slider-JavaScript -->

		<!-- Slide-To-Top JavaScript (No-Need-To-Change) -->
		<script type="text/javascript">
			$(document).ready(function() {
				var defaults = {
					containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 100,
					easingType: 'linear'
				};
				$().UItoTop({ easingType: 'easeOutQuart' });
				     	
					        	   
					        	   		   //2.点击编辑
						            $("#bianji").on("click",function(){
						            var name= $(".name").text();
						         	var xingbie= $(".xingbie").text();
						  //       	alert(xingbie);
						            var xuewei= $(".xuewei").text();
						           
						         	var birthday= $(".birthday").text();
						         //	alert(birthday);
					//var birthday1=birthday.replace(/-/g,"/");
					//	 alert(birthday1);
					     var startyear= $(".startyear").text();
				//	     alert(startyear);
						        	var address= $(".homeAddress").html();
						        	alert(address);
						        	alert(address.length);
						            var email= $(".email").text();
						         	var tel= $(".tel").text();
						         	var tx= $(".tx").attr("src");
						       //  	alert(tx);
						         	
						         	$("input[name='name']").val(name);
						         	if(xingbie=="男"){
						         	$("input:radio[name='optionsRadios']").eq(0).attr("checked",'checked');
						         	}else{
						         	 	$("input:radio[name='optionsRadios']").eq(1).attr("checked",'checked');
						         	}
						         	   	if(xuewei=="硕士研究生"){
						         $(".selector").find("option[value='硕士研究生']").attr("selected",true);
						         	}else{
						         	 $(".selector").find("option[value='博士研究生']").attr("selected",true);
						         	}
						         	
						        	//$("input[name='optionsRadios']").val("女"); 
							//		$("select[name='xuewei']").val(xuewei);
									$("input[name='time']").val(birthday);
									$("input[name='time2']").val(startyear);
						        $("input[name='address']").val(address); //获得文本框中的值
									$("input[name='email']").val(email);	
									$("input[name='tel']").val(tel);
								//	$("input[name='inputfile']").val(tx);
						         	
						         	
						           });
			});
		</script>
		<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 0;"> </span></a>
		<!-- //Slide-To-Top JavaScript -->

		<!-- Smooth-Scrolling-JavaScript -->
		<script type="text/javascript" src="js/move-top.js"></script>
		<script type="text/javascript" src="js/easing.js"></script>
		<script type="text/javascript">
				jQuery(document).ready(function($) {
					$(".scroll, .navbar li a, .footer li a").click(function(event){
						$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
					});
				});
		</script>
		<!-- //Smooth-Scrolling-JavaScript -->

	<!-- //Custom-JavaScript-File-Links -->

    <script src="js/easyResponsiveTabs.js"></script>
	
	<script type="text/javascript">
    $(document).ready(function() {

        //Vertical Tab
        $('#parentVerticalTab').easyResponsiveTabs({
            type: 'vertical', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            tabidentify: 'hor_1', // The tab groups identifier
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#nested-tabInfo2');
                var $name = $('span', $info);
                $name.text($tab.text());
                $info.show();
            }
        });
    });
</script>

	</body>
	<!-- //Body --> 
<!-- Gallery-JavaScript -->
		<script src="js/jquery.swipebox.min.js"></script> 
			<script type="text/javascript">
				jQuery(function($) {
					$(".swipebox").swipebox();
				});
		</script>
		   <script>
            $(function () {
        $('form').bootstrapValidator({
				message: 'This value is not valid',
            	feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                timu: {
                    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '题目不能为空'
                        }
                   
                       
                    }
                },
                content: {
                    validators: {
                        notEmpty: {
                            message: '分享内容不能为空'
                        }
                    }
                },
                    name: {
                    validators: {
                        notEmpty: {
                            message: '名字不能为空'
                        }
                    }
                },
                        time2: {
                    validators: {
                        notEmpty: {
                            message: '入学年份不能为空'
                        }
                    }
                },
                        time: {
                    validators: {
                        notEmpty: {
                            message: '出生日期不能为空'
                        }
                    }
                },
                           address: {
                    validators: {
                        notEmpty: {
                            message: '家庭地址不能为空'
                        }
                    }
                },
                           tel: {
                    validators: {
                        notEmpty: {
                            message: '联系方式不能为空'
                        },
                           stringLength: {
                            min: 11,
                            max: 11,
                            message: '手机号必须为11位'
                        },
                    }
                },
                            email: {
                    validators: {
                        notEmpty: {
                            message: '邮箱不能为空'
                        },
                          emailAddress: {
                            message: '邮箱地址格式有误'
                        }
                    }
                }
            }
        });
    });
    </script>
		<!-- //Gallery-JavaScript -->
</html>

