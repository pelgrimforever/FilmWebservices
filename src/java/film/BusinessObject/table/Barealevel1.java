/*
 * Barealevel1.java
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
import film.conversion.json.JSONArealevel1;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel1search;
import film.logicentity.Arealevel1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Barealevel1
 *
 * Superclass for manipulating data- and database objects
 * for Entity Arealevel1 and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Barealevel1 extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Arealevel1 as default Entity
     */
    public Barealevel1() {
        super(new SQLMapper_pgsql(connectionpool, "Arealevel1"), new Arealevel1());
    }

    /**
     * Constructor, sets Arealevel1 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel1(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Arealevel1());
    }

    /**
     * Map ResultSet Field values to Arealevel1
     * @param dbresult: Database ResultSet
     */
    public Arealevel1 mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel1PK arealevel1PK = null;
        Arealevel1 arealevel1;
        if(dbresult==null) {
            arealevel1 = new Arealevel1(arealevel1PK);
        } else {
            try {
                arealevel1PK = new Arealevel1PK(dbresult.getString("countrycode"), dbresult.getString("al1code"));
                arealevel1 = new Arealevel1(arealevel1PK);
                arealevel1.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    arealevel1.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    arealevel1.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    arealevel1.initViewport(c_viewport.abstractclone());
                }
                arealevel1.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, arealevel1);
        return arealevel1;
    }

    /**
     * create new empty Arealevel1 object
     * @return empty IArealevel1
     */
    public IArealevel1 newArealevel1() {
    	return new Arealevel1();
    }
    
    /**
     * create new empty Arealevel1 object
     * create new primary key with given parameters
     * @return IArealevel1 with primary key
     */
    public IArealevel1 newArealevel1(java.lang.String countrycode, java.lang.String al1code) {
        return new Arealevel1(countrycode, al1code);
    }

    /**
     * create new empty Arealevel1 object with given primary key
     * @param arealevel1PK: primary key for Arealevel1
     * @return IArealevel1 with primary key
     */
    public IArealevel1 newArealevel1(IArealevel1PK arealevel1PK) {
        return new Arealevel1((Arealevel1PK)arealevel1PK);
    }

    /**
     * create new empty primary key
     * @return empty Arealevel1PK
     */
    public IArealevel1PK newArealevel1PK() {
        return new Arealevel1PK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArealevel1PK
     */
    public IArealevel1PK newArealevel1PK(java.lang.String countrycode, java.lang.String al1code) {
        return new Arealevel1PK(countrycode, al1code);
    }

    /**
     * get all Arealevel1 objects from database
     * @return ArrayList of Arealevel1 objects
     * @throws DBException
     */
    public ArrayList getArealevel1s() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel1.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Arealevel1 for primary key
     * @param arealevel1PK: Arealevel1 primary key
     * @return Arealevel1 object
     * @throws DBException
     */
    public Arealevel1 getArealevel1(IArealevel1PK arealevel1PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Arealevel1)super.getEntity((Arealevel1PK)arealevel1PK);
        } else return null;
    }

    public ArrayList searcharealevel1s(IArealevel1search search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searcharealevel1s(IArealevel1search search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search arealevel1 in database for arealevel1PK:
     * @param arealevel1PK: Arealevel1 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel1Exists(IArealevel1PK arealevel1PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Arealevel1PK)arealevel1PK);
        } else return false;
    }

    /**
     * try to insert Arealevel1 in database
     * @param film: Arealevel1 object
     * @throws DBException
     */
    public void insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(arealevel1);
        }
    }

    /**
     * check if Arealevel1PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Arealevel1 object
     * @throws DBException
     */
    public void insertupdateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(this.getArealevel1Exists(arealevel1.getPrimaryKey())) {
            super.updateEntity(arealevel1);
        } else {
            super.insertEntity(arealevel1);
        }
    }

    /**
     * try to update Arealevel1 in database
     * @param film: Arealevel1 object
     * @throws DBException
     */
    public void updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(arealevel1);
        }
    }

    /**
     * try to delete Arealevel1 in database
     * @param film: Arealevel1 object
     * @throws DBException
     */
    public void deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArealevel1(arealevel1.getOwnerobject(), arealevel1.getPrimaryKey());
            super.deleteEntity(arealevel1);
        }
    }

    /**
     * check data rules in Arealevel1, throw DataException with customized message if rules do not apply
     * @param film: Arealevel1 object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArealevel1 arealevel1) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel1.Countrycode - Country.Code
        //Primary key
        if(arealevel1.getName()!=null && arealevel1.getName().length()>IArealevel1.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IArealevel1.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel1PK is used in a primary key
     * @param arealevel1PK: Arealevel1 primary key
     */
    public void cascadedeleteArealevel1(String senderobject, IArealevel1PK arealevel1PK) {
        BLarealevel2 blarealevel2 = new BLarealevel2(this);
        blarealevel2.delete4arealevel1(senderobject, arealevel1PK);
    }

    /**
     * @param countryPK: foreign key for Country
     * @delete all Arealevel1 Entity objects for Country in database
     * @throws film.general.exception.CustomException
     */
    public void delete4country(String senderobject, ICountryPK countryPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Arealevel1.SQLDelete4country, countryPK.getKeyFields());
        }
    }

    /**
     * @param countryPK: foreign key for Country
     * @return all Arealevel1 Entity objects for Country
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel1.SQLSelect4country, countryPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param arealevel2PK: parent Arealevel2 for child object Arealevel1 Entity
     * @return child Arealevel1 Entity object
     * @throws film.general.exception.CustomException
     */
    public IArealevel1 getArealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            Arealevel1PK arealevel1PK = new Arealevel1PK(arealevel2PK.getCountrycode(), arealevel2PK.getAl1code());
            return this.getArealevel1(arealevel1PK);
        } else return null;
    }


    /**
     * get all Arealevel1 objects for sqlparameters
     * @return ArrayList of Arealevel1 objects
     * @throws DBException
     */
    public ArrayList getArealevel1s(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Arealevel1.SQLSelect;
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
     * delete all Arealevel1 objects for sqlparameters
     * @throws DBException
     */
    public void delArealevel1(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Arealevel1.table;
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
