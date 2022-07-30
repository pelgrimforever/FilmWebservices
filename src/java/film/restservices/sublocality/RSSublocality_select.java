/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.sublocality;

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
import film.interfaces.searchentity.ISublocalitysearch;
import film.interfaces.servlet.ISublocalityOperation;
import film.logicentity.Sublocality;
import film.searchentity.Sublocalitysearch;
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
@Path("rssublocality_select")
public class RSSublocality_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISublocalityOperation.SELECT_COUNT:
                    result = count_records(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_ALL:
                    result = get_all_sublocality(sublocalityusecases);
                    break;
                case ISublocalityOperation.SELECT_SUBLOCALITY:
                    result = get_sublocality_with_primarykey(sublocalityusecases, json);
                    break;
                case ISublocalityOperation.SELECT_Locality:
                    result = get_sublocality_with_foreignkey_locality(sublocalityusecases, json);
                    break;
                case ISublocalityOperation.SELECT_Route:
                    result = get_sublocality_with_externalforeignkey_route(sublocalityusecases, json);
                    break;
                case ISublocalityOperation.SELECT_SEARCH:
                    result = search_sublocality(sublocalityusecases, json);
                    break;
                case ISublocalityOperation.SELECT_SEARCHCOUNT:
                    result = search_sublocality_count(sublocalityusecases, json);
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

    private String count_records(Sublocality_usecases sublocalityusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", sublocalityusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_sublocality(Sublocality_usecases sublocalityusecases) throws ParseException, CustomException {
    	return JSONSublocality.toJSONArray(sublocalityusecases.get_all()).toJSONString();
    }
    
    private String get_sublocality_with_primarykey(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
	return JSONSublocality.toJSON(sublocalityusecases.get_sublocality_by_primarykey(sublocalityPK)).toJSONString();
    }
    
    private String get_sublocality_with_foreignkey_locality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        return JSONSublocality.toJSONArray(sublocalityusecases.get_sublocality_with_foreignkey_locality(localityPK)).toJSONString();
    }
    
    private String get_sublocality_with_externalforeignkey_route(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
        return JSONSublocality.toJSON(sublocalityusecases.get_sublocality_with_externalforeignkey_route(routePK)).toJSONString();
    }
    
    private String search_sublocality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalitysearch search = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
        return JSONSublocality.toJSONArray(sublocalityusecases.search_sublocality(search)).toJSONString();
    }
    
    private String search_sublocality_count(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalitysearch sublocalitysearch = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", sublocalityusecases.search_sublocality_count(sublocalitysearch));
        return jsonsearchcount.toJSONString();
    }
}

