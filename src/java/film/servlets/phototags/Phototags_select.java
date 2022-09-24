/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.phototags;

import general.exception.*;
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

@WebServlet(name="Phototags_select", urlPatterns={"/film.Phototags_select"})
public class Phototags_select extends SecurityDataServlet {
   
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
                case IPhototagsOperation.SELECT_ALL:
                    dataobject = phototagsusecases.get_all();
                    break;
                case IPhototagsOperation.SELECT_PHOTOTAGS:
                    dataobject = get_phototags_with_primarykey(phototagsusecases);
                    break;
                case IPhototagsOperation.SELECT_Photo:
                    dataobject = get_phototags_with_foreignkey_photo(phototagsusecases);
                    break;
                case IPhototagsOperation.SELECT_SEARCH:
                    dataobject = search_phototags(phototagsusecases);
                    break;
                case IPhototagsOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_phototags_count(phototagsusecases);
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

    private Object get_phototags_with_primarykey(Phototags_usecases phototagsusecases) throws DBException {
        IPhototagsPK phototagsPK = (IPhototagsPK)parser.getJavaObject("phototagspk");
        return phototagsusecases.get_phototags_by_primarykey(phototagsPK);
    }

    private Object get_phototags_with_foreignkey_photo(Phototags_usecases phototagsusecases) throws CustomException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return phototagsusecases.get_phototags_with_foreignkey_photo(photoPK);
    }
    
    private Object search_phototags(Phototags_usecases phototagsusecases) throws CustomException {
        IPhototagssearch search = (IPhototagssearch)parser.getJavaObject("search");
        return phototagsusecases.search_phototags(search);
    }
    
    private Object search_phototags_count(Phototags_usecases phototagsusecases) throws CustomException {
        IPhototagssearch phototagssearch = (IPhototagssearch)parser.getJavaObject("search");
        return phototagsusecases.search_phototags_count(phototagssearch);
    }

    @Override
    public String getServletInfo() {
        return "phototags_select";
    }

}

