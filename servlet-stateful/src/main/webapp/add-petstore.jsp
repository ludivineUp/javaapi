<%--
  Created by IntelliJ IDEA.
  User: ludivine
  Date: 31/03/2022
  Time: 09:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une animalerie</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <form method="POST" action="petstores">
        <input type="text" id="name" name="name"/>
        <input type="submit"/>
    </form>
</body>
</html>
