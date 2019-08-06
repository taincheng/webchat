<%--
  Created by IntelliJ IDEA.
  User: Old_man
  Date: 2019/8/6
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<c:forEach items="${publicChatAll}" var="chat">
    <div style="font-size: 18px;color: #2aabd2">${chat}</div>
</c:forEach>
<%
    response.setHeader("refresh","2");
%>
</body>
</html>
