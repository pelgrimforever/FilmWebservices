/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.phototags;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPhototags;
import film.interfaces.servlet.IPhototagsOperation;
import film.interfaces.searchentity.IPhototagssearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Phototags_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Phototags_delete", urlPatterns={"/film.Phototags_delete"})
public class Phototags_delete extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Phototags_usecases phototagsusecases = new Phototags_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPhototagsOperation.DELETE_PHOTOTAGS:
                    delete_phototags(phototagsusecases);
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

    private void delete_phototags(Phototags_usecases phototagsusecases) throws CustomException {
        IPhototags phototags = (IPhototags)parser.getJavaObject("phototags");
        phototagsusecases.deletePhototags(phototags);
    }
    
    @Override
    public String getServletInfo() {
        return "phototags_insert";
    }

}

