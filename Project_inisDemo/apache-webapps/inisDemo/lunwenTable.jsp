<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	 <base href="<%=basePath%>">
	<meta charset="utf-8"> 
	<title>科研成果展示</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">  
	<link rel="stylesheet" href="css/bootstrap.min.css">  
<link rel="stylesheet" href="css/bootstrap-switch.min.css">  
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-switch.min.js"></script>
	 <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	 <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
          <link href="css/bootstrapValidator.min.css" rel="stylesheet" />
          <script src="js/bootstrapValidator.min.js"></script>
  
        	<style>
        	
	.box {
padding:1em 4em;
}
.table-hover > tbody > tr:hover > td,
.table-hover > tbody > tr:hover > th {
  background-color:#ccc;
}
td{
font-size:1.2em;
padding:1em;
}
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th
{
padding:1em;
}
.biaohover:hover{
color:yellow;
}
	</style>
        <script type="text/javascript">
           $(function () {
    	  
       	//1.查询
            $("#Button2").bind("click",function () {
   	var type=$("select[name='type']").val(); //获得文本框中的值
			var keyword=$("input[name='keyword']").val();
			var date1=$("input[name='date1']").val();
			var date2=$("input[name='date2']").val();
		//if(keyword!=""||(date1!=""&&date2!="")){
			$.ajax({
				type:"post",// 指定是post还是get
				data:"type="+type+"&keyword="+keyword+"&date1="+date1+"&date2="+date2,//发送到服务器的数据 
				url:"servlet/QueryServlet?action=query",//发送请求的地址
				dataType:"json",
				error:function(err){//如果确定能正确运行,可不写
					alert("错误");
				},
				success:ajaxSendCallBack
			});
			
		//}
	//	else{
			
	//		alert("请确认查询条件是否正确！！！")
	//	}
			});
			  
  
	  
	 

     	});   
        </script>
          <script>
        $(function () {
          
            $("[name='my-checkbox']").bootstrapSwitch();
          
 				
            
        });
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
                author: {
                    validators: {
                        notEmpty: {
                            message: '作者不能为空'
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
</head>
<body>

 <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">科研成果</h3>
                                    <div class="box-tools">
                                     <form role="form" name="uploadCode" method="post" action="servlet/ShowServlet?flag=3&num=1" accept-charset="UTF-8">
                                        <div class="input-group" >
                 
                                            <input type="text" name="tiaojian" class="form-control  pull-right" style="width: 150px;" placeholder="Search" />
                                            <div class="input-group-btn" >
                                                <button class="btn  btn-default " type="submit"><i class="fa fa-search"></i></button>
                                            </div>
                                            
                                            </form>
                                            <c:if test="${userinfo.role_id != '3' }">   
                                            	<!-- 按钮触发模态框 -->
                                            	<div class="input-group-btn" >
													<a class="btn  btn-default " data-toggle="modal" data-target="#myModal">
														上传
													</a>
												</div>
											</c:if>
                                             
                                        </div>
                                    </div>
                                </div><!-- /.box-header -->
                             
                                
                                <div class="box-body table-responsive no-padding" style="margin-top:1em">
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
                                       <a href= "${str.flieurl}/${str.filename}"  target="_blank" class="biaohover">预览</a>
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
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                        </div>
                    </div>
                    
                   	  <jsp:include page="pagination.jsp">
			<jsp:param value="servlet/ShowServlet?flag=3" name="url"/>
		</jsp:include>
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
				 <form role="form" name="uploadCode" method="post" enctype="multipart/form-data" action="servlet/UploadServlert?flag=4">
				 	    <div class="form-group">
				     <label for="name">选择列表</label>
		<select class="form-control selector" name="leibie">
			<option value="学术论文">学术论文</option>
			<option value="专利发明">专利发明</option>
			
		<option value="项目成果">项目成果</option>
		</select>
		</div>
				  <div class="form-group">
				    <label for="name">题目</label>
				    <input type="text" class="form-control" id="name" placeholder="请输入题目" name="timu">
				  </div>
				  
				   <div class="form-group">
				    <label for="author">作者</label>
				    <input type="text" class="form-control" id="author" placeholder="请输入作者" name="author">
				  </div>
				
				   <div class="form-group">
				    <label for="time">发表日期</label>
				    <input type="date" class="form-control" id="time" placeholder="请输入日期" name="time">
				  </div>
				    <div class="form-group">
				    <label for="gongkai">是否公开</label>
				    <div class="switch switch-large">
					 
    <input type="checkbox" data-color="warning" name="my-checkbox" checked />
					</div>
				  </div>
				  <div class="form-group">
				    <label for="inputfile">文件输入</label>
				    <input type="file" id="inputfile" name="inputfile" accept=".pdf,">
				  
				  </div>
				
				  <button type="submit" class="btn  btn-primary pull-right" style="margin-right:0.5em">提交</button>
				     <div class="clearfix"> </div>
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
	
</body>
</html>
