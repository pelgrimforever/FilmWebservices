/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.country;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.usecases.custom.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ICountrysearch;
import film.interfaces.servlet.ICountryOperation;
import film.logicentity.Country;
import film.searchentity.Countrysearch;
import film.servlets.DataServlet;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

@Path("rscountry_select")
public class RSCountry_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ICountryOperation.SELECT_COUNT:
                    result = count_records(countryusecases);
                    break;
                case ICountryOperation.SELECT_ALL:
                    result = get_all_country(countryusecases);
                    break;
                case ICountryOperation.SELECT_COUNTRY:
                    result = get_country_with_primarykey(countryusecases, json);
                    break;
                case ICountryOperation.SELECT_Arealevel1:
                    result = get_country_with_externalforeignkey_arealevel1(countryusecases, json);
                    break;
                case ICountryOperation.SELECT_SEARCH:
                    result = search_country(countryusecases, json);
                    break;
                case ICountryOperation.SELECT_SEARCHCOUNT:
                    result = search_country_count(countryusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private String count_records(Country_usecases countryusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", countryusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_country(Country_usecases countryusecases) throws ParseException, CustomException {
    	return JSONCountry.toJSONArray(countryusecases.get_all()).toJSONString();
    }
    
    private String get_country_with_primarykey(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
	return JSONCountry.toJSON(countryusecases.get_country_by_primarykey(countryPK)).toJSONString();
    }
    
    private String get_country_with_externalforeignkey_arealevel1(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        return JSONCountry.toJSON(countryusecases.get_country_with_externalforeignkey_arealevel1(arealevel1PK)).toJSONString();
    }
    
    private String search_country(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountrysearch search = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
        return JSONCountry.toJSONArray(countryusecases.search_country(search)).toJSONString();
    }
    
    private String search_country_count(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountrysearch countrysearch = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", countryusecases.search_country_count(countrysearch));
        return jsonsearchcount.toJSONString();
    }
}

