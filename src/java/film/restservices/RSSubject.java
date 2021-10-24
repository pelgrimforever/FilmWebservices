/*
 * RSSubject.java
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
import film.interfaces.searchentity.ISubjectsearch;
import film.interfaces.servlet.ISubjectOperation;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
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
@Path("rssubject")
public class RSSubject {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSubject() {
    }

    /**
     * Retrieves representation of an instance of subject.restservices.RSSubject
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsubject blsubject = new BLsubject();
            ArrayList subjects = blsubject.getAll();
            JSONArray jsonsubjects = JSONSubject.toJSONArray(subjects);
            return jsonsubjects.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of subject.restservices.RSSubject
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISubjectPK subjectPK;
            ISubject subject;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsubject.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISubjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsubject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISubjectOperation.SELECT_ALL:
                            result = JSONSubject.toJSONArray(blsubject.getSubjects()).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SUBJECT:
                            subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubject.toJSON(blsubject.getSubject(subjectPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat1:
                            ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4subjectcatCat1(subjectcatCat1PK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4tree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat2:
                            ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4subjectcatCat2(subjectcatCat2PK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONSubject.toJSON(blsubject.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONSubject.toJSON(blsubject.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SEARCH:
                            ISubjectsearch search = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
                            result = JSONSubject.toJSONArray(blsubject.search(search)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SEARCHCOUNT:
                            ISubjectsearch subjectsearch = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsubject.searchcount(subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISubjectOperation.INSERT_SUBJECT:
                            subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
                            blsubject.insertSubject(subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISubjectOperation.UPDATE_SUBJECT:
                            JSONObject jsonsubject = (JSONObject)json.get("subject");
                            subjectPK = JSONSubject.toSubjectPK((JSONObject)jsonsubject.get("PK"));
                            subject = blsubject.getSubject(subjectPK);
                            JSONSubject.updateSubject(subject, jsonsubject);
                            blsubject.updateSubject(subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISubjectOperation.DELETE_SUBJECT:
                            subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
                            blsubject.deleteSubject(subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISubjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsubject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISubjectOperation.SELECT_ALL:
                            result = JSONSubject.toJSONArray(blsubject.getSubjects()).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SUBJECT:
                            subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubject.toJSON(blsubject.getSubject(subjectPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat1:
                            ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4subjectcatCat1(subjectcatCat1PK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4tree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Subjectcatcat2:
                            ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubject.toJSONArray(blsubject.getSubjects4subjectcatCat2(subjectcatCat2PK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONSubject.toJSON(blsubject.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONSubject.toJSON(blsubject.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SEARCH:
                            ISubjectsearch search = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
                            result = JSONSubject.toJSONArray(blsubject.search(search)).toJSONString();
                            break;
                        case ISubjectOperation.SELECT_SEARCHCOUNT:
                            ISubjectsearch subjectsearch = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsubject.searchcount(subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISubjectOperation.INSERT_SUBJECT:
                            subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
                            blsubject.secureinsertSubject(subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISubjectOperation.UPDATE_SUBJECT:
                            JSONObject jsonsubject = (JSONObject)json.get("subject");
                            subjectPK = JSONSubject.toSubjectPK((JSONObject)jsonsubject.get("PK"));
                            subject = blsubject.getSubject(subjectPK);
                            JSONSubject.updateSubject(subject, jsonsubject);
                            blsubject.secureupdateSubject(subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISubjectOperation.DELETE_SUBJECT:
                            subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
                            blsubject.securedeleteSubject(subject);
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
     * PUT method for updating or creating an instance of RSSubject
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

