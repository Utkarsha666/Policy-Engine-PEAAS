
import DataBase.DBQuery;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;

            String email = request.getParameter("email");
            String pwd = request.getParameter("password");
            DBQuery db = new DBQuery();

            System.out.println("email " + email);
            String utype = db.insertLoginData(email, pwd);

            System.out.println("utype " + email);
            if (utype.equalsIgnoreCase("user")) {
                session.setAttribute("downloadUserMail", email);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                session.setAttribute("uid", email);
                rd = request.getRequestDispatcher("UserHome.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("Owner")) {
                session.setAttribute("downloadUserMail", email);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                session.setAttribute("oid", email);
                rd = request.getRequestDispatcher("OwnerHome.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("CEO")) {
                session.setAttribute("downloadUserMail", email);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                session.setAttribute("cid", email);
                rd = request.getRequestDispatcher("CEOHome.jsp");
                rd.forward(request, response);
            } else if (utype.equalsIgnoreCase("Manager")) {
                session.setAttribute("downloadUserMail", email);
                session.setAttribute("log", email + " Your Login Successfull!!!");
                session.setAttribute("mid", email);
                rd = request.getRequestDispatcher("ManagerHome.jsp");
                rd.forward(request, response);
            } else {

                session.setAttribute("UnLog", email + " Your Login Unsuccessfull!!!");
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