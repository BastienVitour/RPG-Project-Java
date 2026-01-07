package main.java.rpg.settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {

        if(connection == null) {
            String url = "jdbc:postgresql://localhost:5432/Java_RPG";
            String username = "bastienvitour";
            String password = "";

            try {

                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Successfully connected to db");
                connection = conn;
                return connection;
            }
            catch(SQLException e) {
                System.out.println(e);
                return null;
            }
        }
        else {
            return connection;
        }
    }
}
