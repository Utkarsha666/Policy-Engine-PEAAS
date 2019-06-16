

import DataBase.DBQuery;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityVerification extends HttpServlet {

    String data = "";
    String uploadedFileLocation="C://ServerFile/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            String name = "";
            String file = "";
            String security_key = request.getParameter("security_key");
            String email = request.getParameter("email");
            System.out.println("email = " + email);
            String hash_value = request.getParameter("hash_value");
            DBQuery db = new DBQuery();

            System.out.println("hash_value " + hash_value);
            System.out.println("security_key, hash_value, email = " + security_key + " " + hash_value + " " + email);
            ResultSet rs = db.securityData(security_key, hash_value);
            while (rs.next()) {
                name = rs.getString("name");
                file = rs.getString("hash_value");
            }
            System.out.println("utype " + security_key);
            if (file != null) {

                BufferedReader br = null;
                FileReader fr1 = null;
                FileInputStream fis;
                LineNumberReader lnr1 = null;
                fis = new FileInputStream(uploadedFileLocation + file);
                br = new BufferedReader(new InputStreamReader(fis));
                fr1 = new FileReader(uploadedFileLocation + file);
                lnr1 = new LineNumberReader(fr1);
                while (lnr1.readLine() != null) {
                    String line_content = br.readLine();
                    data += line_content + "\n";
                }

                    System.out.println("datattttttttttttttttttttt"+data);
                session.setAttribute("log", " Your Key Verify Successfull!!!");
                session.setAttribute("name", name);
                session.setAttribute("file", file);
                session.setAttribute("uid", email);
                session.setAttribute("data", data);
                
                rd = request.getRequestDispatcher("FileDownload_1.jsp");
                rd.forward(request, response);
            } else {

                session.setAttribute("log", " Your Key not Verify Successfull!!!");
                rd = request.getRequestDispatcher("FileDownload.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }




    }
}