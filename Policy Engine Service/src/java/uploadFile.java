
import Algorithm.AES_Algo;
import Algorithm.CheckData;
import Algorithm.CheckFileDetails;

import DataBase.DBQuery;
import Algorithm.HMAC;
import Algorithm.SHA_Algo;
import Algorithm.SplitFileAlgo;
import com.oreilly.servlet.MultipartRequest;
import data.encription.RSA_Algo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
public class uploadFile extends HttpServlet {

    String paramName = "";
    String name = "";
    String file = "";
    String dirName = "C://ServerFile";
    String security = "";
    String filePath = "";
    String paramname = "";
    String file2 = "";
    String fPath = "";
    String dataValue = "";
    String data = "";
    String hash_Value = "Not Required";
    private String key;
    private String dataValue1;
    String SecretKey = "Not Required";
    String pubKey = "Not Required";
    String private_key = "Not Required";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        RequestDispatcher rd = null;
        System.out.println(dirName);
        MultipartRequest multi = new MultipartRequest(request, dirName, 10 * 1024 * 1024); // 10MB
        Enumeration params = multi.getParameterNames();
        while (params.hasMoreElements()) {
            paramname = (String) params.nextElement();
            if (paramname.equalsIgnoreCase("fileName")) {
                name = multi.getParameter(paramname);
                 System.out.println(name);
            }
            if (paramname.equalsIgnoreCase("security")) {
                security = multi.getParameter(paramname);
                 System.out.println(security);
            }
        }
      
        Enumeration files = multi.getFileNames();
        while (files.hasMoreElements()) {
            paramname = (String) files.nextElement();
            if (paramname.equals("d1")) {
                paramname = null;
            }
            if (paramname != null && paramname.equals("file")) {
                int f = 1;
                filePath = multi.getFilesystemName(paramname);
                if (filePath == multi.getFilesystemName(paramname)) {
                }
                fPath = dirName + "/" + filePath;
            }
        }




        String fileName = fPath;System.out.println("fPath="+fPath);
           
        
        System.out.println("-----------------------------------------AES-------------------------------------");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");


        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        System.out.println("line >>>>>>>>><<<<<<<<<<<<<<<<<<<<<<");

        while ((line = bufferedReader.readLine()) != null) {

            stringBuffer.append(line).append("\n");
        }
        System.out.println("stringBuffer >>>>>>>>>:::::>>>>>>>>>>>>>>::  " + stringBuffer);
        String data = stringBuffer.toString();
        //  System.out.println("data>>>>>>   " + data);

//        ReasoningEngine re = new ReasoningEngine();
//        re.reasoningEngine(name, filePath, security);


