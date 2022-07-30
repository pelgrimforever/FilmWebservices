/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.locality;

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
import film.interfaces.searchentity.ILocalitysearch;
import film.interfaces.servlet.ILocalityOperation;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
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

/**
 * @author Franky Laseure
 */
@Path("rslocality_select")
public class RSLocality_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ILocalityOperation.SELECT_COUNT:
                    result = count_records(localityusecases);
                    break;
                case ILocalityOperation.SELECT_ALL:
                    result = get_all_locality(localityusecases);
                    break;
                case ILocalityOperation.SELECT_LOCALITY:
                    result = get_locality_with_primarykey(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_Postalcode:
                    result = get_locality_with_foreignkey_postalcode(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_Sublocality:
                    result = get_locality_with_externalforeignkey_sublocality(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_SEARCH:
                    result = search_locality(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_SEARCHCOUNT:
                    result = search_locality_count(localityusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ILocalityOperation.SELECT_COUNTRY:
                    result = get_for_country(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_AL1:
                    result = get_for_arealevel1(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_AL2:
                    result = get_for_arealevel2(localityusecases, json);
                    break;
                case ILocalityOperation.SELECT_AL3:
                    result = get_for_arealevel3(localityusecases, json);
                    break;
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
    private String get_for_country(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
        ArrayList<Locality> countries = localityusecases.get_for_country(countryPK);
        return JSONLocality.toJSONArray(countries).toJSONString();
    }

    private String get_for_arealevel1(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        ArrayList<Locality> countries = localityusecases.get_for_arealevel1(arealevel1PK);
        return JSONLocality.toJSONArray(countries).toJSONString();
    }

    private String get_for_arealevel2(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        ArrayList<Locality> countries = localityusecases.get_for_arealevel2(arealevel2PK);
        return JSONLocality.toJSONArray(countries).toJSONString();
    }

    private String get_for_arealevel3(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        ArrayList<Locality> countries = localityusecases.get_for_arealevel3(arealevel3PK);
        return JSONLocality.toJSONArray(countries).toJSONString();
    }
//Custom code, do not change this line   

    private String count_records(Locality_usecases localityusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", localityusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_locality(Locality_usecases localityusecases) throws ParseException, CustomException {
    	return JSONLocality.toJSONArray(localityusecases.get_all()).toJSONString();
    }
    
    private String get_locality_with_primarykey(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
	return JSONLocality.toJSON(localityusecases.get_locality_by_primarykey(localityPK)).toJSONString();
    }
    
    private String get_locality_with_foreignkey_postalcode(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
        return JSONLocality.toJSONArray(localityusecases.get_locality_with_foreignkey_postalcode(postalcodePK)).toJSONString();
    }
    
    private String get_locality_with_externalforeignkey_sublocality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
        return JSONLocality.toJSON(localityusecases.get_locality_with_externalforeignkey_sublocality(sublocalityPK)).toJSONString();
    }
    
    private String search_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalitysearch search = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
        return JSONLocality.toJSONArray(localityusecases.search_locality(search)).toJSONString();
    }
    
    private String search_locality_count(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalitysearch localitysearch = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", localityusecases.search_locality_count(localitysearch));
        return jsonsearchcount.toJSONString();
    }
}

