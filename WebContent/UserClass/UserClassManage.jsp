<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=basePath%>/Style/StudentStyle.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/Script/jBox/Skins/Blue/jbox.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/Style/ks.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>/Script/jBox/jquery-1.4.2.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<base href="<%=basePath%>">
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<div class="page">
		<div class="box mtop">
			<div class="leftbox">
				<%@ include file="../Left.jsp"%>
			</div>
			<div class="rightbox">
				<div class="cztable">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tbody>
							<tr style="height: 25px" align="center">
								<th scope="col">编号</th>
								<th scope="col">班级名称</th>
								<th scope="col">班主任</th>
								<th scope="col">联系方式</th>
								<th scope="col">创建时间</th>
								<th scope="col">操作</th>
							</tr>
							<c:forEach items="${oList}" var="o" varStatus="vs">
								<tr align="center">
									<td>${o.id }</td>
									<td>${o.name}</td>
									<td>${o.teacher}</td>
									<td>${o.phone}</td>
									<td>${o.createtime}</td>
									<td><a href="#">删除</a>&nbsp;<a href="#">编辑</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@ include file="../Footer.jsp"%>
	</div>
</body>
</html>