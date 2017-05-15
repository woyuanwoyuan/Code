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
	<link rel="stylesheet" href="css/bootstrap.min.css">  
	<!-- swipebox 展示图片  -->
	<link rel="stylesheet" href="css/swipebox.css">

	<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" href="css/style_lunwen.css">
<link rel="stylesheet" href="css/slidefolio.css">
	     <link href="css/bootstrapValidator.min.css" rel="stylesheet" />
<!-- Font Awesome -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">

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
margin:15px 0 0 30px !important;
}

.dropdown-menu{
background-color:	transparent;
min-width:120px;
}
.port.effect-1 .text-desc {

    padding: 2em 0.7em;
} 
.abt-gd-left p{
font-size:1.0em;
color:#fff;
}
.education-agile-w3l{
padding:1em;
margin:1em;
}
.title a {
    color: #444444;
   
}

.table-hover > tbody > tr:hover > td,
.table-hover > tbody > tr:hover > th {
  background-color:#ccc;
}
td{
font-size:0.8em;
padding:1em;
}
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th
{
padding:1em;
}
.btn-primary {
    color: #fff;
    background-color: #337ab7;
    border-color: #2e6da4;
}
#fh5co-main-nav  ul li ul li a{
text-align:left;
}
.biaohover:hover{
color:yellow;
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
					<li><a href="#" data-nav-section="new">News</a></li>
					<li><a href="#" data-nav-section="family">Family</a></li>
					<li><a href="#" data-nav-section="more">Academic</a></li>
					<c:if test="${userinfo.role_id != '3' }">   
		  			 <li class="dropdown" style="backgroundColor:#fff">
								<a href="#" class="dropdown-toggle external" data-toggle="dropdown">
								<img class="img-circle"   src="/inisDemo/users/${userinfo.username}/touxiang/touxiang.jpg" alt="头像" style="width:45px;height:45px" "/>
									<b class="caret"></b>
								</a>
								<ul class="dropdown-menu" >
								<li> <a href="servlet/ShowServlet?flag=4&uname=${userinfo.username}"  class="external"  target="_blank" ><span class="glyphicon glyphicon-user">&nbsp;${userinfo.username} </span></a></li> 
									
									<c:if test="${userinfo.role_id eq '0' }">   
											<li> <a href="bootstrap-fileinput-master/updatePic.jsp" class="external"  target="_blank" >
												<span class="glyphicon glyphicon-picture">&nbsp;编辑壁纸</span>
											</a></li>

								</c:if>
									
									<li> <a href="upweb/index.jsp"  class="external"   ><span class="glyphicon glyphicon-off">&nbsp;注销</span></a></li> 
									<!--在bootstrap框架的导航栏中 ，只有添加 class="external"，表明是外部链接，才可以跳转外部链接，不然会默认当做导航块在该页面导航使用 -->
								</ul>
						</li>
						</c:if>
						<c:if test="${userinfo.role_id == '3' }">   
						<li><a href="#" >游客</a><a href="upweb/index.jsp"  class="external" >登录</a></li> 
						</c:if>
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
							<h1 class="animate-box">Welcome To INIS</h1>
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
			<h3 class="title animate-box "><a href="#home" data-toggle="tab" style="color:#000" class="daoshi">导师专栏</a><b>|</b><a href="#ios" data-toggle="tab" style="opacity:0.3"class="jianjie">INIS简介</a> <span></span></h3></div>
			
				

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
	<div class="tab-pane fade" id="ios" >
	<div style="padding:1em 0">
	<c:if test="${userinfo.role_id eq '0' }">   
								<button class="btn btn-primary pull-right ${classinfo}"  data-toggle="modal" data-target="#myModal"  title="${title }" style="margin-bottom:0.5em" id="bianji">
	编辑
</button>
<div class="clearfix"></div>
								</c:if>
								</div>
	<div class="panel panel-primary" >
	
	<div class="panel-heading">
		<h3 class="panel-title">实验室简介</h3>
	</div>
	<div class="panel-body inisjianjie">${inisInfo.jianjie}
	</div>
</div>
<div class="panel panel-primary">
	<div class="panel-heading">研究方向</div>
	
	<ul class="list-group">
		<li class="list-group-item yanjiu1">${inisInfo.yanjiu1}</li>
		<li class="list-group-item yanjiu2">${inisInfo.yanjiu2}</li>
		<li class="list-group-item yanjiu3">${inisInfo.yanjiu3}</li>
		<li class="list-group-item yanjiu4">${inisInfo.yanjiu4}</li>
		<li class="list-group-item yanjiu5">${inisInfo.yanjiu5}</li>
	</ul>
</div>


	</div>
	
</div>

			
	      </div>
	</div>
<!--//team -->
<!--//new -->
<div class="content-bottom" id="news" data-section="new">
	<div class="inner-w3 agl animate-box">
					<h3 class="title">我们的足迹 <span></span></h3>
				</div>
					<c:forEach items="${shuoshuolist}" var="str" varStatus="strs">
		<div class="content-in animate-box" >
            <div class="port effect-1">
                <div class="image-box" style="width:100%;height:100%">
                  <a href="servlet/ShowServlet?flag=1&num=1" target="_blank"><img src="/inisDemo/${str.purl}/1.jpg" alt="" class="img-responsive" style="width:110%;max-height:120%;height:120%""></a>
               </div>
                <div class="text-desc">
                    <span>${str.username}</span>
                    <p>     <c:if test="${fn:length(str.content)>'20'}">  
					                    ${fn:substring(str.content,0,20)}...  
					            </c:if>  
					            <c:if test="${fn:length(str.content)<='20'}">  
					                ${str.content}  
					            </c:if>  
             </p>
					 <h5>${(str.publishtime).substring(0,10)}</h5>
                </div>
           </div>
         </div>
         </c:forEach>
		
		
        <div class="clearfix"> </div>
</div>
<!--//new -->
<!-- gallery -->
<div id="gallery" class="gallery" data-section="family">
	<div class="container">
	 <div class="inner-w3 animate-box">
		<h3 class="title"> 学生团队 <span></span></h3>
	 </div>
		<div class="gallery_gds animate-box">
			<ul class="simplefilter wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
               	<li class="preLi">上一组</li>
             
                <li data-filter="2014" class="li1">2014届</li>
                <li data-filter="2015" class="li2">2015届</li>
                <li data-filter="2016" class="li3">2016届</li>
                <li data-filter="2017" class="li4 active"  id="xin">2017届</li>
                	<li class="nextLi">下一组</li>
            </ul>

     	 <div class="filtr-container wow zoomIn" data-wow-duration="1.5s" data-wow-delay="0.1s">
     	             <!-- family循环开始 -->
     <c:forEach items="${introductionlist}" var="str_intr" varStatus="strs_intr">
                <div class=" col-md-4 filtr-item" data-category="${str_intr.startyear.substring(0,4)}" data-sort="Busy streets">
					<a href="servlet/ShowServlet?flag=4&uname=${str_intr.uname}"  target="_blank">
						<div class="item item-type-double">
							<div class="item-hover">
								<div class="item-info">
									<div class="date">${str_intr.startyear.substring(0,4)}届${str_intr.xuewei}</div>			
									<div class="line"></div>			
									<div class="headline">${str_intr.uname}</div>
									<div class="line"></div>
								</div>
								<div class="mask"></div>
							</div>
							<div class="item-img"><img src="/inisDemo/${str_intr.fileurl}/touxiang.jpg" alt=" "  style="height:100%"/></div>
						</div>
					</a>
                </div>
      </c:forEach>
     <!-- family循环结束 -->
      
                <div class=" col-md-4 filtr-item" data-category="2013" data-sort="Busy streets">
					<a href="servlet/ShowServlet?flag=4&uname=嘻嘻嘻" >
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
                <div class="col-md-4 filtr-item" data-category="2014" data-sort="Luminous night">
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
                <div class="col-md-4 filtr-item" data-category="2016" data-sort="City wonders">
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
                <div class=" col-md-4 filtr-item" data-category="2015" data-sort="In production">
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
                <div class="col-md-4 filtr-item" data-category="2013" data-sort="Industrial site">
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
                <div class="col-md-4 filtr-item" data-category="2016" data-sort="Peaceful lake">
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
                <div class="col-md-4  filtr-item" data-category="2014" data-sort="City lights">
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
                <div class="col-md-4 filtr-item" data-category="2015" data-sort="Dreamhouse">
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
				<div class="col-md-4 filtr-item" data-category="2014" data-sort="Dreamhouse">
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
	   <!-- /experience -->
 <div class="education" id="education two">
 <div class="inner-w3 animate-box">
		<h3 class="title"> 科研成果 <span></span></h3>
	 </div>
 		<div class="col-md-3 skills two" style="margin:4em 0 0 4em">

	     <div class="skill-agile">
			<div class="col-sm-12 abt-gd-left text-center">
			
		</div>
		
		
		<div class="clearfix"></div>
</div>
		 </div>
	    <div class="col-md-8 education-w3l">
	<!--       <h3 class="w3l_head three">论文展示</h3> -->	
			  <div class="education-agile-grids">
			  <!-- 论文循环开始 -->
			  <a href="servlet/ShowServlet?flag=3&num=1" class="pull-right " style="font-size:1.1em; margin:0.6em 0;color:blue;font-family: "Roboto Slab", sans-serif"  target="_blank" >More</a>
			    <table class="table table-hover">
<!-- 
	<thead>
		<tr>
			<th>类型</th>
			<th>题目</th>
			<th>作者</th>
			<th>时间</th>
			<th>预览</th>
			<th>下载</th>
		</tr>
	</thead>
	
	 -->
	<tbody >
	<!-- 说说循环开始 -->
         		<c:choose>
			<c:when test=""></c:when>
				<c:otherwise>
					<c:forEach items="${lunwenlist}" var="str" varStatus="strs">
		<tr>
			<td>${str.leibie}</td>
			<td>${str.timu}</td>
			<td>${str.author}</td>
			<td>${(str.publishtime).substring(0,10)}</td>
			
			 <c:choose>
                                <c:when test="${userinfo.role_id == '3'  }">
                                    <c:choose>
                                        <c:when test="${str.gongkai =='off'}">
                                        <td>	
                                         <a href="javascript:void(0);"  onclick="this.setAttribute('disabled','disabled')">不公开</a>
                                        </td>
                                        	<td> <a href="javascript:void(0);"  onclick="this.setAttribute('disabled','disabled')">不公开</a></td>
                                        </c:when>
                                        <c:otherwise>
                                        <td>	
                                       <a href= "${str.flieurl}/${str.filename}"  target="_blank"  class="biaohover">预览</a>
                                      
                                        	</td>
                                        		<td><a href="servlet/DownloadServlet?type=lunwen&filename=${str.filename}&filepath=${str.flieurl}"  target="_blank"  class="biaohover">下载</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                <td>	
                                 <a href= "${str.flieurl}/${str.filename}"  target="_blank"  class="biaohover">预览</a>
                                 </td>
                                 	<td><a href="servlet/DownloadServlet?type=lunwen&filename=${str.filename}&filepath=${str.flieurl}"  target="_blank"  class="biaohover">下载</a></td>
                                </c:otherwise>
                            </c:choose>
			 
		
			
		</tr>
		 <!--shuos循环结束 -->
    
      
        


      		</c:forEach>
				</c:otherwise>
			</c:choose>	
	</tbody>
</table>
				      <!-- 论文循环结束 -->
				  <div>
					
				  </div>
			  </div>
		</div>

		 <div class="clearfix"> </div>
		</div>
 <!-- //experience -->
</div>
<!--//more -->	
		

<!-- footer -->
		<div id="fh5co-footer">
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
									<a href="http://sa.whut.edu.cn/zdh2013/" target="_blank" >武汉理工大学自动化学院</a>
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
	
		
	
	
	
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
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
		<script>
		//网页载入完后
	   $(document).ready(function(){
		  
		   
		   //设置图片宽高比例
	    var width=$(".effect-1").width();
	    
	    $(".effect-1").height(width/1.25);
	//    alert($(".effect-1").width());
	 //   alert($(".effect-1").height());
	    
	 //图像出错代替图片
	    $('.img-circle').error(function(){
		    $(this).attr('src',"images/tx.jpg");
		});

	   });
		
		//改变分辨率后设置图片宽高比例
	   $(window).resize(function() {
		   //设置图片宽高比例
		
		    var width=$(".effect-1").width();
		    
		    $(".effect-1").height(width/1.25);
		 });
	   $(function () {
			  
				   //2.点击上一组
	            $(".preLi").on("click",function(){
	            var oldyear=2000;
	            	
	            var li4= $(".li4").attr("data-filter"); //获取第四栏的年份
	            var year=parseInt(li4);
	            if(year<=oldyear+3){  //如果year小于等于oldyear+3，说明此时第一栏已经是最老一届
	            alert("已经是最老一届了！");
	            }else if(year<oldyear+7){ ////如果year小于等于oldyear+7，说明此时上一组的届数已经不足显示四栏，那就从最老一届开始显示
	            	
	            	$(".li1").attr("data-filter",oldyear);
		            $(".li1").text(oldyear+"届");
		            $(".li2").attr("data-filter",oldyear+1);
		            $(".li2").text(oldyear+1+"届");
		            $(".li3").attr("data-filter",oldyear+2);
		            $(".li3").text(oldyear+2+"届");
		            $(".li4").attr("data-filter",oldyear+3);
		            $(".li4").text(oldyear+3+"届");
	            	
	            }else{ //如果year>oldyear+3，说明此时上一组的届数超过4个，足以填满四栏，那递减4个年份
	            $(".li1").attr("data-filter",year-7);
	            $(".li1").text(year-7+"届");
	            $(".li2").attr("data-filter",year-6);
	            $(".li2").text(year-6+"届");
	            $(".li3").attr("data-filter",year-5);
	            $(".li3").text(year-5+"届");
	            $(".li4").attr("data-filter",year-4);
	            $(".li4").text(year-4+"届");
	            }
 
	            });
			  
			   //2.点击下一组
	            $(".nextLi").on("click",function(){
	            	 var mydate = new Date();
	            	   var now= mydate.getFullYear(); //获取今年的年份
	            	//   alert(now);
	            var li4= $(".li4").attr("data-filter");
	            var year=parseInt(li4);
	            if(year>=now){ //如果year大于now，说明此时第四栏已经是最新一届
	            alert("已经是最新一届了！");
	            }
	            
	            else if(year>=now-3){ ////如果year大于等于now-3，说明此时下一组的届数已经不足显示四栏，那就从最新一届开始显示
	            $(".li1").attr("data-filter",now-3);
	            $(".li1").text(now-3+"届");
	            $(".li2").attr("data-filter",now-2);
	            $(".li2").text(now-2+"届");
	            $(".li3").attr("data-filter",now-1);
	            $(".li3").text(now-1+"届");
	            $(".li4").attr("data-filter",now);
	            $(".li4").text(now+"届");
	            }
	            else {  //如果year<now-3，说明此时下一组的届数超过4个，足以填满四栏，那递增4个年份
		            $(".li1").attr("data-filter",year+1);
		            $(".li1").text(year+1+"届");
		            $(".li2").attr("data-filter",year+2);
		            $(".li2").text(year+2+"届");
		            $(".li3").attr("data-filter",year+3);
		            $(".li3").text(year+3+"届");
		            $(".li4").attr("data-filter",year+4);
		            $(".li4").text(year+4+"届");
		            }
 

	           });

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
            //2.点击编辑
            $("#bianji").on("click",function(){
            var jianjie= $(".inisjianjie").text();
            var yanjiu1= $(".yanjiu1").text();
            var yanjiu2= $(".yanjiu2").text();
            var yanjiu3= $(".yanjiu3").text();
            var yanjiu4= $(".yanjiu1").text();
            var yanjiu5= $(".yanjiu5").text();
            

         	
        	//$("input[name='optionsRadios']").val("女"); 
	//		$("select[name='xuewei']").val(xuewei);
	$("textarea[name='jianjie']").val(jianjie);
			$("input[name='yanjiu1']").val(yanjiu1);
			$("input[name='yanjiu2']").val(yanjiu2);
			$("input[name='yanjiu3']").val(yanjiu3);
			$("input[name='yanjiu4']").val(yanjiu4);
			$("input[name='yanjiu5']").val(yanjiu5);
			
         	
         	
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
				
				 $("#xin").trigger("click");
			});
	</script>
<!-- //swipe box js -->
	
	<!-- Main JS -->
	<script src="js/main.js"></script>

		   <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					编辑简介
				</h4>
			</div>
			<div class="modal-body">
				 <form role="form" name="uploadCode" method="post" action="servlet/UploadServlert?flag=6">
				 	    <div class="form-group">
				    <label for="jianjie">实验室简介</label>
				     <textarea class="form-control" rows="6"  name="jianjie" id="jianjie"></textarea>
				  </div>
				  <div class="form-group">
				    <label for="yanjiu1">研究方向1</label>
				    <input type="text" class="form-control" id="yanjiu1" placeholder="请输入研究方向1" name="yanjiu1">
				  </div>
				 
					  <div class="form-group">
				    <label for="yanjiu2">研究方向2</label>
				    <input type="text" class="form-control" id="yanjiu2" placeholder="请输入研究方向2" name="yanjiu2">
				  </div>
					  <div class="form-group">
				    <label for="yanjiu3">研究方向3</label>
				    <input type="text" class="form-control" id="yanjiu3" placeholder="请输入研究方向3" name="yanjiu3">
				  </div>
				    <div class="form-group">
				    <label for="yanjiu4">研究方向4</label>
				    <input type="text" class="form-control" id="yanjiu4" placeholder="请输入研究方向4" name="yanjiu4">
				  </div>
				     <div class="form-group">
				    <label for="yanjiu5">研究方向5</label>
				    <input type="text" class="form-control" id="yanjiu5" placeholder="请输入研究方向5" name="yanjiu5">
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
	

          <script src="js/bootstrapValidator.min.js"></script>
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
                jianjie: {
                //    message: '用户名验证失败',
                    validators: {
                        notEmpty: {
                            message: '简介不能为空'
                        }
                   
                       
                    }
                },
                yanjiu1: {
                    validators: {
                        notEmpty: {
                            message: '研究方向1不能为空'
                        }
                    }
                },
                yanjiu2: {
                    validators: {
                        notEmpty: {
                            message: '研究方向2不能为空'
                        }
                    }
                },
                yanjiu3: {
                    validators: {
                        notEmpty: {
                            message: '研究方向3不能为空'
                        }
                    }
                },
                yanjiu4: {
                    validators: {
                        notEmpty: {
                            message: '研究方向4不能为空'
                        }
                    }
                },
                yanjiu5: {
                    validators: {
                        notEmpty: {
                            message: '研究方向5不能为空'
                        }
                    }
                },
                
                    time: {
                    validators: {
                        notEmpty: {
                            message: '日期不能为空'
                        }
                    }
                },
                   inputfile: {
                    validators: {
                        notEmpty: {
                            message: '文件不能为空'
                        }
                    }
                }
            }
        });
    });
    </script>
	
	
	</body>
</html>





