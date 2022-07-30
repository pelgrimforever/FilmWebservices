/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.view_publiclocalityphotocount;

import film.BusinessObject.Logic.BLview_publiclocalityphotocount;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IView_publiclocalityphotocount;
import film.interfaces.servlet.IView_publiclocalityphotocountOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.View_publiclocalityphotocount_usecases;
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
@WebServlet(name="View_publiclocalityphotocount_select", urlPatterns={"/film.View_publiclocalityphotocount_select"})
public class View_publiclocalityphotocount_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        View_publiclocalityphotocount_usecases view_publiclocalityphotocountusecases = new View_publiclocalityphotocount_usecases(authenticated);
        try {
            switch(this.operation) {
                case IView_publiclocalityphotocountOperation.SELECT_ALL:
                    dataobject = view_publiclocalityphotocountusecases.get_all();
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
        return "view_publiclocalityphotocount_select";
    }

}

