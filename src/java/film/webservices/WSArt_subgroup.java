/*
 * WSArt_subgroup.java
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
import film.interfaces.webservice.WSIArt_subgroup;
import film.logicentity.Art_subgroup;
import film.searchentity.Art_subgroupsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_subgroup")
public class WSArt_subgroup implements WSIArt_subgroup {

    private JSONArray toJSONArray(ArrayList art_subgroups) {
        JSONArray jsonart_subgroups = new JSONArray();
        Iterator art_subgroupsI = art_subgroups.iterator();
        while(art_subgroupsI.hasNext()) {
            jsonart_subgroups.add(JSONArt_subgroup.toJSON((Art_subgroup)art_subgroupsI.next()));
        }
        return jsonart_subgroups;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArt_subgroups")
    @Override
    public String getArt_subgroups() {
        try {
            BLart_subgroup blart_subgroup = new BLart_subgroup();
            ArrayList art_subgroups = blart_subgroup.getAll();
            JSONArray jsonart_subgroups = toJSONArray(art_subgroups);
            return jsonart_subgroups.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_subgroup art_subgroup;
        try {
            Art_subgroupsearch art_subgroupsearch = JSONArt_subgroup.toArt_subgroupsearch((JSONObject)parser.parse(json));
            ArrayList art_subgroups = blart_subgroup.search(art_subgroupsearch);
            JSONArray jsonart_subgroups = toJSONArray(art_subgroups);
            result = jsonart_subgroups.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArt_subgroup")
    @Override
    public String getArt_subgroup(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_subgroup art_subgroup;
        try {
            Art_subgroupPK art_subgroupPK = JSONArt_subgroup.toArt_subgroupPK((JSONObject)parser.parse(json));
            art_subgroup = blart_subgroup.getArt_subgroup(art_subgroupPK);
            if(art_subgroup!=null) {
                result = JSONArt_subgroup.toJSON(art_subgroup).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArt_subgroup")
    @Override
    public void insertArt_subgroup(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        try {
            IArt_subgroup art_subgroup = JSONArt_subgroup.toArt_subgroup((JSONObject)parser.parse(json));
            blart_subgroup.insertArt_subgroup(art_subgroup);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_subgroup")
    @Override
    public void updateArt_subgroup(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        try {
            IArt_subgroup art_subgroup = JSONArt_subgroup.toArt_subgroup((JSONObject)parser.parse(json));
            blart_subgroup.updateArt_subgroup(art_subgroup);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_subgroup")
    @Override
    public void deleteArt_subgroup(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        try {
            IArt_subgroup art_subgroup = JSONArt_subgroup.toArt_subgroup((JSONObject)parser.parse(json));
            blart_subgroup.deleteArt_subgroup(art_subgroup);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getArt_subgroups4art_group")
    @Override
    public String getArt_subgroups4art_group(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        Art_subgroup art_subgroup;
        try {
            IArt_groupPK art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)parser.parse(json));
            ArrayList art_subgroups = blart_subgroup.getArt_subgroups4art_group(art_groupPK);
            JSONArray jsonart_subgroups = toJSONArray(art_subgroups);
            return jsonart_subgroups.toJSONString();
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

    //@WebMethod(operationName = "delete4art_group")
    @Override
    public void delete4art_group(String json) {
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        Art_subgroup art_subgroup;
        try {
            IArt_groupPK art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)parser.parse(json));
            blart_subgroup.delete4art_group(art_groupPK);
        }
        catch(ParseException e) {
        }
    }


}

