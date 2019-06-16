
import DataBase.DBQuery;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
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

public class download extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String fname = request.getParameter("fname");
        System.out.println("ggggggggggggggggggggggg" + fname);
        RequestDispatcher rd = null;
        String userName = session.getAttribute("downloadUserMail").toString();
        String data = "";
        String uploadedFileLocation ="C://ServerFile/";
        DBQuery db = new DBQuery();
        System.out.println("fname = " + fname);
        //fname = db.getData(userName, fname);
        System.out.println("fname = " + fname);
        System.out.println("uploadedFileLocation + fname = " + uploadedFileLocation + fname);
        try {
            BufferedReader br = null;
            FileReader fr1 = null;
            FileInputStream fis;
            LineNumberReader lnr1 = null;
            fis = new FileInputStream(uploadedFileLocation + fname);
            br = new BufferedReader(new InputStreamReader(fis));
            fr1 = new FileReader(uploadedFileLocation + fname);
            lnr1 = new LineNumberReader(fr1);
            while (lnr1.readLine() != null) {
                String line_content = br.readLine();
                data += line_content + "\n";
            }
          //  out.print(data);
          response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; fname=\"" + fname + "\"");
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(uploadedFileLocation + "/" + fname);
        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();


        session.setAttribute("DownloadFile", "File Download Successful!!!");
        rd = request.getRequestDispatcher("DownloadStatus.jsp");
        rd.forward(request, response);
  
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(download.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(download.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(download.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(download.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
