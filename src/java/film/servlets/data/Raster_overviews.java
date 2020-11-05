/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.2.2013 17:43
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLraster_overviews;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IRaster_overviews;
import film.interfaces.servlet.IRaster_overviewsOperation;
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
@WebServlet(name="Raster_overviews", urlPatterns={"/film.Raster_overviews"})
public class Raster_overviews extends SecurityDataServlet {
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
        BLraster_overviews blraster_overviews = new BLraster_overviews();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IRaster_overviewsOperation.SELECT_ALL:
                            dataobject = blraster_overviews.getRaster_overviewss();
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
        return "raster_overviews";
    }

}

