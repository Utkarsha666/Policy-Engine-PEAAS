package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; //statement is an interface

public class DBQuery {

    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;

    public int insertData(String name, String address, String email, String city, String username, String pwd) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "insert into registration values('" + name + "','" + address + "','" + email + "','" + city + "','" + username + "','" + pwd + "')";
        i = stmt.executeUpdate(s);//update the stmt in the database 


        String l = "insert into login_details values('" + email + "','" + pwd + "','user')";
        stmt.executeUpdate(l);

        return i;

    }

    public int paymentGateWay(String holderName, String cardNo, String month, String year) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        String s = "insert into payment_mode values('" + holderName + "','" + cardNo + "','" + month + "','" + year + "')";
        i = stmt.executeUpdate(s);


        return i;

    }

    public String insertLoginData(String email, String pwd) throws ClassNotFoundException, SQLException {
        String utype = "";
        String s = "select * from login_details where email='" + email + "' and pwd='" + pwd + "'";
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s);
        while (rs.next()) {

            utype = rs.getString("utype");
        }
        return utype;
    }

    public String getData(String userName, String fname) throws ClassNotFoundException, SQLException {
        String fileName = "";
        String s = "select file from file_upload where name='" + fname + "'";
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s); //execute method from statement
        while (rs.next()) {

            fileName = rs.getString(1);
        }
        return fileName;
    }

    public String securityLoginData(String email, String pwd) throws ClassNotFoundException, SQLException {
        String utype = "";
        String s = "select * from login_details where email='" + email + "' and pwd='" + pwd + "'";
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s); //execute method from statement
        while (rs.next()) {

            utype = rs.getString("utype");
        }
        return utype;
    }
    public String securityFileData(String fileName) throws ClassNotFoundException, SQLException {
        String file = "";
        String s = "select hash_value from file_upload where name='" + fileName + "'";
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s); //execute method from statement
        while (rs.next()) {

            file = rs.getString("hash_value");
            
            
            System.out.println("cccccccccccccccccccccccccccccccccccccccccccccc================"+file);
        }
        return file;
    }

    public ResultSet securityData(String security_key, String hash_value) throws ClassNotFoundException, SQLException {
        System.out.println("security_key  hash_value = " + security_key + " " + hash_value);

        String s = "select * from file_upload where file='"+hash_value+"' and f_key='"+security_key+"'";
        System.out.println("s = " + s);
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s);
        return rs;
    }
    public ResultSet high_securityData(String public_key, String hash_value) throws ClassNotFoundException, SQLException {
       
        String s = "select * from file_upload where file='" + hash_value + "' and pubKey='" + public_key + "'";
        System.out.println("s------------------------------- " + s);
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s);
        return rs;
    }

    public ResultSet getDownloadData() throws ClassNotFoundException, SQLException {

        String s = "select * from login_details";
        con = DBConnection.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(s); //execute method from statement

        return rs;
    }

    public int ceoData(String name, String address, String email, String city, String username, String pwd) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "insert into ceo_reg values('" + name + "','" + address + "','" + email + "','" + city + "','" + username + "','" + pwd + "')";
        i = stmt.executeUpdate(s);//update the stmt in the database 


        String l = "insert into login_details values('" + email + "','" + pwd + "','CEO')";
        stmt.executeUpdate(l);
        return i;

    }

    public int insertManagerData(String name, String companyName, String departmentName, String email, String city, String user_name, String pwd) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "insert into manager_reg values('" + name + "','" + companyName + "','" + departmentName + "','" + email + "','" + city + "','" + user_name + "')";
        i = stmt.executeUpdate(s);//update the stmt in the database 


        String l = "insert into login_details values('" + email + "','" + pwd + "','Manager')";
        stmt.executeUpdate(l);

        return i;

    }

    public int addManagerData(String name, String companyName, String departmentName, String email, String city, String user_name, String pwd) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "insert into manager_reg values('" + name + "','" + companyName + "','" + departmentName + "','" + email + "','" + city + "','" + user_name + "')";
        i = stmt.executeUpdate(s);//update the stmt in the database 


        String l = "insert into login_details values('" + email + "','" + pwd + "','Manager')";
        stmt.executeUpdate(l);

        return i;

    }

    public int fileUpload(String name, String file, String keyss, String hash_value, String pubKey,/* String private_key, */String security, String file_cost) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "insert into file_upload values('" + name + "','" + file + "','" + keyss + "','" + hash_value + "','" + pubKey + "', '" + security + "', '" + file_cost + "')";
        System.out.println("s = " + s);
        i = stmt.executeUpdate(s);//

        return i;

    }

    public String verifyFile(String fileName) throws ClassNotFoundException, SQLException {

        String securityLevel = "";
        con = DBConnection.getConnection(); //establish database connection 
        stmt = con.createStatement(); //creating statement 
        String s = "select * from file_upload where name='" + fileName + "'";
        rs = stmt.executeQuery(s);//
        while (rs.next()) {
            securityLevel = rs.getString("security");
            System.out.println("securityLevel = " + securityLevel);

        }
        return securityLevel;

    }
}
