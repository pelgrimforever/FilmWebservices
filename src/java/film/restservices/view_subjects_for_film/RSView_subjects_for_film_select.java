/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.view_subjects_for_film;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_subjects_for_film;
import film.interfaces.servlet.IView_subjects_for_filmOperation;
import film.usecases.View_subjects_for_film_usecases;
import film.logicview.View_subjects_for_film;
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

@Path("rsview_subjects_for_film_select")
public class RSView_subjects_for_film_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_subjects_for_film_usecases view_subjects_for_filmusecases = new View_subjects_for_film_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_subjects_for_filmOperation.SELECT_ALL:
                    result = get_all_view_subjects_for_film(view_subjects_for_filmusecases);
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

    private String get_all_view_subjects_for_film(View_subjects_for_film_usecases view_subjects_for_filmusecases) throws ParseException, CustomException {
    	return JSONView_subjects_for_film.toJSONArray(view_subjects_for_filmusecases.get_all()).toJSONString();
    }
}

