/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 31.11.2012 14:2
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.BLview_backupstatus;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_backupstatus;
import film.interfaces.servlet.IView_backupstatusOperation;
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
@WebServlet(name="View_backupstatus", urlPatterns={"/film.View_backupstatus"})
public class View_backupstatus extends SecurityDataServlet {
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
        BLview_backupstatus blview_backupstatus = new BLview_backupstatus();
        //boolean privateaccess = userprofile!=null && userprofile.privateaccess();
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    ArrayList backupstatuses;
                    switch(this.operation) {
                        case IView_backupstatusOperation.SELECT_ALL:
                            dataobject = blview_backupstatus.getView_backupstatuss();
                            break;
                        case IView_backupstatusOperation.SELECT_TOBACKUP:
                            backupstatuses = blview_backupstatus.getView_backupstatus_Allbackup();
                            dataobject = backupstatuses;
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
        return "view_backupstatus";
    }

}

