/*
 * Bcountry.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
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
import film.conversion.json.JSONCountry;
import film.conversion.entity.EMcountry;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bcountry extends BLtable {

    /**
     * Constructor, sets Country as default Entity
     */
    public Bcountry() {
        super(new Country(), new EMcountry());
    }

    /**
     * Constructor, sets Country as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcountry(BLtable transactionobject) {
        super(transactionobject, new Country(), new EMcountry());
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
     * @param code primary key field
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
     * @param code primary key field
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
    public ArrayList<Country> getCountrys() throws DBException {
        return (ArrayList<Country>)super.getEntities(EMcountry.SQLSelectAll);
    }

    /**
     * search Country for primary key
     * @param countryPK: Country primary key
     * @return Country object
     * @throws DBException
     */
    public Country getCountry(ICountryPK countryPK) throws DBException {
        return (Country)super.getEntity((CountryPK)countryPK);
    }

    /**
     * search country with ICountrysearch parameters
     * @param search ICountrysearch
     * @return ArrayList of Country
     * @throws DBException 
     */
    public ArrayList<Country> searchcountrys(ICountrysearch search) throws DBException {
        return (ArrayList<Country>)this.search(search);
    }

    /**
     * search country with ICountrysearch parameters, order by orderby sql clause
     * @param search ICountrysearch
     * @param orderby sql order by string
     * @return ArrayList of Country
     * @throws DBException 
     */
    public ArrayList<Country> searchcountrys(ICountrysearch search, String orderby) throws DBException {
        return (ArrayList<Country>)this.search(search, orderby);
    }

    /**
     * Search country in database for countryPK:
     * @param countryPK: Country Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCountryExists(ICountryPK countryPK) throws DBException {
        return super.getEntityExists((CountryPK)countryPK);
    }

    /**
     * try to insert Country in database
     * @param country Country object
     * @throws DBException
     * @throws DataException
     */
    public void insertCountry(ICountry country) throws DBException, DataException {
        super.insertEntity(country);
    }

    /**
     * check if CountryPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param country Country object
     * @throws DBException
     * @throws DataException
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
     * @param country Country object
     * @throws DBException
     * @throws DataException
     */
    public void updateCountry(ICountry country) throws DBException, DataException {
        super.updateEntity(country);
    }

    /**
     * try to delete Country in database
     * @param country Country object
     * @throws DBException
     */
    public void deleteCountry(ICountry country) throws DBException {
        cascadedeleteCountry(country.getPrimaryKey());
        super.deleteEntity(country);
    }

    /**
     * check data rules in Country, throw DataException with customized message if rules do not apply
     * @param country Country object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICountry country) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(country.getName()!=null && country.getName().length()>ICountry.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICountry.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where countryPK is used in a primary key
     * @param countryPK: Country primary key
     */
    public void cascadedeleteCountry(ICountryPK countryPK) {
        BLarealevel1 blarealevel1 = new BLarealevel1(this);
        blarealevel1.delete4country(countryPK);
    }

    /**
     * @param arealevel1PK: parent Arealevel1 for child object Country Entity
     * @return child Country Entity object
     * @throws CustomException
     */
    public Country getArealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        CountryPK countryPK = new CountryPK(arealevel1PK.getCountrycode());
        return this.getCountry(countryPK);
    }


    /**
     * get all Country objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Country objects
     * @throws DBException
     */
    public ArrayList<Country> getCountrys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcountry.SQLSelect);
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
        return (ArrayList<Country>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Country objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delCountry(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Country.table);
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
