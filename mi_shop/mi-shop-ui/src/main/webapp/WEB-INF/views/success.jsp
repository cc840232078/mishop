<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <%-- 中间的 --%>
    <link href="/static/css/demo.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/sustyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%-- 头部 --%>
<div class="banner_x center">
    <a href="./index.html" target="_blank">
        <div class="logo fl"></div>
    </a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <%--<div class="dlzc fr">--%>
        <%--<ul>--%>
            <%--<li><a href="./login.html" target="_blank">登录</a></li>--%>
            <%--<li>|</li>--%>
            <%--<li><a href="./register.html" target="_blank">注册</a></li>--%>
        <%--</ul>--%>

    <%--</div>--%>
    <div class="clear"></div>
</div>

<div class="xiantiao"></div>
<%-- body--%>
<div class="take-delivery">
    <div class="status">
        <h2>您已成功付款</h2>
        <div class="successInfo">
            <ul>
                <li>付款金额<em>${order.OPaycount }元</em></li>
                <div class="user-info">
                    <p>收货人：${order.OShperson}</p>
                    <p>联系电话：${order.OShphone }</p>
                    <p>收货地址：${order.OShaddress}</p>
                </div>
                请认真核对您的收货信息，如有错误请联系客服

            </ul>
            <div class="option">
                <span class="info">您可以在</span>
                <a href="person/order.html" class="J_MakePoint"><span>已买到的宝贝</span></a>
                <a href="person/orderinfo.html" class="J_MakePoint">查看<span>交易详情</span></a>
            </div>
        </div>
    </div>
</div>
<!-- footer -->
<footer class="center">
    <div class="xiantiao"></div>
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

</body>
</html>
