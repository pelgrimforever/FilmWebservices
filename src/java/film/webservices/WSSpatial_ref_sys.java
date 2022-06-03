/*
 * WSSpatial_ref_sys.java
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
import film.interfaces.webservice.WSISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.Spatial_ref_syssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISpatial_ref_sys")
public class WSSpatial_ref_sys implements WSISpatial_ref_sys {

    private JSONArray toJSONArray(ArrayList spatial_ref_syss) {
        JSONArray jsonspatial_ref_syss = new JSONArray();
        Iterator spatial_ref_syssI = spatial_ref_syss.iterator();
        while(spatial_ref_syssI.hasNext()) {
            jsonspatial_ref_syss.add(JSONSpatial_ref_sys.toJSON((Spatial_ref_sys)spatial_ref_syssI.next()));
        }
        return jsonspatial_ref_syss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSpatial_ref_syss")
    @Override
    public String getSpatial_ref_syss() {
        try {
            BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
            ArrayList spatial_ref_syss = blspatial_ref_sys.getAll();
            JSONArray jsonspatial_ref_syss = toJSONArray(spatial_ref_syss);
            return jsonspatial_ref_syss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        String result = "";
        Spatial_ref_sys spatial_ref_sys;
        try {
            Spatial_ref_syssearch spatial_ref_syssearch = JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)parser.parse(json));
            ArrayList spatial_ref_syss = blspatial_ref_sys.search(spatial_ref_syssearch);
            JSONArray jsonspatial_ref_syss = toJSONArray(spatial_ref_syss);
            result = jsonspatial_ref_syss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSpatial_ref_sys")
    @Override
    public String getSpatial_ref_sys(String json) {
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        String result = "";
        Spatial_ref_sys spatial_ref_sys;
        try {
            Spatial_ref_sysPK spatial_ref_sysPK = JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)parser.parse(json));
            spatial_ref_sys = blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK);
            if(spatial_ref_sys!=null) {
                result = JSONSpatial_ref_sys.toJSON(spatial_ref_sys).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSpatial_ref_sys")
    @Override
    public void insertSpatial_ref_sys(String json) {
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        try {
            ISpatial_ref_sys spatial_ref_sys = JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)parser.parse(json));
            blspatial_ref_sys.insertSpatial_ref_sys(spatial_ref_sys);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSpatial_ref_sys")
    @Override
    public void updateSpatial_ref_sys(String json) {
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        try {
            ISpatial_ref_sys spatial_ref_sys = JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)parser.parse(json));
            blspatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSpatial_ref_sys")
    @Override
    public void deleteSpatial_ref_sys(String json) {
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        try {
            ISpatial_ref_sys spatial_ref_sys = JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)parser.parse(json));
            blspatial_ref_sys.deleteSpatial_ref_sys(spatial_ref_sys);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

