<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: verbi
  Date: 02.04.2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h3>Product name: <c:out value="${product.productName}"/></h3>
<p>Description: <c:out value="${product.description}"/></p>
<p>Price: <c:out value="${product.price}"/></p>
</body>
</html>