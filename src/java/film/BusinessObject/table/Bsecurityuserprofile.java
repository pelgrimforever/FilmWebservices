/*
 * Bsecurityuserprofile.java
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
import film.conversion.json.JSONSecurityuserprofile;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.logicentity.Securityuserprofile;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bsecurityuserprofile
 *
 * Superclass for manipulating data- and database objects
 * for Entity Securityuserprofile and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsecurityuserprofile extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Securityuserprofile as default Entity
     */
    public Bsecurityuserprofile() {
        super(new SQLMapper_pgsql(connectionpool, "Securityuserprofile"), new Securityuserprofile());
    }

    /**
     * Constructor, sets Securityuserprofile as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurityuserprofile(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Securityuserprofile());
    }

    /**
     * Map ResultSet Field values to Securityuserprofile
     * @param dbresult: Database ResultSet
     */
    public Securityuserprofile mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityuserprofilePK securityuserprofilePK = null;
        Securityuserprofile securityuserprofile;
        if(dbresult==null) {
            securityuserprofile = new Securityuserprofile(securityuserprofilePK);
        } else {
            try {
                securityuserprofilePK = new SecurityuserprofilePK(dbresult.getString("siteusername"), dbresult.getString("userprofile"));
                securityuserprofile = new Securityuserprofile(securityuserprofilePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, securityuserprofile);
        return securityuserprofile;
    }

    /**
     * create new empty Securityuserprofile object
     * @return empty ISecurityuserprofile
     */
    public ISecurityuserprofile newSecurityuserprofile() {
    	return new Securityuserprofile();
    }
    
    /**
     * create new empty Securityuserprofile object
     * create new primary key with given parameters
     * @return ISecurityuserprofile with primary key
     */
    public ISecurityuserprofile newSecurityuserprofile(java.lang.String siteusername, java.lang.String userprofile) {
        return new Securityuserprofile(siteusername, userprofile);
    }

    /**
     * create new empty Securityuserprofile object with given primary key
     * @param securityuserprofilePK: primary key for Securityuserprofile
     * @return ISecurityuserprofile with primary key
     */
    public ISecurityuserprofile newSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) {
        return new Securityuserprofile((SecurityuserprofilePK)securityuserprofilePK);
    }

    /**
     * create new empty primary key
     * @return empty SecurityuserprofilePK
     */
    public ISecurityuserprofilePK newSecurityuserprofilePK() {
        return new SecurityuserprofilePK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISecurityuserprofilePK
     */
    public ISecurityuserprofilePK newSecurityuserprofilePK(java.lang.String siteusername, java.lang.String userprofile) {
        return new SecurityuserprofilePK(siteusername, userprofile);
    }

    /**
     * get all Securityuserprofile objects from database
     * @return ArrayList of Securityuserprofile objects
     * @throws DBException
     */
    public ArrayList getSecurityuserprofiles() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Securityuserprofile.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Securityuserprofile for primary key
     * @param securityuserprofilePK: Securityuserprofile primary key
     * @return Securityuserprofile object
     * @throws DBException
     */
    public Securityuserprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Securityuserprofile)super.getEntity((SecurityuserprofilePK)securityuserprofilePK);
        } else return null;
    }

    public ArrayList searchsecurityuserprofiles(ISecurityuserprofilesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsecurityuserprofiles(ISecurityuserprofilesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search securityuserprofile in database for securityuserprofilePK:
     * @param securityuserprofilePK: Securityuserprofile Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurityuserprofileExists(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SecurityuserprofilePK)securityuserprofilePK);
        } else return false;
    }

    /**
     * try to insert Securityuserprofile in database
     * @param film: Securityuserprofile object
     * @throws DBException
     */
    public void insertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(securityuserprofile);
        }
    }

    /**
     * check if SecurityuserprofilePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Securityuserprofile object
     * @throws DBException
     */
    public void insertupdateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        if(this.getSecurityuserprofileExists(securityuserprofile.getPrimaryKey())) {
            super.updateEntity(securityuserprofile);
        } else {
            super.insertEntity(securityuserprofile);
        }
    }

    /**
     * try to update Securityuserprofile in database
     * @param film: Securityuserprofile object
     * @throws DBException
     */
    public void updateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(securityuserprofile);
        }
    }

    /**
     * try to delete Securityuserprofile in database
     * @param film: Securityuserprofile object
     * @throws DBException
     */
    public void deleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSecurityuserprofile(securityuserprofile.getOwnerobject(), securityuserprofile.getPrimaryKey());
            super.deleteEntity(securityuserprofile);
        }
    }

    /**
     * check data rules in Securityuserprofile, throw DataException with customized message if rules do not apply
     * @param film: Securityuserprofile object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISecurityuserprofile securityuserprofile) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Securityuserprofile.Userprofile - Securityprofile.Userprofile
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where securityuserprofilePK is used in a primary key
     * @param securityuserprofilePK: Securityuserprofile primary key
     */
    public void cascadedeleteSecurityuserprofile(String senderobject, ISecurityuserprofilePK securityuserprofilePK) {
    }

    /**
     * @param securityprofilePK: foreign key for Securityprofile
     * @delete all Securityuserprofile Entity objects for Securityprofile in database
     * @throws film.general.exception.CustomException
     */
    public void delete4securityprofile(String senderobject, ISecurityprofilePK securityprofilePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Securityuserprofile.SQLDelete4securityprofile, securityprofilePK.getKeyFields());
        }
    }

    /**
     * @param securityprofilePK: foreign key for Securityprofile
     * @return all Securityuserprofile Entity objects for Securityprofile
     * @throws film.general.exception.CustomException
     */
    public ArrayList getSecurityuserprofiles4securityprofile(ISecurityprofilePK securityprofilePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Securityuserprofile.SQLSelect4securityprofile, securityprofilePK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Securityuserprofile objects for sqlparameters
     * @return ArrayList of Securityuserprofile objects
     * @throws DBException
     */
    public ArrayList getSecurityuserprofiles(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Securityuserprofile.SQLSelect;
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
     * delete all Securityuserprofile objects for sqlparameters
     * @throws DBException
     */
    public void delSecurityuserprofile(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Securityuserprofile.table;
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
