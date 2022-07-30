/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_locality_photolocations;
import film.logicview.View_locality_photolocations;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONView_locality_photolocations {
    
    public static JSONArray toJSONArray(ArrayList view_locality_photolocationss) {
        JSONArray jsonview_locality_photolocationss = new JSONArray();
        Iterator view_locality_photolocationssI = view_locality_photolocationss.iterator();
        while(view_locality_photolocationssI.hasNext()) {
            jsonview_locality_photolocationss.add(JSONView_locality_photolocations.toJSON((View_locality_photolocations)view_locality_photolocationssI.next()));
        }
        return jsonview_locality_photolocationss;
    }

    public static JSONObject toJSON(IView_locality_photolocations view_locality_photolocations) {
        JSONObject json = new JSONObject();
        json.put("countrycode", view_locality_photolocations.getCountrycode());
        json.put("locality", view_locality_photolocations.getLocality());
        if(view_locality_photolocations.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(view_locality_photolocations.getLocation()));
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_locality_photolocations toView_locality_photolocations(JSONObject json) {
        View_locality_photolocations view_locality_photolocations = new View_locality_photolocations();
        view_locality_photolocations.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_locality_photolocations.setLocality(JSONConversion.getString(json, "locality"));
        view_locality_photolocations.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        return view_locality_photolocations;
    }

    public static View_locality_photolocationssearch toView_locality_photolocationssearch(JSONObject json) {
        View_locality_photolocationssearch view_locality_photolocationssearch = new View_locality_photolocationssearch();
        view_locality_photolocationssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_locality_photolocationssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_locality_photolocationssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locality_photolocationssearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locality_photolocationssearch.locality(valuearray, compareoperator, andor);
        }
        return view_locality_photolocationssearch;
    }
}

