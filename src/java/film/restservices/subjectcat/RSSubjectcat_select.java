/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.subjectcat;

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
import film.interfaces.searchentity.ISubjectcatsearch;
import film.interfaces.servlet.ISubjectcatOperation;
import film.logicentity.Subjectcat;
import film.searchentity.Subjectcatsearch;
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
@Path("rssubjectcat_select")
public class RSSubjectcat_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISubjectcatOperation.SELECT_COUNT:
                    result = count_records(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_ALL:
                    result = get_all_subjectcat(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_SUBJECTCAT:
                    result = get_subjectcat_with_primarykey(subjectcatusecases, json);
                    break;
                case ISubjectcatOperation.SELECT_Subjectcat1:
                    result = get_subjectcat_with_externalforeignkey_subjectCat1(subjectcatusecases, json);
                    break;
                case ISubjectcatOperation.SELECT_Subjectcat2:
                    result = get_subjectcat_with_externalforeignkey_subjectCat2(subjectcatusecases, json);
                    break;
                case ISubjectcatOperation.SELECT_SEARCH:
                    result = search_subjectcat(subjectcatusecases, json);
                    break;
                case ISubjectcatOperation.SELECT_SEARCHCOUNT:
                    result = search_subjectcat_count(subjectcatusecases, json);
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

    private String count_records(Subjectcat_usecases subjectcatusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", subjectcatusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_subjectcat(Subjectcat_usecases subjectcatusecases) throws ParseException, CustomException {
    	return JSONSubjectcat.toJSONArray(subjectcatusecases.get_all()).toJSONString();
    }
    
    private String get_subjectcat_with_primarykey(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatPK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
	return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_by_primarykey(subjectcatPK)).toJSONString();
    }
    
    private String get_subjectcat_with_externalforeignkey_subjectCat1(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectCat1PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat1(subjectCat1PK)).toJSONString();
    }
    
    private String get_subjectcat_with_externalforeignkey_subjectCat2(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectCat2PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat2(subjectCat2PK)).toJSONString();
    }
    
    private String search_subjectcat(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatsearch search = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
        return JSONSubjectcat.toJSONArray(subjectcatusecases.search_subjectcat(search)).toJSONString();
    }
    
    private String search_subjectcat_count(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", subjectcatusecases.search_subjectcat_count(subjectcatsearch));
        return jsonsearchcount.toJSONString();
    }
}

