<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:errors path="*"/>
    <form:input path="email" placeholder="email"/>
    <form:errors path="email"/>

    <form:input path="password" placeholder="password"/>
    <form:errors path="password"/>
    <input type="submit" value="log in">
</form:form>

<a href="/user/add"> add new user</a><br>


</body>
</html>
