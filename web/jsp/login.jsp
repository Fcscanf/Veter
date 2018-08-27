<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2018/4/28
  Time: 下午 22:57
  To change this template use File | Settings | File Templates.
  登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>
</head>
<body>
<h3>登录</h3>
<hr>
<form method="post" border="1" align="center" width="50%" id="loginForm" action="${pageContext.request.contextPath}/user">
    <input type="hidden" name="method" value="login">
    用户名：<input type="text" name="username"/><br>
    密&nbsp;码:<input type="password" name="password"/><br>
    <input type="checkbox" name="remember" value="on" />记住用户
    <input type="checkbox" name="autologin" value="on" />自动登陆<br>
    <!--input type="submit" value="登录"-->
    <a href='/index.html'>登录</a>
    <input type="reset" value="重置">
    <a href='/jsp/regist.jsp'>注册</a>
</form>
</body>
</html>
