/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import film.interfaces.logicview.IView_subjects_for_film;
import film.logicview.View_subjects_for_film;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONView_subjects_for_film {
    
    public static JSONArray toJSONArray(ArrayList view_subjects_for_films) {
        JSONArray jsonview_subjects_for_films = new JSONArray();
        Iterator view_subjects_for_filmsI = view_subjects_for_films.iterator();
        while(view_subjects_for_filmsI.hasNext()) {
            jsonview_subjects_for_films.add(JSONView_subjects_for_film.toJSON((View_subjects_for_film)view_subjects_for_filmsI.next()));
        }
        return jsonview_subjects_for_films;
    }

    public static JSONObject toJSON(IView_subjects_for_film view_subjects_for_film) {
        JSONObject json = new JSONObject();
        json.put("film", view_subjects_for_film.getFilm());
        json.put("cat1", view_subjects_for_film.getCat1());
        json.put("cat2", view_subjects_for_film.getCat2());
        json.put("id", view_subjects_for_film.getId());
        json.put("subject", view_subjects_for_film.getSubject());
        json.put("description", view_subjects_for_film.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static View_subjects_for_film toView_subjects_for_film(JSONObject json) {
        View_subjects_for_film view_subjects_for_film = new View_subjects_for_film();
        view_subjects_for_film.setFilm(JSONConversion.getString(json, "film"));
        view_subjects_for_film.setCat1(JSONConversion.getString(json, "cat1"));
        view_subjects_for_film.setCat2(JSONConversion.getString(json, "cat2"));
        view_subjects_for_film.setId(JSONConversion.getint(json, "id"));
        view_subjects_for_film.setSubject(JSONConversion.getString(json, "subject"));
        view_subjects_for_film.setDescription(JSONConversion.getString(json, "description"));
        return view_subjects_for_film;
    }

    public static View_subjects_for_filmsearch toView_subjects_for_filmsearch(JSONObject json) {
        View_subjects_for_filmsearch view_subjects_for_filmsearch = new View_subjects_for_filmsearch();
        view_subjects_for_filmsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        view_subjects_for_filmsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        view_subjects_for_filmsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("film");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.film(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("cat1");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.cat1(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("cat2");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.cat2(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("subject");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.subject(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            view_subjects_for_filmsearch.description(valuearray, compareoperator, andor);
        }
        return view_subjects_for_filmsearch;
    }
}

