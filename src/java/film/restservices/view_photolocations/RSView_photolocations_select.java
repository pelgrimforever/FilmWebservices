/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.view_photolocations;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_photolocations;
import film.interfaces.servlet.IView_photolocationsOperation;
import film.usecases.View_photolocations_usecases;
import film.logicview.View_photolocations;
import film.servlets.DataServlet;
import film.usecases.custom.*;
import general.exception.*;
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
@Path("rsview_photolocations_select")
public class RSView_photolocations_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_photolocations_usecases view_photolocationsusecases = new View_photolocations_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_photolocationsOperation.SELECT_ALL:
                    result = get_all_view_photolocations(view_photolocationsusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_photolocationsOperation.SECURESELECT_ALL:
                    result = select_private_locations(view_photolocationsusecases);
                    break;
                case IView_photolocationsOperation.SELECT_LOCALITY:
                    result = select_for_locality(view_photolocationsusecases, json);
                    break;
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
    private String select_private_locations(View_photolocations_usecases view_photolocationsusecases) throws ParseException, CustomException {
        ArrayList<View_photolocations> locations = view_photolocationsusecases.select_private_locations(loggedin);
        return JSONView_photolocations.toJSONArray(locations).toJSONString();
    }

    private String select_for_locality(View_photolocations_usecases view_photolocationsusecases, JSONObject json) throws ParseException, CustomException {
        String countrycode = (String)json.get("countrycode");
        String locality = (String)json.get("locality");
        ArrayList<View_photolocations> locations = view_photolocationsusecases.select_4_locality(loggedin, countrycode, locality);
        return JSONView_photolocations.toJSONArray(locations).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_photolocations(View_photolocations_usecases view_photolocationsusecases) throws ParseException, CustomException {
    	return JSONView_photolocations.toJSONArray(view_photolocationsusecases.get_all()).toJSONString();
    }
}

