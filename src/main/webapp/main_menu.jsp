<jsp:useBean id="toDoList" scope="session" class="ToDoList_DB.UserLists.UserList"/>
<jsp:useBean id="user" scope="session" class="ToDoList_DB.Users.User"/>
<%--
  Created by IntelliJ IDEA.
  User: drewm
  Date: 10/15/2022
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu</title>
</head>
<body>
    <h1>${user.getUserName()}'s To-Do List</h1>
    <h2>User ID# ${user.getUserID()}</h2>
    <div title="toDoListItems">
        <p>${toDoList.toHTML()}</p>
    </div>
    <fieldset>
        <legend>Actions</legend>
            <h3>Add Item</h3>
            <form action="${pageContext.request.contextPath}/add_item" method="post">
                <label>
                    Item To-Do: <input type="text" name="itemDescription">
                </label>
                <label>
                    Due Date: <input type="text" name="itemDueDate">
                </label>
                <input type="submit" value="Add Item">
            </form>
        <br/>
        <h3>Select an item to mark "complete"</h3>
        <form action="${pageContext.request.contextPath}/complete_item" method="post">
            <label>
                Item# to complete: <input type="text" name="listAddress">
            </label>
            <input type="submit" value="Complete Item">
        </form>
        <br/>
        <form action="${pageContext.request.contextPath}/logout" method="get">
            <input type="submit" value="Logout">
        </form>
    </fieldset>
</body>
</html>
