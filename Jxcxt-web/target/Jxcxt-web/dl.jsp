<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2020/8/18
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body{
        background-image: url("img/dl.jpg");
        background-size: cover;
    }
    table{
        margin-top: 350px;
        margin-left: 835px;
    }
    table tr td{
        text-align: center;
    }
</style>
<head>
    <title>登录</title>
</head>
<body>
    <form action="dl" method="post">
        <table>
            <tr><td><font color="#f0f8ff">用户名:</font></td><td><input type="text" name="yname"></td></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr><td><font color="#f0f8ff">密码:</font></td><td><input type="password" name="password"></td></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr><td><input type="submit" value="登录"></td><td><input type="reset" value="重置"></td></tr>
        </table>
    </form>
</body>
</html>
