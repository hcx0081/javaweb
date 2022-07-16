<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--分页条，提取出来复用--%>

<ul class="pagination justify-content-center">

    <%--如果当前页大于1，则首页和上一页可以使用即可以返回首页和上一页；反之，禁用--%>
    <c:choose>
        <c:when test="${page.pageNo>1}">
            <li class="page-item ml-1"><a class="page-link text-dark" href="${page.url}pageNo=1">首页</a></li>
            <li class="page-item ml-1"><a class="page-link text-dark"
                                          href="${page.url}pageNo=${page.pageNo-1}">&laquo;</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="page-item ml-1 disabled"><a class="page-link text-dark" href="${page.url}pageNo=1">首页</a>
            </li>
            <li class="page-item ml-1 disabled"><a class="page-link text-dark"
                                                   href="${page.url}pageNo=${page.pageNo-1}">&laquo;</a></li>
        </c:otherwise>
    </c:choose>




    <%--<c:choose>
        &lt;%&ndash;当前页码小于等于5的情况&ndash;%&gt;
        <c:when test="${page.pageTotal<=5}">
            <c:forEach begin="1" end="${page.pageTotal}" var="i">
                <c:choose>
                    <c:when test="${i==page.pageNo}">
                        <li class="page-item ml-1 disabled"><a class="page-link text-dark border-dark"
                                                               href="${page.url}pageNo=${i}">${i}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item ml-1"><a class="page-link text-dark"
                                                      href="${page.url}pageNo=${i}">${i}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:when>

        &lt;%&ndash;当前页码大于5的情况&ndash;%&gt;
        <c:otherwise>
            <c:choose>

                &lt;%&ndash;当前页码是前两页&ndash;%&gt;
                <c:when test="${page.pageNo<=2}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:choose>
                            <c:when test="${i==page.pageNo}">
                                <li class="page-item ml-1 disabled"><a class="page-link text-dark border-dark"
                                                                       href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item ml-1"><a class="page-link text-dark"
                                                              href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>

                &lt;%&ndash;当前页码是后两页&ndash;%&gt;
                <c:when test="${page.pageNo>=page.pageTotal-2}">
                    <c:forEach begin="${page.pageTotal-4}" end="${page.pageTotal}" var="i">
                        <c:choose>
                            <c:when test="${i==page.pageNo}">
                                <li class="page-item ml-1 disabled"><a class="page-link text-dark border-dark"
                                                                       href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item ml-1"><a class="page-link text-dark"
                                                              href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <c:forEach begin="${page.pageNo-2}" end="${page.pageNo+2}" var="i">
                        <c:choose>
                            <c:when test="${i==page.pageNo}">
                                <li class="page-item ml-1 disabled"><a class="page-link text-dark border-dark"
                                                                       href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item ml-1"><a class="page-link text-dark"
                                                              href="${page.url}pageNo=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:otherwise>

            </c:choose>
        </c:otherwise>

    </c:choose>--%>




    <%--下面这种写法比较简洁--%>

    <c:choose>

        <%--当前页码小于等于5的情况--%>
        <c:when test="${page.pageTotal<=5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${page.pageTotal}"></c:set>
        </c:when>

        <%--当前页码大于5的情况--%>
        <c:otherwise>
            <c:choose>

                <%--当前页码是前两页--%>
                <c:when test="${page.pageNo<=2}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                </c:when>

                <%--当前页码是后两页--%>
                <c:when test="${page.pageNo>=page.pageTotal-2}">
                    <c:set var="begin" value="${page.pageTotal-4}"></c:set>
                    <c:set var="end" value="${page.pageTotal}"></c:set>
                </c:when>

                <c:otherwise>
                    <c:set var="begin" value="${page.pageNo-2}"></c:set>
                    <c:set var="end" value="${page.pageNo+2}"></c:set>
                </c:otherwise>

            </c:choose>
        </c:otherwise>

    </c:choose>


    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:choose>
            <c:when test="${i==page.pageNo}">
                <li class="page-item ml-1 disabled"><a class="page-link text-dark border-dark"
                                                       href="${page.url}pageNo=${i}">${i}</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item ml-1"><a class="page-link text-dark"
                                              href="${page.url}pageNo=${i}">${i}</a></li>
            </c:otherwise>
        </c:choose>
    </c:forEach>







    <%--如果当前页是最后一页，则末页和下一页禁用；反之，可以使用--%>
    <c:choose>
        <c:when test="${page.pageNo==page.pageTotal}">
            <li class="page-item ml-1 disabled"><a class="page-link text-dark"
                                                   href="${page.url}pageNo=${page.pageNo+1}">&raquo;</a>
            </li>
            <li class="page-item ml-1 disabled"><a class="page-link text-dark"
                                                   href="${page.url}pageNo=${page.pageTotal}">末页</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="page-item ml-1"><a class="page-link text-dark"
                                          href="${page.url}pageNo=${page.pageNo+1}">&raquo;</a>
            </li>
            <li class="page-item ml-1"><a class="page-link text-dark"
                                          href="${page.url}pageNo=${page.pageTotal}">末页</a>
            </li>
        </c:otherwise>
    </c:choose>


    <li class="page-item ml-3 pt-2"><span class="">共${page.pageTotalCount}条记录</span></li>
    <li class="page-item ml-3 pt-2"><span class="">共${page.pageTotal}页</span></li>



    <input class="form-control col-1 ml-3" type="search" placeholder="Search" id="jumpPage">
    <button class="btn btn-dark ml-1" id="jump">跳转</button>
    <script type="text/javascript">

        $("#jump").click(function () {

            var pageTotal = "${page.pageTotal}"

            /*因为从文本框获得的值是字符串，所以要转换为 int */
            var pageNo = parseInt($("#jumpPage").val());

            if (pageNo >= 1 && pageNo <= pageTotal) {   /*如果页码在正常范围*/
                window.location.href = "${page.url}pageNo=" + pageNo;
            }else {
                alert("超出范围！")
            }
        })
    </script>

</ul>
</body>
</html>
