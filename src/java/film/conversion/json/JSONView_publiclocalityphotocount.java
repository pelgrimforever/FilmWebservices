/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_publiclocalityphotocount;
import film.logicview.View_publiclocalityphotocount;
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
public class JSONView_publiclocalityphotocount {
    
    public static JSONArray toJSONArray(ArrayList view_publiclocalityphotocounts) {
        JSONArray jsonview_publiclocalityphotocounts = new JSONArray();
        Iterator view_publiclocalityphotocountsI = view_publiclocalityphotocounts.iterator();
        while(view_publiclocalityphotocountsI.hasNext()) {
            jsonview_publiclocalityphotocounts.add(JSONView_publiclocalityphotocount.toJSON((View_publiclocalityphotocount)view_publiclocalityphotocountsI.next()));
        }
        return jsonview_publiclocalityphotocounts;
    }

    public static JSONObject toJSON(IView_publiclocalityphotocount view_publiclocalityphotocount) {
        JSONObject json = new JSONObject();
        json.put("countrycode", view_publiclocalityphotocount.getCountrycode());
        json.put("locality", view_publiclocalityphotocount.getLocality());
        if(view_publiclocalityphotocount.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(view_publiclocalityphotocount.getLocation()));
        }
        json.put("photocount", String.valueOf(view_publiclocalityphotocount.getPhotocount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_publiclocalityphotocount toView_publiclocalityphotocount(JSONObject json) {
        View_publiclocalityphotocount view_publiclocalityphotocount = new View_publiclocalityphotocount();
        view_publiclocalityphotocount.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_publiclocalityphotocount.setLocality(JSONConversion.getString(json, "locality"));
        view_publiclocalityphotocount.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        view_publiclocalityphotocount.setPhotocount(JSONConversion.getlong(json, "photocount"));
        return view_publiclocalityphotocount;
    }

    public static View_publiclocalityphotocountsearch toView_publiclocalityphotocountsearch(JSONObject json) {
        View_publiclocalityphotocountsearch view_publiclocalityphotocountsearch = new View_publiclocalityphotocountsearch();
        view_publiclocalityphotocountsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_publiclocalityphotocountsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_publiclocalityphotocountsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiclocalityphotocountsearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiclocalityphotocountsearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photocount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiclocalityphotocountsearch.photocount(valuearray, operators, andor);
        }
        return view_publiclocalityphotocountsearch;
    }
}

