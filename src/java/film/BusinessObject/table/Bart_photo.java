/*
 * Bart_photo.java
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
import film.conversion.json.JSONArt_photo;
import film.conversion.entity.EMart_photo;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bart_photo extends BLtable {

    /**
     * Constructor, sets Art_photo as default Entity
     */
    public Bart_photo() {
        super(new Art_photo(), new EMart_photo());
    }

    /**
     * Constructor, sets Art_photo as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bart_photo(BLtable transactionobject) {
        super(transactionobject, new Art_photo(), new EMart_photo());
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
     * @param film primary key field
     * @param photo primary key field
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
     * @param film primary key field
     * @param photo primary key field
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
    public ArrayList<Art_photo> getArt_photos() throws DBException {
        return (ArrayList<Art_photo>)super.getEntities(EMart_photo.SQLSelectAll);
    }

    /**
     * search Art_photo for primary key
     * @param art_photoPK: Art_photo primary key
     * @return Art_photo object
     * @throws DBException
     */
    public Art_photo getArt_photo(IArt_photoPK art_photoPK) throws DBException {
        return (Art_photo)super.getEntity((Art_photoPK)art_photoPK);
    }

    /**
     * search art_photo with IArt_photosearch parameters
     * @param search IArt_photosearch
     * @return ArrayList of Art_photo
     * @throws DBException 
     */
    public ArrayList<Art_photo> searchart_photos(IArt_photosearch search) throws DBException {
        return (ArrayList<Art_photo>)this.search(search);
    }

    /**
     * search art_photo with IArt_photosearch parameters, order by orderby sql clause
     * @param search IArt_photosearch
     * @param orderby sql order by string
     * @return ArrayList of Art_photo
     * @throws DBException 
     */
    public ArrayList<Art_photo> searchart_photos(IArt_photosearch search, String orderby) throws DBException {
        return (ArrayList<Art_photo>)this.search(search, orderby);
    }

    /**
     * Search art_photo in database for art_photoPK:
     * @param art_photoPK: Art_photo Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArt_photoExists(IArt_photoPK art_photoPK) throws DBException {
        return super.getEntityExists((Art_photoPK)art_photoPK);
    }

    /**
     * try to insert Art_photo in database
     * @param art_photo Art_photo object
     * @throws DBException
     * @throws DataException
     */
    public void insertArt_photo(IArt_photo art_photo) throws DBException, DataException {
        super.insertEntity(art_photo);
    }

    /**
     * check if Art_photoPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param art_photo Art_photo object
     * @throws DBException
     * @throws DataException
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
     * @param art_photo Art_photo object
     * @throws DBException
     * @throws DataException
     */
    public void updateArt_photo(IArt_photo art_photo) throws DBException, DataException {
        super.updateEntity(art_photo);
    }

    /**
     * try to delete Art_photo in database
     * @param art_photo Art_photo object
     * @throws DBException
     */
    public void deleteArt_photo(IArt_photo art_photo) throws DBException {
        cascadedeleteArt_photo(art_photo.getPrimaryKey());
        super.deleteEntity(art_photo);
    }

    /**
     * check data rules in Art_photo, throw DataException with customized message if rules do not apply
     * @param art_photo Art_photo object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArt_photo art_photo) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Art_photo.Film - Photo.Film
        //foreign key Art_photo.Photo - Photo.Id
        if(art_photo.getComment()!=null && art_photo.getComment().length()>IArt_photo.SIZE_COMMENT) {
            message.append("Comment is langer dan toegestaan. Max aantal karakters: ").append(IArt_photo.SIZE_COMMENT).append("\n");
        }
        if(art_photo.getSurrounddir()!=null && art_photo.getSurrounddir().length()>IArt_photo.SIZE_SURROUNDDIR) {
            message.append("Surrounddir is langer dan toegestaan. Max aantal karakters: ").append(IArt_photo.SIZE_SURROUNDDIR).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where art_photoPK is used in a primary key
     * @param art_photoPK: Art_photo primary key
     */
    public void cascadedeleteArt_photo(IArt_photoPK art_photoPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Art_photo Entity objects for Photo in database
     */
    public void delete4photo(IPhotoPK photoPK) {
        super.addStatement(EMart_photo.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Art_photo Entity objects for Photo
     * @throws CustomException
     */
    public ArrayList<Art_photo> getArt_photos4photo(IPhotoPK photoPK) throws CustomException {
        return super.getEntities(EMart_photo.SQLSelect4photo, photoPK.getSQLprimarykey());
    }
    /**
     * @param art_subgroupPK: foreign key for Art_subgroup
     * @delete all Art_photo Entity objects for Art_subgroup in database
     */
    public void delete4art_subgroup(IArt_subgroupPK art_subgroupPK) {
        super.addStatement(EMart_photo.SQLDelete4art_subgroup, art_subgroupPK.getSQLprimarykey());
    }

    /**
     * @param art_subgroupPK: foreign key for Art_subgroup
     * @return all Art_photo Entity objects for Art_subgroup
     * @throws CustomException
     */
    public ArrayList<Art_photo> getArt_photos4art_subgroup(IArt_subgroupPK art_subgroupPK) throws CustomException {
        return super.getEntities(EMart_photo.SQLSelect4art_subgroup, art_subgroupPK.getSQLprimarykey());
    }
    /**
     * @param art_academyPK: foreign key for Art_academy
     * @delete all Art_photo Entity objects for Art_academy in database
     */
    public void delete4art_academy(IArt_academyPK art_academyPK) {
        super.addStatement(EMart_photo.SQLDelete4art_academy, art_academyPK.getSQLprimarykey());
    }

    /**
     * @param art_academyPK: foreign key for Art_academy
     * @return all Art_photo Entity objects for Art_academy
     * @throws CustomException
     */
    public ArrayList<Art_photo> getArt_photos4art_academy(IArt_academyPK art_academyPK) throws CustomException {
        return super.getEntities(EMart_photo.SQLSelect4art_academy, art_academyPK.getSQLprimarykey());
    }
    /**
     * @param art_groupPK: foreign key for Art_group
     * @delete all Art_photo Entity objects for Art_group in database
     */
    public void delete4art_group(IArt_groupPK art_groupPK) {
        super.addStatement(EMart_photo.SQLDelete4art_group, art_groupPK.getSQLprimarykey());
    }

    /**
     * @param art_groupPK: foreign key for Art_group
     * @return all Art_photo Entity objects for Art_group
     * @throws CustomException
     */
    public ArrayList<Art_photo> getArt_photos4art_group(IArt_groupPK art_groupPK) throws CustomException {
        return super.getEntities(EMart_photo.SQLSelect4art_group, art_groupPK.getSQLprimarykey());
    }

    /**
     * get all Art_photo objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Art_photo objects
     * @throws DBException
     */
    public ArrayList<Art_photo> getArt_photos(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMart_photo.SQLSelect);
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
        return (ArrayList<Art_photo>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Art_photo objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArt_photo(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Art_photo.table);
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
