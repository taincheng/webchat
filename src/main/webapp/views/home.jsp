<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Old_man
  Date: 2019/8/5
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
    <script src="${pageContext.request.contextPath}/bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap/3.3.6/bootstrap.js"></script>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">
    <title>聊天室主页</title>
</head>
<body>

<div class="panel panel-default">
    <div class="panel-heading">
        <h2 class="red-text text-center">欢迎来到${username}聊天室</h2>
        <a href="/userlogout/${username}">logout</a>
    </div>
    <div class="panel-body">
        <div class="container">
            <div class="row">
                <div class="col-xs-2">
                    <div class="onlineUser">
                        <table class="table">
                            <thead><tr><th style="color: darkred">在线人员</th></tr></thead>
                            <c:forEach items="${onlineUser}" var="online" >
                                    <tbody><tr><td>${online}</td></tr></tbody>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="col-xs-2">

                </div>
                <div class="col-xs-4">
                    <div class="privateChat">
                        <div class="content private-content">
                                <%
                                    if(null != session.getAttribute("talkname")){
                                        String s = (String) session.getAttribute("talkname");
                                        List privateChat = (List) application.getAttribute(s);
                                        for (Object pc : privateChat){
                                %>
                                    <div><%=pc.toString()%></div>
                                <%
                                        }
                                    }
                                %>
                        </div>
                        <br>
                        <div>
                            <form class="form-inline" action="/privateChat" method="post">
                                <input type="hidden" name="whochat" value="${username}">
                                <input class="form-control" type="text" size="5" name="chatwho" placeholder="chat who">
                                <input class="form-control" type="text" size="15" name="saywhat" placeholder="input chat">
                                <input class="btn btn-primary" type="submit" value="enter">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="publicChat">
                        <div class="content public-content">
                            <iframe class="iframepub" src="${pageContext.request.contextPath}/views/pubmessage.jsp" width="100%" height="100%" frameborder="0"></iframe>
                        </div>
                        <br>
                        <div>
                            <form class="form-inline" action="/publicChat" method="post">
                                <input type="hidden" name="whochat" value="${username}">
                                <input class="form-control" type="text" size="20" name="saywhat" placeholder="input chat">
                                <input class="btn btn-primary" type="submit" value="enter">
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>
</body>
<style>
    div.panel-body{
        height: 80%;
    }

    div.content{
        height: 80%;
        border:1px solid #000
    }
</style>
</html>
