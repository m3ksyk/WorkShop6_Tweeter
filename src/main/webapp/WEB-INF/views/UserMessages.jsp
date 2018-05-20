<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Messages</title>
</head>
<body>

przetestowac czy substring dziala, dorobic bold nieczytanych msg

inbox:
<ul>

    <c:forEach items="${received}" var="r">
    <li>
        <p> From: ${r.sender} </p>
        <p> Time: ${r.created} </p>
        <p>${r.text} </p>
        <p> ${fn:substring(s.text, 0, 30)} </p>


</ul>
</li>
</c:forEach>
</ul>

outbox:
<ul>

    <c:forEach items="${sent}" var="s">
    <li>
        <p> to: ${s.receiver} </p>
        <p> Time: ${s.created} </p>
        <p> ${s.text} </p>
        <p> ${fn:substring(s.text, 0, 30)} </p>

</ul>
</li>
</c:forEach>
</ul>


</body>
</html>
