/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.securityprofile;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.interfaces.servlet.ISecurityprofileOperation;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rssecurityprofile_update")
public class RSSecurityprofile_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISecurityprofileOperation.UPDATE_SECURITYPROFILE:
                    update_securityprofile(securityprofileusecases, json);
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

    private void update_securityprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
        securityprofileusecases.secureupdateSecurityprofile(securityprofile);
        setReturnstatus("OK");
    }
}

