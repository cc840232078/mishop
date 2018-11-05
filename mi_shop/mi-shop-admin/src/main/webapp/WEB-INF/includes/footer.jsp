<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jQuery 3 -->
<script src="/static/plugins/adminLTE/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/plugins/adminLTE/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/plugins/adminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="/static/plugins/adminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/plugins/adminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- Slimscroll -->
<script src="/static/plugins/adminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/plugins/adminLTE/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/static/plugins/adminLTE/dist/js/adminlte.min.js"></script>

<script src="/static/plugins/jquery-validation/jquery-validation/js/additional-methods.min.js"></script>

<script src="/static/plugins/jquery-validation/jquery-validation/js/localization/messages_zh.min.js"></script>

<script src="/static/plugins/jquery-validation/jquery-validation/js/jquery.validate.min.js"></script>

<script src="/static/app/validate.js"></script>

<script src="/static/plugins/adminLTE/plugins/iCheck/icheck.js"></script>

<script src="/static/app/app.js"></script>

<script src="/static/plugins/adminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>

<script src="/static/plugins/adminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<%--<script src="/static/app/app.js"></script>--%>

<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">用户详情</h4>
            </div>
            <div class="modal-body">
                <p id="detail-message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary " data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>