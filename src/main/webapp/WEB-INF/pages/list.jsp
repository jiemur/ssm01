<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2019/1/9
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${uname}
<form>
    <input type="text" name="username">
    <input type="submit"  value="查询">
</form>
<table>
   <thead>
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>tele</th>
        </tr>
   </thead>
    <tbody>
    <c:forEach items="${lists}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.tele}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<ul style="list-style: none">
<c:choose>
    <c:when test="${page.pages>0}">
        <c:choose>
            <c:when test="${page.isFirstPage}">
                <li>首页</li>
                <li>上一页</li>
            </c:when>
            <c:otherwise>
                <li><a href="list.do?pageNum=1${uname}">首页</a></li>
                <li><a href="list.do?pageNum=${page.prePage}${uname}">上一页</a></li>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>
    
    <c:forEach items="${page.navigatepageNums}" var="i">
        <c:choose>
            <c:when test="${page.pageNum==i}">
                <li>${i}</li>
            </c:when>
            <c:otherwise>
                <li><a href="list.do?pageNum=${i}${uname}">${i}</a></li>
            </c:otherwise>
        </c:choose>



    </c:forEach>
    <c:choose>
        <c:when test="${page.pages>0}">
            <c:choose>
                <c:when test="${page.isLastPage}">
                    <li>尾页</li>
                    <li>下一页</li>
                </c:when>
                <c:otherwise>
                    <li><a href="list.do?pageNum=${page.nextPage}${uname}">下一页</a></li>
                    <li><a href="list.do?pageNum=${page.pages}${uname}">尾页</a></li>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

</ul>
<br>
${page}
</body>
</html>
