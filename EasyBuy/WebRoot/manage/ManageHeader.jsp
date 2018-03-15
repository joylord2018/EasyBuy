<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="manage/index.jsp">首页</a></li>
			<li><a href="EzbUserCheckAllAction">用户</a></li>
			<li class="current"><a href="EzbProductCheckAllAction">商品</a></li>
			<li><a href="EzbOrderCheckAllAction">订单</a></li>
			<li><a href="EzbCommentCheckAllAction">留言</a></li>
			<li><a href="EzbNewsAction">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员&nbsp&nbsp${userName}&nbsp&nbsp您好，今天是${time }，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
  </body>
</html>
