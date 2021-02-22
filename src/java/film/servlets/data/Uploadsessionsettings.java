/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IUploadsessionsettings;
import film.interfaces.servlet.IUploadsessionsettingsOperation;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
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
@WebServlet(name="Uploadsessionsettings", urlPatterns={"/film.Uploadsessionsettings"})
public class Uploadsessionsettings extends SecurityDataServlet {
   
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
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        bluploadsessionsettings.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IUploadsessionsettingsPK uploadsessionsettingsPK;
                    IUploadsessionsettings uploadsessionsettings;
                    switch(this.operation) {
                        case IUploadsessionsettingsOperation.SELECT_ALL:
                            dataobject = bluploadsessionsettings.getUploadsessionsettingss();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettingsPK = (IUploadsessionsettingsPK)parser.getJavaObject("uploadsessionsettingspk");
                            dataobject = bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCH:
                            IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)parser.getJavaObject("search");
                            dataobject = bluploadsessionsettings.search(search);
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)parser.getJavaObject("search");
                            dataobject = bluploadsessionsettings.searchcount(uploadsessionsettingssearch);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IUploadsessionsettingsOperation.INSERT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)parser.getJavaObject("uploadsessionsettings");
                            bluploadsessionsettings.insertUploadsessionsettings(uploadsessionsettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IUploadsessionsettingsOperation.UPDATE_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)parser.getJavaObject("uploadsessionsettings");
                            bluploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IUploadsessionsettingsOperation.DELETE_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)parser.getJavaObject("uploadsessionsettings");
                            bluploadsessionsettings.deleteUploadsessionsettings(uploadsessionsettings);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IUploadsessionsettingsOperation.DELETE_ALL:
                            bluploadsessionsettings.deleteall(this.getServletName());
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
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
        return "uploadsessionsettings";
    }

}

