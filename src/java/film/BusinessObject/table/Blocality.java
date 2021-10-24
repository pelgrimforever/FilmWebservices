/*
 * Blocality.java
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
import film.conversion.json.JSONLocality;
import film.conversion.entity.EMlocality;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Blocality extends BLtable {

    /**
     * Constructor, sets Locality as default Entity
     */
    public Blocality() {
        super(new Locality(), new EMlocality());
    }

    /**
     * Constructor, sets Locality as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Blocality(BLtable transactionobject) {
        super(transactionobject, new Locality(), new EMlocality());
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
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
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
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
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
    public ArrayList<Locality> getLocalitys() throws DBException {
        return (ArrayList<Locality>)super.getEntities(EMlocality.SQLSelectAll);
    }

    /**
     * search Locality for primary key
     * @param localityPK: Locality primary key
     * @return Locality object
     * @throws DBException
     */
    public Locality getLocality(ILocalityPK localityPK) throws DBException {
        return (Locality)super.getEntity((LocalityPK)localityPK);
    }

    /**
     * search locality with ILocalitysearch parameters
     * @param search ILocalitysearch
     * @return ArrayList of Locality
     * @throws DBException 
     */
    public ArrayList<Locality> searchlocalitys(ILocalitysearch search) throws DBException {
        return (ArrayList<Locality>)this.search(search);
    }

    /**
     * search locality with ILocalitysearch parameters, order by orderby sql clause
     * @param search ILocalitysearch
     * @param orderby sql order by string
     * @return ArrayList of Locality
     * @throws DBException 
     */
    public ArrayList<Locality> searchlocalitys(ILocalitysearch search, String orderby) throws DBException {
        return (ArrayList<Locality>)this.search(search, orderby);
    }

    /**
     * Search locality in database for localityPK:
     * @param localityPK: Locality Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getLocalityExists(ILocalityPK localityPK) throws DBException {
        return super.getEntityExists((LocalityPK)localityPK);
    }

    /**
     * try to insert Locality in database
     * @param locality Locality object
     * @throws DBException
     * @throws DataException
     */
    public void insertLocality(ILocality locality) throws DBException, DataException {
        super.insertEntity(locality);
    }

    /**
     * check if LocalityPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param locality Locality object
     * @throws DBException
     * @throws DataException
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
     * @param locality Locality object
     * @throws DBException
     * @throws DataException
     */
    public void updateLocality(ILocality locality) throws DBException, DataException {
        super.updateEntity(locality);
    }

    /**
     * try to delete Locality in database
     * @param locality Locality object
     * @throws DBException
     */
    public void deleteLocality(ILocality locality) throws DBException {
        cascadedeleteLocality(locality.getPrimaryKey());
        super.deleteEntity(locality);
    }

    /**
     * check data rules in Locality, throw DataException with customized message if rules do not apply
     * @param locality Locality object
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
    public void cascadedeleteLocality(ILocalityPK localityPK) {
        BLsublocality blsublocality = new BLsublocality(this);
        blsublocality.delete4locality(localityPK);
    }

    /**
     * @param postalcodePK: foreign key for Postalcode
     * @delete all Locality Entity objects for Postalcode in database
     */
    public void delete4postalcode(IPostalcodePK postalcodePK) {
        super.addStatement(EMlocality.SQLDelete4postalcode, postalcodePK.getSQLprimarykey());
    }

    /**
     * @param postalcodePK: foreign key for Postalcode
     * @return all Locality Entity objects for Postalcode
     * @throws CustomException
     */
    public ArrayList<Locality> getLocalitys4postalcode(IPostalcodePK postalcodePK) throws CustomException {
        return super.getEntities(EMlocality.SQLSelect4postalcode, postalcodePK.getSQLprimarykey());
    }
    /**
     * @param sublocalityPK: parent Sublocality for child object Locality Entity
     * @return child Locality Entity object
     * @throws CustomException
     */
    public Locality getSublocality(ISublocalityPK sublocalityPK) throws CustomException {
        LocalityPK localityPK = new LocalityPK(sublocalityPK.getCountrycode(), sublocalityPK.getPostalcode(), sublocalityPK.getLocality());
        return this.getLocality(localityPK);
    }


    /**
     * get all Locality objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Locality objects
     * @throws DBException
     */
    public ArrayList<Locality> getLocalitys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMlocality.SQLSelect);
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
        return (ArrayList<Locality>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Locality objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delLocality(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Locality.table);
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
