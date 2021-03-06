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
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<!--<link rel="shortcut icon" href="favicon.ico"> -->
	<!-- Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,700|Roboto:400,300,700' rel='stylesheet' type='text/css'>
	<!-- Animate -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Flexslider -->
	<link rel="stylesheet" href="css/flexslider.css">
	<!-- Icomoon -->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<!-- swipebox 展示图片  -->
	<link rel="stylesheet" href="css/swipebox.css">

	<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<style>
	#fh5co-main-nav ul li ul li a {
    font-family: "Roboto Slab", sans-serif;
    color: rgba(0, 0, 0, 0.8);
    text-decoration: none;
    margin-left:0px !important;
    text-align:center;
    border-bottom: 2px solid transparent;
}
#fh5co-main-nav ul li ul {
margin:4px 0 0 30px !important;
}

.dropdown-menu{
background-color:	transparent;
min-width:120px;
}
.port.effect-1 .text-desc {

    padding: 2em 0.7em;
} 


.title a {
    color: #444444;
   
}
	</style>

	
	</head>
	<body>

	<div id="fh5co-header">
		<div class="container">
			<!-- Mobile Toggle Menu Button -->
			<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
			<div id="fh5co-logo">
				<a href="index.jsp">INIS<span>.</span></a>
			</div>
			<nav id="fh5co-main-nav">
				<ul>
					<li><a href="#" data-nav-section="home">Home</a></li>
					<li><a href="#" data-nav-section="team">Team</a></li>
					<li><a href="#" data-nav-section="new">New</a></li>
					<li><a href="#" data-nav-section="family">Family</a></li>
					<li><a href="#" data-nav-section="more">More</a></li>
					
		  			 <li class="dropdown">
								<a href="#" class="dropdown-toggle external" data-toggle="dropdown">
								<span class="glyphicon glyphicon-user">	${userinfo.username} </span>
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu" >
									<li> <a href="upweb/index.jsp"  class="external"   ><span class="glyphicon glyphicon-off">&nbsp;注销</span></a></li> 
									<!--在bootstrap框架的导航栏中 ，只有添加 class="external"，表明是外部链接，才可以跳转外部链接，不然会默认当做导航块在该页面导航使用 -->
								</ul>
						</li>
				</ul> 
			</nav>
		</div>
				 
	</div>
	<div id="fh5co-main">
		<div class="fh5co-overlay-mobile"></div>
		     	<!--//home -->
		<div id="fh5co-home" class="js-fullheight" data-section="home">

			<div class="flexslider">
				
				<div class="fh5co-overlay" ></div> <!--此处在main.js中控制background-image的opacity的值，以及鼠标滑动后的变化 -->
				<div class="fh5co-text">
						
					<div class="container">
						<div class="row text-center">
							<h1 class="animate-box">INIS实验室欢迎你~</h1>
							<div class="fh5co-go animate-box">
								<a href="#" class="js-fh5co-next">
									Learn More
									<span><i class="icon-arrow-down2"></i></span>
								</a>
								
							</div>
						</div>
					</div>
			
				</div>
			  	<ul class="slides">
			   	<li style="background-image: url(images/slide_1.jpg);" data-stellar-background-ratio="0.3"></li>
			   	<li style="background-image: url(images/slide_2.jpg);" data-stellar-background-ratio="0.3"></li>
			   	<li style="background-image: url(images/slide_3.jpg);" data-stellar-background-ratio="0.3"></li>
			  	</ul>

			</div>
		</div>
        
      	<!--//home -->
	
			<!--//team -->
<div id="staff" class="reviews" data-section="team">
		   <div class="container ">
			<div  class="inner-w3">
			<h3 class="title animate-box "><a href="#home" data-toggle="tab" style="color:#000" class="daoshi">导师专栏</a>&<a href="#ios" data-toggle="tab" style="opacity:0.3"class="jianjie">INIS简介</a> <span></span></h3></div>
			
				

