/*
 * Bsublocality.java
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
import film.conversion.json.JSONSublocality;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISublocalitysearch;
import film.logicentity.Sublocality;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bsublocality
 *
 * Superclass for manipulating data- and database objects
 * for Entity Sublocality and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsublocality extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Sublocality as default Entity
     */
    public Bsublocality() {
        super(new SQLMapper_pgsql(connectionpool, "Sublocality"), new Sublocality());
    }

    /**
     * Constructor, sets Sublocality as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsublocality(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Sublocality());
    }

    /**
     * Map ResultSet Field values to Sublocality
     * @param dbresult: Database ResultSet
     */
    public Sublocality mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SublocalityPK sublocalityPK = null;
        Sublocality sublocality;
        if(dbresult==null) {
            sublocality = new Sublocality(sublocalityPK);
        } else {
            try {
                sublocalityPK = new SublocalityPK(dbresult.getString("countrycode"), dbresult.getString("postalcode"), dbresult.getString("locality"), dbresult.getString("sublocality"));
                sublocality = new Sublocality(sublocalityPK);
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    sublocality.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    sublocality.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    sublocality.initViewport(c_viewport.abstractclone());
                }
                sublocality.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, sublocality);
        return sublocality;
    }

    /**
     * create new empty Sublocality object
     * @return empty ISublocality
     */
    public ISublocality newSublocality() {
    	return new Sublocality();
    }
    
    /**
     * create new empty Sublocality object
     * create new primary key with given parameters
     * @return ISublocality with primary key
     */
    public ISublocality newSublocality(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality) {
        return new Sublocality(countrycode, postalcode, locality, sublocality);
    }

    /**
     * create new empty Sublocality object with given primary key
     * @param sublocalityPK: primary key for Sublocality
     * @return ISublocality with primary key
     */
    public ISublocality newSublocality(ISublocalityPK sublocalityPK) {
        return new Sublocality((SublocalityPK)sublocalityPK);
    }

    /**
     * create new empty primary key
     * @return empty SublocalityPK
     */
    public ISublocalityPK newSublocalityPK() {
        return new SublocalityPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ISublocalityPK
     */
    public ISublocalityPK newSublocalityPK(java.lang.String countrycode, java.lang.String postalcode, java.lang.String locality, java.lang.String sublocality) {
        return new SublocalityPK(countrycode, postalcode, locality, sublocality);
    }

    /**
     * get all Sublocality objects from database
     * @return ArrayList of Sublocality objects
     * @throws DBException
     */
    public ArrayList getSublocalitys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Sublocality.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Sublocality for primary key
     * @param sublocalityPK: Sublocality primary key
     * @return Sublocality object
     * @throws DBException
     */
    public Sublocality getSublocality(ISublocalityPK sublocalityPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Sublocality)super.getEntity((SublocalityPK)sublocalityPK);
        } else return null;
    }

    public ArrayList searchsublocalitys(ISublocalitysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsublocalitys(ISublocalitysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search sublocality in database for sublocalityPK:
     * @param sublocalityPK: Sublocality Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSublocalityExists(ISublocalityPK sublocalityPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SublocalityPK)sublocalityPK);
        } else return false;
    }

    /**
     * try to insert Sublocality in database
     * @param film: Sublocality object
     * @throws DBException
     */
    public void insertSublocality(ISublocality sublocality) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(sublocality);
        }
    }

    /**
     * check if SublocalityPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Sublocality object
     * @throws DBException
     */
    public void insertupdateSublocality(ISublocality sublocality) throws DBException, DataException {
        if(this.getSublocalityExists(sublocality.getPrimaryKey())) {
            super.updateEntity(sublocality);
        } else {
            super.insertEntity(sublocality);
        }
    }

    /**
     * try to update Sublocality in database
     * @param film: Sublocality object
     * @throws DBException
     */
    public void updateSublocality(ISublocality sublocality) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(sublocality);
        }
    }

    /**
     * try to delete Sublocality in database
     * @param film: Sublocality object
     * @throws DBException
     */
    public void deleteSublocality(ISublocality sublocality) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSublocality(sublocality.getOwnerobject(), sublocality.getPrimaryKey());
            super.deleteEntity(sublocality);
        }
    }

    /**
     * check data rules in Sublocality, throw DataException with customized message if rules do not apply
     * @param film: Sublocality object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISublocality sublocality) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Sublocality.Countrycode - Locality.Countrycode
        //foreign key Sublocality.Postalcode - Locality.Postalcode
        //foreign key Sublocality.Locality - Locality.Locality
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where sublocalityPK is used in a primary key
     * @param sublocalityPK: Sublocality primary key
     */
    public void cascadedeleteSublocality(String senderobject, ISublocalityPK sublocalityPK) {
        BLroute blroute = new BLroute(this);
        blroute.delete4sublocality(senderobject, sublocalityPK);
    }

    /**
     * @param localityPK: foreign key for Locality
     * @delete all Sublocality Entity objects for Locality in database
     * @throws film.general.exception.CustomException
     */
    public void delete4locality(String senderobject, ILocalityPK localityPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Sublocality.SQLDelete4locality, localityPK.getKeyFields());
        }
    }

    /**
     * @param localityPK: foreign key for Locality
     * @return all Sublocality Entity objects for Locality
     * @throws film.general.exception.CustomException
     */
    public ArrayList getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Sublocality.SQLSelect4locality, localityPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param routePK: parent Route for child object Sublocality Entity
     * @return child Sublocality Entity object
     * @throws film.general.exception.CustomException
     */
    public ISublocality getRoute(IRoutePK routePK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SublocalityPK sublocalityPK = new SublocalityPK(routePK.getCountrycode(), routePK.getPostalcode(), routePK.getLocality(), routePK.getSublocality());
            return this.getSublocality(sublocalityPK);
        } else return null;
    }


    /**
     * get all Sublocality objects for sqlparameters
     * @return ArrayList of Sublocality objects
     * @throws DBException
     */
    public ArrayList getSublocalitys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Sublocality.SQLSelect;
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
     * delete all Sublocality objects for sqlparameters
     * @throws DBException
     */
    public void delSublocality(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Sublocality.table;
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
