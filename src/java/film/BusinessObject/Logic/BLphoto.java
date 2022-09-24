/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BusinessLogic;
import static BusinessObject.BusinessLogic.FILEROOT;
import BusinessObject.Filewriter;
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
import db.SQLTqueue;
import db.SQLparameters;
import db.SQLreader;
import db.TableBusinessrules;
import file.Filereader;
import film.conversion.entity.EMphoto;
import film.logicview.Viewdescriptions;
import java.io.FileNotFoundException;
import static java.lang.StrictMath.log;

public class BLphoto extends Bphoto {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public final static String THUMBNAILPATH = "thumbnail" + File.separator;
    public final static String SMALLPATH = "small" + File.separator;
    public final static String CROPPEDPATH = "cropped" + File.separator;
    public final static String FILEEXTENTION = "jpg";

    public final static int SMALL_WIDTH = 800;
    public final static int SMALL_HEIGHT = 600;
    public final static int THUMBNAIL_WIDTH = 200;
    public final static int THUMBNAIL_HEIGHT = 200;

    private Object[][] publiconly = { { "public", true } };
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
    private Filereader filereader = new Filereader();
    private Filewriter filewriter = new Filewriter();
    private PhotoImagefile photoimagefile = new PhotoImagefile();
    private BLphototags blphototags;
    
    public BLphoto(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
        blphototags = new BLphototags(sqlreader);
    }

    public BLphoto(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
        this.setAuthenticated(businessrules.isAuthenticated());
    }

    public boolean hasAccess(Userprofile userprofile, IPhotoPK photoPK) throws DBException {
        boolean hasaccess = userprofile!=null && userprofile.privateaccess();
        if(!hasaccess) {
            Photo photo = getPhoto(photoPK);
            hasaccess = photo.getPublic();
        }
        return hasaccess;
    }

    @Override
    public long count() throws DBException {
        String searchsql = "select count(*) as count from photo where public";
        return this.count(searchsql, null);
    }

    public long count(boolean loggedin) throws DBException {
        if(loggedin) {
            String searchsql = "select count(*) as count from photo";
            return this.count(searchsql, null);
        } else {
            return this.count();
        }
    }

    public ArrayList<Photo> getPhotos() throws DBException {
        return getPhotos(this.isAuthenticated());
    }
    
    public ArrayList<Photo> getPhotos(boolean privateaccess) throws DBException {
        if(privateaccess)
            return this.getEntities(EMphoto.SQLSelect4photo_sorted);
        else {
            SQLparameters parameters = new SQLparameters(publiconly);
            return this.getEntities(EMphoto.SQLSelectAll4Public, parameters);
        }
    }

    public Photo getPhoto(Userprofile userprofile, IPhotoPK photoPK) throws DBException {
        Photo returnphoto = (Photo)getPhoto(photoPK);
        if(!userprofile.privateaccess() && !returnphoto.getPublic()) returnphoto = null;
        return returnphoto;
    }

    public Photo getPhoto(boolean hasprivateaccess, IPhotoPK photoPK) throws DBException {
        Photo returnphoto = getPhoto(photoPK);
        if(!(hasprivateaccess || returnphoto.getPublic())) returnphoto = null;
        return returnphoto;
    }
    
    public ArrayList<Photo> search(IPhotosearch search) throws DBException {
        if(search.used()) {
            String sqlorderby = EMphoto.OrderByDateTime;
            search.build("");
            String searchsql = "select distinct photo.* from photo" + search.getJoin() + " where (" + search.getSql() + ")";
            if(!this.isAuthenticated()) searchsql += " and public";
            searchsql += sqlorderby;
            ArrayList photos = this.getEntities(searchsql, search.getParameters());
            return photos;
        } else {
            return new ArrayList();
        }
    }

    public void addThumbnailsBase64(ArrayList<Photo> photos) throws DBException, CustomException {
        for(Photo photo: photos)
            if(photo.getPublic() || this.isAuthenticated())
                photoimagefile.addThumbnailImageBase64(photo);
    }

