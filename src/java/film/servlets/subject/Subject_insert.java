/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.subject;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.ISubject;
import film.interfaces.servlet.ISubjectOperation;
import film.interfaces.searchentity.ISubjectsearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Subject_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Franky Laseure
 */
@WebServlet(name="Subject_insert", urlPatterns={"/film.Subject_insert"})
public class Subject_insert extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Subject_usecases subjectusecases = new Subject_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case ISubjectOperation.INSERT_SUBJECT:
                    insert_subject(subjectusecases);
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

    private void insert_subject(Subject_usecases subjectusecases) throws CustomException {
        ISubject subject = (ISubject)parser.getJavaObject("subject");
        subjectusecases.secureinsertSubject(subject);
    }
    
    @Override
    public String getServletInfo() {
        return "subject_insert";
    }

}

