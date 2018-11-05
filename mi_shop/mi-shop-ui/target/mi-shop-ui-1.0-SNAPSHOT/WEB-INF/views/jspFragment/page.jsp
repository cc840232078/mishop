<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/18
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--显示分页信息-->
<div class="row">
    <!--文字信息-->
    <div class="col-md-6">
        当前第 ${myPageInfo.page.pageNum} 页.总共 ${myPageInfo.page.pages} 页.一共 ${myPageInfo.page.total} 条记录
    </div>

    <!--点击分页-->
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <li><a href="${myPageInfo.url}1">首页</a></li>

                <!--上一页-->
                <li>
                    <c:if test="${myPageInfo.page.hasPreviousPage}">
                        <a href="${myPageInfo.url}${myPageInfo.page.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">«</span>
                        </a>
                    </c:if>
                </li>

                <!--循环遍历连续显示的页面，若是当前页就高亮显示，并且没有链接-->
                <c:forEach items="${myPageInfo.page.navigatepageNums}" var="page_num">
                    <c:if test="${page_num == myPageInfo.page.pageNum}">
                        <li class="active"><a href="#">${page_num}</a></li>
                    </c:if>
                    <c:if test="${page_num != myPageInfo.page.pageNum}">
                        <li><a href="${myPageInfo.url}${page_num}">${page_num}</a></li>
                    </c:if>
                </c:forEach>

                <!--下一页-->
                <li>
                    <c:if test="${myPageInfo.page.hasNextPage}">
                        <a href="${myPageInfo.url}${myPageInfo.page.pageNum+1}"
                           aria-label="Next">
                            <span aria-hidden="true">»</span>
                        </a>
                    </c:if>
                </li>

                <li><a href="${myPageInfo.url}${myPageInfo.page.pages}">尾页</a></li>
            </ul>
        </nav>
    </div>

</div>
