/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 17.4.2022 17:53
 */

package film.servlets.raster_overviews;

import film.BusinessObject.Logic.BLraster_overviews;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.logicview.IRaster_overviews;
import film.interfaces.servlet.IRaster_overviewsOperation;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Raster_overviews_usecases;
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
@WebServlet(name="Raster_overviews_select", urlPatterns={"/film.Raster_overviews_select"})
public class Raster_overviews_select extends SecurityDataServlet {
//Metacoder: NO AUTHOMATIC UPDATE
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLraster_overviews blraster_overviews = new BLraster_overviews();
        Raster_overviews_usecases raster_overviewsusecases = new Raster_overviews_usecases(authenticated);
        try {
            switch(this.operation) {
                case IRaster_overviewsOperation.SELECT_ALL:
                    dataobject = raster_overviewsusecases.get_all();
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
        return "raster_overviews_select";
    }

}

