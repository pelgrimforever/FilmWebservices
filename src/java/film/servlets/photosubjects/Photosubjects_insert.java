/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 */

package film.servlets.photosubjects;

import general.exception.CustomException;
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
@WebServlet(name="Photosubjects_insert", urlPatterns={"/film.Photosubjects_insert"})
public class Photosubjects_insert extends SecurityDataServlet {
   
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
                case IPhotosubjectsOperation.INSERT_PHOTOSUBJECTS:
                    insert_photosubjects(photosubjectsusecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhotosubjectsOperation.INSERT_PHOTOSUBJECT_RELOAD:
                    dataobject = insert_photosubjects_and_reload(photosubjectsusecases);
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
    private Object insert_photosubjects_and_reload(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)parser.getJavaObject("photosubject");
        return photosubjectsusecases.insert_photosubjects_and_reload(photosubjects);
    }
//Custom code, do not change this line   

    private void insert_photosubjects(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)parser.getJavaObject("photosubjects");
        photosubjectsusecases.insertPhotosubjects(photosubjects);
    }
    
    @Override
    public String getServletInfo() {
        return "photosubjects_insert";
    }

}

