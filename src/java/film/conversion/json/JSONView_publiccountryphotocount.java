/*
 * JSONView_publiccountryphotocount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_publiccountryphotocount;
import film.logicview.View_publiccountryphotocount;
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
public class JSONView_publiccountryphotocount {
    
    public static JSONArray toJSONArray(ArrayList view_publiccountryphotocounts) {
        JSONArray jsonview_publiccountryphotocounts = new JSONArray();
        Iterator view_publiccountryphotocountsI = view_publiccountryphotocounts.iterator();
        while(view_publiccountryphotocountsI.hasNext()) {
            jsonview_publiccountryphotocounts.add(JSONView_publiccountryphotocount.toJSON((View_publiccountryphotocount)view_publiccountryphotocountsI.next()));
        }
        return jsonview_publiccountryphotocounts;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_publiccountryphotocount view_publiccountryphotocount) {
        JSONObject json = new JSONObject();
        json.put("code", view_publiccountryphotocount.getCode());
        json.put("name", view_publiccountryphotocount.getName());
        json.put("photocount", String.valueOf(view_publiccountryphotocount.getPhotocount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_publiccountryphotocount toView_publiccountryphotocount(JSONObject json) {
        View_publiccountryphotocount view_publiccountryphotocount = new View_publiccountryphotocount();
        view_publiccountryphotocount.setCode(JSONConversion.getString(json, "code"));
        view_publiccountryphotocount.setName(JSONConversion.getString(json, "name"));
        view_publiccountryphotocount.setPhotocount(JSONConversion.getlong(json, "photocount"));
        return view_publiccountryphotocount;
    }

    /**
     * 
     * @param json: JSONObject with the View_publiccountryphotocountsearch parameters
     * @return 
     */
    public static View_publiccountryphotocountsearch toView_publiccountryphotocountsearch(JSONObject json) {
        View_publiccountryphotocountsearch view_publiccountryphotocountsearch = new View_publiccountryphotocountsearch();
        view_publiccountryphotocountsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_publiccountryphotocountsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_publiccountryphotocountsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiccountryphotocountsearch.code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiccountryphotocountsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photocount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_publiccountryphotocountsearch.photocount(valuearray, operators, andor);
        }
        return view_publiccountryphotocountsearch;
    }
}

