/*
 * BLphoto.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 *
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import BusinessObject.BusinessLogic;
import static BusinessObject.BusinessLogic.FILEROOT;
import data.gis.shape.piPoint;
import data.gis.shape.piPolyline;
import data.google.geocode.Googleaddresscomponent;
import data.google.geocode.Googleaddresssubcomponent;
import data.google.geocode.Googlegeocode;
import data.interfaces.db.Filedata;
import film.logicentity.Photo;
import film.BusinessObject.table.Bphoto;
import film.entity.pk.*;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.IFilm;
import film.interfaces.logicentity.IPhoto;
import film.interfaces.searchentity.IPhotosearch;
import film.logic.Userprofile;
import film.logicentity.Arealevel1;
import film.logicentity.Arealevel2;
import film.logicentity.Arealevel3;
import film.logicentity.Country;
import film.logicentity.Film;
import film.logicentity.Locality;
import film.logicentity.Postalcode;
import film.logicentity.Route;
import film.logicentity.Sublocality;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import graphic.jpeg.Graphicfile;
import graphic.jpeg.Tag;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import data.google.geocode.Googlegeocodestatus;
import data.osm.geocode.OSMgeocode;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import data.interfaces.db.Tablesearcher;
import db.SQLparameters;
import film.conversion.entity.EMphoto;
import film.logicview.Viewdescriptions;

/**
 * Business Logic Entity class BLphoto
 *
 * Class for manipulating data- and database objects
 * for Entity Photo and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLphoto extends Bphoto {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public final static String THUMBNAILPATH = "thumbnail" + File.separator;
    public final static String SMALLPATH = "small" + File.separator;
    public final static String CROPPEDPATH = "cropped" + File.separator;
    public final static String FILEEXTENTION = "jpg";

    //path to store temporary photo files to work with the photo website
    //not used anymore
    //public final static String TEMPdestinationpath = "../docroot/photos/temp/";
    //public final static String TEMPonlinepath = "temp/";

    public final static int SMALL_WIDTH = 800;
    public final static int SMALL_HEIGHT = 600;
    public final static int THUMBNAIL_WIDTH = 200;
    public final static int THUMBNAIL_HEIGHT = 200;

    private Object[][] publiconly = { { "public", true } };
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
    
    /**
     * Constructor, sets Photo as default Entity
     */
    public BLphoto() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Photo as default Entity
 sets transaction queue from given BusinessLogic implementation
 all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLphoto(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
        this.setAuthenticated(transactionobject.isAuthenticated());
    }

    public boolean hasAccess(Userprofile userprofile, IPhotoPK photoPK) throws DBException {
        boolean hasaccess = userprofile!=null && userprofile.privateaccess();
        if(!hasaccess) {
            Photo photo = (Photo)super.getEntity((PhotoPK)photoPK);
            hasaccess = photo.getPublic();
        }
        return hasaccess;
    }

    /**
     * count all records of table
     * @return records amount
     * @throws DBException 
     */
    @Override
    public long count() throws DBException {
        String searchsql = "select count(*) as count from photo where public";
        return this.count(searchsql, null);
    }

    /**
     * count all records of table
     * @param loggedin
     * @return records amount
     * @throws DBException 
     */
    public long count(boolean loggedin) throws DBException {
        if(loggedin) {
            String searchsql = "select count(*) as count from photo";
            return this.count(searchsql, null);
        } else {
            return this.count();
        }
    }

    /**
     * get all Photo objects from database
     * @return ArrayList of Photo objects
     * @throws DBException
     */
    public ArrayList getPhotos() throws DBException {
        return getPhotos(this.isAuthenticated());
    }
    
    /**
     * get all Photo objects from database
     * @param privateaccess
     * @return ArrayList of Photo objects
     * @throws DBException
     */
    public ArrayList getPhotos(boolean privateaccess) throws DBException {
        if(privateaccess)
            return this.getEntities(EMphoto.SQLSelect4photo_sorted);
        else {
            SQLparameters parameters = new SQLparameters(publiconly);
            return this.getEntities(EMphoto.SQLSelectAll4Public, parameters);
        }
    }

    /**
     * search Photo for primary key
     * @param photoPK: Photo primary key
     * @return Photo object
     * @throws DBException
     */
    @Override
    public Photo getPhoto(IPhotoPK photoPK) throws DBException {
        return (Photo)super.getEntity((PhotoPK)photoPK);
    }

    /**
     * search Photo for primary key
     * @param userprofile
     * @param photoPK: Photo primary key
     * @return Photo object
     * @throws DBException
     */
    public Photo getPhoto(Userprofile userprofile, IPhotoPK photoPK) throws DBException {
        Photo returnphoto = (Photo)super.getEntity((PhotoPK)photoPK);
        if(!userprofile.privateaccess() && !returnphoto.getPublic()) returnphoto = null;
        return returnphoto;
    }

    /**
     * get Photo for primary key, return null if access is not allowed
     * @param hasprivateaccess: has private access ?
     * @param photoPK: photo primary key
     * @return Photo object
     * @throws DBException 
     */
    public Photo getPhoto(boolean hasprivateaccess, IPhotoPK photoPK) throws DBException {
        Photo returnphoto = getPhoto(photoPK);
        if(!(hasprivateaccess || returnphoto.getPublic())) returnphoto = null;
        return returnphoto;
    }
    
    /**
     * search public photos with search parameters
     * if no search is used, return empty list
     * @param search: IPhotosearch object
     * @return ArrayList of Photo entities
     * @throws DBException
     */
    public ArrayList search(IPhotosearch search) throws DBException {
        if(search.used()) {
            String sqlorderby = EMphoto.OrderByDateTime;
            search.build("");
            String searchsql = "select distinct photo.* from photo" + search.getJoin() + " where (" + search.getSql() + ")";
            if(!this.isAuthenticated()) searchsql += " and public";
            searchsql += sqlorderby;
            ArrayList photos = this.getEntities(searchsql, search.getParameters());
            //this.addSmallimage(photos, hasprivateaccess);
            return photos;
        } else {
            return new ArrayList();
        }
    }

    public void addThumbnailsBase64(ArrayList photos) throws DBException, CustomException {
        Photo photo;
        try {
            for(int i=0; i<photos.size(); i++) {
                photo = (Photo)photos.get(i);
                if(photo.getPublic() || this.isAuthenticated()) {
                    BufferedImage bi = ImageIO.read(getThumbnail(photo.getPrimaryKey()));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bi, "jpg", baos);
                    photo.setImagebase64("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(baos.toByteArray()));
                }
            }
        }
        catch(IOException e) {
            throw new CustomException(e);
        }
    }
    
    /**
     * perform photos search with search parameters
     * return only the amount of records found
     * @param search: IPhotosearch object
     * @return number of found records
     * @throws DBException 
     */
    public long searchcount(IPhotosearch search) throws DBException {
        long count = 0;
        if(search.used()) {
            search.build("");
            String searchsql = EMphoto.SQLSelectAll + search.getJoin() + " where (" + search.getSql() + ")";
            if(!this.isAuthenticated()) searchsql += " and public";        
            searchsql = "select count(distinct tablecount.*) as count from (" + searchsql + ") as tablecount";
            count = this.count(searchsql, search.getParameters());
        }
        return count;
    }
    
    /**
     * search Photos for a given location
     * @param hasprivateaccess: has private access ?
     * @param location: location point
     * @return ArrayList of Photos
     * @throws DBException 
     */
    public ArrayList getPhoto4Location(boolean hasprivateaccess, piPoint location) throws DBException {
        ArrayList photos;
        Object[][] parameter = { { "location", location } };
        SQLparameters parameters = new SQLparameters(parameter);
        if(hasprivateaccess) {
            photos = this.getEntities(EMphoto.SQLSelect4location, parameters);
        } else {
            parameters.add(publiconly);
            photos = this.getEntities(EMphoto.SQLSelect4publiclocation, parameters);
        }
        return photos;
    }
    
    /**
     * search Photos for given locations
     * @param locations: location points
     * @return ArrayList of Photos
     * @throws DBException 
     */
    public ArrayList getPhoto4Locations(ArrayList<piPoint> locations) throws DBException {
        ArrayList photos;
        SQLparameters parameters = new SQLparameters();
        Iterator<piPoint> locationsI = locations.iterator();
        int l = 0;
        StringBuilder sqlwhere = new StringBuilder("");
        String parametername = "";
        while(locationsI.hasNext()) {
            parametername = "location" + l;
            Object[][] p = {{ parametername, locationsI.next() }};
            parameters.add(p);
            sqlwhere.append(Photo.fieldnames[Photo.LOCATION-1]).append(" = :").append(parametername).append(":");
            if(locationsI.hasNext()) {
                sqlwhere.append(" or ");
            }
            l++;
        }
        StringBuilder sql = new StringBuilder(EMphoto.SQLSelectAll).append(" where ");
        if(this.isAuthenticated()) {
            sql.append(sqlwhere);
        } else {
            parameters.add(publiconly);
            sql.append(EMphoto.SQLWherePublic).append(" and (").append(sqlwhere).append(")");
        }
        sql.append(EMphoto.OrderByDateTime);
        return this.getEntities(sql.toString(), parameters);
    }
    
    /**
     * search Photos for a given date
     * @param hasprivateaccess: has private access ?
     * @param date: date
     * @return ArrayList of Photos
     * @throws DBException 
     */
    public ArrayList getPhoto4Date(boolean hasprivateaccess, Date date) throws DBException {
        ArrayList photos;
        Object[][] parameter = { { "photodate", date } };
        SQLparameters parameters = new SQLparameters(parameter);
        if(hasprivateaccess) {
            photos = this.getEntities(EMphoto.SQLSelect4date, parameters);
        } else {
            parameters.add(publiconly);
            photos = this.getEntities(EMphoto.SQLSelect4publicdate, parameters);
        }
        return photos;
    }
    
    /**
     * @param hasprivateaccess: boolean, access to private photos
     * @param filmPK: foreign key for Film
     * @param loadthumbnails: boolean, load thumbnail pictures in ArrayList for found photo objects
     * @return all Photo Entity objects for Film
     * @throws general.exception.CustomException
     */
    public ArrayList getPhotos4photo_film(boolean hasprivateaccess, IFilmPK filmPK, boolean loadthumbnails) throws CustomException {
        SQLparameters parameters = filmPK.getSQLprimarykey();
        ArrayList photos;
        if(hasprivateaccess) {
            photos = this.getEntities(EMphoto.SQLSelect4photo_film_sorted, parameters);
        } else {
            parameters.add(publiconly);
            photos = this.getEntities(EMphoto.SQLSelect4photo_filmpublic_sorted, parameters);
        }
        if(loadthumbnails)
            return loadThumbnailImages(photos);
        else
            return photos;
    }

    /**
     *
     * @param userprofile
     * @param filmPK: foreign key for Film
     * @param loadthumbnails
     * @return all Photo Entity objects for Film
     * @throws general.exception.CustomException
     */
    public ArrayList getPhotos4photo_film_edit(Userprofile userprofile, IFilmPK filmPK, boolean loadthumbnails) throws CustomException {
        ArrayList photos = new ArrayList();
        if(userprofile!=null && userprofile.isEditor()) {
            photos = getPhotos4photo_film(userprofile.privateaccess(), filmPK, loadthumbnails);
        }
        return photos;
    }

    /**
     *
     * @param filmPK: foreign key for Film
     * @return all Photo Entity objects for Film where imagebackup
     * @throws general.exception.CustomException
     */
    public ArrayList getPhotos4photo_film_imagebackup(IFilmPK filmPK) throws CustomException {
        return this.getEntities(EMphoto.SQLSelect4photo_film_imagebackup, filmPK.getSQLprimarykey());
    }

    /**
     *
     * @param filmPK: foreign key for Film
     * @return all Photo Entity objects for Film where backup
     * @throws general.exception.CustomException
     */
    public ArrayList getPhotos4photo_film_backup(IFilmPK filmPK) throws CustomException {
        return this.getEntities(EMphoto.SQLSelect4photo_film_backup, filmPK.getSQLprimarykey());
    }

    /**
     *
     * @param photoPK: Photo Primary Key
     * @param subpath: sub directory of Photo Image Path
     * @return Photo directory
     */
    public String getImagePath(IPhotoPK photoPK, String subpath) {
        return BLfilm.getRootImagePath(photoPK.getFilmPK()).append(subpath).toString();
    }

    /**
     *
     * @param photoPK: Photo Primary Key
     * @return Photo Filename
     */
    protected String getFilename(IPhotoPK photoPK) {
        return new StringBuffer(Photo.getFileName(photoPK)).append(".").append(FILEEXTENTION).toString();
    }

    /**
     *
     * @param photoPK: Photo Primary Key
     * @param format: format suffix in filename (C, P, COMPOSITION, ...)
     * @return Photo Filename
     */
    private String getFilename(IPhotoPK photoPK, String format) {
        if(format.length()==1) {
            return new StringBuffer(Photo.getFileName(photoPK)).append(format).append(".").append(FILEEXTENTION).toString();
        } else {
            return new StringBuffer(Photo.getFileName(photoPK)).append("_").append(format).append(".").append(FILEEXTENTION).toString();
        }
    }

    /**
     *
     * @param photoPK: Photo primary key
     * @return Thumbnail image for this photo
     * @throws DBException
     */
    public Filedata getThumbnailfiledata(IPhotoPK photoPK) throws DBException {
        String filepath = getImagePath(photoPK, THUMBNAILPATH);
        String filename = getFilename(photoPK);
        return super.getFiledata(filepath, filename);
    }

    /**
     * returns the image file if authenticated or public
     * @param photoPK
     * @return image file, thumbnail size
     * @throws DBException 
     */
    public File getThumbnail(IPhotoPK photoPK) throws DBException {
        Photo photo = this.getPhoto(photoPK);
        if(isAuthenticated() || photo.getPublic()) {
            String filepath = getImagePath(photoPK, THUMBNAILPATH);
            String filename = getFilename(photoPK);
            return new File(BusinessLogic.FILEROOT + filepath + filename);
        } else {
            return null;
        }
    }
    
    /**
     * returns the image file if authenticated or public
     * @param photoPK
     * @return image file, small size
     * @throws DBException 
     */
    public File getSmall(IPhotoPK photoPK) throws DBException {
        Photo photo = this.getPhoto(photoPK);
        if(isAuthenticated() || photo.getPublic()) {
            String filepath = getImagePath(photoPK, SMALLPATH);
            String filename = getFilename(photoPK);
            return new File(BusinessLogic.FILEROOT + filepath + filename);
        } else {
            return null;
        }
    }
    
    /**
     *
     * @param photoPK: Photo primary key
     * @param format: format suffix in filename (C, P, COMPOSITION, ...)
     * @return Thumbnail image for this photo
     * @throws DBException
     */
    public Filedata getThumbnailfiledata(IPhotoPK photoPK, String format) throws DBException {
        String filepath = getImagePath(photoPK, THUMBNAILPATH);
        String filename = getFilename(photoPK, format);
        return super.getFiledata(filepath, filename);
    }

    /**
     *
     * @param photoPK Photo primary key
     * @return Small image path
     * @throws DBException
     */
    private String getSmallfilepath(IPhotoPK photoPK) {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK);
        return FILEROOT + filepath + filename;
    }

    /**
     * @param photoPK: Photo primary key
     * @return Small image for this photo
     * @throws DBException
     */
    public Filedata getSmallfiledata(IPhotoPK photoPK) throws DBException {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK);
        return super.getFiledata(filepath, filename);
    }

    /**
     * @param photoPK: Photo primary key
     * @param format: format suffix in filename (C, P, COMPOSITION, ...)
     * @return Small image for this photo
     * @throws DBException
     */
    public Filedata getSmallfiledata(IPhotoPK photoPK, String format) throws DBException {
        String filepath = getImagePath(photoPK, SMALLPATH);
        String filename = getFilename(photoPK, format);
        return super.getFiledata(filepath, filename);
    }

    /**
     * @param photoPK: Photo primary key
     * @return Cropped image for this photo
     * @throws DBException
     */
    public Filedata getCroppedfiledata(IPhotoPK photoPK) throws DBException {
        String filepath = getImagePath(photoPK, CROPPEDPATH);
        String filename = getFilename(photoPK);
        return super.getFiledata(filepath, filename);
    }

    /**
     * @param photoPK: Photo primary key
     * @param format: format suffix in filename (C, P, COMPOSITION, ...)
     * @return Cropped image for this photo
     * @throws DBException
     */
    public Filedata getCroppedfiledata(IPhotoPK photoPK, String format) throws DBException {
        String filepath = getImagePath(photoPK, CROPPEDPATH);
        String filename = getFilename(photoPK, format);
        return super.getFiledata(filepath, filename);
    }

    /**
     * @param photoPK: Photo primary key
     * @return Cropped image for this photo
     * @throws DBException
     */
    public Filedata getRootfiledata(IPhotoPK photoPK) throws DBException {
        String filepath = BLfilm.getRootImagePath(photoPK.getFilmPK()).toString();
        String filename = getFilename(photoPK);
        return super.getFiledata(filepath, filename);
    }

    /**
     * Search all descriptions that contain searchtext
     * @param searchtext: searchtext
     * @return ArrayList of description Strings
     * @throws DBException 
     */
    public ArrayList getDescriptions(String searchtext) throws DBException {
        String search = ":*:" + searchtext + ":*:";
        Object[][] parameter = { { "description", search } };
        SQLparameters parameters = new SQLparameters(parameter);
        String sql = EMphoto.SQLSelectDescriptions;
        if(!this.isAuthenticated()) {
            sql += " and " + EMphoto.SQLWherePublic;
            parameters.add(publiconly);
        }
        sql += EMphoto.OrderByDescription;
        BLviewdescriptions blviewdescriptions = new BLviewdescriptions();
        ArrayList<Viewdescriptions> descriptions = blviewdescriptions.getEntities(sql, parameters);
        ArrayList<String> descriptionsarray = new ArrayList<String>();
        for(Viewdescriptions descriptionview: descriptions) {
            descriptionsarray.add(descriptionview.getDescription());
        }
        return descriptionsarray;
    }
    
    /**
     * get photos where location or date/time is not in database
     * @return ArrayList of Photo objects
     * @throws DBException 
     */
    public ArrayList getPhotoDataErrors() throws DBException {
        return this.getEntities(EMphoto.SQLSelectDataError);
    }
    
    /**
     * Backup Image files
     * Delete images in root and cropped directory to save server diskspace
     * only keep files in small and thumbnail
     * @param film
     * @param photo
     * @param backupdir
     * @throws DBException
     * @throws CustomException
     */
    public void backupImages(IFilm film, IPhoto photo, String backupdir) throws DBException, CustomException {
        String rootfilename = null;
        String croppedfilename = null;
        String croppedfilename_format = null;
        String croppedfilename_composition = null;

        String filmtype = film.getFilmtypePK().getType();
        IPhotoPK photoPK = photo.getPrimaryKey();
        //Root image must be present
        Filedata rootimage = getRootfiledata(photoPK);
        rootfilename = rootimage.getFilename();
        saveFileAbsolutepath(rootimage, backupdir + BLfilm.getRootImagePath(photoPK.getFilmPK()).toString());
        Filedata image;
        //cropped image must be present for APS, CON, DIA
        try {
            image = getCroppedfiledata(photoPK);
            croppedfilename = image.getFilename();
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
        }
        catch(Exception e) {
            //cropped file not found, create
            if(!filmtype.equals("APS") && !filmtype.equals("CON") && !filmtype.equals("DIA")) {
                String croppedpath = getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
                saveFile(rootimage, croppedpath);
                croppedpath = getImagePath(photoPK, CROPPEDPATH);
                saveFileAbsolutepath(rootimage, backupdir + getImagePath(photoPK, CROPPEDPATH));
            } else {
                throw new DBException(e);
            }
        }
        //small & thumbnail image, create in all cases when it does not exists
        try {
            image = getSmallfiledata(photoPK);
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
        }
        catch(Exception e) {
            //get cropped file, transform to small and save
            if(!filmtype.equals("APS") && !filmtype.equals("CON") && !filmtype.equals("DIA")) {
                try {
                    Graphicfile gf = rootimage.getGraphicfile();
                    //convert and save small
                    gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
                    String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
                    gf.saveImage(smallpath, rootimage.getFilename());
                    smallpath = backupdir + getImagePath(photo.getPrimaryKey(), SMALLPATH);
                    gf.saveImage(smallpath, rootimage.getFilename());
                }
                catch(Exception gfe) {
                    throw new DBException(gfe);
                }
            } else {
                throw new DBException(e);
            }
        }
        try {
            image = getThumbnailfiledata(photoPK);
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
        }
        catch(Exception e) {
            //get cropped file, transform to small and save
            if(!filmtype.equals("APS") && !filmtype.equals("CON") && !filmtype.equals("DIA")) {
                try {
                    Graphicfile gf = rootimage.getGraphicfile();
                    //convert and save thumbnail
                    gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
                    String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
                    gf.saveImage(thumbnailpath, rootimage.getFilename());
                    thumbnailpath = backupdir + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
                    gf.saveImage(thumbnailpath, rootimage.getFilename());
                }
                catch(Exception gfe) {
                    throw new DBException(gfe);
                }
            } else {
                throw new DBException(e);
            }
        }
        if(!photo.getFormat().equals("H")) {
            image = getCroppedfiledata(photoPK, photo.getFormat());
            log.finer("get cropped image for format " + photo.getFormat() + ": " + image.getFilename());
            croppedfilename_format = image.getFilename();
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
            image = getSmallfiledata(photoPK, photo.getFormat());
            log.finer("get small image for format " + photo.getFormat() + ": " + image.getFilename());
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
            image = getThumbnailfiledata(photoPK, photo.getFormat());
            log.finer("get thumbnail image for format " + photo.getFormat() + ": " + image.getFilename());
            saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
        }
        if(photo.getComposition()) {
            //check if file with COMPOSITION extention exists
            try {
                image = getCroppedfiledata(photoPK, "COMPOSITION");
                croppedfilename_composition = image.getFilename();
                saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, CROPPEDPATH));
            } catch(DBException e) {}
            try {
                image = getSmallfiledata(photoPK, "COMPOSITION");
                saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, SMALLPATH));
            } catch(DBException e) {}
            try {
                image = getThumbnailfiledata(photoPK, "COMPOSITION");
                saveFileAbsolutepath(image, backupdir + getImagePath(photoPK, THUMBNAILPATH));
            } catch(DBException e) {}
        }
        photo.setImagebackup(false);
        updatePhoto(photo);

        //delete files when database is updated
        String filepath = BLfilm.getRootImagePath(photoPK.getFilmPK()).toString();
        super.deleteFile(filepath, rootfilename);
        filepath = getImagePath(photoPK, CROPPEDPATH);
        super.deleteFile(filepath, croppedfilename);
        if(croppedfilename_format!=null) {
            super.deleteFile(filepath, croppedfilename_format);
        }
        if(croppedfilename_composition!=null) {
            super.deleteFile(filepath, croppedfilename_composition);
        }
    }

    /**
     *
     * @param photos: ArrayList of Photo objects
     * @return ArrayList of Photo Objects with thumbnail image data as Filedata Objects
     */
    private ArrayList loadThumbnailImages(ArrayList photos) {
        Photo photo;
        StringBuffer filepath;
        StringBuffer filename;
        String filmid;
        for(int i=0; i<photos.size(); i++) {
            photo = (Photo)photos.get(i);
            try {
                photo.setThumbnailimage(getThumbnailfiledata(photo.getPrimaryKey()));
            }
            catch(DBException e) {
                System.out.println(e.getMessage());
            }
        }
        return photos;
    }

    /**
     * try to insert Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void insertPhoto(IPhoto photo) throws DBException, DataException {
        trans_insertPhoto(photo);
        super.Commit2DB();
    }
    
    /**
     * try to insert Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureinsertPhoto(IPhoto photo) throws DBException, DataException {
        trans_insertPhoto(photo);
        super.Commit2DB();
    }
    
    /**
     * Check if write permissions on server disk are still ok
     * if not, a Data Exception is thrown
     * @throws DataException 
     */
    public void checkwritepermissions() throws DataException {
        //check writing permissions on disk
        File checkpermissionsfile = new File(BusinessLogic.FILEROOT + BLfilm.PHOTOSUBROOT);
        if(!checkpermissionsfile.canWrite()) {
            throw new DataException("No write permission on server disk");
        }
    }
    
    /**
     * try to insert Photo object in database, based on root and cropped photo file data
     * commit transaction
     * @param root: root Photo file
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void uploadPhotoImage_Root(Filedata root) throws DBException, DataException {
        checkwritepermissions(); //DataException is thrown when not ok
        String filename = root.getFilename();
        filename = filename.substring(0, filename.indexOf("."));
        String filmid = filename.substring(0, 3) + filename.substring(4, 7);
        int photoid = Integer.valueOf(filename.substring(8, 10));
        Photo photo = new Photo(filmid, photoid);
        photo.setPublic(false);
        photo.setFormat("H");
        if(this.getPhoto(photo.getPrimaryKey())==null) {
            trans_insertPhoto(photo);
            super.Commit2DB();
        }
        String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
        String newfilename = filename + "." + FILEEXTENTION;
        saveFileAs(root, rootpath, newfilename);
    }

    /**
     * try to insert Photo object in database, based on root and cropped photo file data
     * commit transaction
     * @param root: root Photo file
     * @param photoproperties
     * @return 
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public String uploadPhotoImage_CONRoot(Filedata root, HashMap photoproperties) throws DBException, DataException {
        checkwritepermissions(); //DataException is thrown when not ok
        String filmid = (String)photoproperties.get("filmid");
        int photoid = 0;
        Photo lastphoto = getLastPhotoinGroup(filmid);
        if(lastphoto!=null) {
            photoid = lastphoto.getPrimaryKey().getId()+1;
        }
        Photo photo = new Photo(filmid, photoid);
        photo.setCreatorPK((CreatorPK)photoproperties.get("creatorpk"));
        String filename = photo.getFileName(photo.getPrimaryKey());
        photo.setPublic(false);
        photo.setFormat("H");
        if(this.getPhoto(photo.getPrimaryKey())==null) {
            trans_insertPhoto(photo);
            super.Commit2DB();
        }
        String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
        String newfilename = filename + "." + FILEEXTENTION;
        saveFileAs(root, rootpath, newfilename);
        return newfilename;
    }

    public void uploadPhotoImage_CONCropped(Filedata cropped, HashMap photoproperties) throws DBException, DataException {
        checkwritepermissions(); //DataException is thrown when not ok
        String filmid = (String)photoproperties.get("filmid");
        String usedfilename = (String)photoproperties.get("usedfilename");
        String photonumber = usedfilename.substring(8, 10);
        int photoid = Integer.parseInt(photonumber);
        Photo photo = new Photo(filmid, photoid);
        String filename = photo.getFileName(photo.getPrimaryKey());
        photo.setPublic(false);
        photo.setFormat("H");
        if(this.getPhoto(photo.getPrimaryKey())==null) {
            trans_insertPhoto(photo);
            super.Commit2DB();
        }
        String croppedpath = getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
        String newfilename = filename + "." + FILEEXTENTION;
        saveFileAs(cropped, croppedpath, newfilename);
        Graphicfile gf = null;
        try {
            gf = cropped.getGraphicfile();
            //convert and save small
            gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
            String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
            gf.saveImage(smallpath, newfilename);
            //convert and save thumbnail
            gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
            String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
            gf.saveImage(thumbnailpath, newfilename);
        }
        catch(IOException e) {
            throw new DataException(e.getMessage());
        }
    }

    public String uploadPhotoImage(String senderobject, Filedata photofile, HashMap photoproperties) throws DBException, DataException {
        checkwritepermissions(); //DataException is thrown when not ok
        BLphototags blphototags = new BLphototags(this);
        //photofilename is the filename on disk and sent back as result
        String photofilename = null;
        //get Photo properties
        String filmgroupid = (String)photoproperties.get("filmgroupid");
        float rotation = (Float)photoproperties.get("rotation");
        String description = (String)photoproperties.get("description");
        ArrayList subjects = (ArrayList)photoproperties.get("subjects");
        String uploadtype = (String)photoproperties.get("uploadtype");
        CreatorPK creatorpk = (CreatorPK)photoproperties.get("creatorpk");
        Date photodate = null;
        Time phototime = null;
        Graphicfile gf = null;
        try {
            gf = photofile.getGraphicfile();
            Tag datetimetag = blphototags.findTag(gf.getMetadataTaglist(), Tag.DATETIMEORIGINAL);
            if(datetimetag!=null) {
                photodate = datetimetag.getDateValue();
                phototime = datetimetag.getTimeValue();
            }
        }
        catch(IOException e) {
            throw new DataException(e.getMessage());
        }

        //save root photo
        //last photo for this group
        Photo lastphoto = getLastPhotoinGroup(filmgroupid);
        //last photo for this group with uploadtype (film.type)
        Photo lastphotofortype = getLastPhotoinGroupAndType(filmgroupid, uploadtype);
        Photo photo;
        if(lastphotofortype==null || (lastphotofortype!=null && lastphotofortype.getPrimaryKey().getId()==99)) {
            //the combination group, film.type doesn't exist or is at 99
            String groupid;
            if(lastphotofortype==null) {
                if(lastphoto==null) {
                    //this group does not exist yet for any film.type
                    groupid = "000";
                } else {
                    //this group already exists for another film.type, create new one
                    String filmid = lastphoto.getPrimaryKey().getFilm();
                    groupid = filmid.substring(3, 6);
                    int groupnumber = Integer.valueOf(groupid).intValue() + 1;
                    groupid = String.valueOf(groupnumber);
                    while(groupid.length()<3) groupid = "0" + groupid;
                }
            } else {
                //99 is reached within last group for film.type, start new one
                String filmid = lastphoto.getPrimaryKey().getFilm();
                groupid = filmid.substring(3, 6);
                int groupnumber = Integer.valueOf(groupid).intValue() + 1;
                groupid = String.valueOf(groupnumber);
                while(groupid.length()<3) groupid = "0" + groupid;
            }
            Film film = new Film(filmgroupid + groupid);
            film.setPublic(false);
            film.setFilmtypePK(new FilmtypePK(uploadtype));
            BLfilm blfilm = new BLfilm(this);
            blfilm.trans_insertFilm(film);
            photo = new Photo(filmgroupid + groupid, 0);
        } else {
            photo = new Photo(lastphotofortype.getPrimaryKey().getFilm(), lastphotofortype.getPrimaryKey().getId()+1);
        }
        String filename = photo.getFileName(photo.getPrimaryKey());

        photo.setPublic(false);
        photo.setFormat("H");
        if(description!=null) photo.setDescription(description);
        photo.setCreatorPK(creatorpk);
        photo.setPhotodate(photodate);
        photo.setPhototime(phototime);
        if(this.getPhoto(photo.getPrimaryKey())==null) {
            trans_insertPhoto(photo);
            BLphototree7subject blphototree7subject = new BLphototree7subject(this);
            blphototree7subject.linkPhoto_with_Subjects(senderobject, photo.getPrimaryKey(), subjects);
            //BLphotosubjects blphotosubjects = new BLphotosubjects(this);
            //blphotosubjects.linkPhoto_with_Subjects(photo.getPrimaryKey(), subjects);
            String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
            String newfilename = filename + "." + FILEEXTENTION;
            saveFileAs(photofile, rootpath, newfilename);

            //save Cropped, Small and Thumbnail
            try {
                //load image as jpeg
                //Graphicfile gf = new Graphicfile(FILEROOT + rootpath + newfilename);
                blphototags.insertGraphicfileMetatags(gf, photo);
                //check if rotation is x * 90° or not
                //if so, simple rotation method used
                //if not, complex rotation method used
                int rotationfactor = (int)rotation;
                while(rotationfactor<0) rotationfactor += 360;
                while(rotationfactor>360) rotationfactor -= 360;
                switch(rotationfactor) {
                    case 90:
                        gf.rotateRight();
                        break;
                    case 180:
                        gf.rotate180();
                        break;
                    case 270:
                        gf.rotateLeft();
                        break;
                }
                String croppedpath = FILEROOT + getImagePath(photo.getPrimaryKey(), CROPPEDPATH);
                gf.saveImage(croppedpath, newfilename);
                //convert and save small
                gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
                String smallpath = FILEROOT + getImagePath(photo.getPrimaryKey(), SMALLPATH);
                gf.saveImage(smallpath, newfilename);
                //convert and save thumbnail
                gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
                String thumbnailpath = FILEROOT + getImagePath(photo.getPrimaryKey(), THUMBNAILPATH);
                gf.saveImage(thumbnailpath, newfilename);
                super.Commit2DB();
                //send back used filename
                photofilename = newfilename;
            }
            catch(IOException e) {
                throw new DBException(e);
            }
        }
        return photofilename;
    }

    public Photo getLastPhotoinGroup(String filmgroupid) throws DBException {
        Object[][] parameter = { { "groupid", filmgroupid + "%" } };
        SQLparameters parameters = new SQLparameters(parameter);
        return (Photo)this.getEntity(EMphoto.SQLSelectLastPhotoinGroup, parameters);
    }

    public Photo getLastPhotoinGroupAndType(String filmgroupid, String uploadtype) throws DBException {
        Object[][] parameter = {
            { "groupid", filmgroupid + "%" },
            { "type", uploadtype }
        };
        SQLparameters parameters = new SQLparameters(parameter);
        return (Photo)this.getEntity(EMphoto.SQLSelectLastPhotoinGroupAndFilmtype, parameters);
    }

    /**
     * try to insert Photo object in database, based on root and cropped photo file data
     * commit transaction
     * @param cropped: cropped Photo file
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void uploadPhotoImage_Cropped(Filedata cropped) throws DBException, DataException {
        checkwritepermissions(); //DataException is thrown when not ok
        String filename = cropped.getFilename();
        filename = filename.substring(0, filename.indexOf("."));
        String lastcharacter = "H";
        if(filename.endsWith("C")) lastcharacter = "C";
        if(filename.endsWith("P")) lastcharacter = "P";
        String filmid = filename.substring(0, 3) + filename.substring(4, 7);
        int photoid = Integer.valueOf(filename.substring(8, 10));
        PhotoPK photoPK = new PhotoPK(filmid, photoid);
        Photo photo = this.getPhoto(photoPK);
        if(filename.endsWith("COMPOSITION")) photo.setComposition(true);
        if(!lastcharacter.equals("H")) photo.setFormat(lastcharacter);
        this.trans_updatePhoto(photo);
        super.Commit2DB();
        String croppedpath = getImagePath(photoPK, CROPPEDPATH);
        String newfilename = filename + "." + FILEEXTENTION;
        saveFileAs(cropped, croppedpath, newfilename);

        //save Small and Thumbnail
        try {
            //load image as jpeg
            Graphicfile gf = new Graphicfile(Photo.getImage(cropped));
            //convert and save small
            gf.resize(SMALL_WIDTH, SMALL_HEIGHT);
            String smallpath = FILEROOT + getImagePath(photoPK, SMALLPATH);
            gf.saveImage(smallpath, newfilename);
            //convert and save thumbnail
            gf.resize(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT);
            String thumbnailpath = FILEROOT + getImagePath(photoPK, THUMBNAILPATH);
            gf.saveImage(thumbnailpath, newfilename);
        }
        catch(IOException e) {
            throw new DBException(e);
        }
    }

    /**
     * try to update Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    @Override
    public void updatePhoto(IPhoto photo) throws DBException, DataException {
        trans_updatePhoto(photo);
        super.Commit2DB();
    }

    /**
     * try to update Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void secureupdatePhoto(IPhoto photo) throws DBException, DataException {
        trans_updatePhoto(photo);
        super.Commit2DB();
    }

    /**
     * update location and dependent parameters
     * @param photo
     * @throws DBException
     * @throws DataException 
     */
    public void updateGeolocation(IPhoto photo) throws DBException, DataException {
        log.fine("updateGeolocation start");
        if(photo.getReversegeocode()!=null && photo.getReversegeocode().length()>0 && 
                (photo.isReversegeocodeUpdated() || photo.isLocationUpdated())) {   
            log.fine("ReverseGEOcode for " + photo.getPrimaryKey().getFilm() + " " + photo.getPrimaryKey().getId() + ": " + photo.getReversegeocode());
            log.fine("updateGeolocation authorized");
            //get photo from database and only update location parameters
            Photo dbphoto = this.getPhoto(photo.getPrimaryKey());
            dbphoto.setLocation(photo.getLocation());
            dbphoto.setReversegeocode(photo.getReversegeocode());
            dbphoto.setExactlocation(photo.getExactlocation());
            google_processreversegeocode(dbphoto);
            //processreversegeocode(dbphoto);
            trans_updatePhoto(dbphoto);
            log.fine("trans_updatePhoto performed");
            super.Commit2DB();
        }
    }
    
    /**
     * copy previous used location in this photo series
     * update location and dependent parameters
     * @param photo
     * @return 
     * @throws DBException
     * @throws DataException 
     */
    public boolean updateCopyPrevGeolocation(IPhoto photo) throws DBException, DataException, CustomException {
        boolean success = false;
        ArrayList<Photo> photos = getPhotos4photo_film(this.isAuthenticated(), photo.getPrimaryKey().getFilmPK(), false);
        int arraylength = photos.size();
        int index = arraylength-1;
        //find position of current photo
        while(index>-1 && photos.get(index).getPrimaryKey().getId()>photo.getPrimaryKey().getId()) {
            index--;
        }
        //if photo is found, search the nearest previous photo with a valid location
        int previousindex = index-1;
        while(previousindex>-1 && photos.get(previousindex).getReversegeocode()==null || photos.get(previousindex).getReversegeocode().length()==0) {
            previousindex--;
        }
        //if found, copy the location parameters
        if(previousindex>-1) {
            Photo updphoto = photos.get(index);
            Photo prevphoto = photos.get(previousindex);
            updphoto.setLocation(prevphoto.getLocation());
            updphoto.setLocationradius(prevphoto.getLocationradius());
            updphoto.setReversegeocode(prevphoto.getReversegeocode());
            updphoto.setExactlocation(prevphoto.getExactlocation());
            updphoto.setFormattedaddress(prevphoto.getFormattedaddress());
            updphoto.setRoutePK(prevphoto.getRoutePK());
            updphoto.setStreetnumber(prevphoto.getStreetnumber());
            trans_updatePhoto(updphoto);
            super.Commit2DB();
            success = true;
        }
        return success;
    }
    
    /**
     * copy given photo location in this photo
     * update location and dependent parameters
     * @param photo: photo to update
     * @param source_photoPK: photo primary key containing the location to use
     * @return 
     * @throws DBException
     * @throws DataException 
     */
    public boolean copyPhotoGeolocation(IPhoto photo, IPhotoPK source_photoPK) throws DBException, DataException, CustomException {
        boolean success = false;
        Photo updphoto = this.getPhoto(photo.getPrimaryKey());
        Photo source = this.getPhoto(source_photoPK);
        if(source!=null && source.getLocation()!=null && updphoto!=null) {
            updphoto.setLocation(source.getLocation());
            updphoto.setLocationradius(source.getLocationradius());
            updphoto.setReversegeocode(source.getReversegeocode());
            updphoto.setExactlocation(source.getExactlocation());
            updphoto.setFormattedaddress(source.getFormattedaddress());
            updphoto.setRoutePK(source.getRoutePK());
            updphoto.setStreetnumber(source.getStreetnumber());
            trans_updatePhoto(updphoto);
            super.Commit2DB();
            success = true;
        }
        return success;
    }
    
    /**
     * try to update Photo object in database
     * commit transaction
     * @param senderobject
     * @param userprofile
     * @param photo: Photo Entity Object
     * @param subjects
     * @param tree7subjects
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void updatePhoto(String senderobject, Userprofile userprofile, IPhoto photo, ArrayList subjects, ArrayList tree7subjects) throws DBException, DataException {
        //check if user is allowed to edit
        if(userprofile.isEditor()) {
            //check if user is allowed to manage this film (privateaccess check)
            if(getPhoto(userprofile, photo.getPrimaryKey())!=null) {
                trans_updatePhoto(photo);
                BLphotosubjects blphotosubjects = new BLphotosubjects(this);
                blphotosubjects.linkPhoto_with_Subjects(senderobject, photo.getPrimaryKey(), subjects);
                BLphototree7subject blphototree7subject = new BLphototree7subject(this);
                blphototree7subject.linkPhoto_with_Subjects(senderobject, photo.getPrimaryKey(), tree7subjects);
                super.Commit2DB();
            }
        }
    }

    public void updatePhoto(String senderobject, Userprofile userprofile, IPhoto photo, ArrayList tree7subjects) throws DBException, DataException {
        //check if user is allowed to edit
        if(userprofile.isEditor()) {
            //check if user is allowed to manage this film (privateaccess check)
            if(getPhoto(userprofile, photo.getPrimaryKey())!=null) {
                if(photo.getReversegeocode()!=null && photo.getReversegeocode().length()>0 && 
                        (photo.isReversegeocodeUpdated() || photo.isLocationUpdated())) {   
                    processreversegeocode(photo);
                }
                trans_updatePhoto(photo);
                BLphototree7subject blphototree7subject = new BLphototree7subject(this);
                blphototree7subject.linkPhoto_with_Subjects(senderobject, photo.getPrimaryKey(), tree7subjects);
                super.Commit2DB();
            }
        }
    }
    
    /**
     * try to delete Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     */
    @Override
    public void deletePhoto(IPhoto photo) throws DBException {
        trans_deletePhoto(photo);
        super.Commit2DB();
    }

    /**
     * try to delete Photo object in database
     * commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     */
    public void securedeletePhoto(IPhoto photo) throws DBException {
        trans_deletePhoto(photo);
        super.Commit2DB();
    }

    /**
     * try to insert Photo object in database
     * do not commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_insertPhoto(IPhoto photo) throws DBException, DataException {
        super.checkDATA(photo);
        super.insertPhoto((Photo)photo);
    }
    
    /**
     * try to update Photo object in database
     * do not commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     * @throws general.exception.DataException
     */
    public void trans_updatePhoto(IPhoto photo) throws DBException, DataException {
        super.checkDATA(photo);
        photo.setBackup(true);
        super.updatePhoto((Photo)photo);
    }
    
    /**
     * try to delete Photo object in database
     * do not commit transaction
     * @param photo: Photo Entity Object
     * @throws general.exception.DBException
     */
    public void trans_deletePhoto(IPhoto photo) throws DBException {
        super.deletePhoto((Photo)photo);
    }

    public void setBackedup(String senderobject, IFilmPK filmpk) throws DBException {
        Object[][] parameter = { { "backup", false } };
        SQLparameters parameters = new SQLparameters(parameter);
        parameters.add(filmpk.getSQLprimarykey());
        addStatement(EMphoto.SQLUpdateBackup4Film, parameters);
        Commit2DB();
    }

    /**
     * search database table with search parameters
     * if no search is used, return empty list
     * @param userprofile: Userprofile of logged in user
     * @param search: Tablesearcher object
     * @param loadthumbnails: boolean, load thumbnail pictures in ArrayList for found photo objects
     * @return ArrayList of found entities
     * @throws DBException
     */
    public ArrayList search(Userprofile userprofile, Tablesearcher search, boolean loadthumbnails) throws DBException {
        ArrayList photos = new ArrayList();
        if(userprofile!=null && userprofile.privateaccess()) {
            photos = super.search(search);
        } else {
            IPhotosearch photosearch = (IPhotosearch)search;
            ArrayList allphotos = super.search(search);
            IPhoto photo;
            for(int i=0; i<allphotos.size(); i++) {
                photo = (IPhoto)allphotos.get(i);
                if(photo.getPublic()) photos.add(photo);
            }
        }
        if(photos.size()<=search.getMaxresults() && loadthumbnails) {
            loadThumbnailImages(photos);
        }
        return photos;
    }
    
    /**
     * translate openstreetmaps reverse geocoding result into database fields
     * @param photo: photo data with new reverse geocode data
     * @throws DBException
     * @throws DataException 
     */
    private void processreversegeocode(IPhoto photo) throws DBException, DataException {
        StringBuilder datalog = new StringBuilder("Reverse geocode for ").append(photo.getPrimaryKey().getFilm()).append("-").append(photo.getPrimaryKey().getId());
        try {
            OSMgeocode geocode = new OSMgeocode(photo.getReversegeocode());

            piPolyline bounds;
            piPolyline viewport;
            log.finer("country " + geocode.getCountry() + " " + geocode.getCountrycode());
            datalog.append("\r\n").append("country ").append(geocode.getCountrycode()).append(" ").append(geocode.getCountry());
            Country country = new Country(geocode.getCountrycode());
            country.setName(geocode.getCountry());
            country.setLocation(geocode.getLocation().extractpiPoint());
/*                country.setHasarealevel1(compal1!=null);
                country.setHasarealevel2(compal2!=null);
                country.setHasarealevel3(compal3!=null);
*/
            BLcountry blcountry = new BLcountry(this);
            blcountry.insertcheckCountry(country);

            log.finer("al1 state " + geocode.getState());
            //Arealevel1 -> state
            datalog.append("\r\n").append("Arealevel1 state ").append(geocode.getState());
            Arealevel1 al1 = null;
            al1 = new Arealevel1(new Arealevel1PK(
                    country.getPrimaryKey().getCode(), 
                    geocode.getState()));
            al1.setName(geocode.getState());
            al1.setLocation(geocode.getLocation().extractpiPoint());

            BLarealevel1 blarealevel1 = new BLarealevel1(this);
            blarealevel1.insertcheckArealevel1(al1);

            log.finer("al2 county " + geocode.getCounty());
            //Arealevel2 -> county
            datalog.append("\r\n").append("Arealevel2 county ").append(geocode.getCounty());
            String countyname = geocode.getCounty();
            if(countyname==null) {
                countyname = al1.getPrimaryKey().getAl1code();
            }
            Arealevel2 al2 = null;
            al2 = new Arealevel2(new Arealevel2PK(
                    al1.getPrimaryKey().getCountrycode(), 
                    al1.getPrimaryKey().getAl1code(), 
                    countyname));
            al2.setName(countyname);
            al2.setLocation(geocode.getLocation().extractpiPoint());

            BLarealevel2 blarealevel2 = new BLarealevel2(this);
            blarealevel2.insertcheckArealevel2(al2);

            log.finer("al3 city " + geocode.getCity());
            //Arealevel3 -> city
            String city = geocode.getCity();
            if(city==null) {
                city = al2.getPrimaryKey().getAl2code();
            }
            datalog.append("\r\n").append("Arealevel3 city ").append(city);
            Arealevel3 al3 = null;
            al3 = new Arealevel3(new Arealevel3PK(
                    al2.getPrimaryKey().getCountrycode(), 
                    al2.getPrimaryKey().getAl1code(), 
                    al2.getPrimaryKey().getAl2code(),
                    city));
            al3.setName(city);
            al3.setLocation(geocode.getLocation().extractpiPoint());
            BLarealevel3 blarealevel3 = new BLarealevel3(this);
            blarealevel3.insertcheckArealevel3(al3);

            log.finer("postalcode " + geocode.getPostcode());
            datalog.append("\r\n").append("Postalcode ").append(geocode.getPostcode());
            Postalcode postalcode = null;
            postalcode = new Postalcode(
                    country.getPrimaryKey().getCode(), 
                    geocode.getPostcode());
            postalcode.setArealevel3PK(al3.getPrimaryKey());
            postalcode.setLocation(geocode.getLocation().extractpiPoint());
            bounds = new piPolyline(postalcode.getLocation().getSrid());
            BLpostalcode blpostalcode = new BLpostalcode(this);
            blpostalcode.insertcheckPostalcode(postalcode);

            log.finer("Locality town " + geocode.getTown());
            log.finer("Locality village " + geocode.getVillage());
            log.finer("Locality suburb " + geocode.getSuburb());
            log.finer("Locality citydisctrict " + geocode.getCitydistrict());
            log.finer("Locality statedisctrict " + geocode.getStatedistrict());
            datalog.append("\r\n").append("Locality town ").append(geocode.getTown());
            datalog.append("\r\n").append("Locality village ").append(geocode.getSuburb());
            datalog.append("\r\n").append("Locality suburb ").append(geocode.getSuburb());
            datalog.append("\r\n").append("Locality citydistrict ").append(geocode.getCitydistrict());
            datalog.append("\r\n").append("Locality statedisctrict ").append(geocode.getStatedistrict());
            String localityname = geocode.getTown();
            if(localityname==null) {
                localityname = geocode.getVillage();
            }
            if(localityname==null) {
                localityname = geocode.getSuburb();
            }
            if(localityname==null) {
                localityname = geocode.getCitydistrict();
            }
            if(localityname==null) {
                localityname = geocode.getStatedistrict();
            }
            Locality locality = null;
            locality = new Locality(
                    postalcode.getPrimaryKey().getCountrycode(),
                    postalcode.getPrimaryKey().getPostalcode(),
                    localityname);
            locality.setLocation(geocode.getLocation().extractpiPoint());
            bounds = new piPolyline(locality.getLocation().getSrid());
            BLlocality bllocality = new BLlocality(this);
            bllocality.insertcheckLocality(locality);

            log.finer("Sublocality neighbourhood " + geocode.getNeighbourhood());
            datalog.append("\r\n").append("Sublocality neighbourhood ").append(geocode.getNeighbourhood());
            Sublocality sublocality = null;
            String sublocalityname = geocode.getNeighbourhood();
            if(sublocalityname==null) sublocalityname = localityname;
            sublocality = new Sublocality(
                    locality.getPrimaryKey().getCountrycode(),
                    locality.getPrimaryKey().getPostalcode(),
                    locality.getPrimaryKey().getLocality(),
                    sublocalityname);
            sublocality.setLocation(geocode.getLocation().extractpiPoint());
            BLsublocality blsublocality = new BLsublocality(this);
            blsublocality.insertcheckSublocality(sublocality);

            log.finer("Route road " + geocode.getRoad());
            log.finer("Route footway " + geocode.getFootway());
            datalog.append("\r\n").append("Route road ").append(geocode.getRoad());
            datalog.append("\r\n").append("Route footway ").append(geocode.getFootway());
            String routename = geocode.getRoad();
            if(geocode.getRoad()==null) {
                routename = geocode.getFootway();
            }
            if(routename==null) {
                routename = sublocality.getPrimaryKey().getSublocality();
            }
            Route route = new Route(new RoutePK());
            route.getPrimaryKey().setSublocalityPK(sublocality.getPrimaryKey());
            route.getPrimaryKey().setRoutecode(routename);
            route.setName(routename);
            route.setLocation(geocode.getLocation().extractpiPoint());
            BLroute blroute = new BLroute(this);
            blroute.insertcheckRoute(route);

            log.finer("Streetnumber housenumber " + geocode.getHousenumber());
            photo.setRoutePK(route.getPrimaryKey());
            if(geocode.getHousenumber()!=null) {
                datalog.append("\r\n").append("Streetnumber housenumber ").append(geocode.getHousenumber());
                photo.setStreetnumber(geocode.getHousenumber());
            }
            log.finer("Reversegeocoding complete");
        }
        catch(NullPointerException e) {
            datalog.append("\r\n").append(photo.getReversegeocode());
            datalog.append("\r\n").append(e.getMessage());
            log.warning(datalog.toString());
            throw new DataException(datalog.toString());
        }
    }

    /**
     * translate google reverse geocoding result into database fields
     * @param photo: photo data with new reverse geocode data
     * @throws DBException
     * @throws DataException 
     */
    private void google_processreversegeocode(IPhoto photo) throws DBException, DataException {
        StringBuilder datalog = new StringBuilder("Reverse geocode for ").append(photo.getPrimaryKey().getFilm()).append("-").append(photo.getPrimaryKey().getId());
        try {
            Googlegeocode geocode = new Googlegeocode(photo.getReversegeocode());
            if(geocode.getStatus().equals(Googlegeocodestatus.STATUS_OK)) {
                Googleaddresscomponent compcountry = geocode.getCountry();
                Googleaddresscomponent compal1 = geocode.getArealevel1();
                Googleaddresscomponent compal2 = geocode.getArealevel2();
                Googleaddresscomponent compal3 = geocode.getArealevel3();
                Googleaddresscomponent comppostalcode = geocode.getPostalcode();
                //in case there is a prefix, it contains the bounds for the Postalcode
                Googleaddresscomponent comppostalcodeprefix = geocode.getPostalcodePrefix();
                Googleaddresscomponent complocality = geocode.getLocality();
                Googleaddresscomponent compsublocality = geocode.getSublocality();
                Googleaddresscomponent comproute = geocode.getRoute();
                Googleaddresscomponent compstreetaddress = geocode.getStreetaddress();

                piPolyline bounds;
                piPolyline viewport;
                Country country = null;
                datalog.append("\r\n").append("compcountry Null ").append((compcountry==null));
                if(compcountry!=null) {
                    datalog.append("\r\n").append("Country Shortname ");
                    datalog.append("\r\n").append(compcountry.getCountry().getShortname());
                    country = new Country(compcountry.getCountry().getShortname());
                    datalog.append("\r\n").append("Country Longname ");
                    datalog.append("\r\n").append(compcountry.getCountry().getLongname());
                    country.setName(compcountry.getCountry().getLongname());
                    country.setLocation(compcountry.getLocation().extractpiPoint());
                    bounds = new piPolyline(country.getLocation().getSrid());
                    bounds.addPoint(compcountry.getBounds().extractpiPointNE());
                    bounds.addPoint(compcountry.getBounds().extractpiPointSW());
                    country.setBounds(bounds);
                    viewport = new piPolyline(country.getLocation().getSrid());
                    viewport.addPoint(compcountry.getViewport().extractpiPointNE());
                    viewport.addPoint(compcountry.getViewport().extractpiPointSW());
                    country.setViewport(viewport);
                    country.setApproximate(compcountry.getIsApproximate());
                    country.setHasarealevel1(compal1!=null);
                    country.setHasarealevel2(compal2!=null);
                    country.setHasarealevel3(compal3!=null);
                } else {
                    Googleaddresssubcomponent subcountrycomp = geocode.findCountry();
                    datalog.append("\r\n").append("Country Shortname ");
                    datalog.append("\r\n").append(subcountrycomp.getShortname());
                    country = new Country(subcountrycomp.getShortname());
                    datalog.append("\r\n").append("Country Longname ");
                    datalog.append("\r\n").append(subcountrycomp.getLongname());
                    country.setName(subcountrycomp.getLongname());
                    country.setApproximate(true);
                    country.setHasarealevel1(compal1!=null);
                    country.setHasarealevel2(compal2!=null);
                    country.setHasarealevel3(compal3!=null);
                }
                if(country!=null) {
                    BLcountry blcountry = new BLcountry(this);
                    blcountry.insertcheckCountry(country);
                    //log.finer("Country check: " + country.getPrimaryKey().getKeystring());
                } else {
                    log.warning("Country nog defined in " + photo.getReversegeocode());
                }

                Arealevel1 al1 = null;
                if(compal1==null) {
                    al1 = new Arealevel1(new Arealevel1PK(
                            country.getPrimaryKey().getCode(), 
                            country.getPrimaryKey().getCode()));
                    if(compstreetaddress!=null && compstreetaddress.getArealevel1()!=null) {
                        al1.getPrimaryKey().setAl1code(compstreetaddress.getArealevel1().getShortname());
                        al1.setName(compstreetaddress.getArealevel1().getLongname());
                    } else if(comproute!=null && comproute.getArealevel1()!=null) {
                        al1.getPrimaryKey().setAl1code(comproute.getArealevel1().getShortname());
                        al1.setName(comproute.getArealevel1().getLongname());                
                    }
                } else {
                    al1 = new Arealevel1(new Arealevel1PK(
                            country.getPrimaryKey().getCode(), 
                            compal1.getArealevel1().getShortname()));
                    al1.setName(compal1.getArealevel1().getLongname());
                    al1.setLocation(compal1.getLocation().extractpiPoint());
                    bounds = new piPolyline(al1.getLocation().getSrid());
                    bounds.addPoint(compal1.getBounds().extractpiPointNE());
                    bounds.addPoint(compal1.getBounds().extractpiPointSW());
                    al1.setBounds(bounds);
                    viewport = new piPolyline(al1.getLocation().getSrid());
                    viewport.addPoint(compal1.getViewport().extractpiPointNE());
                    viewport.addPoint(compal1.getViewport().extractpiPointSW());
                    al1.setViewport(viewport);
                    al1.setApproximate(compal1.getIsApproximate());
                }
                BLarealevel1 blarealevel1 = new BLarealevel1(this);
                blarealevel1.insertcheckArealevel1(al1);
                //log.finer("Area Level 1 check: " + al1.getPrimaryKey().getKeystring());

                Arealevel2 al2 = null;
                if(compal2==null) {
                    al2 = new Arealevel2(new Arealevel2PK(
                            al1.getPrimaryKey().getCountrycode(), 
                            al1.getPrimaryKey().getAl1code(), 
                            al1.getPrimaryKey().getAl1code()));
                    if(compstreetaddress!=null && compstreetaddress.getArealevel2()!=null) {
                        al2.getPrimaryKey().setAl2code(compstreetaddress.getArealevel2().getShortname());
                        al2.setName(compstreetaddress.getArealevel2().getLongname());
                    } else if(comproute!=null && comproute.getArealevel2()!=null) {
                        al2.getPrimaryKey().setAl2code(comproute.getArealevel2().getShortname());
                        al2.setName(comproute.getArealevel2().getLongname());                
                    }
                } else {
                    al2 = new Arealevel2(new Arealevel2PK(
                            al1.getPrimaryKey().getCountrycode(), 
                            al1.getPrimaryKey().getAl1code(), 
                            compal2.getArealevel2().getShortname()));
                    al2.setName(compal2.getArealevel2().getLongname());
                    al2.setLocation(compal2.getLocation().extractpiPoint());
                    bounds = new piPolyline(al2.getLocation().getSrid());
                    bounds.addPoint(compal2.getBounds().extractpiPointNE());
                    bounds.addPoint(compal2.getBounds().extractpiPointSW());
                    al2.setBounds(bounds);
                    viewport = new piPolyline(al2.getLocation().getSrid());
                    viewport.addPoint(compal2.getViewport().extractpiPointNE());
                    viewport.addPoint(compal2.getViewport().extractpiPointSW());
                    al2.setViewport(viewport);
                    al2.setApproximate(compal2.getIsApproximate());
                }
                BLarealevel2 blarealevel2 = new BLarealevel2(this);
                blarealevel2.insertcheckArealevel2(al2);
                //log.finer("Area Level 2 check: " + al2.getPrimaryKey().getKeystring());

                Arealevel3 al3 = null;
                if(compal3==null) {
                    al3 = new Arealevel3(new Arealevel3PK(
                            al2.getPrimaryKey().getCountrycode(), 
                            al2.getPrimaryKey().getAl1code(), 
                            al2.getPrimaryKey().getAl2code(),
                            al2.getPrimaryKey().getAl2code()));
                    if(compstreetaddress!=null && compstreetaddress.getArealevel3()!=null) {
                        al3.getPrimaryKey().setAl3code(compstreetaddress.getArealevel3().getShortname());
                        al3.setName(compstreetaddress.getArealevel3().getLongname());
                    } else if(comproute!=null && comproute.getArealevel3()!=null) {
                        al3.getPrimaryKey().setAl3code(comproute.getArealevel3().getShortname());
                        al3.setName(comproute.getArealevel3().getLongname());                
                    }
                } else {
                    al3 = new Arealevel3(new Arealevel3PK(
                            al2.getPrimaryKey().getCountrycode(), 
                            al2.getPrimaryKey().getAl1code(), 
                            al2.getPrimaryKey().getAl2code(),
                            compal3.getArealevel3().getShortname()));
                    al3.setName(compal3.getArealevel3().getLongname());
                    al3.setLocation(compal3.getLocation().extractpiPoint());
                    bounds = new piPolyline(al3.getLocation().getSrid());
                    bounds.addPoint(compal3.getBounds().extractpiPointNE());
                    bounds.addPoint(compal3.getBounds().extractpiPointSW());
                    al3.setBounds(bounds);
                    viewport = new piPolyline(al3.getLocation().getSrid());
                    viewport.addPoint(compal3.getViewport().extractpiPointNE());
                    viewport.addPoint(compal3.getViewport().extractpiPointSW());
                    al3.setViewport(viewport);
                    al3.setApproximate(compal3.getIsApproximate());
                }
                BLarealevel3 blarealevel3 = new BLarealevel3(this);
                blarealevel3.insertcheckArealevel3(al3);
                //log.finer("Area Level 3 check: " + al3.getPrimaryKey().getKeystring());

                Postalcode postalcode = null;
                if(comppostalcode==null) {
                    String postalcodestring = "000000";
                    if(compstreetaddress!=null && compstreetaddress.getPostalcode()!=null) {
                        postalcodestring = compstreetaddress.getPostalcode().getShortname();
                    } else if(comproute!=null && comproute.getPostalcode()!=null) {
                        postalcodestring = comproute.getPostalcode().getShortname();
                    }
                    postalcode = new Postalcode(
                            country.getPrimaryKey().getCode(), 
                            postalcodestring);
                    postalcode.setArealevel3PK(al3.getPrimaryKey());
                } else {
                    postalcode = new Postalcode(
                            country.getPrimaryKey().getCode(), 
                            comppostalcode.getPostalcode().getShortname());
                    postalcode.setArealevel3PK(al3.getPrimaryKey());
                    postalcode.setLocation(comppostalcode.getLocation().extractpiPoint());
                    bounds = new piPolyline(postalcode.getLocation().getSrid());
                    if(comppostalcode.getBounds()!=null) {
                        bounds.addPoint(comppostalcode.getBounds().extractpiPointNE());
                        bounds.addPoint(comppostalcode.getBounds().extractpiPointSW());
                    } else if(comppostalcodeprefix!=null && comppostalcodeprefix.getBounds()!=null) {
                        bounds.addPoint(comppostalcodeprefix.getBounds().extractpiPointNE());
                        bounds.addPoint(comppostalcodeprefix.getBounds().extractpiPointSW());
                    } else {
                        bounds.addPoint(comppostalcode.getViewport().extractpiPointNE());
                        bounds.addPoint(comppostalcode.getViewport().extractpiPointSW());
                    }
                    postalcode.setBounds(bounds);
                    viewport = new piPolyline(postalcode.getLocation().getSrid());
                    viewport.addPoint(comppostalcode.getViewport().extractpiPointNE());
                    viewport.addPoint(comppostalcode.getViewport().extractpiPointSW());
                    postalcode.setViewport(viewport);
                    postalcode.setApproximate(comppostalcode.getIsApproximate());
                }
                BLpostalcode blpostalcode = new BLpostalcode(this);
                blpostalcode.insertcheckPostalcode(postalcode);
                //log.finer("Postal Code check: " + postalcode.getPrimaryKey().getKeystring());

                Locality locality = null;
                if(complocality==null) {
                    String localityname = al3.getPrimaryKey().getAl3code();
                    if(compstreetaddress!=null && compstreetaddress.getLocality()!=null) {
                        localityname = compstreetaddress.getLocality().getLongname();
                    } else if(comproute!=null && comproute.getLocality()!=null) {
                        localityname = comproute.getLocality().getLongname();
                    }
                    locality = new Locality(
                            postalcode.getPrimaryKey().getCountrycode(),
                            postalcode.getPrimaryKey().getPostalcode(),
                            localityname);
                } else {
                    locality = new Locality(
                            postalcode.getPrimaryKey().getCountrycode(),
                            postalcode.getPrimaryKey().getPostalcode(),
                            complocality.getLocality().getLongname());
                    locality.setLocation(complocality.getLocation().extractpiPoint());
                    bounds = new piPolyline(locality.getLocation().getSrid());
                    bounds.addPoint(complocality.getBounds().extractpiPointNE());
                    bounds.addPoint(complocality.getBounds().extractpiPointSW());
                    locality.setBounds(bounds);
                    viewport = new piPolyline(locality.getLocation().getSrid());
                    viewport.addPoint(complocality.getViewport().extractpiPointNE());
                    viewport.addPoint(complocality.getViewport().extractpiPointSW());
                    locality.setViewport(viewport);
                    locality.setApproximate(complocality.getIsApproximate());
                    locality.setHassublocality(compsublocality!=null);
                }
                BLlocality bllocality = new BLlocality(this);
                bllocality.insertcheckLocality(locality);
                //log.finer("Locality check: " + locality.getPrimaryKey().getKeystring());

                Sublocality sublocality = null;
                if(compsublocality==null) {
                    String sublocalityname = locality.getPrimaryKey().getLocality();
                    if(compstreetaddress!=null && compstreetaddress.getSublocality()!=null) {
                        sublocalityname = compstreetaddress.getSublocality().getLongname();
                    } else if(comproute!=null && comproute.getSublocality()!=null) {
                        sublocalityname = comproute.getSublocality().getLongname();
                    }
                    sublocality = new Sublocality(
                            locality.getPrimaryKey().getCountrycode(),
                            locality.getPrimaryKey().getPostalcode(),
                            locality.getPrimaryKey().getLocality(),
                            sublocalityname);
                } else {
                    sublocality = new Sublocality(
                            locality.getPrimaryKey().getCountrycode(),
                            locality.getPrimaryKey().getPostalcode(),
                            locality.getPrimaryKey().getLocality(),
                            compsublocality.getSublocality().getLongname());
                    sublocality.setLocation(compsublocality.getLocation().extractpiPoint());
                    bounds = new piPolyline(sublocality.getLocation().getSrid());
                    bounds.addPoint(compsublocality.getBounds().extractpiPointNE());
                    bounds.addPoint(compsublocality.getBounds().extractpiPointSW());
                    sublocality.setBounds(bounds);
                    viewport = new piPolyline(sublocality.getLocation().getSrid());
                    viewport.addPoint(compsublocality.getViewport().extractpiPointNE());
                    viewport.addPoint(compsublocality.getViewport().extractpiPointSW());
                    sublocality.setViewport(viewport);
                    sublocality.setApproximate(compsublocality.getIsApproximate());
                }
                BLsublocality blsublocality = new BLsublocality(this);
                blsublocality.insertcheckSublocality(sublocality);
                //log.finer("Sublocality check: " + sublocality.getPrimaryKey().getKeystring());

                Route route = new Route(new RoutePK());
                route.getPrimaryKey().setSublocalityPK(sublocality.getPrimaryKey());
                if(compstreetaddress!=null) {
                    route.getPrimaryKey().setRoutecode(compstreetaddress.getRoute().getShortname());
                    route.setName(compstreetaddress.getRoute().getLongname());
        //            photo.setFormattedaddress(compstreetaddress.getFormatted());
                } else if(comproute!=null) {
                    route.getPrimaryKey().setRoutecode(comproute.getRoute().getShortname());
                    route.setName(comproute.getRoute().getLongname());
                    route.setLocation(comproute.getLocation().extractpiPoint());
                    bounds = new piPolyline(route.getLocation().getSrid());
                    bounds.addPoint(comproute.getBounds().extractpiPointNE());
                    bounds.addPoint(comproute.getBounds().extractpiPointSW());
                    route.setBounds(bounds);
                    viewport = new piPolyline(route.getLocation().getSrid());
                    viewport.addPoint(comproute.getViewport().extractpiPointNE());
                    viewport.addPoint(comproute.getViewport().extractpiPointSW());
                    route.setViewport(viewport);
                    route.setApproximate(comproute.getIsApproximate());
        //            photo.setFormattedaddress(comproute.getFormatted());
                } else {
                    route.getPrimaryKey().setRoutecode(sublocality.getPrimaryKey().getSublocality());
                }
                BLroute blroute = new BLroute(this);
                blroute.insertcheckRoute(route);
                //log.finer("Route check: " + route.getPrimaryKey().getKeystring());

                photo.setRoutePK(route.getPrimaryKey());
                if(compstreetaddress!=null) {
                    photo.setStreetnumber(compstreetaddress.getStreetnumber().getShortname());
                }
            } else {
                photo.setReversegeocode(null);
                datalog.append("\r\n").append(geocode.getStatus());
                log.warning(datalog.toString());
                throw new DataException(geocode.getStatus());
            }
        }
        catch(NullPointerException e) {
            datalog.append("\r\n").append(photo.getReversegeocode());
            log.warning(datalog.toString());
            throw new DataException(datalog.toString());
        }
    }
}
