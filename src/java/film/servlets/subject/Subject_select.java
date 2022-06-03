/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.subject;

import general.exception.*;
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
@WebServlet(name="Subject_select", urlPatterns={"/film.Subject_select"})
public class Subject_select extends SecurityDataServlet {
   
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
                case ISubjectOperation.SELECT_ALL:
                    dataobject = subjectusecases.get_all();
                    break;
                case ISubjectOperation.SELECT_SUBJECT:
                    dataobject = get_subject_with_primarykey(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_Subjectcatcat1:
                    dataobject = get_subject_with_foreignkey_subjectcatCat1(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_Tree7subject:
                    dataobject = get_subject_with_foreignkey_tree7subject(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_Subjectcatcat2:
                    dataobject = get_subject_with_foreignkey_subjectcatCat2(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_Filmsubjects:
                    dataobject = get_subject_with_externalforeignkey_filmsubjects(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_Photosubjects:
                    dataobject = get_subject_with_externalforeignkey_photosubjects(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_SEARCH:
                    dataobject = search_subject(subjectusecases);
                    break;
                case ISubjectOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_subject_count(subjectusecases);
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

    private Object get_subject_with_primarykey(Subject_usecases subjectusecases) throws DBException {
        ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
        return subjectusecases.get_subject_by_primarykey(subjectPK);
    }

    private Object get_subject_with_foreignkey_subjectcatCat1(Subject_usecases subjectusecases) throws CustomException {
        ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
        return subjectusecases.get_subject_with_foreignkey_subjectcatCat1(subjectcatCat1PK);
    }
    
    private Object get_subject_with_foreignkey_tree7subject(Subject_usecases subjectusecases) throws CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
        return subjectusecases.get_subject_with_foreignkey_tree7subject(tree7subjectPK);
    }
    
    private Object get_subject_with_foreignkey_subjectcatCat2(Subject_usecases subjectusecases) throws CustomException {
        ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)parser.getJavaObject("subjectcatpk");
        return subjectusecases.get_subject_with_foreignkey_subjectcatCat2(subjectcatCat2PK);
    }
    
    private Object get_subject_with_externalforeignkey_filmsubjects(Subject_usecases subjectusecases) throws CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)parser.getJavaObject("filmsubjectspk");
        return subjectusecases.get_subject_with_externalforeignkey_filmsubjects(filmsubjectsPK);
    }
    
    private Object get_subject_with_externalforeignkey_photosubjects(Subject_usecases subjectusecases) throws CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
        return subjectusecases.get_subject_with_externalforeignkey_photosubjects(photosubjectsPK);
    }
    
    private Object search_subject(Subject_usecases subjectusecases) throws CustomException {
        ISubjectsearch search = (ISubjectsearch)parser.getJavaObject("search");
        return subjectusecases.search_subject(search);
    }
    
    private Object search_subject_count(Subject_usecases subjectusecases) throws CustomException {
        ISubjectsearch subjectsearch = (ISubjectsearch)parser.getJavaObject("search");
        return subjectusecases.search_subject_count(subjectsearch);
    }

    @Override
    public String getServletInfo() {
        return "subject_select";
    }

}

