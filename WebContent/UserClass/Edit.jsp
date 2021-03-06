<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级编辑</title>
<link href="<%=basePath %>/Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath %>/Style/ks.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>/Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>/Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath %>/Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<base href="<%=basePath%>">
<script type="text/javascript">
	function onSave() {
		var name = $('input[name="txtName"]').val();
		var teacher = $('input[name="txtTeacher"]').val();

		if (name.length <= 0) {
			jBox.tip("请填写班级名称！");
			return false;
		}
		if (teacher.length <= 0) {
			jBox.tip("请填写班级名称！");
			return false;
		}
		
		$("#formEditClass").submit();
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
					<form id="formEditClass" action="EditUserClass?editId=${info.id}" method="post">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="91" align="right">班级名称：</td>
								<td colspan="5"><input type="text" name="txtName" value="${info.name}" /></td>
							</tr>
							<tr>
								<td align="right">班主任：</td>
								<td colspan="5"><input type="text" name="txtTeacher" value="${info.teacher}" /></td>
							</tr>
							<tr>
								<td align="right">联系方式：</td>
								<td colspan="5"><input type="text" name="txtPhone"  value="${info.phone}"/></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td colspan="5"><input type="button" class="input2"
									onclick="onSave();" value="确认添加" />
									<% if(request.getAttribute("message")!=null){
										boolean ret= Boolean.parseBoolean(request.getAttribute("message").toString());
										if(ret)
										{%>
											 <script type="text/javascript">jBox.tip('操作成功！','loading');
											 window.setTimeout(function () { location.href="UserClassManageServlet"; }, 2000);											 
											 </script>
										<%}
										else
										{%>											
											<script type="text/javascript">jBox.tip('操作失敗！','loading');
											window.setTimeout(function () { location.href="UserClassManageServlet"; }, 2000);
											</script>
										<%}
									} %>
									</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<%@ include file="../Footer.jsp"%>
	</div>
</body>
</html>