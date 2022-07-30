/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.tree7subject;

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
import film.interfaces.searchentity.ITree7subjectsearch;
import film.interfaces.servlet.ITree7subjectOperation;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
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
@Path("rstree7subject_delete")
public class RSTree7subject_delete extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ITree7subjectOperation.DELETE_TREE7SUBJECT:
                    delete_tree7subject(tree7subjectusecases, json);
                    break;
                case ITree7subjectOperation.DELETE_Tree7subjectparentsubjectid:
                    delete_tree7subject(tree7subjectusecases, json);
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

    private void delete_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subject tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
        tree7subjectusecases.deleteTree7subject(tree7subject);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tree7subjectparentsubjectid(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        tree7subjectusecases.delete_all_containing_Tree7subjectparentsubjectid(tree7subjectParentsubjectidPK);
        setReturnstatus("OK");
    }

}

