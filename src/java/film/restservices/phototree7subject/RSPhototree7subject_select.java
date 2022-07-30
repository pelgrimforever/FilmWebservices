/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.phototree7subject;

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
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.interfaces.servlet.IPhototree7subjectOperation;
import film.logicentity.Phototree7subject;
import film.searchentity.Phototree7subjectsearch;
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
@Path("rsphototree7subject_select")
public class RSPhototree7subject_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPhototree7subjectOperation.SELECT_COUNT:
                    result = count_records(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_ALL:
                    result = get_all_phototree7subject(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_PHOTOTREE7SUBJECT:
                    result = get_phototree7subject_with_primarykey(phototree7subjectusecases, json);
                    break;
                case IPhototree7subjectOperation.SELECT_Tree7subject:
                    result = get_phototree7subject_with_foreignkey_tree7subject(phototree7subjectusecases, json);
                    break;
                case IPhototree7subjectOperation.SELECT_Photo:
                    result = get_phototree7subject_with_foreignkey_photo(phototree7subjectusecases, json);
                    break;
                case IPhototree7subjectOperation.SELECT_SEARCH:
                    result = search_phototree7subject(phototree7subjectusecases, json);
                    break;
                case IPhototree7subjectOperation.SELECT_SEARCHCOUNT:
                    result = search_phototree7subject_count(phototree7subjectusecases, json);
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

    private String count_records(Phototree7subject_usecases phototree7subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", phototree7subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_phototree7subject(Phototree7subject_usecases phototree7subjectusecases) throws ParseException, CustomException {
    	return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_all()).toJSONString();
    }
    
    private String get_phototree7subject_with_primarykey(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
	return JSONPhototree7subject.toJSON(phototree7subjectusecases.get_phototree7subject_by_primarykey(phototree7subjectPK)).toJSONString();
    }
    
    private String get_phototree7subject_with_foreignkey_tree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_phototree7subject_with_foreignkey_tree7subject(tree7subjectPK)).toJSONString();
    }
    
    private String get_phototree7subject_with_foreignkey_photo(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_phototree7subject_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String search_phototree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectsearch search = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.search_phototree7subject(search)).toJSONString();
    }
    
    private String search_phototree7subject_count(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", phototree7subjectusecases.search_phototree7subject_count(phototree7subjectsearch));
        return jsonsearchcount.toJSONString();
    }
}

