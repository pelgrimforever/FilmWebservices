/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_subjects_for_photo;
import film.logicview.View_subjects_for_photo;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_subjects_for_photo {
    
    public static JSONArray toJSONArray(ArrayList view_subjects_for_photos) {
        JSONArray jsonview_subjects_for_photos = new JSONArray();
        Iterator view_subjects_for_photosI = view_subjects_for_photos.iterator();
        while(view_subjects_for_photosI.hasNext()) {
            jsonview_subjects_for_photos.add(JSONView_subjects_for_photo.toJSON((View_subjects_for_photo)view_subjects_for_photosI.next()));
        }
        return jsonview_subjects_for_photos;
    }

    public static JSONObject toJSON(IView_subjects_for_photo view_subjects_for_photo) {
        JSONObject json = new JSONObject();
        json.put("film", view_subjects_for_photo.getFilm());
        json.put("photoid", view_subjects_for_photo.getPhotoid());
        json.put("cat1", view_subjects_for_photo.getCat1());
        json.put("cat2", view_subjects_for_photo.getCat2());
        json.put("id", view_subjects_for_photo.getId());
        json.put("subject", view_subjects_for_photo.getSubject());
        json.put("description", view_subjects_for_photo.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_subjects_for_photo toView_subjects_for_photo(JSONObject json) {
        View_subjects_for_photo view_subjects_for_photo = new View_subjects_for_photo();
        view_subjects_for_photo.setFilm(JSONConversion.getString(json, "film"));
        view_subjects_for_photo.setPhotoid(JSONConversion.getint(json, "photoid"));
        view_subjects_for_photo.setCat1(JSONConversion.getString(json, "cat1"));
        view_subjects_for_photo.setCat2(JSONConversion.getString(json, "cat2"));
        view_subjects_for_photo.setId(JSONConversion.getint(json, "id"));
        view_subjects_for_photo.setSubject(JSONConversion.getString(json, "subject"));
        view_subjects_for_photo.setDescription(JSONConversion.getString(json, "description"));
        return view_subjects_for_photo;
    }

    public static View_subjects_for_photosearch toView_subjects_for_photosearch(JSONObject json) {
        View_subjects_for_photosearch view_subjects_for_photosearch = new View_subjects_for_photosearch();
        view_subjects_for_photosearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_subjects_for_photosearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_subjects_for_photosearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("film");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.film(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photoid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.photoid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("cat1");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.cat1(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("cat2");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.cat2(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("subject");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.subject(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_photosearch.description(valuearray, compareoperator, andor);
        }
        return view_subjects_for_photosearch;
    }
}

