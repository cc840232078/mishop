<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
    <script type="text/javascript" src="/static/jquery/jquery-1.8.2.js"></script>

</head>
<body>
<form method="post" action="/register">
    <div class="regist">
        <div class="regist_center">
            <div class="regist_top">
                <div class="left fl">会员注册</div>
                <div class="right fr"><a href="/index" target="_self">小米商城</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="regist_main center">

                <c:if test="${not empty message}">
                    <div>${message}</div>
                </c:if>

                <div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text"
                                                                                     name="userName"
                                                                                     placeholder="请输入你的用户名"/><span>请不要输入汉字</span>
                </div>
                <div class="username">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;<input
                        class="shurukuang" type="text" name="truename" placeholder="请输入你的真实姓名"/></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input
                        class="shurukuang" type="password" name="password" placeholder="请输入你的密码"/><span>请输入6位以上字符</span>
                </div>

                <div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="repassword"
                                                              placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div>
                <div class="username">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：&nbsp;&nbsp;&nbsp;<input class="shurukuang" type="text"
                                                                                          name="email"
                                                                                          placeholder="请填写正确的邮箱"/><span>填写下邮箱，用于注册信息通知</span>
                </div>
                <div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text"
                                                                                     name="phone"
                                                                                     placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span>
                </div>
                <div class="username">
                    <div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text"
                                                                                        name="code"
                                                                                        placeholder="请输入验证码"/></div>
                    <div class="check check-border">
                        &nbsp;&nbsp;
                        &nbsp;&nbsp;
                        <img id="vcode" onclick="loadCode()">
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="regist_submit">
                <input class="submit" type="submit" name="submit" value="立即注册">
            </div>

        </div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        loadCode();
    });

    //
    function loadCode() {
        var d = new Date();
        $("#vcode").prop("src", "/kaptcha?d=" + d);
    }
</script>
</body>
</html>
