package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Database {
	
    protected Connection connectToDB()
    {
        // SQLite connection string
        String url = "jdbc:postgresql://127.0.0.1:5432/resturant_db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,"postgres","28631");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
