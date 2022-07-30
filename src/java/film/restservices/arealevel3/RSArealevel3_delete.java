/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.arealevel3;

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
import film.interfaces.searchentity.IArealevel3search;
import film.interfaces.servlet.IArealevel3Operation;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
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
@Path("rsarealevel3_delete")
public class RSArealevel3_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArealevel3Operation.DELETE_AREALEVEL3:
                    delete_arealevel3(arealevel3usecases, json);
                    break;
                case IArealevel3Operation.DELETE_Arealevel2:
                    delete_arealevel3(arealevel3usecases, json);
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

    private void delete_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3 arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
        arealevel3usecases.deleteArealevel3(arealevel3);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel2(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        arealevel3usecases.delete_all_containing_Arealevel2(arealevel2PK);
        setReturnstatus("OK");
    }

}

