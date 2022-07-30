/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_locationtree;
import film.logicview.View_locationtree;
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
public class JSONView_locationtree {
    
    public static JSONArray toJSONArray(ArrayList view_locationtrees) {
        JSONArray jsonview_locationtrees = new JSONArray();
        Iterator view_locationtreesI = view_locationtrees.iterator();
        while(view_locationtreesI.hasNext()) {
            jsonview_locationtrees.add(JSONView_locationtree.toJSON((View_locationtree)view_locationtreesI.next()));
        }
        return jsonview_locationtrees;
    }

    public static JSONObject toJSON(IView_locationtree view_locationtree) {
        JSONObject json = new JSONObject();
        json.put("countrycode", view_locationtree.getCountrycode());
        json.put("countryname", view_locationtree.getCountryname());
        json.put("postalcode", view_locationtree.getPostalcode());
        json.put("al1code", view_locationtree.getAl1code());
        json.put("al1name", view_locationtree.getAl1name());
        json.put("al2code", view_locationtree.getAl2code());
        json.put("al2name", view_locationtree.getAl2name());
        json.put("al3code", view_locationtree.getAl3code());
        json.put("al3name", view_locationtree.getAl3name());
        json.put("locality", view_locationtree.getLocality());
        json.put("hassublocality", view_locationtree.getHassublocality());
        json.put("sublocality", view_locationtree.getSublocality());
        json.put("routecode", view_locationtree.getRoutecode());
        json.put("routename", view_locationtree.getRoutename());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_locationtree toView_locationtree(JSONObject json) {
        View_locationtree view_locationtree = new View_locationtree();
        view_locationtree.setCountrycode(JSONConversion.getString(json, "countrycode"));
        view_locationtree.setCountryname(JSONConversion.getString(json, "countryname"));
        view_locationtree.setPostalcode(JSONConversion.getString(json, "postalcode"));
        view_locationtree.setAl1code(JSONConversion.getString(json, "al1code"));
        view_locationtree.setAl1name(JSONConversion.getString(json, "al1name"));
        view_locationtree.setAl2code(JSONConversion.getString(json, "al2code"));
        view_locationtree.setAl2name(JSONConversion.getString(json, "al2name"));
        view_locationtree.setAl3code(JSONConversion.getString(json, "al3code"));
        view_locationtree.setAl3name(JSONConversion.getString(json, "al3name"));
        view_locationtree.setLocality(JSONConversion.getString(json, "locality"));
        view_locationtree.setHassublocality(JSONConversion.getboolean(json, "hassublocality"));
        view_locationtree.setSublocality(JSONConversion.getString(json, "sublocality"));
        view_locationtree.setRoutecode(JSONConversion.getString(json, "routecode"));
        view_locationtree.setRoutename(JSONConversion.getString(json, "routename"));
        return view_locationtree;
    }

    public static View_locationtreesearch toView_locationtreesearch(JSONObject json) {
        View_locationtreesearch view_locationtreesearch = new View_locationtreesearch();
        view_locationtreesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_locationtreesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_locationtreesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("countryname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.countryname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("postalcode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.postalcode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al1code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al1code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al1name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al1name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al2code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al2code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al2name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al2name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al3code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al3code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("al3name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.al3name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("hassublocality");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            view_locationtreesearch.hassublocality(value);
        }
        field = (JSONObject)fss.get("sublocality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.sublocality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("routecode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.routecode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("routename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_locationtreesearch.routename(valuearray, compareoperator, andor);
        }
        return view_locationtreesearch;
    }
}

