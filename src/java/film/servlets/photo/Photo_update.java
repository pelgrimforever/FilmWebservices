/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.servlets.photo;

import general.exception.*;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPhoto;
import film.interfaces.servlet.IPhotoOperation;
import film.interfaces.searchentity.IPhotosearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Photo_usecases;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Photo_update", urlPatterns={"/film.Photo_update"})
public class Photo_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Photo_usecases photousecases = new Photo_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IPhotoOperation.UPDATE_PHOTO:
                    update_photo(photousecases);
                    break;
//Custom code, do not change this line
//add here custom operations
            case IPhotoOperation.UPDATE_GEOLOCATION:
                updateGeolocation(photousecases);
                break;
            case IPhotoOperation.UPDATE_PROPERTIES:
                uploadPhoto_properties(photousecases);
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
    private void updateGeolocation(Photo_usecases photousecases) throws CustomException {
        IPhoto photo = (IPhoto)parser.getJavaObject("photo");
        photousecases.updateGeolocation(photo);
    }

    private void uploadPhoto_properties(Photo_usecases photousecases) throws CustomException {
        IPhoto photop = (IPhoto)parser.getJavaObject("photo");
        ArrayList tree7subjects = (ArrayList)parser.getJavaObject("tree7subjects");
        photousecases.uploadPhoto_properties(userprofile, photop, tree7subjects);
    }
//Custom code, do not change this line   

    private void update_photo(Photo_usecases photousecases) throws CustomException {
        IPhoto photo = (IPhoto)parser.getJavaObject("photo");
        photousecases.updatePhoto(photo);
    }
    
    @Override
    public String getServletInfo() {
        return "photo_insert";
    }

}

