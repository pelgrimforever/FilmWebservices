/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
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
@WebServlet(name="Photosubjects_update", urlPatterns={"/film.Photosubjects_update"})
public class Photosubjects_update extends SecurityDataServlet {
   
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
                case IPhotosubjectsOperation.UPDATE_PHOTOSUBJECTS:
                    update_photosubjects(photosubjectsusecases);
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

    private void update_photosubjects(Photosubjects_usecases photosubjectsusecases) throws CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)parser.getJavaObject("photosubjects");
        photosubjectsusecases.secureupdatePhotosubjects(photosubjects);
    }
    
    @Override
    public String getServletInfo() {
        return "photosubjects_insert";
    }

}

