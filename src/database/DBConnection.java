package database;

import java.sql.*;
/**
 * Created by Eric on 09/04/2019.
 */
public class DBConnection {

    public java.sql.Connection getConnection() {

        try {
            /*String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=asset_manager;integratedSecurity=true;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");*/
            java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/student_grades", "postgres", "Baraza2011");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
