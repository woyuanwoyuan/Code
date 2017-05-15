<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!--
author: W3layouts
author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
	 <base href="<%=basePath%>introduction/">
<title>Classy Resume a Personal Category Bootstrap Responsive Website Template | Home :: w3layouts</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Classy Resume Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

<!-- gallery -->
<link type="text/css" rel="stylesheet" href="css/cm-overlay.css" />

<!-- //gallery -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 

<!-- //font-awesome icons -->

<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,700|Roboto:400,300,700' rel='stylesheet' type='text/css'>
<style>
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
</head>
	
<body>
<div class="main" id="home">
<!-- banner -->
	<div class="banner">
			<!--Slider-->
			<img src="/inisDemo/${introduction.fileurl}/touxiang.jpg"  alt=" " class="img-responsive" style="width:25%">
					<h2>大家好，我是${introduction.uname}</h2>
					<span>武汉理工大学${introduction.xuewei}</span>
				<div class="callbacks_container">
					<ul class="rslides" id="slider3">
						<li>
						
							<div class="slider-info">
								  <p>这个世界自始至终只有两种人：一种是像我这样的人，一种是不像我这样的人。 </p>
							</div>
						</li>
						<li>
							<div class="slider-info">
							   
								   <p>活下去的诀窍是：保持愚蠢，又不能知道自己有多蠢。</p>
						    </div>
						</li>
						<li>
							
							<div class="slider-info">
							<p>在很穷的时候，用到自己偷来的东西，感觉妙不可言！ </p>
							
							</div>
						</li>


					</ul>
					
			<div class="clearfix"></div>
		</div>
		<!--//Slider-->
					
	</div>
<!-- //banner -->
	</div>
<!-- header -->
	<div class="w3_navigation">
		<div class="container">
			<nav class="navbar navbar-default">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
					<div class="logo">
						<h1><a class="navbar-brand" href="index.html"><span class="one">个</span>人展示</a></h1>
					</div>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
					<nav class="cl-effect-1" id="cl-effect-1">
						<ul class="nav navbar-nav">
						<!-- 	<li class="active"><a class="scroll" href="index.html">Home</a></li>
							<li><a href="#about" class="scroll hvr-bounce-to-bottom">About</a></li>
							<li><a href="#services" class="scroll hvr-bounce-to-bottom">Services</a></li>
									<li><a href="#gallery" class="scroll hvr-bounce-to-bottom">Gallery</a></li> 
							<li><a href="#mail" class="scroll hvr-bounce-to-bottom">Contact</a></li>   -->
							<li><a href="#about" class="scroll hvr-bounce-to-bottom">About</a></li>
							<li><a href="#education" class="scroll hvr-bounce-to-bottom">Skills</a></li>
					
						</ul>
					</nav>
				</div>
				<!-- /.navbar-collapse -->
			</nav>
		</div>
	</div>
</div>
<!-- //header -->
<!-- about -->
	<div class="about" id="about">
		<div class="container">
					<h3 class="w3l_head">About Me</h3>
			<p class="w3ls_head_para">A few words about me</p>
				<!-- 按钮触发模态框 -->
                                            	<div class="input-group-btn pull-right">
<a class="btn btn-sm btn-default ${classinfo}"  data-toggle="modal" data-target="#myModal" id="bianji" title="${title}" >
	编辑
</a>
</div>
		<div class="w3l-grids-about">
				<div class="col-md-5 w3ls-ab-right">
					<div class="agile-about-right-img">
						<img src="/inisDemo/${introduction.fileurl}/touxiang.jpg" alt="" class="tx" style="width:100%;height:80%">
					</div>
				</div>
				<div class="col-md-7 w3ls-agile-left">
				<div class="w3ls-agile-left-info">
						<h4>姓名</h4>
						<p class="name">${introduction.uname} </p>
						
					</div>
				<div class="w3ls-agile-left-info">
						<h4>性别</h4>
						<p class="xingbie">${introduction.xingbie} </p>
					</div>
						<div class="w3ls-agile-left-info">
						<h4>入学年份</h4>
						<p class="startyear">${introduction.startyear.substring(0,10)}</p>
					</div>
					<div class="w3ls-agile-left-info">
						<h4>学位</h4>
						<p class="xuewei">${introduction.xuewei} </p>
					</div>
					
						<div class="w3ls-agile-left-info">
						<h4>破壳日</h4>
						<p class="birthday">${introduction.birthday.substring(0,10)}</p>
					</div>
					<div class="w3ls-agile-left-info" >
						<h4>家庭地址</h4>
						<p class="address">${introduction.address} </p>
					</div>
					<div class="w3ls-agile-left-info">
						<h4>邮箱</h4>
						<p class="email"><a href="${introduction.email}">${introduction.email} </a></p>
					</div>
					<div class="w3ls-agile-left-info">
						<h4>联系方式</h4>
						<p class="tel">${introduction.tel} </p>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
