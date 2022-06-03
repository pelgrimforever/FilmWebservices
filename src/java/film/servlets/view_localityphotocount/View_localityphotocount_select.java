/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_localityphotocount;

import film.BusinessObject.Logic.BLview_localityphotocount;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_localityphotocount;
import film.interfaces.servlet.IView_localityphotocountOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_localityphotocount_usecases;
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
@WebServlet(name="View_localityphotocount_select", urlPatterns={"/film.View_localityphotocount_select"})
public class View_localityphotocount_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLview_localityphotocount blview_localityphotocount = new BLview_localityphotocount();
        View_localityphotocount_usecases view_localityphotocountusecases = new View_localityphotocount_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_localityphotocountOperation.SELECT_ALL:
                    dataobject = view_localityphotocountusecases.get_all();
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
        return "view_localityphotocount_select";
    }

}

