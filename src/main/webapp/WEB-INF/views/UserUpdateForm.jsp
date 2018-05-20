
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id" value="${id}" />
    <form:input path="password" placeholder="password"/>
    <form:errors path="password"/>
    <input type="submit" value="save">
</form:form>

</body>
</html>
