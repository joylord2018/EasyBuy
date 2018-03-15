<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript" src="scripts/function.js">
	$(function(){
		$("#select").change(function(){
			var eoId=$(this).next().val();
			var eoStatus=$(this).val();
			var url="EzbOrderUpdateAction?eoId="+eoId+"&eoStatus="+eoStatus;
			$.post(url,function(msg){
				if(msg>0){
					alert("错误");
				}
			});	
		});
	});
</script>
</head>
<body>
<%@include file="ManageHeader.jsp" %>
<div id="main" class="wrap">
<%@include file="ManageLeft.jsp" %>
<div class="main">
		<h2>订单管理</h2>
<div class="manage">
			<div class="search">				
			</div>
			<div class="spacer"></div>
            <form id="orderForm" method="post"  action="EzbOrderFindAction">
                 订单号：<input type="text" class="text" name="entityId" id="entityId" />
                 订货人：<input type="text" class="text" name="userName" />
                 <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
			<table class="list">
			<c:forEach items="${map }" var="eo" varStatus="id">
				<tr>
						<th colspan="2">单号：${eo.key.eoId }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间：<span class="time">${eo.key.eoCreateTime}</span></th>					
									<th colspan="2">状态:<select name="status" id="select">	
									<c:forEach items="${li}" var="str" varStatus="num">
										<c:choose>
											<c:when test="${eo.key.eoStatus eq (num.index +1)}">
												<option value="${num.index+1 }" selected="selected">${str}</option>
											</c:when>
											<c:otherwise>
												<option value="${num.index+1 }">${str}</option>
											</c:otherwise>
										</c:choose>		
									</c:forEach>									
							</select>
							<input type="hidden" value="${eo.key.eoId }"/>	
							</th>
						<td class="w1 c" rowspan="2">总计：${eo.key.eoCost }</td>
						</tr>
						<c:forEach items="${eo.value}" var="eod" varStatus="num">
						<tr>
							<td class="first w4 c"><img src="images/product/9.jpg" />${eod.epName }</td>
							<td >${eod.epPrice }</td>
							<td>${eod.eodQuantity}</td>		
						</tr>
					</c:forEach>			
			</c:forEach>			
			</table>
		<div class="pager">
				<ul class="clearfix">
					<li><a href="EzbOrderCheckAllAction?pageNo=1&pageSize=${pageSize}">首页</a></li>
					<li><a href="EzbOrderCheckAllAction?pageNo=${pageNo-1}&pageSize=${pageSize}">上一页</a></li>
                    <li><a href="EzbOrderCheckAllAction?pageNo=${pageNo+1}&pageSize=${pageSize}">下一页</a></li>
					<li><a href="EzbOrderCheckAllAction?pageNo=${countPage}&pageSize=${pageSize}">尾页</a></li>
				</ul>
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
