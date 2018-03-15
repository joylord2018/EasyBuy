<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
function add(){
	 var epId=$("#pro1").attr("value");
	$.get("EzbShopCarAddAction",{"epId":epId},function(res){
		if(res>0){
			alert("添加成功");
			window.location.reload();
		}
	});
}
</script>
</head>

<body>
<%@include file="header.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
<%@include file="left.jsp" %>
	<div id="product" class="main">
		<h1>${pro.epName }</h1>
		<div class="infos">
			<div class="thumb"><img src="images/product/3.jpg" width="110" height="106" /></div>
			<div class="buy">
				商城价：<span class="price">￥${pro.epPrice}</span><br />
				库　存:${pro.epcStock }
			  <div class="button"><input type="button" name="button" value="" onclick="location.href = 'EzbAdressShowAction'" /><a href="javascript:add();" value="${pro.epId}" id="pro1">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${pro.epDescription }<br />
				......<br />
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
