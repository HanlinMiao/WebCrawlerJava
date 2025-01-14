package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Singleton Class --> Objected Oriented Programming Pattern
    // Class with only single instance
    // Because when we are setting up the connection from Java to MySQL
    // It is a costly operation and having multiple connections are not necessary
    static Connection connection = null;
    public static Connection getConnection() {
        // if pre-existing connection exists
        // return the existing connection
        if (connection != null) {
            return connection;
        }
        String user ="root";
        String password = "Miao%980505";
        String db_name = "searchengineapp";
        return getConnection(user, password, db_name);
    }

    private static Connection getConnection(String user, String password, String db_name) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/searchengineapp?user=root&password=Miao$980505");
        }
        catch (SQLException | ClassNotFoundException Exception) {
            Exception.printStackTrace();
        }
        return connection;
    }
}
