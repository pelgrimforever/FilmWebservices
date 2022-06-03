/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_locality_photolocations;

import film.BusinessObject.Logic.BLview_locality_photolocations;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_locality_photolocations;
import film.interfaces.servlet.IView_locality_photolocationsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_locality_photolocations_usecases;
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
@WebServlet(name="View_locality_photolocations_select", urlPatterns={"/film.View_locality_photolocations_select"})
public class View_locality_photolocations_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_locality_photolocations blview_locality_photolocations = new BLview_locality_photolocations();
        View_locality_photolocations_usecases view_locality_photolocationsusecases = new View_locality_photolocations_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_locality_photolocationsOperation.SELECT_ALL:
                    dataobject = view_locality_photolocationsusecases.get_all();
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
        return "view_locality_photolocations_select";
    }

}

