/*
 * Bsublocality.java
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
import film.conversion.json.JSONSublocality;
import film.conversion.entity.EMsublocality;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bsublocality extends BLtable {

    /**
     * Constructor, sets Sublocality as default Entity
     */
    public Bsublocality() {
        super(new Sublocality(), new EMsublocality());
    }

    /**
     * Constructor, sets Sublocality as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsublocality(BLtable transactionobject) {
        super(transactionobject, new Sublocality(), new EMsublocality());
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
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
     * @param sublocality primary key field
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
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @param locality primary key field
     * @param sublocality primary key field
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
    public ArrayList<Sublocality> getSublocalitys() throws DBException {
        return (ArrayList<Sublocality>)super.getEntities(EMsublocality.SQLSelectAll);
    }

    /**
     * search Sublocality for primary key
     * @param sublocalityPK: Sublocality primary key
     * @return Sublocality object
     * @throws DBException
     */
    public Sublocality getSublocality(ISublocalityPK sublocalityPK) throws DBException {
        return (Sublocality)super.getEntity((SublocalityPK)sublocalityPK);
    }

    /**
     * search sublocality with ISublocalitysearch parameters
     * @param search ISublocalitysearch
     * @return ArrayList of Sublocality
     * @throws DBException 
     */
    public ArrayList<Sublocality> searchsublocalitys(ISublocalitysearch search) throws DBException {
        return (ArrayList<Sublocality>)this.search(search);
    }

    /**
     * search sublocality with ISublocalitysearch parameters, order by orderby sql clause
     * @param search ISublocalitysearch
     * @param orderby sql order by string
     * @return ArrayList of Sublocality
     * @throws DBException 
     */
    public ArrayList<Sublocality> searchsublocalitys(ISublocalitysearch search, String orderby) throws DBException {
        return (ArrayList<Sublocality>)this.search(search, orderby);
    }

    /**
     * Search sublocality in database for sublocalityPK:
     * @param sublocalityPK: Sublocality Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSublocalityExists(ISublocalityPK sublocalityPK) throws DBException {
        return super.getEntityExists((SublocalityPK)sublocalityPK);
    }

    /**
     * try to insert Sublocality in database
     * @param sublocality Sublocality object
     * @throws DBException
     * @throws DataException
     */
    public void insertSublocality(ISublocality sublocality) throws DBException, DataException {
        super.insertEntity(sublocality);
    }

    /**
     * check if SublocalityPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param sublocality Sublocality object
     * @throws DBException
     * @throws DataException
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
     * @param sublocality Sublocality object
     * @throws DBException
     * @throws DataException
     */
    public void updateSublocality(ISublocality sublocality) throws DBException, DataException {
        super.updateEntity(sublocality);
    }

    /**
     * try to delete Sublocality in database
     * @param sublocality Sublocality object
     * @throws DBException
     */
    public void deleteSublocality(ISublocality sublocality) throws DBException {
        cascadedeleteSublocality(sublocality.getPrimaryKey());
        super.deleteEntity(sublocality);
    }

    /**
     * check data rules in Sublocality, throw DataException with customized message if rules do not apply
     * @param sublocality Sublocality object
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
    public void cascadedeleteSublocality(ISublocalityPK sublocalityPK) {
        BLroute blroute = new BLroute(this);
        blroute.delete4sublocality(sublocalityPK);
    }

    /**
     * @param localityPK: foreign key for Locality
     * @delete all Sublocality Entity objects for Locality in database
     */
    public void delete4locality(ILocalityPK localityPK) {
        super.addStatement(EMsublocality.SQLDelete4locality, localityPK.getSQLprimarykey());
    }

    /**
     * @param localityPK: foreign key for Locality
     * @return all Sublocality Entity objects for Locality
     * @throws CustomException
     */
    public ArrayList<Sublocality> getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        return super.getEntities(EMsublocality.SQLSelect4locality, localityPK.getSQLprimarykey());
    }
    /**
     * @param routePK: parent Route for child object Sublocality Entity
     * @return child Sublocality Entity object
     * @throws CustomException
     */
    public Sublocality getRoute(IRoutePK routePK) throws CustomException {
        SublocalityPK sublocalityPK = new SublocalityPK(routePK.getCountrycode(), routePK.getPostalcode(), routePK.getLocality(), routePK.getSublocality());
        return this.getSublocality(sublocalityPK);
    }


    /**
     * get all Sublocality objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Sublocality objects
     * @throws DBException
     */
    public ArrayList<Sublocality> getSublocalitys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsublocality.SQLSelect);
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
        return (ArrayList<Sublocality>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Sublocality objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSublocality(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Sublocality.table);
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
