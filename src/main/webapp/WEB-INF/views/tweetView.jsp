<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <p>${tweet.title} </p>
        <p>${tweet.tweetText} </p>
        <p>${tweet.user} </p>
        <p> comments:
        </p>

        <ul>

            <c:forEach items="${comments}" var="comment">
            <li>
                <p>${comment.user} </p>
                <p>${comment.text} </p>
                <p>${comment.created} </p>

</ul>
</li>
</c:forEach>
</ul>

add new comment for this tweet:

        //podac reszte parametrow?
        <form:form method="post" modelAttribute="comment">
            <form:errors path="*"/>
            <form:textarea path="text" placeholder="text"/>

            <input type="submit" value="post comment">
        </form:form>

</body>
</html>
