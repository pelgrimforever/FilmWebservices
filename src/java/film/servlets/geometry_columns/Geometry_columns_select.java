/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 28.6.2022 19:49
 */

package film.servlets.geometry_columns;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IGeometry_columns;
import film.interfaces.servlet.IGeometry_columnsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Geometry_columns_usecases;
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
@WebServlet(name="Geometry_columns_select", urlPatterns={"/film.Geometry_columns_select"})
public class Geometry_columns_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        Geometry_columns_usecases geometry_columnsusecases = new Geometry_columns_usecases(authenticated);
        try {
            switch(this.operation) {
                case IGeometry_columnsOperation.SELECT_ALL:
                    dataobject = geometry_columnsusecases.get_all();
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
        return "geometry_columns_select";
    }

}

