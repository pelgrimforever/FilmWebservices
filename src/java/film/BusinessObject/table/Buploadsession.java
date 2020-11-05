/*
 * Buploadsession.java
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
import film.conversion.json.JSONUploadsession;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.logicentity.Uploadsession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Buploadsession
 *
 * Superclass for manipulating data- and database objects
 * for Entity Uploadsession and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Buploadsession extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Uploadsession as default Entity
     */
    public Buploadsession() {
        super(new SQLMapper_pgsql(connectionpool, "Uploadsession"), new Uploadsession());
    }

    /**
     * Constructor, sets Uploadsession as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Buploadsession(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Uploadsession());
    }

    /**
     * Map ResultSet Field values to Uploadsession
     * @param dbresult: Database ResultSet
     */
    public Uploadsession mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UploadsessionPK uploadsessionPK = null;
        Uploadsession uploadsession;
        if(dbresult==null) {
            uploadsession = new Uploadsession(uploadsessionPK);
        } else {
            try {
                uploadsessionPK = new UploadsessionPK(dbresult.getString("filename"));
                uploadsession = new Uploadsession(uploadsessionPK);
                uploadsession.initCreatorPK(new CreatorPK(dbresult.getString("creator")));
                if(dbresult.wasNull()) uploadsession.setCreatorPK(null);                
                uploadsession.initUpload(dbresult.getBoolean("upload"));
                uploadsession.initRotation(dbresult.getFloat("rotation"));
                uploadsession.initFilmgroupid(dbresult.getString("filmgroupid"));
                uploadsession.initPhotosubjects(dbresult.getString("photosubjects"));
                uploadsession.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, uploadsession);
        return uploadsession;
    }

    /**
     * create new empty Uploadsession object
     * @return empty IUploadsession
     */
    public IUploadsession newUploadsession() {
    	return new Uploadsession();
    }
    
    /**
     * create new empty Uploadsession object
     * create new primary key with given parameters
     * @return IUploadsession with primary key
     */
    public IUploadsession newUploadsession(java.lang.String filename) {
        return new Uploadsession(filename);
    }

    /**
     * create new empty Uploadsession object with given primary key
     * @param uploadsessionPK: primary key for Uploadsession
     * @return IUploadsession with primary key
     */
    public IUploadsession newUploadsession(IUploadsessionPK uploadsessionPK) {
        return new Uploadsession((UploadsessionPK)uploadsessionPK);
    }

    /**
     * create new empty primary key
     * @return empty UploadsessionPK
     */
    public IUploadsessionPK newUploadsessionPK() {
        return new UploadsessionPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IUploadsessionPK
     */
    public IUploadsessionPK newUploadsessionPK(java.lang.String filename) {
        return new UploadsessionPK(filename);
    }

    /**
     * get all Uploadsession objects from database
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    public ArrayList getUploadsessions() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Uploadsession.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Uploadsession for primary key
     * @param uploadsessionPK: Uploadsession primary key
     * @return Uploadsession object
     * @throws DBException
     */
    public Uploadsession getUploadsession(IUploadsessionPK uploadsessionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Uploadsession)super.getEntity((UploadsessionPK)uploadsessionPK);
        } else return null;
    }

    public ArrayList searchuploadsessions(IUploadsessionsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchuploadsessions(IUploadsessionsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search uploadsession in database for uploadsessionPK:
     * @param uploadsessionPK: Uploadsession Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUploadsessionExists(IUploadsessionPK uploadsessionPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((UploadsessionPK)uploadsessionPK);
        } else return false;
    }

    /**
     * try to insert Uploadsession in database
     * @param film: Uploadsession object
     * @throws DBException
     */
    public void insertUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(uploadsession);
        }
    }

    /**
     * check if UploadsessionPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Uploadsession object
     * @throws DBException
     */
    public void insertupdateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        if(this.getUploadsessionExists(uploadsession.getPrimaryKey())) {
            super.updateEntity(uploadsession);
        } else {
            super.insertEntity(uploadsession);
        }
    }

    /**
     * try to update Uploadsession in database
     * @param film: Uploadsession object
     * @throws DBException
     */
    public void updateUploadsession(IUploadsession uploadsession) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(uploadsession);
        }
    }

    /**
     * try to delete Uploadsession in database
     * @param film: Uploadsession object
     * @throws DBException
     */
    public void deleteUploadsession(IUploadsession uploadsession) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteUploadsession(uploadsession.getOwnerobject(), uploadsession.getPrimaryKey());
            super.deleteEntity(uploadsession);
        }
    }

    /**
     * check data rules in Uploadsession, throw DataException with customized message if rules do not apply
     * @param film: Uploadsession object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUploadsession uploadsession) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
	//if(uploadsession.getCreatorPK()!=null && uploadsession.getCreatorPK().getCreatorid()!=null && uploadsession.getCreatorPK().getCreatorid().length()>IUploadsession.SIZE_CREATOR) {
        if(uploadsession.getCreatorPK()!=null && uploadsession.getCreatorPK().getCreatorid()!=null && uploadsession.getCreatorPK().getCreatorid().length()>IUploadsession.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_CREATOR + "\n");
        }

        if(uploadsession.getFilmgroupid()!=null && uploadsession.getFilmgroupid().length()>IUploadsession.SIZE_FILMGROUPID) {
            message.append("Filmgroupid is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_FILMGROUPID + "\n");
        }
        if(uploadsession.getPhotosubjects()!=null && uploadsession.getPhotosubjects().length()>IUploadsession.SIZE_PHOTOSUBJECTS) {
            message.append("Photosubjects is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_PHOTOSUBJECTS + "\n");
        }
        if(uploadsession.getDescription()!=null && uploadsession.getDescription().length()>IUploadsession.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_DESCRIPTION + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where uploadsessionPK is used in a primary key
     * @param uploadsessionPK: Uploadsession primary key
     */
    public void cascadedeleteUploadsession(String senderobject, IUploadsessionPK uploadsessionPK) {
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @delete all Uploadsession Entity objects for Creator in database
     * @throws film.general.exception.CustomException
     */
    public void delete4creator(String senderobject, ICreatorPK creatorPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Uploadsession.SQLDelete4creator, creatorPK.getKeyFields());
        }
    }

    /**
     * @param creatorPK: foreign key for Creator
     * @return all Uploadsession Entity objects for Creator
     * @throws film.general.exception.CustomException
     */
    public ArrayList getUploadsessions4creator(ICreatorPK creatorPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Uploadsession.SQLSelect4creator, creatorPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Uploadsession objects for sqlparameters
     * @return ArrayList of Uploadsession objects
     * @throws DBException
     */
    public ArrayList getUploadsessions(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Uploadsession.SQLSelect;
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
     * delete all Uploadsession objects for sqlparameters
     * @throws DBException
     */
    public void delUploadsession(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Uploadsession.table;
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
