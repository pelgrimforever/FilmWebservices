/*
 * WSCreator.java
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
import film.interfaces.webservice.WSICreator;
import film.logicentity.Creator;
import film.searchentity.Creatorsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSICreator")
public class WSCreator implements WSICreator {

    private JSONArray toJSONArray(ArrayList creators) {
        JSONArray jsoncreators = new JSONArray();
        Iterator creatorsI = creators.iterator();
        while(creatorsI.hasNext()) {
            jsoncreators.add(JSONCreator.toJSON((Creator)creatorsI.next()));
        }
        return jsoncreators;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getCreators")
    @Override
    public String getCreators() {
        try {
            BLcreator blcreator = new BLcreator();
            ArrayList creators = blcreator.getAll();
            JSONArray jsoncreators = toJSONArray(creators);
            return jsoncreators.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        String result = "";
        Creator creator;
        try {
            Creatorsearch creatorsearch = JSONCreator.toCreatorsearch((JSONObject)parser.parse(json));
            ArrayList creators = blcreator.search(creatorsearch);
            JSONArray jsoncreators = toJSONArray(creators);
            result = jsoncreators.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getCreator")
    @Override
    public String getCreator(String json) {
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        String result = "";
        Creator creator;
        try {
            CreatorPK creatorPK = JSONCreator.toCreatorPK((JSONObject)parser.parse(json));
            creator = blcreator.getCreator(creatorPK);
            if(creator!=null) {
                result = JSONCreator.toJSON(creator).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertCreator")
    @Override
    public void insertCreator(String json) {
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        try {
            ICreator creator = JSONCreator.toCreator((JSONObject)parser.parse(json));
            blcreator.insertCreator(creator);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateCreator")
    @Override
    public void updateCreator(String json) {
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        try {
            ICreator creator = JSONCreator.toCreator((JSONObject)parser.parse(json));
            blcreator.updateCreator(creator);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteCreator")
    @Override
    public void deleteCreator(String json) {
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        try {
            ICreator creator = JSONCreator.toCreator((JSONObject)parser.parse(json));
            blcreator.deleteCreator(creator);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