<!-- //about-bottom -->
<!-- services -->
<!--
<div class="service" id="services">
     <div class="container">
	 
	 		<h3 class="w3l_head two">WHAT I DO FOR YOU</h3>
			<p class="w3ls_head_para">See My Services</p>
    <div class="service-agileits">
			
			<div class="col-md-4 list-gds text-center">
				<i class="fa fa-cog" aria-hidden="true"></i>
				<h4>WHY CHOOSE Me.</h4>
				<p>Nam aliquam pretium feugiat. Duis sem est, viverra eu interdum ac, 
					suscipit nec mauris. Suspendisse commodo tempor sagittis</p>
			</div>
			<div class="col-md-4 list-gds text-center">
				<i class="fa fa-laptop" aria-hidden="true"></i>
				<h4>WHAT I DO. </h4>
				<p>Nam aliquam pretium feugiat. Duis sem est, viverra eu interdum ac, 
					suscipit nec mauris. Suspendisse commodo tempor sagittis</p>
			</div>
				<div class="col-md-4 list-gds text-center">
				<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
				<h4>My MISSION.</h4>
				<p>Nam aliquam pretium feugiat. Duis sem est, viverra eu interdum ac, 
					suscipit nec mauris. Suspendisse commodo tempor sagittis</p>
			</div>

			<div class="clearfix"></div>			
		
	 </div>
  </div>
 </div>
  -->
<!-- //services -->


<!-- /education -->
<!--
 <div class="education" id="education">
 <div class="col-md-4 skills">
		<h3 class="w3l_head two">教育经历</h3>
			<p>细数你的教育历程</p>

						</div>
	    <div class="col-md-8 education-w3l">
		     <h3 class="w3l_head three">My Education</h3>
		     					        	<div class="input-group-btn pull-right">
<a class="btn btn-sm btn-default ${classinfo}"  data-toggle="modal" data-target="#myModal2" id="bianji2" title="${title}" >
	编辑
</a>
</div>
			  <div class="education-agile-grids">
			  
				  
				  <div class="education-agile-w3l">
				     <div class="education-agile-w3l-year">
					       <h4>2008-2011</h4>
						   <h6>嘻嘻嘻</h6>
				     </div>
					 <div class="education-agile-w3l-info">
					       <h4>莆田第二中学</h4>
						   <p>2008-2011就读于莆田第二中学</p>
						  
				     </div>
				      <div class="clearfix"></div>
				  </div>
				  <div class="education-agile-w3l two">
				    <div class="education-agile-w3l-year">
					       <h4>2011-2015</h4>
						   <h6>嘻嘻嘻</h6>
				     </div>
					 <div class="education-agile-w3l-info">
					       <h4>武汉理工大学</h4>
						   <p>2011-2015就读于武汉理工大学</p>
						  
				     </div>
				      <div class="clearfix"></div>
				  </div>
				  <div class="education-agile-w3l">
				     <div class="education-agile-w3l-year">
					       <h4>2015-至今</h4>
						   <h6>嘻嘻嘻</h6>
						
				     </div>
					 <div class="education-agile-w3l-info">
					       <h4>武汉理工大学</h4>
						   <p>2011-2015就读于武汉理工大学</p>
						  
				     </div>
				      <div class="clearfix"></div>
				  </div>
				 
			  </div>
		</div>
		
		 </div>
		 <div class="clearfix"> </div>
		</div>
		-->
 <!-- //education -->
 
 
 
 
  <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					上传论文
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
				    <label for="xuewei">学位</label>
				    <input type="text" class="form-control" id="xuewei" placeholder="请输入学位" name="xuewei">
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
				    <label for="beizhu">备注</label>
				   <textarea class="form-control" rows="6"  name="beizhu" type="text" id="beizhu"></textarea>
				  </div>
				  <div class="form-group">
				  <div class="form-group">
				    <label for="inputfile">上传头像</label>
				    <input type="file" id="inputfile" name="inputfile" accept=".jpg,">
				  
				  </div>
				
				  <button type="submit" class="btn btn-default">提交</button>
				</form>
    </div>  

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
 </div>
 <!-- /.modal结束 -->
 
 
 <!-- 模态框2（Modal） -->
 <!--
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					上传论文
				</h4>
			</div>
			<div class="modal-body">
			<form role="form" name="uploadCode" method="post"  action="../servlet/UploadServlert?flag=5">
				 <div class="form-group">
				    <label for="xuewei">学历1</label>
				    <input type="text" class="form-control" id="xuewei" placeholder="请输入学位" name="xuewei">
				  </div>
				 
				     <div class="form-group">
				    <label for="time2">入学年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				    <div class="form-group">
				    <label for="time2">毕业年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				   <div class="form-group">
				    <label for="address">就读学校</label>
				    <input type="text" class="form-control" id="address" placeholder="请输入家庭地址" name="address">
				  </div>
			<div class="form-group">
				    <label for="xuewei">学历2</label>
				    <input type="text" class="form-control" id="xuewei" placeholder="请输入学位" name="xuewei">
				  </div>
				 
				     <div class="form-group">
				    <label for="time2">入学年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				    <div class="form-group">
				    <label for="time2">毕业年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				   <div class="form-group">
				    <label for="address">就读学校</label>
				    <input type="text" class="form-control" id="address" placeholder="请输入家庭地址" name="address">
				  </div>
				  <div class="form-group">
				    <label for="xuewei">学历3</label>
				    <input type="text" class="form-control" id="xuewei" placeholder="请输入学位" name="xuewei">
				  </div>
				 
				     <div class="form-group">
				    <label for="time2">入学年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				    <div class="form-group">
				    <label for="time2">毕业年份</label>
				    <input type="date" class="form-control" id="time2" placeholder="请输入日期" name="time2">
				  </div>
				   <div class="form-group">
				    <label for="address">就读学校</label>
				    <input type="text" class="form-control" id="address" placeholder="请输入家庭地址" name="address">
				  </div>
				  <button type="submit" class="btn btn-default">提交</button>
				</form>
    </div>  

			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button type="button" class="btn btn-primary" name="tijiao">
					确定
				</button>
			</div>
		</div><!-- /.modal-content -->
