package softwaredev2.todolist_webapp;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ToDoList_DB.Queries.UserListQueries;
import ToDoList_DB.Queries.UserQueries;
import ToDoList_DB.UserLists.UserList;
import ToDoList_DB.Users.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "newUserServlet", value = "/new_user")
public class NewUserServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newUsername = request.getParameter("newUsername");
        User user;
        UserList toDoList;

        try{
            UserQueries.query_insertNewUser(connectToDB(), newUsername);
            user = UserQueries.query_User(connectToDB(), newUsername);
            UserListQueries.query_insertNewList(connectToDB(), user.getUserID());
            toDoList = UserListQueries.query_getList(connectToDB(), user.getUserID());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("toDoList", toDoList);

        request.getRequestDispatcher("main_menu.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){
    }

    public void destroy() {
    }

    private static Connection connectToDB() throws SQLException, ClassNotFoundException {
        Connection newConnection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        newConnection = DriverManager.getConnection("jdbc:mysql://localhost/todolist_db", "ToDoListApp", "Java123");
        return newConnection;
    }
}