/*
 * WSSublocality.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSISublocality;
import film.logicentity.Sublocality;
import film.searchentity.Sublocalitysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISublocality")
public class WSSublocality implements WSISublocality {

    private JSONArray toJSONArray(ArrayList sublocalitys) {
        JSONArray jsonsublocalitys = new JSONArray();
        Iterator sublocalitysI = sublocalitys.iterator();
        while(sublocalitysI.hasNext()) {
            jsonsublocalitys.add(JSONSublocality.toJSON((Sublocality)sublocalitysI.next()));
        }
        return jsonsublocalitys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSublocalitys")
    @Override
    public String getSublocalitys() {
        try {
            BLsublocality blsublocality = new BLsublocality();
            ArrayList sublocalitys = blsublocality.getAll();
            JSONArray jsonsublocalitys = toJSONArray(sublocalitys);
            return jsonsublocalitys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        String result = "";
        Sublocality sublocality;
        try {
            Sublocalitysearch sublocalitysearch = JSONSublocality.toSublocalitysearch((JSONObject)parser.parse(json));
            ArrayList sublocalitys = blsublocality.search(sublocalitysearch);
            JSONArray jsonsublocalitys = toJSONArray(sublocalitys);
            result = jsonsublocalitys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSublocality")
    @Override
    public String getSublocality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        String result = "";
        Sublocality sublocality;
        try {
            SublocalityPK sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)parser.parse(json));
            sublocality = blsublocality.getSublocality(sublocalityPK);
            if(sublocality!=null) {
                result = JSONSublocality.toJSON(sublocality).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSublocality")
    @Override
    public void insertSublocality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        try {
            ISublocality sublocality = JSONSublocality.toSublocality((JSONObject)parser.parse(json));
            blsublocality.insertSublocality(sublocality);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSublocality")
    @Override
    public void updateSublocality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        try {
            ISublocality sublocality = JSONSublocality.toSublocality((JSONObject)parser.parse(json));
            blsublocality.updateSublocality(sublocality);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSublocality")
    @Override
    public void deleteSublocality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        try {
            ISublocality sublocality = JSONSublocality.toSublocality((JSONObject)parser.parse(json));
            blsublocality.deleteSublocality(sublocality);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSublocalitys4locality")
    @Override
    public String getSublocalitys4locality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        Sublocality sublocality;
        try {
            ILocalityPK localityPK = JSONLocality.toLocalityPK((JSONObject)parser.parse(json));
            ArrayList sublocalitys = blsublocality.getSublocalitys4locality(localityPK);
            JSONArray jsonsublocalitys = toJSONArray(sublocalitys);
            return jsonsublocalitys.toJSONString();
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

    //@WebMethod(operationName = "delete4locality")
    @Override
    public void delete4locality(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        Sublocality sublocality;
        try {
            ILocalityPK localityPK = JSONLocality.toLocalityPK((JSONObject)parser.parse(json));
            blsublocality.delete4locality(localityPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSublocalitys4route")
    @Override
    public String getSublocalitys4route(String json) {
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        Sublocality sublocality;
        try {
            String result = null;
            IRoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            sublocality = (Sublocality)blsublocality.getRoute(routePK);
            if(sublocality!=null) {
                result = JSONSublocality.toJSON(sublocality).toJSONString();
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

