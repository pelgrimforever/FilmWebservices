/*
 * WSRoute.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIRoute;
import film.logicentity.Route;
import film.searchentity.Routesearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIRoute")
public class WSRoute implements WSIRoute {

    private JSONArray toJSONArray(ArrayList routes) {
        JSONArray jsonroutes = new JSONArray();
        Iterator routesI = routes.iterator();
        while(routesI.hasNext()) {
            jsonroutes.add(JSONRoute.toJSON((Route)routesI.next()));
        }
        return jsonroutes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getRoutes")
    @Override
    public String getRoutes() {
        try {
            BLroute blroute = new BLroute();
            ArrayList routes = blroute.getAll();
            JSONArray jsonroutes = toJSONArray(routes);
            return jsonroutes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        String result = "";
        Route route;
        try {
            Routesearch routesearch = JSONRoute.toRoutesearch((JSONObject)parser.parse(json));
            ArrayList routes = blroute.search(routesearch);
            JSONArray jsonroutes = toJSONArray(routes);
            result = jsonroutes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getRoute")
    @Override
    public String getRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        String result = "";
        Route route;
        try {
            RoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            route = blroute.getRoute(routePK);
            if(route!=null) {
                result = JSONRoute.toJSON(route).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertRoute")
    @Override
    public void insertRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.insertRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateRoute")
    @Override
    public void updateRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.updateRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteRoute")
    @Override
    public void deleteRoute(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        try {
            IRoute route = JSONRoute.toRoute((JSONObject)parser.parse(json));
            blroute.deleteRoute(route);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getRoutes4sublocality")
    @Override
    public String getRoutes4sublocality(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            ISublocalityPK sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)parser.parse(json));
            ArrayList routes = blroute.getRoutes4sublocality(sublocalityPK);
            JSONArray jsonroutes = toJSONArray(routes);
            return jsonroutes.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4sublocality")
    @Override
    public void delete4sublocality(String json) {
        BLroute blroute = new BLroute();
        JSONParser parser = new JSONParser();
        Route route;
        try {
            ISublocalityPK sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)parser.parse(json));
            blroute.delete4sublocality(sublocalityPK);
        }
        catch(ParseException e) {
        }
    }


}

