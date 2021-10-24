/*
 * RSArt_photo.java
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
import film.interfaces.searchentity.IArt_photosearch;
import film.interfaces.servlet.IArt_photoOperation;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
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
@Path("rsart_photo")
public class RSArt_photo {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArt_photo() {
    }

    /**
     * Retrieves representation of an instance of art_photo.restservices.RSArt_photo
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLart_photo blart_photo = new BLart_photo();
            ArrayList art_photos = blart_photo.getAll();
            JSONArray jsonart_photos = JSONArt_photo.toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of art_photo.restservices.RSArt_photo
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArt_photoPK art_photoPK;
            IArt_photo art_photo;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blart_photo.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArt_photoOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_photo.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_ALL:
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos()).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_ART_PHOTO:
                            art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
                            result = JSONArt_photo.toJSON(blart_photo.getArt_photo(art_photoPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4photo(photoPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_subgroup:
                            IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_subgroup(art_subgroupPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_academy:
                            IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_academy(art_academyPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_SEARCH:
                            IArt_photosearch search = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
                            result = JSONArt_photo.toJSONArray(blart_photo.search(search)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_SEARCHCOUNT:
                            IArt_photosearch art_photosearch = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_photo.searchcount(art_photosearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArt_photoOperation.INSERT_ART_PHOTO:
                            art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
                            blart_photo.insertArt_photo(art_photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArt_photoOperation.UPDATE_ART_PHOTO:
                            JSONObject jsonart_photo = (JSONObject)json.get("art_photo");
                            art_photoPK = JSONArt_photo.toArt_photoPK((JSONObject)jsonart_photo.get("PK"));
                            art_photo = blart_photo.getArt_photo(art_photoPK);
                            JSONArt_photo.updateArt_photo(art_photo, jsonart_photo);
                            blart_photo.updateArt_photo(art_photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArt_photoOperation.DELETE_ART_PHOTO:
                            art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
                            blart_photo.deleteArt_photo(art_photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArt_photoOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_photo.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_ALL:
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos()).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_ART_PHOTO:
                            art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
                            result = JSONArt_photo.toJSON(blart_photo.getArt_photo(art_photoPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4photo(photoPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_subgroup:
                            IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_subgroup(art_subgroupPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_academy:
                            IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_academy(art_academyPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_photo.toJSONArray(blart_photo.getArt_photos4art_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_SEARCH:
                            IArt_photosearch search = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
                            result = JSONArt_photo.toJSONArray(blart_photo.search(search)).toJSONString();
                            break;
                        case IArt_photoOperation.SELECT_SEARCHCOUNT:
                            IArt_photosearch art_photosearch = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_photo.searchcount(art_photosearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArt_photoOperation.INSERT_ART_PHOTO:
                            art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
                            blart_photo.secureinsertArt_photo(art_photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArt_photoOperation.UPDATE_ART_PHOTO:
                            JSONObject jsonart_photo = (JSONObject)json.get("art_photo");
                            art_photoPK = JSONArt_photo.toArt_photoPK((JSONObject)jsonart_photo.get("PK"));
                            art_photo = blart_photo.getArt_photo(art_photoPK);
                            JSONArt_photo.updateArt_photo(art_photo, jsonart_photo);
                            blart_photo.secureupdateArt_photo(art_photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArt_photoOperation.DELETE_ART_PHOTO:
                            art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
                            blart_photo.securedeleteArt_photo(art_photo);
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
     * PUT method for updating or creating an instance of RSArt_photo
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

