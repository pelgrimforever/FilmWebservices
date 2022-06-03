/*
 * Buploadsessionsettings.java
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
import film.conversion.json.JSONUploadsessionsettings;
import film.conversion.entity.EMuploadsessionsettings;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.logicentity.Uploadsessionsettings;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Buploadsessionsettings
 *
 * Superclass for manipulating data- and database objects
 * for Entity Uploadsessionsettings and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Buploadsessionsettings extends BLtable {

    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     */
    public Buploadsessionsettings() {
        super(new Uploadsessionsettings(), new EMuploadsessionsettings());
    }

    /**
     * Constructor, sets Uploadsessionsettings as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Buploadsessionsettings(BLtable transactionobject) {
        super(transactionobject, new Uploadsessionsettings(), new EMuploadsessionsettings());
    }

    /**
     * create new empty Uploadsessionsettings object
     * @return empty IUploadsessionsettings
     */
    public IUploadsessionsettings newUploadsessionsettings() {
    	return new Uploadsessionsettings();
    }
    
    /**
     * create new empty Uploadsessionsettings object
     * create new primary key with given parameters
     * @param directory primary key field
     * @return IUploadsessionsettings with primary key
     */
    public IUploadsessionsettings newUploadsessionsettings(java.lang.String directory) {
        return new Uploadsessionsettings(directory);
    }

    /**
     * create new empty Uploadsessionsettings object with given primary key
     * @param uploadsessionsettingsPK: primary key for Uploadsessionsettings
     * @return IUploadsessionsettings with primary key
     */
    public IUploadsessionsettings newUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) {
        return new Uploadsessionsettings((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    /**
     * create new empty primary key
     * @return empty UploadsessionsettingsPK
     */
    public IUploadsessionsettingsPK newUploadsessionsettingsPK() {
        return new UploadsessionsettingsPK();
    }

    /**
     * create new primary key with given parameters
     * @param directory primary key field
     * @return new IUploadsessionsettingsPK
     */
    public IUploadsessionsettingsPK newUploadsessionsettingsPK(java.lang.String directory) {
        return new UploadsessionsettingsPK(directory);
    }

    /**
     * get all Uploadsessionsettings objects from database
     * @return ArrayList of Uploadsessionsettings objects
     * @throws DBException
     */
    public ArrayList<Uploadsessionsettings> getUploadsessionsettingss() throws DBException {
        return (ArrayList<Uploadsessionsettings>)super.getEntities(EMuploadsessionsettings.SQLSelectAll);
    }

    /**
     * search Uploadsessionsettings for primary key
     * @param uploadsessionsettingsPK: Uploadsessionsettings primary key
     * @return Uploadsessionsettings object
     * @throws DBException
     */
    public Uploadsessionsettings getUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return (Uploadsessionsettings)super.getEntity((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    /**
     * search uploadsessionsettings with IUploadsessionsettingssearch parameters
     * @param search IUploadsessionsettingssearch
     * @return ArrayList of Uploadsessionsettings
     * @throws DBException 
     */
    public ArrayList<Uploadsessionsettings> searchuploadsessionsettingss(IUploadsessionsettingssearch search) throws DBException {
        return (ArrayList<Uploadsessionsettings>)this.search(search);
    }

    /**
     * search uploadsessionsettings with IUploadsessionsettingssearch parameters, order by orderby sql clause
     * @param search IUploadsessionsettingssearch
     * @param orderby sql order by string
     * @return ArrayList of Uploadsessionsettings
     * @throws DBException 
     */
    public ArrayList<Uploadsessionsettings> searchuploadsessionsettingss(IUploadsessionsettingssearch search, String orderby) throws DBException {
        return (ArrayList<Uploadsessionsettings>)this.search(search, orderby);
    }

    /**
     * Search uploadsessionsettings in database for uploadsessionsettingsPK:
     * @param uploadsessionsettingsPK: Uploadsessionsettings Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getUploadsessionsettingsExists(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return super.getEntityExists((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    /**
     * try to insert Uploadsessionsettings in database
     * @param uploadsessionsettings Uploadsessionsettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.insertEntity(uploadsessionsettings);
    }

    /**
     * check if UploadsessionsettingsPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param uploadsessionsettings Uploadsessionsettings object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        if(this.getUploadsessionsettingsExists(uploadsessionsettings.getPrimaryKey())) {
            super.updateEntity(uploadsessionsettings);
        } else {
            super.insertEntity(uploadsessionsettings);
        }
    }

    /**
     * try to update Uploadsessionsettings in database
     * @param uploadsessionsettings Uploadsessionsettings object
     * @throws DBException
     * @throws DataException
     */
    public void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        super.updateEntity(uploadsessionsettings);
    }

    /**
     * try to delete Uploadsessionsettings in database
     * @param uploadsessionsettings Uploadsessionsettings object
     * @throws DBException
     */
    public void deleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException {
        cascadedeleteUploadsessionsettings(uploadsessionsettings.getPrimaryKey());
        super.deleteEntity(uploadsessionsettings);
    }

    /**
     * check data rules in Uploadsessionsettings, throw DataException with customized message if rules do not apply
     * @param uploadsessionsettings Uploadsessionsettings object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IUploadsessionsettings uploadsessionsettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(uploadsessionsettings.getUploadtype()!=null && uploadsessionsettings.getUploadtype().length()>IUploadsessionsettings.SIZE_UPLOADTYPE) {
            message.append("Uploadtype is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_UPLOADTYPE).append("\n");
        }
        if(uploadsessionsettings.getUploadtype()==null) {
            message.append("Uploadtype mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getFilmgroups()!=null && uploadsessionsettings.getFilmgroups().length()>IUploadsessionsettings.SIZE_FILMGROUPS) {
            message.append("Filmgroups is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_FILMGROUPS).append("\n");
        }
        if(uploadsessionsettings.getFilmgroups()==null) {
            message.append("Filmgroups mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getCopymode()!=null && uploadsessionsettings.getCopymode().length()>IUploadsessionsettings.SIZE_COPYMODE) {
            message.append("Copymode is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_COPYMODE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where uploadsessionsettingsPK is used in a primary key
     * @param uploadsessionsettingsPK: Uploadsessionsettings primary key
     */
    public void cascadedeleteUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) {
    }


    /**
     * get all Uploadsessionsettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Uploadsessionsettings objects
     * @throws DBException
     */
    public ArrayList<Uploadsessionsettings> getUploadsessionsettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuploadsessionsettings.SQLSelect);
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
        return (ArrayList<Uploadsessionsettings>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Uploadsessionsettings objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delUploadsessionsettings(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Uploadsessionsettings.table);
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
