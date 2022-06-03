/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.creator;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Creator_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ICreatorsearch;
import film.interfaces.servlet.ICreatorOperation;
import film.logicentity.Creator;
import film.searchentity.Creatorsearch;
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
@Path("rscreator_select")
public class RSCreator_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ICreatorPK creatorPK;
            ICreator creator;
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ICreatorOperation.SELECT_COUNT:
                    result = count_records(creatorusecases);
                    break;
                case ICreatorOperation.SELECT_ALL:
                    result = get_all_creator(creatorusecases);
                    break;
                case ICreatorOperation.SELECT_CREATOR:
                    result = get_creator_with_primarykey(creatorusecases, json);
                    break;
                case ICreatorOperation.SELECT_SEARCH:
                    result = search_creator(creatorusecases, json);
                    break;
                case ICreatorOperation.SELECT_SEARCHCOUNT:
                    result = search_creator_count(creatorusecases, json);
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

    private String count_records(Creator_usecases creatorusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", creatorusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_creator(Creator_usecases creatorusecases) throws ParseException, CustomException {
    	return JSONCreator.toJSONArray(creatorusecases.get_all()).toJSONString();
    }
    
    private String get_creator_with_primarykey(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
	return JSONCreator.toJSON(creatorusecases.get_creator_by_primarykey(creatorPK)).toJSONString();
    }
    
    private String search_creator(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorsearch search = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
        return JSONCreator.toJSONArray(creatorusecases.search_creator(search)).toJSONString();
    }
    
    private String search_creator_count(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorsearch creatorsearch = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", creatorusecases.search_creator_count(creatorsearch));
        return jsonsearchcount.toJSONString();
    }
}

