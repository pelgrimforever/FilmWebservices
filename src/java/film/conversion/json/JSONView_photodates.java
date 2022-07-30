/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_photodates;
import film.logicview.View_photodates;
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
public class JSONView_photodates {
    
    public static JSONArray toJSONArray(ArrayList view_photodatess) {
        JSONArray jsonview_photodatess = new JSONArray();
        Iterator view_photodatessI = view_photodatess.iterator();
        while(view_photodatessI.hasNext()) {
            jsonview_photodatess.add(JSONView_photodates.toJSON((View_photodates)view_photodatessI.next()));
        }
        return jsonview_photodatess;
    }

    public static JSONObject toJSON(IView_photodates view_photodates) {
        JSONObject json = new JSONObject();
        if(view_photodates.getPhotodate()!=null) {
	        json.put("photodate", view_photodates.getPhotodate().getTime());
        }
        json.put("photos", String.valueOf(view_photodates.getPhotos()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_photodates toView_photodates(JSONObject json) {
        View_photodates view_photodates = new View_photodates();
        view_photodates.setPhotodate(JSONConversion.getDate(json, "photodate"));
        view_photodates.setPhotos(JSONConversion.getlong(json, "photos"));
        return view_photodates;
    }

    public static View_photodatessearch toView_photodatessearch(JSONObject json) {
        View_photodatessearch view_photodatessearch = new View_photodatessearch();
        view_photodatessearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_photodatessearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_photodatessearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("photodate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photodatessearch.photodate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("photos");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photodatessearch.photos(valuearray, operators, andor);
        }
        return view_photodatessearch;
    }
}

