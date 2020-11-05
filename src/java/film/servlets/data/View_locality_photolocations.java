/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 29.3.2016 11:1
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_locality_photolocations;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_locality_photolocations;
import film.interfaces.servlet.IView_locality_photolocationsOperation;
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
 * @author Franky Laseure
 */
@WebServlet(name="View_locality_photolocations", urlPatterns={"/film.View_locality_photolocations"})
public class View_locality_photolocations extends SecurityDataServlet {
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
        BLview_locality_photolocations blview_locality_photolocations = new BLview_locality_photolocations();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_locality_photolocationsOperation.SELECT_ALL:
                            dataobject = blview_locality_photolocations.getView_locality_photolocationss();
                            break;
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
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
        return "view_locality_photolocations";
    }

}

