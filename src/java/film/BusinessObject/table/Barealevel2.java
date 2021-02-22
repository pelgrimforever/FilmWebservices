/*
 * Barealevel2.java
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
import film.conversion.json.JSONArealevel2;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel2search;
import film.logicentity.Arealevel2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Barealevel2
 *
 * Superclass for manipulating data- and database objects
 * for Entity Arealevel2 and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Barealevel2 extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Arealevel2 as default Entity
     */
    public Barealevel2() {
        super(new SQLMapper_pgsql(connectionpool, "Arealevel2"), new Arealevel2());
    }

    /**
     * Constructor, sets Arealevel2 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel2(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Arealevel2());
    }

    /**
     * Map ResultSet Field values to Arealevel2
     * @param dbresult: Database ResultSet
     */
    public Arealevel2 mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel2PK arealevel2PK = null;
        Arealevel2 arealevel2;
        if(dbresult==null) {
            arealevel2 = new Arealevel2(arealevel2PK);
        } else {
            try {
                arealevel2PK = new Arealevel2PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"));
                arealevel2 = new Arealevel2(arealevel2PK);
                arealevel2.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    arealevel2.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    arealevel2.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    arealevel2.initViewport(c_viewport.abstractclone());
                }
                arealevel2.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, arealevel2);
        return arealevel2;
    }

    /**
     * create new empty Arealevel2 object
     * @return empty IArealevel2
     */
    public IArealevel2 newArealevel2() {
    	return new Arealevel2();
    }
    
    /**
     * create new empty Arealevel2 object
     * create new primary key with given parameters
     * @return IArealevel2 with primary key
     */
    public IArealevel2 newArealevel2(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code) {
        return new Arealevel2(countrycode, al1code, al2code);
    }

    /**
     * create new empty Arealevel2 object with given primary key
     * @param arealevel2PK: primary key for Arealevel2
     * @return IArealevel2 with primary key
     */
    public IArealevel2 newArealevel2(IArealevel2PK arealevel2PK) {
        return new Arealevel2((Arealevel2PK)arealevel2PK);
    }

    /**
     * create new empty primary key
     * @return empty Arealevel2PK
     */
    public IArealevel2PK newArealevel2PK() {
        return new Arealevel2PK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArealevel2PK
     */
    public IArealevel2PK newArealevel2PK(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code) {
        return new Arealevel2PK(countrycode, al1code, al2code);
    }

    /**
     * get all Arealevel2 objects from database
     * @return ArrayList of Arealevel2 objects
     * @throws DBException
     */
    public ArrayList getArealevel2s() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel2.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Arealevel2 for primary key
     * @param arealevel2PK: Arealevel2 primary key
     * @return Arealevel2 object
     * @throws DBException
     */
    public Arealevel2 getArealevel2(IArealevel2PK arealevel2PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Arealevel2)super.getEntity((Arealevel2PK)arealevel2PK);
        } else return null;
    }

    public ArrayList searcharealevel2s(IArealevel2search search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searcharealevel2s(IArealevel2search search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search arealevel2 in database for arealevel2PK:
     * @param arealevel2PK: Arealevel2 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel2Exists(IArealevel2PK arealevel2PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Arealevel2PK)arealevel2PK);
        } else return false;
    }

    /**
     * try to insert Arealevel2 in database
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void insertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(arealevel2);
        }
    }

    /**
     * check if Arealevel2PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void insertupdateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(this.getArealevel2Exists(arealevel2.getPrimaryKey())) {
            super.updateEntity(arealevel2);
        } else {
            super.insertEntity(arealevel2);
        }
    }

    /**
     * try to update Arealevel2 in database
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void updateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(arealevel2);
        }
    }

    /**
     * try to delete Arealevel2 in database
     * @param film: Arealevel2 object
     * @throws DBException
     */
    public void deleteArealevel2(IArealevel2 arealevel2) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArealevel2(arealevel2.getOwnerobject(), arealevel2.getPrimaryKey());
            super.deleteEntity(arealevel2);
        }
    }

    /**
     * check data rules in Arealevel2, throw DataException with customized message if rules do not apply
     * @param film: Arealevel2 object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArealevel2 arealevel2) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel2.Countrycode - Arealevel1.Countrycode
        //foreign key Arealevel2.Al1code - Arealevel1.Al1code
        //Primary key
        if(arealevel2.getName()!=null && arealevel2.getName().length()>IArealevel2.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IArealevel2.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel2PK is used in a primary key
     * @param arealevel2PK: Arealevel2 primary key
     */
    public void cascadedeleteArealevel2(String senderobject, IArealevel2PK arealevel2PK) {
        BLarealevel3 blarealevel3 = new BLarealevel3(this);
        blarealevel3.delete4arealevel2(senderobject, arealevel2PK);
    }

    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @delete all Arealevel2 Entity objects for Arealevel1 in database
     * @throws film.general.exception.CustomException
     */
    public void delete4arealevel1(String senderobject, IArealevel1PK arealevel1PK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Arealevel2.SQLDelete4arealevel1, arealevel1PK.getKeyFields());
        }
    }

    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @return all Arealevel2 Entity objects for Arealevel1
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArealevel2s4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel2.SQLSelect4arealevel1, arealevel1PK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param arealevel3PK: parent Arealevel3 for child object Arealevel2 Entity
     * @return child Arealevel2 Entity object
     * @throws film.general.exception.CustomException
     */
    public IArealevel2 getArealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            Arealevel2PK arealevel2PK = new Arealevel2PK(arealevel3PK.getCountrycode(), arealevel3PK.getAl1code(), arealevel3PK.getAl2code());
            return this.getArealevel2(arealevel2PK);
        } else return null;
    }


    /**
     * get all Arealevel2 objects for sqlparameters
     * @return ArrayList of Arealevel2 objects
     * @throws DBException
     */
    public ArrayList getArealevel2s(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Arealevel2.SQLSelect;
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
     * delete all Arealevel2 objects for sqlparameters
     * @throws DBException
     */
    public void delArealevel2(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Arealevel2.table;
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
