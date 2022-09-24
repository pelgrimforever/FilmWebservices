/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Photo;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Photo_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLphoto blphoto = new BLphoto(sqlreader);
    
    public Photo_usecases() {
        this(false);
    }
    
    public Photo_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blphoto.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    private PhotoImagefile photoimagefile = new PhotoImagefile();    
    private Photogeolocator photogeolocator = new Photogeolocator();
    
    public ArrayList<Photo> get_publicprivate_photo_with_foreignkey_film_with_ThumbnailImages(IFilmPK filmPK) throws CustomException {
        boolean loadthumbnails = true;
        return blphoto.getPhotos4photo_film(loggedin, filmPK, loadthumbnails);
    }
    
    public ArrayList<Photo> get_publicprivate_photo_with_foreignkey_film_for_editing(film.logic.Userprofile userprofile, IFilmPK filmPK) throws CustomException {
        boolean loadthumbnails = true;
        return blphoto.getPhotos4photo_film_edit(userprofile, filmPK, loadthumbnails);
    }
    
    public Filedata get_smallimage_from_photo(film.logic.Userprofile userprofile, IPhotoPK photoPK) throws DBException, IOException {
        if(blphoto.hasAccess(userprofile, photoPK))
            return photoimagefile.getSmallfiledata(photoPK);
        else
            return null;
    }
    
    public Filedata get_croppedimage_from_photo(film.logic.Userprofile userprofile, IPhotoPK photoPK) throws DBException, IOException {
        if(blphoto.hasAccess(userprofile, photoPK))
            return photoimagefile.getCroppedfiledata(photoPK);
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
        SQLTqueue tq = new SQLTqueue();
        Photo dbphoto = null;
        if(photo.getReversegeocode()!=null && 
                photo.getReversegeocode().length()>0 && 
                (photo.isReversegeocodeUpdated() || photo.isLocationUpdated())) {   
            dbphoto = blphoto.getPhoto(photo.getPrimaryKey());
            dbphoto.setLocation(photo.getLocation());
            dbphoto.setReversegeocode(photo.getReversegeocode());
            dbphoto.setExactlocation(photo.getExactlocation());
            photogeolocator.google_processreversegeocode(tq, dbphoto);
            blphoto.updatePhoto(tq, dbphoto);
        }
        sqlwriter.Commit2DB(tq);
    }
    
    public boolean copyPreviousGeolocation(IPhoto photo) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        boolean updated = blphoto.updateCopyPrevGeolocation(tq, photo);
        sqlwriter.Commit2DB(tq);
        return updated;
    }

    public boolean copyGeolocation_from_Photo(IPhoto photo, IPhotoPK source_photoPK) throws DBException, CustomException {
        SQLTqueue tq = new SQLTqueue();
        boolean updated = blphoto.copyPhotoGeolocation(tq, photo, source_photoPK);
        sqlwriter.Commit2DB(tq);
        return updated;
    }
    
    public void uploadPhotoImage_Root(Filedata rootphotofile) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.uploadPhotoImage_Root(tq, rootphotofile);
        sqlwriter.Commit2DB(tq);
    }

    public void uploadPhotoImage_Cropped(Filedata croppedphotofile) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.uploadPhotoImage_Cropped(tq, croppedphotofile);
    }

    public String uploadPhotoImage_Manual_return_filename(Filedata photofile, HashMap photoproperties) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        String filename = blphoto.uploadPhotoImage(tq, photofile, photoproperties);
        sqlwriter.Commit2DB(tq);
        return filename;
    }

    public String uploadPhotoImage_CONroot(Filedata conrootphotofile, HashMap conhotoproperties) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        String filename = blphoto.uploadPhotoImage_CONRoot(tq, conrootphotofile, conhotoproperties);
        sqlwriter.Commit2DB(tq);
        return filename;
    }

    public void uploadPhotoImage_CONcropped(Filedata concroppedphotofile, HashMap concroppedphotoproperties) throws DBException, DataException, IOException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.uploadPhotoImage_CONCropped(tq, concroppedphotofile, concroppedphotoproperties);
        sqlwriter.Commit2DB(tq);
    }

    public void uploadPhoto_properties(film.logic.Userprofile userprofile, IPhoto photo, ArrayList tree7subjects) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        boolean location_has_changed = photo.getReversegeocode()!=null && photo.getReversegeocode().length()>0 && 
                (photo.isReversegeocodeUpdated() || photo.isLocationUpdated());
        if(location_has_changed)
            photogeolocator.processreversegeocode(tq, photo);
        blphoto.updatePhoto(tq, userprofile, photo, tree7subjects);
        sqlwriter.Commit2DB(tq);
    }
    
    public java.io.File getThumbnail(IPhotoPK photoPK) throws DBException {
        return blphoto.getThumbnail(photoPK);
    }
    
    public java.io.File getSmall(IPhotoPK photoPK) throws DBException {
        return blphoto.getSmall(photoPK);
    }
    
    public Filedata getRootfiledata(IPhotoPK photoPK) throws DBException, IOException {
        return photoimagefile.getRootfiledata(photoPK);
    }    

    public Photo getLastPhotoinGroup(String filmgroupid) throws DBException {
        return blphoto.getLastPhotoinGroup(filmgroupid);
    }

    public Photo getLastPhotoinGroupAndType(String filmgroupid, String uploadtype) throws DBException {
        return blphoto.getLastPhotoinGroupAndType(filmgroupid, uploadtype);
    }
    
    public String getImagePath(IPhotoPK photoPK, String subpath) {
        return photoimagefile.getImagePath(photoPK, subpath);
    }
    
    public ArrayList getPhotos4photo_film(boolean hasprivateaccess, IFilmPK filmPK, boolean loadthumbnails) throws CustomException {
        return blphoto.getPhotos4photo_film(hasprivateaccess, filmPK, loadthumbnails);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blphoto.count();
    }
    
    public ArrayList<Photo> get_all() throws DBException {
        return blphoto.getPhotos();
    }
    
    public boolean getPhotoExists(IPhotoPK photoPK) throws DBException {
        return blphoto.getPhotoExists(photoPK);
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

    public void insertPhoto(IPhoto photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.insertPhoto(tq, photo);
        sqlwriter.Commit2DB(tq);
    }

    public void updatePhoto(IPhoto photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.updatePhoto(tq, photo);
        sqlwriter.Commit2DB(tq);
    }

    public void deletePhoto(IPhoto photo) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.deletePhoto(tq, photo);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Route(IRoutePK routePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.delete4route(tq, routePK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Creator(ICreatorPK creatorPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.delete4creator(tq, creatorPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Film(IFilmPK filmPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blphoto.delete4film(tq, filmPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

