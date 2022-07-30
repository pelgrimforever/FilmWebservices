/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 28.6.2022 19:49
 */

package film.servlets.geography_columns;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IGeography_columns;
import film.interfaces.servlet.IGeography_columnsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Geography_columns_usecases;
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
@WebServlet(name="Geography_columns_select", urlPatterns={"/film.Geography_columns_select"})
public class Geography_columns_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        Geography_columns_usecases geography_columnsusecases = new Geography_columns_usecases(authenticated);
        try {
            switch(this.operation) {
                case IGeography_columnsOperation.SELECT_ALL:
                    dataobject = geography_columnsusecases.get_all();
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
        return "geography_columns_select";
    }

}

