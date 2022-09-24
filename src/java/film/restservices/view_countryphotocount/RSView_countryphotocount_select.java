/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.view_countryphotocount;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.logicview.IView_countryphotocount;
import film.interfaces.servlet.IView_countryphotocountOperation;
import film.usecases.View_countryphotocount_usecases;
import film.logicview.View_countryphotocount;
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

@Path("rsview_countryphotocount_select")
public class RSView_countryphotocount_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            View_countryphotocount_usecases view_countryphotocountusecases = new View_countryphotocount_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IView_countryphotocountOperation.SELECT_ALL:
                    result = get_all_view_countryphotocount(view_countryphotocountusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IView_countryphotocountOperation.SELECT_ALLPRIVATE:
                    result = get_private_photocount_per_country(view_countryphotocountusecases);
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
    private String get_private_photocount_per_country(View_countryphotocount_usecases view_countryphotocountusecases) throws ParseException, CustomException {
        ArrayList<View_countryphotocount> countryphotocount = view_countryphotocountusecases.get_private_photocount_per_country(loggedin);
    	return JSONView_countryphotocount.toJSONArray(countryphotocount).toJSONString();
    }
//Custom code, do not change this line   

    private String get_all_view_countryphotocount(View_countryphotocount_usecases view_countryphotocountusecases) throws ParseException, CustomException {
    	return JSONView_countryphotocount.toJSONArray(view_countryphotocountusecases.get_all()).toJSONString();
    }
}

