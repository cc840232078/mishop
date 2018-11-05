<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <%--<span class="logo-mini"><b>A</b>LT</span>--%>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">小米集团商品管理系统</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">切换小边栏</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

                <!-- Notifications: style can be found in dropdown.less -->


                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="/static/plugins/adminLTE/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">CEO—雷军</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="/static/plugins/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                雷军- Web Developer
                                <small>Member since Nov. 2012</small>
                            </p>
                        </li>

                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">个人信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="#" class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <%--<!-- Control Sidebar Toggle Button -->--%>
                <%--<li>--%>
                <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
                <%--</li>--%>
            </ul>
        </div>
    </nav>
</header>