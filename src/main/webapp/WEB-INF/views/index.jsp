<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 11.05.18
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>homepage</title>
</head>
<body>

<form:form method="post" modelAttribute="tweet">

    <form:input path="title" placeholder="title" />
    <form:errors path="title"/>
    <form:textarea path="tweetText" placeholder="tweetText"/>
    <form:errors path="tweetText"/>
    <form:hidden path="user" value="${id}"/>


    <input type="submit" value="save">
</form:form>

<ul>

    <c:forEach items="${tweets}" var="tweet">
    <li>
        <p>${tweet.title} </p>
        <p>${tweet.tweetText} </p>

</ul>
</li>
</c:forEach>
</ul>

</body>
</html>
