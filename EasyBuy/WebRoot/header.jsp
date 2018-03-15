<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("[name='fye']").click(function(){
			var epcId=$(this).attr("value");
			var str="";
			$.getJSON("EzbProductCategoryClick",{"epcId":epcId},function(res){
				$(res).each(function(){
					str+="<li class='first' ><a href='EzbProductListAction?epcId="+this.epcId+"'>"+this.epcName+"</a></li>";
				});
				$("#sye").html(str);
			});
		});
	}); 
</script>
</head>

<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">

	<c:choose>
		<c:when test="${not empty sc}">	<a href="shopping.jsp" id="shoppingBag" class="shopping">购物车 ${sc.sumcount}件</a></c:when>	
		<c:otherwise><a href="EzbShopCarAddAction?zzz=zzz" id="shoppingBag" class="shopping">购物车0件</a></c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${not empty userName}">
			您好,&nbsp${userName }
		</c:when>
		<c:otherwise>	
			<a href="login.jsp">登录</a>
		</c:otherwise>
	</c:choose>

		<c:choose>
				<c:when test="${not empty eu}">
			<a class="button" id="logout" href="javascript:;">注销</a>
			<a href="guestbook.jsp">留言</a>
		</c:when>
		<c:otherwise>
			<a href="register.jsp">注册</a>
		</c:otherwise>
		</c:choose>
			<a href="game.jsp">赢折扣小游戏</a>

	<c:if test="${admin==2 }">
		<a href="manage/index.jsp">后台管理</a>
	</c:if></div>
    <div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="indexAction">首页</a></li>
			<c:forEach var="parent" items="${map }" varStatus="epc">
				<li><a href="javascript:;" name="fye" value="${parent.key.epcId }">${parent.key.epcName }</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix" id="sye">
			<c:forEach var="parent" items="${map }" varStatus="epc">
				<c:forEach items="${parent.value }" var="epcli">
					<li class="first" ><a href="#">${epcli.epcName }</a></li>
				</c:forEach>
			</c:forEach>
		</ul>
	</div>
</div>
</body>
</html>
