package softwaredev2.todolist_webapp;


import ToDoList_DB.Queries.UserQueries;
import ToDoList_DB.Users.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "mainMenuServlet", value = "/main_menu")
public class MainMenuServlet extends HttpServlet {
    User user;

    public void init(int userID) {
        try {
            user = UserQueries.query_User(connectToDB(), userID);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + user.getUserName() + "</h1>");
        out.println("</body></html>");
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
