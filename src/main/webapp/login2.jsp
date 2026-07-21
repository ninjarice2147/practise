<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登入頁面</title>
</head>
<body>
    <h1>登入系統</h1>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>

    <form action="LoginPractise" method="post">
        <p>
            帳號：
            <input type="text" name="username">
        </p>

        <p>
            密碼：
            <input type="password" name="password">
        </p>

        <button type="submit">登入</button>
    </form>

    <p>
        <a href="register2">註冊新帳號</a>
    </p>
</body>
</html>