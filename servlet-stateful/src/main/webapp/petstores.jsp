<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 31/03/2022
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Mes animaleries</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <c:forEach items="${petStores}" var="ps">
        <p>${ps.id} : ${ps.name}</p>
    </c:forEach>
</body>
</html>