<div id="myTabContent" class="tab-content">
	<div class="staff-section tab-pane fade in active" id="home">
				    <div class="col-md-3 staff-grid  animate-box" data-wow-duration="1000ms" data-wow-delay="500ms">
				          <div class="view fifth-effect">
							 <a href="http://sa.whut.edu.cn/zdh2013/content/?993.html" title="Full Image" target="_blank"><img src="images/t1.jpg" /></a>
							 <div class="mask"></div>
						  </div>
							<h4>刘清</h4>
						  <p>博士生导师，教授</p>
												  
				     </div>
					  <div class="col-md-3 staff-grid animate-box" data-wow-duration="1000ms" data-wow-delay="500ms">
				         <div class="view fifth-effect">
							 <a href="http://sa.whut.edu.cn/zdh2013/content/?934.html" title="Full Image" target="_blank"><img src="images/t2.jpg" /></a>
							 <div class="mask"></div>
						</div>  
						<h4>郭建明</h4>
						  <p>教授</p>
													
				     </div>
					 <div class="col-md-3 staff-grid animate-box" data-wow-duration="1000ms" data-wow-delay="500ms">
				          <div class="view fifth-effect">
							 <a href="http://sa.whut.edu.cn/zdh2013/content/?9719.html" title="Full Image" target="_blank"><img src="images/t3.jpg" /></a>
							 <div class="mask"></div>
						  </div>
						  <h4>徐小强</h4>
						  <p>副教授</p>
							
						 
				     </div>
					  <div class="col-md-3 staff-grid  animate-box" data-wow-duration="1000ms" data-wow-delay="500ms">
				          <div class="view fifth-effect">
							 <a href="http://sa.whut.edu.cn/zdh2013/content/?4550.html" title="Full Image" target="_blank"><img src="images/t4.jpg" /></a>
							 <div class="mask"></div>
						  </div>
							<h4>黄珍</h4>
						  <p>副教授</p>
												  
				     </div>
					   <div class="clearfix"></div>
				 </div>
	<div class="tab-pane fade" id="ios">
	<div class="panel panel-primary" style="margin:1em auto">
	<div class="panel-heading">
		<h3 class="panel-title">实验室简介</h3>
	</div>
	<div class="panel-body">
		武汉理工大学工业网络与智能系统研究所所长为刘清教授，研究所是由原港口自动化专业方向基础上发展起来的。多年来从事电气传动控制技术、网络技术、智能系统及其应用、传感与检测技术、计算机实时控制与远程监视等方面的研究,其突出特点是理论与实践并重,技术与工程结合。研究所有教授2人,副教授以上职称4人,讲师和实验师5人。主要骨干均有博士学位或为在读博士生。每年招收硕士研究生近30多人。 
    目前研究所设5个研究小组：工业网络与工业控制小组，智能控制理论及其机器人控制研究小组，视频传输技术与计算机网络研究小组，智能信息和图像处理研究小组，传感器网络技术研究小组。科研方面主要体现在港口计算机网络控制与监视系统集成（包括集装箱和散货码头），船舶智能控制与计算机远程监视，无线视频传输技术研究与工程应用，多传感器融合、多智能体的协同技术和智能技术在港口AGV系统中的应用，基于DSP的谐波抑制和无功补偿技术研究，基于DSP和嵌入式系统的AGV运动控制技术研究等。  
    研究所的基本定位是：紧密跟踪国际学术前沿，保持理论研究和技术应用研究并重的特色，形成从方法创新到软硬件技术研究，从学术研究到促进成果转化的有机统一，建成有自己学术特色的高水平研究基地。研究所将充分发挥原有的行业优势，开拓新的应用领域，深入开展理论研究，全面提升综合实力，为我国的经济建设和社会进步做出了应有的贡献
	</div>
</div>
<div class="panel panel-primary">
	<div class="panel-heading">研究方向</div>
	
	<ul class="list-group">
		<li class="list-group-item">工业无线网络系统及其信息安全技术的研究</li>
		<li class="list-group-item">基于网络控制技术的计算机远程检测与监控</li>
		<li class="list-group-item">智能控制理论及其应用研究</li>
		<li class="list-group-item">智能传感器与多传感器融合技术</li>
		<li class="list-group-item">船舶港口自动化和自动控制与CAD技术</li>
	</ul>
</div>


	</div>
	
</div>

			
	      </div>
	</div>
