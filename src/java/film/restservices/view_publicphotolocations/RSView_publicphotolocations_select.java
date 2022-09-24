/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.view_publicphotolocations;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_publicphotolocations;
import film.interfaces.servlet.IView_publicphotolocationsOperation;
import film.usecases.View_publicphotolocations_usecases;
import film.logicview.View_publicphotolocations;
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

@Path("rsview_publicphotolocations_select")
public class RSView_publicphotolocations_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_publicphotolocations_usecases view_publicphotolocationsusecases = new View_publicphotolocations_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_publicphotolocationsOperation.SELECT_ALL:
                    result = get_all_view_publicphotolocations(view_publicphotolocationsusecases);
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

    private String get_all_view_publicphotolocations(View_publicphotolocations_usecases view_publicphotolocationsusecases) throws ParseException, CustomException {
    	return JSONView_publicphotolocations.toJSONArray(view_publicphotolocationsusecases.get_all()).toJSONString();
    }
}

