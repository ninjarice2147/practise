<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>註冊帳號</title>
</head>
<body>
    <h1>註冊帳號</h1>

    <%
        String error = (String) request.getAttribute("error");
        String message = (String) request.getAttribute("message");

        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }

        if (message != null) {
    %>
        <p style="color:green;"><%= message %></p>
    <%
        }
    %>

    <form action="register" method="post">
        <p>
            帳號：
            <input type="text" name="username">
        </p>

        <p>
            密碼：
            <input type="password" name="password">
        </p>

        <button type="submit">註冊</button>
    </form>

    <p>
        <a href="login">回登入頁</a>
    </p>
</body>
</html>