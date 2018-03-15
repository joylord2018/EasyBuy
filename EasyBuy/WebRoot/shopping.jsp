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
<script type="text/javascript">
	function changeNum(id,op){
			var num=$("#pro"+id+"").val();
			if(op==1){
				num++;
			}else if(op==-1){
				if(num<1){
				return;
				}
				num--;
			}
			var reg=/^[1-9]*[1-9][0-9]*$/;
			var fa=reg.test(num);
			if(fa){
			window.location.href="EzbShopCarUpdateAction?epId="+id+"&num="+num;
			}else{
				alert("请输入正整数");
			}
		}
</script>
</head>

<body>
<%@include file="header.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="EzbAdressShowAction" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品单价</th>
					<th>购买数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				
			<c:forEach items="${sc.lines}" var="line" varStatus="scli">
				<tr id="product_id_0">
					<td class="thumb"><img src="images/product/0.jpg" /><a href="product-view.jsp">${line.product.epName }</a></td>
					<td class="price" id="price_id_0">
						<span>${line.product.epPrice }</span>
						<input type="hidden" value="99" />
					</td>
					
					<td class="number">
                        <span name="del" onclick="changeNum(${line.product.epId },-1)">-</span>
                        <input id="pro${line.product.epId }" type="text" name="number" value="${line.amount }" onblur="changeNum(${line.product.epId });" />
                        <c:choose>
                        	<c:when test="${line.product.epcStock>line.amount}">
                        		 <span name="add" onclick="changeNum(${line.product.epId },1)">+</span>
                        	</c:when>
                        	<c:otherwise>
                        		<h3>库存不足</h3>
                        	</c:otherwise>
                        </c:choose>
					</td>
					<td class="price" id="price_id_0">
						<span>${line.subtotal }</span>
						<input type="hidden" value="99" />
					</td>
					<td class="delete"><a href="EzbShopCarDeleteAction?epId=${line.product.epId }">删除</a></td>
				</tr>
			</c:forEach>
         	<a href="EzbShopCarClearAction">清空购物车</a>
			</table>
            <div class="total">
            	<c:choose>
            		<c:when test="${empty discount }">
						<span id="total">总计：￥${sc.total }</span>
            		</c:when>
            		<c:otherwise>
            			<span id="total">您有一张优惠券，已为您打完折扣 总计：￥${sc.total*0.8 }</span>	
            		</c:otherwise>
            	</c:choose>
           		
            </div>
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
