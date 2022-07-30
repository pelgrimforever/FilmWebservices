/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.route;

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
import film.interfaces.searchentity.IRoutesearch;
import film.interfaces.servlet.IRouteOperation;
import film.logicentity.Route;
import film.searchentity.Routesearch;
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
@Path("rsroute_delete")
public class RSRoute_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRouteOperation.DELETE_ROUTE:
                    delete_route(routeusecases, json);
                    break;
                case IRouteOperation.DELETE_Sublocality:
                    delete_route(routeusecases, json);
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

    private void delete_route(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoute route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
        routeusecases.deleteRoute(route);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Sublocality(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
        routeusecases.delete_all_containing_Sublocality(sublocalityPK);
        setReturnstatus("OK");
    }

}

