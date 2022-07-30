/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.art_photo;

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
import film.interfaces.searchentity.IArt_photosearch;
import film.interfaces.servlet.IArt_photoOperation;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
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

/**
 * @author Franky Laseure
 */
@Path("rsart_photo_update")
public class RSArt_photo_update extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArt_photoOperation.UPDATE_ART_PHOTO:
                    update_art_photo(art_photousecases, json);
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

    private void update_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photo art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
        art_photousecases.updateArt_photo(art_photo);
        setReturnstatus("OK");
    }
}

