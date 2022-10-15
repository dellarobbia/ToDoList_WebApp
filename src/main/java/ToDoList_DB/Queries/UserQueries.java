package ToDoList_DB.Queries;

import ToDoList_DB.Users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQueries {
    public static User query_User(Connection dbConnection, int userID){
        try{
            PreparedStatement statement = dbConnection.prepareStatement("""
                SELECT user_id, username
                FROM users
                WHERE users.user_id = ?
            """);
            statement.setInt(1, userID);

            ResultSet results = statement.executeQuery();

            results.next();
            User user = new User(results.getInt(1), results.getString(2));

            dbConnection.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static User query_User(Connection dbConnection, String username){
        try{
            PreparedStatement statement = dbConnection.prepareStatement("""
                SELECT user_id, username
                FROM users
                WHERE users.username = ?
            """);
            statement.setString(1, username);

            ResultSet results = statement.executeQuery();

            results.next();
            User user = new User(results.getInt(1), results.getString(2));

            dbConnection.close();

            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void query_insertNewUser(Connection dbConnection, String username){
        try{
            PreparedStatement statement = dbConnection.prepareStatement("""
                INSERT INTO users VALUES(null, ?)
            """);
            statement.setString(1, username);

            statement.executeUpdate();
            dbConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
