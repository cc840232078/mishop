<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车-小米商城</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <script type="text/javascript" src="/static/jquery/jquery-1.8.2.js"></script>
</head>
<body>
<!-- start header -->
<!--end header -->

<!-- start banner_x -->
<div class="banner_x center">
    <a href="#" target="_blank">
        <div class="logo fl"></div>
    </a>

    <div class="wdgwc fl ml40">我的购物车</div>
    <div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
    <%--<div class="dlzc fr">--%>
    <%--<ul>--%>
    <%--<li>--%>
    <%--<a href="./login.html" &lt;%&ndash;target="_blank"&ndash;%&gt; >返回</a>--%>
    <%--</li>--%>
    <%--&lt;%&ndash;<li>|</li>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<li><a href="./register.html" target="_blank">注册</a></li>&ndash;%&gt;--%>
    <%--</ul>--%>
    <%--</div>--%>
    <div class="clear"></div>
</div>

<div class="xiantiao"></div>

<div class="gwcxqbj">
    <form action="/jiesuan" method="post" onsubmit="return checkform()">
        <div class="gwcxd center">
            <div class="top2 center">
                <div class="sub_top fl">
                    <%--<input type="checkbox" value="quanxuan" class="quanxuan"/>--%>序号
                </div>
                <div class="sub_top fl">商品名称</div>
                <div class="sub_top fl">单价</div>
                <div class="sub_top fl">数量</div>
                <div class="sub_top fl">小计</div>
                <div class="sub_top fr">操作</div>
                <div class="clear"></div>
            </div>
            <%-- 具体的商品 --%>
            <c:set var="list" value="${GoodsVersionList}"></c:set>
            <c:forEach var="goodsCar" items="${list}" varStatus="status">
                <div class="content2 center">
                    <div class="sub_content fl ">
                        <%--<input type="checkbox" value="quanxuan" class="quanxuan" style="margin-top: 45px"/>--%>
                        ${status.index+1}
                    </div>
                    <div class="sub_content fl">
                        <img src="${goodsCar.goodsVersion.goodsInfo.goodsPic}" style="margin-top: 15px;width: 80px;height: 80px">
                    </div>
                    <div class="sub_content fl ft20">${goodsCar.goodsVersion.goodsInfo.goodsName} ${goodsCar.goodsVersion.version}</div>
                    <div class="sub_content fl ">${goodsCar.goodsVersion.goodsPrice}</div>
                    <div class="sub_content fl">
                            <%--<input &lt;%&ndash;class="min am-btn"&ndash;%&gt; name="" type="button" value="-" id="jian"/>--%>
                            <%--<input &lt;%&ndash;class="text_box"&ndash;%&gt; id="count${goodsCar.goodsVersion.id}" type="text" value="${goodsCar.num}" style="width: 30px; text-align: center;"/>--%>
                            <%--<input &lt;%&ndash;class="add am-btn"&ndash;%&gt; name="" type="button" value="+" id="jia"/>--%>
                            <%--<input type="hidden" value="${goodsCar.goodsVersion.id}"/>--%>
                            <%-- 改之前 --%>
                        <%--<input &lt;%&ndash;class="shuliang"&ndash;%&gt; type="text" &lt;%&ndash;onchange="upperCase()"&ndash;%&gt; --%><%--value="--%>${goodsCar.num}<%--"--%> <%--step="1" min="1"--%> <%--style="margin-top: 45px">--%>
                    </div>
                    <div class="sub_content fl sumPrice">${goodsCar.goodsVersion.goodsPrice * goodsCar.num}</div>
                    <div class="sub_content fl">
                        <input class="delete" type="button" value="X" style="margin-top: 50px"/>
                        <input type="hidden" value="${goodsCar.goodsVersion.id}"/>
                    </div>
                    <div class="clear"></div>
                </div>
            </c:forEach>
            <%--<div class="content2 center">--%>
            <%--<div class="sub_content fl ">--%>
            <%--<input type="checkbox" value="quanxuan" class="quanxuan"/>--%>
            <%--</div>--%>
            <%--<div class="sub_content fl"><img src="/static/image/gwc_xiaomi6.jpg"></div>--%>
            <%--<div class="sub_content fl ft20">小米6全网通6GB内存+64GB 亮黑色</div>--%>
            <%--<div class="sub_content fl ">2499元</div>--%>
            <%--<div class="sub_content fl">--%>
            <%--<input class="shuliang" type="number" value="1" step="1" min="1">--%>
            <%--</div>--%>
            <%--<div class="sub_content fl">2499元</div>--%>
            <%--<div class="sub_content fl"><a href="">×</a></div>--%>
            <%--<div class="clear"></div>--%>
            <%--</div>--%>
        </div>

        <div class="jiesuandan mt20 center">
            <div class="tishi fl ml20">
                <ul>
                    <li><a href="/index">继续购物</a></li>
                    <li>|</li>
                    <li>共<span id="goodsnum1"></span>件商品，已选择<span id="goodsnum2">0</span>件</li>
                    <div class="clear"></div>
                </ul>
            </div>
            <div class="jiesuan fr">
                <div class="jiesuanjiage fl">合计（不含运费）：
                    <span id="allsum"></span>
                </div>
                <div class="jsanniu fr">
                    <c:choose>
                        <c:when test="${list.size()==0}">
                            <input class="jsan" type="submit" name="jiesuan" value="去结算" disabled="disabled"/>
                        </c:when>
                        <c:otherwise>
                            <input class="jsan" type="submit" name="jiesuan" value="去结算"/>
                        </c:otherwise>
                    </c:choose>

                </div>
                <div class="clear"></div>
            </div>

            <div class="clear"></div>
        </div>
    </form>
