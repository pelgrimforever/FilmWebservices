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

@WebServlet(name="Photo_select", urlPatterns={"/film.Photo_select"})
public class Photo_select extends SecurityDataServlet {
   
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
                case IPhotoOperation.SELECT_ALL:
                    dataobject = photousecases.get_all();
                    break;
                case IPhotoOperation.SELECT_PHOTO:
                    dataobject = get_photo_with_primarykey(photousecases);
                    break;
                case IPhotoOperation.SELECT_Route:
                    dataobject = get_photo_with_foreignkey_route(photousecases);
                    break;
                case IPhotoOperation.SELECT_Creator:
                    dataobject = get_photo_with_foreignkey_creator(photousecases);
                    break;
                case IPhotoOperation.SELECT_Film:
                    dataobject = get_photo_with_foreignkey_film(photousecases);
                    break;
                case IPhotoOperation.SELECT_Phototree7subject:
                    dataobject = get_photo_with_externalforeignkey_phototree7subject(photousecases);
                    break;
                case IPhotoOperation.SELECT_Art_photo:
                    dataobject = get_photo_with_externalforeignkey_art_photo(photousecases);
                    break;
                case IPhotoOperation.SELECT_Photosubjects:
                    dataobject = get_photo_with_externalforeignkey_photosubjects(photousecases);
                    break;
                case IPhotoOperation.SELECT_Phototags:
                    dataobject = get_photo_with_externalforeignkey_phototags(photousecases);
                    break;
                case IPhotoOperation.SELECT_SEARCH:
                    dataobject = search_photo(photousecases);
                    break;
                case IPhotoOperation.SELECT_SEARCHCOUNT:
                    dataobject = search_photo_count(photousecases);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhotoOperation.SELECT_4FILM:
                    dataobject = get_publicprivate_photo_with_foreignkey_film_with_ThumbnailImages(photousecases);
                    break;
                case IPhotoOperation.SELECT_4FILM_EDIT:
                    dataobject = get_publicprivate_photo_with_foreignkey_film_for_editing(photousecases);
                    break;
                case IPhotoOperation.SELECT_SMALLIMAGE:
                    dataobject = get_smallimage_from_photo(photousecases);
                    break;
                case IPhotoOperation.SELECT_CROPPEDIMAGE:
                    dataobject = get_croppedimage_from_photo(photousecases);
                    break;
                case IPhotoOperation.SELECT_SEARCHAUTH:
                    dataobject = search_private(photousecases);
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
    public Object get_publicprivate_photo_with_foreignkey_film_with_ThumbnailImages(Photo_usecases photousecases) throws DBException, CustomException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        return photousecases.get_publicprivate_photo_with_foreignkey_film_with_ThumbnailImages(filmPK);
    }

    public Object get_publicprivate_photo_with_foreignkey_film_for_editing(Photo_usecases photousecases) throws DBException, CustomException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        return photousecases.get_publicprivate_photo_with_foreignkey_film_for_editing(userprofile, filmPK);
    }

    public Object get_smallimage_from_photo(Photo_usecases photousecases) throws DBException, IOException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return photousecases.get_smallimage_from_photo(userprofile, photoPK);
    }

    public Object get_croppedimage_from_photo(Photo_usecases photousecases) throws DBException, IOException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return photousecases.get_croppedimage_from_photo(userprofile, photoPK);
    }

    public Object search_private(Photo_usecases photousecases) throws DBException, CustomException {
        IPhotosearch search = (IPhotosearch)parser.getJavaObject("search");
        return photousecases.search_private(userprofile, search);
    }
//Custom code, do not change this line   

    private Object get_photo_with_primarykey(Photo_usecases photousecases) throws DBException {
        IPhotoPK photoPK = (IPhotoPK)parser.getJavaObject("photopk");
        return photousecases.get_photo_by_primarykey(photoPK);
    }

    private Object get_photo_with_foreignkey_route(Photo_usecases photousecases) throws CustomException {
        IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
        return photousecases.get_photo_with_foreignkey_route(routePK);
    }
    
    private Object get_photo_with_foreignkey_creator(Photo_usecases photousecases) throws CustomException {
        ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
        return photousecases.get_photo_with_foreignkey_creator(creatorPK);
    }
    
    private Object get_photo_with_foreignkey_film(Photo_usecases photousecases) throws CustomException {
        IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
        return photousecases.get_photo_with_foreignkey_film(filmPK);
    }
    
    private Object get_photo_with_externalforeignkey_phototree7subject(Photo_usecases photousecases) throws CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
        return photousecases.get_photo_with_externalforeignkey_phototree7subject(phototree7subjectPK);
    }
    
    private Object get_photo_with_externalforeignkey_art_photo(Photo_usecases photousecases) throws CustomException {
        IArt_photoPK art_photoPK = (IArt_photoPK)parser.getJavaObject("art_photopk");
        return photousecases.get_photo_with_externalforeignkey_art_photo(art_photoPK);
    }
    
    private Object get_photo_with_externalforeignkey_photosubjects(Photo_usecases photousecases) throws CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
        return photousecases.get_photo_with_externalforeignkey_photosubjects(photosubjectsPK);
    }
    
    private Object get_photo_with_externalforeignkey_phototags(Photo_usecases photousecases) throws CustomException {
        IPhototagsPK phototagsPK = (IPhototagsPK)parser.getJavaObject("phototagspk");
        return photousecases.get_photo_with_externalforeignkey_phototags(phototagsPK);
    }
    
    private Object search_photo(Photo_usecases photousecases) throws CustomException {
        IPhotosearch search = (IPhotosearch)parser.getJavaObject("search");
        return photousecases.search_photo(search);
    }
    
    private Object search_photo_count(Photo_usecases photousecases) throws CustomException {
        IPhotosearch photosearch = (IPhotosearch)parser.getJavaObject("search");
        return photousecases.search_photo_count(photosearch);
    }

    @Override
    public String getServletInfo() {
        return "photo_select";
    }

}

