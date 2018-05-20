
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <firstName>Add new user</firstName>
</head>
<body>

<form:form method="post" modelAttribute="user">
    <form:errors path="*"/>

    <form:input path="userName" placeholder="userName" />
    <form:errors path="userName"/>
    <form:input path="password" placeholder="password"/>
    <form:errors path="password"/>
    <form:input path="email" placeholder="email"/>
    <form:errors path="email"/>
    <input type="submit" value="save">
</form:form>


</body>
</html>
