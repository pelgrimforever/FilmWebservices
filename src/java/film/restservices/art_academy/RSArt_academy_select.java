/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.art_academy;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.usecases.custom.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IArt_academysearch;
import film.interfaces.servlet.IArt_academyOperation;
import film.logicentity.Art_academy;
import film.searchentity.Art_academysearch;
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

@Path("rsart_academy_select")
public class RSArt_academy_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArt_academyOperation.SELECT_COUNT:
                    result = count_records(art_academyusecases);
                    break;
                case IArt_academyOperation.SELECT_ALL:
                    result = get_all_art_academy(art_academyusecases);
                    break;
                case IArt_academyOperation.SELECT_ART_ACADEMY:
                    result = get_art_academy_with_primarykey(art_academyusecases, json);
                    break;
                case IArt_academyOperation.SELECT_SEARCH:
                    result = search_art_academy(art_academyusecases, json);
                    break;
                case IArt_academyOperation.SELECT_SEARCHCOUNT:
                    result = search_art_academy_count(art_academyusecases, json);
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

    private String count_records(Art_academy_usecases art_academyusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_academyusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_academy(Art_academy_usecases art_academyusecases) throws ParseException, CustomException {
    	return JSONArt_academy.toJSONArray(art_academyusecases.get_all()).toJSONString();
    }
    
    private String get_art_academy_with_primarykey(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
	return JSONArt_academy.toJSON(art_academyusecases.get_art_academy_by_primarykey(art_academyPK)).toJSONString();
    }
    
    private String search_art_academy(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academysearch search = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
        return JSONArt_academy.toJSONArray(art_academyusecases.search_art_academy(search)).toJSONString();
    }
    
    private String search_art_academy_count(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academysearch art_academysearch = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_academyusecases.search_art_academy_count(art_academysearch));
        return jsonsearchcount.toJSONString();
    }
}

