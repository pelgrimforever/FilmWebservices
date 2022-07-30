/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_photo_firstlastdate;
import film.logicview.View_photo_firstlastdate;
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
public class JSONView_photo_firstlastdate {
    
    public static JSONArray toJSONArray(ArrayList view_photo_firstlastdates) {
        JSONArray jsonview_photo_firstlastdates = new JSONArray();
        Iterator view_photo_firstlastdatesI = view_photo_firstlastdates.iterator();
        while(view_photo_firstlastdatesI.hasNext()) {
            jsonview_photo_firstlastdates.add(JSONView_photo_firstlastdate.toJSON((View_photo_firstlastdate)view_photo_firstlastdatesI.next()));
        }
        return jsonview_photo_firstlastdates;
    }

    public static JSONObject toJSON(IView_photo_firstlastdate view_photo_firstlastdate) {
        JSONObject json = new JSONObject();
        if(view_photo_firstlastdate.getMinphotodate()!=null) {
	        json.put("minphotodate", view_photo_firstlastdate.getMinphotodate().getTime());
        }
        if(view_photo_firstlastdate.getMaxphotodate()!=null) {
	        json.put("maxphotodate", view_photo_firstlastdate.getMaxphotodate().getTime());
        }
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_photo_firstlastdate toView_photo_firstlastdate(JSONObject json) {
        View_photo_firstlastdate view_photo_firstlastdate = new View_photo_firstlastdate();
        view_photo_firstlastdate.setMinphotodate(JSONConversion.getDate(json, "minphotodate"));
        view_photo_firstlastdate.setMaxphotodate(JSONConversion.getDate(json, "maxphotodate"));
        return view_photo_firstlastdate;
    }

    public static View_photo_firstlastdatesearch toView_photo_firstlastdatesearch(JSONObject json) {
        View_photo_firstlastdatesearch view_photo_firstlastdatesearch = new View_photo_firstlastdatesearch();
        view_photo_firstlastdatesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_photo_firstlastdatesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_photo_firstlastdatesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("minphotodate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photo_firstlastdatesearch.minphotodate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("maxphotodate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photo_firstlastdatesearch.maxphotodate(valuearray, operators, andor);
        }
        return view_photo_firstlastdatesearch;
    }
}

