/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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

/**
 * @author Franky Laseure
 */
@WebServlet(name="Phototree7subject_select", urlPatterns={"/film.Phototree7subject_select"})
public class Phototree7subject_select extends SecurityDataServlet {
   
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
                case IPhototree7subjectOperation.SELECT_ALL:
                    dataobject = phototree7subjectusecases.get_all();
                    break;
                case IPhototree7subjectOperation.SELECT_PHOTOTREE7SUBJECT:
                    dataobject = get_phototree7subject_with_primarykey(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_Tree7subject:
                    dataobject = get_phototree7subject_with_foreignkey_tree7subject(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_Photo:
                    dataobject = get_phototree7subject_with_foreignkey_photo(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_SEARCH:
                    dataobject = search_phototree7subject(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_phototree7subject_count(phototree7subjectusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhototree7subjectOperation.SELECT_SUBJECT:
                    //is the same as SELECT_Tree7subject
                    dataobject = get_phototree7subject_with_foreignkey_tree7subject(phototree7subjectusecases);
                    break;
                case IPhototree7subjectOperation.SELECT_PHOTO:
                    //this should move to Tree7subject_select
                    dataobject = get_phototree7subject_from_photo(phototree7subjectusecases);
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
    private Object get_phototree7subject_from_photo(Phototree7subject_usecases phototree7subjectusecases) throws DBException {
        IPhotoPK photopk = (IPhotoPK)parser.getJavaObject("photopk");
        return phototree7subjectusecases.get_phototree7subject_from_photo(photopk);
    }
//Custom code, do not change this line   

    private Object get_phototree7subject_with_primarykey(Phototree7subject_usecases phototree7subjectusecases) throws DBException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
        return phototree7subjectusecases.get_phototree7subject_by_primarykey(phototree7subjectPK);
    }

    private Object get_phototree7subject_with_foreignkey_tree7subject(Phototree7subject_usecases phototree7subjectusecases) throws CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)parser.getJavaObject("tree7subjectpk");
        return phototree7subjectusecases.get_phototree7subject_with_foreignkey_tree7subject(tree7subjectPK);
    }
    
    private Object get_phototree7subject_with_foreignkey_photo(Phototree7subject_usecases phototree7subjectusecases) throws CustomException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return phototree7subjectusecases.get_phototree7subject_with_foreignkey_photo(photoPK);
    }
    
    private Object search_phototree7subject(Phototree7subject_usecases phototree7subjectusecases) throws CustomException {
        IPhototree7subjectsearch search = (IPhototree7subjectsearch)parser.getJavaObject("search");
        return phototree7subjectusecases.search_phototree7subject(search);
    }
    
    private Object search_phototree7subject_count(Phototree7subject_usecases phototree7subjectusecases) throws CustomException {
        IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)parser.getJavaObject("search");
        return phototree7subjectusecases.search_phototree7subject_count(phototree7subjectsearch);
    }

    @Override
    public String getServletInfo() {
        return "phototree7subject_select";
    }

}

