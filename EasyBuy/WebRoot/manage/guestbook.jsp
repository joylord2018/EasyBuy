<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
$(function(){
			$(".del").click(function(){
			//获取a标签中的value属性的值
				var id=$(this).attr("value");
				var t = $(this);
				$.post("EzbCommentDeleteAction?ecId="+id,function(msg){
					alert(msg);
					t.parents("tr").remove();
				});
			});
		});
	</script>
</head>

<body>
<%@include file="ManageHeader.jsp" %>
<div id="main" class="wrap">
<%@include file="ManageLeft.jsp" %>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="comments" items="${commentLi}" varStatus="id">
     			<tr>
					<td class="first w4 c">${id.count}</td>
					<td class="w1 c">${comments.ecNickName}</td>
					<td>${comments.ecContent}</td>
					<td class="w1 c">
					<c:choose>
					<c:when test="${comments.ecReply==null}">
						未回复
					</c:when>
					<c:otherwise>
						已回复
					</c:otherwise>
					</c:choose>
					</td>
					<td class="w1 c"><a href="EzbCommentGetIdAction?ecId=${comments.ecId}">修改</a> <a class="del" value="${comments.ecId}" href="javascript:">删除</a></td>
				</tr>
    			</c:forEach>
				
				
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="EzbCommentCheckAllAction?pageNo=1&pageSize=${pageSize}">首页</a></li>
					<li><a href="EzbCommentCheckAllAction?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a></li>
                    <li><a href="EzbCommentCheckAllAction?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a></li>
					<li><a href="EzbCommentCheckAllAction?pageNo=${countPage}&pageSize=${pageSize}">尾页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
