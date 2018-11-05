<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/plugins/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>雷军</p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">主菜单</li>
            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>用户管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/user/list"><i class="fa fa-circle-o"></i>用户列表</a></li>
                    <li><a href="/user/form"><i class="fa fa-circle-o"></i>新增用户</a></li>
                    <%--<li><a href="#"><i class="fa fa-circle-o"></i> 用户编辑</a></li>--%>
                </ul>
            </li>

            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>会员管理</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/member/list"><i class="fa fa-circle-o"></i>会员列表</a></li>
                    <li><a href="/member/form"><i class="fa fa-circle-o"></i>新增会员</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i>用户编辑</a></li>
                </ul>
            </li>

            <li class="active treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>商品信息</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/category/list"><i class="fa fa-circle-o"></i>商品管理</a></li>
                    <%--<li><a href="#"><i class="fa fa-circle-o"></i> 内容列表</a></li>--%>
                </ul>
            </li>

            <%--<li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>--%>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>