        DBQuery dbq = new DBQuery();
        if (security.equalsIgnoreCase("Low Security")) {
            String hash_value = "Not Required.";
            File file4 = new File(fileName);
            long fileSize = file4.length();
            String fileCost = "" + (((double) fileSize / 1024) * 0.0010);
            session.setAttribute("fileCost", fileCost);

            key = "Not Required.";
            int h = dbq.fileUpload(name, filePath, key, hash_value, pubKey,/* private_key,*/ security, fileCost);
            session.setAttribute("upload", name + " Your upload Successfull!!!  "); //Save an attribute in session
            rd = request.getRequestDispatcher("SlaEngine.jsp"); //attribute is sent to index.jsp
            rd.forward(request, response);


        } else if (security.equalsIgnoreCase("Medium Security")) {

            KeyGenerator kgr = new KeyGenerator();
            String keys = kgr.KeyGenerator();
            key = "" + keys;
            File file4 = new File(fileName);
            System.out.println("name="+file4);
            long fileSize = file4.length();
            String fileCost = "" + (((double) fileSize / 1024) * 0.0065);
            AES_Algo aes = new AES_Algo();
            String sessionId = session.getId();
               System.out.println("sessionId="+sessionId);
           
            HMAC vfc = new HMAC();
            hash_Value = vfc.calculateCode(data, key);
            System.out.println("hash_Value="+hash_Value);
            
            System.out.println("hash_Value >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + hash_Value);


            dataValue = aes.encrypt(data, keys);
            System.out.println("" + dataValue);

            System.out.println("dataValue = " + dataValue);

            FileWriter writer1 = new FileWriter("C://ServerFile/EncryptedFile/" + "/" + filePath);
            BufferedWriter bw1 = new BufferedWriter(writer1); //C://ServerFile/EncryptedFile/
            {
                bw1.append(dataValue);
                bw1.append("\n");
            }
            bw1.close();
            writer1.close();

            System.out.println("key = " + key);
            session.setAttribute("fileCost", fileCost);
            System.out.println("filePath:: " + file + fPath);
            int h = dbq.fileUpload(name, filePath, key, hash_Value, pubKey,/*private_key,*/ security, fileCost);
            session.setAttribute("upload", "'" + name + "'" + " Your upload Successfull take down your Key and hash !!! " + key + "  ,   " + hash_Value); //Save an attribute in session
            rd = request.getRequestDispatcher("SlaEngine.jsp");
            rd.forward(request, response);
            System.out.println("split--------------------------");
            String division = "1";
            SplitFileAlgo sr = new SplitFileAlgo();
            int i = sr.splitRequest(filePath, division);
            System.out.println("");
            CheckFileDetails cfd = new CheckFileDetails();

            String paths = "C:/ServerFile/" + filePath + ".part1";
            cfd.checkFileDetails(paths);
        } else if (security.equalsIgnoreCase("High Security")) {
            KeyGenerator keygen = new KeyGenerator();
            SHA_Algo kgr = new SHA_Algo();
            String keys = kgr.SHA_Algo(dirName + "/" + filePath);
            CheckData pk = new CheckData();
            pubKey = pk.privateKey();
            System.out.println("pubKey = " + pubKey);
            
             // hash_Value = keygen.KeyGenerator();
            hash_Value = keys;
            
            File file4 = new File(fileName);
            long fileSize = file4.length();
            String fileCost = "" + (((double) fileSize / 1024) * 0.0125);
            session.setAttribute("fileCost", fileCost);
            String sessionId = session.getId();
            String sessionId2 = session.getId();
            System.out.println("sessionId = " + sessionId);
            System.out.println("sessionId2 = " + sessionId2);
            String SecretKey = sessionId + sessionId2;
            System.out.println("SecretKey = " + SecretKey);

            KeyGenerator kgr1 = new KeyGenerator();
            String keyss = kgr1.KeyGenerator();
            //private_key = "" + keyss;
            private_key = SecretKey;
            HMAC vfc = new HMAC();
            // hash_Value = vfc.calculateCode(data, key);
            RSA_Algo rsass = new RSA_Algo();
            key = "Not Required";
            String dats = data;
                System.out.println("data = " + dats);

            String encData = rsass.rsa_Algo(dats);
            System.out.println("encData = " + encData);
            System.out.println("encData = " + encData);
            System.out.println("encData = " + encData);
            System.out.println("dataValue = " + dataValue);
            System.out.println("dataValue = " + dataValue1);

            FileWriter writer1 = new FileWriter( "C://ServerFile/EncryptedFile" + "/" + filePath);
            BufferedWriter bw1 = new BufferedWriter(writer1); //C://ServerFile/EncryptedFile/
            {
                bw1.append(encData);
                bw1.append("\n");
            }
            bw1.close();
            writer1.close();

            System.out.println("key = " + hash_Value);

            System.out.println("filePaths:: " + file + fPath);

            // name,  file,  key,  hash_value,  pubKey,  private_key,  security,  file_cost
            int h = dbq.fileUpload(name, filePath, key, hash_Value, pubKey, /*private_key,*/ security, fileCost);
            session.setAttribute("upload", "'" + name + "'" + " Your upload Successfull take down your private key and public key  !!! " + SecretKey + " ," + pubKey); //Save an attribute in session
            session.setAttribute("upload1", "'" + name + "'" + " Your upload Successfull take down your hash value  !!! " + keys);
            rd = request.getRequestDispatcher("SlaEngine.jsp");
            rd.forward(request, response);
        } else {

            session.setAttribute("upload", name + " Your upload Unsuccessfull!!!");
            rd = request.getRequestDispatcher("SlaEngine.jsp");
            rd.forward(request, response);
        }
    }

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
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(uploadFile.class.getName()).log(Level.SEVERE, null, ex);
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
