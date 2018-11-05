<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="author" content="order by dede58.com"/>
    <title>小米商城-个人中心</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">

    <link rel="stylesheet" href="/static/dingdan/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/dingdan/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/dingdan/Ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dingdan/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
    folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/static/dingdan/css/skins/_all-skins.min.css">
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
            <div class="gouwuche fr"><a href="/order/dingdanzhongxin.html">我的订单</a></div>
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
<!-- end banner_x -->
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/order/dingdanzhongxin" >我的订单</a></li>
                    <li><a href="">意外保</a></li>
                    <li><a href="">团购订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="self/self_info" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">优惠券</a></li>
                    <li><a href="/address/addresslist">收货地址</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">订单详情</div>

            <!-- Main content -->
            <section class="content">
                <div class="box">
                    <div class="box-body table-responsive no-padding mailbox-messages">
                        <table class="table table-hover">
                            <thead>

                            <tr>
                                <th>订单号 </th>
                                <th>收货人</th>
                                <th>手机号码</th>
                                <td>收货地址</td>
                                <th>订单金额</th>
                                <th>下单时间</th>
                                <th> 物流</th>
                                <th> 订单状态</th>
                                <th>操作</th>
                            </tr>

                            </thead>


                            <tbody>

                            <c:forEach items="${orders3}" var="order">
                                <tr>
                                    <td>${order.id}</td>
                                    <td>${order.OShperson}</td>
                                    <td>${order.OShphone}</td>
                                    <td>${order.OShaddress}</td>
                                    <td>${order.OPaycount}</td>
                                    <td><fmt:formatDate value="${order.created}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate></td>
                                    <td>${order.OSendtype}</td>
                                    <td>${order.OStarve}</td>
                                    <td><a href="" style="color: blue">退款</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                            <tfoot>

                            </tfoot>
                        </table>
                    </div>

                </div>
            </section>


        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- self_info -->

<footer class="mt20 center">
    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>
</body>
</html>
