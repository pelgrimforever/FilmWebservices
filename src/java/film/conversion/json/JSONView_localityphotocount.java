/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_localityphotocount;
import film.logicview.View_localityphotocount;
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
public class JSONView_localityphotocount {
    
    public static JSONArray toJSONArray(ArrayList view_localityphotocounts) {
        JSONArray jsonview_localityphotocounts = new JSONArray();
        Iterator view_localityphotocountsI = view_localityphotocounts.iterator();
        while(view_localityphotocountsI.hasNext()) {
            jsonview_localityphotocounts.add(JSONView_localityphotocount.toJSON((View_localityphotocount)view_localityphotocountsI.next()));
        }
        return jsonview_localityphotocounts;
    }

    public static JSONObject toJSON(IView_localityphotocount view_localityphotocount) {
        JSONObject json = new JSONObject();
        json.put("countrycode", view_localityphotocount.getCountrycode());
        json.put("locality", view_localityphotocount.getLocality());
        if(view_localityphotocount.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(view_localityphotocount.getLocation()));
        }
        json.put("photocount", String.valueOf(view_localityphotocount.getPhotocount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_localityphotocount toView_localityphotocount(JSONObject json) {
        View_localityphotocount view_localityphotocount = new View_localityphotocount();
        view_localityphotocount.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_localityphotocount.setLocality(JSONConversion.getString(json, "locality"));
        view_localityphotocount.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        view_localityphotocount.setPhotocount(JSONConversion.getlong(json, "photocount"));
        return view_localityphotocount;
    }

    public static View_localityphotocountsearch toView_localityphotocountsearch(JSONObject json) {
        View_localityphotocountsearch view_localityphotocountsearch = new View_localityphotocountsearch();
        view_localityphotocountsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_localityphotocountsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_localityphotocountsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_localityphotocountsearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_localityphotocountsearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photocount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_localityphotocountsearch.photocount(valuearray, operators, andor);
        }
        return view_localityphotocountsearch;
    }
}

