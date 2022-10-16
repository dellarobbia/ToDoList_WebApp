<jsp:useBean id="toDoListHTML" scope="request" class="java.lang.String"/>
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
    <div title="toDoListItems">
        <p>${toDoListHTML}</p>
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
        <input type="button" value="Log Out" onclick="window.location='/index.jsp'"/>
    </fieldset>
</body>
</html>
