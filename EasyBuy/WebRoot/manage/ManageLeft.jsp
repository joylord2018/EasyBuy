<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="EzbUserCheckAllAction">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="EzbProductCategoryCheckByPidAction">新增</a></em><a href="EzbProductCategoryCheckAllAction">分类管理</a></dd>
				<dd><em><a href="manage/product-add.jsp">新增</a></em><a href="EzbProductCheckAllAction">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="EzbOrderCheckAllAction">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="EzbCommentCheckAllAction">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="manage/news-add.jsp">新增</a></em><a href="EzbNewsAction">新闻管理</a></dd>
			</dl>
		</div>
	</div>
  </body>
</html>
