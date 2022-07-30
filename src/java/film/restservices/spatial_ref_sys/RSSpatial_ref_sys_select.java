/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.spatial_ref_sys;

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
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.interfaces.servlet.ISpatial_ref_sysOperation;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.Spatial_ref_syssearch;
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
@Path("rsspatial_ref_sys_select")
public class RSSpatial_ref_sys_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Spatial_ref_sys_usecases spatial_ref_sysusecases = new Spatial_ref_sys_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISpatial_ref_sysOperation.SELECT_COUNT:
                    result = count_records(spatial_ref_sysusecases);
                    break;
                case ISpatial_ref_sysOperation.SELECT_ALL:
                    result = get_all_spatial_ref_sys(spatial_ref_sysusecases);
                    break;
                case ISpatial_ref_sysOperation.SELECT_SPATIAL_REF_SYS:
                    result = get_spatial_ref_sys_with_primarykey(spatial_ref_sysusecases, json);
                    break;
                case ISpatial_ref_sysOperation.SELECT_SEARCH:
                    result = search_spatial_ref_sys(spatial_ref_sysusecases, json);
                    break;
                case ISpatial_ref_sysOperation.SELECT_SEARCHCOUNT:
                    result = search_spatial_ref_sys_count(spatial_ref_sysusecases, json);
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
}

