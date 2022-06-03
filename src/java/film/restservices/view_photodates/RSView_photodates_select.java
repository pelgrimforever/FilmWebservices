/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.view_photodates;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_photodates;
import film.interfaces.servlet.IView_photodatesOperation;
import film.usecases.View_photodates_usecases;
import film.logicview.View_photodates;
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
@Path("rsview_photodates_select")
public class RSView_photodates_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IView_photodates view_photodates;
            View_photodates_usecases view_photodatesusecases = new View_photodates_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_photodatesOperation.SELECT_ALL:
                    result = get_all_view_photodates(view_photodatesusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_photodatesOperation.SECURE_SELECT_ALL:
                    result = get_private_photodates(view_photodatesusecases);
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
    private String get_private_photodates(View_photodates_usecases view_photodatesusecases) throws ParseException, CustomException {
        ArrayList<View_photodates> photodates = view_photodatesusecases.get_private_photodates(loggedin);
    	return JSONView_photodates.toJSONArray(photodates).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_photodates(View_photodates_usecases view_photodatesusecases) throws ParseException, CustomException {
    	return JSONView_photodates.toJSONArray(view_photodatesusecases.get_all()).toJSONString();
    }
}

