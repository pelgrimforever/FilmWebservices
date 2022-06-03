/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.arealevel3;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Arealevel3_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IArealevel3search;
import film.interfaces.servlet.IArealevel3Operation;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
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
@Path("rsarealevel3_select")
public class RSArealevel3_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IArealevel3PK arealevel3PK;
            IArealevel3 arealevel3;
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel3Operation.SELECT_COUNT:
                    result = count_records(arealevel3usecases);
                    break;
                case IArealevel3Operation.SELECT_ALL:
                    result = get_all_arealevel3(arealevel3usecases);
                    break;
                case IArealevel3Operation.SELECT_AREALEVEL3:
                    result = get_arealevel3_with_primarykey(arealevel3usecases, json);
                    break;
                case IArealevel3Operation.SELECT_Arealevel2:
                    result = get_arealevel3_with_foreignkey_arealevel2(arealevel3usecases, json);
                    break;
                case IArealevel3Operation.SELECT_SEARCH:
                    result = search_arealevel3(arealevel3usecases, json);
                    break;
                case IArealevel3Operation.SELECT_SEARCHCOUNT:
                    result = search_arealevel3_count(arealevel3usecases, json);
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

    private String count_records(Arealevel3_usecases arealevel3usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel3usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel3(Arealevel3_usecases arealevel3usecases) throws ParseException, CustomException {
    	return JSONArealevel3.toJSONArray(arealevel3usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel3_with_primarykey(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
	return JSONArealevel3.toJSON(arealevel3usecases.get_arealevel3_by_primarykey(arealevel3PK)).toJSONString();
    }
    
    private String get_arealevel3_with_foreignkey_arealevel2(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        return JSONArealevel3.toJSONArray(arealevel3usecases.get_arealevel3_with_foreignkey_arealevel2(arealevel2PK)).toJSONString();
    }
    
    private String search_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3search search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
        return JSONArealevel3.toJSONArray(arealevel3usecases.search_arealevel3(search)).toJSONString();
    }
    
    private String search_arealevel3_count(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3search arealevel3search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel3usecases.search_arealevel3_count(arealevel3search));
        return jsonsearchcount.toJSONString();
    }
}

