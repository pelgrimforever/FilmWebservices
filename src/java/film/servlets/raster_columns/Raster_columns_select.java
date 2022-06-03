/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.raster_columns;

import film.BusinessObject.Logic.BLraster_columns;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IRaster_columns;
import film.interfaces.servlet.IRaster_columnsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Raster_columns_usecases;
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
@WebServlet(name="Raster_columns_select", urlPatterns={"/film.Raster_columns_select"})
public class Raster_columns_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLraster_columns blraster_columns = new BLraster_columns();
        Raster_columns_usecases raster_columnsusecases = new Raster_columns_usecases(authenticated);
        try {
            switch(this.operation) {
                case IRaster_columnsOperation.SELECT_ALL:
                    dataobject = raster_columnsusecases.get_all();
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
        return "raster_columns_select";
    }

}

