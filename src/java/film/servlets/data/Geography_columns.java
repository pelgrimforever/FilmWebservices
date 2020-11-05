/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 18.2.2013 17:43
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLgeography_columns;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IGeography_columns;
import film.interfaces.servlet.IGeography_columnsOperation;
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
@WebServlet(name="Geography_columns", urlPatterns={"/film.Geography_columns"})
public class Geography_columns extends SecurityDataServlet {
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
        BLgeography_columns blgeography_columns = new BLgeography_columns();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(this.operation) {
                        case IGeography_columnsOperation.SELECT_ALL:
                            dataobject = blgeography_columns.getGeography_columnss();
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
        return "geography_columns";
    }

}

