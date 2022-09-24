/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.arealevel2;

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
import film.interfaces.searchentity.IArealevel2search;
import film.interfaces.servlet.IArealevel2Operation;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
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

@Path("rsarealevel2_select")
public class RSArealevel2_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel2Operation.SELECT_COUNT:
                    result = count_records(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_ALL:
                    result = get_all_arealevel2(arealevel2usecases);
                    break;
                case IArealevel2Operation.SELECT_AREALEVEL2:
                    result = get_arealevel2_with_primarykey(arealevel2usecases, json);
                    break;
                case IArealevel2Operation.SELECT_Arealevel1:
                    result = get_arealevel2_with_foreignkey_arealevel1(arealevel2usecases, json);
                    break;
                case IArealevel2Operation.SELECT_Arealevel3:
                    result = get_arealevel2_with_externalforeignkey_arealevel3(arealevel2usecases, json);
                    break;
                case IArealevel2Operation.SELECT_SEARCH:
                    result = search_arealevel2(arealevel2usecases, json);
                    break;
                case IArealevel2Operation.SELECT_SEARCHCOUNT:
                    result = search_arealevel2_count(arealevel2usecases, json);
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

    private String count_records(Arealevel2_usecases arealevel2usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel2usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel2(Arealevel2_usecases arealevel2usecases) throws ParseException, CustomException {
    	return JSONArealevel2.toJSONArray(arealevel2usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel2_with_primarykey(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
	return JSONArealevel2.toJSON(arealevel2usecases.get_arealevel2_by_primarykey(arealevel2PK)).toJSONString();
    }
    
    private String get_arealevel2_with_foreignkey_arealevel1(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        return JSONArealevel2.toJSONArray(arealevel2usecases.get_arealevel2_with_foreignkey_arealevel1(arealevel1PK)).toJSONString();
    }
    
    private String get_arealevel2_with_externalforeignkey_arealevel3(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        return JSONArealevel2.toJSON(arealevel2usecases.get_arealevel2_with_externalforeignkey_arealevel3(arealevel3PK)).toJSONString();
    }
    
    private String search_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2search search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
        return JSONArealevel2.toJSONArray(arealevel2usecases.search_arealevel2(search)).toJSONString();
    }
    
    private String search_arealevel2_count(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2search arealevel2search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel2usecases.search_arealevel2_count(arealevel2search));
        return jsonsearchcount.toJSONString();
    }
}

