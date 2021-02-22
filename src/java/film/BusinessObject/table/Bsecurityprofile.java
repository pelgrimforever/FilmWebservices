/*
 * Bsecurityprofile.java
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
import film.conversion.json.JSONSecurityprofile;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.logicentity.Securityprofile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bsecurityprofile
 *
 * Superclass for manipulating data- and database objects
 * for Entity Securityprofile and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsecurityprofile extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Securityprofile as default Entity
     */
    public Bsecurityprofile() {
        super(new SQLMapper_pgsql(connectionpool, "Securityprofile"), new Securityprofile());
    }

    /**
     * Constructor, sets Securityprofile as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurityprofile(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Securityprofile());
    }

    /**
     * Map ResultSet Field values to Securityprofile
     * @param dbresult: Database ResultSet
     */
    public Securityprofile mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityprofilePK securityprofilePK = null;
        Securityprofile securityprofile;
        if(dbresult==null) {
            securityprofile = new Securityprofile(securityprofilePK);
        } else {
            try {
                securityprofilePK = new SecurityprofilePK(dbresult.getString("userprofile"));
                securityprofile = new Securityprofile(securityprofilePK);
                securityprofile.initPrivateaccess(dbresult.getBoolean("privateaccess"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, securityprofile);
        return securityprofile;
    }

    /**
     * create new empty Securityprofile object
     * @return empty ISecurityprofile
     */
    public ISecurityprofile newSecurityprofile() {
    	return new Securityprofile();
    }
    
    /**
     * create new empty Securityprofile object
     * create new primary key with given parameters
     * @return ISecurityprofile with primary key
     */
    public ISecurityprofile newSecurityprofile(java.lang.String userprofile) {
        return new Securityprofile(userprofile);
    }

    /**
     * create new empty Securityprofile object with given primary key
     * @param securityprofilePK: primary key for Securityprofile
     * @return ISecurityprofile with primary key
     */
    public ISecurityprofile newSecurityprofile(ISecurityprofilePK securityprofilePK) {
        return new Securityprofile((SecurityprofilePK)securityprofilePK);
    }

    /**
     * create new empty primary key
     * @return empty SecurityprofilePK
     */
    public ISecurityprofilePK newSecurityprofilePK() {
        return new SecurityprofilePK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISecurityprofilePK
     */
    public ISecurityprofilePK newSecurityprofilePK(java.lang.String userprofile) {
        return new SecurityprofilePK(userprofile);
    }

    /**
     * get all Securityprofile objects from database
     * @return ArrayList of Securityprofile objects
     * @throws DBException
     */
    public ArrayList getSecurityprofiles() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Securityprofile.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Securityprofile for primary key
     * @param securityprofilePK: Securityprofile primary key
     * @return Securityprofile object
     * @throws DBException
     */
    public Securityprofile getSecurityprofile(ISecurityprofilePK securityprofilePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Securityprofile)super.getEntity((SecurityprofilePK)securityprofilePK);
        } else return null;
    }

    public ArrayList searchsecurityprofiles(ISecurityprofilesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsecurityprofiles(ISecurityprofilesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search securityprofile in database for securityprofilePK:
     * @param securityprofilePK: Securityprofile Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurityprofileExists(ISecurityprofilePK securityprofilePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SecurityprofilePK)securityprofilePK);
        } else return false;
    }

    /**
     * try to insert Securityprofile in database
     * @param film: Securityprofile object
     * @throws DBException
     */
    public void insertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(securityprofile);
        }
    }

    /**
     * check if SecurityprofilePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Securityprofile object
     * @throws DBException
     */
    public void insertupdateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        if(this.getSecurityprofileExists(securityprofile.getPrimaryKey())) {
            super.updateEntity(securityprofile);
        } else {
            super.insertEntity(securityprofile);
        }
    }

    /**
     * try to update Securityprofile in database
     * @param film: Securityprofile object
     * @throws DBException
     */
    public void updateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(securityprofile);
        }
    }

    /**
     * try to delete Securityprofile in database
     * @param film: Securityprofile object
     * @throws DBException
     */
    public void deleteSecurityprofile(ISecurityprofile securityprofile) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSecurityprofile(securityprofile.getOwnerobject(), securityprofile.getPrimaryKey());
            super.deleteEntity(securityprofile);
        }
    }

    /**
     * check data rules in Securityprofile, throw DataException with customized message if rules do not apply
     * @param film: Securityprofile object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISecurityprofile securityprofile) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where securityprofilePK is used in a primary key
     * @param securityprofilePK: Securityprofile primary key
     */
    public void cascadedeleteSecurityprofile(String senderobject, ISecurityprofilePK securityprofilePK) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile(this);
        blsecurityuserprofile.delete4securityprofile(senderobject, securityprofilePK);
    }

    /**
     * @param securityuserprofilePK: parent Securityuserprofile for child object Securityprofile Entity
     * @return child Securityprofile Entity object
     * @throws film.general.exception.CustomException
     */
    public ISecurityprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SecurityprofilePK securityprofilePK = new SecurityprofilePK(securityuserprofilePK.getUserprofile());
            return this.getSecurityprofile(securityprofilePK);
        } else return null;
    }


    /**
     * get all Securityprofile objects for sqlparameters
     * @return ArrayList of Securityprofile objects
     * @throws DBException
     */
    public ArrayList getSecurityprofiles(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Securityprofile.SQLSelect;
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
     * delete all Securityprofile objects for sqlparameters
     * @throws DBException
     */
    public void delSecurityprofile(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Securityprofile.table;
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
