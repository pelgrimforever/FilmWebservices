/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.subjectcat;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISubjectcat;
import film.interfaces.servlet.ISubjectcatOperation;
import film.interfaces.searchentity.ISubjectcatsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Subjectcat_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Subjectcat_update", urlPatterns={"/film.Subjectcat_update"})
public class Subjectcat_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISubjectcatOperation.UPDATE_SUBJECTCAT:
                    update_subjectcat(subjectcatusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private void update_subjectcat(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcat subjectcat = (ISubjectcat)parser.getJavaObject("subjectcat");
        subjectcatusecases.updateSubjectcat(subjectcat);
    }
    
    @Override
    public String getServletInfo() {
        return "subjectcat_insert";
    }

}

