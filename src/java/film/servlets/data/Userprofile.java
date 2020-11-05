/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLsubjectcat;
import general.exception.CustomException;
import film.interfaces.servlet.IUserprofileOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pelgrim
 */
@WebServlet(name="Userprofile", urlPatterns={"/film.Userprofile"})
public class Userprofile extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        this.sendData(response, userprofile);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
