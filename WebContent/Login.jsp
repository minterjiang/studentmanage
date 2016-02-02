<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>名特学生信息管理系统</title>
<link href="<%=basePath %>/Style/StudentStyle.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/Script/jBox/Skins/Blue/jbox.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath %>/Style/ks.css" rel="stylesheet" type="text/css" />
<script src="<%=basePath %>/Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>/Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
<script src="<%=basePath %>/Script/jBox/i18n/jquery.jBox-zh-CN.js"
	type="text/javascript"></script>
<script src="<%=basePath %>/Script/Common.js" type="text/javascript"></script>
<script src="<%=basePath %>/Script/Data.js" type="text/javascript"></script>
<base href="<%=basePath%>">
<style type="text/css">
<!--
* {
	margin: 0;
	padding: 0;
	word-break: break-all;
	word-wrap: break-word;
	font-family: "Microsoft Yahei", Verdana, Arial, Helvetica, sans-serif;
}

body {
	font-size: 13px;
	line-height: 22px;
	color: #333;
}

.banner {
	background: url(images/login/bg.jpg) repeat-x;
	height: 106px;
	margin-top: 50px;
}

.width {
	width: 960px;
	margin: 0 auto;
	height: 100px;
}

.dl_logo {
	margin: 15px 30px 0 0;
}

.denglubox {
	width: 332px;
	margin: 8px auto 0;
}

.lbt {
	background: url(images/login/loginbt.jpg) no-repeat;
	height: 33px;
	width: 85px;
	cursor: pointer;
	border: none;
}

.input_out {
	border: 1px #d7d7d7 solid;
	line-height: 30px;
	height: 30px;
	padding: 5px 10px;
	width: 260px;
	font-size: 18px;
	color: #bbb;
	background: url(images/login/zh.jpg) no-repeat 0 0;
	padding-left: 50px;
}

.input_on {
	border: 2px #4890cf solid;
	line-height: 30px;
	height: 30px;
	padding: 4px 9px;
	width: 260px;
	font-size: 18px;
	background: url(images/login/zh.jpg) no-repeat -1px -1px;
	padding-left: 50px;
}

.input_out2 {
	border: 1px #d7d7d7 solid;
	line-height: 30px;
	height: 30px;
	padding: 5px 10px;
	width: 260px;
	font-size: 18px;
	color: #bbb;
	background: url(images/login/mm.jpg) no-repeat 0 0;
	padding-left: 50px;
}

.input_on2 {
	border: 2px #4890cf solid;
	line-height: 30px;
	height: 30px;
	padding: 4px 9px;
	width: 260px;
	font-size: 18px;
	background: url(images/login/mm.jpg) no-repeat -1px -1px;
	padding-left: 50px;
}

.crm {
	margin-top: 15px;
	overflow: hidden;
}

.footer {
	border-top: 1px #ddd solid;
	margin-top: 100px;
	line-height: 40px;
	text-align: center;
}
-->
</style>
</head>
<body>
<div class="banner">
		<div class="width">
			<img src="<%=basePath%>Images/login/logo.jpg" class="dl_logo" /><img
				src="<%=basePath%>Images/login/title.jpg" width="326" height="35"
				style="margin-top: 30px;" />
		</div>
	</div>
	<div style="text-align: center;">
		<img src="<%=basePath%>Images/login/school.jpg" />
	</div>
	<div class="denglubox">
		<img src="<%=basePath%>Images/login/txt1.jpg" width="148" height="15" />
		<div class="crm">
			<input name="loginName" type="text" class="input_out" id="loginName"
				onfocus="this.className='input_on'"
				onblur="this.className='input_out'" />

		</div>
		<div class="crm">
			<input name="loginPwd" type="password" class="input_out2"
				id="loginPwd" onfocus="this.className='input_on2'"
				onblur="this.className='input_out2'" />

		</div>
		<div class="crm">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="74%"><input type="checkbox" name="checkbox"
						id="checkbox" /> ��ס����&nbsp; &nbsp; <!--�������� --></td>
					<td width="26%"><input type="submit" name="button" id="button"
						value=" " class="lbt" onclick="loginClick()" /></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="width" style="text-align: center; margin-top: 50px;">
		<img src="<%=basePath%>Images/Login/mokuai.jpg" />
	</div>
	 <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>