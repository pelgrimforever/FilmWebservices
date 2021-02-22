/*
 * Bspatial_ref_sys.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.1.2021 12:6
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
import film.conversion.json.JSONSpatial_ref_sys;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.logicentity.Spatial_ref_sys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bspatial_ref_sys
 *
 * Superclass for manipulating data- and database objects
 * for Entity Spatial_ref_sys and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bspatial_ref_sys extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     */
    public Bspatial_ref_sys() {
        super(new SQLMapper_pgsql(connectionpool, "Spatial_ref_sys"), new Spatial_ref_sys());
    }

    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bspatial_ref_sys(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Spatial_ref_sys());
    }

    /**
     * Map ResultSet Field values to Spatial_ref_sys
     * @param dbresult: Database ResultSet
     */
    public Spatial_ref_sys mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Spatial_ref_sysPK spatial_ref_sysPK = null;
        Spatial_ref_sys spatial_ref_sys;
        if(dbresult==null) {
            spatial_ref_sys = new Spatial_ref_sys(spatial_ref_sysPK);
        } else {
            try {
                spatial_ref_sysPK = new Spatial_ref_sysPK(dbresult.getInt("srid"));
                spatial_ref_sys = new Spatial_ref_sys(spatial_ref_sysPK);
                spatial_ref_sys.initAuth_name(dbresult.getString("auth_name"));
                spatial_ref_sys.initAuth_srid(dbresult.getInt("auth_srid"));
                spatial_ref_sys.initSrtext(dbresult.getString("srtext"));
                spatial_ref_sys.initProj4text(dbresult.getString("proj4text"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, spatial_ref_sys);
        return spatial_ref_sys;
    }

    /**
     * create new empty Spatial_ref_sys object
     * @return empty ISpatial_ref_sys
     */
    public ISpatial_ref_sys newSpatial_ref_sys() {
    	return new Spatial_ref_sys();
    }
    
    /**
     * create new empty Spatial_ref_sys object
     * create new primary key with given parameters
     * @return ISpatial_ref_sys with primary key
     */
    public ISpatial_ref_sys newSpatial_ref_sys(int srid) {
        return new Spatial_ref_sys(srid);
    }

    /**
     * create new empty Spatial_ref_sys object with given primary key
     * @param spatial_ref_sysPK: primary key for Spatial_ref_sys
     * @return ISpatial_ref_sys with primary key
     */
    public ISpatial_ref_sys newSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) {
        return new Spatial_ref_sys((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    /**
     * create new empty primary key
     * @return empty Spatial_ref_sysPK
     */
    public ISpatial_ref_sysPK newSpatial_ref_sysPK() {
        return new Spatial_ref_sysPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISpatial_ref_sysPK
     */
    public ISpatial_ref_sysPK newSpatial_ref_sysPK(int srid) {
        return new Spatial_ref_sysPK(srid);
    }

    /**
     * get all Spatial_ref_sys objects from database
     * @return ArrayList of Spatial_ref_sys objects
     * @throws DBException
     */
    public ArrayList getSpatial_ref_syss() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Spatial_ref_sys.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Spatial_ref_sys for primary key
     * @param spatial_ref_sysPK: Spatial_ref_sys primary key
     * @return Spatial_ref_sys object
     * @throws DBException
     */
    public Spatial_ref_sys getSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Spatial_ref_sys)super.getEntity((Spatial_ref_sysPK)spatial_ref_sysPK);
        } else return null;
    }

    public ArrayList searchspatial_ref_syss(ISpatial_ref_syssearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchspatial_ref_syss(ISpatial_ref_syssearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search spatial_ref_sys in database for spatial_ref_sysPK:
     * @param spatial_ref_sysPK: Spatial_ref_sys Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSpatial_ref_sysExists(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Spatial_ref_sysPK)spatial_ref_sysPK);
        } else return false;
    }

    /**
     * try to insert Spatial_ref_sys in database
     * @param film: Spatial_ref_sys object
     * @throws DBException
     */
    public void insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(spatial_ref_sys);
        }
    }

    /**
     * check if Spatial_ref_sysPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Spatial_ref_sys object
     * @throws DBException
     */
    public void insertupdateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        if(this.getSpatial_ref_sysExists(spatial_ref_sys.getPrimaryKey())) {
            super.updateEntity(spatial_ref_sys);
        } else {
            super.insertEntity(spatial_ref_sys);
        }
    }

    /**
     * try to update Spatial_ref_sys in database
     * @param film: Spatial_ref_sys object
     * @throws DBException
     */
    public void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(spatial_ref_sys);
        }
    }

    /**
     * try to delete Spatial_ref_sys in database
     * @param film: Spatial_ref_sys object
     * @throws DBException
     */
    public void deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSpatial_ref_sys(spatial_ref_sys.getOwnerobject(), spatial_ref_sys.getPrimaryKey());
            super.deleteEntity(spatial_ref_sys);
        }
    }

    /**
     * check data rules in Spatial_ref_sys, throw DataException with customized message if rules do not apply
     * @param film: Spatial_ref_sys object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISpatial_ref_sys spatial_ref_sys) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(spatial_ref_sys.getAuth_name()!=null && spatial_ref_sys.getAuth_name().length()>ISpatial_ref_sys.SIZE_AUTH_NAME) {
            message.append("Auth_name is langer dan toegestaan. Max aantal karakters: " + ISpatial_ref_sys.SIZE_AUTH_NAME + "\n");
        }
        if(spatial_ref_sys.getSrtext()!=null && spatial_ref_sys.getSrtext().length()>ISpatial_ref_sys.SIZE_SRTEXT) {
            message.append("Srtext is langer dan toegestaan. Max aantal karakters: " + ISpatial_ref_sys.SIZE_SRTEXT + "\n");
        }
        if(spatial_ref_sys.getProj4text()!=null && spatial_ref_sys.getProj4text().length()>ISpatial_ref_sys.SIZE_PROJ4TEXT) {
            message.append("Proj4text is langer dan toegestaan. Max aantal karakters: " + ISpatial_ref_sys.SIZE_PROJ4TEXT + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where spatial_ref_sysPK is used in a primary key
     * @param spatial_ref_sysPK: Spatial_ref_sys primary key
     */
    public void cascadedeleteSpatial_ref_sys(String senderobject, ISpatial_ref_sysPK spatial_ref_sysPK) {
    }


    /**
     * get all Spatial_ref_sys objects for sqlparameters
     * @return ArrayList of Spatial_ref_sys objects
     * @throws DBException
     */
    public ArrayList getSpatial_ref_syss(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Spatial_ref_sys.SQLSelect;
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
     * delete all Spatial_ref_sys objects for sqlparameters
     * @throws DBException
     */
    public void delSpatial_ref_sys(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Spatial_ref_sys.table;
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
