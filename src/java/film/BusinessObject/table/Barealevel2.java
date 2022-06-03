/*
 * Barealevel2.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
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
import film.conversion.json.JSONArealevel2;
import film.conversion.entity.EMarealevel2;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Barealevel2 extends BLtable {

    /**
     * Constructor, sets Arealevel2 as default Entity
     */
    public Barealevel2() {
        super(new Arealevel2(), new EMarealevel2());
    }

    /**
     * Constructor, sets Arealevel2 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel2(BLtable transactionobject) {
        super(transactionobject, new Arealevel2(), new EMarealevel2());
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
     * @param countrycode primary key field
     * @param al1code primary key field
     * @param al2code primary key field
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
     * @param countrycode primary key field
     * @param al1code primary key field
     * @param al2code primary key field
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
    public ArrayList<Arealevel2> getArealevel2s() throws DBException {
        return (ArrayList<Arealevel2>)super.getEntities(EMarealevel2.SQLSelectAll);
    }

    /**
     * search Arealevel2 for primary key
     * @param arealevel2PK: Arealevel2 primary key
     * @return Arealevel2 object
     * @throws DBException
     */
    public Arealevel2 getArealevel2(IArealevel2PK arealevel2PK) throws DBException {
        return (Arealevel2)super.getEntity((Arealevel2PK)arealevel2PK);
    }

    /**
     * search arealevel2 with IArealevel2search parameters
     * @param search IArealevel2search
     * @return ArrayList of Arealevel2
     * @throws DBException 
     */
    public ArrayList<Arealevel2> searcharealevel2s(IArealevel2search search) throws DBException {
        return (ArrayList<Arealevel2>)this.search(search);
    }

    /**
     * search arealevel2 with IArealevel2search parameters, order by orderby sql clause
     * @param search IArealevel2search
     * @param orderby sql order by string
     * @return ArrayList of Arealevel2
     * @throws DBException 
     */
    public ArrayList<Arealevel2> searcharealevel2s(IArealevel2search search, String orderby) throws DBException {
        return (ArrayList<Arealevel2>)this.search(search, orderby);
    }

    /**
     * Search arealevel2 in database for arealevel2PK:
     * @param arealevel2PK: Arealevel2 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel2Exists(IArealevel2PK arealevel2PK) throws DBException {
        return super.getEntityExists((Arealevel2PK)arealevel2PK);
    }

    /**
     * try to insert Arealevel2 in database
     * @param arealevel2 Arealevel2 object
     * @throws DBException
     * @throws DataException
     */
    public void insertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        super.insertEntity(arealevel2);
    }

    /**
     * check if Arealevel2PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param arealevel2 Arealevel2 object
     * @throws DBException
     * @throws DataException
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
     * @param arealevel2 Arealevel2 object
     * @throws DBException
     * @throws DataException
     */
    public void updateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        super.updateEntity(arealevel2);
    }

    /**
     * try to delete Arealevel2 in database
     * @param arealevel2 Arealevel2 object
     * @throws DBException
     */
    public void deleteArealevel2(IArealevel2 arealevel2) throws DBException {
        cascadedeleteArealevel2(arealevel2.getPrimaryKey());
        super.deleteEntity(arealevel2);
    }

    /**
     * check data rules in Arealevel2, throw DataException with customized message if rules do not apply
     * @param arealevel2 Arealevel2 object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IArealevel2 arealevel2) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Arealevel2.Countrycode - Arealevel1.Countrycode
        //foreign key Arealevel2.Al1code - Arealevel1.Al1code
        //Primary key
        if(arealevel2.getName()!=null && arealevel2.getName().length()>IArealevel2.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel2.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel2PK is used in a primary key
     * @param arealevel2PK: Arealevel2 primary key
     */
    public void cascadedeleteArealevel2(IArealevel2PK arealevel2PK) {
        BLarealevel3 blarealevel3 = new BLarealevel3(this);
        blarealevel3.delete4arealevel2(arealevel2PK);
    }

    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @delete all Arealevel2 Entity objects for Arealevel1 in database
     */
    public void delete4arealevel1(IArealevel1PK arealevel1PK) {
        super.addStatement(EMarealevel2.SQLDelete4arealevel1, arealevel1PK.getSQLprimarykey());
    }

    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @return all Arealevel2 Entity objects for Arealevel1
     * @throws CustomException
     */
    public ArrayList<Arealevel2> getArealevel2s4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return super.getEntities(EMarealevel2.SQLSelect4arealevel1, arealevel1PK.getSQLprimarykey());
    }
    /**
     * @param arealevel3PK: parent Arealevel3 for child object Arealevel2 Entity
     * @return child Arealevel2 Entity object
     * @throws CustomException
     */
    public Arealevel2 getArealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        Arealevel2PK arealevel2PK = new Arealevel2PK(arealevel3PK.getCountrycode(), arealevel3PK.getAl1code(), arealevel3PK.getAl2code());
        return this.getArealevel2(arealevel2PK);
    }


    /**
     * get all Arealevel2 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Arealevel2 objects
     * @throws DBException
     */
    public ArrayList<Arealevel2> getArealevel2s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel2.SQLSelect);
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
        return (ArrayList<Arealevel2>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Arealevel2 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArealevel2(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel2.table);
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
