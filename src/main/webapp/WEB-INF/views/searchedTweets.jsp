<%--
  Created by IntelliJ IDEA.
  User: m3ksyk
  Date: 11.05.18
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>searched tweets</title>
</head>
<body>


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
