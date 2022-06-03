/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.filmtype;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IFilmtypesearch;
import film.interfaces.servlet.IFilmtypeOperation;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
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
@Path("rsfilmtype_update")
public class RSFilmtype_update extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFilmtypeOperation.UPDATE_FILMTYPE:
                    update_filmtype(filmtypeusecases, json);
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

    private void update_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtype filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
        filmtypeusecases.secureupdateFilmtype(filmtype);
        setReturnstatus("OK");
    }
}