    public long searchcount(IPhotosearch search) throws DBException {
        long count = 0;
        if(search.used()) {
            if(!this.isAuthenticated()) search.publicf_(true);
            count = super.searchcount(search);
        }
        return count;
    }
    
    public ArrayList<Photo> getPhoto4Location(boolean hasprivateaccess, piPoint location) throws DBException {
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
    
    public ArrayList<Photo> getPhoto4Locations(ArrayList<piPoint> locations) throws DBException {
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
            if(locationsI.hasNext())
                sqlwhere.append(" or ");
            l++;
        }
        StringBuilder sql = new StringBuilder(EMphoto.SQLSelectAll).append(" where ");
        if(this.isAuthenticated())
            sql.append(sqlwhere);
        else {
            parameters.add(publiconly);
            sql.append(EMphoto.SQLWherePublic).append(" and (").append(sqlwhere).append(")");
        }
        sql.append(EMphoto.OrderByDateTime);
        return this.getEntities(sql.toString(), parameters);
    }
    
    public ArrayList<Photo> getPhoto4Date(boolean hasprivateaccess, Date date) throws DBException {
        ArrayList photos;
        Object[][] parameter = { { "photodate", date } };
        SQLparameters parameters = new SQLparameters(parameter);
        if(hasprivateaccess)
            photos = this.getEntities(EMphoto.SQLSelect4date, parameters);
        else {
            parameters.add(publiconly);
            photos = this.getEntities(EMphoto.SQLSelect4publicdate, parameters);
        }
        return photos;
    }
    
    public ArrayList<Photo> getPhotos4photo_film(boolean hasprivateaccess, IFilmPK filmPK, boolean loadthumbnails) throws DBException {
        SQLparameters parameters = filmPK.getSQLprimarykey();
        ArrayList photos;
        if(hasprivateaccess)
            photos = this.getEntities(EMphoto.SQLSelect4photo_film_sorted, parameters);
        else {
            parameters.add(publiconly);
            photos = this.getEntities(EMphoto.SQLSelect4photo_filmpublic_sorted, parameters);
        }
        if(loadthumbnails)
            return loadThumbnailImages(photos);
        else
            return photos;
    }

    public ArrayList<Photo> getPhotos4photo_film_edit(Userprofile userprofile, IFilmPK filmPK, boolean loadthumbnails) throws CustomException {
        ArrayList photos = new ArrayList();
        if(userprofile!=null && userprofile.isEditor())
            photos = getPhotos4photo_film(userprofile.privateaccess(), filmPK, loadthumbnails);
        return photos;
    }

    public ArrayList<Photo> getPhotos4photo_film_imagebackup(IFilmPK filmPK) throws DBException {
        return this.getEntities(EMphoto.SQLSelect4photo_film_imagebackup, filmPK.getSQLprimarykey());
    }

    public ArrayList<Photo> getPhotos4photo_film_backup(IFilmPK filmPK) throws DBException {
        return this.getEntities(EMphoto.SQLSelect4photo_film_backup, filmPK.getSQLprimarykey());
    }

    public File getThumbnail(IPhotoPK photoPK) throws DBException {
        Photo photo = this.getPhoto(photoPK);
        if(isAuthenticated() || photo.getPublic())
            return photoimagefile.getThumbnailFile(photoPK);
        else
            return null;
    }

    public File getSmall(IPhotoPK photoPK) throws DBException {
        Photo photo = this.getPhoto(photoPK);
        if(isAuthenticated() || photo.getPublic())
            return photoimagefile.getSmallFile(photoPK);
        else
            return null;
    }

