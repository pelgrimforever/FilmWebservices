/*
 * Bphoto.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONPhoto;
import film.conversion.entity.EMphoto;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhotosearch;
import film.logicentity.Photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bphoto
 *
 * Superclass for manipulating data- and database objects
 * for Entity Photo and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphoto extends BLtable {

    /**
     * Constructor, sets Photo as default Entity
     */
    public Bphoto() {
        super(new Photo(), new EMphoto());
    }

    /**
     * Constructor, sets Photo as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphoto(BLtable transactionobject) {
        super(transactionobject, new Photo(), new EMphoto());
    }

    /**
     * create new empty Photo object
     * @return empty IPhoto
     */
    public IPhoto newPhoto() {
    	return new Photo();
    }
    
    /**
     * create new empty Photo object
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @return IPhoto with primary key
     */
    public IPhoto newPhoto(java.lang.String film, int id) {
        return new Photo(film, id);
    }

    /**
     * create new empty Photo object with given primary key
     * @param photoPK: primary key for Photo
     * @return IPhoto with primary key
     */
    public IPhoto newPhoto(IPhotoPK photoPK) {
        return new Photo((PhotoPK)photoPK);
    }

    /**
     * create new empty primary key
     * @return empty PhotoPK
     */
    public IPhotoPK newPhotoPK() {
        return new PhotoPK();
    }

    /**
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @return new IPhotoPK
     */
    public IPhotoPK newPhotoPK(java.lang.String film, int id) {
        return new PhotoPK(film, id);
    }

    /**
     * get all Photo objects from database
     * @return ArrayList of Photo objects
     * @throws DBException
     */
    public ArrayList<Photo> getPhotos() throws DBException {
        return (ArrayList<Photo>)super.getEntities(EMphoto.SQLSelectAll);
    }

    /**
     * search Photo for primary key
     * @param photoPK: Photo primary key
     * @return Photo object
     * @throws DBException
     */
    public Photo getPhoto(IPhotoPK photoPK) throws DBException {
        return (Photo)super.getEntity((PhotoPK)photoPK);
    }

    /**
     * search photo with IPhotosearch parameters
     * @param search IPhotosearch
     * @return ArrayList of Photo
     * @throws DBException 
     */
    public ArrayList<Photo> searchphotos(IPhotosearch search) throws DBException {
        return (ArrayList<Photo>)this.search(search);
    }

    /**
     * search photo with IPhotosearch parameters, order by orderby sql clause
     * @param search IPhotosearch
     * @param orderby sql order by string
     * @return ArrayList of Photo
     * @throws DBException 
     */
    public ArrayList<Photo> searchphotos(IPhotosearch search, String orderby) throws DBException {
        return (ArrayList<Photo>)this.search(search, orderby);
    }

    /**
     * Search photo in database for photoPK:
     * @param photoPK: Photo Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhotoExists(IPhotoPK photoPK) throws DBException {
        return super.getEntityExists((PhotoPK)photoPK);
    }

    /**
     * try to insert Photo in database
     * @param photo Photo object
     * @throws DBException
     * @throws DataException
     */
    public void insertPhoto(IPhoto photo) throws DBException, DataException {
        super.insertEntity(photo);
    }

    /**
     * check if PhotoPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param photo Photo object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdatePhoto(IPhoto photo) throws DBException, DataException {
        if(this.getPhotoExists(photo.getPrimaryKey())) {
            super.updateEntity(photo);
        } else {
            super.insertEntity(photo);
        }
    }

    /**
     * try to update Photo in database
     * @param photo Photo object
     * @throws DBException
     * @throws DataException
     */
    public void updatePhoto(IPhoto photo) throws DBException, DataException {
        super.updateEntity(photo);
    }

    /**
     * try to delete Photo in database
     * @param photo Photo object
     * @throws DBException
     */
    public void deletePhoto(IPhoto photo) throws DBException {
        cascadedeletePhoto(photo.getPrimaryKey());
        super.deleteEntity(photo);
    }

    /**
     * check data rules in Photo, throw DataException with customized message if rules do not apply
     * @param photo Photo object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhoto photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photo.Film - Film.Id
        //Primary key
        if(photo.getRoutePK()!=null && photo.getRoutePK().getCountrycode()!=null && photo.getRoutePK().getCountrycode().length()>IPhoto.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_COUNTRYCODE + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getPostalcode()!=null && photo.getRoutePK().getPostalcode().length()>IPhoto.SIZE_POSTALCODE) {
            message.append("Postalcode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_POSTALCODE + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getLocality()!=null && photo.getRoutePK().getLocality().length()>IPhoto.SIZE_LOCALITY) {
            message.append("Locality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_LOCALITY + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getSublocality()!=null && photo.getRoutePK().getSublocality().length()>IPhoto.SIZE_SUBLOCALITY) {
            message.append("Sublocality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_SUBLOCALITY + "\n");
        }
        if(photo.getRoutePK()!=null && photo.getRoutePK().getRoutecode()!=null && photo.getRoutePK().getRoutecode().length()>IPhoto.SIZE_ROUTECODE) {
            message.append("Routecode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_ROUTECODE + "\n");
        }

        if(photo.getCreatorPK()!=null && photo.getCreatorPK().getCreatorid()!=null && photo.getCreatorPK().getCreatorid().length()>IPhoto.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_CREATOR + "\n");
        }

        if(photo.getFormat()!=null && photo.getFormat().length()>IPhoto.SIZE_FORMAT) {
            message.append("Format is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_FORMAT).append("\n");
        }
        if(photo.getFormat()==null) {
            message.append("Format mag niet leeg zijn.\n");
        }
        if(photo.getDescription()!=null && photo.getDescription().length()>IPhoto.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_DESCRIPTION).append("\n");
        }
        if(photo.getReversegeocode()!=null && photo.getReversegeocode().length()>IPhoto.SIZE_REVERSEGEOCODE) {
            message.append("Reversegeocode is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_REVERSEGEOCODE).append("\n");
        }
        if(photo.getStreetnumber()!=null && photo.getStreetnumber().length()>IPhoto.SIZE_STREETNUMBER) {
            message.append("Streetnumber is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_STREETNUMBER).append("\n");
        }
        if(photo.getFormattedaddress()!=null && photo.getFormattedaddress().length()>IPhoto.SIZE_FORMATTEDADDRESS) {
            message.append("Formattedaddress is langer dan toegestaan. Max aantal karakters: ").append(IPhoto.SIZE_FORMATTEDADDRESS).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where photoPK is used in a primary key
     * @param photoPK: Photo primary key
     */
    public void cascadedeletePhoto(IPhotoPK photoPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.delete4photo(photoPK);
        BLart_photo blart_photo = new BLart_photo(this);
        blart_photo.delete4photo(photoPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.delete4photo(photoPK);
        BLphototags blphototags = new BLphototags(this);
        blphototags.delete4photo(photoPK);
    }

    /**
     * @param routePK: foreign key for Route
     * @delete all Photo Entity objects for Route in database
     */
    public void delete4route(IRoutePK routePK) {
        super.addStatement(EMphoto.SQLDelete4route, routePK.getSQLprimarykey());
    }

    /**
     * @param routePK: foreign key for Route
     * @return all Photo Entity objects for Route
     * @throws CustomException
     */
    public ArrayList<Photo> getPhotos4route(IRoutePK routePK) throws CustomException {
        return super.getEntities(EMphoto.SQLSelect4route, routePK.getSQLprimarykey());
    }
    /**
     * @param creatorPK: foreign key for Creator
     * @delete all Photo Entity objects for Creator in database
     */
    public void delete4creator(ICreatorPK creatorPK) {
        super.addStatement(EMphoto.SQLDelete4creator, creatorPK.getSQLprimarykey());
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @return all Photo Entity objects for Creator
     * @throws CustomException
     */
    public ArrayList<Photo> getPhotos4creator(ICreatorPK creatorPK) throws CustomException {
        return super.getEntities(EMphoto.SQLSelect4creator, creatorPK.getSQLprimarykey());
    }
    /**
     * @param filmPK: foreign key for Film
     * @delete all Photo Entity objects for Film in database
     */
    public void delete4film(IFilmPK filmPK) {
        super.addStatement(EMphoto.SQLDelete4film, filmPK.getSQLprimarykey());
    }

    /**
     * @param filmPK: foreign key for Film
     * @return all Photo Entity objects for Film
     * @throws CustomException
     */
    public ArrayList<Photo> getPhotos4film(IFilmPK filmPK) throws CustomException {
        return super.getEntities(EMphoto.SQLSelect4film, filmPK.getSQLprimarykey());
    }
    /**
     * @param phototree7subjectPK: parent Phototree7subject for child object Photo Entity
     * @return child Photo Entity object
     * @throws CustomException
     */
    public Photo getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(phototree7subjectPK.getFilm(), phototree7subjectPK.getId());
        return this.getPhoto(photoPK);
    }

    /**
     * @param art_photoPK: parent Art_photo for child object Photo Entity
     * @return child Photo Entity object
     * @throws CustomException
     */
    public Photo getArt_photo(IArt_photoPK art_photoPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(art_photoPK.getFilm(), art_photoPK.getPhoto());
        return this.getPhoto(photoPK);
    }

    /**
     * @param photosubjectsPK: parent Photosubjects for child object Photo Entity
     * @return child Photo Entity object
     * @throws CustomException
     */
    public Photo getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(photosubjectsPK.getFilm(), photosubjectsPK.getId());
        return this.getPhoto(photoPK);
    }

    /**
     * @param phototagsPK: parent Phototags for child object Photo Entity
     * @return child Photo Entity object
     * @throws CustomException
     */
    public Photo getPhototags(IPhototagsPK phototagsPK) throws CustomException {
        PhotoPK photoPK = new PhotoPK(phototagsPK.getFilm(), phototagsPK.getId());
        return this.getPhoto(photoPK);
    }


    /**
     * get all Photo objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Photo objects
     * @throws DBException
     */
    public ArrayList<Photo> getPhotos(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphoto.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Photo>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Photo objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delPhoto(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Photo.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
