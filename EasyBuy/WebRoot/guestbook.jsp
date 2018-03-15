<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
<%@include file="left.jsp" %>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			<c:forEach items="${ezList}" var="ezList1" varStatus="ez">
				<li>
					<dl>
						<dt>${ezList1.ecContent }</dt>
						<dd class="author">网友：${ezList1.ecNickName } <span class="timer">${ezList1.ecReplyTime }</span></dd>
						<dd>${ezList1.ecReply}</dd>
					</dl>
				</li>
			</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="EzbCommentViewAction?pageNo=1&pageSize=${pageSize}">首页</a></li>
					<li><a href="EzbCommentViewAction?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a></li>
                    <li><a href="EzbCommentViewAction?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a></li>
					<li><a href="EzbCommentViewAction?pageNo=${countPage}&pageSize=${pageSize}">尾页</a></li>
				</ul>
			</div>
			<div id="reply-box">
				<form id="guestBook" method="post" action="EzbCommentAddAction">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" readonly="readonly" value="${userId }"/></td>
						</tr>						
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
