/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.raster_overviews;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IRaster_overviews;
import film.interfaces.servlet.IRaster_overviewsOperation;
import film.usecases.Raster_overviews_usecases;
import film.logicview.Raster_overviews;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsraster_overviews_select")
public class RSRaster_overviews_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IRaster_overviews raster_overviews;
            Raster_overviews_usecases raster_overviewsusecases = new Raster_overviews_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRaster_overviewsOperation.SELECT_ALL:
                    result = get_all_raster_overviews(raster_overviewsusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
	    }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private String get_all_raster_overviews(Raster_overviews_usecases raster_overviewsusecases) throws ParseException, CustomException {
    	return JSONRaster_overviews.toJSONArray(raster_overviewsusecases.get_all()).toJSONString();
    }
}

