/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.filmsubjects;

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
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.interfaces.servlet.IFilmsubjectsOperation;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
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

@Path("rsfilmsubjects_delete")
public class RSFilmsubjects_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFilmsubjectsOperation.DELETE_FILMSUBJECTS:
                    delete_filmsubjects(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.DELETE_Subject:
                    delete_filmsubjects(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.DELETE_Film:
                    delete_filmsubjects(filmsubjectsusecases, json);
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

    private void delete_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
        filmsubjectsusecases.deleteFilmsubjects(filmsubjects);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subject(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        filmsubjectsusecases.delete_all_containing_Subject(subjectPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Film(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        filmsubjectsusecases.delete_all_containing_Film(filmPK);
        setReturnstatus("OK");
    }

}

