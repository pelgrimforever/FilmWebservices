/*
 * RSFilm.java
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
import film.interfaces.searchentity.IFilmsearch;
import film.interfaces.servlet.IFilmOperation;
import film.logicentity.Film;
import film.searchentity.Filmsearch;
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
@Path("rsfilm")
public class RSFilm {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFilm() {
    }

    /**
     * Retrieves representation of an instance of film.restservices.RSFilm
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfilm blfilm = new BLfilm();
            ArrayList films = blfilm.getAll();
            JSONArray jsonfilms = JSONFilm.toJSONArray(films);
            return jsonfilms.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of film.restservices.RSFilm
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFilmPK filmPK;
            IFilm film;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfilm.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFilmOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilm.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmOperation.SELECT_ALL:
                            result = JSONFilm.toJSONArray(blfilm.getFilms()).toJSONString();
                            break;
                        case IFilmOperation.SELECT_FILM:
                            filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONFilm.toJSON(blfilm.getFilm(filmPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Filmtype:
                            IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
                            result = JSONFilm.toJSONArray(blfilm.getFilms4filmtype(filmtypePK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONFilm.toJSON(blfilm.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONFilm.toJSON(blfilm.getPhoto(photoPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_SEARCH:
                            IFilmsearch search = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
                            result = JSONFilm.toJSONArray(blfilm.search(search)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_SEARCHCOUNT:
                            IFilmsearch filmsearch = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilm.searchcount(filmsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFilmOperation.INSERT_FILM:
                            film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
                            blfilm.insertFilm(film);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFilmOperation.UPDATE_FILM:
                            JSONObject jsonfilm = (JSONObject)json.get("film");
                            filmPK = JSONFilm.toFilmPK((JSONObject)jsonfilm.get("PK"));
                            film = blfilm.getFilm(filmPK);
                            JSONFilm.updateFilm(film, jsonfilm);
                            blfilm.updateFilm(film);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFilmOperation.DELETE_FILM:
                            film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
                            blfilm.deleteFilm(film);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFilmOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilm.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmOperation.SELECT_ALL:
                            result = JSONFilm.toJSONArray(blfilm.getFilms()).toJSONString();
                            break;
                        case IFilmOperation.SELECT_FILM:
                            filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONFilm.toJSON(blfilm.getFilm(filmPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Filmtype:
                            IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
                            result = JSONFilm.toJSONArray(blfilm.getFilms4filmtype(filmtypePK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Filmsubjects:
                            IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONFilm.toJSON(blfilm.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONFilm.toJSON(blfilm.getPhoto(photoPK)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_SEARCH:
                            IFilmsearch search = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
                            result = JSONFilm.toJSONArray(blfilm.search(search)).toJSONString();
                            break;
                        case IFilmOperation.SELECT_SEARCHCOUNT:
                            IFilmsearch filmsearch = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilm.searchcount(filmsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFilmOperation.INSERT_FILM:
                            film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
                            blfilm.secureinsertFilm(film);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFilmOperation.UPDATE_FILM:
                            JSONObject jsonfilm = (JSONObject)json.get("film");
                            filmPK = JSONFilm.toFilmPK((JSONObject)jsonfilm.get("PK"));
                            film = blfilm.getFilm(filmPK);
                            JSONFilm.updateFilm(film, jsonfilm);
                            blfilm.secureupdateFilm(film);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFilmOperation.DELETE_FILM:
                            film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
                            blfilm.securedeleteFilm(film);
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
     * PUT method for updating or creating an instance of RSFilm
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

