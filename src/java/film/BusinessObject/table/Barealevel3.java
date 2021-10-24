/*
 * Barealevel3.java
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
import film.conversion.json.JSONArealevel3;
import film.conversion.entity.EMarealevel3;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Barealevel3 extends BLtable {

    /**
     * Constructor, sets Arealevel3 as default Entity
     */
    public Barealevel3() {
        super(new Arealevel3(), new EMarealevel3());
    }

    /**
     * Constructor, sets Arealevel3 as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Barealevel3(BLtable transactionobject) {
        super(transactionobject, new Arealevel3(), new EMarealevel3());
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
     * @param countrycode primary key field
     * @param al1code primary key field
     * @param al2code primary key field
     * @param al3code primary key field
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
     * @param countrycode primary key field
     * @param al1code primary key field
     * @param al2code primary key field
     * @param al3code primary key field
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
    public ArrayList<Arealevel3> getArealevel3s() throws DBException {
        return (ArrayList<Arealevel3>)super.getEntities(EMarealevel3.SQLSelectAll);
    }

    /**
     * search Arealevel3 for primary key
     * @param arealevel3PK: Arealevel3 primary key
     * @return Arealevel3 object
     * @throws DBException
     */
    public Arealevel3 getArealevel3(IArealevel3PK arealevel3PK) throws DBException {
        return (Arealevel3)super.getEntity((Arealevel3PK)arealevel3PK);
    }

    /**
     * search arealevel3 with IArealevel3search parameters
     * @param search IArealevel3search
     * @return ArrayList of Arealevel3
     * @throws DBException 
     */
    public ArrayList<Arealevel3> searcharealevel3s(IArealevel3search search) throws DBException {
        return (ArrayList<Arealevel3>)this.search(search);
    }

    /**
     * search arealevel3 with IArealevel3search parameters, order by orderby sql clause
     * @param search IArealevel3search
     * @param orderby sql order by string
     * @return ArrayList of Arealevel3
     * @throws DBException 
     */
    public ArrayList<Arealevel3> searcharealevel3s(IArealevel3search search, String orderby) throws DBException {
        return (ArrayList<Arealevel3>)this.search(search, orderby);
    }

    /**
     * Search arealevel3 in database for arealevel3PK:
     * @param arealevel3PK: Arealevel3 Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getArealevel3Exists(IArealevel3PK arealevel3PK) throws DBException {
        return super.getEntityExists((Arealevel3PK)arealevel3PK);
    }

    /**
     * try to insert Arealevel3 in database
     * @param arealevel3 Arealevel3 object
     * @throws DBException
     * @throws DataException
     */
    public void insertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        super.insertEntity(arealevel3);
    }

    /**
     * check if Arealevel3PK exists
     * insert if not, update if found
     * do not commit transaction
     * @param arealevel3 Arealevel3 object
     * @throws DBException
     * @throws DataException
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
     * @param arealevel3 Arealevel3 object
     * @throws DBException
     * @throws DataException
     */
    public void updateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        super.updateEntity(arealevel3);
    }

    /**
     * try to delete Arealevel3 in database
     * @param arealevel3 Arealevel3 object
     * @throws DBException
     */
    public void deleteArealevel3(IArealevel3 arealevel3) throws DBException {
        cascadedeleteArealevel3(arealevel3.getPrimaryKey());
        super.deleteEntity(arealevel3);
    }

    /**
     * check data rules in Arealevel3, throw DataException with customized message if rules do not apply
     * @param arealevel3 Arealevel3 object
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
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IArealevel3.SIZE_NAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where arealevel3PK is used in a primary key
     * @param arealevel3PK: Arealevel3 primary key
     */
    public void cascadedeleteArealevel3(IArealevel3PK arealevel3PK) {
    }

    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @delete all Arealevel3 Entity objects for Arealevel2 in database
     */
    public void delete4arealevel2(IArealevel2PK arealevel2PK) {
        super.addStatement(EMarealevel3.SQLDelete4arealevel2, arealevel2PK.getSQLprimarykey());
    }

    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @return all Arealevel3 Entity objects for Arealevel2
     * @throws CustomException
     */
    public ArrayList<Arealevel3> getArealevel3s4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return super.getEntities(EMarealevel3.SQLSelect4arealevel2, arealevel2PK.getSQLprimarykey());
    }

    /**
     * get all Arealevel3 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Arealevel3 objects
     * @throws DBException
     */
    public ArrayList<Arealevel3> getArealevel3s(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMarealevel3.SQLSelect);
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
        return (ArrayList<Arealevel3>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Arealevel3 objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delArealevel3(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Arealevel3.table);
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
