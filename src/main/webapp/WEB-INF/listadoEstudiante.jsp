<%--<%@taglib uri="http://java.sun.com/jsp/jsp/jstl/core" prefix="c" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Estudiante</title>
</head>
<body>
    <h1>Listad de estudiante 😐</h1>
    <ul>
        <c:forEach items="${estudiantes}" var="estudiante">
            <li>${estudiante.carnet}  ${estudiante.nombres}</li>
        </c:forEach>
    </ul>
</body>
</html>