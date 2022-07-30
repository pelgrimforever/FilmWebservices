/*
 * Generated on 27.6.2022 16:45
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
@Path("rsphoto_delete")
public class RSPhoto_delete extends RS_json_login {

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
                case IPhotoOperation.DELETE_PHOTO:
                    delete_photo(photousecases, json);
                    break;
                case IPhotoOperation.DELETE_Route:
                    delete_photo(photousecases, json);
                    break;
                case IPhotoOperation.DELETE_Creator:
                    delete_photo(photousecases, json);
                    break;
                case IPhotoOperation.DELETE_Film:
                    delete_photo(photousecases, json);
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

    private void delete_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.deletePhoto(photo);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Route(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
        photousecases.delete_all_containing_Route(routePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Creator(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        photousecases.delete_all_containing_Creator(creatorPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Film(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        photousecases.delete_all_containing_Film(filmPK);
        setReturnstatus("OK");
    }

}

