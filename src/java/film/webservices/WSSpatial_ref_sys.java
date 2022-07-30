/*
 * WSSpatial_ref_sys.java
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
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.interfaces.webservice.WSISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.Spatial_ref_syssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISpatial_ref_sys")
public class WSSpatial_ref_sys extends RS_json_login implements WSISpatial_ref_sys {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList spatial_ref_syss) {
        JSONArray jsonspatial_ref_syss = new JSONArray();
        Iterator spatial_ref_syssI = spatial_ref_syss.iterator();
        while(spatial_ref_syssI.hasNext()) {
            jsonspatial_ref_syss.add(JSONSpatial_ref_sys.toJSON((Spatial_ref_sys)spatial_ref_syssI.next()));
        }
        return jsonspatial_ref_syss;
    }

    //@WebMethod(operationName = "getSpatial_ref_syss")
    @Override
    public String getSpatial_ref_syss() {
        try {
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            return get_all_spatial_ref_sys(spatial_ref_sysusecases);
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
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            return search_spatial_ref_sys(spatial_ref_sysusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSpatial_ref_sys")
    @Override
    public String getSpatial_ref_sys(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            return get_spatial_ref_sys_with_primarykey(spatial_ref_sysusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSpatial_ref_sys")
    @Override
    public void insertSpatial_ref_sys(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            insert_spatial_ref_sys(spatial_ref_sysusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSpatial_ref_sys")
    @Override
    public void updateSpatial_ref_sys(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            update_spatial_ref_sys(spatial_ref_sysusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSpatial_ref_sys")
    @Override
    public void deleteSpatial_ref_sys(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
            delete_spatial_ref_sys(spatial_ref_sysusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", spatial_ref_sysusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases) throws ParseException, CustomException {
    	return JSONSpatial_ref_sys.toJSONArray(spatial_ref_sysusecases.get_all()).toJSONString();
    }
    
    private String get_spatial_ref_sys_with_primarykey(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_sysPK spatial_ref_sysPK = (ISpatial_ref_sysPK)JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)json.get("spatial_ref_syspk"));
	return JSONSpatial_ref_sys.toJSON(spatial_ref_sysusecases.get_spatial_ref_sys_by_primarykey(spatial_ref_sysPK)).toJSONString();
    }
    
    private String search_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_syssearch search = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
        return JSONSpatial_ref_sys.toJSONArray(spatial_ref_sysusecases.search_spatial_ref_sys(search)).toJSONString();
    }
    
    private String search_spatial_ref_sys_count(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_syssearch spatial_ref_syssearch = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", spatial_ref_sysusecases.search_spatial_ref_sys_count(spatial_ref_syssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_sys spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
        spatial_ref_sysusecases.insertSpatial_ref_sys(spatial_ref_sys);
        setReturnstatus("OK");
    }

    private void update_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_sys spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
        spatial_ref_sysusecases.updateSpatial_ref_sys(spatial_ref_sys);
        setReturnstatus("OK");
    }

    private void delete_spatial_ref_sys(Spatial_ref_sys_usecases spatial_ref_sysusecases, JSONObject json) throws ParseException, CustomException {
        ISpatial_ref_sys spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
        spatial_ref_sysusecases.deleteSpatial_ref_sys(spatial_ref_sys);
        setReturnstatus("OK");
    }

}

