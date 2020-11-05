/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package film.restservices;

import data.gis.shape.GISConversion;
import film.BusinessObject.Logic.BLphoto;
import film.conversion.json.JSONPhoto;
import static film.conversion.json.JSONPhoto.toJSON;
import film.conversion.json.JSONRoute;
import film.interfaces.logicentity.IPhoto;
import film.logicentity.Photo;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author pelgrim
 */
@Path("rsphotodataerror")
public class RSPhotoDataError {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSPhotoDataError
     */
    public RSPhotoDataError() {
    }

    public static JSONObject toJSON(IPhoto photo) {
        JSONObject json = new JSONObject();
        json.put("PK", JSONPhoto.toJSON(photo.getPrimaryKey()));
        json.put("routePK", JSONRoute.toJSON(photo.getRoutePK()));
        if(photo.getPhotodate()!=null) {
	        json.put("photodate", photo.getPhotodate().getTime());
        }
        if(photo.getPhototime()!=null) {
	        json.put("phototime", photo.getPhototime().getTime());
        }
        json.put("public", photo.getPublic());
        return json;
    }
    
    private JSONArray toJSONArray(ArrayList photos) {
        JSONArray jsonphotos = new JSONArray();
        Iterator photosI = photos.iterator();
        while(photosI.hasNext()) {
            jsonphotos.add(toJSON((Photo)photosI.next()));
        }
        return jsonphotos;
    }

    /**
     * Retrieves representation of an instance of film.restservices.RSPhotoDataError
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        try {
            BLphoto blphoto = new BLphoto();
            ArrayList photos = blphoto.getPhotoDataErrors();
            JSONArray jsonphotos = toJSONArray(photos);
            return jsonphotos.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * PUT method for updating or creating an instance of RSPhotoDataError
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