<!-- </div> <!-- /.modal -->
 <!--</div>
 -->
 <!-- /.modal2结束 -->
 
 
<!-- footer -->
	<div class="w3l_footer">
		
		<div class="w3l_footer_pos">
			<p>© 2016 Classy Resume. All Rights Reserved | Design by <a href="https://w3layouts.com/">W3layouts</a></p>
		</div>
	</div>
<!-- //footer -->
<script src="js/jquery-2.2.3.min.js"></script> 
<!-- skills -->
<script src="js/pie-chart.js" type="text/javascript"></script>
 <script type="text/javascript">

        $(document).ready(function () {
            $('#demo-pie-1').pieChart({
                barColor: '#44c7f4',
                trackColor: '#fff',
                lineCap: 'round',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-2').pieChart({
                barColor: '#44c7f4',
                trackColor: '#fff',
                lineCap: 'butt',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });

            $('#demo-pie-3').pieChart({
                barColor: '#44c7f4',
                trackColor: '#fff',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
			
			$('#demo-pie-4').pieChart({
                barColor: '#44c7f4',
                trackColor: '#fff',
                lineCap: 'square',
                lineWidth: 8,
                onStep: function (from, to, percent) {
                    $(this.element).find('.pie-value').text(Math.round(percent) + '%');
                }
            });
        });
    </script>
<!-- skills -->	
						<script src="js/responsiveslides.min.js"></script>
							<script>
								// You can also use "$(window).load(function() {"
								$(function () {
								  // Slideshow 4
								  $("#slider3").responsiveSlides({
									auto: true,
									pager:true,
									nav:false,
									speed: 500,
									namespace: "callbacks",
									before: function () {
									  $('.events').append("<li>before event fired.</li>");
									},
									after: function () {
									  $('.events').append("<li>after event fired.</li>");
									}
								  });
								  
								  
								   //2.点击编辑
						            $("#bianji").on("click",function(){
						            var name= $(".name").text();
						         	var xingbie= $(".xingbie").text();
						            var xuewei= $(".xuewei").text();
						         	var birthday= $(".birthday").text();
						         	alert(birthday);
					//var birthday1=birthday.replace(/-/g,"/");
					//	 alert(birthday1);
					     var startyear= $(".startyear").text();
						        	var address= $(".address").text();
						            var email= $(".email").text();
						         	var tel= $(".tel").text();
						         	var tx= $(".tx").attr("src");
						         	alert(tx);
						         	
						         	$("input[name='name']").val(name);
						         	if(xingbie=="男"){
						         	$("input:radio[name='optionsRadios']").eq(1).attr("checked",'checked');
						         	}else{
						         	 	$("input:radio[name='optionsRadios']").eq(0).attr("checked",'checked');
						         	}
						         	
						        	//$("input[name='optionsRadios']").val("女"); 
									$("input[name='xuewei']").val(xuewei);
									$("input[name='time']").val(birthday);
									$("input[name='time2']").val(startyear);
						        $("input[name='address']").val(address); //获得文本框中的值
									$("input[name='email']").val(email);	
									$("input[name='tel']").val(tel);
								//	$("input[name='inputfile']").val(tx);
						         	
						         	
						           });
								  
							
						         
						  
								   
								});
								
								
						      	//使装图片的div宽高保1.25:1；
					        	   $(document).ready(function(){
					        	    var width=$(".img-responsive").width();
					        	    
					        	    $(".img-responsive").height(width);
					        	//    alert($(".content-grid-effect").width());
					        	//    alert($(".content-grid-effect").height());
					        	   });
					    
							 </script>
							 <!-- js -->
				<script src="js/jquery.tools.min.js"></script>
				<script src="js/jquery.mobile.custom.min.js"></script>
				<script src="js/jquery.cm-overlay.js"></script>
				<script>
					$(document).ready(function(){
						$('.cm-overlay').cmOverlay();
					});
				</script>
<!-- js files -->



<script src="js/bars.js"></script>

<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->

<!-- //js -->
	<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>

