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
<title>INIS共享空间</title>

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
 


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script src="js/fileinput.min.js" type="text/javascript"></script>  
<script src="js/locales/zh.js" type="text/javascript"></script>  


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
.modal-dialog {
    width: 600px;

    margin: 30px auto;
}
.kv-main{
width:550px;
}
}
@media (min-width: 1200px){
.modal-dialog {
    width: 800px;
	
    margin: 30px auto;
}
.kv-main{
width:750px;

}

}
.@media (min-width: 1900px){
.modal-dialog {
    width: 900px;
	
    margin: 30px auto;
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
					<h1><a href="../servlet/ShowServlet?flag=1&num=1">CAPTURE</a></h1>
					<img src="images/logo-style.png" alt="Capture">
				</div>

				<div class="header-info">
					<p>今天带着马飞飞出来飞.</p>
					<p>飞的很开心.</p>
					<p>秀一下.</p>
				</div>

			
				<div class="clearfix"></div>

			</div>

			<div class="col-md-7 header-left">

				<div class="header-slider">
					<div class="slider-1">
						<!-- Slider -->
						<div class="slider">
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
									<img src="images/slide-6.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-7.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-8.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-9.jpg" alt="Sportive">
								</li>
								<li>
									<img src="images/slide-10.jpg" alt="Sportive">
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

	
		


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
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
	
	$("Button[name='tijiao']").bind("click",function () {
		
		var a=$(".file-caption-name").attr('title');
		alert(a);
	});
	
	});
</script>  
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao">
					提交更改
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
		

		<!-- About -->
		<div class="about" id="about">
			<h2>About Us</h2>
	
	  <!-- 说说循环开始 -->
         		<c:choose>
			<c:when test=""></c:when>
				<c:otherwise>
					<c:forEach items="${shuoshuolist}" var="str" varStatus="strs">
	
			<div class="about-grid${(strs.index)%2+1} w3layouts">
				
				<div class="col-md-12 col-sm-12 about-grid about-info">
					<div style="margin:15px 10px">
					<div class="col-md-1 col-sm-1">
						<img src="/inisDemo/users/${str.username}/touxiang/touxiang.jpg" class="touxiang img-circle" style="width:75px;height:75px; margin-right:1em""/>
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
											<!-- 	<img src="../${str.purl}/${i}.jpg"    alt="image" class="img-responsive agileits w3layouts zoom-img" > -->	
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
			<jsp:param value="../servlet/ShowServlet?flag=1" name="url"/>
		</jsp:include>
			
	

		</div>
		<!-- //About -->



		



		
		
		<!-- Gallery -->
		<!-- 
		<div class="gallery agileits w3layouts" id="gallery">
				<h3>Family Share</h3>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
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
				<div class="col-md-2 col-sm-2 gal-left agileits w3layouts">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-10.jpg" class="b-link-stripe b-animate-go swipebox agileits w3layouts">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-10.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-11.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-11.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical text-center agileits w3layouts">
						<a href="images/gallery-12.jpg" class="b-link-stripe b-animate-go agileits w3layouts swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-12.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-13.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-13.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-14.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-14.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-15.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-15.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-16.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-16.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-17.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-17.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-18.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-18.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-19.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-19.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-20.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-20.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-21.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-21.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom agileits w3layouts vertical text-center">
						<a href="images/gallery-22.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-22.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-23.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-23.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
							</div>
							<div class="info-box agileits w3layouts">
								<div class="info-content agileits w3layouts">
									<span class="separator agileits w3layouts"></span>
								</div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-md-2 col-sm-2 agileits w3layouts gal-left">
					<div class="content-grid-effect slow-zoom vertical agileits w3layouts text-center">
						<a href="images/gallery-24.jpg" class="b-link-stripe agileits w3layouts b-animate-go swipebox">
							<div class="img-box agileits w3layouts">
								<img src="images/gallery-24.jpg" alt="image" class="img-responsive agileits w3layouts zoom-img">
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
				
		</div>
		 -->
		<!-- //Gallery -->




		



		



		<!-- Footer -->
		<div class="footer agileits-w3layouts">
			<div class="container">

				<div class="footer-top w3layouts">
					<div class="footer-grids w3l-agile">
						<div class="col-md-3 col-sm-3 address agileinfo">
							<h5>Address</h5>
								<ul>
									<li>Parma Via Modena</li>
									<li>40019</li>
									<li>Sant'Agata Bolognese</li>
									<li>BO, Italy</li>
									<li>Mail : <a href="mailto:mail@example.com">info@example.com</a></li>
								</ul>
						</div>
						<div class="col-md-3 col-sm-3 contact agileinfo">
							<h5>Phone</h5>
							<div class="phone">
								<p>+1 234 456 7890</p>
								<p>+1 456 789 3450</p>
							</div>

							<div class="mail wthree">
								<form action="#" method="post">
									<input type="text" name="Email Address" placeholder="Email Address" required="">
									<input type="submit" value="Subscribe">
								</form>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="col-md-6 col-sm-6 connect agileinfo">
							<h5>Connect</h5>
							<div class="connect-social w3-agileits">
								<ul>
									<li><a href="#" class="facebook" title="Go to Our Facebook Page"></a></li>
									<li><a href="#" class="twitter" title="Go to Our Twitter Account"></a></li>
									<li><a href="#" class="googleplus" title="Go to Our Google Plus Account"></a></li>
									<li><a href="#" class="linkedin" title="Go to Our Linkedin Page"></a></li>
									<li><a href="#" class="blogger" title="Go to Our Blogger Account"></a></li>
									<li><a href="#" class="tumblr" title="Go to Our Tumblr Page"></a></li>
									<li><a href="#" class="rss" title="Go to Our RSS Feed"></a></li>
									<li><a href="#" class="vimeo" title="Go to Our Vimeo Channel"></a></li>
									<li><a href="#" class="deviantart" title="Go to Our Deviantart Page"></a></li>
								</ul>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="footer-bottom w3l-agile">
						<div class="footer-nav w3l">
							<ul>
								<li><a class="scroll" href="#">Home</a></li>
								<li><a class="scroll" href="#about">About</a></li>
								<li><a class="scroll" href="#services">Services</a></li>
								<li><a class="scroll" href="#team">Team</a></li>
								<li><a class="scroll" href="#gallery">Gallery</a></li>
							</ul>
						</div>
						<div class="copyright wthree">
							<p>&copy; 2016 Capture. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank"> W3layouts </a></p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

			</div>
		</div>
		<!-- //Footer -->



	<!-- Custom-JavaScript-File-Links -->

		<!-- Supportive-JavaScript --> <script type="text/javascript" src="js/jquery.min.js"></script>
		<!-- Necessary-JS-File-For-Bootstrap --> <script type="text/javascript" src="js/bootstrap.min.js"></script>

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
		<!-- //Gallery-JavaScript -->
</html>

