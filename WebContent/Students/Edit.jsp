<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="studentmanage.models.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级编辑</title>
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
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
%>
<script type="text/javascript">
	function onSave() {
		var account = $('input[name="txtAccount"]').val();
		var passWord = $('input[name="txtPassWord"]').val();
		var passWord2 = $('input[name="txtPassWord2"]').val();
		var name = $('input[name="txtName"]').val();
		if (account.length <= 0) {
			jBox.tip("请填写学生账号！");
			return false;
		}
		if (name.length <= 0) {
			jBox.tip("请填写学生姓名！");
			return false;
		}

		if (passWord != undefined && passWord.length <= 0) {
			jBox.tip("密码必填！");
			return false;
		}

		if (passWord2 != undefined && passWord2.length <= 0) {
			jBox.tip("请确认密码！");
			return false;
		}

		if (passWord != passWord2) {
			jBox.tip("两次密码输入不相同！");
			return false;
		}

		$("#formEdit").submit();
	}
</script>
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
					<form id="formEdit" action="EditClass?editId=${info.id}"
						method="post">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="91" align="right">账号：</td>
								<td colspan="5"><input type="text" name="txtAccount"
									value="${info.account}" /></td>
							</tr>
							<c:if test="${ info==null||info.id<=0}">
								<tr>
									<td align="right">密码：</td>
									<td colspan="5"><input type="password" name="txtPassWord"
										value="${info.password}" /></td>
								</tr>
								<tr>
									<td align="right">确认密码：</td>
									<td colspan="5"><input type="password" name="txtPassWord2"
										value="${info.password}" /></td>
								</tr>
							</c:if>
							<tr>
								<td align="right">学生姓名：</td>
								<td colspan="5"><input type="text" name="txtName"
									value="${info.name}" /></td>
							</tr>
							<tr>
								<td align="right">班级：</td>
								<td colspan="5"><select id="sltClassId" name="sltClassId">
										<c:forEach var="item" items="${userClass}">
											<option value="${item.id}"
												<c:if test="${item.id ==info.id }" var="name1"></c:if>><c:out
													value="${item.name}"></c:out>
											</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td colspan="5"><input type="button" class="input2"
									onclick="onSave();" value="确认添加" /></td>
							</tr>
						</table>
						<%
							if (request.getAttribute("message") != null) {
								boolean ret = Boolean.parseBoolean(request.getAttribute("message").toString());
								if (ret) {
						%>
						<script type="text/javascript">
							jBox.tip('操作成功！', 'loading');
							window.setTimeout(function() {
								location.href = "StudentManage";
							}, 2000);
						</script>
						<%
							} else {
						%>
						<script type="text/javascript">
							jBox.tip('操作失敗！', 'loading');
							window.setTimeout(function() {
								location.href = "StudentManage";
							}, 2000);
						</script>
						<%
							}
							}
						%>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="../Footer.jsp"%>
	</div>
</body>
</html>