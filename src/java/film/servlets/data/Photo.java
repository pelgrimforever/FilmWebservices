/*
 * DataServlet.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.servlets.data;

import film.BusinessObject.Logic.*;
import general.exception.CustomException;
import data.interfaces.db.Filedata;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.IPhoto;
import film.interfaces.servlet.IPhotoOperation;
import film.interfaces.searchentity.IPhotosearch;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="Photo", urlPatterns={"/film.Photo"})
public class Photo extends SecurityDataServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        loadAuthorization(request);

        Object dataobject = null;
        BLphoto blphoto = new BLphoto();
        blphoto.setAuthenticated(authenticated);
//Custom code, do not change this line
//add here custom operations
        boolean privateaccess = userprofile!=null && userprofile.privateaccess();
//Custom code, do not change this line   
        try {
            switch(this.operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    IPhotoPK photoPK;
                    IPhoto photo;
                    switch(this.operation) {
                        case IPhotoOperation.SELECT_ALL:
                            dataobject = blphoto.getPhotos();
                            break;
                        case IPhotoOperation.SELECT_PHOTO:
                            photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            dataobject = blphoto.getPhoto(photoPK);
                            break;
                        case IPhotoOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
                            dataobject = blphoto.getPhotos4route(routePK);
                            break;
                        case IPhotoOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
                            dataobject = blphoto.getPhotos4creator(creatorPK);
                            break;
                        case IPhotoOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = blphoto.getPhotos4film(filmPK);
                            break;
                        case IPhotoOperation.SELECT_Phototree7subject:
                            IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)parser.getJavaObject("phototree7subjectpk");
                            dataobject = blphoto.getPhototree7subject(phototree7subjectPK);
                            break;
                        case IPhotoOperation.SELECT_Art_photo:
                            IArt_photoPK art_photoPK = (IArt_photoPK)parser.getJavaObject("art_photopk");
                            dataobject = blphoto.getArt_photo(art_photoPK);
                            break;
                        case IPhotoOperation.SELECT_Photosubjects:
                            IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)parser.getJavaObject("photosubjectspk");
                            dataobject = blphoto.getPhotosubjects(photosubjectsPK);
                            break;
                        case IPhotoOperation.SELECT_Phototags:
                            IPhototagsPK phototagsPK = (IPhototagsPK)parser.getJavaObject("phototagspk");
                            dataobject = blphoto.getPhototags(phototagsPK);
                            break;
                        case IPhotoOperation.SELECT_SEARCH:
                            IPhotosearch search = (IPhotosearch)parser.getJavaObject("search");
                            dataobject = blphoto.search(search);
                            break;
                        case IPhotoOperation.SELECT_SEARCHCOUNT:
                            IPhotosearch photosearch = (IPhotosearch)parser.getJavaObject("search");
                            dataobject = blphoto.searchcount(photosearch);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotoOperation.SELECT_4FILM:
                            filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = blphoto.getPhotos4photo_film(privateaccess, filmPK, true);
                            break;
                        case IPhotoOperation.SELECT_4FILM_EDIT:
                            filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            dataobject = blphoto.getPhotos4photo_film_edit(userprofile, filmPK, true);
                            break;
                        case IPhotoOperation.SELECT_SMALLIMAGE:
                            IPhotoPK s_photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            if(blphoto.hasAccess(userprofile, s_photoPK)) {
                                dataobject = blphoto.getSmallfiledata(s_photoPK);
                            }
                            break;
                        case IPhotoOperation.SELECT_CROPPEDIMAGE:
                            IPhotoPK c_photoPK = (IPhotoPK)parser.getJavaObject("photopk");
                            if(blphoto.hasAccess(userprofile, c_photoPK)) {
                                dataobject = blphoto.getCroppedfiledata(c_photoPK);
                            }
                            break;
                        case IPhotoOperation.SELECT_SEARCHAUTH:
                            IPhotosearch searchauth = (IPhotosearch)parser.getJavaObject("search");
                            dataobject = blphoto.search(userprofile, searchauth, true);
                            break;
//Custom code, do not change this line   
                    }
                    break;

                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(this.operation) {
                        case IPhotoOperation.INSERT_PHOTO:
                            photo = (IPhoto)parser.getJavaObject("photo");
                            blphoto.insertPhoto(photo);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotoOperation.INSERT_ROOT:
                            Filedata rootphotofile = parser.getFiledata("rootphoto");
                            blphoto.uploadPhotoImage_Root(rootphotofile);
                            break;
                        case IPhotoOperation.INSERT_CROPPED:
                            Filedata croppedphotofile = parser.getFiledata("croppedphoto");
                            blphoto.uploadPhotoImage_Cropped(croppedphotofile);
                            break;
                        case IPhotoOperation.INSERT_MANUAL:
                            Filedata photofile = parser.getFiledata("photo");
                            HashMap photoproperties = (HashMap)parser.getJavaObject("photoproperties");
                            String newfilename = blphoto.uploadPhotoImage(this.getServletName(), photofile, photoproperties);
                            dataobject = newfilename;
                            break;
                        case IPhotoOperation.INSERT_CONROOT:
                            Filedata conrootphotofile = parser.getFiledata("rootphoto");
                            HashMap conhotoproperties = (HashMap)parser.getJavaObject("photoproperties");
                            String usedfilename = blphoto.uploadPhotoImage_CONRoot(conrootphotofile, conhotoproperties);
                            dataobject = usedfilename;
                            break;
                        case IPhotoOperation.INSERT_CONCROPPED:
                            Filedata concroppedphotofile = parser.getFiledata("croppedphoto");
                            HashMap concroppedphotoproperties = (HashMap)parser.getJavaObject("photoproperties");
                            blphoto.uploadPhotoImage_CONCropped(concroppedphotofile, concroppedphotoproperties);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(this.operation) {
                        case IPhotoOperation.UPDATE_PHOTO:
                            photo = (IPhoto)parser.getJavaObject("photo");
                            blphoto.updatePhoto(photo);
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IPhotoOperation.UPDATE_GEOLOCATION:
                            photo = (IPhoto)parser.getJavaObject("photo");
                            blphoto.updateGeolocation(photo);
                            break;
                        case IPhotoOperation.UPDATE_PROPERTIES:
                            IPhoto photop = (IPhoto)parser.getJavaObject("photo");
                            //ArrayList subjects = (ArrayList)parser.getJavaObject("subjects");
                            ArrayList tree7subjects = (ArrayList)parser.getJavaObject("tree7subjects");
                            blphoto.updatePhoto(this.getServletName(), userprofile, photop, tree7subjects);
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(this.operation) {
                        case IPhotoOperation.DELETE_PHOTO:
                            photo = (IPhoto)parser.getJavaObject("photo");
                            blphoto.deletePhoto(photo);
                            break;
                        case IPhotoOperation.DELETE_Route:
                            IRoutePK routePK = (IRoutePK)parser.getJavaObject("routepk");
                            blphoto.delete4route(this.getServletName(), routePK);
                            break;
                        case IPhotoOperation.DELETE_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)parser.getJavaObject("creatorpk");
                            blphoto.delete4creator(this.getServletName(), creatorPK);
                            break;
                        case IPhotoOperation.DELETE_Film:
                            IFilmPK filmPK = (IFilmPK)parser.getJavaObject("filmpk");
                            blphoto.delete4film(this.getServletName(), filmPK);
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_BACKUP:
                    switch(this.operation) {
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line
                    }
                    break;
            }

        } 
        catch(CustomException e) {
            dataobject = e;
        }
        finally {
        }
        this.sendData(response, dataobject);
    } 

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "photo";
    }

}

