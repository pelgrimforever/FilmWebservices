/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IRoutesearch;
import film.interfaces.webservice.WSIRoute;
import film.logicentity.Route;
import film.searchentity.Routesearch;
import film.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import film.usecases.custom.Security_usecases;

@WebService(endpointInterface = "film.interfaces.webservice.WSIRoute")
public class WSRoute extends RS_json_login implements WSIRoute {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList routes) {
        JSONArray jsonroutes = new JSONArray();
        Iterator routesI = routes.iterator();
        while(routesI.hasNext()) {
            jsonroutes.add(JSONRoute.toJSON((Route)routesI.next()));
        }
        return jsonroutes;
    }

    //@WebMethod(operationName = "getRoutes")
    @Override
    public String getRoutes() {
        try {
            Route_usecases routeusecases = new Route_usecases(loggedin);
            return get_all_route(routeusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            return search_route(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getRoute")
    @Override
    public String getRoute(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            return get_route_with_primarykey(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertRoute")
    @Override
    public void insertRoute(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            insert_route(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateRoute")
    @Override
    public void updateRoute(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            update_route(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteRoute")
    @Override
    public void deleteRoute(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            delete_route(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getRoutes4sublocality")
    @Override
    public String getRoutes4sublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            return get_route_with_foreignkey_sublocality(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4sublocality")
    @Override
    public void delete4sublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Route_usecases routeusecases = new Route_usecases(loggedin);
            delete_route(routeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_route(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoute route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
        routeusecases.insertRoute(route);
        setReturnstatus("OK");
    }

    private void update_route(Route_usecases routeusecases, JSONObject json) throws ParseException, CustomException {
        IRoute route = (IRoute)JSONRoute.toRoute((JSONObject)json.get("route"));
        routeusecases.updateRoute(route);
        setReturnstatus("OK");
    }

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

