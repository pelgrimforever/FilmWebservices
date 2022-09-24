/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

@Path("rsart_photo_delete")
public class RSArt_photo_delete extends RS_json_login {

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
                case IArt_photoOperation.DELETE_ART_PHOTO:
                    delete_art_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.DELETE_Photo:
                    delete_art_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.DELETE_Art_subgroup:
                    delete_art_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.DELETE_Art_academy:
                    delete_art_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.DELETE_Art_group:
                    delete_art_photo(art_photousecases, json);
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

    private void delete_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photo art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
        art_photousecases.deleteArt_photo(art_photo);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        art_photousecases.delete_all_containing_Photo(photoPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_subgroup(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
        art_photousecases.delete_all_containing_Art_subgroup(art_subgroupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_academy(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
        art_photousecases.delete_all_containing_Art_academy(art_academyPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_group(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        art_photousecases.delete_all_containing_Art_group(art_groupPK);
        setReturnstatus("OK");
    }

}

