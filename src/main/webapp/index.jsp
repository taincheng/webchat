<!DOCTYPE html>

<script src="bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.js"></script>
<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.css" rel="stylesheet">

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<body>

<div class="jumbotron">
    <div class="container" align="center">
        <h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:49px">Web Chat</h2>
        <br>
        <div class="text-muted">欢迎来到聊天室</div>
        <br>
        <br>
        <p><a role="button" href="${pageContext.request.contextPath}/views/login.jsp" class="btn btn-success">登录</a></p>
        <p><a role="button" href="${pageContext.request.contextPath}/views/register.jsp" class="btn btn-success">注册</a></p>
    </div>
</div>
</body>
</html>
