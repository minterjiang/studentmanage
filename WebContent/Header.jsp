<%@ page language="java" pageEncoding="utf-8"%>
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
                    <a href="Index.aspx.html">
                        <img src="Images/Student/logo.gif" alt="" width="165" height="48" />
                    </a>
                </div>
                <div class="topxx">
                    <select onchange="changeCateory($(this))" style="font-size: 11px; background: #4991cf;
                        color: #fff;">
                        
                        <option 
                            value="4">
                            远程</option>
                        
                        <option selected='selected'
                            value="1">
                            自考</option>
                        
                    </select>
                    910513201419学员：邹智，欢迎您！ <a href="MyInfo/Index.aspx.html">我的信息</a> <a href="User/StudentInfor/systemMsge.aspx.html">
                        通知</a> <a href="User/Account/ChangePasswd.aspx.html">密码修改</a> <a onclick="loginOut()"
                            href="javascript:">安全退出</a>
                </div>
                <div class="blog_nav">
                    <ul>
                        <li><a href="Index.aspx.html">我的信息</a></li>
                        <li><a href="EducationCenter/Score.aspx.html">教务中心</a></li>
                        <li><a href="MyAccount/wdcw.aspx.html">我的学费</a></li>
                        <li><a href="OnlineTeaching/StudentMaterial.aspx.html">资料中心</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>