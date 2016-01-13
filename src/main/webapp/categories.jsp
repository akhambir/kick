<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%@ include file="prefixes.jsp"%>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <c:forEach var="category" items="${categories}">
        <ul>
            <li> <a href="categories?category=<c:out value="${category.id}"/>"> <c:out value="${category.categoryName}"/> </a></li>
        </ul>
    </c:forEach>

    <c:forEach var="project" items="${projects}">
        <ul>
            <li> <a href="project?project=<c:out value="${project.id}"/>"> <c:out value="${project.projectName}"/> </a></li>
        </ul>
    </c:forEach>
    <%--<form action="categories.jsp" method="post">--%>
        <%--<input type="text" name = "category_name">--%>
        <%--<br>--%>
        <%--<input type="submit" value="Create">--%>
    <%--</form>--%>
</body>
</html>
