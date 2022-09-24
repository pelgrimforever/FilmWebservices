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

@WebServlet(name="Subjectcat_insert", urlPatterns={"/film.Subjectcat_insert"})
public class Subjectcat_insert extends SecurityDataServlet {
   
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
                case ISubjectcatOperation.INSERT_SUBJECTCAT:
                    insert_subjectcat(subjectcatusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ISubjectcatOperation.INSERT_CAT1:
                    dataobject = insert_subject_category_1_getSubjects_category_1(subjectcatusecases);
                    break;
                case ISubjectcatOperation.INSERT_CAT2:
                    dataobject = insert_subject_category_2_getSubjects_category_2(subjectcatusecases);
                    break;
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
    private Object insert_subject_category_1_getSubjects_category_1(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcat subjectcat1 = (ISubjectcat)parser.getJavaObject("subjectcat1");
        return subjectcatusecases.insert_subject_category_1_getSubjects_category_1(subjectcat1);
    }

    private Object insert_subject_category_2_getSubjects_category_2(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcat subjectcat2 = (ISubjectcat)parser.getJavaObject("subjectcat2");
        return subjectcatusecases.insert_subject_category_2_getSubjects_category_2(subjectcat2);
    }
//Custom code, do not change this line   

    private void insert_subjectcat(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcat subjectcat = (ISubjectcat)parser.getJavaObject("subjectcat");
        subjectcatusecases.insertSubjectcat(subjectcat);
    }
    
    @Override
    public String getServletInfo() {
        return "subjectcat_insert";
    }

}

