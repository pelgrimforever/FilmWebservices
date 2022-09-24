/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_photolocations;
import film.logicview.View_photolocations;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_photolocations {
    
    public static JSONArray toJSONArray(ArrayList view_photolocationss) {
        JSONArray jsonview_photolocationss = new JSONArray();
        Iterator view_photolocationssI = view_photolocationss.iterator();
        while(view_photolocationssI.hasNext()) {
            jsonview_photolocationss.add(JSONView_photolocations.toJSON((View_photolocations)view_photolocationssI.next()));
        }
        return jsonview_photolocationss;
    }

    public static JSONObject toJSON(IView_photolocations view_photolocations) {
        JSONObject json = new JSONObject();
        if(view_photolocations.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(view_photolocations.getLocation()));
        }
        json.put("exactlocation", view_photolocations.getExactlocation());
        json.put("locationradius", view_photolocations.getLocationradius());
        json.put("countrycode", view_photolocations.getCountrycode());
        json.put("postalcode", view_photolocations.getPostalcode());
        json.put("locality", view_photolocations.getLocality());
        json.put("sublocality", view_photolocations.getSublocality());
        json.put("routecode", view_photolocations.getRoutecode());
        json.put("streetnumber", view_photolocations.getStreetnumber());
        json.put("locationcount", String.valueOf(view_photolocations.getLocationcount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_photolocations toView_photolocations(JSONObject json) {
        View_photolocations view_photolocations = new View_photolocations();
        view_photolocations.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        view_photolocations.setExactlocation(JSONConversion.getboolean(json, "exactlocation"));
        view_photolocations.setLocationradius(JSONConversion.getdouble(json, "locationradius"));
        view_photolocations.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_photolocations.setPostalcode(JSONConversion.getString(json, "postalcode"));
        view_photolocations.setLocality(JSONConversion.getString(json, "locality"));
        view_photolocations.setSublocality(JSONConversion.getString(json, "sublocality"));
        view_photolocations.setRoutecode(JSONConversion.getString(json, "routecode"));
        view_photolocations.setStreetnumber(JSONConversion.getString(json, "streetnumber"));
        view_photolocations.setLocationcount(JSONConversion.getlong(json, "locationcount"));
        return view_photolocations;
    }

    public static View_photolocationssearch toView_photolocationssearch(JSONObject json) {
        View_photolocationssearch view_photolocationssearch = new View_photolocationssearch();
        view_photolocationssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_photolocationssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_photolocationssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("exactlocation");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_photolocationssearch.exactlocation(value);
        }
        field = (JSONObject)fss.get("locationradius");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.locationradius(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("postalcode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.postalcode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("sublocality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.sublocality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("routecode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.routecode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("streetnumber");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.streetnumber(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locationcount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photolocationssearch.locationcount(valuearray, operators, andor);
        }
        return view_photolocationssearch;
    }
}

