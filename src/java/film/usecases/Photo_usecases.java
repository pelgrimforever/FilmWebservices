/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Photo;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Photo_usecases {

    private boolean loggedin = false;
    private BLphoto blphoto = new BLphoto();
    
    public Photo_usecases() {
        this(false);
    }
    
    public Photo_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphoto.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Photo> get_publicprivate_photo_with_foreignkey_film_with_ThumbnailImages(IFilmPK filmPK) throws CustomException {
        boolean loadthumbnails = true;
        return blphoto.getPhotos4photo_film(loggedin, filmPK, loadthumbnails);
    }
    
    public ArrayList<Photo> get_publicprivate_photo_with_foreignkey_film_for_editing(film.logic.Userprofile userprofile, IFilmPK filmPK) throws CustomException {
        boolean loadthumbnails = true;
        return blphoto.getPhotos4photo_film_edit(userprofile, filmPK, loadthumbnails);
    }
    
    public Filedata get_smallimage_from_photo(film.logic.Userprofile userprofile, IPhotoPK photoPK) throws CustomException {
        if(blphoto.hasAccess(userprofile, photoPK))
            return blphoto.getSmallfiledata(photoPK);
        else
            return null;
    }
    
    public data.interfaces.db.Filedata get_croppedimage_from_photo(film.logic.Userprofile userprofile, IPhotoPK photoPK) throws CustomException {
        if(blphoto.hasAccess(userprofile, photoPK))
            return blphoto.getCroppedfiledata(photoPK);
        else
            return null;
    }
    
    public ArrayList<Photo> search_private(film.logic.Userprofile userprofile, IPhotosearch search) throws CustomException {
        boolean loadthumbnails = true;
        return blphoto.search(userprofile, search, loadthumbnails);
    }
    
    public ArrayList<Photo> get_photos_from_film_with_Thumbnails(IFilmPK filmPK) throws DBException, CustomException {
        ArrayList<Photo> photos = blphoto.getPhotos4film(filmPK);
        blphoto.addThumbnailsBase64(photos);
        return photos;
    }

    public long count_records_public_and_private(boolean privateaccess) throws DBException {
        return blphoto.count(privateaccess);
    }

    public ArrayList<Photo> get_photos_from_location_with_Thumbnails(piPoint location) throws DBException, CustomException {
        ArrayList<Photo> photos = blphoto.getPhoto4Location(loggedin, location);
        blphoto.addThumbnailsBase64(photos);
        return photos;
    }

    public ArrayList<Photo> get_photos_from_locations_with_Thumbnails(ArrayList<piPoint> locations) throws DBException, CustomException {
        ArrayList<Photo> photos = blphoto.getPhoto4Locations(locations);
        blphoto.addThumbnailsBase64(photos);
        return photos;
    }

    public ArrayList<Photo> get_photos_from_date(Date date) throws DBException, CustomException {
        ArrayList<Photo> photos = blphoto.getPhoto4Date(loggedin, date);
        return photos;
    }

    public ArrayList<Photo> search_photos_with_Thumbnails(IPhotosearch searchparameters) throws DBException, CustomException {
        ArrayList<Photo> photos = blphoto.search(searchparameters);
        blphoto.addThumbnailsBase64(photos);
        return photos;
    }

    public long search_photos_count_public_and_private(IPhotosearch searchparameters) throws DBException {
        return blphoto.searchcount(searchparameters);
    }
    
    public ArrayList<String> search_text_in_description(String searchtext) throws DBException, CustomException {
        return blphoto.getDescriptions(searchtext);
    }

    public void updateGeolocation(IPhoto photo) throws DBException, DataException {
        blphoto.updateGeolocation(photo);
    }

    public boolean copyPreviousGeolocation(IPhoto photo) throws DBException, CustomException {
        return blphoto.updateCopyPrevGeolocation(photo);
    }

    public boolean copyGeolocation_from_Photo(IPhoto photo, IPhotoPK source_photoPK) throws DBException, CustomException {
        return blphoto.copyPhotoGeolocation(photo, source_photoPK);
    }
    
    public void uploadPhotoImage_Root(Filedata rootphotofile) throws DBException, DataException {
        blphoto.uploadPhotoImage_Root(rootphotofile);
    }

    public void uploadPhotoImage_Cropped(Filedata croppedphotofile) throws DBException, DataException {
        blphoto.uploadPhotoImage_Cropped(croppedphotofile);
    }

    public String uploadPhotoImage_Manual_return_filename(Filedata photofile, HashMap photoproperties) throws DBException, DataException {
        return blphoto.uploadPhotoImage("Photo_usecases.uploadPhotoImage_Manual", photofile, photoproperties);
    }

    public String uploadPhotoImage_CONroot(Filedata conrootphotofile, HashMap conhotoproperties) throws DBException, DataException {
        return blphoto.uploadPhotoImage_CONRoot(conrootphotofile, conhotoproperties);
    }

    public void uploadPhotoImage_CONcropped(Filedata concroppedphotofile, HashMap concroppedphotoproperties) throws DBException, DataException {
        blphoto.uploadPhotoImage_CONCropped(concroppedphotofile, concroppedphotoproperties);
    }

    public void uploadPhoto_properties(film.logic.Userprofile userprofile, IPhoto photo, ArrayList tree7subjects) throws DBException, DataException {
        blphoto.updatePhoto("Photo_usecases.uploadPhoto_properties", userprofile, photo, tree7subjects);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphoto.count();
    }
    
    public ArrayList<Photo> get_all() throws DBException {
        return blphoto.getPhotos();
    }
    
    public boolean getPhotoExists(IPhotoPK photoPK) throws DBException {
        return blphoto.getEntityExists(photoPK);
    }
    
    public Photo get_photo_by_primarykey(IPhotoPK photoPK) throws DBException {
        return blphoto.getPhoto(photoPK);
    }

    public ArrayList<Photo> get_photo_with_foreignkey_route(IRoutePK routePK) throws CustomException {
        return blphoto.getPhotos4route(routePK);
    }
    
    public ArrayList<Photo> get_photo_with_foreignkey_creator(ICreatorPK creatorPK) throws CustomException {
        return blphoto.getPhotos4creator(creatorPK);
    }
    
    public ArrayList<Photo> get_photo_with_foreignkey_film(IFilmPK filmPK) throws CustomException {
        return blphoto.getPhotos4film(filmPK);
    }
    
    public Photo get_photo_with_externalforeignkey_phototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        return blphoto.getPhototree7subject(phototree7subjectPK);
    }
    
    public Photo get_photo_with_externalforeignkey_art_photo(IArt_photoPK art_photoPK) throws CustomException {
        return blphoto.getArt_photo(art_photoPK);
    }
    
    public Photo get_photo_with_externalforeignkey_photosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        return blphoto.getPhotosubjects(photosubjectsPK);
    }
    
    public Photo get_photo_with_externalforeignkey_phototags(IPhototagsPK phototagsPK) throws CustomException {
        return blphoto.getPhototags(phototagsPK);
    }
    
    public ArrayList<Photo> search_photo(IPhotosearch photosearch) throws CustomException {
        return blphoto.search(photosearch);
    }
    
    public long search_photo_count(IPhotosearch photosearch) throws CustomException {
        return blphoto.searchcount(photosearch);
    }

    public void secureinsertPhoto(IPhoto photo) throws DBException, DataException {
        blphoto.secureinsertPhoto(photo);
    }

    public void secureupdatePhoto(IPhoto photo) throws DBException, DataException {
        blphoto.secureupdatePhoto(photo);
    }

    public void securedeletePhoto(IPhoto photo) throws DBException, DataException {
        blphoto.securedeletePhoto(photo);
    }
}

