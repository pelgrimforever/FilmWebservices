/*
 * WSFilmtype.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIFilmtype;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIFilmtype")
public class WSFilmtype implements WSIFilmtype {

    private JSONArray toJSONArray(ArrayList filmtypes) {
        JSONArray jsonfilmtypes = new JSONArray();
        Iterator filmtypesI = filmtypes.iterator();
        while(filmtypesI.hasNext()) {
            jsonfilmtypes.add(JSONFilmtype.toJSON((Filmtype)filmtypesI.next()));
        }
        return jsonfilmtypes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFilmtypes")
    @Override
    public String getFilmtypes() {
        try {
            BLfilmtype blfilmtype = new BLfilmtype();
            ArrayList filmtypes = blfilmtype.getAll();
            JSONArray jsonfilmtypes = toJSONArray(filmtypes);
            return jsonfilmtypes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        String result = "";
        Filmtype filmtype;
        try {
            Filmtypesearch filmtypesearch = JSONFilmtype.toFilmtypesearch((JSONObject)parser.parse(json));
            ArrayList filmtypes = blfilmtype.search(filmtypesearch);
            JSONArray jsonfilmtypes = toJSONArray(filmtypes);
            result = jsonfilmtypes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFilmtype")
    @Override
    public String getFilmtype(String json) {
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        String result = "";
        Filmtype filmtype;
        try {
            FilmtypePK filmtypePK = JSONFilmtype.toFilmtypePK((JSONObject)parser.parse(json));
            filmtype = blfilmtype.getFilmtype(filmtypePK);
            if(filmtype!=null) {
                result = JSONFilmtype.toJSON(filmtype).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFilmtype")
    @Override
    public void insertFilmtype(String json) {
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        try {
            IFilmtype filmtype = JSONFilmtype.toFilmtype((JSONObject)parser.parse(json));
            blfilmtype.insertFilmtype(filmtype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFilmtype")
    @Override
    public void updateFilmtype(String json) {
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        try {
            IFilmtype filmtype = JSONFilmtype.toFilmtype((JSONObject)parser.parse(json));
            blfilmtype.updateFilmtype(filmtype);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilmtype")
    @Override
    public void deleteFilmtype(String json) {
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        try {
            IFilmtype filmtype = JSONFilmtype.toFilmtype((JSONObject)parser.parse(json));
            blfilmtype.deleteFilmtype(filmtype);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

