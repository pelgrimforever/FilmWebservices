/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.subject;

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
import film.interfaces.searchentity.ISubjectsearch;
import film.interfaces.servlet.ISubjectOperation;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
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

@Path("rssubject_delete")
public class RSSubject_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISubjectOperation.DELETE_SUBJECT:
                    delete_subject(subjectusecases, json);
                    break;
                case ISubjectOperation.DELETE_Subjectcatcat1:
                    delete_subject(subjectusecases, json);
                    break;
                case ISubjectOperation.DELETE_Tree7subject:
                    delete_subject(subjectusecases, json);
                    break;
                case ISubjectOperation.DELETE_Subjectcatcat2:
                    delete_subject(subjectusecases, json);
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

    private void delete_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubject subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
        subjectusecases.deleteSubject(subject);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subjectcatcat1(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        subjectusecases.delete_all_containing_Subjectcatcat1(subjectcatCat1PK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tree7subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        subjectusecases.delete_all_containing_Tree7subject(tree7subjectPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subjectcatcat2(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        subjectusecases.delete_all_containing_Subjectcatcat2(subjectcatCat2PK);
        setReturnstatus("OK");
    }

}

