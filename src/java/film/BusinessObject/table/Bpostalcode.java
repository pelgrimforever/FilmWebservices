/*
 * Bpostalcode.java
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
import film.conversion.json.JSONPostalcode;
import film.conversion.entity.EMpostalcode;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPostalcodesearch;
import film.logicentity.Postalcode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bpostalcode
 *
 * Superclass for manipulating data- and database objects
 * for Entity Postalcode and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bpostalcode extends BLtable {

    /**
     * Constructor, sets Postalcode as default Entity
     */
    public Bpostalcode() {
        super(new Postalcode(), new EMpostalcode());
    }

    /**
     * Constructor, sets Postalcode as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bpostalcode(BLtable transactionobject) {
        super(transactionobject, new Postalcode(), new EMpostalcode());
    }

    /**
     * create new empty Postalcode object
     * @return empty IPostalcode
     */
    public IPostalcode newPostalcode() {
    	return new Postalcode();
    }
    
    /**
     * create new empty Postalcode object
     * create new primary key with given parameters
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @return IPostalcode with primary key
     */
    public IPostalcode newPostalcode(java.lang.String countrycode, java.lang.String postalcode) {
        return new Postalcode(countrycode, postalcode);
    }

    /**
     * create new empty Postalcode object with given primary key
     * @param postalcodePK: primary key for Postalcode
     * @return IPostalcode with primary key
     */
    public IPostalcode newPostalcode(IPostalcodePK postalcodePK) {
        return new Postalcode((PostalcodePK)postalcodePK);
    }

    /**
     * create new empty primary key
     * @return empty PostalcodePK
     */
    public IPostalcodePK newPostalcodePK() {
        return new PostalcodePK();
    }

    /**
     * create new primary key with given parameters
     * @param countrycode primary key field
     * @param postalcode primary key field
     * @return new IPostalcodePK
     */
    public IPostalcodePK newPostalcodePK(java.lang.String countrycode, java.lang.String postalcode) {
        return new PostalcodePK(countrycode, postalcode);
    }

    /**
     * get all Postalcode objects from database
     * @return ArrayList of Postalcode objects
     * @throws DBException
     */
    public ArrayList<Postalcode> getPostalcodes() throws DBException {
        return (ArrayList<Postalcode>)super.getEntities(EMpostalcode.SQLSelectAll);
    }

    /**
     * search Postalcode for primary key
     * @param postalcodePK: Postalcode primary key
     * @return Postalcode object
     * @throws DBException
     */
    public Postalcode getPostalcode(IPostalcodePK postalcodePK) throws DBException {
        return (Postalcode)super.getEntity((PostalcodePK)postalcodePK);
    }

    /**
     * search postalcode with IPostalcodesearch parameters
     * @param search IPostalcodesearch
     * @return ArrayList of Postalcode
     * @throws DBException 
     */
    public ArrayList<Postalcode> searchpostalcodes(IPostalcodesearch search) throws DBException {
        return (ArrayList<Postalcode>)this.search(search);
    }

    /**
     * search postalcode with IPostalcodesearch parameters, order by orderby sql clause
     * @param search IPostalcodesearch
     * @param orderby sql order by string
     * @return ArrayList of Postalcode
     * @throws DBException 
     */
    public ArrayList<Postalcode> searchpostalcodes(IPostalcodesearch search, String orderby) throws DBException {
        return (ArrayList<Postalcode>)this.search(search, orderby);
    }

    /**
     * Search postalcode in database for postalcodePK:
     * @param postalcodePK: Postalcode Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPostalcodeExists(IPostalcodePK postalcodePK) throws DBException {
        return super.getEntityExists((PostalcodePK)postalcodePK);
    }

    /**
     * try to insert Postalcode in database
     * @param postalcode Postalcode object
     * @throws DBException
     * @throws DataException
     */
    public void insertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        super.insertEntity(postalcode);
    }

    /**
     * check if PostalcodePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param postalcode Postalcode object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        if(this.getPostalcodeExists(postalcode.getPrimaryKey())) {
            super.updateEntity(postalcode);
        } else {
            super.insertEntity(postalcode);
        }
    }

    /**
     * try to update Postalcode in database
     * @param postalcode Postalcode object
     * @throws DBException
     * @throws DataException
     */
    public void updatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        super.updateEntity(postalcode);
    }

    /**
     * try to delete Postalcode in database
     * @param postalcode Postalcode object
     * @throws DBException
     */
    public void deletePostalcode(IPostalcode postalcode) throws DBException {
        cascadedeletePostalcode(postalcode.getPrimaryKey());
        super.deleteEntity(postalcode);
    }

    /**
     * check data rules in Postalcode, throw DataException with customized message if rules do not apply
     * @param postalcode Postalcode object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPostalcode postalcode) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        //Primary key
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getCountrycode()!=null && postalcode.getArealevel3PK().getCountrycode().length()>IPostalcode.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_COUNTRYCODE + "\n");
        }
        if(postalcode.getArealevel3PK()==null || postalcode.getArealevel3PK().getCountrycode()==null) {
            message.append("Countrycode mag niet leeg zijn.\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl1code()!=null && postalcode.getArealevel3PK().getAl1code().length()>IPostalcode.SIZE_AL1CODE) {
            message.append("Al1code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL1CODE + "\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl2code()!=null && postalcode.getArealevel3PK().getAl2code().length()>IPostalcode.SIZE_AL2CODE) {
            message.append("Al2code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL2CODE + "\n");
        }
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl3code()!=null && postalcode.getArealevel3PK().getAl3code().length()>IPostalcode.SIZE_AL3CODE) {
            message.append("Al3code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL3CODE + "\n");
        }

        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where postalcodePK is used in a primary key
     * @param postalcodePK: Postalcode primary key
     */
    public void cascadedeletePostalcode(IPostalcodePK postalcodePK) {
        BLlocality bllocality = new BLlocality(this);
        bllocality.delete4postalcode(postalcodePK);
    }

    /**
     * @param arealevel3PK: foreign key for Arealevel3
     * @delete all Postalcode Entity objects for Arealevel3 in database
     */
    public void delete4arealevel3(IArealevel3PK arealevel3PK) {
        super.addStatement(EMpostalcode.SQLDelete4arealevel3, arealevel3PK.getSQLprimarykey());
    }

    /**
     * @param arealevel3PK: foreign key for Arealevel3
     * @return all Postalcode Entity objects for Arealevel3
     * @throws CustomException
     */
    public ArrayList<Postalcode> getPostalcodes4arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return super.getEntities(EMpostalcode.SQLSelect4arealevel3, arealevel3PK.getSQLprimarykey());
    }
    /**
     * @param localityPK: parent Locality for child object Postalcode Entity
     * @return child Postalcode Entity object
     * @throws CustomException
     */
    public Postalcode getLocality(ILocalityPK localityPK) throws CustomException {
        PostalcodePK postalcodePK = new PostalcodePK(localityPK.getCountrycode(), localityPK.getPostalcode());
        return this.getPostalcode(postalcodePK);
    }


    /**
     * get all Postalcode objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Postalcode objects
     * @throws DBException
     */
    public ArrayList<Postalcode> getPostalcodes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMpostalcode.SQLSelect);
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
        return (ArrayList<Postalcode>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Postalcode objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delPostalcode(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Postalcode.table);
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
