<jsp:useBean id="toDoListItems" scope="request" class="java.lang.String"/>
<jsp:useBean id="user" scope="request" class="ToDoList_DB.Users.User"/>
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
        <p>${toDoListItems}</p>
    </div>
    <fieldset>
        <legend>Select an option</legend>
        <div>
            <input type="radio" id="addToDoItem" name="toDoListOptionRadio" value="addToDoItem">
            <label for="addToDoItem">Add To-Do Item</label>
        </div>
        <div>
            <input type="radio" id="completeItem" name="toDoListOptionRadio" value="completeItem">
            <label for="completeItem">Mark an item complete</label>
        </div>
        <div>
            <input type="radio" id="logout" name="toDoListOptionRadio" value="logout">
            <label for="logout">Log Out</label>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </fieldset>
</body>
</html>
