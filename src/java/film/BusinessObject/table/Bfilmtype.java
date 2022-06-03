/*
 * Bfilmtype.java
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
import film.conversion.json.JSONFilmtype;
import film.conversion.entity.EMfilmtype;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmtypesearch;
import film.logicentity.Filmtype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bfilmtype
 *
 * Superclass for manipulating data- and database objects
 * for Entity Filmtype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bfilmtype extends BLtable {

    /**
     * Constructor, sets Filmtype as default Entity
     */
    public Bfilmtype() {
        super(new Filmtype(), new EMfilmtype());
    }

    /**
     * Constructor, sets Filmtype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilmtype(BLtable transactionobject) {
        super(transactionobject, new Filmtype(), new EMfilmtype());
    }

    /**
     * create new empty Filmtype object
     * @return empty IFilmtype
     */
    public IFilmtype newFilmtype() {
    	return new Filmtype();
    }
    
    /**
     * create new empty Filmtype object
     * create new primary key with given parameters
     * @param type primary key field
     * @return IFilmtype with primary key
     */
    public IFilmtype newFilmtype(java.lang.String type) {
        return new Filmtype(type);
    }

    /**
     * create new empty Filmtype object with given primary key
     * @param filmtypePK: primary key for Filmtype
     * @return IFilmtype with primary key
     */
    public IFilmtype newFilmtype(IFilmtypePK filmtypePK) {
        return new Filmtype((FilmtypePK)filmtypePK);
    }

    /**
     * create new empty primary key
     * @return empty FilmtypePK
     */
    public IFilmtypePK newFilmtypePK() {
        return new FilmtypePK();
    }

    /**
     * create new primary key with given parameters
     * @param type primary key field
     * @return new IFilmtypePK
     */
    public IFilmtypePK newFilmtypePK(java.lang.String type) {
        return new FilmtypePK(type);
    }

    /**
     * get all Filmtype objects from database
     * @return ArrayList of Filmtype objects
     * @throws DBException
     */
    public ArrayList<Filmtype> getFilmtypes() throws DBException {
        return (ArrayList<Filmtype>)super.getEntities(EMfilmtype.SQLSelectAll);
    }

    /**
     * search Filmtype for primary key
     * @param filmtypePK: Filmtype primary key
     * @return Filmtype object
     * @throws DBException
     */
    public Filmtype getFilmtype(IFilmtypePK filmtypePK) throws DBException {
        return (Filmtype)super.getEntity((FilmtypePK)filmtypePK);
    }

    /**
     * search filmtype with IFilmtypesearch parameters
     * @param search IFilmtypesearch
     * @return ArrayList of Filmtype
     * @throws DBException 
     */
    public ArrayList<Filmtype> searchfilmtypes(IFilmtypesearch search) throws DBException {
        return (ArrayList<Filmtype>)this.search(search);
    }

    /**
     * search filmtype with IFilmtypesearch parameters, order by orderby sql clause
     * @param search IFilmtypesearch
     * @param orderby sql order by string
     * @return ArrayList of Filmtype
     * @throws DBException 
     */
    public ArrayList<Filmtype> searchfilmtypes(IFilmtypesearch search, String orderby) throws DBException {
        return (ArrayList<Filmtype>)this.search(search, orderby);
    }

    /**
     * Search filmtype in database for filmtypePK:
     * @param filmtypePK: Filmtype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmtypeExists(IFilmtypePK filmtypePK) throws DBException {
        return super.getEntityExists((FilmtypePK)filmtypePK);
    }

    /**
     * try to insert Filmtype in database
     * @param filmtype Filmtype object
     * @throws DBException
     * @throws DataException
     */
    public void insertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        super.insertEntity(filmtype);
    }

    /**
     * check if FilmtypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param filmtype Filmtype object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        if(this.getFilmtypeExists(filmtype.getPrimaryKey())) {
            super.updateEntity(filmtype);
        } else {
            super.insertEntity(filmtype);
        }
    }

    /**
     * try to update Filmtype in database
     * @param filmtype Filmtype object
     * @throws DBException
     * @throws DataException
     */
    public void updateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        super.updateEntity(filmtype);
    }

    /**
     * try to delete Filmtype in database
     * @param filmtype Filmtype object
     * @throws DBException
     */
    public void deleteFilmtype(IFilmtype filmtype) throws DBException {
        cascadedeleteFilmtype(filmtype.getPrimaryKey());
        super.deleteEntity(filmtype);
    }

    /**
     * check data rules in Filmtype, throw DataException with customized message if rules do not apply
     * @param filmtype Filmtype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFilmtype filmtype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(filmtype.getDescription()!=null && filmtype.getDescription().length()>IFilmtype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IFilmtype.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where filmtypePK is used in a primary key
     * @param filmtypePK: Filmtype primary key
     */
    public void cascadedeleteFilmtype(IFilmtypePK filmtypePK) {
    }


    /**
     * get all Filmtype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Filmtype objects
     * @throws DBException
     */
    public ArrayList<Filmtype> getFilmtypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilmtype.SQLSelect);
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
        return (ArrayList<Filmtype>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Filmtype objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delFilmtype(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Filmtype.table);
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
