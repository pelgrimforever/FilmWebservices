/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.photo;

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
import film.interfaces.searchentity.IPhotosearch;
import film.interfaces.servlet.IPhotoOperation;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
import film.servlets.DataServlet;
import film.usecases.*;
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

@Path("rsphoto_update")
public class RSPhoto_update extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPhotoOperation.UPDATE_PHOTO:
                    update_photo(photousecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhotoOperation.UPDATE_GEOLOCATION:
                    updateGeolocation(photousecases, json);
                    break;
                case IPhotoOperation.UPDATE_COPYPREVGEOLOCATION:
                    copyPreviousGeolocation(photousecases, json);
                    break;
                case IPhotoOperation.UPDATE_COPYPHOTOGEOLOCATION:
                    copyGeolocation_from_Photo(photousecases, json);
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
    private void updateGeolocation(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.updateGeolocation(photo);
        setReturnstatus("OK");
    }

    private void copyPreviousGeolocation(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        boolean success = photousecases.copyPreviousGeolocation(photo);
        if(success)
            setReturnstatus("OK");
        else
            setReturnstatus("No location available");
    }

    private void copyGeolocation_from_Photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        IPhotoPK source_photoPK = JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        boolean copysuccess = photousecases.copyGeolocation_from_Photo(photo, source_photoPK);
        if(copysuccess)
            setReturnstatus("OK");
        else
            setReturnstatus("No location available");
    }
//Custom code, do not change this line   

    private void update_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.updatePhoto(photo);
        setReturnstatus("OK");
    }
}

