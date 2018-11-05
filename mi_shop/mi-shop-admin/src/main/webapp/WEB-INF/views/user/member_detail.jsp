<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<body>
<div class="box-body table-responsive" >
    <table id="dataTable" class="table">
        <tbody>
        <tr>
            <td>邮箱</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>${user.userName}</td>
        </tr>
        <tr>
            <td>手机</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <td>真实姓名</td>
            <td>${user.truename}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${user.sex}</td>
        </tr>
        <tr>
            <td>地址</td>
            <td>${user.address}</td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td><fmt:formatDate value="${user.created}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
        </tr>
        </tbody>
    </table>
</div>
<jsp:include page="../../includes/footer.jsp"/>
</body>
</html>

