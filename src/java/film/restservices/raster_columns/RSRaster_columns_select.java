/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.raster_columns;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IRaster_columns;
import film.interfaces.servlet.IRaster_columnsOperation;
import film.usecases.Raster_columns_usecases;
import film.logicview.Raster_columns;
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
@Path("rsraster_columns_select")
public class RSRaster_columns_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IRaster_columns raster_columns;
            Raster_columns_usecases raster_columnsusecases = new Raster_columns_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRaster_columnsOperation.SELECT_ALL:
                    result = get_all_raster_columns(raster_columnsusecases);
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

    private String get_all_raster_columns(Raster_columns_usecases raster_columnsusecases) throws ParseException, CustomException {
    	return JSONRaster_columns.toJSONArray(raster_columnsusecases.get_all()).toJSONString();
    }
}

