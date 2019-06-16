
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


public class verifyFile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;

            String fileName = request.getParameter("fileName");
            session.setAttribute("fileName", fileName);


            DBQuery db = new DBQuery();

            String securityLevel = db.verifyFile(fileName);

            System.out.println("securityLevel ====="+securityLevel);
            
            if (securityLevel.equalsIgnoreCase("Low Security")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("uid", "Your file is available");
                rd = request.getRequestDispatcher("loginVerification.jsp");
                rd.forward(request, response);

            } else if (securityLevel.equalsIgnoreCase("Medium Security")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("uid", "Your file is available");
                rd = request.getRequestDispatcher("SecurityVerification.jsp");
                rd.forward(request, response);

            } else if (securityLevel.equalsIgnoreCase("High Security")) {
                session.setAttribute("fileName", fileName);
                session.setAttribute("uid", "Your file is available");
                rd = request.getRequestDispatcher("HighSecurityVerification.jsp");
                rd.forward(request, response);

            } else {

                session.setAttribute("UnLog", " Sorry, Your file is Unavailable!!!");
                rd = request.getRequestDispatcher("FileDownload.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(verifyFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(verifyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
