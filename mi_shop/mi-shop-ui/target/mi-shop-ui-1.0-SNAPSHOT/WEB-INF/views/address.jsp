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
<body class="hold-transition skin-blue sidebar-mini">

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
<!-- end banner_x -->
<!-- self_info -->
<div class="grzxbj">
    <div class="selfinfo center">
        <div class="lfnav fl">
            <div class="ddzx">订单中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/order/dingdanzhongxin">我的订单</a></li>
                    <li><a href="">意外保</a></li>
                    <li><a href="">团购订单</a></li>
                    <li><a href="">评价晒单</a></li>
                </ul>
            </div>
            <div class="ddzx">个人中心</div>
            <div class="subddzx">
                <ul>
                    <li><a href="/self/self_info" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
                    <li><a href="">消息通知</a></li>
                    <li><a href="">优惠券</a></li>
                    <li><a href="/address/addresslist">收货地址</a></li>
                </ul>
            </div>
        </div>
        <div class="rtcont fr">
            <div class="grzlbt ml40">收货地址
                <%--<div style="border: solid 1px red">--%>
                <%--<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#modal-info">--%>
                <%--<a href="/address/save" style="color: black ">--%>
                <%--<i class="fa fa-fw fa-user-plus"></i> 新增--%>
                <%--</a>--%>
                <%--</button>--%>
                <%--</div>--%>
            </div>

            <div class="clear"></div>

            <div style="float:right; margin-right: 60px">
                <button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#modal-info">
                    <a href="/address/save" style="color: black ">
                        <i class="fa fa-fw fa-user-plus"></i> 新增收件地址
                    </a>
                </button>
            </div>
            <div class="clear"></div>
            <!-- Main content -->
            <section class="content">
                <div class="box">
                    <div class="box-body table-responsive no-padding mailbox-messages">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>收货人</th>
                                <td>收货地址</td>
                                <th>手机号</th>
                                <th>是否为默认地址</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${addresses}" var="ad">
                                <tr>
                                    <td>${ad.shouhuoren}</td>
                                    <td>${ad.address}</td>
                                    <td>${ad.phone}</td>
                                    <td>${ad.isDefault eq "1"?"是":"否"}</td>
                                    <td>
                                        <a href="/address/update?id=${ad.id}" style="color: blue">修改</a>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="/address/delete?adid=${ad.id}">删除</a>
                                        &nbsp;&nbsp; &nbsp;
                                        <a href="/address/defaultaddress?adid=${ad.id}">设为默认</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </section>
            <%--<div class="subgrzl ml20" style="background-color: #00b3ee"><a href="/address/save?userid=1">新增</a></div>--%>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>

    </div>
    <footer class="mt20 center">
        <div class="mt-20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
        <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
        <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
    </footer>
</div>

<%--<div class="clear"></div>--%>
</body>
</html>
