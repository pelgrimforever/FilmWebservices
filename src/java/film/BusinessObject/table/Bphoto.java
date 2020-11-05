/*
 * Bphoto.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONPhoto;
import film.data.ProjectConstants;
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
public abstract class Bphoto extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Photo as default Entity
     */
    public Bphoto() {
        super(new SQLMapper_pgsql(connectionpool, "Photo"), new Photo());
    }

    /**
     * Constructor, sets Photo as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphoto(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Photo());
    }

    /**
     * Map ResultSet Field values to Photo
     * @param dbresult: Database ResultSet
     */
    public Photo mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhotoPK photoPK = null;
        Photo photo;
        if(dbresult==null) {
            photo = new Photo(photoPK);
        } else {
            try {
                photoPK = new PhotoPK(dbresult.getString("film"), dbresult.getInt("id"));
                photo = new Photo(photoPK);
                photo.initRoutePK(new RoutePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"), dbresult.getString("routecode")));
                if(dbresult.wasNull()) photo.setRoutePK(null);                
                photo.initCreatorPK(new CreatorPK(dbresult.getString("creator")));
                if(dbresult.wasNull()) photo.setCreatorPK(null);                
                photo.initFormat(dbresult.getString("format"));
                photo.initDescription(dbresult.getString("description"));
                photo.initPhotodate(dbresult.getDate("photodate"));
                photo.initPhototime(dbresult.getString("phototime") == null ? null : Time.valueOf(dbresult.getString("phototime")));
                photo.initPublic(dbresult.getBoolean("public"));
                photo.initComposition(dbresult.getBoolean("composition"));
                photo.initRotation(dbresult.getFloat("rotation"));
                photo.initBackup(dbresult.getBoolean("backup"));
                photo.initImagebackup(dbresult.getBoolean("imagebackup"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    photo.initLocation(c_location.abstractclone());
                }
                photo.initExactlocation(dbresult.getBoolean("exactlocation"));
                photo.initLocationradius(dbresult.getDouble("locationradius"));
                photo.initReversegeocode(dbresult.getString("reversegeocode"));
                photo.initStreetnumber(dbresult.getString("streetnumber"));
                photo.initFormattedaddress(dbresult.getString("formattedaddress"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, photo);
        return photo;
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
    public ArrayList getPhotos() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photo.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Photo for primary key
     * @param photoPK: Photo primary key
     * @return Photo object
     * @throws DBException
     */
    public Photo getPhoto(IPhotoPK photoPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Photo)super.getEntity((PhotoPK)photoPK);
        } else return null;
    }

    public ArrayList searchphotos(IPhotosearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchphotos(IPhotosearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search photo in database for photoPK:
     * @param photoPK: Photo Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhotoExists(IPhotoPK photoPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((PhotoPK)photoPK);
        } else return false;
    }

    /**
     * try to insert Photo in database
     * @param film: Photo object
     * @throws DBException
     */
    public void insertPhoto(IPhoto photo) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(photo);
        }
    }

    /**
     * check if PhotoPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Photo object
     * @throws DBException
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
     * @param film: Photo object
     * @throws DBException
     */
    public void updatePhoto(IPhoto photo) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(photo);
        }
    }

    /**
     * try to delete Photo in database
     * @param film: Photo object
     * @throws DBException
     */
    public void deletePhoto(IPhoto photo) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeletePhoto(photo.getOwnerobject(), photo.getPrimaryKey());
            super.deleteEntity(photo);
        }
    }

    /**
     * check data rules in Photo, throw DataException with customized message if rules do not apply
     * @param film: Photo object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhoto photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photo.Film - Film.Id
        //Primary key
	//if(photo.getRoutePK()!=null && photo.getRoutePK().getCountrycode()!=null && photo.getRoutePK().getCountrycode().length()>IPhoto.SIZE_COUNTRYCODE) {
        if(photo.getRoutePK()!=null && photo.getRoutePK().getCountrycode()!=null && photo.getRoutePK().getCountrycode().length()>IPhoto.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_COUNTRYCODE + "\n");
        }
	//if(photo.getRoutePK()!=null && photo.getRoutePK().getPostalcode()!=null && photo.getRoutePK().getPostalcode().length()>IPhoto.SIZE_POSTALCODE) {
        if(photo.getRoutePK()!=null && photo.getRoutePK().getPostalcode()!=null && photo.getRoutePK().getPostalcode().length()>IPhoto.SIZE_POSTALCODE) {
            message.append("Postalcode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_POSTALCODE + "\n");
        }
	//if(photo.getRoutePK()!=null && photo.getRoutePK().getLocality()!=null && photo.getRoutePK().getLocality().length()>IPhoto.SIZE_LOCALITY) {
        if(photo.getRoutePK()!=null && photo.getRoutePK().getLocality()!=null && photo.getRoutePK().getLocality().length()>IPhoto.SIZE_LOCALITY) {
            message.append("Locality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_LOCALITY + "\n");
        }
	//if(photo.getRoutePK()!=null && photo.getRoutePK().getSublocality()!=null && photo.getRoutePK().getSublocality().length()>IPhoto.SIZE_SUBLOCALITY) {
        if(photo.getRoutePK()!=null && photo.getRoutePK().getSublocality()!=null && photo.getRoutePK().getSublocality().length()>IPhoto.SIZE_SUBLOCALITY) {
            message.append("Sublocality is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_SUBLOCALITY + "\n");
        }
	//if(photo.getRoutePK()!=null && photo.getRoutePK().getRoutecode()!=null && photo.getRoutePK().getRoutecode().length()>IPhoto.SIZE_ROUTECODE) {
        if(photo.getRoutePK()!=null && photo.getRoutePK().getRoutecode()!=null && photo.getRoutePK().getRoutecode().length()>IPhoto.SIZE_ROUTECODE) {
            message.append("Routecode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_ROUTECODE + "\n");
        }

	//if(photo.getCreatorPK()!=null && photo.getCreatorPK().getCreatorid()!=null && photo.getCreatorPK().getCreatorid().length()>IPhoto.SIZE_CREATOR) {
        if(photo.getCreatorPK()!=null && photo.getCreatorPK().getCreatorid()!=null && photo.getCreatorPK().getCreatorid().length()>IPhoto.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_CREATOR + "\n");
        }

        if(photo.getFormat()!=null && photo.getFormat().length()>IPhoto.SIZE_FORMAT) {
            message.append("Format is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_FORMAT + "\n");
        }
        if(photo.getFormat()==null) {
            message.append("Format mag niet leeg zijn.\n");
        }
        if(photo.getDescription()!=null && photo.getDescription().length()>IPhoto.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_DESCRIPTION + "\n");
        }
        if(photo.getReversegeocode()!=null && photo.getReversegeocode().length()>IPhoto.SIZE_REVERSEGEOCODE) {
            message.append("Reversegeocode is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_REVERSEGEOCODE + "\n");
        }
        if(photo.getStreetnumber()!=null && photo.getStreetnumber().length()>IPhoto.SIZE_STREETNUMBER) {
            message.append("Streetnumber is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_STREETNUMBER + "\n");
        }
        if(photo.getFormattedaddress()!=null && photo.getFormattedaddress().length()>IPhoto.SIZE_FORMATTEDADDRESS) {
            message.append("Formattedaddress is langer dan toegestaan. Max aantal karakters: " + IPhoto.SIZE_FORMATTEDADDRESS + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where photoPK is used in a primary key
     * @param photoPK: Photo primary key
     */
    public void cascadedeletePhoto(String senderobject, IPhotoPK photoPK) {
        BLphototree7subject blphototree7subject = new BLphototree7subject(this);
        blphototree7subject.delete4photo(senderobject, photoPK);
        BLart_photo blart_photo = new BLart_photo(this);
        blart_photo.delete4photo(senderobject, photoPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.delete4photo(senderobject, photoPK);
        BLphototags blphototags = new BLphototags(this);
        blphototags.delete4photo(senderobject, photoPK);
    }

    /**
     * @param routePK: foreign key for Route
     * @delete all Photo Entity objects for Route in database
     * @throws film.general.exception.CustomException
     */
    public void delete4route(String senderobject, IRoutePK routePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Photo.SQLDelete4route, routePK.getKeyFields());
        }
    }

    /**
     * @param routePK: foreign key for Route
     * @return all Photo Entity objects for Route
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhotos4route(IRoutePK routePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photo.SQLSelect4route, routePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param creatorPK: foreign key for Creator
     * @delete all Photo Entity objects for Creator in database
     * @throws film.general.exception.CustomException
     */
    public void delete4creator(String senderobject, ICreatorPK creatorPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Photo.SQLDelete4creator, creatorPK.getKeyFields());
        }
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @return all Photo Entity objects for Creator
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhotos4creator(ICreatorPK creatorPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photo.SQLSelect4creator, creatorPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param filmPK: foreign key for Film
     * @delete all Photo Entity objects for Film in database
     * @throws film.general.exception.CustomException
     */
    public void delete4film(String senderobject, IFilmPK filmPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Photo.SQLDelete4film, filmPK.getKeyFields());
        }
    }

    /**
     * @param filmPK: foreign key for Film
     * @return all Photo Entity objects for Film
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhotos4film(IFilmPK filmPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Photo.SQLSelect4film, filmPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param phototree7subjectPK: parent Phototree7subject for child object Photo Entity
     * @return child Photo Entity object
     * @throws film.general.exception.CustomException
     */
    public IPhoto getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            PhotoPK photoPK = new PhotoPK(phototree7subjectPK.getFilm(), phototree7subjectPK.getId());
            return this.getPhoto(photoPK);
        } else return null;
    }

    /**
     * @param art_photoPK: parent Art_photo for child object Photo Entity
     * @return child Photo Entity object
     * @throws film.general.exception.CustomException
     */
    public IPhoto getArt_photo(IArt_photoPK art_photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            PhotoPK photoPK = new PhotoPK(art_photoPK.getFilm(), art_photoPK.getPhoto());
            return this.getPhoto(photoPK);
        } else return null;
    }

    /**
     * @param photosubjectsPK: parent Photosubjects for child object Photo Entity
     * @return child Photo Entity object
     * @throws film.general.exception.CustomException
     */
    public IPhoto getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            PhotoPK photoPK = new PhotoPK(photosubjectsPK.getFilm(), photosubjectsPK.getId());
            return this.getPhoto(photoPK);
        } else return null;
    }

    /**
     * @param phototagsPK: parent Phototags for child object Photo Entity
     * @return child Photo Entity object
     * @throws film.general.exception.CustomException
     */
    public IPhoto getPhototags(IPhototagsPK phototagsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            PhotoPK photoPK = new PhotoPK(phototagsPK.getFilm(), phototagsPK.getId());
            return this.getPhoto(photoPK);
        } else return null;
    }


    /**
     * get all Photo objects for sqlparameters
     * @return ArrayList of Photo objects
     * @throws DBException
     */
    public ArrayList getPhotos(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Photo.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Photo objects for sqlparameters
     * @throws DBException
     */
    public void delPhoto(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Photo.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
