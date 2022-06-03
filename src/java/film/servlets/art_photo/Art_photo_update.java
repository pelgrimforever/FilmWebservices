/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.art_photo;

import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IArt_photo;
import film.interfaces.servlet.IArt_photoOperation;
import film.interfaces.searchentity.IArt_photosearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import film.usecases.Art_photo_usecases;
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
@WebServlet(name="Art_photo_update", urlPatterns={"/film.Art_photo_update"})
public class Art_photo_update extends SecurityDataServlet {
   
    @Override
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);
        Object dataobject = null;
        Art_photo_usecases art_photousecases = new Art_photo_usecases(authenticated);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
        try {
            switch(this.operation) {
                case IArt_photoOperation.UPDATE_ART_PHOTO:
                    update_art_photo(art_photousecases);
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

    private void update_art_photo(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_photo art_photo = (IArt_photo)parser.getJavaObject("art_photo");
        art_photousecases.secureupdateArt_photo(art_photo);
    }
    
    @Override
    public String getServletInfo() {
        return "art_photo_insert";
    }

}

