/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_photo_firstlastdate;

import film.BusinessObject.Logic.BLview_photo_firstlastdate;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_photo_firstlastdate;
import film.interfaces.servlet.IView_photo_firstlastdateOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_photo_firstlastdate_usecases;
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
@WebServlet(name="View_photo_firstlastdate_select", urlPatterns={"/film.View_photo_firstlastdate_select"})
public class View_photo_firstlastdate_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_photo_firstlastdate_usecases view_photo_firstlastdateusecases = new View_photo_firstlastdate_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_photo_firstlastdateOperation.SELECT_ALL:
                    dataobject = view_photo_firstlastdateusecases.get_all();
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
        return "view_photo_firstlastdate_select";
    }

}

