/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.locality;

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
import film.interfaces.searchentity.ILocalitysearch;
import film.interfaces.servlet.ILocalityOperation;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
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
@Path("rslocality_delete")
public class RSLocality_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ILocalityOperation.DELETE_LOCALITY:
                    delete_locality(localityusecases, json);
                    break;
                case ILocalityOperation.DELETE_Postalcode:
                    delete_locality(localityusecases, json);
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

    private void delete_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocality locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
        localityusecases.deleteLocality(locality);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Postalcode(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
        localityusecases.delete_all_containing_Postalcode(postalcodePK);
        setReturnstatus("OK");
    }

}

