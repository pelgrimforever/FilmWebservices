/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.art_group;

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
import film.interfaces.searchentity.IArt_groupsearch;
import film.interfaces.servlet.IArt_groupOperation;
import film.logicentity.Art_group;
import film.searchentity.Art_groupsearch;
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

@Path("rsart_group_select")
public class RSArt_group_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArt_groupOperation.SELECT_COUNT:
                    result = count_records(art_groupusecases);
                    break;
                case IArt_groupOperation.SELECT_ALL:
                    result = get_all_art_group(art_groupusecases);
                    break;
                case IArt_groupOperation.SELECT_ART_GROUP:
                    result = get_art_group_with_primarykey(art_groupusecases, json);
                    break;
                case IArt_groupOperation.SELECT_SEARCH:
                    result = search_art_group(art_groupusecases, json);
                    break;
                case IArt_groupOperation.SELECT_SEARCHCOUNT:
                    result = search_art_group_count(art_groupusecases, json);
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

    private String count_records(Art_group_usecases art_groupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_groupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_group(Art_group_usecases art_groupusecases) throws ParseException, CustomException {
    	return JSONArt_group.toJSONArray(art_groupusecases.get_all()).toJSONString();
    }
    
    private String get_art_group_with_primarykey(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
	return JSONArt_group.toJSON(art_groupusecases.get_art_group_by_primarykey(art_groupPK)).toJSONString();
    }
    
    private String search_art_group(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupsearch search = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
        return JSONArt_group.toJSONArray(art_groupusecases.search_art_group(search)).toJSONString();
    }
    
    private String search_art_group_count(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupsearch art_groupsearch = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_groupusecases.search_art_group_count(art_groupsearch));
        return jsonsearchcount.toJSONString();
    }
}

