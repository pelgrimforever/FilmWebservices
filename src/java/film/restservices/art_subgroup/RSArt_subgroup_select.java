/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.art_subgroup;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Art_subgroup_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.interfaces.servlet.IArt_subgroupOperation;
import film.logicentity.Art_subgroup;
import film.searchentity.Art_subgroupsearch;
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
@Path("rsart_subgroup_select")
public class RSArt_subgroup_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IArt_subgroupPK art_subgroupPK;
            IArt_subgroup art_subgroup;
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArt_subgroupOperation.SELECT_COUNT:
                    result = count_records(art_subgroupusecases);
                    break;
                case IArt_subgroupOperation.SELECT_ALL:
                    result = get_all_art_subgroup(art_subgroupusecases);
                    break;
                case IArt_subgroupOperation.SELECT_ART_SUBGROUP:
                    result = get_art_subgroup_with_primarykey(art_subgroupusecases, json);
                    break;
                case IArt_subgroupOperation.SELECT_Art_group:
                    result = get_art_subgroup_with_foreignkey_art_group(art_subgroupusecases, json);
                    break;
                case IArt_subgroupOperation.SELECT_SEARCH:
                    result = search_art_subgroup(art_subgroupusecases, json);
                    break;
                case IArt_subgroupOperation.SELECT_SEARCHCOUNT:
                    result = search_art_subgroup_count(art_subgroupusecases, json);
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

    private String count_records(Art_subgroup_usecases art_subgroupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_subgroupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_subgroup(Art_subgroup_usecases art_subgroupusecases) throws ParseException, CustomException {
    	return JSONArt_subgroup.toJSONArray(art_subgroupusecases.get_all()).toJSONString();
    }
    
    private String get_art_subgroup_with_primarykey(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
	return JSONArt_subgroup.toJSON(art_subgroupusecases.get_art_subgroup_by_primarykey(art_subgroupPK)).toJSONString();
    }
    
    private String get_art_subgroup_with_foreignkey_art_group(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        return JSONArt_subgroup.toJSONArray(art_subgroupusecases.get_art_subgroup_with_foreignkey_art_group(art_groupPK)).toJSONString();
    }
    
    private String search_art_subgroup(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupsearch search = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
        return JSONArt_subgroup.toJSONArray(art_subgroupusecases.search_art_subgroup(search)).toJSONString();
    }
    
    private String search_art_subgroup_count(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_subgroupusecases.search_art_subgroup_count(art_subgroupsearch));
        return jsonsearchcount.toJSONString();
    }
}

