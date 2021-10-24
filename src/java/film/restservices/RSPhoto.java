/*
 * RSPhoto.java
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
import film.interfaces.searchentity.IPhotosearch;
import film.interfaces.servlet.IPhotoOperation;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
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
@Path("rsphoto")
public class RSPhoto {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSPhoto() {
    }

    /**
     * Retrieves representation of an instance of photo.restservices.RSPhoto
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLphoto blphoto = new BLphoto();
            ArrayList photos = blphoto.getAll();
            JSONArray jsonphotos = JSONPhoto.toJSONArray(photos);
            return jsonphotos.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of photo.restservices.RSPhoto
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IPhotoPK photoPK;
            IPhoto photo;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blphoto.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPhotoOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphoto.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhotoOperation.SELECT_ALL:
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos()).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_PHOTO:
                            photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhoto.toJSON(blphoto.getPhoto(photoPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4route(routePK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4creator(creatorPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4film(filmPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONPhoto.toJSON(blphoto.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Art_photo:
                            IArt_photoPK art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
                            result = JSONPhoto.toJSON(blphoto.getArt_photo(art_photoPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONPhoto.toJSON(blphoto.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Phototags:
                            IPhototagsPK phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
                            result = JSONPhoto.toJSON(blphoto.getPhototags(phototagsPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_SEARCH:
                            IPhotosearch search = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            result = JSONPhoto.toJSONArray(blphoto.search(search)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_SEARCHCOUNT:
                            IPhotosearch photosearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphoto.searchcount(photosearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotoOperation.SELECT_FilmWITHIMAGESBASE64:
                            IFilmPK filmPK2 = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            ArrayList photos = blphoto.getPhotos4film(filmPK2);
                            blphoto.addThumbnailsBase64(photos);
                            result = JSONPhoto.toJSONArray(photos).toJSONString();
                            break;
                        case IPhotoOperation.SECURESELECT_COUNT:
                            JSONObject sjsoncount = new JSONObject();
                            sjsoncount.put("recordcount", blphoto.count(loggedin));
                            result = sjsoncount.toJSONString();
                            break;
                        case IPhotoOperation.SELECT_LOCATION:
                            piPoint location = GISConversion.topiPoint((JSONObject)json.get("location"));
                            ArrayList photosl = blphoto.getPhoto4Location(loggedin, location);
                            blphoto.addThumbnailsBase64(photosl);
                            result = JSONPhoto.toJSONArray(photosl).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_LOCATIONS:
                            JSONArray jsonlocations = (JSONArray)json.get("locations");
                            Iterator<JSONObject> jsonlocationsI = jsonlocations.iterator();
                            ArrayList<piPoint> locations = new ArrayList<>();
                            while(jsonlocationsI.hasNext()) {
                                piPoint location1 = GISConversion.topiPoint(jsonlocationsI.next());
                                locations.add(location1);
                            }
                            ArrayList photos1 = blphoto.getPhoto4Locations(locations);
                            blphoto.addThumbnailsBase64(photos1);
                            result = JSONPhoto.toJSONArray(photos1).toJSONString();
                            break;
                        case IPhotoOperation.SECURESELECT_DATE:
                            //add security
                            String datestring = json.get("date").toString();
                            Date date = new Date(Long.valueOf(datestring));
                            ArrayList photos4date = blphoto.getPhoto4Date(loggedin, date);
                            //blphoto.addSmallimage(photos4date, loggedin);
                            result = JSONPhoto.toJSONArray(photos4date).toJSONString();
                            break;
                        /*case IPhotoOperation.DOWNLOAD_SMALLIMAGE:
                            photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            try {
                                String filepath = blphoto.publishSmall(loggedin, photoPK, BLphoto.TEMPdestinationpath + File.separator);
                                filepath = BLphoto.TEMPonlinepath + filepath;
                                JSONObject imagejson = new JSONObject();
                                imagejson.put("status", "OK");
                                imagejson.put("image", filepath);
                                result = imagejson.toJSONString();
                            }
                            catch(IOException e) {
                                result = returnstatus(e.getMessage());
                            }
                            break;*/
                        case IPhotoOperation.SELECT_SEARCHWITHIMAGESBASE64:
                            IPhotosearch secsearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            ArrayList secphotos = blphoto.search(secsearch);
                            blphoto.addThumbnailsBase64(secphotos);
                            result = JSONPhoto.toJSONArray(secphotos).toJSONString();
                            break;
                        case IPhotoOperation.SECURESELECT_SEARCHCOUNT:
                            IPhotosearch secphotosearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            JSONObject jsonsecsearchcount = new JSONObject();
                            jsonsecsearchcount.put("recordcount", blphoto.searchcount(secphotosearch));
                            result = jsonsecsearchcount.toJSONString();
                            break;
                        case IPhotoOperation.SECURESELECT_DESCRIPTIONS:
                            String searchtext = (String)json.get("searchtext");
                            JSONArray jsondescriptions = new JSONArray();
                            JSONObject jsonitem;
                            ArrayList descriptions = blphoto.getDescriptions(searchtext);
                            Iterator<String> descriptionsI = descriptions.iterator();
                            while(descriptionsI.hasNext()) {
                                jsonitem = new JSONObject();
                                jsonitem.put("description", descriptionsI.next());
                                jsondescriptions.add(jsonitem);
                            }
                            result = jsondescriptions.toJSONString();
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IPhotoOperation.INSERT_PHOTO:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            blphoto.insertPhoto(photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IPhotoOperation.UPDATE_PHOTO:
                            JSONObject jsonphoto = (JSONObject)json.get("photo");
                            photoPK = JSONPhoto.toPhotoPK((JSONObject)jsonphoto.get("PK"));
                            photo = blphoto.getPhoto(photoPK);
                            JSONPhoto.updatePhoto(photo, jsonphoto);
                            blphoto.updatePhoto(photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotoOperation.UPDATE_GEOLOCATION:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            blphoto.updateGeolocation(photo);
                            result = returnstatus("OK");
                            break;
                        case IPhotoOperation.UPDATE_COPYPREVGEOLOCATION:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            boolean success = blphoto.updateCopyPrevGeolocation(photo);
                            if(success) {
                                result = returnstatus("OK");
                            } else {
                                result = returnstatus("No location available");
                            }
                            break;
                        case IPhotoOperation.UPDATE_COPYPHOTOGEOLOCATION:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            photoPK = JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            boolean copysuccess = blphoto.copyPhotoGeolocation(photo, photoPK);
                            if(copysuccess) {
                                result = returnstatus("OK");
                            } else {
                                result = returnstatus("No location available");
                            }
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IPhotoOperation.DELETE_PHOTO:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            blphoto.deletePhoto(photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IPhotoOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphoto.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhotoOperation.SELECT_ALL:
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos()).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_PHOTO:
                            photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhoto.toJSON(blphoto.getPhoto(photoPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4route(routePK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4creator(creatorPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONPhoto.toJSONArray(blphoto.getPhotos4film(filmPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONPhoto.toJSON(blphoto.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Art_photo:
                            IArt_photoPK art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
                            result = JSONPhoto.toJSON(blphoto.getArt_photo(art_photoPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONPhoto.toJSON(blphoto.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_Phototags:
                            IPhototagsPK phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
                            result = JSONPhoto.toJSON(blphoto.getPhototags(phototagsPK)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_SEARCH:
                            IPhotosearch search = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            result = JSONPhoto.toJSONArray(blphoto.search(search)).toJSONString();
                            break;
                        case IPhotoOperation.SELECT_SEARCHCOUNT:
                            IPhotosearch photosearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphoto.searchcount(photosearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IPhotoOperation.INSERT_PHOTO:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            blphoto.secureinsertPhoto(photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IPhotoOperation.UPDATE_PHOTO:
                            JSONObject jsonphoto = (JSONObject)json.get("photo");
                            photoPK = JSONPhoto.toPhotoPK((JSONObject)jsonphoto.get("PK"));
                            photo = blphoto.getPhoto(photoPK);
                            JSONPhoto.updatePhoto(photo, jsonphoto);
                            blphoto.secureupdatePhoto(photo);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IPhotoOperation.DELETE_PHOTO:
                            photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
                            blphoto.securedeletePhoto(photo);
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
     * PUT method for updating or creating an instance of RSPhoto
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