    public ArrayList<String> getDescriptions(String searchtext) throws DBException {
        String search = ":*:" + searchtext + ":*:";
        Object[][] parameter = { { "description", search } };
        SQLparameters parameters = new SQLparameters(parameter);
        String sql = EMphoto.SQLSelectDescriptions;
        if(!this.isAuthenticated()) {
            sql += " and " + EMphoto.SQLWherePublic;
            parameters.add(publiconly);
        }
        sql += EMphoto.OrderByDescription;
        BLviewdescriptions blviewdescriptions = new BLviewdescriptions(tableio.getSQLreader());
        blviewdescriptions.setAuthenticated(true);
        ArrayList<Viewdescriptions> descriptions = blviewdescriptions.getViewio().getEntities(sql, parameters);
        ArrayList<String> descriptionsarray = new ArrayList<String>();
        for(Viewdescriptions descriptionview: descriptions)
            descriptionsarray.add(descriptionview.getDescription());
        return descriptionsarray;
    }
    
    public ArrayList<Photo> getPhotoDataErrors() throws DBException {
        return this.getEntities(EMphoto.SQLSelectDataError);
    }

    public void backupImages(
            SQLTqueue transactionqueue, 
            IFilm film, 
            IPhoto photo, 
            String backupdir) 
            throws DBException, DataException, IOException, FileNotFoundException {
        String rootfilename = null;
        String croppedfilename = null;
        String croppedfilename_format = null;
        String croppedfilename_composition = null;

        String filmtype = film.getFilmtypePK().getType();
        IPhotoPK photoPK = photo.getPrimaryKey();
        Filedata rootimage = photoimagefile.getRootfiledata(photoPK);
        rootfilename = rootimage.getFilename();
        filewriter.saveFileAbsolutepath(rootimage, backupdir + BLfilm.getRootImagePath(photoPK.getFilmPK()).toString());
        croppedfilename = backupImage_cropped(backupdir, filmtype, photo, rootimage);
        backupImage_small(backupdir, filmtype, rootimage, photo);
        backupImage_thumbnail(backupdir, filmtype, rootimage, photo);
        if(!photo.getFormat().equals("H"))
            croppedfilename_format = photoimagefile.backupImage_formatH(photo, backupdir);
        if(photo.getComposition())
            croppedfilename_composition = backupImage_composition(photoPK, backupdir);
        photo.setImagebackup(false);
        updatePhoto(transactionqueue, photo);
        photoimagefile.backupImages_deletebigfiles(photoPK, rootfilename, croppedfilename, croppedfilename_format, croppedfilename_composition);
    }

    public String backupImage_cropped(String backupdir, String filmtype, IPhoto photo, Filedata rootimage) throws IOException {
        IPhotoPK photoPK = photo.getPrimaryKey();
        String newcroppedfilename = null;
        try {
            newcroppedfilename = photoimagefile.copy_cropped_to_backupdir(photoPK, backupdir);
        }
        catch(IOException e) {
            if(filmtype_needs_resizedimage(filmtype))
                photoimagefile.copy_cropped_and_backup(photo, rootimage, backupdir);
            else
                throw e;
        }
        return newcroppedfilename;
    }

    private void backupImage_small(String backupdir, String filmtype, Filedata rootimage, IPhoto photo) throws IOException {
        IPhotoPK photoPK = photo.getPrimaryKey();
        try {
            photoimagefile.copy_small_to_backupdir(photoPK, backupdir);
        }
        catch(IOException e) {
            if(filmtype_needs_resizedimage(filmtype))
                photoimagefile.copy_root_resizetosmall_and_backup(rootimage, photo, backupdir);
            else
                throw e;
        }
    }

    private void backupImage_thumbnail(String backupdir, String filmtype, Filedata rootimage, IPhoto photo) throws IOException {
        IPhotoPK photoPK = photo.getPrimaryKey();
        try {
            photoimagefile.copy_thumbnail_to_backupdir(photoPK, backupdir);
        }
        catch(IOException e) {
            if(filmtype_needs_resizedimage(filmtype))
                photoimagefile.copy_root_resizetothumbnail_and_backup(rootimage, photo, backupdir);
            else
                throw e;
        }
    }

