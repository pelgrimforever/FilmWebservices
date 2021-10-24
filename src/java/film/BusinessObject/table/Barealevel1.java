/*
 * Barealevel1.java
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
import film.conversion.json.JSONArealevel1;
import film.conversion.entity.EMarealevel1;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Barealevel1 extends BLtable {

    /**
     * Constructor, sets Arealevel1 as default Entity
     */
    public Barealevel1() {
        super(new Arealevel1(), new EMarealevel1());
    }

    /**
     * Constructor, sets Arealevel1 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel1(BLtable transactionobject) {
        super(transactionobject, new Arealevel1(), new EMarealevel1());
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
     * @param countrycode primary key field
     * @param al1code primary key field
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
     * @param countrycode primary key field
     * @param al1code primary key field
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
    public ArrayList<Arealevel1> getArealevel1s() throws DBException {
        return (ArrayList<Arealevel1>)super.getEntities(EMarealevel1.SQLSelectAll);
    }

    /**
     * search Arealevel1 for primary key
     * @param arealevel1PK: Arealevel1 primary key
     * @return Arealevel1 object
     * @throws DBException
     */
    public Arealevel1 getArealevel1(IArealevel1PK arealevel1PK) throws DBException {
        return (Arealevel1)super.getEntity((Arealevel1PK)arealevel1PK);
    }

    /**
     * search arealevel1 with IArealevel1search parameters
     * @param search IArealevel1search
     * @return ArrayList of Arealevel1
     * @throws DBException 
     */
    public ArrayList<Arealevel1> searcharealevel1s(IArealevel1search search) throws DBException {
        return (ArrayList<Arealevel1>)this.search(search);
    }

    /**
     * search arealevel1 with IArealevel1search parameters, order by orderby sql clause
     * @param search IArealevel1search
     * @param orderby sql order by string
     * @return ArrayList of Arealevel1
     * @throws DBException 
     */
    public ArrayList<Arealevel1> searcharealevel1s(IArealevel1search search, String orderby) throws DBException {
        return (ArrayList<Arealevel1>)this.search(search, orderby);
    }

    /**
     * Search arealevel1 in database for arealevel1PK:
     * @param arealevel1PK: Arealevel1 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel1Exists(IArealevel1PK arealevel1PK) throws DBException {
        return super.getEntityExists((Arealevel1PK)arealevel1PK);
    }

    /**
     * try to insert Arealevel1 in database
     * @param arealevel1 Arealevel1 object
     * @throws DBException
     * @throws DataException
     */
    public void insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.insertEntity(arealevel1);
    }

    /**
     * check if Arealevel1PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param arealevel1 Arealevel1 object
     * @throws DBException
     * @throws DataException
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
     * @param arealevel1 Arealevel1 object
     * @throws DBException
     * @throws DataException
     */
    public void updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        super.updateEntity(arealevel1);
    }

    /**
     * try to delete Arealevel1 in database
     * @param arealevel1 Arealevel1 object
     * @throws DBException
     */
    public void deleteArealevel1(IArealevel1 arealevel1) throws DBException {
        cascadedeleteArealevel1(arealevel1.getPrimaryKey());
        super.deleteEntity(arealevel1);
    }

    /**
     * check data rules in Arealevel1, throw DataException with customized message if rules do not apply
     * @param arealevel1 Arealevel1 object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArealevel1 arealevel1) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel1.Countrycode - Country.Code
        //Primary key
        if(arealevel1.getName()!=null && arealevel1.getName().length()>IArealevel1.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel1.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel1PK is used in a primary key
     * @param arealevel1PK: Arealevel1 primary key
     */
    public void cascadedeleteArealevel1(IArealevel1PK arealevel1PK) {
        BLarealevel2 blarealevel2 = new BLarealevel2(this);
        blarealevel2.delete4arealevel1(arealevel1PK);
    }

    /**
     * @param countryPK: foreign key for Country
     * @delete all Arealevel1 Entity objects for Country in database
     */
    public void delete4country(ICountryPK countryPK) {
        super.addStatement(EMarealevel1.SQLDelete4country, countryPK.getSQLprimarykey());
    }

    /**
     * @param countryPK: foreign key for Country
     * @return all Arealevel1 Entity objects for Country
     * @throws CustomException
     */
    public ArrayList<Arealevel1> getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        return super.getEntities(EMarealevel1.SQLSelect4country, countryPK.getSQLprimarykey());
    }
    /**
     * @param arealevel2PK: parent Arealevel2 for child object Arealevel1 Entity
     * @return child Arealevel1 Entity object
     * @throws CustomException
     */
    public Arealevel1 getArealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        Arealevel1PK arealevel1PK = new Arealevel1PK(arealevel2PK.getCountrycode(), arealevel2PK.getAl1code());
        return this.getArealevel1(arealevel1PK);
    }


    /**
     * get all Arealevel1 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Arealevel1 objects
     * @throws DBException
     */
    public ArrayList<Arealevel1> getArealevel1s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel1.SQLSelect);
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
        return (ArrayList<Arealevel1>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Arealevel1 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArealevel1(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel1.table);
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
