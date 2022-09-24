/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.menu;

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
import film.interfaces.searchentity.IMenusearch;
import film.interfaces.servlet.IMenuOperation;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
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

@Path("rsmenu_delete")
public class RSMenu_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMenuOperation.DELETE_MENU:
                    delete_menu(menuusecases, json);
                    break;
                case IMenuOperation.DELETE_Mainmenu:
                    delete_menu(menuusecases, json);
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

    private void delete_menu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenu menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
        menuusecases.deleteMenu(menu);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Mainmenu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
        menuusecases.delete_all_containing_Mainmenu(mainmenuPK);
        setReturnstatus("OK");
    }

}

