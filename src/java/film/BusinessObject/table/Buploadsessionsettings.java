/*
 * Buploadsessionsettings.java
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
import film.conversion.json.JSONUploadsessionsettings;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.logicentity.Uploadsessionsettings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Buploadsessionsettings
 *
 * Superclass for manipulating data- and database objects
 * for Entity Uploadsessionsettings and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Buploadsessionsettings extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     */
    public Buploadsessionsettings() {
        super(new SQLMapper_pgsql(connectionpool, "Uploadsessionsettings"), new Uploadsessionsettings());
    }

    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Buploadsessionsettings(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Uploadsessionsettings());
    }

    /**
     * Map ResultSet Field values to Uploadsessionsettings
     * @param dbresult: Database ResultSet
     */
    public Uploadsessionsettings mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UploadsessionsettingsPK uploadsessionsettingsPK = null;
        Uploadsessionsettings uploadsessionsettings;
        if(dbresult==null) {
            uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
        } else {
            try {
                uploadsessionsettingsPK = new UploadsessionsettingsPK(dbresult.getString("directory"));
                uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
                uploadsessionsettings.initUploadtype(dbresult.getString("uploadtype"));
                uploadsessionsettings.initFilmgroups(dbresult.getString("filmgroups"));
                uploadsessionsettings.initLastposition(dbresult.getInt("lastposition"));
                uploadsessionsettings.initCopymode(dbresult.getString("copymode"));
                uploadsessionsettings.initUploadingposition(dbresult.getInt("uploadingposition"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, uploadsessionsettings);
        return uploadsessionsettings;
    }

    /**
     * create new empty Uploadsessionsettings object
     * @return empty IUploadsessionsettings
     */
    public IUploadsessionsettings newUploadsessionsettings() {
    	return new Uploadsessionsettings();
    }
    
    /**
     * create new empty Uploadsessionsettings object
     * create new primary key with given parameters
     * @return IUploadsessionsettings with primary key
     */
    public IUploadsessionsettings newUploadsessionsettings(java.lang.String directory) {
        return new Uploadsessionsettings(directory);
    }

    /**
     * create new empty Uploadsessionsettings object with given primary key
     * @param uploadsessionsettingsPK: primary key for Uploadsessionsettings
     * @return IUploadsessionsettings with primary key
     */
    public IUploadsessionsettings newUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) {
        return new Uploadsessionsettings((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    /**
     * create new empty primary key
     * @return empty UploadsessionsettingsPK
     */
    public IUploadsessionsettingsPK newUploadsessionsettingsPK() {
        return new UploadsessionsettingsPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IUploadsessionsettingsPK
     */
    public IUploadsessionsettingsPK newUploadsessionsettingsPK(java.lang.String directory) {
        return new UploadsessionsettingsPK(directory);
    }

    /**
     * get all Uploadsessionsettings objects from database
     * @return ArrayList of Uploadsessionsettings objects
     * @throws DBException
     */
    public ArrayList getUploadsessionsettingss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Uploadsessionsettings.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Uploadsessionsettings for primary key
     * @param uploadsessionsettingsPK: Uploadsessionsettings primary key
     * @return Uploadsessionsettings object
     * @throws DBException
     */
    public Uploadsessionsettings getUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Uploadsessionsettings)super.getEntity((UploadsessionsettingsPK)uploadsessionsettingsPK);
        } else return null;
    }

    public ArrayList searchuploadsessionsettingss(IUploadsessionsettingssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchuploadsessionsettingss(IUploadsessionsettingssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search uploadsessionsettings in database for uploadsessionsettingsPK:
     * @param uploadsessionsettingsPK: Uploadsessionsettings Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUploadsessionsettingsExists(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((UploadsessionsettingsPK)uploadsessionsettingsPK);
        } else return false;
    }

    /**
     * try to insert Uploadsessionsettings in database
     * @param film: Uploadsessionsettings object
     * @throws DBException
     */
    public void insertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(uploadsessionsettings);
        }
    }

    /**
     * check if UploadsessionsettingsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Uploadsessionsettings object
     * @throws DBException
     */
    public void insertupdateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(this.getUploadsessionsettingsExists(uploadsessionsettings.getPrimaryKey())) {
            super.updateEntity(uploadsessionsettings);
        } else {
            super.insertEntity(uploadsessionsettings);
        }
    }

    /**
     * try to update Uploadsessionsettings in database
     * @param film: Uploadsessionsettings object
     * @throws DBException
     */
    public void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(uploadsessionsettings);
        }
    }

    /**
     * try to delete Uploadsessionsettings in database
     * @param film: Uploadsessionsettings object
     * @throws DBException
     */
    public void deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteUploadsessionsettings(uploadsessionsettings.getOwnerobject(), uploadsessionsettings.getPrimaryKey());
            super.deleteEntity(uploadsessionsettings);
        }
    }

    /**
     * check data rules in Uploadsessionsettings, throw DataException with customized message if rules do not apply
     * @param film: Uploadsessionsettings object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUploadsessionsettings uploadsessionsettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(uploadsessionsettings.getUploadtype()!=null && uploadsessionsettings.getUploadtype().length()>IUploadsessionsettings.SIZE_UPLOADTYPE) {
            message.append("Uploadtype is langer dan toegestaan. Max aantal karakters: " + IUploadsessionsettings.SIZE_UPLOADTYPE + "\n");
        }
        if(uploadsessionsettings.getUploadtype()==null) {
            message.append("Uploadtype mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getFilmgroups()!=null && uploadsessionsettings.getFilmgroups().length()>IUploadsessionsettings.SIZE_FILMGROUPS) {
            message.append("Filmgroups is langer dan toegestaan. Max aantal karakters: " + IUploadsessionsettings.SIZE_FILMGROUPS + "\n");
        }
        if(uploadsessionsettings.getFilmgroups()==null) {
            message.append("Filmgroups mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getCopymode()!=null && uploadsessionsettings.getCopymode().length()>IUploadsessionsettings.SIZE_COPYMODE) {
            message.append("Copymode is langer dan toegestaan. Max aantal karakters: " + IUploadsessionsettings.SIZE_COPYMODE + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where uploadsessionsettingsPK is used in a primary key
     * @param uploadsessionsettingsPK: Uploadsessionsettings primary key
     */
    public void cascadedeleteUploadsessionsettings(String senderobject, IUploadsessionsettingsPK uploadsessionsettingsPK) {
    }


    /**
     * get all Uploadsessionsettings objects for sqlparameters
     * @return ArrayList of Uploadsessionsettings objects
     * @throws DBException
     */
    public ArrayList getUploadsessionsettingss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Uploadsessionsettings.SQLSelect;
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
     * delete all Uploadsessionsettings objects for sqlparameters
     * @throws DBException
     */
    public void delUploadsessionsettings(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Uploadsessionsettings.table;
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
