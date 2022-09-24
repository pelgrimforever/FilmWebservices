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

@WebServlet(name="Photo_insert", urlPatterns={"/film.Photo_insert"})
public class Photo_insert extends SecurityDataServlet {
   
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
                case IPhotoOperation.INSERT_PHOTO:
                    insert_photo(photousecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhotoOperation.INSERT_ROOT:
                    insert_rootphoto(photousecases);
                    break;
                case IPhotoOperation.INSERT_CROPPED:
                    uploadPhotoImage_Cropped(photousecases);
                    break;
                case IPhotoOperation.INSERT_MANUAL:
                    dataobject = uploadPhotoImage_Manual_return_filename(photousecases);
                    break;
                case IPhotoOperation.INSERT_CONROOT:
                    dataobject = uploadPhotoImage_CONroot(photousecases);
                    break;
                case IPhotoOperation.INSERT_CONCROPPED:
                    uploadPhotoImage_CONcropped(photousecases);
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
    private void insert_rootphoto(Photo_usecases photousecases) throws DBException, DataException, IOException {
        Filedata rootphotofile = parser.getFiledata("rootphoto");
        photousecases.uploadPhotoImage_Root(rootphotofile);
    }
    
    private void uploadPhotoImage_Cropped(Photo_usecases photousecases) throws DBException, DataException, IOException {
        Filedata croppedphotofile = parser.getFiledata("croppedphoto");
        photousecases.uploadPhotoImage_Cropped(croppedphotofile);
    }
    
    private String uploadPhotoImage_Manual_return_filename(Photo_usecases photousecases) throws DBException, DataException, IOException {
        Filedata photofile = parser.getFiledata("photo");
        HashMap photoproperties = (HashMap)parser.getJavaObject("photoproperties");
        return photousecases.uploadPhotoImage_Manual_return_filename(photofile, photoproperties);
    }

    private String uploadPhotoImage_CONroot(Photo_usecases photousecases) throws DBException, DataException, IOException {
        Filedata conrootphotofile = parser.getFiledata("rootphoto");
        HashMap conhotoproperties = (HashMap)parser.getJavaObject("photoproperties");
        return photousecases.uploadPhotoImage_CONroot(conrootphotofile, conhotoproperties);
    }

    private void uploadPhotoImage_CONcropped(Photo_usecases photousecases) throws DBException, DataException, IOException {
        Filedata concroppedphotofile = parser.getFiledata("croppedphoto");
        HashMap concroppedphotoproperties = (HashMap)parser.getJavaObject("photoproperties");
        photousecases.uploadPhotoImage_CONcropped(concroppedphotofile, concroppedphotoproperties);
    }
//Custom code, do not change this line   

    private void insert_photo(Photo_usecases photousecases) throws CustomException {
        IPhoto photo = (IPhoto)parser.getJavaObject("photo");
        photousecases.insertPhoto(photo);
    }
    
    @Override
    public String getServletInfo() {
        return "photo_insert";
    }

}

