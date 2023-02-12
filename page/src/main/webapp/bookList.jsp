<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍展示</title>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css"/>
    <script src="static/js/jquery-3.1.1.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css"/>
</head>
<body>
    <div class="container border border-dark mt-3 pt-3">
        <table class="table mt-2">

            <thead class="thead-dark">
            <tr>
                <th scope="col">书名</th>
                <th scope="col">作者</th>
                <th scope="col">价格</th>
                <th scope="col">库存</th>
            </tr>
            </thead>


            <tbody>

            <c:forEach items="${page.items}" var="it">
                <tr>
                    <td>${it.bookname}</td>
                    <td>${it.bookautor}</td>
                    <td>￥${it.bookprice}</td>
                    <td>${it.booknum}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>


        <%--静态包含，分页条--%>
        <%@include file="page_nav.jsp" %>


        <form class="form-inline justify-content-center mb-2" id="form" action="PageByPriceServlet">
            <input type="hidden" name="pageNo" value="1"><%--注意此处--%>
            <label class="">价格：</label>
            <%--保留参数中的 min--%>
            <input class="col-1 form-control form-control-sm" type="text" id="min" name="min" value="${param.min}">&nbsp;元
            &nbsp;—&nbsp;
            <%--保留参数中的 max--%>
            <input class="col-1 form-control form-control-sm" type="text" id="max" name="max" value="${param.max}">&nbsp;元
            <button class="btn btn-outline-secondary ml-2 btn-s" type="submit" id="search">查询</button>
            <script>

                $("#search").click(function () {
                    var min = $("#min").val()
                    var max = $("#max").val()

                    /* //如果输入的值为 空 ，即什么也没输入，或输入的值 有空格
                     if ((min==""||max=="")||((min.indexOf(" ")>=0)||max.indexOf(" ")>=0)){
                         alert("不能为空！")
                         //表单不提交
                         return false
                     }*/


                    //如果输入的值 有空格 ，为 空 交给后端处理
                    if (((min.indexOf(" ") >= 0) || max.indexOf(" ") >= 0)) {
                        alert("不能为空！")
                        //表单不提交
                        return false
                    }

                })

            </script>
        </form>


    </div>
</body>
</html>