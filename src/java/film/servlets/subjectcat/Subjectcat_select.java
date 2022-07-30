/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Subjectcat_select", urlPatterns={"/film.Subjectcat_select"})
public class Subjectcat_select extends SecurityDataServlet {
   
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
                case ISubjectcatOperation.SELECT_ALL:
                    dataobject = subjectcatusecases.get_all();
                    break;
                case ISubjectcatOperation.SELECT_SUBJECTCAT:
                    dataobject = get_subjectcat_with_primarykey(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_Subjectcat1:
                    dataobject = get_subjectcat_with_externalforeignkey_subjectCat1(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_Subjectcat2:
                    dataobject = get_subjectcat_with_externalforeignkey_subjectCat2(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_SEARCH:
                    dataobject = search_subjectcat(subjectcatusecases);
                    break;
                case ISubjectcatOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_subjectcat_count(subjectcatusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case ISubjectcatOperation.SELECT_CAT1:
                    dataobject = subjectcatusecases.getSubjects_category_1();
                    break;
                case ISubjectcatOperation.SELECT_CAT2:
                    dataobject = subjectcatusecases.getSubjects_category_2();
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
//Custom code, do not change this line   

    private Object get_subjectcat_with_primarykey(Subjectcat_usecases subjectcatusecases) throws DBException {
        ISubjectcatPK subjectcatPK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
        return subjectcatusecases.get_subjectcat_by_primarykey(subjectcatPK);
    }

    private Object get_subjectcat_with_externalforeignkey_subjectCat1(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectPK subjectCat1PK = (ISubjectPK)parser.getJavaObject("subjectpk");
        return subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat1(subjectCat1PK);
    }
    
    private Object get_subjectcat_with_externalforeignkey_subjectCat2(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectPK subjectCat2PK = (ISubjectPK)parser.getJavaObject("subjectpk");
        return subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat2(subjectCat2PK);
    }
    
    private Object search_subjectcat(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcatsearch search = (ISubjectcatsearch)parser.getJavaObject("search");
        return subjectcatusecases.search_subjectcat(search);
    }
    
    private Object search_subjectcat_count(Subjectcat_usecases subjectcatusecases) throws CustomException {
        ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)parser.getJavaObject("search");
        return subjectcatusecases.search_subjectcat_count(subjectcatsearch);
    }

    @Override
    public String getServletInfo() {
        return "subjectcat_select";
    }

}

