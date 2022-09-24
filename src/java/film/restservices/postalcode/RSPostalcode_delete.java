/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.postalcode;

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
import film.interfaces.searchentity.IPostalcodesearch;
import film.interfaces.servlet.IPostalcodeOperation;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
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

@Path("rspostalcode_delete")
public class RSPostalcode_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPostalcodeOperation.DELETE_POSTALCODE:
                    delete_postalcode(postalcodeusecases, json);
                    break;
                case IPostalcodeOperation.DELETE_Arealevel3:
                    delete_postalcode(postalcodeusecases, json);
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

    private void delete_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcode postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
        postalcodeusecases.deletePostalcode(postalcode);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel3(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        postalcodeusecases.delete_all_containing_Arealevel3(arealevel3PK);
        setReturnstatus("OK");
    }

}

