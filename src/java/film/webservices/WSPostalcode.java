/*
 * WSPostalcode.java
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
import film.interfaces.webservice.WSIPostalcode;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPostalcode")
public class WSPostalcode implements WSIPostalcode {

    private JSONArray toJSONArray(ArrayList postalcodes) {
        JSONArray jsonpostalcodes = new JSONArray();
        Iterator postalcodesI = postalcodes.iterator();
        while(postalcodesI.hasNext()) {
            jsonpostalcodes.add(JSONPostalcode.toJSON((Postalcode)postalcodesI.next()));
        }
        return jsonpostalcodes;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getPostalcodes")
    @Override
    public String getPostalcodes() {
        try {
            BLpostalcode blpostalcode = new BLpostalcode();
            ArrayList postalcodes = blpostalcode.getAll();
            JSONArray jsonpostalcodes = toJSONArray(postalcodes);
            return jsonpostalcodes.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        String result = "";
        Postalcode postalcode;
        try {
            Postalcodesearch postalcodesearch = JSONPostalcode.toPostalcodesearch((JSONObject)parser.parse(json));
            ArrayList postalcodes = blpostalcode.search(postalcodesearch);
            JSONArray jsonpostalcodes = toJSONArray(postalcodes);
            result = jsonpostalcodes.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getPostalcode")
    @Override
    public String getPostalcode(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        String result = "";
        Postalcode postalcode;
        try {
            PostalcodePK postalcodePK = JSONPostalcode.toPostalcodePK((JSONObject)parser.parse(json));
            postalcode = blpostalcode.getPostalcode(postalcodePK);
            if(postalcode!=null) {
                result = JSONPostalcode.toJSON(postalcode).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertPostalcode")
    @Override
    public void insertPostalcode(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        try {
            IPostalcode postalcode = JSONPostalcode.toPostalcode((JSONObject)parser.parse(json));
            blpostalcode.insertPostalcode(postalcode);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updatePostalcode")
    @Override
    public void updatePostalcode(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        try {
            IPostalcode postalcode = JSONPostalcode.toPostalcode((JSONObject)parser.parse(json));
            blpostalcode.updatePostalcode(postalcode);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deletePostalcode")
    @Override
    public void deletePostalcode(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        try {
            IPostalcode postalcode = JSONPostalcode.toPostalcode((JSONObject)parser.parse(json));
            blpostalcode.deletePostalcode(postalcode);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getPostalcodes4arealevel3")
    @Override
    public String getPostalcodes4arealevel3(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        Postalcode postalcode;
        try {
            IArealevel3PK arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)parser.parse(json));
            ArrayList postalcodes = blpostalcode.getPostalcodes4arealevel3(arealevel3PK);
            JSONArray jsonpostalcodes = toJSONArray(postalcodes);
            return jsonpostalcodes.toJSONString();
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

    //@WebMethod(operationName = "delete4arealevel3")
    @Override
    public void delete4arealevel3(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        Postalcode postalcode;
        try {
            IArealevel3PK arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)parser.parse(json));
            blpostalcode.delete4arealevel3(arealevel3PK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPostalcodes4locality")
    @Override
    public String getPostalcodes4locality(String json) {
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        Postalcode postalcode;
        try {
            String result = null;
            ILocalityPK localityPK = JSONLocality.toLocalityPK((JSONObject)parser.parse(json));
            postalcode = (Postalcode)blpostalcode.getLocality(localityPK);
            if(postalcode!=null) {
                result = JSONPostalcode.toJSON(postalcode).toJSONString();
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

