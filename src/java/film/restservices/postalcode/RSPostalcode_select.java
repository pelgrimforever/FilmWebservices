/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.postalcode;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Postalcode_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IPostalcodesearch;
import film.interfaces.servlet.IPostalcodeOperation;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
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
@Path("rspostalcode_select")
public class RSPostalcode_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IPostalcodePK postalcodePK;
            IPostalcode postalcode;
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPostalcodeOperation.SELECT_COUNT:
                    result = count_records(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_ALL:
                    result = get_all_postalcode(postalcodeusecases);
                    break;
                case IPostalcodeOperation.SELECT_POSTALCODE:
                    result = get_postalcode_with_primarykey(postalcodeusecases, json);
                    break;
                case IPostalcodeOperation.SELECT_Arealevel3:
                    result = get_postalcode_with_foreignkey_arealevel3(postalcodeusecases, json);
                    break;
                case IPostalcodeOperation.SELECT_Locality:
                    result = get_postalcode_with_externalforeignkey_locality(postalcodeusecases, json);
                    break;
                case IPostalcodeOperation.SELECT_SEARCH:
                    result = search_postalcode(postalcodeusecases, json);
                    break;
                case IPostalcodeOperation.SELECT_SEARCHCOUNT:
                    result = search_postalcode_count(postalcodeusecases, json);
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

    private String count_records(Postalcode_usecases postalcodeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", postalcodeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_postalcode(Postalcode_usecases postalcodeusecases) throws ParseException, CustomException {
    	return JSONPostalcode.toJSONArray(postalcodeusecases.get_all()).toJSONString();
    }
    
    private String get_postalcode_with_primarykey(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
	return JSONPostalcode.toJSON(postalcodeusecases.get_postalcode_by_primarykey(postalcodePK)).toJSONString();
    }
    
    private String get_postalcode_with_foreignkey_arealevel3(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        return JSONPostalcode.toJSONArray(postalcodeusecases.get_postalcode_with_foreignkey_arealevel3(arealevel3PK)).toJSONString();
    }
    
    private String get_postalcode_with_externalforeignkey_locality(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        return JSONPostalcode.toJSON(postalcodeusecases.get_postalcode_with_externalforeignkey_locality(localityPK)).toJSONString();
    }
    
    private String search_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodesearch search = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
        return JSONPostalcode.toJSONArray(postalcodeusecases.search_postalcode(search)).toJSONString();
    }
    
    private String search_postalcode_count(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodesearch postalcodesearch = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", postalcodeusecases.search_postalcode_count(postalcodesearch));
        return jsonsearchcount.toJSONString();
    }
}

