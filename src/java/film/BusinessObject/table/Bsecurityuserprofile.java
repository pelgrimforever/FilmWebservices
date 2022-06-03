/*
 * Bsecurityuserprofile.java
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
import film.conversion.json.JSONSecurityuserprofile;
import film.conversion.entity.EMsecurityuserprofile;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bsecurityuserprofile extends BLtable {

    /**
     * Constructor, sets Securityuserprofile as default Entity
     */
    public Bsecurityuserprofile() {
        super(new Securityuserprofile(), new EMsecurityuserprofile());
    }

    /**
     * Constructor, sets Securityuserprofile as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsecurityuserprofile(BLtable transactionobject) {
        super(transactionobject, new Securityuserprofile(), new EMsecurityuserprofile());
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
     * @param siteusername primary key field
     * @param userprofile primary key field
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
     * @param siteusername primary key field
     * @param userprofile primary key field
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
    public ArrayList<Securityuserprofile> getSecurityuserprofiles() throws DBException {
        return (ArrayList<Securityuserprofile>)super.getEntities(EMsecurityuserprofile.SQLSelectAll);
    }

    /**
     * search Securityuserprofile for primary key
     * @param securityuserprofilePK: Securityuserprofile primary key
     * @return Securityuserprofile object
     * @throws DBException
     */
    public Securityuserprofile getSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return (Securityuserprofile)super.getEntity((SecurityuserprofilePK)securityuserprofilePK);
    }

    /**
     * search securityuserprofile with ISecurityuserprofilesearch parameters
     * @param search ISecurityuserprofilesearch
     * @return ArrayList of Securityuserprofile
     * @throws DBException 
     */
    public ArrayList<Securityuserprofile> searchsecurityuserprofiles(ISecurityuserprofilesearch search) throws DBException {
        return (ArrayList<Securityuserprofile>)this.search(search);
    }

    /**
     * search securityuserprofile with ISecurityuserprofilesearch parameters, order by orderby sql clause
     * @param search ISecurityuserprofilesearch
     * @param orderby sql order by string
     * @return ArrayList of Securityuserprofile
     * @throws DBException 
     */
    public ArrayList<Securityuserprofile> searchsecurityuserprofiles(ISecurityuserprofilesearch search, String orderby) throws DBException {
        return (ArrayList<Securityuserprofile>)this.search(search, orderby);
    }

    /**
     * Search securityuserprofile in database for securityuserprofilePK:
     * @param securityuserprofilePK: Securityuserprofile Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSecurityuserprofileExists(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return super.getEntityExists((SecurityuserprofilePK)securityuserprofilePK);
    }

    /**
     * try to insert Securityuserprofile in database
     * @param securityuserprofile Securityuserprofile object
     * @throws DBException
     * @throws DataException
     */
    public void insertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        super.insertEntity(securityuserprofile);
    }

    /**
     * check if SecurityuserprofilePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param securityuserprofile Securityuserprofile object
     * @throws DBException
     * @throws DataException
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
     * @param securityuserprofile Securityuserprofile object
     * @throws DBException
     * @throws DataException
     */
    public void updateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        super.updateEntity(securityuserprofile);
    }

    /**
     * try to delete Securityuserprofile in database
     * @param securityuserprofile Securityuserprofile object
     * @throws DBException
     */
    public void deleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException {
        cascadedeleteSecurityuserprofile(securityuserprofile.getPrimaryKey());
        super.deleteEntity(securityuserprofile);
    }

    /**
     * check data rules in Securityuserprofile, throw DataException with customized message if rules do not apply
     * @param securityuserprofile Securityuserprofile object
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
    public void cascadedeleteSecurityuserprofile(ISecurityuserprofilePK securityuserprofilePK) {
    }

    /**
     * @param securityprofilePK: foreign key for Securityprofile
     * @delete all Securityuserprofile Entity objects for Securityprofile in database
     */
    public void delete4securityprofile(ISecurityprofilePK securityprofilePK) {
        super.addStatement(EMsecurityuserprofile.SQLDelete4securityprofile, securityprofilePK.getSQLprimarykey());
    }

    /**
     * @param securityprofilePK: foreign key for Securityprofile
     * @return all Securityuserprofile Entity objects for Securityprofile
     * @throws CustomException
     */
    public ArrayList<Securityuserprofile> getSecurityuserprofiles4securityprofile(ISecurityprofilePK securityprofilePK) throws CustomException {
        return super.getEntities(EMsecurityuserprofile.SQLSelect4securityprofile, securityprofilePK.getSQLprimarykey());
    }

    /**
     * get all Securityuserprofile objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Securityuserprofile objects
     * @throws DBException
     */
    public ArrayList<Securityuserprofile> getSecurityuserprofiles(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsecurityuserprofile.SQLSelect);
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
        return (ArrayList<Securityuserprofile>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Securityuserprofile objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSecurityuserprofile(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Securityuserprofile.table);
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
