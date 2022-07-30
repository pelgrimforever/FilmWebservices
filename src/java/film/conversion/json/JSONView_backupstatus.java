/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_backupstatus;
import film.logicview.View_backupstatus;
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
public class JSONView_backupstatus {
    
    public static JSONArray toJSONArray(ArrayList view_backupstatuss) {
        JSONArray jsonview_backupstatuss = new JSONArray();
        Iterator view_backupstatussI = view_backupstatuss.iterator();
        while(view_backupstatussI.hasNext()) {
            jsonview_backupstatuss.add(JSONView_backupstatus.toJSON((View_backupstatus)view_backupstatussI.next()));
        }
        return jsonview_backupstatuss;
    }

    public static JSONObject toJSON(IView_backupstatus view_backupstatus) {
        JSONObject json = new JSONObject();
        json.put("id", view_backupstatus.getId());
        json.put("photocount", String.valueOf(view_backupstatus.getPhotocount()));
        json.put("backupcount", String.valueOf(view_backupstatus.getBackupcount()));
        json.put("imagebackupcount", String.valueOf(view_backupstatus.getImagebackupcount()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_backupstatus toView_backupstatus(JSONObject json) {
        View_backupstatus view_backupstatus = new View_backupstatus();
        view_backupstatus.setId(JSONConversion.getString(json, "id"));
        view_backupstatus.setPhotocount(JSONConversion.getlong(json, "photocount"));
        view_backupstatus.setBackupcount(JSONConversion.getlong(json, "backupcount"));
        view_backupstatus.setImagebackupcount(JSONConversion.getlong(json, "imagebackupcount"));
        return view_backupstatus;
    }

    public static View_backupstatussearch toView_backupstatussearch(JSONObject json) {
        View_backupstatussearch view_backupstatussearch = new View_backupstatussearch();
        view_backupstatussearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_backupstatussearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_backupstatussearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_backupstatussearch.id(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photocount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_backupstatussearch.photocount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("backupcount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_backupstatussearch.backupcount(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("imagebackupcount");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_backupstatussearch.imagebackupcount(valuearray, operators, andor);
        }
        return view_backupstatussearch;
    }
}

