/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_locationtree;

import film.BusinessObject.Logic.BLview_locationtree;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_locationtree;
import film.interfaces.servlet.IView_locationtreeOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_locationtree_usecases;
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
@WebServlet(name="View_locationtree_select", urlPatterns={"/film.View_locationtree_select"})
public class View_locationtree_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_locationtree blview_locationtree = new BLview_locationtree();
        View_locationtree_usecases view_locationtreeusecases = new View_locationtree_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_locationtreeOperation.SELECT_ALL:
                    dataobject = view_locationtreeusecases.get_all();
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
        return "view_locationtree_select";
    }

}

