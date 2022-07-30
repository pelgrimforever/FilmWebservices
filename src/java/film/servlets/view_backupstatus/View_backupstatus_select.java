/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_backupstatus;

import film.BusinessObject.Logic.BLview_backupstatus;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_backupstatus;
import film.interfaces.servlet.IView_backupstatusOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_backupstatus_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="View_backupstatus_select", urlPatterns={"/film.View_backupstatus_select"})
public class View_backupstatus_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    View_backupstatus_usecases view_backupstatususecases;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        view_backupstatususecases = new View_backupstatus_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_backupstatusOperation.SELECT_ALL:
                    dataobject = view_backupstatususecases.get_all();
                    break;
                case IView_backupstatusOperation.SELECT_TOBACKUP:
                    dataobject = view_backupstatususecases.getView_backupstatus_Allbackup();
                    break;
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        this.sendData(response, dataobject);
    } 

    @Override
    public String getServletInfo() {
        return "view_backupstatus_select";
    }

}

