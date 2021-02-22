/*
 * Bfilmtype.java
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
import film.conversion.json.JSONFilmtype;
import film.data.ProjectConstants;
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
public abstract class Bfilmtype extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Filmtype as default Entity
     */
    public Bfilmtype() {
        super(new SQLMapper_pgsql(connectionpool, "Filmtype"), new Filmtype());
    }

    /**
     * Constructor, sets Filmtype as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bfilmtype(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Filmtype());
    }

    /**
     * Map ResultSet Field values to Filmtype
     * @param dbresult: Database ResultSet
     */
    public Filmtype mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmtypePK filmtypePK = null;
        Filmtype filmtype;
        if(dbresult==null) {
            filmtype = new Filmtype(filmtypePK);
        } else {
            try {
                filmtypePK = new FilmtypePK(dbresult.getString("type"));
                filmtype = new Filmtype(filmtypePK);
                filmtype.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, filmtype);
        return filmtype;
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
    public ArrayList getFilmtypes() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Filmtype.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Filmtype for primary key
     * @param filmtypePK: Filmtype primary key
     * @return Filmtype object
     * @throws DBException
     */
    public Filmtype getFilmtype(IFilmtypePK filmtypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Filmtype)super.getEntity((FilmtypePK)filmtypePK);
        } else return null;
    }

    public ArrayList searchfilmtypes(IFilmtypesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchfilmtypes(IFilmtypesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search filmtype in database for filmtypePK:
     * @param filmtypePK: Filmtype Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getFilmtypeExists(IFilmtypePK filmtypePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((FilmtypePK)filmtypePK);
        } else return false;
    }

    /**
     * try to insert Filmtype in database
     * @param film: Filmtype object
     * @throws DBException
     */
    public void insertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(filmtype);
        }
    }

    /**
     * check if FilmtypePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Filmtype object
     * @throws DBException
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
     * @param film: Filmtype object
     * @throws DBException
     */
    public void updateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(filmtype);
        }
    }

    /**
     * try to delete Filmtype in database
     * @param film: Filmtype object
     * @throws DBException
     */
    public void deleteFilmtype(IFilmtype filmtype) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteFilmtype(filmtype.getOwnerobject(), filmtype.getPrimaryKey());
            super.deleteEntity(filmtype);
        }
    }

    /**
     * check data rules in Filmtype, throw DataException with customized message if rules do not apply
     * @param film: Filmtype object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IFilmtype filmtype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(filmtype.getDescription()!=null && filmtype.getDescription().length()>IFilmtype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + IFilmtype.SIZE_DESCRIPTION + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where filmtypePK is used in a primary key
     * @param filmtypePK: Filmtype primary key
     */
    public void cascadedeleteFilmtype(String senderobject, IFilmtypePK filmtypePK) {
    }


    /**
     * get all Filmtype objects for sqlparameters
     * @return ArrayList of Filmtype objects
     * @throws DBException
     */
    public ArrayList getFilmtypes(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Filmtype.SQLSelect;
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
     * delete all Filmtype objects for sqlparameters
     * @throws DBException
     */
    public void delFilmtype(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Filmtype.table;
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
