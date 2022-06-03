/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 */

package film.servlets.art_photo;

import general.exception.*;
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
@WebServlet(name="Art_photo_select", urlPatterns={"/film.Art_photo_select"})
public class Art_photo_select extends SecurityDataServlet {
   
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
                case IArt_photoOperation.SELECT_ALL:
                    dataobject = art_photousecases.get_all();
                    break;
                case IArt_photoOperation.SELECT_ART_PHOTO:
                    dataobject = get_art_photo_with_primarykey(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_Photo:
                    dataobject = get_art_photo_with_foreignkey_photo(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_Art_subgroup:
                    dataobject = get_art_photo_with_foreignkey_art_subgroup(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_Art_academy:
                    dataobject = get_art_photo_with_foreignkey_art_academy(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_Art_group:
                    dataobject = get_art_photo_with_foreignkey_art_group(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_SEARCH:
                    dataobject = search_art_photo(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_art_photo_count(art_photousecases);
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

    private Object get_art_photo_with_primarykey(Art_photo_usecases art_photousecases) throws DBException {
        IArt_photoPK art_photoPK = (IArt_photoPK)parser.getJavaObject("art_photopk");
        return art_photousecases.get_art_photo_by_primarykey(art_photoPK);
    }

    private Object get_art_photo_with_foreignkey_photo(Art_photo_usecases art_photousecases) throws CustomException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return art_photousecases.get_art_photo_with_foreignkey_photo(photoPK);
    }
    
    private Object get_art_photo_with_foreignkey_art_subgroup(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)parser.getJavaObject("art_subgrouppk");
        return art_photousecases.get_art_photo_with_foreignkey_art_subgroup(art_subgroupPK);
    }
    
    private Object get_art_photo_with_foreignkey_art_academy(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)parser.getJavaObject("art_academypk");
        return art_photousecases.get_art_photo_with_foreignkey_art_academy(art_academyPK);
    }
    
    private Object get_art_photo_with_foreignkey_art_group(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)parser.getJavaObject("art_grouppk");
        return art_photousecases.get_art_photo_with_foreignkey_art_group(art_groupPK);
    }
    
    private Object search_art_photo(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_photosearch search = (IArt_photosearch)parser.getJavaObject("search");
        return art_photousecases.search_art_photo(search);
    }
    
    private Object search_art_photo_count(Art_photo_usecases art_photousecases) throws CustomException {
        IArt_photosearch art_photosearch = (IArt_photosearch)parser.getJavaObject("search");
        return art_photousecases.search_art_photo_count(art_photosearch);
    }

    @Override
    public String getServletInfo() {
        return "art_photo_select";
    }

}

