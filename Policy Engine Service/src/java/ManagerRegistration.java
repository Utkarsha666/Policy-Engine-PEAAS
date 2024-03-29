
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

public class ManagerRegistration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(); // creates a session id and returns current session
               RequestDispatcher rd = null;


               String name = request.getParameter("name"); //method for request object and getting the value from html fields
               String companyName = request.getParameter("companyName");
               String departmentName = request.getParameter("departmentName");
               String email = request.getParameter("email");
               String city = request.getParameter("city");
                String user_name = request.getParameter("user_name");
               String pwd = request.getParameter("password");

               DBQuery db = new DBQuery();
               int i = db.insertManagerData(name, companyName, departmentName, email,city, user_name, pwd);

               if (i != 0) {

                   session.setAttribute("reg", name + " Your Registration Successfull!!!"); //Save an attribute in session
                   rd = request.getRequestDispatcher("Registration.jsp"); //attribute is sent to index.jsp
                   rd.forward(request, response);
               }
               
              else {

                   session.setAttribute("reg", name + " Your Registration Unsuccessfull!!!");
                   rd = request.getRequestDispatcher("index.jsp");
                   rd.forward(request, response);
           
           
           
           
           
       }} catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

  }}
