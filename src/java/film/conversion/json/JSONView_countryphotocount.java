/*
 * JSONView_countryphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_countryphotocount;
import film.logicview.View_countryphotocount;
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
public class JSONView_countryphotocount {
    
    public static JSONArray toJSONArray(ArrayList view_countryphotocounts) {
        JSONArray jsonview_countryphotocounts = new JSONArray();
        Iterator view_countryphotocountsI = view_countryphotocounts.iterator();
        while(view_countryphotocountsI.hasNext()) {
            jsonview_countryphotocounts.add(JSONView_countryphotocount.toJSON((View_countryphotocount)view_countryphotocountsI.next()));
        }
        return jsonview_countryphotocounts;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_countryphotocount view_countryphotocount) {
        JSONObject json = new JSONObject();
        json.put("code", view_countryphotocount.getCode());
        json.put("name", view_countryphotocount.getName());
        json.put("photocount", String.valueOf(view_countryphotocount.getPhotocount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_countryphotocount toView_countryphotocount(JSONObject json) {
        View_countryphotocount view_countryphotocount = new View_countryphotocount();
        view_countryphotocount.setCode(JSONConversion.getString(json, "code"));
        view_countryphotocount.setName(JSONConversion.getString(json, "name"));
        view_countryphotocount.setPhotocount(JSONConversion.getlong(json, "photocount"));
        return view_countryphotocount;
    }

    /**
     * 
     * @param json: JSONObject with the View_countryphotocountsearch parameters
     * @return 
     */
    public static View_countryphotocountsearch toView_countryphotocountsearch(JSONObject json) {
        View_countryphotocountsearch view_countryphotocountsearch = new View_countryphotocountsearch();
        view_countryphotocountsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_countryphotocountsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_countryphotocountsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_countryphotocountsearch.code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_countryphotocountsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photocount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_countryphotocountsearch.photocount(valuearray, operators, andor);
        }
        return view_countryphotocountsearch;
    }
}

