/*
 * Bphototags.java
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
import film.conversion.json.JSONPhototags;
import film.data.ProjectConstants;
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
public abstract class Bphototags extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Phototags as default Entity
     */
    public Bphototags() {
        super(new SQLMapper_pgsql(connectionpool, "Phototags"), new Phototags());
    }

    /**
     * Constructor, sets Phototags as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bphototags(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Phototags());
    }

    /**
     * Map ResultSet Field values to Phototags
     * @param dbresult: Database ResultSet
     */
    public Phototags mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PhototagsPK phototagsPK = null;
        Phototags phototags;
        if(dbresult==null) {
            phototags = new Phototags(phototagsPK);
        } else {
            try {
                phototagsPK = new PhototagsPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getString("tag"));
                phototags = new Phototags(phototagsPK);
                phototags.initTagformat(dbresult.getString("tagformat"));
                phototags.initTagvalue(dbresult.getString("tagvalue"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, phototags);
        return phototags;
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
    public ArrayList getPhototagss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Phototags.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Phototags for primary key
     * @param phototagsPK: Phototags primary key
     * @return Phototags object
     * @throws DBException
     */
    public Phototags getPhototags(IPhototagsPK phototagsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Phototags)super.getEntity((PhototagsPK)phototagsPK);
        } else return null;
    }

    public ArrayList searchphototagss(IPhototagssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchphototagss(IPhototagssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search phototags in database for phototagsPK:
     * @param phototagsPK: Phototags Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPhototagsExists(IPhototagsPK phototagsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((PhototagsPK)phototagsPK);
        } else return false;
    }

    /**
     * try to insert Phototags in database
     * @param film: Phototags object
     * @throws DBException
     */
    public void insertPhototags(IPhototags phototags) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(phototags);
        }
    }

    /**
     * check if PhototagsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Phototags object
     * @throws DBException
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
     * @param film: Phototags object
     * @throws DBException
     */
    public void updatePhototags(IPhototags phototags) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(phototags);
        }
    }

    /**
     * try to delete Phototags in database
     * @param film: Phototags object
     * @throws DBException
     */
    public void deletePhototags(IPhototags phototags) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeletePhototags(phototags.getOwnerobject(), phototags.getPrimaryKey());
            super.deleteEntity(phototags);
        }
    }

    /**
     * check data rules in Phototags, throw DataException with customized message if rules do not apply
     * @param film: Phototags object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPhototags phototags) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototags.Film - Photo.Film
        //foreign key Phototags.Id - Photo.Id
        //Primary key
        if(phototags.getTagformat()!=null && phototags.getTagformat().length()>IPhototags.SIZE_TAGFORMAT) {
            message.append("Tagformat is langer dan toegestaan. Max aantal karakters: " + IPhototags.SIZE_TAGFORMAT + "\n");
        }
        if(phototags.getTagformat()==null) {
            message.append("Tagformat mag niet leeg zijn.\n");
        }
        if(phototags.getTagvalue()!=null && phototags.getTagvalue().length()>IPhototags.SIZE_TAGVALUE) {
            message.append("Tagvalue is langer dan toegestaan. Max aantal karakters: " + IPhototags.SIZE_TAGVALUE + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where phototagsPK is used in a primary key
     * @param phototagsPK: Phototags primary key
     */
    public void cascadedeletePhototags(String senderobject, IPhototagsPK phototagsPK) {
    }

    /**
     * @param photoPK: foreign key for Photo
     * @delete all Phototags Entity objects for Photo in database
     * @throws film.general.exception.CustomException
     */
    public void delete4photo(String senderobject, IPhotoPK photoPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Phototags.SQLDelete4photo, photoPK.getKeyFields());
        }
    }

    /**
     * @param photoPK: foreign key for Photo
     * @return all Phototags Entity objects for Photo
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPhototagss4photo(IPhotoPK photoPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Phototags.SQLSelect4photo, photoPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Phototags objects for sqlparameters
     * @return ArrayList of Phototags objects
     * @throws DBException
     */
    public ArrayList getPhototagss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Phototags.SQLSelect;
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
     * delete all Phototags objects for sqlparameters
     * @throws DBException
     */
    public void delPhototags(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Phototags.table;
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
