<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>
        <h1>The name and value of cookies only from ListOfCookies</h1>
    </legend>
    <c:forEach items="${cookieList}" var="myCookie">
        <div>
            <strong>Cookie name: </strong><p>${myCookie.name}</p>
            <strong>Cookie value: </strong><p> ${myCookie.value}</p><br><br>
        </div>
    </c:forEach>
</fieldset>
</body>
</html>
