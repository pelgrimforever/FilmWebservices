/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 14.5.2016 12:24
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_photodatespublic;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_photodatespublic;
import film.interfaces.servlet.IView_photodatespublicOperation;
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
@WebServlet(name="View_photodatespublic", urlPatterns={"/film.View_photodatespublic"})
public class View_photodatespublic extends SecurityDataServlet {
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
        BLview_photodatespublic blview_photodatespublic = new BLview_photodatespublic();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IView_photodatespublicOperation.SELECT_ALL:
                            dataobject = blview_photodatespublic.getView_photodatespublics();
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
        return "view_photodatespublic";
    }

}

