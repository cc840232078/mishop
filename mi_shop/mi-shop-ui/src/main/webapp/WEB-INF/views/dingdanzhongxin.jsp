<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米商城-个人中心</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
<!-- start header -->
<header>
    <div class="top center">
        <div class="left fl">
            <ul>
                <li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
                <li>|</li>
                <li><a href="">MIUI</a></li>
                <li>|</li>
                <li><a href="">米聊</a></li>
                <li>|</li>
                <li><a href="">游戏</a></li>
                <li>|</li>
                <li><a href="">多看阅读</a></li>
                <li>|</li>
                <li><a href="">云服务</a></li>
                <li>|</li>
                <li><a href="">金融</a></li>
                <li>|</li>
                <li><a href="">小米商城移动版</a></li>
                <li>|</li>
                <li><a href="">问题反馈</a></li>
                <li>|</li>
                <li><a href="">Select Region</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <div class="right fr">
            <div class="gouwuche fr"><a href="/order/dingdanzhongxin">我的订单</a></div>
            <div class="fr">
                <ul>
                    <c:choose>
                        <c:when test="${empty user}">
                            <li><a href="/ilogin">登录</a></li>
                            <li>|</li>
                            <li><a href="/iregister">注册</a></li>
                            <li>|</li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="/self/self_info" target="_blank">小米商城-个人中心</a></li>
                            <li>|</li>
                        </c:otherwise>
                    </c:choose>

                    <li><a href="">消息通知</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>
</header>
<!--end header -->
<!-- start banner_x -->
<div class="banner_x center">
    <a href="/index" target="_blank">
        <div class="logo fl"></div>
    </a>
    <a href="">
        <div class="ad_top fl"></div>
    </a>
    <div class="nav fl">
        <ul>
            <li><a href="">小米手机</a></li>
            <li><a href="">红米</a></li>
            <li><a href="">平板·笔记本</a></li>
            <li><a href="">电视</a></li>
            <li><a href="">盒子·影音</a></li>
            <li><a href="">路由器</a></li>
            <li><a href="">智能硬件</a></li>
            <li><a href="">服务</a></li>
            <li><a href="">社区</a></li>
        </ul>
    </div>
    <div class="search fr">
        <form action="" method="post">
            <div class="text fl">
                <input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
            </div>
            <div class="submit fl">
                <input type="submit" class="sousuo" value="搜索"/>
            </div>
            <div class="clear"></div>
        </form>
        <div class="clear"></div>
    </div>
</div>
<!-- end banner_x -->
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/order/dingdanzhongxin" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
                    <li><a href="">意外保</a></li>
                    <li><a href="">团购订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/self/self_info">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">优惠券</a></li>
                    <li><a href="/address/addresslist">收货地址</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="ddzxbt">交易订单</div>
            <c:forEach items="${orders.olist}" var="order">
                <div class="ddxq">

                        <%--<c:forEach items="${orders.odlists}" var="olist">--%>
                        <%----%>
                        <%--<c:forEach items="${olist}" var="od">--%>
                        <%----%>
                        <%--<c:if test="${od.order.id==order.id}" >--%>
                        <%--<div class="ddspt fl"><img src="${od.goodsInfo.goodsPic}" alt=""></div>--%>
                        <%--</c:if>--%>
                        <%----%>
                        <%--</c:forEach>--%>
                        <%----%>
                        <%--</c:forEach> --%>
                    <div class="ddspt fl">
                        <img src="/static/image/liebiao_hongmin4_dd.jpg" alt="">
                    </div>
                    <div class="ddbh fl">订单号:${order.id}</div>
                    <div class="ztxx fr">
                        <ul>
                            <li>${order.OStarve}</li>
                            <li>￥${order.OPaycount}</li>
                            <li>
                                <fmt:formatDate value="${order.created}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate>
                            </li>
                            <li>
                                <a href="/order/orderdt?id=${order.id}">订单详情</a>
                            </li>
                            <div class="clear"></div>
                        </ul>
                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
        </div>

        <div class="clear"></div>
    </div>
    <footer class="mt20 center">
        <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
        <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
        <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
    </footer>
</div>
<!-- self_info -->


</body>
</html>
