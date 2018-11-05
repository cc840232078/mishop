
var App = function () {
    var icheck_master ;
    var _checkbox ;
    var idArray;

    var handlerICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
        icheck_master = $('input[type="checkbox"].minimal.icheck_master');
        _checkbox = $('input[type="checkbox"].minimal._checkbox');
    };

    var handlerCheckboxAll = function () {
        icheck_master.on('ifChanged',function (event) {
            if(event.target.checked){
                _checkbox.iCheck('check');
            }

            else {
                _checkbox.iCheck('uncheck');
            }
        });
    };

   //批量删除
    var handlerDeleteMulti = function (url) {
        idArray = new Array();
        _checkbox.each(function (){
            var _id = $(this).attr("id");
            if (_id != null && _id != "undefine" && $(this).is(":checked")) {
                idArray.push(_id);
            }
        });
            if(idArray.length == 0){
                $("#modal-message").html("您还没有选择任何数据，请至少选择一项");
            }

            else {
                $("#modal-message").html("您确定要删除数据吗？");
            }
            $("#modal-default").modal("show");


            $(".btn.btn-primary").bind("click",function () {
                deleteData(url);
            });

    };

    var handlerDeleteSingle = function (url,id,msg) {
        if(!msg){
            msg = null;
        }
        idArray = new Array();
        idArray.push(id);
        $("#modal-message").html(msg == null ?"您确定要删除数据吗？":msg);
        $("#modal-default").modal("show");
        $(".btn.btn-primary").bind("click",function () {
            deleteData(url);
        });
    };


    var deleteData = function(url) {
        $("#modal-default").modal("hide");

        if (idArray.length === 0){

        }

        else {
            setTimeout(function () {
                $.ajax({
                    "url":url,
                    "type":"POST",
                    "data":{"ids":idArray.toString()},
                    "dataType":"JSON",
                    "success":function (data) {
                        if (data.status === 200){
                            window.location.reload();
                        }

                        else {
                            $(".btn.btn-primary").unbind("click");
                            $(".btn.btn-primary").bind("click",function () {
                                $("#modal-default").modal("hide");
                            });

                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    }

                });
            },500);
        }
    };

    var handlerDetail = function(url){
        $.ajax({
            url:url,
            type:"GET",
            dataType:"html",
            success:function (data) {
                $("#detail-message").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    var handlerUserTable = function (url,columns) {
        var dataTable = $("#userTable").DataTable({
            // 是否开启本地分页
            "paging": true,
            // 是否开启本地排序
            "ordering": false,
            // 是否显示左下角信息
            "info": true,
            // 是否允许用户改变表格每页显示的记录数
            "lengthChange": false,
            // 是否显示处理状态(排序的时候，数据很多耗费时间长的话，也会显示这个)
            "processing": true,
            // 是否允许 DataTables 开启本地搜索
            "searching": false,
            // 是否开启服务器模式
            "serverSide": true,
            // 控制 DataTables 的延迟渲染，可以提高初始化的速度
            "deferRender": true,
            // 增加或修改通过 Ajax 提交到服务端的请求数据
            "ajax": {
                "url": url,
            },
            "columns":columns,
            "pagingType": "full_numbers",
            // 设置列的数据源

            // 表格重绘的回调函数
            "drawCallback": function (settings) {
                App.init();
            },
            // 国际化
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }

        });
        return dataTable;
    };

    return {
        init:function () {
            handlerICheck();
            handlerCheckboxAll();
        },
        getCheckbox:function () {
            return _checkbox;
        },
        deleteMulti:function (url) {
            handlerDeleteMulti(url);
        },
        detail:function (url) {
            handlerDetail(url);
        },
        userTable:function (url,columns) {
            return handlerUserTable(url,columns);
        },
        deleteSingle:function (url,id,msg) {
            return handlerDeleteSingle(url,id,msg);
        }

    }
}();

$(document).ready(function () {
   App.init();
});

