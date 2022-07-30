/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.arealevel2;

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
import film.interfaces.searchentity.IArealevel2search;
import film.interfaces.servlet.IArealevel2Operation;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
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
@Path("rsarealevel2_delete")
public class RSArealevel2_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel2Operation.DELETE_AREALEVEL2:
                    delete_arealevel2(arealevel2usecases, json);
                    break;
                case IArealevel2Operation.DELETE_Arealevel1:
                    delete_arealevel2(arealevel2usecases, json);
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

    private void delete_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2 arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
        arealevel2usecases.deleteArealevel2(arealevel2);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel1(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        arealevel2usecases.delete_all_containing_Arealevel1(arealevel1PK);
        setReturnstatus("OK");
    }

}

