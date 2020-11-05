package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIFilmsubjects;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIFilmsubjects")
public class WSFilmsubjects implements WSIFilmsubjects {

    private JSONArray toJSONArray(ArrayList filmsubjectss) {
        JSONArray jsonfilmsubjectss = new JSONArray();
        Iterator filmsubjectssI = filmsubjectss.iterator();
        while(filmsubjectssI.hasNext()) {
            jsonfilmsubjectss.add(JSONFilmsubjects.toJSON((Filmsubjects)filmsubjectssI.next()));
        }
        return jsonfilmsubjectss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFilmsubjectss")
    @Override
    public String getFilmsubjectss() {
        try {
            BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
            ArrayList filmsubjectss = blfilmsubjects.getAll();
            JSONArray jsonfilmsubjectss = toJSONArray(filmsubjectss);
            return jsonfilmsubjectss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        String result = "";
        Filmsubjects filmsubjects;
        try {
            Filmsubjectssearch filmsubjectssearch = JSONFilmsubjects.toFilmsubjectssearch((JSONObject)parser.parse(json));
            ArrayList filmsubjectss = blfilmsubjects.search(filmsubjectssearch);
            JSONArray jsonfilmsubjectss = toJSONArray(filmsubjectss);
            result = jsonfilmsubjectss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFilmsubjects")
    @Override
    public String getFilmsubjects(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        String result = "";
        Filmsubjects filmsubjects;
        try {
            FilmsubjectsPK filmsubjectsPK = JSONFilmsubjects.toFilmsubjectsPK((JSONObject)parser.parse(json));
            filmsubjects = blfilmsubjects.getFilmsubjects(filmsubjectsPK);
            if(filmsubjects!=null) {
                result = JSONFilmsubjects.toJSON(filmsubjects).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFilmsubjects")
    @Override
    public void insertFilmsubjects(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        try {
            IFilmsubjects filmsubjects = JSONFilmsubjects.toFilmsubjects((JSONObject)parser.parse(json));
            blfilmsubjects.insertFilmsubjects(filmsubjects);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFilmsubjects")
    @Override
    public void updateFilmsubjects(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        try {
            IFilmsubjects filmsubjects = JSONFilmsubjects.toFilmsubjects((JSONObject)parser.parse(json));
            blfilmsubjects.updateFilmsubjects(filmsubjects);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilmsubjects")
    @Override
    public void deleteFilmsubjects(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        try {
            IFilmsubjects filmsubjects = JSONFilmsubjects.toFilmsubjects((JSONObject)parser.parse(json));
            blfilmsubjects.deleteFilmsubjects(filmsubjects);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getFilmsubjectss4subject")
    @Override
    public String getFilmsubjectss4subject(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        Filmsubjects filmsubjects;
        try {
            ISubjectPK subjectPK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            ArrayList filmsubjectss = blfilmsubjects.getFilmsubjectss4subject(subjectPK);
            JSONArray jsonfilmsubjectss = toJSONArray(filmsubjectss);
            return jsonfilmsubjectss.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subject")
    @Override
    public void delete4subject(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        Filmsubjects filmsubjects;
        try {
            ISubjectPK subjectPK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            blfilmsubjects.delete4subject(this.getClass().getName(), subjectPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilmsubjectss4film")
    @Override
    public String getFilmsubjectss4film(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        Filmsubjects filmsubjects;
        try {
            IFilmPK filmPK = JSONFilm.toFilmPK((JSONObject)parser.parse(json));
            ArrayList filmsubjectss = blfilmsubjects.getFilmsubjectss4film(filmPK);
            JSONArray jsonfilmsubjectss = toJSONArray(filmsubjectss);
            return jsonfilmsubjectss.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4film")
    @Override
    public void delete4film(String json) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        Filmsubjects filmsubjects;
        try {
            IFilmPK filmPK = JSONFilm.toFilmPK((JSONObject)parser.parse(json));
            blfilmsubjects.delete4film(this.getClass().getName(), filmPK);
        }
        catch(ParseException e) {
        }
    }


}

