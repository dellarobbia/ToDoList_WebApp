package softwaredev2.todolist_webapp;


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

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "mainMenuServlet", value = "/main_menu")
public class MainMenuServlet extends HttpServlet {
    User user;
    UserList toDoList;

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            user = UserQueries.query_User(connectToDB(), Integer.parseInt(request.getParameter("userID")));
            toDoList = UserListQueries.query_getList(connectToDB(), user.getUserID());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String toDoListHTML = toDoList.toString();
        toDoListHTML = toDoListHTML.replaceAll("(\n)", "<br/>");
        request.setAttribute("toDoListHTML", toDoListHTML);

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("toDoList", toDoList);
        request.getRequestDispatcher("main_menu.jsp").forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
