/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_countryphotocount;

import film.BusinessObject.Logic.BLview_countryphotocount;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_countryphotocount;
import film.interfaces.servlet.IView_countryphotocountOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_countryphotocount_usecases;
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
@WebServlet(name="View_countryphotocount_select", urlPatterns={"/film.View_countryphotocount_select"})
public class View_countryphotocount_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_countryphotocount_usecases view_countryphotocountusecases = new View_countryphotocount_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_countryphotocountOperation.SELECT_ALL:
                    dataobject = view_countryphotocountusecases.get_all();
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
        return "view_countryphotocount_select";
    }

}

