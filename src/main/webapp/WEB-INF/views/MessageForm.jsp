<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send a message</title>
</head>
<body>
<form:form method="post" modelAttribute="message">

    <form:hidden path="sender" value="${id}" />
    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:textarea path="tweetText" placeholder="tweetText"/>
    <form:errors path="tweetText"/>
    To:
    <form:select path="receiver" items="${users}" itemLabel="userName" itemValue="id" placeholder="receiver" />
    <form:errors path="user"/>

    <input type="submit" value="save">
</form:form>

</body>
</html>
