package film.servlets.data;

import film.BusinessObject.Logic.BLsubjectcat;
import general.exception.CustomException;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Userprofile_select", urlPatterns={"/film.Userprofile_select"})
public class Userprofile_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        this.sendData(response, userprofile);
    } 

    @Override
    public String getServletInfo() {
        return "User profile";
    }

}
