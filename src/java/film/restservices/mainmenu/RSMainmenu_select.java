/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.mainmenu;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Mainmenu_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IMainmenusearch;
import film.interfaces.servlet.IMainmenuOperation;
import film.logicentity.Mainmenu;
import film.searchentity.Mainmenusearch;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rsmainmenu_select")
public class RSMainmenu_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IMainmenuPK mainmenuPK;
            IMainmenu mainmenu;
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMainmenuOperation.SELECT_COUNT:
                    result = count_records(mainmenuusecases);
                    break;
                case IMainmenuOperation.SELECT_ALL:
                    result = get_all_mainmenu(mainmenuusecases);
                    break;
                case IMainmenuOperation.SELECT_MAINMENU:
                    result = get_mainmenu_with_primarykey(mainmenuusecases, json);
                    break;
                case IMainmenuOperation.SELECT_Menu:
                    result = get_mainmenu_with_externalforeignkey_menu(mainmenuusecases, json);
                    break;
                case IMainmenuOperation.SELECT_SEARCH:
                    result = search_mainmenu(mainmenuusecases, json);
                    break;
                case IMainmenuOperation.SELECT_SEARCHCOUNT:
                    result = search_mainmenu_count(mainmenuusecases, json);
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

    private String count_records(Mainmenu_usecases mainmenuusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", mainmenuusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_mainmenu(Mainmenu_usecases mainmenuusecases) throws ParseException, CustomException {
    	return JSONMainmenu.toJSONArray(mainmenuusecases.get_all()).toJSONString();
    }
    
    private String get_mainmenu_with_primarykey(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
	return JSONMainmenu.toJSON(mainmenuusecases.get_mainmenu_by_primarykey(mainmenuPK)).toJSONString();
    }
    
    private String get_mainmenu_with_externalforeignkey_menu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
        return JSONMainmenu.toJSON(mainmenuusecases.get_mainmenu_with_externalforeignkey_menu(menuPK)).toJSONString();
    }
    
    private String search_mainmenu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenusearch search = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
        return JSONMainmenu.toJSONArray(mainmenuusecases.search_mainmenu(search)).toJSONString();
    }
    
    private String search_mainmenu_count(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenusearch mainmenusearch = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", mainmenuusecases.search_mainmenu_count(mainmenusearch));
        return jsonsearchcount.toJSONString();
    }
}

