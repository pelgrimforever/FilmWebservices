package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSILocality;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSILocality")
public class WSLocality implements WSILocality {

    private JSONArray toJSONArray(ArrayList localitys) {
        JSONArray jsonlocalitys = new JSONArray();
        Iterator localitysI = localitys.iterator();
        while(localitysI.hasNext()) {
            jsonlocalitys.add(JSONLocality.toJSON((Locality)localitysI.next()));
        }
        return jsonlocalitys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getLocalitys")
    @Override
    public String getLocalitys() {
        try {
            BLlocality bllocality = new BLlocality();
            ArrayList localitys = bllocality.getAll();
            JSONArray jsonlocalitys = toJSONArray(localitys);
            return jsonlocalitys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        String result = "";
        Locality locality;
        try {
            Localitysearch localitysearch = JSONLocality.toLocalitysearch((JSONObject)parser.parse(json));
            ArrayList localitys = bllocality.search(localitysearch);
            JSONArray jsonlocalitys = toJSONArray(localitys);
            result = jsonlocalitys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getLocality")
    @Override
    public String getLocality(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        String result = "";
        Locality locality;
        try {
            LocalityPK localityPK = JSONLocality.toLocalityPK((JSONObject)parser.parse(json));
            locality = bllocality.getLocality(localityPK);
            if(locality!=null) {
                result = JSONLocality.toJSON(locality).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertLocality")
    @Override
    public void insertLocality(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        try {
            ILocality locality = JSONLocality.toLocality((JSONObject)parser.parse(json));
            bllocality.insertLocality(locality);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateLocality")
    @Override
    public void updateLocality(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        try {
            ILocality locality = JSONLocality.toLocality((JSONObject)parser.parse(json));
            bllocality.updateLocality(locality);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteLocality")
    @Override
    public void deleteLocality(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        try {
            ILocality locality = JSONLocality.toLocality((JSONObject)parser.parse(json));
            bllocality.deleteLocality(locality);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getLocalitys4postalcode")
    @Override
    public String getLocalitys4postalcode(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        Locality locality;
        try {
            IPostalcodePK postalcodePK = JSONPostalcode.toPostalcodePK((JSONObject)parser.parse(json));
            ArrayList localitys = bllocality.getLocalitys4postalcode(postalcodePK);
            JSONArray jsonlocalitys = toJSONArray(localitys);
            return jsonlocalitys.toJSONString();
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

    //@WebMethod(operationName = "delete4postalcode")
    @Override
    public void delete4postalcode(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        Locality locality;
        try {
            IPostalcodePK postalcodePK = JSONPostalcode.toPostalcodePK((JSONObject)parser.parse(json));
            bllocality.delete4postalcode(this.getClass().getName(), postalcodePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getLocalitys4sublocality")
    @Override
    public String getLocalitys4sublocality(String json) {
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        Locality locality;
        try {
            String result = null;
            ISublocalityPK sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)parser.parse(json));
            locality = (Locality)bllocality.getSublocality(sublocalityPK);
            if(locality!=null) {
                result = JSONLocality.toJSON(locality).toJSONString();
            }
            return result;
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


}

