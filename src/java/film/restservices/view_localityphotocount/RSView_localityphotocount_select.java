/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.view_localityphotocount;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_localityphotocount;
import film.interfaces.servlet.IView_localityphotocountOperation;
import film.usecases.View_localityphotocount_usecases;
import film.logicview.View_localityphotocount;
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

@Path("rsview_localityphotocount_select")
public class RSView_localityphotocount_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_localityphotocount_usecases view_localityphotocountusecases = new View_localityphotocount_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_localityphotocountOperation.SELECT_ALL:
                    result = get_all_view_localityphotocount(view_localityphotocountusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_localityphotocountOperation.SELECT_4COUNTRY:
                    result = count_4_country(view_localityphotocountusecases, json);
                    break;
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
    private String count_4_country(View_localityphotocount_usecases view_localityphotocountusecases, JSONObject json) throws ParseException, CustomException {
        String countrycode = (String)json.get("countrycode");
        ArrayList<View_localityphotocount> photocount = view_localityphotocountusecases.count_4_country(countrycode, loggedin);
    	return JSONView_localityphotocount.toJSONArray(photocount).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_localityphotocount(View_localityphotocount_usecases view_localityphotocountusecases) throws ParseException, CustomException {
    	return JSONView_localityphotocount.toJSONArray(view_localityphotocountusecases.get_all()).toJSONString();
    }
}