</div>

<div class="clear"></div>
<!-- footer -->
<footer class="center">

    <div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
    <div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
    <div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
</footer>

<script type="text/javascript">
    function upperCase() {
        alert(parseInt($(this).val()));
    }
    function checkform(){
        var num=parseFloat($("#allsum").text());
        if (num==0){
            return false;
        }
    }
    $(function () {
        //给 共计几件商品赋值
        $("#goodsnum1").text(${list.size()});
        //
        var sum = 0.0;
        $(".sumPrice").each(function () {
            sum += parseFloat($(this).text());
        })

        $("#allsum").text(sum.toFixed(2));
        //alert(parseFloat(sum));

        $(".delete").click(function () {
            var num = $(this).next().val();
            $.ajax({
                type: "GET",
                url: "deleteGoodsCar?userId=${user.id}&goodsVersionId="+num,
                success: function () {
                    //给 共计几件商品赋值
                    var sice=parseFloat($("#goodsnum1").text());
                    $("#goodsnum1").text(sice-1);
                    //
                    var sum = 0.0;
                    $(".sumPrice").each(function () {
                        sum += parseFloat($(this).text());
                    })

                    $("#allsum").text(sum.toFixed(2));
                    //alert($(this).parents(".content2.center"))
                    //$($(this).parents(".content2.center")).remove();

                    //$(this).remove();

                    // if (data == "1") {.addclass("hiddendiv")
                    //     /* 给数据的输入框重新赋值 */
                    //     $("#count" + id).val(count);
                    //     /* 得到单价 */
                    //     var price = parseFloat($("#priceNow" + id).html());
                    //
                    //     var danPrice = count * price;
                    //     /* 给单个商品总价的输入框赋值 */
                    //     $("#singlePrice" + id).html(danPrice.toFixed(2));
                    //
                    //     var totalPrice = parseFloat($("#J_ActualFee").html());
                    //     $("#J_ActualFee").html((totalPrice + price).toFixed(2));
                    // }
                    //alert("操作成功"+num);
                }
            })
            $(this).parent().parent().remove();
        })
    })
</script>
</body>
</html>