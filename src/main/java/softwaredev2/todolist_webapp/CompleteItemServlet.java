package softwaredev2.todolist_webapp;

import ToDoList_DB.Queries.ListItemQueries;
import ToDoList_DB.Queries.UserListQueries;
import ToDoList_DB.UserLists.ToDoListItem;
import ToDoList_DB.UserLists.UserList;
import ToDoList_DB.Users.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "completeItemServlet", value = "/complete_item")
public class CompleteItemServlet extends HttpServlet {
    public void init(){
        
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        
        UserList toDoList = (UserList) session.getAttribute("toDoList");
        User user = (User) session.getAttribute("user");

        int listAddress = Integer.parseInt(request.getParameter("listAddress"));
        ToDoListItem completedItem = toDoList.getUserListItems().get(listAddress - 1);

        try{
            ListItemQueries.query_updateCompletedStatus(connectToDB(), toDoList.getUserListID(), completedItem);
            toDoList = UserListQueries.query_getList(connectToDB(), user.getUserID());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("toDoList", toDoList);

        request.getRequestDispatcher("main_menu.jsp").forward(request, response);
    }

    private static Connection connectToDB() throws SQLException, ClassNotFoundException {
        Connection newConnection;
        Class.forName("com.mysql.cj.jdbc.Driver");
        newConnection = DriverManager.getConnection("jdbc:mysql://localhost/todolist_db", "ToDoListApp", "Java123");
        return newConnection;
    }
}
