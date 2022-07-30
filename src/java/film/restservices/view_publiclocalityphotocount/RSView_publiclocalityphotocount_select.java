/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.view_publiclocalityphotocount;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_publiclocalityphotocount;
import film.interfaces.servlet.IView_publiclocalityphotocountOperation;
import film.usecases.View_publiclocalityphotocount_usecases;
import film.logicview.View_publiclocalityphotocount;
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
@Path("rsview_publiclocalityphotocount_select")
public class RSView_publiclocalityphotocount_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_publiclocalityphotocount_usecases view_publiclocalityphotocountusecases = new View_publiclocalityphotocount_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_publiclocalityphotocountOperation.SELECT_ALL:
                    result = get_all_view_publiclocalityphotocount(view_publiclocalityphotocountusecases);
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

    private String get_all_view_publiclocalityphotocount(View_publiclocalityphotocount_usecases view_publiclocalityphotocountusecases) throws ParseException, CustomException {
    	return JSONView_publiclocalityphotocount.toJSONArray(view_publiclocalityphotocountusecases.get_all()).toJSONString();
    }
}

