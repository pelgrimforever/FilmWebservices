/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.arealevel1;

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
import film.interfaces.searchentity.IArealevel1search;
import film.interfaces.servlet.IArealevel1Operation;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
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
@Path("rsarealevel1_insert")
public class RSArealevel1_insert extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel1Operation.INSERT_AREALEVEL1:
                    insert_arealevel1(arealevel1usecases, json);
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

    private void insert_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1 arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
        arealevel1usecases.insertArealevel1(arealevel1);
        setReturnstatus("OK");
    }
}

