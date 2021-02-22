/*
 * Barealevel3.java
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
import film.conversion.json.JSONArealevel3;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IArealevel3search;
import film.logicentity.Arealevel3;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Barealevel3
 *
 * Superclass for manipulating data- and database objects
 * for Entity Arealevel3 and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Barealevel3 extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Arealevel3 as default Entity
     */
    public Barealevel3() {
        super(new SQLMapper_pgsql(connectionpool, "Arealevel3"), new Arealevel3());
    }

    /**
     * Constructor, sets Arealevel3 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel3(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Arealevel3());
    }

    /**
     * Map ResultSet Field values to Arealevel3
     * @param dbresult: Database ResultSet
     */
    public Arealevel3 mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel3PK arealevel3PK = null;
        Arealevel3 arealevel3;
        if(dbresult==null) {
            arealevel3 = new Arealevel3(arealevel3PK);
        } else {
            try {
                arealevel3PK = new Arealevel3PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"), dbresult.getString("al3code"));
                arealevel3 = new Arealevel3(arealevel3PK);
                arealevel3.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    arealevel3.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    arealevel3.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    arealevel3.initViewport(c_viewport.abstractclone());
                }
                arealevel3.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, arealevel3);
        return arealevel3;
    }

    /**
     * create new empty Arealevel3 object
     * @return empty IArealevel3
     */
    public IArealevel3 newArealevel3() {
    	return new Arealevel3();
    }
    
    /**
     * create new empty Arealevel3 object
     * create new primary key with given parameters
     * @return IArealevel3 with primary key
     */
    public IArealevel3 newArealevel3(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code, java.lang.String al3code) {
        return new Arealevel3(countrycode, al1code, al2code, al3code);
    }

    /**
     * create new empty Arealevel3 object with given primary key
     * @param arealevel3PK: primary key for Arealevel3
     * @return IArealevel3 with primary key
     */
    public IArealevel3 newArealevel3(IArealevel3PK arealevel3PK) {
        return new Arealevel3((Arealevel3PK)arealevel3PK);
    }

    /**
     * create new empty primary key
     * @return empty Arealevel3PK
     */
    public IArealevel3PK newArealevel3PK() {
        return new Arealevel3PK();
    }

    /**
     * create new primary key with given parameters
     * @return new IArealevel3PK
     */
    public IArealevel3PK newArealevel3PK(java.lang.String countrycode, java.lang.String al1code, java.lang.String al2code, java.lang.String al3code) {
        return new Arealevel3PK(countrycode, al1code, al2code, al3code);
    }

    /**
     * get all Arealevel3 objects from database
     * @return ArrayList of Arealevel3 objects
     * @throws DBException
     */
    public ArrayList getArealevel3s() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel3.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Arealevel3 for primary key
     * @param arealevel3PK: Arealevel3 primary key
     * @return Arealevel3 object
     * @throws DBException
     */
    public Arealevel3 getArealevel3(IArealevel3PK arealevel3PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Arealevel3)super.getEntity((Arealevel3PK)arealevel3PK);
        } else return null;
    }

    public ArrayList searcharealevel3s(IArealevel3search search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searcharealevel3s(IArealevel3search search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search arealevel3 in database for arealevel3PK:
     * @param arealevel3PK: Arealevel3 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel3Exists(IArealevel3PK arealevel3PK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((Arealevel3PK)arealevel3PK);
        } else return false;
    }

    /**
     * try to insert Arealevel3 in database
     * @param film: Arealevel3 object
     * @throws DBException
     */
    public void insertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(arealevel3);
        }
    }

    /**
     * check if Arealevel3PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Arealevel3 object
     * @throws DBException
     */
    public void insertupdateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(this.getArealevel3Exists(arealevel3.getPrimaryKey())) {
            super.updateEntity(arealevel3);
        } else {
            super.insertEntity(arealevel3);
        }
    }

    /**
     * try to update Arealevel3 in database
     * @param film: Arealevel3 object
     * @throws DBException
     */
    public void updateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(arealevel3);
        }
    }

    /**
     * try to delete Arealevel3 in database
     * @param film: Arealevel3 object
     * @throws DBException
     */
    public void deleteArealevel3(IArealevel3 arealevel3) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteArealevel3(arealevel3.getOwnerobject(), arealevel3.getPrimaryKey());
            super.deleteEntity(arealevel3);
        }
    }

    /**
     * check data rules in Arealevel3, throw DataException with customized message if rules do not apply
     * @param film: Arealevel3 object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArealevel3 arealevel3) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel3.Countrycode - Arealevel2.Countrycode
        //foreign key Arealevel3.Al1code - Arealevel2.Al1code
        //foreign key Arealevel3.Al2code - Arealevel2.Al2code
        //Primary key
        if(arealevel3.getName()!=null && arealevel3.getName().length()>IArealevel3.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + IArealevel3.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel3PK is used in a primary key
     * @param arealevel3PK: Arealevel3 primary key
     */
    public void cascadedeleteArealevel3(String senderobject, IArealevel3PK arealevel3PK) {
    }

    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @delete all Arealevel3 Entity objects for Arealevel2 in database
     * @throws film.general.exception.CustomException
     */
    public void delete4arealevel2(String senderobject, IArealevel2PK arealevel2PK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Arealevel3.SQLDelete4arealevel2, arealevel2PK.getKeyFields());
        }
    }

    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @return all Arealevel3 Entity objects for Arealevel2
     * @throws film.general.exception.CustomException
     */
    public ArrayList getArealevel3s4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Arealevel3.SQLSelect4arealevel2, arealevel2PK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Arealevel3 objects for sqlparameters
     * @return ArrayList of Arealevel3 objects
     * @throws DBException
     */
    public ArrayList getArealevel3s(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Arealevel3.SQLSelect;
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
     * delete all Arealevel3 objects for sqlparameters
     * @throws DBException
     */
    public void delArealevel3(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Arealevel3.table;
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
