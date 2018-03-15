<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
</head>

<body>
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
	</div>
</body>
</html>
