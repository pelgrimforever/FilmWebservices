/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.photosubjects;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPhotosubjects;
import film.interfaces.servlet.IPhotosubjectsOperation;
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Photosubjects_usecases;
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
@WebServlet(name="Photosubjects_select", urlPatterns={"/film.Photosubjects_select"})
public class Photosubjects_select extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPhotosubjectsOperation.SELECT_ALL:
                    dataobject = photosubjectsusecases.get_all();
                    break;
                case IPhotosubjectsOperation.SELECT_PHOTOSUBJECTS:
                    dataobject = get_photosubjects_with_primarykey(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_Photo:
                    dataobject = get_photosubjects_with_foreignkey_photo(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_Subject:
                    dataobject = get_photosubjects_with_foreignkey_subject(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_SEARCH:
                    dataobject = search_photosubjects(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_photosubjects_count(photosubjectsusecases);
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

    private Object get_photosubjects_with_primarykey(Photosubjects_usecases photosubjectsusecases) throws DBException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
        return photosubjectsusecases.get_photosubjects_by_primarykey(photosubjectsPK);
    }

    private Object get_photosubjects_with_foreignkey_photo(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return photosubjectsusecases.get_photosubjects_with_foreignkey_photo(photoPK);
    }
    
    private Object get_photosubjects_with_foreignkey_subject(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        ISubjectPK subjectPK = (ISubjectPK)parser.getJavaObject("subjectpk");
        return photosubjectsusecases.get_photosubjects_with_foreignkey_subject(subjectPK);
    }
    
    private Object search_photosubjects(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotosubjectssearch search = (IPhotosubjectssearch)parser.getJavaObject("search");
        return photosubjectsusecases.search_photosubjects(search);
    }
    
    private Object search_photosubjects_count(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)parser.getJavaObject("search");
        return photosubjectsusecases.search_photosubjects_count(photosubjectssearch);
    }

    @Override
    public String getServletInfo() {
        return "photosubjects_select";
    }

}

