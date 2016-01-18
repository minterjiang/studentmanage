<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>名特学生信息管理系统</title>
<link href="Style/StudentStyle.css" rel="stylesheet" type="text/css" /><link href="Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" /><link href="Style/ks.css" rel="stylesheet" type="text/css" />
    <script src="Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="Script/Common.js" type="text/javascript"></script>
    <script src="Script/Data.js" type="text/javascript"></script>
    <script type="text/javascript">
        $().ready(function () {
            setStudMsgHeadTabCheck();
            showUnreadSysMsgCount();
        });

        //我的信息头部选项卡
        function setStudMsgHeadTabCheck() {
            var currentUrl = window.location.href;
            currentUrl = currentUrl.toLowerCase();
            var asmhm = "";
            $("#ulStudMsgHeadTab li").each(function () {
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
                StudentLogin.loginOut(function (data) {
                    if (data == "true") {
                        window.location = "/Login.aspx";
                    }
                    else {
                        jBox.alert("退出失败！", "提示", new { buttons: { "确定": true} });
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
            }
            else {
                cateoryId = thisObj.val();
            }
            var studentId = $("#studentId").val();
            if (cateoryId.length <= 0) {
                jBox.tip("报考类别不能为空！");
                if (id == null) {
                    thisObj.val(oldCateoryId);
                }
            }
            else {
                studentInfo.changeStudentCateory(cateoryId, function (data) {
                    var result = $.parseJSON(data);
                    if ((String(result.ok) == "true")) {
                        window.location.href = "/Index.aspx";
                    }
                    else {
                        jBox.tip(result.message);
                    }
                });
            }
        }
    </script>
    
    <script src="Script/changeOption.js" type="text/javascript"></script>
    <script src="Script/rl.js" type="text/javascript"></script>

</head>
<body>
       <jsp:include page="Header.jsp"></jsp:include>
  <div class="page">
        <div class="box mtop">
            <div class="leftbox">
               <%@ include file="Left.jsp" %>
            </div>
            <div class="rightbox">
                
    <h2 class="mbx">
        我的学习中心&nbsp;&nbsp;&nbsp;&nbsp;</h2>

    <div class="dhbg">
        <div class="dh1" style="margin: 0 27px 15px 0;">
            <div class="dhwz">
                <p>
                    您共有 <span class="red">0</span>条通知信息 <span class="red">0 </span>条未读
                </p>
                <p>
                    共有 <span class="red">0 </span>条短信息、 <span class="red">0</span>个投诉、 <span class="red">
                        0 </span>个异议
                </p>
                <p>
                    有 <span class="red">0</span>个投诉、<span class="red">0
                    </span>个异议、<span class="red">0</span>条短信息未处理</p>
                <div class="btright">
                    <a href="User/StudentInfor/Letter.aspx.html">
                        <img src="Images/Student/default/bt_bzr.jpg" alt="给班主任发消息" width="121" height="25" /></a></div>
            </div>
        </div>
        <div class="dh2">
            <div class="dhwz">
                <p>
                    你有 <span class="red">0</span> 门课程要考 <a href="EducationCenter/Application.aspx.html" class="red">查看报考计划</a></p>
                <p>
                    你已经通过 <span class="red">0 </span>门课程&nbsp;共有 <span class="red">13</span> 门 <a href="EducationCenter/Score.aspx.html" class="red">查看成绩</a>
                </p>
                <p>
                    已经发放了 <span class="red">0 </span>本书籍 <a href="EducationCenter/Book.aspx.html" class="red">查看书籍情况</a></p>
                <div class="btright">
                    <a href="EducationCenter/Application.aspx.html">
                        <img src="Images/Student/default/bt_jw.jpg" alt="进入教务中心" width="121" height="25" /></a></div>
            </div>
        </div>
        <div class="dh3" style="margin: 0 27px 15px 0;">
            <div class="dhwz">
                <p>
                    <a href="http://sm.zk0731.com/User/ExamCenter/ExamPractice/ListExam.aspx?ptid=1">模拟考试</a></p>
                <p>
                    <a href="http://sm.zk0731.com/User/ExamCenter/ExamPractice/ListExercise.aspx?ptid=3">章节练习</a>
                </p>
                <p>
                    <a href="http://sm.zk0731.com/User/ExamCenter/ExamPractice/ListExercise.aspx?ptid=2">网上作业</a></p>
                <div class="btright">
                    <a href="http://sm.zk0731.com/User/ExamCenter/ExamPractice/ListExam.aspx?ptid=1">
                        <img src="Images/Student/default/bt_ks.jpg" alt="进入考试中心" width="121" height="25" /></a></div>
            </div>
        </div>
        <div class="dh4">
            <div class="dhwz">
                <p>
                    你应交<span class="blue">7800.00</span> 元，实缴 <span class="green">3700.00</span>元</p>
                    <p>
                    欠费 <span class="red">4100.00</span> 元</p>
                <p>
                    你总共有<span class="red">3</span> 条财务记录需要确定</p>
                
                <div class="btright">
                    <a href="MyAccount/wdcw.aspx.html">
                        <img src="Images/Student/default/bt_cw.jpg" alt="进入财务中心" width="121" height="25" /></a></div>
            </div>
        </div>
    </div>

    <div class="xxlc">
        <strong class="lcbt">学历历程</strong>
    </div>
    <div class="lcbiao">
        <div class="lctime">
            2014-05-01</div>
        <div class="lctime">
            2014-05-02</div>
        <div class="lctime">
             2014-05-03</div>
        <div class="lctime2">
            2014-05-04</div>
        <div class="lctime">
             2014-05-05</div>
        <div class="lctime">
             2014-05-06</div>
        <div class="lctime">
             2014-05-07</div>
    </div>
    <div class="xxjl">
    
        <div align="center">
        <span>
            18:10 登陆系统
            
              <a></a>
             
              </span>
            </div>
           
           
        <div align="center">
        <span>
            18:09 登陆系统
            
              <a></a>
             
              </span>
            </div>
           
           
        <div align="center">
        <span>
            18:06 登陆系统
            
              <a></a>
             
              </span>
            </div>
           
           
        <div align="center">
        <span>
            11:19 登陆系统
            
              <a></a>
             
              </span>
            </div>
           
           
    </div>

            </div>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>
    </div>
  
</body>
</html>