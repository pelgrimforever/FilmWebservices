/*
 * Bsecurityprofile.java
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
import film.conversion.json.JSONSecurityprofile;
import film.conversion.entity.EMsecurityprofile;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bsecurityprofile extends BLtable {

    /**
     * Constructor, sets Securityprofile as default Entity
     */
    public Bsecurityprofile() {
        super(new Securityprofile(), new EMsecurityprofile());
    }

    /**
     * Constructor, sets Securityprofile as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurityprofile(BLtable transactionobject) {
        super(transactionobject, new Securityprofile(), new EMsecurityprofile());
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
     * @param userprofile primary key field
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
     * @param userprofile primary key field
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
    public ArrayList<Securityprofile> getSecurityprofiles() throws DBException {
        return (ArrayList<Securityprofile>)super.getEntities(EMsecurityprofile.SQLSelectAll);
    }

    /**
     * search Securityprofile for primary key
     * @param securityprofilePK: Securityprofile primary key
     * @return Securityprofile object
     * @throws DBException
     */
    public Securityprofile getSecurityprofile(ISecurityprofilePK securityprofilePK) throws DBException {
        return (Securityprofile)super.getEntity((SecurityprofilePK)securityprofilePK);
    }

    /**
     * search securityprofile with ISecurityprofilesearch parameters
     * @param search ISecurityprofilesearch
     * @return ArrayList of Securityprofile
     * @throws DBException 
     */
    public ArrayList<Securityprofile> searchsecurityprofiles(ISecurityprofilesearch search) throws DBException {
        return (ArrayList<Securityprofile>)this.search(search);
    }

    /**
     * search securityprofile with ISecurityprofilesearch parameters, order by orderby sql clause
     * @param search ISecurityprofilesearch
     * @param orderby sql order by string
     * @return ArrayList of Securityprofile
     * @throws DBException 
     */
    public ArrayList<Securityprofile> searchsecurityprofiles(ISecurityprofilesearch search, String orderby) throws DBException {
        return (ArrayList<Securityprofile>)this.search(search, orderby);
    }

    /**
     * Search securityprofile in database for securityprofilePK:
     * @param securityprofilePK: Securityprofile Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurityprofileExists(ISecurityprofilePK securityprofilePK) throws DBException {
        return super.getEntityExists((SecurityprofilePK)securityprofilePK);
    }

    /**
     * try to insert Securityprofile in database
     * @param securityprofile Securityprofile object
     * @throws DBException
     * @throws DataException
     */
    public void insertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        super.insertEntity(securityprofile);
    }

    /**
     * check if SecurityprofilePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param securityprofile Securityprofile object
     * @throws DBException
     * @throws DataException
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
     * @param securityprofile Securityprofile object
     * @throws DBException
     * @throws DataException
     */
    public void updateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        super.updateEntity(securityprofile);
    }

    /**
     * try to delete Securityprofile in database
     * @param securityprofile Securityprofile object
     * @throws DBException
     */
    public void deleteSecurityprofile(ISecurityprofile securityprofile) throws DBException {
        cascadedeleteSecurityprofile(securityprofile.getPrimaryKey());
        super.deleteEntity(securityprofile);
    }

    /**
     * check data rules in Securityprofile, throw DataException with customized message if rules do not apply
     * @param securityprofile Securityprofile object
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
    public void cascadedeleteSecurityprofile(ISecurityprofilePK securityprofilePK) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile(this);
        blsecurityuserprofile.delete4securityprofile(securityprofilePK);
    }

    /**
     * @param securityuserprofilePK: parent Securityuserprofile for child object Securityprofile Entity
     * @return child Securityprofile Entity object
     * @throws CustomException
     */
    public Securityprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws CustomException {
        SecurityprofilePK securityprofilePK = new SecurityprofilePK(securityuserprofilePK.getUserprofile());
        return this.getSecurityprofile(securityprofilePK);
    }


    /**
     * get all Securityprofile objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Securityprofile objects
     * @throws DBException
     */
    public ArrayList<Securityprofile> getSecurityprofiles(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurityprofile.SQLSelect);
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
        return (ArrayList<Securityprofile>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Securityprofile objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSecurityprofile(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Securityprofile.table);
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
