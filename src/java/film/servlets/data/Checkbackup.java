package film.servlets.data;

import film.BusinessObject.Logic.BLfilm;
import film.usecases.Film_usecases;
import general.exception.CustomException;
import general.exception.DBException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name = "Checkbackup", urlPatterns = {"/Checkbackup"})
public class Checkbackup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<String> list = null;
        String errormessage = null;
        try {
            Film_usecases filmusecases = new Film_usecases();
            list = filmusecases.Checkbackup();
        }
        catch(DBException e) {
            errormessage = e.getDetailedMessage();
        }
        catch(CustomException e) {
            errormessage = e.getDetailedMessage();
        }
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Checkbackup</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Checkbackup at " + request.getContextPath() + "</h1>");
            String line;
            Iterator<String> listI = list.iterator();
            while(listI.hasNext()) {
                line = listI.next();
                out.println(line + "<br>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
