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
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>

<body>
<div id="welcomeImage">
    <img width="100%" height="150" src="images/banner.jpg" alt="welcome"/>
</div>
<%@include file="header.jsp" %>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${map }" var="parent" varStatus="pid">
					<dt>${parent.key.epcName }</dt>				
						<c:forEach items="${parent.value}" var="child">
							<dd><a href="EzbProductListAction?epcId=${child.epcId }">${child.epcName }</a></dd>
						</c:forEach>
				</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
		<c:forEach items="${lipro }" var="pro" varStatus="p">
			<dl class="clearfix">
				<dt><img src="images/product/3.jpg" width="50"/></dt>
				<dd><a href="EzbProductViewAction?epId=${pro.epId }"  target="_self">${pro.epName }</a><a href="product-view.jsp"></a></dd>
		  	</dl>
		  </c:forEach>
	  </div>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">			
			<c:forEach items="${pu.list}" var="pulist" varStatus="nl">
				<li>
					<dl>
						<dt><a href="EzbProductViewAction?epId=${pulist.epId }"  target="_self"><img src="images/product/3.jpg" /></a></dt>
						<dd class="title"><a href="product-view.jsp" target="_self">${pulist.epName }</a></dd>
						<dd class="price">￥${pulist.epPrice }</dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul> 
					<c:forEach items="${ezlist}" var="ezlist" varStatus="nl">
						<li><a href="EzbNewsViewAction?enId=${ezlist.enId }">${ezlist.enTitle }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
