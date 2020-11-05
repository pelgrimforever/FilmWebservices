/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 20.8.2014 16:3
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_publicphotolocations;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_publicphotolocations;
import film.interfaces.servlet.IView_publicphotolocationsOperation;
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
@WebServlet(name="View_publicphotolocations", urlPatterns={"/film.View_publicphotolocations"})
public class View_publicphotolocations extends SecurityDataServlet {
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
        BLview_publicphotolocations blview_publicphotolocations = new BLview_publicphotolocations();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_publicphotolocationsOperation.SELECT_ALL:
                            dataobject = blview_publicphotolocations.getView_publicphotolocationss();
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
        return "view_publicphotolocations";
    }

}

