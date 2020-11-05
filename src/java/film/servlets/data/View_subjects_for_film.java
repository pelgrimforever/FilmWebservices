/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 31.11.2012 14:2
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_subjects_for_film;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_subjects_for_film;
import film.interfaces.servlet.IView_subjects_for_filmOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pelgrim
 */
@WebServlet(name="View_subjects_for_film", urlPatterns={"/film.View_subjects_for_film"})
public class View_subjects_for_film extends SecurityDataServlet {
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
        BLview_subjects_for_film blview_subjects_for_film = new BLview_subjects_for_film();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_subjects_for_filmOperation.SELECT_ALL:
                            dataobject = blview_subjects_for_film.getView_subjects_for_films();
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
        return "view_subjects_for_film";
    }

}

