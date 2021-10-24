/*
 * RSTree7subject.java
 *
 * Generated on 24.9.2021 14:50
 *
 */

package film.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ITree7subjectsearch;
import film.interfaces.servlet.ITree7subjectOperation;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
import film.servlets.DataServlet;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rstree7subject")
public class RSTree7subject {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSTree7subject() {
    }

    /**
     * Retrieves representation of an instance of tree7subject.restservices.RSTree7subject
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLtree7subject bltree7subject = new BLtree7subject();
            ArrayList tree7subjects = bltree7subject.getAll();
            JSONArray jsontree7subjects = JSONTree7subject.toJSONArray(tree7subjects);
            return jsontree7subjects.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of tree7subject.restservices.RSTree7subject
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ITree7subjectPK tree7subjectPK;
            ITree7subject tree7subject;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bltree7subject.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ITree7subjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltree7subject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_ALL:
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects()).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_TREE7SUBJECT:
                            tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONTree7subject.toJSON(bltree7subject.getTree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_Tree7subjectparentsubjectid:
                            ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONTree7subject.toJSON(bltree7subject.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_SEARCH:
                            ITree7subjectsearch search = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.search(search)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_SEARCHCOUNT:
                            ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltree7subject.searchcount(tree7subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ITree7subjectOperation.SELECT_STEP1:
                            result = JSONTree7subject.toJSONArray(bltree7subject.getAllStep1()).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_CHILDREN4PARENT:
                            tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_SEARCHTEXT:
                            String searchtext = (String)json.get("searchtext");
                            result = JSONTree7subject.toJSONArray(bltree7subject.searchTree7subject_Subject(searchtext)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_PHOTOPK:
                            PhotoPK photoPK = (PhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects(photoPK)).toJSONString();
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ITree7subjectOperation.INSERT_TREE7SUBJECT:
                            tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
                            bltree7subject.insertTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ITree7subjectOperation.UPDATE_TREE7SUBJECT:
                            JSONObject jsontree7subject = (JSONObject)json.get("tree7subject");
                            tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)jsontree7subject.get("PK"));
                            tree7subject = bltree7subject.getTree7subject(tree7subjectPK);
                            JSONTree7subject.updateTree7subject(tree7subject, jsontree7subject);
                            bltree7subject.updateTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ITree7subjectOperation.DELETE_TREE7SUBJECT:
                            tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
                            bltree7subject.deleteTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ITree7subjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bltree7subject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_ALL:
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects()).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_TREE7SUBJECT:
                            tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONTree7subject.toJSON(bltree7subject.getTree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_Tree7subjectparentsubjectid:
                            ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONTree7subject.toJSON(bltree7subject.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_SEARCH:
                            ITree7subjectsearch search = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
                            result = JSONTree7subject.toJSONArray(bltree7subject.search(search)).toJSONString();
                            break;
                        case ITree7subjectOperation.SELECT_SEARCHCOUNT:
                            ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bltree7subject.searchcount(tree7subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ITree7subjectOperation.INSERT_TREE7SUBJECT:
                            tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
                            bltree7subject.secureinsertTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ITree7subjectOperation.UPDATE_TREE7SUBJECT:
                            JSONObject jsontree7subject = (JSONObject)json.get("tree7subject");
                            tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)jsontree7subject.get("PK"));
                            tree7subject = bltree7subject.getTree7subject(tree7subjectPK);
                            JSONTree7subject.updateTree7subject(tree7subject, jsontree7subject);
                            bltree7subject.secureupdateTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ITree7subjectOperation.DELETE_TREE7SUBJECT:
                            tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
                            bltree7subject.securedeleteTree7subject(tree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSTree7subject
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

