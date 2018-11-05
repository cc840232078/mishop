<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 新增用户</title>
    <jsp:include page="../../includes/header.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="../../includes/nav.jsp"/>

    <jsp:include page="../../includes/menu.jsp"/>

    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                ${user.id == null ? "新增":"编辑"}用户
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li><a href="#">${user.id == null ? "新增":"编辑"}信息</a></li>
            </ol>
        </section>

        <div class="row" style="margin-left: 1px;margin-top: 8px;margin-right: 1px;">
            <div class="col-xs-12">
        <div class="box box-info" >

            <div class="box-header with-border">

                <h3 class="box-title">用户信息</h3>
            </div>
            <!-- /.box-header -->
            <c:if test="${not empty baseResult.message}">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                 ${baseResult.message}
            </div>
            </c:if>
            <!-- form start -->
            <jsp:useBean id="user" class="com.xiaomi.mishop.entity.User" scope="request"/>
            <form:form id="inputForm" cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="user">
               <form:hidden path="id"/>
                <div class="box-body">
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮箱</label>

                        <div class="col-sm-6">
                            <form:input path="email" cssClass="form-control required email" placeholder="邮箱"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>

                        <div class="col-sm-6">
                            <form:password path="password" cssClass="form-control required" placeholder="密码"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="userName" class="col-sm-2 control-label">昵称</label>

                        <div class="col-sm-6">
                            <form:input path="userName" cssClass="form-control required" placeholder="昵称"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="truename" class="col-sm-2 control-label">真实姓名</label>

                        <div class="col-sm-6">
                            <form:input path="truename" cssClass="form-control required" placeholder="真实姓名"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">电话</label>

                        <div class="col-sm-6">
                            <form:input path="phone" cssClass="form-control required mobile" placeholder="电话"/>
                        </div>
                    </div>

                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    <button onclick="history.go(-1)" type="button" class="btn btn-default">返回</button>
                    <button type="submit" class="btn btn-info pull-right" >保存</button>
                </div>
            </form:form>
                <!-- /.box-footer -->
        </div>
    </div>
        </div>
    </div>


    <jsp:include page="../../includes/copyright.jsp"/>

</div>

</div>

<jsp:include page="../../includes/footer.jsp"/>

</body>
</html>

