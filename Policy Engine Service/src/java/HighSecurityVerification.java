
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

public class HighSecurityVerification extends HttpServlet {

    String data = "";
    String uploadedFileLocation = System.getenv("OPENSHIFT_DATA_DIR");//"C://ServerFile/";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            String name = "";
            String file = "";
            String public_key = request.getParameter("public_key");
            String email = request.getParameter("email");
            System.out.println("email = " + email);
            String hash_value = request.getParameter("hash_value");
            DBQuery db = new DBQuery();

            System.out.println("hash_value " + hash_value);
            System.out.println("security_key, hash_value, email = " + public_key + " " + hash_value + " " + email);
            ResultSet rs = db.high_securityData(public_key, hash_value);
            while (rs.next()) {
                name = rs.getString("name");
                file = rs.getString("file");
            }
            System.out.println("rs = " + name + "  " + file);
            if (file != null) {
                session.setAttribute("log", " Your Key Verify Successfull!!!");
                session.setAttribute("name", name);
                session.setAttribute("file", file);
                session.setAttribute("uid", email);

                rd = request.getRequestDispatcher("FileDownload_2.jsp");
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