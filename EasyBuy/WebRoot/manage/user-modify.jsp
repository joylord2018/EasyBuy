<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="/EasyBuy/scripts/My97DatePicker/WdatePicker.js"></script></head>
<body>
<%@include file="ManageHeader.jsp" %>
<div id="main" class="wrap">
<%@include file="ManageLeft.jsp" %>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form action="EzbUserUpdateAction" method="post">
				<table class="form">
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input type="text" class="text" name="userName" value="${euser.euUserId }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">真实姓名(*)：</td>
						<td><input type="text" class="text" name="name" value="${euser.euUserName}" /></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input type="text" class="text" name="passWord" value="${euser.euPassword }" /></td>
					</tr>
                    <tr>
						<td class="field">确认密码(*)：</td>
						<td><input type="text" class="text" name="passWord" value="${euser.euPassword }" /></td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						
						<td><c:choose>
						<c:when test="${euser.euPassword==T}">
						<input type="radio" name="sex" value="T" checked="checked" />男 
						<input type="radio" name="sex" value="F" />女
						</c:when>
						<c:otherwise>
						<input type="radio" name="sex" value="T" />男 
						<input type="radio" name="sex" value="F" checked="checked" />女
						</c:otherwise>
						</c:choose></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<input type="text" onfocus="WdatePicker()" readOnly="readonly" name="birthday" value="${euser.euBirthday }"/>
						</td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>
						<td><input type="text" class="text" name="mobile" value="${euser.euMobile}" /></td>
					</tr>
					<tr>
						<td class="field">地址(*)：</td>
						<td><input type="text" class="text" name="address" value="${euser.euAddress }" /></td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

