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

<script type="text/javascript" src="upweb/images/login.js"></script>
<link href="upweb/css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	    	function showTime(){
		var date = new Date();
		var seperator1 = "/";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + date.getHours() + seperator2 + date.getMinutes()
	            + seperator2 + date.getSeconds();
	    
	    document.getElementById("first").innerHTML = currentdate;
		//document.getElementById("first").innerHTML = date.toLocaleDateString()+"一"+date.toLocaleTimeString();
		//document.getElementById("first").innerHTML = date.toLocaleDateString();
		setTimeout("showTime()",1000);
		
	}
	    	function checkuse(){
	    		   //在每个函数中定义check变量是为了在表单提交后，能够逐个验证每个函数是否通过，很好很好。（以下同理）
	    		   var check; 
	    		   var username = document.getElementById("username").value; 
	    		   if (username.length > 16 || username.length < 2) { 
	    		    alert("用户名输入不合法，请重新输入！");
	    		    //此处甚妙，既然你在此处输入错误，那么按理说当然要在此处继续输入了。（在此处继续获取焦点！）
	    		    document.getElementById("username").focus();
	    		    check = false; 
	    		   } else { 
	    		    document.getElementById("checktext1").innerHTML = "* 用户名由2-16位字符组成 √"; 
	    		    check = true; 
	    		   } 
	    		   return check; 
	    		  }
	    	function checkpwdc() { 
	    		  var check; 
	    		  var password = document.getElementById("passwd").value; 
	    		  var pwdc = document.getElementById("passwd2").value; 
	    		  if (password != pwdc) { 
	    		   alert("两次输入密码不一致，请重新输入！");
	    		   document.getElementById("pwdc").focus();
	    		   check = false; 
	    		  } else { 
	    		   document.getElementById("checktext3").innerHTML = "* 请再次输入你的密码 √"; 
	    		   check = true; 
	    		  } 
	    		  return check; 
	    		 }
	    	function checkemail(){
	    		  var check; 
	    		  //电子邮件的正则表达式
	    		  var e1 = document.getElementById("email").value.indexOf("@",0);
	    		  var e2 = document.getElementById("email").value.indexOf(".",0);
	    		  if(email == "" || (e1==-1 || e2==-1) || e2<e1 )
	    		  {
	    		   alert("E_mail输入错误!");
	    		   document.getElementById("email").focus();
	    		   check = false;
	    		  } else { 
	    		   document.getElementById("checktext8").innerHTML = "* 请填写常用的EMAIL，将用于密码找回 √"; 
	    		   check = true; 
	    		  } 
	    		  return check; 
	    		 } 
	    	function check() { 
	    		  var check = checkuse() && checkpwd() && checkpwdc() && checkut() && checkGender() && checkDate() && checkHobby()
	    		   && checkemail() &&checkintro(); 
	    		 
	    		  return check; 
	    		  
	    		 } 



	    	/* function reg(form){
	        	if(form.username.value == ""){
	        		alert("用户不能为空！");
	        		return false;
	        	}
	        	if(form.passwd.value == ""){
	        		alert("密码不能为空！");
	        		return false;
	        	}
	        	if(form.repasswd.value == ""){
	        		alert("确认密码不能为空！");
	        		return false;
	        	}
	        	if(form.passwd.value != form.repasswd.value){
	        		alert("两次密码输入不一致！");
	        		return false;
	        	}
	        	if(form.email.value == ""){
	        		alert("电子邮箱不能为空！");
	        		return false;
	        	}
	    	} */
	    	
	    </script>
</head>
<body>
<h1>INIS实验室</h1>
<div class="login" style="margin-top:50px;">
 <div class="qlogin" id="qlogin" >
   
    <div class="web_login"><form name="form2" id="regUser" accept-charset="utf-8"  action="SystemServlet?flag=0" method="post" onsubmit="return check()";>
	      
		      		       
        <ul class="reg_form" id="reg-ul">
        		<br/>
                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="username" name="username" maxlength="18" class="inputstyle2" onchange=" checkuse()" />
                        <span id="checktext1" style="color:Red;font-size：25px">* 用户名由2-16位字符组成</span>
                        
                    </div>
                    
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passwd" maxlength="16" class="inputstyle2"/>
                        <span id="checktext3 " style="color:Red;font-size：25px">* 请输入你的密码</span>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="repasswd" maxlength="16" class="inputstyle2" onchange="checkpwdc()"  />
                        <span id="checktext3" style="color:Red;font-size：25px">* 请再次输入你的密码</span>
                        
                    </div>
                    
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="qq" name="email" maxlength="20" class="inputstyle2"onchange="checkemail()"/>
                        <span id="checktext8" style="color:Red;font-size：25px">* 请填写常用的EMAIL</span>
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg"  style="margin-top:10px;margin-left:140px;" class="button_blue" value="注册"/>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           
    
    </div>
   
    
    </div>
    <!--注册end-->
</div>
</div>
 <div class="go-regist">
			 <span style="font-size:18px; color:#BBB">已有账号？请 </span>
			<a href="upweb/index.jsp"><span style="font-size:18px ; color:#EEE" >返回登录</span></a>
</div>
<div class="jianyi">*推荐使用360、chrome使用本网站，IE浏览器会出错</div>
</body></html>