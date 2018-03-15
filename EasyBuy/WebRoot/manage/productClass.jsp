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
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
			<c:forEach items="${map}" var="parent" varStatus="pid">
				<tr>
					<td class="first w4 c">${pid.count}</td>
					<td>${parent.key.epcName }</td>
					<td class="w1 c"><a href="EzbProductCategoryGetIdAction?epcId=${parent.key.epcId }">修改</a> <a class="manageDel" href="javascript:void(0)">删除</a></td>
				</tr>
					<c:forEach items="${parent.value}" var="child">
						<tr>
						<td class="first w4 c"></td>
						<td class="childClass">${child.epcName }</td>
						<td class="w1 c"><a href="EzbProductCategoryGetIdAction?epcId=${child.epcId}">修改</a> <a class="manageDel" href="EzbProductCategoryDelAction?epcId=${child.epcId}">删除</a></td>
						</tr>
					</c:forEach>
			</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
					<li><a href="EzbProductCategoryCheckAllAction?pageNo=1&pageSize=${pageSize}">首页</a></li>
                    <li><a href="EzbProductCategoryCheckAllAction?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a></li>
                    <li><a href="EzbProductCategoryCheckAllAction?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a></li>
					<li><a href="EzbProductCategoryCheckAllAction?pageNo=${countPage}&pageSize=${pageSize}">末页</a></li>
				</ul>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