    private String backupImage_composition(IPhotoPK photoPK, String backupdir) {
        Filedata image;
        String croppedfilename_composition = null;
        try {
            croppedfilename_composition = photoimagefile.backupImage_composition_cropped(photoPK, backupdir);
        } catch(IOException e) {}
        try {
            photoimagefile.backupImage_composition_small(photoPK, backupdir);
        } catch(IOException e) {}
        try {
            photoimagefile.backupImage_composition_thumbnail(photoPK, backupdir);
        } catch(IOException e) {}
        return croppedfilename_composition;
    }

    private static boolean filmtype_needs_resizedimage(String filmtype) {
        return !filmtype.equals("APS") && !filmtype.equals("CON") && !filmtype.equals("DIA");
    }

    private ArrayList<Photo> loadThumbnailImages(ArrayList<Photo> photos) {
        for(Photo photo: photos) {
            try {
                photo.setThumbnailimage(photoimagefile.getThumbnailfiledata(photo.getPrimaryKey()));
            }
            catch(IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return photos;
    }

    public void checkwritepermissions() throws DataException {
        File checkpermissionsfile = new File(BusinessLogic.FILEROOT + BLfilm.PHOTOSUBROOT);
        if(!checkpermissionsfile.canWrite())
            throw new DataException("No write permission on server disk");
    }
    
    public String uploadPhotoImage_Root(SQLTqueue transactionqueue, Filedata root) throws IOException, DBException, DataException {
        checkwritepermissions();
        String filename = root.getFilename();
        filename = filename.substring(0, filename.indexOf("."));
        String filmid = filename.substring(0, 3) + filename.substring(4, 7);
        int photoid = Integer.valueOf(filename.substring(8, 10));
        Photo photo = new Photo(filmid, photoid);
        if(!this.getPhotoExists(photo.getPrimaryKey())) {
            photo.setPublic(false);
            photo.setFormat("H");
            insertPhoto(transactionqueue, photo);
        }
        return photoimagefile.writeRootimage(photo, filename, root);
    }

    public String uploadPhotoImage_CONRoot(SQLTqueue transactionqueue, Filedata root, HashMap photoproperties) throws IOException, DBException, DataException {
        checkwritepermissions();
        String filmid = (String)photoproperties.get("filmid");
        int photoid = 0;
        Photo lastphoto = getLastPhotoinGroup(filmid);
        if(lastphoto!=null)
            photoid = lastphoto.getPrimaryKey().getId()+1;
        Photo photo = new Photo(filmid, photoid);
        String filename = photo.getFileName(photo.getPrimaryKey());
        if(!this.getPhotoExists(photo.getPrimaryKey())) {
            photo.setCreatorPK((CreatorPK)photoproperties.get("creatorpk"));
            photo.setPublic(false);
            photo.setFormat("H");
            insertPhoto(transactionqueue, photo);
        }
        String rootpath = BLfilm.getRootImagePath(photo.getPrimaryKey().getFilmPK()).toString();
        String newfilename = filename + "." + FILEEXTENTION;
        filewriter.saveFileAs(root, rootpath, newfilename);
        return photoimagefile.writeRootimage(photo, filename, root);
    }

    public void uploadPhotoImage_CONCropped(SQLTqueue transactionqueue, Filedata cropped, HashMap photoproperties) throws IOException, DBException, DataException {
        checkwritepermissions();
        String filmid = (String)photoproperties.get("filmid");
        String usedfilename = (String)photoproperties.get("usedfilename");
        String photonumber = usedfilename.substring(8, 10);
        int photoid = Integer.parseInt(photonumber);
        Photo photo = new Photo(filmid, photoid);
        String filename = photo.getFileName(photo.getPrimaryKey());
        if(!this.getPhotoExists(photo.getPrimaryKey())) {
            photo.setPublic(false);
            photo.setFormat("H");
            insertPhoto(transactionqueue, photo);
        }
        String newfilename = photoimagefile.writeCroppedimage(photo, filename, cropped);
        photoimagefile.resizeImage_to_small_thumbnail(cropped, photo, newfilename);
    }

    public String uploadPhotoImage(SQLTqueue transactionqueue, Filedata photofile, HashMap photoproperties) throws IOException, DBException, DataException {
        checkwritepermissions();
        blphototags.setAuthenticated(true);
        String photofilename = null;
        String uploadtype = (String)photoproperties.get("uploadtype");
        String filmgroupid = (String)photoproperties.get("filmgroupid");
        Graphicfile gf = photofile.getGraphicfile();

        Photo photo = uploadPhotoImage_initialize_group(transactionqueue, filmgroupid, uploadtype);
        addphotodata(photo, gf, photoproperties);
        if(!getPhotoExists(photo.getPrimaryKey()))
            photofilename = uploadPhotoImage_newphoto(transactionqueue, photo, photoproperties, photofile, gf);
        
        uploadPhotoImage_addphotoproperties(transactionqueue, photo, gf, photoproperties);

        return photofilename;
    }

    private String uploadPhotoImage_newphoto(
            SQLTqueue transactionqueue, 
            Photo photo, 
            HashMap photoproperties, 
            Filedata photofile, 
            Graphicfile gf) 
            throws DBException, IOException, DataException {
        String filename = photo.getFileName(photo.getPrimaryKey());
        insertPhoto(transactionqueue, photo);
        uploadPhotoImage_subjects(transactionqueue, photo, photoproperties);
        String newfilename = photoimagefile.writeRootimage(photo, filename, photofile);
        photoimagefile.write_rotatedimage(gf, photo, newfilename, photoproperties);
        photoimagefile.write_resizesmall(gf, photo, newfilename);
        photoimagefile.write_resizethumbnail(gf, photo, newfilename);
        return newfilename;
    }

    private Photo uploadPhotoImage_initialize_group(SQLTqueue transactionqueue, String filmgroupid, String uploadtype) throws DBException, NumberFormatException, DataException {
        Photo photo;
        Photo lastphoto = getLastPhotoinGroup(filmgroupid);
        Photo lastphotofortype = getLastPhotoinGroupAndType(filmgroupid, uploadtype);
        boolean invalidgroupid = lastphotofortype==null || (lastphotofortype!=null && lastphotofortype.getPrimaryKey().getId()==99);
        if(invalidgroupid)
            photo = uploadPhotoImage_create_group(transactionqueue, lastphotofortype, lastphoto, filmgroupid, uploadtype);
        else
            photo = new Photo(lastphotofortype.getPrimaryKey().getFilm(), lastphotofortype.getPrimaryKey().getId()+1);
        return photo;
    }

    private Photo uploadPhotoImage_create_group(
            SQLTqueue transactionqueue,
            Photo lastphotofortype, 
            Photo lastphoto, 
            String filmgroupid, 
            String uploadtype) throws DataException, NumberFormatException, DBException {
        Photo photo;
        boolean group_contains_no_photos = lastphotofortype==null && lastphoto==null;
        String groupid = group_contains_no_photos ? "000" : construct_groupid(lastphoto);
        Film film = new Film(filmgroupid + groupid);
        film.setPublic(false);
        film.setFilmtypePK(new FilmtypePK(uploadtype));
        BLfilm blfilm = new BLfilm(this);
        blfilm.setAuthenticated(true);
        blfilm.insertFilm(transactionqueue, film);
        photo = new Photo(filmgroupid + groupid, 0);
        return photo;
    }

    private String construct_groupid(Photo lastphoto) throws NumberFormatException {
        String filmid = lastphoto.getPrimaryKey().getFilm();
        String groupid = filmid.substring(3, 6);
        int groupnumber = Integer.parseInt(groupid) + 1;
        groupid = String.valueOf(groupnumber);
        while(groupid.length()<3) groupid = "0" + groupid;
        return groupid;
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

    public void addphotodata(
            Photo photo, 
            Graphicfile gf, 
            HashMap photoproperties) 
            throws IOException, DBException, DataException {
        String description = (String)photoproperties.get("description");
        CreatorPK creatorpk = (CreatorPK)photoproperties.get("creatorpk");
        Date photodate = null;
        Time phototime = null;
        Tag datetimetag = blphototags.findTag(gf.getMetadataTaglist(), Tag.DATETIMEORIGINAL);
        if(datetimetag!=null) {
            photodate = datetimetag.getDateValue();
            phototime = datetimetag.getTimeValue();
        }
        photo.setPublic(false);
        photo.setFormat("H");
        if(description!=null) photo.setDescription(description);
        photo.setCreatorPK(creatorpk);
        photo.setPhotodate(photodate);
        photo.setPhototime(phototime);        
    }
    
    public void uploadPhotoImage_addphotoproperties(
            SQLTqueue transactionqueue, 
            Photo photo, 
            Graphicfile gf, 
            HashMap photoproperties) 
            throws IOException, DBException, DataException {
        blphototags.insertGraphicfileMetatags(transactionqueue, gf, photo);
    }
    
    private void uploadPhotoImage_subjects(SQLTqueue transactionqueue, Photo photo, HashMap photoproperties) throws DataException, DBException {
        ArrayList subjects = (ArrayList)photoproperties.get("subjects");
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.setAuthenticated(true);
        blphototree7subject.linkPhoto_with_Subjects(transactionqueue, photo.getPrimaryKey(), subjects);
    }

    public void uploadPhotoImage_Cropped(SQLTqueue transactionqueue, Filedata cropped) throws DBException, DataException, IOException {
        checkwritepermissions();
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
        updatePhoto(transactionqueue, photo);
        
        String newfilename = photoimagefile.writeCroppedimage(photo, filename, cropped);
        Graphicfile gf = new Graphicfile(Photo.getImage(cropped));
        photoimagefile.write_resizesmall(gf, photo, newfilename);
        photoimagefile.write_resizethumbnail(gf, photo, newfilename);
    }

    public boolean updateCopyPrevGeolocation(SQLTqueue transactionqueue, IPhoto photo) throws DBException, DataException {
        boolean success = false;
        ArrayList<Photo> photos = getPhotos4photo_film(this.isAuthenticated(), photo.getPrimaryKey().getFilmPK(), false);
        int index = find_photo_position_in_array(photos, photo);
        int previousindex = find_previous_photo_with_valid_reversegeocode(index, photos);
        boolean valid_position_found = previousindex>-1;
        if(valid_position_found)
            copy_photo_locationdata(photo, photos.get(previousindex), transactionqueue);
        return valid_position_found;
    }

    private void copy_photo_locationdata(IPhoto updphoto, IPhoto prevphoto, SQLTqueue transactionqueue) throws DataException, DBException {
        updphoto.setLocation(prevphoto.getLocation());
        updphoto.setLocationradius(prevphoto.getLocationradius());
        updphoto.setReversegeocode(prevphoto.getReversegeocode());
        updphoto.setExactlocation(prevphoto.getExactlocation());
        updphoto.setFormattedaddress(prevphoto.getFormattedaddress());
        updphoto.setRoutePK(prevphoto.getRoutePK());
        updphoto.setStreetnumber(prevphoto.getStreetnumber());
        updatePhoto(transactionqueue, updphoto);
    }

    private int find_photo_position_in_array(ArrayList<Photo> photos, IPhoto photo) {
        int index = photos.size()-1;
        while(index>-1 && photos.get(index).getPrimaryKey().getId()>photo.getPrimaryKey().getId())
            index--;
        return index;
    }
    
    private int find_previous_photo_with_valid_reversegeocode(int index, ArrayList<Photo> photos) {
        int previousindex = index-1;
        while(previousindex>-1 && !photo_from_array_has_reversegeocode(photos, previousindex)) {
            previousindex--;
        }
        return previousindex;
    }

    private boolean photo_from_array_has_reversegeocode(ArrayList<Photo> photos, int index) {
        boolean has_reversegeocode = false;
        if(index>-1)
            if(photos.get(index).getReversegeocode()!=null)
                has_reversegeocode = photos.get(index).getReversegeocode().length()>0;
        return has_reversegeocode;
    }
    
    public boolean copyPhotoGeolocation(SQLTqueue transactionqueue, IPhoto photo, IPhotoPK source_photoPK) throws DBException, DataException {
        boolean success = false;
        Photo updphoto = this.getPhoto(photo.getPrimaryKey());
        Photo source = this.getPhoto(source_photoPK);
        boolean source_has_valid_locationdata = source!=null && source.getLocation()!=null && updphoto!=null;
        if(source_has_valid_locationdata)
            copy_photo_locationdata(updphoto, source, transactionqueue);
        return source_has_valid_locationdata;
    }
    
    public void updatePhoto(
            SQLTqueue transactionqueue, 
            String senderobject, 
            Userprofile userprofile, 
            IPhoto photo, 
            ArrayList subjects, 
            ArrayList tree7subjects) 
            throws DBException, DataException {
        boolean user_is_editor = getPhoto(userprofile, photo.getPrimaryKey())!=null;
        if(user_is_editor) {
            updatePhoto(transactionqueue, photo);
            BLphotosubjects blphotosubjects = new BLphotosubjects(this);
            blphotosubjects.setAuthenticated(true);
            blphotosubjects.linkPhoto_with_Subjects(transactionqueue, senderobject, photo.getPrimaryKey(), subjects);
            BLphototree7subject blphototree7subject = new BLphototree7subject(this);
            blphototree7subject.setAuthenticated(true);
            blphototree7subject.linkPhoto_with_Subjects(transactionqueue, photo.getPrimaryKey(), tree7subjects);
        }
    }

    public void updatePhoto(SQLTqueue transactionqueue, Userprofile userprofile, IPhoto photo, ArrayList tree7subjects) throws DBException, DataException {
        boolean user_is_editor = getPhoto(userprofile, photo.getPrimaryKey())!=null;
        if(user_is_editor) {
            updatePhoto(transactionqueue, photo);
            BLphototree7subject blphototree7subject = new BLphototree7subject(this);
            blphototree7subject.setAuthenticated(true);
            blphototree7subject.linkPhoto_with_Subjects(transactionqueue, photo.getPrimaryKey(), tree7subjects);
        }
    }
    
    public void setBackedup(SQLTqueue transactionqueue, IFilmPK filmpk) throws DBException {
        Object[][] parameter = { { "backup", false } };
        SQLparameters parameters = new SQLparameters(parameter);
        parameters.add(filmpk.getSQLprimarykey());
        addStatement(transactionqueue, EMphoto.SQLUpdateBackup4Film, parameters);
    }

    public ArrayList<Photo> search(Userprofile userprofile, Tablesearcher search, boolean loadthumbnails) throws DBException {
        ArrayList<Photo> photos = new ArrayList<>();
        boolean user_has_privateaccess = userprofile!=null && userprofile.privateaccess();
        if(user_has_privateaccess)
            photos = super.search(search);
        else {
            photos = search_publiconly((IPhotosearch)search);
        }
        if(photos.size()<=search.getMaxresults() && loadthumbnails)
            loadThumbnailImages(photos);
        return photos;
    }

    private ArrayList<Photo> search_publiconly(IPhotosearch photosearch) throws DBException {
        photosearch.publicf_(true);
        return super.search(photosearch);
    }    

}
