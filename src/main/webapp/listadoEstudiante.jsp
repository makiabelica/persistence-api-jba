<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Estudiante</title>
</head>
<body>
    <h1>Listad de estudiante 😐</h1>
    <ul>
        <c:forEach items="${estudiantes}" var="estudiante">
            <li>${estudiante.carnet}  ${estudiante.nombre}</li>
        </c:forEach>
    </ul>
</body>
</html>