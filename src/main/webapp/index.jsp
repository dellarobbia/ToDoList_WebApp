<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List App</title>
</head>
<body>
<h1><%= "Welcome! Please enter your user ID# below:" %>
</h1>
<br/>
<h3>Existing Users</h3>
<form action="${pageContext.request.contextPath}/main_menu" method="post">
    <label>
        User ID#: <input type="text" name="userID">
    </label>
    <input type="submit" value="Start!">
</form>
<br/>
<h3>New users</h3>
<form action="${pageContext.request.contextPath}/new_user" method="post">
    <label>
        Enter a username: <input type="text" name="newUsername">
    </label>
    <input type="submit" value="Create New User">
</form>
</body>
</html>