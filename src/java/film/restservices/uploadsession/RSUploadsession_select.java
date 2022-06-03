/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.uploadsession;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Uploadsession_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.interfaces.servlet.IUploadsessionOperation;
import film.logicentity.Uploadsession;
import film.searchentity.Uploadsessionsearch;
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
@Path("rsuploadsession_select")
public class RSUploadsession_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IUploadsessionPK uploadsessionPK;
            IUploadsession uploadsession;
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IUploadsessionOperation.SELECT_COUNT:
                    result = count_records(uploadsessionusecases);
                    break;
                case IUploadsessionOperation.SELECT_ALL:
                    result = get_all_uploadsession(uploadsessionusecases);
                    break;
                case IUploadsessionOperation.SELECT_UPLOADSESSION:
                    result = get_uploadsession_with_primarykey(uploadsessionusecases, json);
                    break;
                case IUploadsessionOperation.SELECT_Creator:
                    result = get_uploadsession_with_foreignkey_creator(uploadsessionusecases, json);
                    break;
                case IUploadsessionOperation.SELECT_SEARCH:
                    result = search_uploadsession(uploadsessionusecases, json);
                    break;
                case IUploadsessionOperation.SELECT_SEARCHCOUNT:
                    result = search_uploadsession_count(uploadsessionusecases, json);
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

    private String count_records(Uploadsession_usecases uploadsessionusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", uploadsessionusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_uploadsession(Uploadsession_usecases uploadsessionusecases) throws ParseException, CustomException {
    	return JSONUploadsession.toJSONArray(uploadsessionusecases.get_all()).toJSONString();
    }
    
    private String get_uploadsession_with_primarykey(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionPK uploadsessionPK = (IUploadsessionPK)JSONUploadsession.toUploadsessionPK((JSONObject)json.get("uploadsessionpk"));
	return JSONUploadsession.toJSON(uploadsessionusecases.get_uploadsession_by_primarykey(uploadsessionPK)).toJSONString();
    }
    
    private String get_uploadsession_with_foreignkey_creator(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        return JSONUploadsession.toJSONArray(uploadsessionusecases.get_uploadsession_with_foreignkey_creator(creatorPK)).toJSONString();
    }
    
    private String search_uploadsession(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsearch search = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
        return JSONUploadsession.toJSONArray(uploadsessionusecases.search_uploadsession(search)).toJSONString();
    }
    
    private String search_uploadsession_count(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", uploadsessionusecases.search_uploadsession_count(uploadsessionsearch));
        return jsonsearchcount.toJSONString();
    }
}