<!--//team -->
<div class="content-bottom" id="news" data-section="new">
	<div class="inner-w3 agl animate-box">
					<h3 class="title">我们的足迹 <span></span></h3>
				</div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                  <a href="servlet/ShowServlet?flag=1&num=1" target="_blank"><img src="images/g7.jpg" alt="" class="img-responsive"></a>
               </div>
                <div class="text-desc">
                    <h6>马飞飞</h6>
                    <p>我在南湖飞</p>
					 <h5>Jan.26.2016</h5>
                </div>
           </div>
         </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                   <a href="html/index.html" target="_blank"><img src="images/g1.jpg" alt="" class="img-responsive"></a>
                </div>
				<div class="text-desc">
                     <h6>马菲菲</h6>
                    <p>路过鉴湖飞p>
					<h5>Mar.30.2016</h5>					
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                     <a href="html/index.html" target="_blank"><img src="images/g4.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                      <h6>马慧慧Family</h6>
                    <p>然后西苑集体飞</p>
					<h5>Jun.16.2016</h5>
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                <a href="html/index.html" target="_blank"><img src="images/g6.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                     <h6>马灰灰Family</h6>
                    <p>来东院装个bi</p>
                </div>
            </div>
        </div>
		
        <div class="clearfix"> </div>
		
			<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                  <a href="html/index.html" target="_blank"><img src="images/g2.jpg" alt="" class="img-responsive"></a>
               </div>
                <div class="text-desc">
                    <h6>马飞飞</h6>
                    <p>我在南湖飞</p>
					 <h5>Jan.26.2016</h5>
                </div>
           </div>
         </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                   <a href="html/index.html" target="_blank"><img src="images/g3.jpg" alt="" class="img-responsive"></a>
                </div>
				<div class="text-desc">
                     <h6>马菲菲</h6>
                    <p>路过鉴湖飞p>
					<h5>Mar.30.2016</h5>					
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                     <a href="html/index.html" target="_blank"><img src="images/g5.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                      <h6>马慧慧Family</h6>
                    <p>然后西苑集体飞</p>
					<h5>Jun.16.2016</h5>
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                <a href="html/index.html" target="_blank"><img src="images/g6.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                     <h6>马灰灰Family</h6>
                    <p>来东院装个bi</p>
                </div>
            </div>
        </div>
		
        <div class="clearfix"> </div>
</div>
<!--//new -->
<!-- gallery -->
<div id="gallery" class="gallery" data-section="family">
	<div class="container">
	 <div class="inner-w3 animate-box">
		<h3 class="title"> INIS的花朵 <span></span></h3>
	 </div>
		<div class="gallery_gds animate-box">
			<ul class="simplefilter wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
                <li class="active" data-filter="all">All</li>
                <li data-filter="1">一组帅比</li>
                <li data-filter="2">二组逗比</li>
                <li data-filter="3">三组萨比</li>
                <li data-filter="4">四组懵逼</li>
            </ul>
     
            <div class="filtr-container wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
                <div class=" col-md-4 filtr-item" data-category="1, 5" data-sort="Busy streets">
					<a href="servlet/ShowServlet?flag=4" >
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号帅比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g1.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
                <div class="col-md-4 filtr-item" data-category="2, 5" data-sort="Luminous night">
					<a href="images/g2.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">102号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g2.jpg" alt=" " /></div>
						</div>
					</a>

                </div>
                <div class="col-md-4 filtr-item" data-category="1, 4" data-sort="City wonders">
                    <a href="images/g3.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g3.jpg" alt=" " /></div>
						</div>
					</a>

                </div>
                <div class=" col-md-4 filtr-item" data-category="3" data-sort="In production">
                    <a href="images/g4.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g4.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
                <div class="col-md-4 filtr-item" data-category="3, 4" data-sort="Industrial site">
                    <a href="images/g5.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img  src="images/g5.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
                <div class="col-md-4 filtr-item" data-category="2, 4" data-sort="Peaceful lake">
                    <a href="images/g6.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img  src="images/g6.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
                <div class="col-md-4  filtr-item" data-category="1, 5" data-sort="City lights">
                    <a href="images/g7.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img  src="images/g7.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
                <div class="col-md-4 filtr-item" data-category="2, 4" data-sort="Dreamhouse">
                    <a href="images/g8.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="images/g8.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
				<div class="col-md-4 filtr-item" data-category="3" data-sort="Dreamhouse">
                    <a href="images/g3.jpg" class="b-link-stripe b-animate-go  swipebox">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">101号逗比</div>			
									<div class="line"></div>			
									<div class="headline">我很帅谢谢</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img  src="images/g3.jpg" alt=" " /></div>
						</div>
					</a>
                </div>
               <div class="clearfix"> </div>
            </div>
		</div>
	</div>
	</div>
		
		<!-- gallery -->
	<!--//more -->
