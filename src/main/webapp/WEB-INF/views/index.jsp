<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
    <p>Welcome to our store Spring sercurity 4 </p>
    <c:if test="${not empty username}">
        <p>hello ${username}</p>
        <form action="<c:url value="/j_spring_security_logout" />" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" value="Logout" />
        </form>
    </c:if>
    <c:if test="${empty username}">
        <p>
            <a href="<%=request.getContextPath()%>/login">Login</a>
        </p>
    </c:if>
  </body>
</html>
