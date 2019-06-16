package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection con = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");//Loads the jdbc driver class
        //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_data_base", "root", "root"); //establish connection
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/policy_data_base", "root", "root123"); //establish connection
        return con;

    }
}
