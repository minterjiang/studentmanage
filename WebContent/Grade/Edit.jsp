<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级编辑</title>
<link href="<%=basePath%>Style/StudentStyle.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>Script/jBox/Skins/Blue/jbox.css"
	rel="stylesheet" type="text/css" />
<link href="<%=basePath%>Style/ks.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath%>Script/jBox/jquery-1.4.2.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>Script/jBox/jquery.jBox-2.3.min.js"
	type="text/javascript"></script>
<script src="<%=basePath%>Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<base href="<%=basePath%>">
<script type="text/javascript">
	function onSave() {	 		
		var chinese = $('input[name="txtChinese"]').val();
		var maths = $('input[name="txtMaths"]').val();
		var english =$('input[name="txtEnglish"]').val();
		
		if (chinese.length <= 0) {
			jBox.tip("请填写语文成绩！");
			return false;
		}
		//一系列的判断
	 
		$("#formEdit").submit();
	}

	//根据班级去加载这个班级的学生
	function SelectStudent(id) {
		if (id <= 0) {
			jBox.tip("请选择班级！");
			return;
		}
		var url ="<%=basePath%>" + "SelectStudent";

		$.ajax({
			type : "GET",
			dataType : 'json',
			data : {
				id : id
			},
			url : url,
			error : function(json) {
				alert(json);
			},
			timeout : 1000,
			success : function(json) {
				$("#sltStudents").find("option").remove();//empty the option
				$("#sltStudents").append('<option value="0">请选择学生</option>');
				if (json != null) {
					var lst = eval(json);
					$.each(lst, function(index, optiondata) {
						$("#sltStudents").append(
								'<option value='+optiondata.id+'>'
										+ optiondata.name + '</option>');
					});
				}
			}
		});
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
					<form id="formEdit" action="GradeEdit" method="post">
						<table border="0" cellspacing="0" cellpadding="0" width="100%">
							<tr>
								<td width="91" align="right">班级名称：</td>
								<td colspan="5"><select name="sltClass" id="sltClass"
									onChange="SelectStudent(this.value)">
										<option value="0">请选择班级</option>
										<c:forEach var="item" items="${userClass}">
											<option value="${item.id}">${item.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td align="right">学生：</td>
								<td colspan="5"><select name="sltStudents" id="sltStudents">
										<option value="0">请选择学生</option>
								</select></td>
							</tr>
							<tr>
								<td align="right">语文成绩：</td>
								<td colspan="5"><input type="text" name="txtChinese"
									value="0" /></td>
							</tr>
							<tr>
								<td align="right">数学成绩：</td>
								<td colspan="5"><input type="text" name="txtMaths"
									value="0" /></td>
							</tr>
							<tr>
								<td align="right">英语成绩：</td>
								<td colspan="5"><input type="text" name="txtEnglish"
									value="0" /></td>
							</tr>
							<tr>
								<td align="right"></td>
								<td colspan="5"><input type="button" class="input2"
									onclick="onSave();" value="确认添加" /> <%
 	if (request.getAttribute("message") != null) {
 		boolean ret = Boolean.parseBoolean(request.getAttribute("message").toString());
 		if (ret) {
 %> <script type="text/javascript">
		jBox.tip('操作成功！', 'loading');
		window.setTimeout(function() {
			location.href = "UserClassManageServlet";
		}, 2000);
	</script> <%
 	} else {
 %> <script type="text/javascript">
		jBox.tip('操作失敗！请检查该学生是否已经添加过成绩！', 'loading');
		window.setTimeout(function() {
			location.href = "UserClassManageServlet";
		}, 2000);
	</script> <%
 	}
 	}
 %></td>
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