<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--
  Created by IntelliJ IDEA.
  User: verbi
  Date: 09.03.2019
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Category</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>Category name <c:out value="${category.categoryName}"/></h3>--%>
<%--<p>Description:<c:out value="${category.description}"/></p>--%>
<%--<c:forEach items="${category.products}" var="p">--%>
    <%--<p>Products:<a href="<c:url value="/servlet/product?p_id=${p.id}"/>"> <c:out value="${p.productName}"/></a>--%>
        <%--<c:out value="${p.productName}"/></p>--%>
<%--</c:forEach>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>

<h3>Category name: <c:out value="${category.categoryName}"/></h3>
<p>Description: <c:out value="${category.description}"/></p>
<c:forEach items="${category.products}" var="p">
    <p>Products:<a href="<c:url value="/servlet/product?p_id=${p.id}"/>">
        <c:out value="${p.productName}"/></a></p>
</c:forEach>

</body>
</html>