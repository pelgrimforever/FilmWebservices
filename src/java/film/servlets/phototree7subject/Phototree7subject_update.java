/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.phototree7subject;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPhototree7subject;
import film.interfaces.servlet.IPhototree7subjectOperation;
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Phototree7subject_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Phototree7subject_update", urlPatterns={"/film.Phototree7subject_update"})
public class Phototree7subject_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPhototree7subjectOperation.UPDATE_PHOTOTREE7SUBJECT:
                    update_phototree7subject(phototree7subjectusecases);
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

    private void update_phototree7subject(Phototree7subject_usecases phototree7subjectusecases) throws CustomException {
        IPhototree7subject phototree7subject = (IPhototree7subject)parser.getJavaObject("phototree7subject");
        phototree7subjectusecases.updatePhototree7subject(phototree7subject);
    }
    
    @Override
    public String getServletInfo() {
        return "phototree7subject_insert";
    }

}