<div class="content-bottom" id="more" data-section="more">
	<div class="inner-w3 agl animate-box">
					<h3 class="title">更多待续 <span></span></h3>
				</div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                  <a href="servlet/ShowServlet?flag=3&num=1" target="_blank"><img src="images/g7.jpg" alt="" class="img-responsive"></a>
               </div>
                <div class="text-desc">
                    <h6>马飞飞</h6>
                    <p>我在南湖飞</p>
					 <h5>Jan.26.2016</h5>
                </div>
           </div>
         </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                   <a href="html/index.html" target="_blank"><img src="images/g1.jpg" alt="" class="img-responsive"></a>
                </div>
				<div class="text-desc">
                     <h6>马菲菲</h6>
                    <p>路过鉴湖飞p>
					<h5>Mar.30.2016</h5>					
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                     <a href="html/index.html" target="_blank"><img src="images/g4.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                      <h6>马慧慧Family</h6>
                    <p>然后西苑集体飞</p>
					<h5>Jun.16.2016</h5>
                </div>
            </div>
        </div>
	
		
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                <a href="html/index.html" target="_blank"><img src="images/g6.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                     <h6>马灰灰Family</h6>
                    <p>来东院装个bi</p>
                </div>
            </div>
        </div>
			<div class="clearfix"> </div>
			<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                  <a href="html/index.html" target="_blank"><img src="images/g2.jpg" alt="" class="img-responsive"></a>
               </div>
                <div class="text-desc">
                    <h6>马飞飞</h6>
                    <p>我在南湖飞</p>
					 <h5>Jan.26.2016</h5>
                </div>
           </div>
         </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                   <a href="html/index.html" target="_blank"><img src="images/g3.jpg" alt="" class="img-responsive"></a>
                </div>
				<div class="text-desc">
                     <h6>马菲菲</h6>
                    <p>路过鉴湖飞p>
					<h5>Mar.30.2016</h5>					
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                     <a href="html/index.html" target="_blank"><img src="images/g5.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                      <h6>马慧慧Family</h6>
                    <p>然后西苑集体飞</p>
					<h5>Jun.16.2016</h5>
                </div>
            </div>
        </div>
		<div class="content-in animate-box">
            <div class="port effect-1">
                <div class="image-box">
                <a href="html/index.html" target="_blank"><img src="images/g6.jpg" alt="" class="img-responsive"></a>
                </div>
                <div class="text-desc">
                     <h6>马灰灰Family</h6>
                    <p>来东院装个bi</p>
                </div>
            </div>
        </div>
		
        <div class="clearfix"> </div>
</div>
<!--//more -->	
		
	
<!-- footer -->
		<div id="fh5co-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6 animate-box">
						<div class="fh5co-footer-widget">
							<p>&copy; Fotografy Free HTML5 Template. All Rights Reserved.</p>

						</div>
					</div>
					<div class="col-md-6 col-sm-6 animate-box">
						<div class="fh5co-footer-widget">
							<ul class="fh5co-social pull-right">
								<li>
									<a href="#"><i class="icon-twitter"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon-facebook"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon-vine"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon-behance"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon-google"></i></a>
								</li>
								<li>
									<a href="#"><i class="icon-vimeo"></i></a>
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
	

	
		<!--Slide-To-Top  实现回到顶部的动画效果 -->
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
		
		<!-- Slide-To-Top -->
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
		<script>
	   $(document).ready(function(){
	    var width=$(".effect-1").width();
	    
	    $(".effect-1").height(width/1.25);
	    alert($(".effect-1").width());
	    alert($(".effect-1").height());
	   });
</script>
	
	<!-- jQuery Easing  实现动画效果-->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints  实现滚动监听 -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax 视觉差滚动-->
	<script src="js/jquery.stellar.min.js"></script>
	
	<!-- filterizr    jQuery的筛选过滤插件-->
	<script src="js/jquery.filterizr.js"></script>
	<script src="js/controls.js"></script>
	  <!-- Kick off Filterizr  启动筛选-->
    <script type="text/javascript">
        $(function() {
            //Initialize filterizr with default options
            //Filterizr  启动筛选-
            $('.filtr-container').filterizr();
            
            //切换导师栏和简介栏时透明度变化
            $(".daoshi").on("click",function(){
         	   $(this).css("opacity","1");
        	   $(".jianjie").css("opacity","0.3");
            });
            $(".jianjie").on("click",function(){
          	   $(this).css("opacity","1");
         	   $(".daoshi").css("opacity","0.3");
             });
        	 
           
        });
    </script>
	<!-- Flexslider - Flexslider是一款基于的jQuery内容滚动插件  Flexslider图片轮播、文字图片相结合滑动切换效果-->
	<script src="js/jquery.flexslider-min.js"></script>
	
	<!-- //js --><!-- swipe box js  Swipebox 是一款可触摸的 jQuery 灯箱效果插件 -->
	<script src="js/jquery.swipebox.min.js"></script> 
	    <script type="text/javascript">
			jQuery(function($) {
				$(".swipebox").swipebox();
			});
	</script>
<!-- //swipe box js -->
	
	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>





