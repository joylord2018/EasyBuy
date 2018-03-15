<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
<%@include file="ManageHeader.jsp" %>
<div id="main" class="wrap">
<%@include file="ManageLeft.jsp" %>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				
				<c:forEach  items="${pu.list }" var="pro" varStatus="id">
				<c:if test="${pro.epDelete==1}">
				<tr>
					<td class="first w4 c">${id.count }</td>
					<td class="thumb"><img src="images/product/3.jpg" />
					<a href="./product-view.jsp" target="_self">${pro.epName }</a></td>
					<td class="w1 c"><a href="EzbProductGetIdAction?epId=${pro.epId}">修改</a> 
					<a class="manageDel" href="EzbProductDeleteAction?epId=${pro.epId}">删除</a></td>
				</tr>
				</c:if>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
					<li><a href="EzbProductCheckAllAction?pageNo=1">首页</a></li>
                    <li><a href="EzbProductCheckAllAction?pageNo=${pu.ago}">上一页</a></li>
                    <li><a href="EzbProductCheckAllAction?pageNo=${pu.after}">下一页</a></li>
					<li><a href="EzbProductCheckAllAction?pageNo=${pu.maxPage }">末页</a></li>
				</ul>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

