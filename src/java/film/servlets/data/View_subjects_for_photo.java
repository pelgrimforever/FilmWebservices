/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 31.11.2012 14:2
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_subjects_for_photo;
import film.interfaces.servlet.IView_subjects_for_photoOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import general.exception.CustomException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pelgrim
 */
@WebServlet(name="View_subjects_for_photo", urlPatterns={"/film.View_subjects_for_photo"})
public class View_subjects_for_photo extends SecurityDataServlet {
//ProjectGenerator: NO AUTHOMATIC UPDATE
   
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

        Object dataobject = null;
        BLview_subjects_for_photo blview_subjects_for_photo = new BLview_subjects_for_photo();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_subjects_for_photoOperation.SELECT_ALL:
                            dataobject = blview_subjects_for_photo.getView_subjects_for_photos();
                            break;
                    }
                    break;
            }

        } 
        catch(CustomException e) {
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "view_subjects_for_photo";
    }

}

