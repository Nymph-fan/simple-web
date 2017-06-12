<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>form表单</title>
</head>

<body>
<form action="<%=contextPath%>/servlet/DoFormServlet" method="post">
    <%--使用隐藏域存储生成的token--%>

    <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">


    用户名：<input type="text" name="username">
    <input type="submit" value="提交">
</form>
</body>
</html>