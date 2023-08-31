<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        p{
            display: inline;
        }
    </style>

</head>
<body>
<c:forEach items="${heroes}" var="hero">
    <div>
        <p>imię bohatera : ${hero.key};</p>
        <p>wiek bohatera: ${hero.value} lat </p>
    </div>
</c:forEach>
</body>
</html>
