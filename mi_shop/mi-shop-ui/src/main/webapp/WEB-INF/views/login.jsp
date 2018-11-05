<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>会员登录</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
    <script type="text/javascript" src="/static/jquery/jquery-1.8.2.js"></script>

</head>
<body>
<!-- login -->
<div class="top center">
    <div class="logo center">
        <a href="./index.html" target="_blank"><img src="/static/image/mistore_logo.png" alt=""></a>
    </div>
</div>
<form method="post" action="/login" class="form center">
    <div class="login">
        <div class="login_center">
            <div class="login_top">
                <div class="left fl">会员登录</div>
                <div class="right fr">您还不是我们的会员？<a href="iregister" target="_self">立即注册</a></div>
                <div class="clear"></div>
                <div class="xian center"></div>
            </div>
            <div class="login_main center">
                <c:if test="${not empty message }">
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            ${message}
                    </div>
                </c:if>
                <div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username"
                                                       placeholder="请输入你的用户名"/></div>
                <div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password"
                                                                              name="password" placeholder="请输入你的密码"/>
                </div>
                <div class="username">
                    <div class="left fl">验证码:
                        <input class="yanzhengma" type="text" name="vcode" placeholder="请输入验证码"/>
                        &nbsp;&nbsp;
                    </div>

                    <div class="check check-border" >
                        <img  id="vcode" onclick="loadCode()">
                    </div>
                    <div class="clear"></div>
                </div>

            </div>
            <div class="login_submit">
                <input class="submit" type="submit" name="submit" value="立即登录">
            </div>

        </div>
    </div>
</form>
<footer>
    <div class="copyright">简体 | 繁体 | English | 常见问题</div>
    <div class="copyright">陈氏集团董事会<img src="/static/image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号
    </div>

</footer>
<script type="text/javascript">
    $(function () {
        loadCode();
    });
    //
    function loadCode() {
        var d=new Date();
        $("#vcode").prop("src","/kaptcha?d="+d);
    }
</script>
</body>
</html>
