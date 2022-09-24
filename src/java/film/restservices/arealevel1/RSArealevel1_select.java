/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.arealevel1;

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
import film.interfaces.searchentity.IArealevel1search;
import film.interfaces.servlet.IArealevel1Operation;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
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

@Path("rsarealevel1_select")
public class RSArealevel1_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel1Operation.SELECT_COUNT:
                    result = count_records(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_ALL:
                    result = get_all_arealevel1(arealevel1usecases);
                    break;
                case IArealevel1Operation.SELECT_AREALEVEL1:
                    result = get_arealevel1_with_primarykey(arealevel1usecases, json);
                    break;
                case IArealevel1Operation.SELECT_Country:
                    result = get_arealevel1_with_foreignkey_country(arealevel1usecases, json);
                    break;
                case IArealevel1Operation.SELECT_Arealevel2:
                    result = get_arealevel1_with_externalforeignkey_arealevel2(arealevel1usecases, json);
                    break;
                case IArealevel1Operation.SELECT_SEARCH:
                    result = search_arealevel1(arealevel1usecases, json);
                    break;
                case IArealevel1Operation.SELECT_SEARCHCOUNT:
                    result = search_arealevel1_count(arealevel1usecases, json);
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

    private String count_records(Arealevel1_usecases arealevel1usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel1usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel1(Arealevel1_usecases arealevel1usecases) throws ParseException, CustomException {
    	return JSONArealevel1.toJSONArray(arealevel1usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel1_with_primarykey(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
	return JSONArealevel1.toJSON(arealevel1usecases.get_arealevel1_by_primarykey(arealevel1PK)).toJSONString();
    }
    
    private String get_arealevel1_with_foreignkey_country(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
        return JSONArealevel1.toJSONArray(arealevel1usecases.get_arealevel1_with_foreignkey_country(countryPK)).toJSONString();
    }
    
    private String get_arealevel1_with_externalforeignkey_arealevel2(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        return JSONArealevel1.toJSON(arealevel1usecases.get_arealevel1_with_externalforeignkey_arealevel2(arealevel2PK)).toJSONString();
    }
    
    private String search_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1search search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
        return JSONArealevel1.toJSONArray(arealevel1usecases.search_arealevel1(search)).toJSONString();
    }
    
    private String search_arealevel1_count(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1search arealevel1search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel1usecases.search_arealevel1_count(arealevel1search));
        return jsonsearchcount.toJSONString();
    }
}

