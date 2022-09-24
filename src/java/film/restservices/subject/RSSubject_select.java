/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.subject;

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
import film.interfaces.searchentity.ISubjectsearch;
import film.interfaces.servlet.ISubjectOperation;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
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

@Path("rssubject_select")
public class RSSubject_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISubjectOperation.SELECT_COUNT:
                    result = count_records(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_ALL:
                    result = get_all_subject(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_SUBJECT:
                    result = get_subject_with_primarykey(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_Subjectcatcat1:
                    result = get_subject_with_foreignkey_subjectcatCat1(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_Tree7subject:
                    result = get_subject_with_foreignkey_tree7subject(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_Subjectcatcat2:
                    result = get_subject_with_foreignkey_subjectcatCat2(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_Filmsubjects:
                    result = get_subject_with_externalforeignkey_filmsubjects(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_Photosubjects:
                    result = get_subject_with_externalforeignkey_photosubjects(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_SEARCH:
                    result = search_subject(subjectusecases, json);
                    break;
                case ISubjectOperation.SELECT_SEARCHCOUNT:
                    result = search_subject_count(subjectusecases, json);
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

    private String count_records(Subject_usecases subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_subject(Subject_usecases subjectusecases) throws ParseException, CustomException {
    	return JSONSubject.toJSONArray(subjectusecases.get_all()).toJSONString();
    }
    
    private String get_subject_with_primarykey(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
	return JSONSubject.toJSON(subjectusecases.get_subject_by_primarykey(subjectPK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_subjectcatCat1(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_subjectcatCat1(subjectcatCat1PK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_tree7subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_tree7subject(tree7subjectPK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_subjectcatCat2(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_subjectcatCat2(subjectcatCat2PK)).toJSONString();
    }
    
    private String get_subject_with_externalforeignkey_filmsubjects(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
        return JSONSubject.toJSON(subjectusecases.get_subject_with_externalforeignkey_filmsubjects(filmsubjectsPK)).toJSONString();
    }
    
    private String get_subject_with_externalforeignkey_photosubjects(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
        return JSONSubject.toJSON(subjectusecases.get_subject_with_externalforeignkey_photosubjects(photosubjectsPK)).toJSONString();
    }
    
    private String search_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectsearch search = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
        return JSONSubject.toJSONArray(subjectusecases.search_subject(search)).toJSONString();
    }
    
    private String search_subject_count(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectsearch subjectsearch = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", subjectusecases.search_subject_count(subjectsearch));
        return jsonsearchcount.toJSONString();
    }
}

