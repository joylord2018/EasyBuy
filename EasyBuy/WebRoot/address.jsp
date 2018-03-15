<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div id="position0" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 结账
</div>
<div id="main" class="wrap">
<%@include file="left.jsp" %>
</div>
<div id="news" class="right-main">
		<h1>&nbsp;</h1>
		<div class="content">
            <form action="EzbOrderAddAction" method="post">
                收货地址:<input name="addr" id="addr" type="button"  value="添加新地址" />
                <span id="span"></span> <br />
                <c:forEach items="${ad }" var="address" varStatus="user">
                	<input name="address" type="radio" id="address0" checked="checked" value="${address }"/><span>${address }</span><br />
                </c:forEach>
                <div class="button">  <input type="submit" value="结账" />    </div>
            </form>
		</div>
	</div>
<div class="clear"></div>
<div id="position1" class="wrap"></div>
<div class="wrap">
	<div id="shopping"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>

</html>
