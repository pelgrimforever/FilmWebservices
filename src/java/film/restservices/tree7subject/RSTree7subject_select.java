/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.tree7subject;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Tree7subject_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ITree7subjectsearch;
import film.interfaces.servlet.ITree7subjectOperation;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
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
@Path("rstree7subject_select")
public class RSTree7subject_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ITree7subjectPK tree7subjectPK;
            ITree7subject tree7subject;
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITree7subjectOperation.SELECT_COUNT:
                    result = count_records(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_ALL:
                    result = get_all_tree7subject(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_TREE7SUBJECT:
                    result = get_tree7subject_with_primarykey(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_Tree7subjectparentsubjectid:
                    result = get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_Phototree7subject:
                    result = get_tree7subject_with_externalforeignkey_phototree7subject(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_SEARCH:
                    result = search_tree7subject(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_SEARCHCOUNT:
                    result = search_tree7subject_count(tree7subjectusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ITree7subjectOperation.SELECT_STEP1:
                    result = get_all_4_step1(tree7subjectusecases);
                    break;
                case ITree7subjectOperation.SELECT_CHILDREN4PARENT:
                    result = get_children_4_parent(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_SEARCHTEXT:
                    result = searchtext(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.SELECT_PHOTOPK:
                    result = subjects4photo(tree7subjectusecases, json);
                    break;
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
    private String get_all_4_step1(Tree7subject_usecases tree7subjectusecases) throws ParseException, CustomException {
        ArrayList<Tree7subject> tree7subjects = tree7subjectusecases.get_all_4_step1();
    	return JSONTree7subject.toJSONArray(tree7subjects).toJSONString();
    }

    private String get_children_4_parent(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        ArrayList<Tree7subject> tree7subjects = tree7subjectusecases.get_children_4_parent(tree7subjectPK);
    	return JSONTree7subject.toJSONArray(tree7subjects).toJSONString();
    }

    private String searchtext(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        String searchtext = (String)json.get("searchtext");
        ArrayList<Tree7subject> tree7subjects = tree7subjectusecases.searchtext(searchtext);
    	return JSONTree7subject.toJSONArray(tree7subjects).toJSONString();
    }

    private String subjects4photo(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        PhotoPK photoPK = (PhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        ArrayList<Tree7subject> tree7subjects = tree7subjectusecases.subjects4photo(photoPK);
    	return JSONTree7subject.toJSONArray(tree7subjects).toJSONString();
    }
//Custom code, do not change this line   

    private String count_records(Tree7subject_usecases tree7subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tree7subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_tree7subject(Tree7subject_usecases tree7subjectusecases) throws ParseException, CustomException {
    	return JSONTree7subject.toJSONArray(tree7subjectusecases.get_all()).toJSONString();
    }
    
    private String get_tree7subject_with_primarykey(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
	return JSONTree7subject.toJSON(tree7subjectusecases.get_tree7subject_by_primarykey(tree7subjectPK)).toJSONString();
    }
    
    private String get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONTree7subject.toJSONArray(tree7subjectusecases.get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectParentsubjectidPK)).toJSONString();
    }
    
    private String get_tree7subject_with_externalforeignkey_phototree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
        return JSONTree7subject.toJSON(tree7subjectusecases.get_tree7subject_with_externalforeignkey_phototree7subject(phototree7subjectPK)).toJSONString();
    }
    
    private String search_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectsearch search = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
        return JSONTree7subject.toJSONArray(tree7subjectusecases.search_tree7subject(search)).toJSONString();
    }
    
    private String search_tree7subject_count(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tree7subjectusecases.search_tree7subject_count(tree7subjectsearch));
        return jsonsearchcount.toJSONString();
    }
}

