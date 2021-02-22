/*
 * Bcountry.java
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
import film.conversion.json.JSONCountry;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ICountrysearch;
import film.logicentity.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bcountry
 *
 * Superclass for manipulating data- and database objects
 * for Entity Country and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcountry extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Country as default Entity
     */
    public Bcountry() {
        super(new SQLMapper_pgsql(connectionpool, "Country"), new Country());
    }

    /**
     * Constructor, sets Country as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcountry(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Country());
    }

    /**
     * Map ResultSet Field values to Country
     * @param dbresult: Database ResultSet
     */
    public Country mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CountryPK countryPK = null;
        Country country;
        if(dbresult==null) {
            country = new Country(countryPK);
        } else {
            try {
                countryPK = new CountryPK(dbresult.getString("code"));
                country = new Country(countryPK);
                country.initName(dbresult.getString("name"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    country.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    country.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    country.initViewport(c_viewport.abstractclone());
                }
                country.initApproximate(dbresult.getBoolean("approximate"));
                country.initHasarealevel1(dbresult.getBoolean("hasarealevel1"));
                country.initHasarealevel2(dbresult.getBoolean("hasarealevel2"));
                country.initHasarealevel3(dbresult.getBoolean("hasarealevel3"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, country);
        return country;
    }

    /**
     * create new empty Country object
     * @return empty ICountry
     */
    public ICountry newCountry() {
    	return new Country();
    }
    
    /**
     * create new empty Country object
     * create new primary key with given parameters
     * @return ICountry with primary key
     */
    public ICountry newCountry(java.lang.String code) {
        return new Country(code);
    }

    /**
     * create new empty Country object with given primary key
     * @param countryPK: primary key for Country
     * @return ICountry with primary key
     */
    public ICountry newCountry(ICountryPK countryPK) {
        return new Country((CountryPK)countryPK);
    }

    /**
     * create new empty primary key
     * @return empty CountryPK
     */
    public ICountryPK newCountryPK() {
        return new CountryPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ICountryPK
     */
    public ICountryPK newCountryPK(java.lang.String code) {
        return new CountryPK(code);
    }

    /**
     * get all Country objects from database
     * @return ArrayList of Country objects
     * @throws DBException
     */
    public ArrayList getCountrys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Country.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Country for primary key
     * @param countryPK: Country primary key
     * @return Country object
     * @throws DBException
     */
    public Country getCountry(ICountryPK countryPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Country)super.getEntity((CountryPK)countryPK);
        } else return null;
    }

    public ArrayList searchcountrys(ICountrysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchcountrys(ICountrysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search country in database for countryPK:
     * @param countryPK: Country Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCountryExists(ICountryPK countryPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((CountryPK)countryPK);
        } else return false;
    }

    /**
     * try to insert Country in database
     * @param film: Country object
     * @throws DBException
     */
    public void insertCountry(ICountry country) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(country);
        }
    }

    /**
     * check if CountryPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Country object
     * @throws DBException
     */
    public void insertupdateCountry(ICountry country) throws DBException, DataException {
        if(this.getCountryExists(country.getPrimaryKey())) {
            super.updateEntity(country);
        } else {
            super.insertEntity(country);
        }
    }

    /**
     * try to update Country in database
     * @param film: Country object
     * @throws DBException
     */
    public void updateCountry(ICountry country) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(country);
        }
    }

    /**
     * try to delete Country in database
     * @param film: Country object
     * @throws DBException
     */
    public void deleteCountry(ICountry country) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteCountry(country.getOwnerobject(), country.getPrimaryKey());
            super.deleteEntity(country);
        }
    }

    /**
     * check data rules in Country, throw DataException with customized message if rules do not apply
     * @param film: Country object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICountry country) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(country.getName()!=null && country.getName().length()>ICountry.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ICountry.SIZE_NAME + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where countryPK is used in a primary key
     * @param countryPK: Country primary key
     */
    public void cascadedeleteCountry(String senderobject, ICountryPK countryPK) {
        BLarealevel1 blarealevel1 = new BLarealevel1(this);
        blarealevel1.delete4country(senderobject, countryPK);
    }

    /**
     * @param arealevel1PK: parent Arealevel1 for child object Country Entity
     * @return child Country Entity object
     * @throws film.general.exception.CustomException
     */
    public ICountry getArealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            CountryPK countryPK = new CountryPK(arealevel1PK.getCountrycode());
            return this.getCountry(countryPK);
        } else return null;
    }


    /**
     * get all Country objects for sqlparameters
     * @return ArrayList of Country objects
     * @throws DBException
     */
    public ArrayList getCountrys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Country.SQLSelect;
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
     * delete all Country objects for sqlparameters
     * @throws DBException
     */
    public void delCountry(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Country.table;
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
