<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sys" uri="/WEB-INF/sys.tld" %>
<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>
<link href="/static/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css">




<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <jsp:include page="/WEB-INF/includes/nav.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/includes/menu.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                分类管理
            </h1>
            <c:if test="${not empty errorMessage }">
                <br>
                <div class="alert alert-danger alert-dismissible ">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        ${errorMessage}
                </div>
            </c:if>
            <%--<ul id='myTree' class='ztree'>--%>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- general form elements -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">分类编辑</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" action="/category/edit" method="post" id="form">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="pid">父节点</label>
                                    <input type="hidden" class="form-control" value="${Good.goodsInfo.goodsTypeFather.id}" name="goodsInfo.goodsTypeFather.id" id="pid" placeholder="父id">
                                    <input type="text" readonly="readonly" class="form-control" value="${Good.goodsInfo.goodsTypeFather.gtypeName}" pname="goodsInfo.goodsTypeFather.gtypeName" id="pname" placeholder="父节点" data-toggle="modal" data-target="#modal-info">
                                    <input type="hidden" name="id"   value="${Good.id}">
                                </div>

                                <div class="form-group">
                                    <label for="name">商品名称</label>
                                    <input type="text" maxlength="50" minlength="3" required value="${Good.goodsInfo.goodsName}"  class="form-control" id="goodsInfo.goodsName" name="goodsInfo.goodsName" placeholder="商品描述">

                                </div>
                                <div class="form-group">
                                    <label for="name">商品描述</label>
                                    <input type="text" maxlength="50" minlength="3" required value="${Good.goodsInfo.goodsDescription}"  class="form-control" id="goodsInfo.goodsDescription" name="goodsInfo.goodsDescription" placeholder="商品描述">
                                </div>
                                <div class="form-group">
                                    <label for="name">商品价格（￥）</label>
                                    <input type="number" maxlength="10" minlength="1" required value="${Good.goodsPrice}"  class="form-control" id="goodsPrice" name="goodsPrice" placeholder="商品价格">
                                </div>
                                <div class="form-group">
                                    <label for="name">商品库存（件）</label>
                                    <input type="number" maxlength="10" minlength="1" required value="${Good.goodsStock}"  class="form-control" id="goodsStock" name="goodsStock" placeholder="商品库存">
                                </div>
                                <div class="form-group">
                                    <label for="order">商品版本</label>
                                    <input type="text"    class="form-control" value="${Good.version}" id="version" name="version" placeholder="商品版本">
                                </div>

                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="submit" class="btn btn-primary">提交</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->

                </div>

            </div>

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <jsp:include page="/WEB-INF/includes/copyright.jsp"></jsp:include>


    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <%--<div class="control-sidebar-bg"></div>--%>
</div>

</div>
<div class="modal modal-info fade in" id="modal-info" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span></button>
                <h4 class="modal-title">父节点数据</h4>
            </div>
            <div class="modal-body">
                <ul id="category-tree" class="ztree"></ul>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline pull-left" data-dismiss="modal">取消</button>
                <button onclick="getData()" type="button" class="btn btn-outline">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript" src="/static/plugins/jquery-ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
    $(function () {
        $("#form").validate();

        //加载ztree
        var setting = {
            view: {
                //是否允许多选 不允许多选
                selectedMulti: false
            },
            //异步
            async: {
                enable: true,
                url: "/category/treeData",
                autoParam: ['id']
            }
        };

        $.fn.zTree.init($("#category-tree"), setting);

    });
    function getData() {
        //获取到ztree对象 把控件所在的ul 那个id传进去
        var zTree = $.fn.zTree.getZTreeObj("category-tree");
        //获取到选中的节点
        var nodes = zTree.getSelectedNodes();//因为ztree允许多选，所以getSelectedNodes返回一个json对象数组
        if(nodes.length==0){
            alert("请选择一条数据");
            return;
        }
        var name=nodes[0].name;
        var id=nodes[0].id;

        $("#pid").val(id);
        $("#pname").val(name);
        $("#modal-info").modal("hide");//将model隐藏，这是bootstrap自带的方法
    }
</script>
<script type="text/javascript">

    // function submitForm() {
    //     var password=$("#password").val();
    //     password=password.trim();
    //     if(password==''){
    //         alert("密码不能为空！");
    //         return;
    //     }
    //     if(password.length<6 || password.length>20){
    //         alert("密码长度不可以少于6位，不能超过20位");
    //         return;
    //     }
    //     var userName=$("#userName").val();
    //     userName=userName.trim();
    //     if(userName==''){
    //         alert("用户名不能为空！");
    //         return;
    //     }
    //     if(userName.length<3 || userName.length>10){
    //         alert("用户名长度不可以少于3位，不能超过10位");
    //         return;
    //     }
    //     var phone=$("#phone").val();
    //     phone=phone.trim();
    //     if(!checkPhone(phone)){
    //         alert("电话号码格式不正确！")
    //         return;
    //     }
    //     $("#form").submit();
    // }
    function checkPhone(str){
        var re = /^1\d{10}$/;
        if(re.test(str)){
            return true;
        }else{
            return false;
        }
    }
</script>

