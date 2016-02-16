<%@ page language="java" pageEncoding="utf-8"%>
<%@ page language="java" import="studentmanage.models.*"	%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<div class="banner">
	<div class="bgh">
		<div class="page">
			<div id="logo">
				<img src="Images/Student/logo.gif"
					alt="" width="165" height="48" />				
			</div>
			<div class="topxx">
				<%
					if (session.getAttribute("user") != null) {
						StudentInfo info = (StudentInfo) session.getAttribute("user");
						if (info != null && info.getId() > 0) {
							out.write(info.getName());
						} else {
							response.sendRedirect("Login.jsp");
						}
					}
				%>
				欢迎您！ <a href="MyInfo/Index.aspx.html">我的信息</a> <a
					href="User/Account/ChangePasswd.aspx.html">密码修改</a> <a
					onclick="loginOut()" href="javascript:">安全退出</a>
			</div>
			<div class="blog_nav">
				<ul>
					<li><a href="Index.aspx.html">我的信息</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>