<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href=" <%=basePath%>"/> 
<title></title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="upweb/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="upweb/images/login.js"></script>
<link href="upweb/css/login2.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>INIS实验室</h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch"   id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;快速登录</a>
			
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 270px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
				<form action="SystemServlet?flag=1" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
               <input type="hidden" name="to" value="log"/>
              
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="username" class="inputstyle" style="width: 210px; "/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="passwd" class="inputstyle" style="width: 210px; "/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
                
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

</div>

       <div class="go-regist">
			 <span style="font-size:18px;color:#BBB">还没有账号？请 </span>
			<a href="upweb/reg.jsp"><span style="font-size:18px ; color:#EEE" >立即注册</span></a>
			</div>
<div class="jianyi">*推荐使用360、chrome使用本网站，IE浏览器会出错</div>
</body></html>