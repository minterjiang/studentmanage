<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="studentmanage.models.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>名特学生信息管理系统</title>
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
<script src="<%=basePath%>/Script/Common.js" type="text/javascript"></script>
<script src="<%=basePath%>/Script/Data.js" type="text/javascript"></script>
<base href="<%=basePath%>">
<script type="text/javascript">
	$().ready(function() {
		setStudMsgHeadTabCheck();
		showUnreadSysMsgCount();
	});

	//我的信息头部选项卡
	function setStudMsgHeadTabCheck() {
		var currentUrl = window.location.href;
		currentUrl = currentUrl.toLowerCase();
		var asmhm = "";
		$("#ulStudMsgHeadTab li").each(function() {
			asmhm = $(this).find('a').attr("href").toLowerCase();
			if (currentUrl.indexOf(asmhm) > 0) {
				$(this).find('a').attr("class", "tab1");
				return;
			}
		});
	}

	//显示未读系统信息
	function showUnreadSysMsgCount() {
		var unreadSysMsgCount = "0";
		if (Number(unreadSysMsgCount) > 0) {
			$("#unreadSysMsgCount").html("(" + unreadSysMsgCount + ")");
		}
	}

	//退出
	function loginOut() {
		if (confirm("确定退出吗？")) {
			StudentLogin.loginOut(function(data) {
				if (data == "true") {
					window.location = "/Login.aspx";
				} else {
					jBox.alert("退出失败！", "提示", new {
						buttons : {
							"确定" : true
						}
					});
				}
			});
		}
	}
	//更改报考类别
	function changeCateory(thisObj, id) {
		var oldCateoryId = $("#cateoryId").val();
		var cateoryId = "";
		if (id != null) {
			cateoryId = id;
		} else {
			cateoryId = thisObj.val();
		}
		var studentId = $("#studentId").val();
		if (cateoryId.length <= 0) {
			jBox.tip("报考类别不能为空！");
			if (id == null) {
				thisObj.val(oldCateoryId);
			}
		} else {
			studentInfo.changeStudentCateory(cateoryId, function(data) {
				var result = $.parseJSON(data);
				if ((String(result.ok) == "true")) {
					window.location.href = "/Index.aspx";
				} else {
					jBox.tip(result.message);
				}
			});
		}
	}
</script>

<script src="<%=basePath%>Script/changeOption.js" type="text/javascript"></script>
<script src="<%=basePath%>Script/rl.js" type="text/javascript"></script>

</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="page">
		<div class="box mtop">
			<div class="leftbox">
				<%@ include file="Left.jsp"%>
			</div>
			<div class="rightbox">
				<%
					StudentInfo info = new StudentInfo();
					if (session.getAttribute("user") != null) {
						info = (StudentInfo) session.getAttribute("user");						 
					}
					else
					{
						response.sendRedirect("Login.jsp");
					}
				%>
				<h2 class="mbx">我的学习中心&nbsp;&nbsp;&nbsp;&nbsp;</h2>

				<div class="dhbg">
					<%-- <div class="dh1" style="margin: 0 27px 15px 0;">
						<div class="dhwz">
							<p>
							
								您语文成绩 <span class="red"><%= info.getChinese() %></span>分
							</p>
							<p>
								您数学成绩 <span class="red"><%= info.getMaths() %></span>分
							</p>
							<p>
								您英语成绩 <span class="red"><%= info.getEnglish() %></span>分
							</p>
						</div>
					</div>
					<div class="dh2">
						<div class="dhwz">
							<p>
								你有 <span class="red">0</span> 门课程要考 <a
									href="EducationCenter/Application.aspx.html" class="red">查看报考计划</a>
							</p>
							<p>
								你已经通过 <span class="red">0 </span>门课程&nbsp;共有 <span class="red">13</span>
								门 <a href="EducationCenter/Score.aspx.html" class="red">查看成绩</a>
							</p>
							<p>
								已经发放了 <span class="red">0 </span>本书籍 <a
									href="EducationCenter/Book.aspx.html" class="red">查看书籍情况</a>
							</p>
							<div class="btright">
								<a href="EducationCenter/Application.aspx.html"> <img
									src="Images/Student/default/bt_jw.jpg" alt="进入教务中心" width="121"
									height="25" /></a>
							</div>
						</div>
					</div> --%>
					<div class="dh3" style="margin: 0 27px 15px 0;">
						<div class="dhwz">
						 <p>
							
							<span class="red"><%= info.getType()==1?"学生":"老师" %></span>&nbsp;&nbsp;<%= info.getName() %>
							<% if(info.getType()==1){ %>
							班级：<span class="red"><%=info.getClassname() %></span>
							<%} %>
							</p>
							 <p>
							
								您语文成绩 <span class="red"><%= info.getChinese() %></span>分
							</p>
							<p>
								您数学成绩 <span class="red"><%= info.getMaths() %></span>分
							</p>
							<p>
								您英语成绩 <span class="red"><%= info.getEnglish() %></span>分
							</p>
						</div>
					</div>
					<!-- <div class="dh4">
						<div class="dhwz">
							<p>
								你应交<span class="blue">7800.00</span> 元，实缴 <span class="green">3700.00</span>元
							</p>
							<p>
								欠费 <span class="red">4100.00</span> 元
							</p>
							<p>
								你总共有<span class="red">3</span> 条财务记录需要确定
							</p>

							<div class="btright">
								<a href="MyAccount/wdcw.aspx.html"> <img
									src="Images/Student/default/bt_cw.jpg" alt="进入财务中心" width="121"
									height="25" /></a>
							</div>
						</div>
					</div> -->
				</div>


			</div>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>

</body>
</html>