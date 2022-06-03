/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_publicphotolocations;

import film.BusinessObject.Logic.BLview_publicphotolocations;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_publicphotolocations;
import film.interfaces.servlet.IView_publicphotolocationsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_publicphotolocations_usecases;
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
@WebServlet(name="View_publicphotolocations_select", urlPatterns={"/film.View_publicphotolocations_select"})
public class View_publicphotolocations_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_publicphotolocations blview_publicphotolocations = new BLview_publicphotolocations();
        View_publicphotolocations_usecases view_publicphotolocationsusecases = new View_publicphotolocations_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_publicphotolocationsOperation.SELECT_ALL:
                    dataobject = view_publicphotolocationsusecases.get_all();
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
        return "view_publicphotolocations_select";
    }

}

