
import DataBase.DBQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LowSecurityVerification extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;


            String fileName = request.getParameter("fileName");
            String email = request.getParameter("email");
            String pwd = request.getParameter("password");
            DBQuery db = new DBQuery();

            System.out.println("email " + email);
            String utype = db.securityLoginData(email, pwd);
            String fileData = db.securityFileData(fileName);

            System.out.println("utype " + email);
            if (utype.equalsIgnoreCase("user")) {
                System.out.println("kkkkkkkkkkkkcming");
                session.setAttribute("log", email + " Your Login Successfull!!!");
                session.setAttribute("uid", email);
                session.setAttribute("fileName", fileName);
                session.setAttribute("fileData", fileData);
                rd = request.getRequestDispatcher("FileDownload_low.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("Owner")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                rd = request.getRequestDispatcher("FileDownload_low.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("CEO")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("fileData", fileData);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                rd = request.getRequestDispatcher("FileDownload_low.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("Manager")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("fileData", fileData);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                rd = request.getRequestDispatcher("FileDownload_low.jsp");
                rd.forward(request, response);
            } else {

                session.setAttribute("UnLog", email + " Your Login Verification Is Unsuccessfull!!!");
                rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}