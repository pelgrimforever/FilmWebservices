/*
 * Blocality.java
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
import film.conversion.json.JSONLocality;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ILocalitysearch;
import film.logicentity.Locality;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Blocality
 *
 * Superclass for manipulating data- and database objects
 * for Entity Locality and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Blocality extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Locality as default Entity
     */
    public Blocality() {
        super(new SQLMapper_pgsql(connectionpool, "Locality"), new Locality());
    }

    /**
     * Constructor, sets Locality as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Blocality(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Locality());
    }

    /**
     * Map ResultSet Field values to Locality
     * @param dbresult: Database ResultSet
     */
    public Locality mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        LocalityPK localityPK = null;
        Locality locality;
        if(dbresult==null) {
            locality = new Locality(localityPK);
        } else {
            try {
                localityPK = new LocalityPK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"));
                locality = new Locality(localityPK);
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    locality.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    locality.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    locality.initViewport(c_viewport.abstractclone());
                }
                locality.initApproximate(dbresult.getBoolean("approximate"));
                locality.initHassublocality(dbresult.getBoolean("hassublocality"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, locality);
        return locality;
    }

    /**
     * create new empty Locality object
     * @return empty ILocality
     */
    public ILocality newLocality() {
    	return new Locality();
    }
    
    /**
     * create new empty Locality object
     * create new primary key with given parameters
     * @return ILocality with primary key
     */
    public ILocality newLocality(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality) {
        return new Locality(countrycode, postalcode, locality);
    }

    /**
     * create new empty Locality object with given primary key
     * @param localityPK: primary key for Locality
     * @return ILocality with primary key
     */
    public ILocality newLocality(ILocalityPK localityPK) {
        return new Locality((LocalityPK)localityPK);
    }

    /**
     * create new empty primary key
     * @return empty LocalityPK
     */
    public ILocalityPK newLocalityPK() {
        return new LocalityPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ILocalityPK
     */
    public ILocalityPK newLocalityPK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality) {
        return new LocalityPK(countrycode, postalcode, locality);
    }

    /**
     * get all Locality objects from database
     * @return ArrayList of Locality objects
     * @throws DBException
     */
    public ArrayList getLocalitys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Locality.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Locality for primary key
     * @param localityPK: Locality primary key
     * @return Locality object
     * @throws DBException
     */
    public Locality getLocality(ILocalityPK localityPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Locality)super.getEntity((LocalityPK)localityPK);
        } else return null;
    }

    public ArrayList searchlocalitys(ILocalitysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchlocalitys(ILocalitysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search locality in database for localityPK:
     * @param localityPK: Locality Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getLocalityExists(ILocalityPK localityPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((LocalityPK)localityPK);
        } else return false;
    }

    /**
     * try to insert Locality in database
     * @param film: Locality object
     * @throws DBException
     */
    public void insertLocality(ILocality locality) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(locality);
        }
    }

    /**
     * check if LocalityPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Locality object
     * @throws DBException
     */
    public void insertupdateLocality(ILocality locality) throws DBException, DataException {
        if(this.getLocalityExists(locality.getPrimaryKey())) {
            super.updateEntity(locality);
        } else {
            super.insertEntity(locality);
        }
    }

    /**
     * try to update Locality in database
     * @param film: Locality object
     * @throws DBException
     */
    public void updateLocality(ILocality locality) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(locality);
        }
    }

    /**
     * try to delete Locality in database
     * @param film: Locality object
     * @throws DBException
     */
    public void deleteLocality(ILocality locality) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteLocality(locality.getOwnerobject(), locality.getPrimaryKey());
            super.deleteEntity(locality);
        }
    }

    /**
     * check data rules in Locality, throw DataException with customized message if rules do not apply
     * @param film: Locality object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ILocality locality) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Locality.Countrycode - Postalcode.Countrycode
        //foreign key Locality.Postalcode - Postalcode.Postalcode
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where localityPK is used in a primary key
     * @param localityPK: Locality primary key
     */
    public void cascadedeleteLocality(String senderobject, ILocalityPK localityPK) {
        BLsublocality blsublocality = new BLsublocality(this);
        blsublocality.delete4locality(senderobject, localityPK);
    }

    /**
     * @param postalcodePK: foreign key for Postalcode
     * @delete all Locality Entity objects for Postalcode in database
     * @throws film.general.exception.CustomException
     */
    public void delete4postalcode(String senderobject, IPostalcodePK postalcodePK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Locality.SQLDelete4postalcode, postalcodePK.getKeyFields());
        }
    }

    /**
     * @param postalcodePK: foreign key for Postalcode
     * @return all Locality Entity objects for Postalcode
     * @throws film.general.exception.CustomException
     */
    public ArrayList getLocalitys4postalcode(IPostalcodePK postalcodePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Locality.SQLSelect4postalcode, postalcodePK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param sublocalityPK: parent Sublocality for child object Locality Entity
     * @return child Locality Entity object
     * @throws film.general.exception.CustomException
     */
    public ILocality getSublocality(ISublocalityPK sublocalityPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            LocalityPK localityPK = new LocalityPK(sublocalityPK.getCountrycode(), sublocalityPK.getPostalcode(), sublocalityPK.getLocality());
            return this.getLocality(localityPK);
        } else return null;
    }


    /**
     * get all Locality objects for sqlparameters
     * @return ArrayList of Locality objects
     * @throws DBException
     */
    public ArrayList getLocalitys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Locality.SQLSelect;
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
     * delete all Locality objects for sqlparameters
     * @throws DBException
     */
    public void delLocality(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Locality.table;
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
