<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 会员列表</title>
    <jsp:include page="../../includes/header.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="../../includes/nav.jsp"/>

    <jsp:include page="../../includes/menu.jsp"/>

    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                会员管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li><a href="#">会员管理</a></li>
            </ol>
        </section>
        <c:if test="${not empty baseResult.message}">
            <div class="alert alert-success alert-dismissible" style="margin:5px 18px 0px 18px">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${baseResult.message}
            </div>
        </c:if>
        <div class="row " style="margin-left: 15px;margin-top: 8px;margin-right: 15px;">
            <div class="box box-info box-info-search" style="display: none">
                <div class="box-header with-border">
                    <h3 class="box-title">高级搜索</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <div class="box-body">
                    <div class="col-xs-12 col-sm-3">
                        <div class="form-group">
                            <label for="username" class="col-sm-3 control-label">姓名</label>

                            <div class="col-sm-9">
                                <input type="text" class="form-control email" id="username" name="username" placeholder="姓名"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-3">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">邮箱</label>

                            <div class="col-sm-9">
                                <input id="email" name="email" class="form-control email" placeholder="邮箱">
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-12 col-sm-3">
                        <div class="form-group">
                            <label for="phone" class="col-sm-3 control-label">手机</label>

                            <div class="col-sm-9">
                                <input id="phone" name="phone" class="form-control email" placeholder="手机">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.box-body -->
                <div class="box-footer">
                    <button type="button" class="btn btn-info pull-right" onclick="search()">搜索</button>
                </div>
                <!-- /.box-footer -->
            </div>
        </div>

        <div class="row" style="margin-left: 1px;margin-top: 0px;margin-right: 1px;">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">会员列表</h3>


                    </div>

                    <div class="box-body">
                        <div class="col-xs-12">
                            <a href="/member/form" type="button" class="btn btn-default btn-sm" style="width:auto;margin-left: 10px"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;
                            <button type="button" class="btn btn-default btn-sm" style="width:auto" onclick="App.deleteMulti('/member/delete')"><i class="fa fa-trash"></i> 删除</button>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-default btn-sm" style="width:auto"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-default btn-sm" style="width:auto"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;
                            <button type="button" class="btn btn-info btn-sm" style="width:auto" onclick="$('.box-info-search').css('display')== 'none' ? $('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                        </div>
                    </div>

                    <!-- /.box-header -->
                    <div class="box-body table-responsive" >
                        <table id="userTable" class="table table-hover">
                            <thead>
                            <tr>
                                <th><input type="checkbox" class="minimal icheck_master" ></th>
                                <th>ID</th>
                                <th>用户名</th>
                                <th>姓名</th>
                                <th>电话</th>
                                <th>邮件</th>
                                <th>地址</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
    </div>

    <jsp:include page="../../includes/copyright.jsp"/>

</div>

</div>

<jsp:include page="../../includes/footer.jsp"/>

<sys:modal />
<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal _checkbox" />';
                }
            },
            {"data": "id"},
            {"data": "userName"},
            {"data":"truename"},
            {"data": "phone"},
            {"data": "email"},
            {"data":"address"},
            {"data": "updated"},
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/member/detail?id="+ row.id;
                    var deleteUrl = "/member/delete";
                    return '<button type="button" class="btn btn-sm btn-primary" onclick="App.detail(\'' + detailUrl + '\')"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<a href="/member/form?id='+row.id +'" type="button" class="btn btn-sm btn-info"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button href="#" type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\''+ deleteUrl +'\',\''+row.id+'\')"><i class="fa fa-trash-o"></i> 删除</button>'
                }
            }
        ]
        _dataTable =  App.userTable("/member/page",_columns);
    });
    function search() {
        var username = $("#username").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var param = {
            "userName": username,
            "email": email,
            "phone":phone
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }

</script>

</body>
</html>

