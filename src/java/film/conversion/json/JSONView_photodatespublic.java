/*
 * JSONView_photodatespublic.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_photodatespublic;
import film.logicview.View_photodatespublic;
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
public class JSONView_photodatespublic {
    
    public static JSONArray toJSONArray(ArrayList view_photodatespublics) {
        JSONArray jsonview_photodatespublics = new JSONArray();
        Iterator view_photodatespublicsI = view_photodatespublics.iterator();
        while(view_photodatespublicsI.hasNext()) {
            jsonview_photodatespublics.add(JSONView_photodatespublic.toJSON((View_photodatespublic)view_photodatespublicsI.next()));
        }
        return jsonview_photodatespublics;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IView_photodatespublic view_photodatespublic) {
        JSONObject json = new JSONObject();
        if(view_photodatespublic.getPhotodate()!=null) {
	        json.put("photodate", view_photodatespublic.getPhotodate().getTime());
        }
        json.put("photos", String.valueOf(view_photodatespublic.getPhotos()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_photodatespublic toView_photodatespublic(JSONObject json) {
        View_photodatespublic view_photodatespublic = new View_photodatespublic();
        view_photodatespublic.setPhotodate(JSONConversion.getDate(json, "photodate"));
        view_photodatespublic.setPhotos(JSONConversion.getlong(json, "photos"));
        return view_photodatespublic;
    }

    /**
     * 
     * @param json: JSONObject with the View_photodatespublicsearch parameters
     * @return 
     */
    public static View_photodatespublicsearch toView_photodatespublicsearch(JSONObject json) {
        View_photodatespublicsearch view_photodatespublicsearch = new View_photodatespublicsearch();
        view_photodatespublicsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_photodatespublicsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_photodatespublicsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("photodate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photodatespublicsearch.photodate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("photos");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_photodatespublicsearch.photos(valuearray, operators, andor);
        }
        return view_photodatespublicsearch;
    }
}

