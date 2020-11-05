/*
 * Bart_photo.java
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
import film.conversion.json.JSONArt_photo;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArt_photosearch;
import film.logicentity.Art_photo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bart_photo
 *
 * Superclass for manipulating data- and database objects
 * for Entity Art_photo and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bart_photo extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Art_photo as default Entity
     */
    public Bart_photo() {
        super(new SQLMapper_pgsql(connectionpool, "Art_photo"), new Art_photo());
    }

    /**
     * Constructor, sets Art_photo as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_photo(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Art_photo());
    }

    /**
     * Map ResultSet Field values to Art_photo
     * @param dbresult: Database ResultSet
     */
    public Art_photo mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_photoPK art_photoPK = null;
        Art_photo art_photo;
        if(dbresult==null) {
            art_photo = new Art_photo(art_photoPK);
        } else {
            try {
                art_photoPK = new Art_photoPK(dbresult.getString("film"), dbresult.getInt("photo"));
                art_photo = new Art_photo(art_photoPK);
                art_photo.initArt_subgroupPK(new Art_subgroupPK(dbresult.getInt("photosubgroup")));
                if(dbresult.wasNull()) art_photo.setArt_subgroupPK(null);                
                art_photo.initArt_academyPK(new Art_academyPK(dbresult.getLong("academy")));
                if(dbresult.wasNull()) art_photo.setArt_academyPK(null);                
                art_photo.initArt_groupPK(new Art_groupPK(dbresult.getLong("photogroup")));
                if(dbresult.wasNull()) art_photo.setArt_groupPK(null);                
                art_photo.initSelection(dbresult.getBoolean("selection"));
                art_photo.initWidth(dbresult.getInt("width"));
                art_photo.initHeight(dbresult.getInt("height"));
                art_photo.initComment(dbresult.getString("comment"));
                art_photo.initSeqno(dbresult.getInt("seqno"));
                art_photo.initArchive(dbresult.getBoolean("archive"));
                art_photo.initSurround(dbresult.getBoolean("surround"));
                art_photo.initSurrounddir(dbresult.getString("surrounddir"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, art_photo);
        return art_photo;
    }

    /**
     * create new empty Art_photo object
     * @return empty IArt_photo
     */
    public IArt_photo newArt_photo() {
    	return new Art_photo();
    }
    
    /**
     * create new empty Art_photo object
     * create new primary key with given parameters
     * @return IArt_photo with primary key
     */
    public IArt_photo newArt_photo(java.lang.String film, int photo) {
        return new Art_photo(film, photo);
    }

    /**
     * create new empty Art_photo object with given primary key
     * @param art_photoPK: primary key for Art_photo
     * @return IArt_photo with primary key
     */
    public IArt_photo newArt_photo(IArt_photoPK art_photoPK) {
        return new Art_photo((Art_photoPK)art_photoPK);
    }

    /**
     * create new empty primary key
     * @return empty Art_photoPK
     */
    public IArt_photoPK newArt_photoPK() {
        return new Art_photoPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArt_photoPK
     */
    public IArt_photoPK newArt_photoPK(java.lang.String film, int photo) {
        return new Art_photoPK(film, photo);
    }

    /**
     * get all Art_photo objects from database
     * @return ArrayList of Art_photo objects
     * @throws DBException
     */
    public ArrayList getArt_photos() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_photo.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Art_photo for primary key
     * @param art_photoPK: Art_photo primary key
     * @return Art_photo object
     * @throws DBException
     */
    public Art_photo getArt_photo(IArt_photoPK art_photoPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Art_photo)super.getEntity((Art_photoPK)art_photoPK);
        } else return null;
    }

    public ArrayList searchart_photos(IArt_photosearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchart_photos(IArt_photosearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search art_photo in database for art_photoPK:
     * @param art_photoPK: Art_photo Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_photoExists(IArt_photoPK art_photoPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Art_photoPK)art_photoPK);
        } else return false;
    }

    /**
     * try to insert Art_photo in database
     * @param film: Art_photo object
     * @throws DBException
     */
    public void insertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(art_photo);
        }
    }

    /**
     * check if Art_photoPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Art_photo object
     * @throws DBException
     */
    public void insertupdateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        if(this.getArt_photoExists(art_photo.getPrimaryKey())) {
            super.updateEntity(art_photo);
        } else {
            super.insertEntity(art_photo);
        }
    }

    /**
     * try to update Art_photo in database
     * @param film: Art_photo object
     * @throws DBException
     */
    public void updateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(art_photo);
        }
    }

    /**
     * try to delete Art_photo in database
     * @param film: Art_photo object
     * @throws DBException
     */
    public void deleteArt_photo(IArt_photo art_photo) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArt_photo(art_photo.getOwnerobject(), art_photo.getPrimaryKey());
            super.deleteEntity(art_photo);
        }
    }

    /**
     * check data rules in Art_photo, throw DataException with customized message if rules do not apply
     * @param film: Art_photo object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_photo art_photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Art_photo.Film - Photo.Film
        //foreign key Art_photo.Photo - Photo.Id



        if(art_photo.getComment()!=null && art_photo.getComment().length()>IArt_photo.SIZE_COMMENT) {
            message.append("Comment is langer dan toegestaan. Max aantal karakters: " + IArt_photo.SIZE_COMMENT + "\n");
        }
        if(art_photo.getSurrounddir()!=null && art_photo.getSurrounddir().length()>IArt_photo.SIZE_SURROUNDDIR) {
            message.append("Surrounddir is langer dan toegestaan. Max aantal karakters: " + IArt_photo.SIZE_SURROUNDDIR + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where art_photoPK is used in a primary key
     * @param art_photoPK: Art_photo primary key
     */
    public void cascadedeleteArt_photo(String senderobject, IArt_photoPK art_photoPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Art_photo Entity objects for Photo in database
     * @throws film.general.exception.CustomException
     */
    public void delete4photo(String senderobject, IPhotoPK photoPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Art_photo.SQLDelete4photo, photoPK.getKeyFields());
        }
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Art_photo Entity objects for Photo
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArt_photos4photo(IPhotoPK photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_photo.SQLSelect4photo, photoPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param art_subgroupPK: foreign key for Art_subgroup
     * @delete all Art_photo Entity objects for Art_subgroup in database
     * @throws film.general.exception.CustomException
     */
    public void delete4art_subgroup(String senderobject, IArt_subgroupPK art_subgroupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Art_photo.SQLDelete4art_subgroup, art_subgroupPK.getKeyFields());
        }
    }

    /**
     * @param art_subgroupPK: foreign key for Art_subgroup
     * @return all Art_photo Entity objects for Art_subgroup
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArt_photos4art_subgroup(IArt_subgroupPK art_subgroupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_photo.SQLSelect4art_subgroup, art_subgroupPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param art_academyPK: foreign key for Art_academy
     * @delete all Art_photo Entity objects for Art_academy in database
     * @throws film.general.exception.CustomException
     */
    public void delete4art_academy(String senderobject, IArt_academyPK art_academyPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Art_photo.SQLDelete4art_academy, art_academyPK.getKeyFields());
        }
    }

    /**
     * @param art_academyPK: foreign key for Art_academy
     * @return all Art_photo Entity objects for Art_academy
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArt_photos4art_academy(IArt_academyPK art_academyPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_photo.SQLSelect4art_academy, art_academyPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param art_groupPK: foreign key for Art_group
     * @delete all Art_photo Entity objects for Art_group in database
     * @throws film.general.exception.CustomException
     */
    public void delete4art_group(String senderobject, IArt_groupPK art_groupPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Art_photo.SQLDelete4art_group, art_groupPK.getKeyFields());
        }
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @return all Art_photo Entity objects for Art_group
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArt_photos4art_group(IArt_groupPK art_groupPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Art_photo.SQLSelect4art_group, art_groupPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Art_photo objects for sqlparameters
     * @return ArrayList of Art_photo objects
     * @throws DBException
     */
    public ArrayList getArt_photos(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Art_photo.SQLSelect;
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
     * delete all Art_photo objects for sqlparameters
     * @throws DBException
     */
    public void delArt_photo(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Art_photo.table;
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
