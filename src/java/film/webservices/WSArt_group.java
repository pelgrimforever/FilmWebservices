package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIArt_group;
import film.logicentity.Art_group;
import film.searchentity.Art_groupsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_group")
public class WSArt_group implements WSIArt_group {

    private JSONArray toJSONArray(ArrayList art_groups) {
        JSONArray jsonart_groups = new JSONArray();
        Iterator art_groupsI = art_groups.iterator();
        while(art_groupsI.hasNext()) {
            jsonart_groups.add(JSONArt_group.toJSON((Art_group)art_groupsI.next()));
        }
        return jsonart_groups;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArt_groups")
    @Override
    public String getArt_groups() {
        try {
            BLart_group blart_group = new BLart_group();
            ArrayList art_groups = blart_group.getAll();
            JSONArray jsonart_groups = toJSONArray(art_groups);
            return jsonart_groups.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_group art_group;
        try {
            Art_groupsearch art_groupsearch = JSONArt_group.toArt_groupsearch((JSONObject)parser.parse(json));
            ArrayList art_groups = blart_group.search(art_groupsearch);
            JSONArray jsonart_groups = toJSONArray(art_groups);
            result = jsonart_groups.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArt_group")
    @Override
    public String getArt_group(String json) {
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_group art_group;
        try {
            Art_groupPK art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)parser.parse(json));
            art_group = blart_group.getArt_group(art_groupPK);
            if(art_group!=null) {
                result = JSONArt_group.toJSON(art_group).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArt_group")
    @Override
    public void insertArt_group(String json) {
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        try {
            IArt_group art_group = JSONArt_group.toArt_group((JSONObject)parser.parse(json));
            blart_group.insertArt_group(art_group);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_group")
    @Override
    public void updateArt_group(String json) {
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        try {
            IArt_group art_group = JSONArt_group.toArt_group((JSONObject)parser.parse(json));
            blart_group.updateArt_group(art_group);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_group")
    @Override
    public void deleteArt_group(String json) {
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        try {
            IArt_group art_group = JSONArt_group.toArt_group((JSONObject)parser.parse(json));
            blart_group.deleteArt_group(art_group);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

