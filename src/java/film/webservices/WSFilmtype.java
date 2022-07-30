/*
 * WSFilmtype.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IFilmtypesearch;
import film.interfaces.webservice.WSIFilmtype;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
import film.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import film.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIFilmtype")
public class WSFilmtype extends RS_json_login implements WSIFilmtype {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList filmtypes) {
        JSONArray jsonfilmtypes = new JSONArray();
        Iterator filmtypesI = filmtypes.iterator();
        while(filmtypesI.hasNext()) {
            jsonfilmtypes.add(JSONFilmtype.toJSON((Filmtype)filmtypesI.next()));
        }
        return jsonfilmtypes;
    }

    //@WebMethod(operationName = "getFilmtypes")
    @Override
    public String getFilmtypes() {
        try {
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            return get_all_filmtype(filmtypeusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            return search_filmtype(filmtypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFilmtype")
    @Override
    public String getFilmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            return get_filmtype_with_primarykey(filmtypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFilmtype")
    @Override
    public void insertFilmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            insert_filmtype(filmtypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFilmtype")
    @Override
    public void updateFilmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            update_filmtype(filmtypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilmtype")
    @Override
    public void deleteFilmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
            delete_filmtype(filmtypeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Filmtype_usecases filmtypeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", filmtypeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_filmtype(Filmtype_usecases filmtypeusecases) throws ParseException, CustomException {
    	return JSONFilmtype.toJSONArray(filmtypeusecases.get_all()).toJSONString();
    }
    
    private String get_filmtype_with_primarykey(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
	return JSONFilmtype.toJSON(filmtypeusecases.get_filmtype_by_primarykey(filmtypePK)).toJSONString();
    }
    
    private String search_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypesearch search = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
        return JSONFilmtype.toJSONArray(filmtypeusecases.search_filmtype(search)).toJSONString();
    }
    
    private String search_filmtype_count(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypesearch filmtypesearch = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", filmtypeusecases.search_filmtype_count(filmtypesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtype filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
        filmtypeusecases.insertFilmtype(filmtype);
        setReturnstatus("OK");
    }

    private void update_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtype filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
        filmtypeusecases.updateFilmtype(filmtype);
        setReturnstatus("OK");
    }

    private void delete_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtype filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
        filmtypeusecases.deleteFilmtype(filmtype);
        setReturnstatus("OK");
    }

}

