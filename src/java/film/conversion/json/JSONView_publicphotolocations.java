/*
 * JSONView_publicphotolocations.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_publicphotolocations;
import film.logicview.View_publicphotolocations;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Franky Laseure
 */
public class JSONView_publicphotolocations {
    
    public static JSONArray toJSONArray(ArrayList view_publicphotolocationss) {
        JSONArray jsonview_publicphotolocationss = new JSONArray();
        Iterator view_publicphotolocationssI = view_publicphotolocationss.iterator();
        while(view_publicphotolocationssI.hasNext()) {
            jsonview_publicphotolocationss.add(JSONView_publicphotolocations.toJSON((View_publicphotolocations)view_publicphotolocationssI.next()));
        }
        return jsonview_publicphotolocationss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_publicphotolocations view_publicphotolocations) {
        JSONObject json = new JSONObject();
        if(view_publicphotolocations.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(view_publicphotolocations.getLocation()));
        }
        json.put("exactlocation", view_publicphotolocations.getExactlocation());
        json.put("locationradius", view_publicphotolocations.getLocationradius());
        json.put("countrycode", view_publicphotolocations.getCountrycode());
        json.put("postalcode", view_publicphotolocations.getPostalcode());
        json.put("locality", view_publicphotolocations.getLocality());
        json.put("sublocality", view_publicphotolocations.getSublocality());
        json.put("routecode", view_publicphotolocations.getRoutecode());
        json.put("streetnumber", view_publicphotolocations.getStreetnumber());
        json.put("locationcount", String.valueOf(view_publicphotolocations.getLocationcount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_publicphotolocations toView_publicphotolocations(JSONObject json) {
        View_publicphotolocations view_publicphotolocations = new View_publicphotolocations();
        view_publicphotolocations.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        view_publicphotolocations.setExactlocation(JSONConversion.getboolean(json, "exactlocation"));
        view_publicphotolocations.setLocationradius(JSONConversion.getdouble(json, "locationradius"));
        view_publicphotolocations.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_publicphotolocations.setPostalcode(JSONConversion.getString(json, "postalcode"));
        view_publicphotolocations.setLocality(JSONConversion.getString(json, "locality"));
        view_publicphotolocations.setSublocality(JSONConversion.getString(json, "sublocality"));
        view_publicphotolocations.setRoutecode(JSONConversion.getString(json, "routecode"));
        view_publicphotolocations.setStreetnumber(JSONConversion.getString(json, "streetnumber"));
        view_publicphotolocations.setLocationcount(JSONConversion.getlong(json, "locationcount"));
        return view_publicphotolocations;
    }

    /**
     * 
     * @param json: JSONObject with the View_publicphotolocationssearch parameters
     * @return 
     */
    public static View_publicphotolocationssearch toView_publicphotolocationssearch(JSONObject json) {
        View_publicphotolocationssearch view_publicphotolocationssearch = new View_publicphotolocationssearch();
        view_publicphotolocationssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_publicphotolocationssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_publicphotolocationssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("exactlocation");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_publicphotolocationssearch.exactlocation(value);
        }
        field = (JSONObject)fss.get("locationradius");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.locationradius(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("postalcode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.postalcode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sublocality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.sublocality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("routecode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.routecode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("streetnumber");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.streetnumber(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locationcount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publicphotolocationssearch.locationcount(valuearray, operators, andor);
        }
        return view_publicphotolocationssearch;
    }
}

