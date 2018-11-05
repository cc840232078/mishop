<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <%-- 中间的css样式 --%>
    <link href="/static/css/demo.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/cartstyle.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/jsstyle.css" rel="stylesheet" type="text/css"/>
    <%-- jquery --%>
    <script type="text/javascript" src="/static/jquery/jquery-1.8.2.js"></script>
    <%-- 中间的jacascript --%>
    <script type="text/javascript">
        $(function () {
            /* var a=$("p[class='buy-footer-address'] span[class='buy-line-title buy-line-title-type']").html();//收获地址栏
            var d=$("p[class='buy-footer-address'] span[class='buy-line-title']").html();//收件人地址栏

            var b=$("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();//收货地址
            var c=$("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();//收获人
            $("p[class='buy-footer-address'] span[class='buy-line-title buy-line-title-type']").html(a+b);//收获地址赋值
            $("p[class='buy-footer-address'] span[class='buy-line-title']").html(d+c);//收件人赋值 */


            var shouhuoren = $("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();
            var phone = $("li[class='user-addresslist defaultAddr'] span[class='buy-phone']").html();
            var address = $("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();

            $("#send").html(address);
            $("#person").html(shouhuoren);
            $("#tel").html(phone);

            $("#buy_user").val(shouhuoren);
            $("#phone").val(phone);
            $("#address").val(address);

            //选择收货地址
            $("ul[class='addressChoose'] li").each(function () {
                $(this).click(function () {
                    $("ul[class='addressChoose'] li").removeClass("defaultAddr");
                    $(this).addClass("defaultAddr");

                    var shouhuoren = $("li[class='user-addresslist defaultAddr'] span[class='buy-user']").html();
                    var phone = $("li[class='user-addresslist defaultAddr'] span[class='buy-phone']").html();
                    var address = $("li[class='user-addresslist defaultAddr'] span[class='buy--address-detail']").html();

                    /* 给结算框里面的信息赋值 */
                    $("#send").html(address);
                    $("#person").html(shouhuoren);
                    $("#tel").html(phone);

                    /* 给form表单赋值 */
                    $("#buy_user").val(shouhuoren);
                    $("#phone").val(phone);
                    $("#address").val(address);
                })
            })

            //改变物流方式
            $("ul[class='op_express_delivery_hot'] li").each(function () {
                $(this).click(function () {
                    $("ul[class='op_express_delivery_hot'] li").removeClass("selected");
                    $(this).addClass("selected");

                    var express = $(this).children("span").attr("id");
                    $("#express").val(express);
                })
            })

            //改变支付方式
            $("ul[class='pay-list'] li").each(function () {
                $(this).click(function () {
                    $("ul[class='pay-list'] li").removeClass("selected");
                    $(this).addClass("selected");

                    var pay = $(this).children("span").attr("id");
                    $("#paytype").val(pay);
                })
            })

            //加号
            $("input[class='add am-btn']").click(function () {
                var id = $(this).next().val();
                var count = parseInt($("#count" + id).val()) + 1;

               /* /!* 给数据的输入框重新赋值 *!/
                $("#count" + id).val(count);
                /!* 得到单价 *!/
                var price = parseFloat($("#priceNow" + id).html());

                var danPrice = count * price;
                /!* 给单个商品总价的输入框赋值 *!/
                $("#singlePrice" + id).html(danPrice.toFixed(2));

                var totalPrice = parseFloat($("#J_ActualFee").html());
                $("#J_ActualFee").html((totalPrice + price).toFixed(2));*/

                $.ajax({
                    type: "GET",
                    url: "modifyNum?userId=${user.id}&goodsVersionNum="+count+"&goodsVersionId="+id,
                    success: function () {
                        // if (data == "1") {
                        /* 给数据的输入框重新赋值 */
                        $("#count" + id).val(count);
                        /* 得到单价 */
                        var price = parseFloat($("#priceNow" + id).html());

                        var danPrice = count * price;
                        /* 给单个商品总价的输入框赋值 */
                        $("#singlePrice" + id).html(danPrice.toFixed(2));

                        var totalPrice = parseFloat($("#J_ActualFee").html());
                        $("#J_ActualFee").html((totalPrice + price).toFixed(2));
                        }
                    // }
                })
            })

            //减号
            $("input[class='min am-btn']").click(function () {
                var id = $(this).next().next().next().val();
                // 第几个中框
                var count = parseInt($("#count" + id).val());
                if (count > 1) {
                    count -= 1;
                    $.ajax({
                        type: "GET",
                        url: "modifyNum?userId=${user.id}&goodsVersionNum="+count+"&goodsVersionId="+id,
                        success: function () {
                        // if (data == "1") {
                            /* 给数据的输入框重新赋值 */
                            $("#count" + id).val(count);
                            /* 得到单价 */
                            var price = parseFloat($("#priceNow" + id).html());

                            var danPrice = count * price;
                            /* 给单个商品总价的输入框赋值 */
                            $("#singlePrice" + id).html(danPrice.toFixed(2));
                            /* 给结算框里的商品总价赋值 */
                            var totalPrice = parseFloat($("#J_ActualFee").html());
                            $("#J_ActualFee").html((totalPrice - price).toFixed(2));
                        }
                        // }
                    })
                }
            })


            // 提交订单
            $("#go").click(function () {
                $("#form").submit();
            })

            //获取总金额
            var money=0.0;
            $(".J_ItemSum.number").each(function () {
                money += parseFloat($(this).text());
            })
            $(".style-large-bold-red").text(money.toFixed(2));
            $("#allmoney").val(money.toFixed(2));
        })
    </script>

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

<%-- body --%>
<div class="concent">
    <!--地址 -->
    <div class="paycont">
        <div class="address">
            <h3>确认收货地址</h3>
            <div class="control">
                <div class="tc-btn createAddr theme-login am-btn am-btn-danger">
                    <a href="addAddress.jsp" style="color: white;">使用新地址</a>
                </div>
            </div>
            <div class="clear"></div>
            <ul class="addressChoose">
                <div class="per-border"></div>

                <c:forEach items="${AddressList}" var="address">
                    <c:choose>
                        <c:when test="${address.isDefault eq '是'}">
                            <li class="user-addresslist defaultAddr">
                        </c:when>
                        <c:otherwise>
                            <li class="user-addresslist">
                        </c:otherwise>
                    </c:choose>
                    <div class="address-left">
                        <div class="user DefaultAddr">
                            <span class="buy-address-detail">
                                <span class="buy-user">${address.shouhuoren}</span>
                                <span class="buy-phone">${address.phone}</span>
                            </span>
                        </div>

                        <div class="default-address DefaultAddr">
                            <span class="buy-line-title buy-line-title-type">收货地址：</span>
                            <span class="buy--address-detail">${address.address}</span>
                        </div>

                        <c:if test="${address.isDefault eq '是'}">
                            <ins class="deftip">默认地址</ins>
                        </c:if>

                    </div>
                    <div class="address-right">
                        <a href="person/address.html">
                            <span class="am-icon-angle-right am-icon-lg"></span>
                        </a>
                    </div>
                    <div class="clear"></div>

                    <div class="new-addr-btn">
                        <a href="#" class="hidden">设为默认</a>
                        <span class="new-addr-bar hidden">|</span>
                        <a href="#">编辑</a>
                        <span class="new-addr-bar">|</span>
                        <a href="javascript:void(0);" onclick="delClick(this);">删除</a>
                    </div>
                    </li>
                </c:forEach>
            </ul>

            <div class="clear"></div>
        </div>
        <!--物流 -->
        <div class="logistics">
            <h3>选择物流方式</h3>
            <ul class="op_express_delivery_hot">
                <li data-value="yuantong" class="OP_LOG_BTN ">
                    <i class="c-gap-right" style="background-position: 0px -468px"></i>圆通
                    <span id="圆通"></span>
                </li>
                <li data-value="shentong" class="OP_LOG_BTN ">
                    <i class="c-gap-right" style="background-position: 0px -1008px"></i>申通
                    <span id="申通"></span>
                </li>
                <li data-value="yunda" class="OP_LOG_BTN ">
                    <i class="c-gap-right" style="background-position: 0px -576px"></i>韵达
                    <span id="韵达"></span>
                </li>
                <li data-value="zhongtong" class="OP_LOG_BTN op_express_delivery_hot_last">
                    <i class="c-gap-right" style="background-position: 0px -324px"></i>中通
                    <span id="中通"></span>
                </li>
                <li data-value="shunfeng" class="OP_LOG_BTN  op_express_delivery_hot_bottom">
                    <i class="c-gap-right" style="background-position: 0px -180px"></i>顺丰
                    <span id="顺丰"></span>
                </li>
            </ul>
        </div>
        <div class="clear"></div>

        <!--支付方式-->
        <div class="logistics">
            <h3>选择支付方式</h3>
            <ul class="pay-list">
                <li class="pay card">
                    <img src="/static/image/wangyin.jpg"/>银联
                    <span id="银联"></span>
                </li>
                <li class="pay qq">
                    <img src="/static/image/weizhifu.jpg"/>微信
                    <span id="微信"></span>
                </li>
                <li class="pay taobao">
                    <img src="/static/image/zhifubao.jpg"/>支付宝
                    <span id="支付宝"></span>
                </li>
            </ul>
        </div>
        <div class="clear"></div>

        <!--订单 -->
        <div class="concent">
            <div id="payTable">
                <h3>确认订单信息</h3>
                <div class="cart-table-th">
                    <div class="wp">

                        <div class="th th-item">
                            <div class="td-inner">商品信息</div>
                        </div>
                        <div class="th th-price">
                            <div class="td-inner">单价</div>
                        </div>
                        <div class="th th-amount">
                            <div class="td-inner">数量</div>
                        </div>
                        <div class="th th-sum">
                            <div class="td-inner">金额</div>
                        </div>
                        <div class="th th-oplist">
                            <div class="td-inner">配送方式</div>
                        </div>

                    </div>
                </div>
                <div class="clear"></div>

                <%-- 展示订单数据 --%>
                <tr class="item-list">
                    <div class="bundle  bundle-last">
                        <c:forEach items="${GoodsVersionList}" var="goodsCar">
                        <div class="bundle-main">
                            <ul class="item-content clearfix">
                                <div class="pay-phone">
                                    <li class="td td-item">
                                        <div class="item-pic">
                                            <a href="#" class="J_MakePoint">
                                                <!--商品的图片-->
                                                <img src="${goodsCar.goodsVersion.goodsInfo.goodsPic}" style="width: 80px; height: 80px" class="itempic J_ItemImg">
                                            </a>
                                        </div>
                                        <div class="item-info">
                                            <div class="item-basic-info">
                                                <!--商品的信息  -->
                                                <a href="#" class="item-title J_MakePoint" data-point="tbcart.8.11">${goodsCar.goodsVersion.goodsInfo.goodsDescription}</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="td td-price">
                                        <div class="item-price price-promo-promo">
                                            <div class="price-content">
                                                    <%--<div class="price-line">--%>
                                                    <%--<!--商品的价格  -->--%>
                                                    <%--<em class="price-original">${goodsCar.goodsVersion.goodsPrice}</em>--%>
                                                    <%--</div>--%>
                                                <div class="price-line">
                                                    <!--商品的折后价  -->
                                                    <em class="J_Price price-now" id="priceNow${goodsCar.goodsVersion.id}" tabindex="0">${goodsCar.goodsVersion.goodsPrice}</em>
                                                </div>

                                            </div>
                                        </div>
                                    </li>
                                </div>
                                <li class="td td-amount">
                                    <div class="amount-wrapper ">
                                        <div class="item-amount ">
                                            <span class="phone-title">购买数量</span>
                                            <div class="sl">
                                                <input class="min am-btn" name="" type="button" value="-" id="jian"/>
                                                <input class="text_box" id="count${goodsCar.goodsVersion.id}" type="text" value="${goodsCar.num}" style="width: 30px; text-align: center;"/>
                                                <input class="add am-btn" name="" type="button" value="+" id="jia"/>
                                                <input type="hidden" value="${goodsCar.goodsVersion.id}"/>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li class="td td-sum">
                                    <div class="td-inner">
                                        <!--单个商品的总价格  -->
                                        <em tabindex="0" class="J_ItemSum number" id="singlePrice${goodsCar.goodsVersion.id}">${goodsCar.num * goodsCar.goodsVersion.goodsPrice}</em>
                                    </div>
                                </li>
                                <li class="td td-oplist">
                                    <div class="td-inner">
                                        <span class="phone-title">配送方式</span>
                                        <div class="pay-logis">
                                            快递<b class="sys_item_freprice"></b>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="clear"></div>
                        </div>
                        </c:forEach>
                </tr>
                <div class="clear"></div>
            </div>


            <!--信息 -->
            <div class="order-go clearfix">
                <div class="pay-confirm clearfix">
                    <div class="box">
                        <div tabindex="0" id="holyshit267" class="realPay">
                            <em class="t">实付款：</em>
                            <span class="price g_price ">
                                <span>¥</span>
                                <em class="style-large-bold-red " id="J_ActualFee"></em>
                            </span>
                        </div>

                        <div id="holyshit268" class="pay-address">

                            <p class="buy-footer-address">
                                <span class="buy-line-title buy-line-title-type">寄送至：</span>
                                <span class="buy--address-detail" id="send"> </span>
                            </p>
                            <p class="buy-footer-address">
                                <span class="buy-line-title">收货人：</span>
                                <span class="buy-address-detail">
                                    <span class="buy-user" id="person"></span>
                                    <span class="buy-phone" id="tel"></span>
                                </span>
                            </p>
                        </div>
                    </div>

                    <div id="holyshit269" class="submitOrder">
                        <div class="go-btn-wrap">
                            <c:choose>
                                <c:when test="${GoodsVersionList.size()==0}">
                                    <a class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                                </c:when>
                                <c:otherwise>
                                    <a id="go" class="btn-go" tabindex="0" title="点击此按钮，提交订单">提交订单</a>
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <form action="/success" method="post" id="form">
                            <input type="hidden" name="oShperson" value="" id="buy_user"/> <!--  收件人  有-->
                            <input type="hidden" name="oShphone" value="" id="phone"/>     <!--  电话  有-->
                            <input type="hidden" name="oShaddress" value="" id="address"/> <!--  收件地址  有-->
                            <input type="hidden" name="oSendtype" value="" id="express"/>    <!--  快递  -->
                            <input type="hidden" name="oPaytype" value="" id="paytype"/>       <!--  支付方式  -->
                            <input type="hidden" name="oPaycount" value="" id="allmoney"/>      <!--  总金额  有-->
                        </form>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
        <div class="clear"></div>
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