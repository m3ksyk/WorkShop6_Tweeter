
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add tweet</title>
</head>
<body>

<form:form method="post" modelAttribute="tweet">

    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:textarea path="tweetText" placeholder="tweetText"/>
    <form:errors path="tweetText"/>
    User:
    <form:select path="user" items="${users}" itemLabel="firstName" itemValue="id" placeholder="user" />
    <form:errors path="user"/>

    <input type="submit" value="save">
</form:form>

</body>
</html>
