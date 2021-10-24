/*
 * Bphototags.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
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
import film.conversion.json.JSONPhototags;
import film.conversion.entity.EMphototags;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhototagssearch;
import film.logicentity.Phototags;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bphototags
 *
 * Superclass for manipulating data- and database objects
 * for Entity Phototags and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bphototags extends BLtable {

    /**
     * Constructor, sets Phototags as default Entity
     */
    public Bphototags() {
        super(new Phototags(), new EMphototags());
    }

    /**
     * Constructor, sets Phototags as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphototags(BLtable transactionobject) {
        super(transactionobject, new Phototags(), new EMphototags());
    }

    /**
     * create new empty Phototags object
     * @return empty IPhototags
     */
    public IPhototags newPhototags() {
    	return new Phototags();
    }
    
    /**
     * create new empty Phototags object
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param tag primary key field
     * @return IPhototags with primary key
     */
    public IPhototags newPhototags(java.lang.String film, int id, java.lang.String tag) {
        return new Phototags(film, id, tag);
    }

    /**
     * create new empty Phototags object with given primary key
     * @param phototagsPK: primary key for Phototags
     * @return IPhototags with primary key
     */
    public IPhototags newPhototags(IPhototagsPK phototagsPK) {
        return new Phototags((PhototagsPK)phototagsPK);
    }

    /**
     * create new empty primary key
     * @return empty PhototagsPK
     */
    public IPhototagsPK newPhototagsPK() {
        return new PhototagsPK();
    }

    /**
     * create new primary key with given parameters
     * @param film primary key field
     * @param id primary key field
     * @param tag primary key field
     * @return new IPhototagsPK
     */
    public IPhototagsPK newPhototagsPK(java.lang.String film, int id, java.lang.String tag) {
        return new PhototagsPK(film, id, tag);
    }

    /**
     * get all Phototags objects from database
     * @return ArrayList of Phototags objects
     * @throws DBException
     */
    public ArrayList<Phototags> getPhototagss() throws DBException {
        return (ArrayList<Phototags>)super.getEntities(EMphototags.SQLSelectAll);
    }

    /**
     * search Phototags for primary key
     * @param phototagsPK: Phototags primary key
     * @return Phototags object
     * @throws DBException
     */
    public Phototags getPhototags(IPhototagsPK phototagsPK) throws DBException {
        return (Phototags)super.getEntity((PhototagsPK)phototagsPK);
    }

    /**
     * search phototags with IPhototagssearch parameters
     * @param search IPhototagssearch
     * @return ArrayList of Phototags
     * @throws DBException 
     */
    public ArrayList<Phototags> searchphototagss(IPhototagssearch search) throws DBException {
        return (ArrayList<Phototags>)this.search(search);
    }

    /**
     * search phototags with IPhototagssearch parameters, order by orderby sql clause
     * @param search IPhototagssearch
     * @param orderby sql order by string
     * @return ArrayList of Phototags
     * @throws DBException 
     */
    public ArrayList<Phototags> searchphototagss(IPhototagssearch search, String orderby) throws DBException {
        return (ArrayList<Phototags>)this.search(search, orderby);
    }

    /**
     * Search phototags in database for phototagsPK:
     * @param phototagsPK: Phototags Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhototagsExists(IPhototagsPK phototagsPK) throws DBException {
        return super.getEntityExists((PhototagsPK)phototagsPK);
    }

    /**
     * try to insert Phototags in database
     * @param phototags Phototags object
     * @throws DBException
     * @throws DataException
     */
    public void insertPhototags(IPhototags phototags) throws DBException, DataException {
        super.insertEntity(phototags);
    }

    /**
     * check if PhototagsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param phototags Phototags object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdatePhototags(IPhototags phototags) throws DBException, DataException {
        if(this.getPhototagsExists(phototags.getPrimaryKey())) {
            super.updateEntity(phototags);
        } else {
            super.insertEntity(phototags);
        }
    }

    /**
     * try to update Phototags in database
     * @param phototags Phototags object
     * @throws DBException
     * @throws DataException
     */
    public void updatePhototags(IPhototags phototags) throws DBException, DataException {
        super.updateEntity(phototags);
    }

    /**
     * try to delete Phototags in database
     * @param phototags Phototags object
     * @throws DBException
     */
    public void deletePhototags(IPhototags phototags) throws DBException {
        cascadedeletePhototags(phototags.getPrimaryKey());
        super.deleteEntity(phototags);
    }

    /**
     * check data rules in Phototags, throw DataException with customized message if rules do not apply
     * @param phototags Phototags object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhototags phototags) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototags.Film - Photo.Film
        //foreign key Phototags.Id - Photo.Id
        //Primary key
        if(phototags.getTagformat()!=null && phototags.getTagformat().length()>IPhototags.SIZE_TAGFORMAT) {
            message.append("Tagformat is langer dan toegestaan. Max aantal karakters: ").append(IPhototags.SIZE_TAGFORMAT).append("\n");
        }
        if(phototags.getTagformat()==null) {
            message.append("Tagformat mag niet leeg zijn.\n");
        }
        if(phototags.getTagvalue()!=null && phototags.getTagvalue().length()>IPhototags.SIZE_TAGVALUE) {
            message.append("Tagvalue is langer dan toegestaan. Max aantal karakters: ").append(IPhototags.SIZE_TAGVALUE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where phototagsPK is used in a primary key
     * @param phototagsPK: Phototags primary key
     */
    public void cascadedeletePhototags(IPhototagsPK phototagsPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Phototags Entity objects for Photo in database
     */
    public void delete4photo(IPhotoPK photoPK) {
        super.addStatement(EMphototags.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Phototags Entity objects for Photo
     * @throws CustomException
     */
    public ArrayList<Phototags> getPhototagss4photo(IPhotoPK photoPK) throws CustomException {
        return super.getEntities(EMphototags.SQLSelect4photo, photoPK.getSQLprimarykey());
    }

    /**
     * get all Phototags objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Phototags objects
     * @throws DBException
     */
    public ArrayList<Phototags> getPhototagss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphototags.SQLSelect);
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
        return (ArrayList<Phototags>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Phototags objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delPhototags(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Phototags.table);
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
