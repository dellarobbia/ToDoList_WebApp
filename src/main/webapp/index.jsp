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
<form action="${pageContext.request.contextPath}/main_menu" method="post">
    <label>
        User ID#: <input type="text" name="userID">
    </label>
    <br/>
    <input type="submit" value="Start!">
</form>
<br/>
<p>New users click here:<a href="new_user">New User</a></p>
</body>
</html>