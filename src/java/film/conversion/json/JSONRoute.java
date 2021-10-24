/*
 * JSONRoute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.RoutePK;
import film.interfaces.entity.pk.IRoutePK;
import film.interfaces.logicentity.IRoute;
import film.logicentity.Route;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONRoute {
    
    public static JSONArray toJSONArray(ArrayList routes) {
        JSONArray jsonroutes = new JSONArray();
        Iterator routesI = routes.iterator();
        while(routesI.hasNext()) {
            jsonroutes.add(toJSON((Route)routesI.next()));
        }
        return jsonroutes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRoutePK routePK) {
        JSONObject json = null;
        if(routePK!=null) {
            json = new JSONObject();
            json.put("countrycode", routePK.getCountrycode());
            json.put("postalcode", routePK.getPostalcode());
            json.put("locality", routePK.getLocality());
            json.put("sublocality", routePK.getSublocality());
            json.put("routecode", routePK.getRoutecode());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IRoute route) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(route.getPrimaryKey()));
        json.put("name", route.getName());
        if(route.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(route.getLocation()));
        }
        if(route.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(route.getBounds()));
        }
        if(route.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(route.getViewport()));
        }
        json.put("approximate", route.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Routesearch routesearch) {
        JSONObject json = new JSONObject();
        if(routesearch.used()) {
            byte andoroperator = routesearch.getAndoroperator();
            int maxresults = routesearch.getMaxresults();
            boolean docount = routesearch.getDocount();
            Iterator<EntityPK> primarykeysI = routesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = routesearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(routesearch.getSublocalitysearch()!=null && routesearch.getSublocalitysearch().used()) {
                kss.put("sublocalitysearcher", JSONSublocality.toJSON((Sublocalitysearch)routesearch.getSublocalitysearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Routesearch toRoutesearch(JSONObject json) {
        Routesearch routesearch = new Routesearch();
        routesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        routesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        routesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            routesearch.addPrimarykey(RoutePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("routecode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            routesearch.routecode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            routesearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            routesearch.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("sublocalitysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Sublocalitysearch sublocalitysearch = JSONSublocality.toSublocalitysearch((JSONObject)keysearch.get(i));
                routesearch.sublocality(sublocalitysearch);
            }
        }
        return routesearch;
    }
    
    public static RoutePK toRoutePK(JSONObject json) {
        RoutePK routePK = null;
        if(json!=null) {
            routePK = new RoutePK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "postalcode"), JSONConversion.getString(json, "locality"), JSONConversion.getString(json, "sublocality"), JSONConversion.getString(json, "routecode"));
        }
        return routePK;
    }

    public static Route toRoute(JSONObject json) {
        Route route = new Route(toRoutePK((JSONObject)json.get("PK")));
        updateRoute(route, json);
        return route;
    }

    public static void updateRoute(IRoute route, JSONObject json) {
        route.setName(JSONConversion.getString(json, "name"));
        route.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        route.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        route.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        route.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Route initRoute(JSONObject json) {
        Route route = new Route(toRoutePK((JSONObject)json.get("PK")));
        route.initName(JSONConversion.getString(json, "name"));
        route.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        route.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        route.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        route.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return route;
    }
}

