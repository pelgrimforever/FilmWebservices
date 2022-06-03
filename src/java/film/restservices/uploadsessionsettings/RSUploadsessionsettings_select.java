/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.uploadsessionsettings;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Uploadsessionsettings_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.interfaces.servlet.IUploadsessionsettingsOperation;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.Uploadsessionsettingssearch;
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
@Path("rsuploadsessionsettings_select")
public class RSUploadsessionsettings_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IUploadsessionsettingsPK uploadsessionsettingsPK;
            IUploadsessionsettings uploadsessionsettings;
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUploadsessionsettingsOperation.SELECT_COUNT:
                    result = count_records(uploadsessionsettingsusecases);
                    break;
                case IUploadsessionsettingsOperation.SELECT_ALL:
                    result = get_all_uploadsessionsettings(uploadsessionsettingsusecases);
                    break;
                case IUploadsessionsettingsOperation.SELECT_UPLOADSESSIONSETTINGS:
                    result = get_uploadsessionsettings_with_primarykey(uploadsessionsettingsusecases, json);
                    break;
                case IUploadsessionsettingsOperation.SELECT_SEARCH:
                    result = search_uploadsessionsettings(uploadsessionsettingsusecases, json);
                    break;
                case IUploadsessionsettingsOperation.SELECT_SEARCHCOUNT:
                    result = search_uploadsessionsettings_count(uploadsessionsettingsusecases, json);
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

    private String count_records(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", uploadsessionsettingsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws ParseException, CustomException {
    	return JSONUploadsessionsettings.toJSONArray(uploadsessionsettingsusecases.get_all()).toJSONString();
    }
    
    private String get_uploadsessionsettings_with_primarykey(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingsPK uploadsessionsettingsPK = (IUploadsessionsettingsPK)JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)json.get("uploadsessionsettingspk"));
	return JSONUploadsessionsettings.toJSON(uploadsessionsettingsusecases.get_uploadsessionsettings_by_primarykey(uploadsessionsettingsPK)).toJSONString();
    }
    
    private String search_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
        return JSONUploadsessionsettings.toJSONArray(uploadsessionsettingsusecases.search_uploadsessionsettings(search)).toJSONString();
    }
    
    private String search_uploadsessionsettings_count(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", uploadsessionsettingsusecases.search_uploadsessionsettings_count(uploadsessionsettingssearch));
        return jsonsearchcount.toJSONString();
    }
}

