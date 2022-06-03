/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.route;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Route_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IRoutesearch;
import film.interfaces.servlet.IRouteOperation;
import film.logicentity.Route;
import film.searchentity.Routesearch;
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
@Path("rsroute_select")
public class RSRoute_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IRoutePK routePK;
            IRoute route;
            Route_usecases routeusecases = new Route_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IRouteOperation.SELECT_COUNT:
                    result = count_records(routeusecases);
                    break;
                case IRouteOperation.SELECT_ALL:
                    result = get_all_route(routeusecases);
                    break;
                case IRouteOperation.SELECT_ROUTE:
                    result = get_route_with_primarykey(routeusecases, json);
                    break;
                case IRouteOperation.SELECT_Sublocality:
                    result = get_route_with_foreignkey_sublocality(routeusecases, json);
                    break;
                case IRouteOperation.SELECT_SEARCH:
                    result = search_route(routeusecases, json);
                    break;
                case IRouteOperation.SELECT_SEARCHCOUNT:
                    result = search_route_count(routeusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IRouteOperation.SELECT_LOCALITY:
                    result = getRoutes4locality(routeusecases, json);
                    break;
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
    private String getRoutes4locality(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        ArrayList<Route> routes = routeusecases.getRoutes4locality(localityPK);
	return JSONRoute.toJSONArray(routes).toJSONString();
    }
//Custom code, do not change this line   

    private String count_records(Route_usecases routeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", routeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_route(Route_usecases routeusecases) throws ParseException, CustomException {
    	return JSONRoute.toJSONArray(routeusecases.get_all()).toJSONString();
    }
    
    private String get_route_with_primarykey(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
	return JSONRoute.toJSON(routeusecases.get_route_by_primarykey(routePK)).toJSONString();
    }
    
    private String get_route_with_foreignkey_sublocality(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
        return JSONRoute.toJSONArray(routeusecases.get_route_with_foreignkey_sublocality(sublocalityPK)).toJSONString();
    }
    
    private String search_route(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutesearch search = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
        return JSONRoute.toJSONArray(routeusecases.search_route(search)).toJSONString();
    }
    
    private String search_route_count(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoutesearch routesearch = (IRoutesearch)JSONRoute.toRoutesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", routeusecases.search_route_count(routesearch));
        return jsonsearchcount.toJSONString();
    }
}

