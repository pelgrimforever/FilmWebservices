/*
 * Bspatial_ref_sys.java
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
import film.conversion.json.JSONSpatial_ref_sys;
import film.conversion.entity.EMspatial_ref_sys;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.logicentity.Spatial_ref_sys;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bspatial_ref_sys
 *
 * Superclass for manipulating data- and database objects
 * for Entity Spatial_ref_sys and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bspatial_ref_sys extends BLtable {

    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     */
    public Bspatial_ref_sys() {
        super(new Spatial_ref_sys(), new EMspatial_ref_sys());
    }

    /**
     * Constructor, sets Spatial_ref_sys as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bspatial_ref_sys(BLtable transactionobject) {
        super(transactionobject, new Spatial_ref_sys(), new EMspatial_ref_sys());
    }

    /**
     * create new empty Spatial_ref_sys object
     * @return empty ISpatial_ref_sys
     */
    public ISpatial_ref_sys newSpatial_ref_sys() {
    	return new Spatial_ref_sys();
    }
    
    /**
     * create new empty Spatial_ref_sys object
     * create new primary key with given parameters
     * @param srid primary key field
     * @return ISpatial_ref_sys with primary key
     */
    public ISpatial_ref_sys newSpatial_ref_sys(int srid) {
        return new Spatial_ref_sys(srid);
    }

    /**
     * create new empty Spatial_ref_sys object with given primary key
     * @param spatial_ref_sysPK: primary key for Spatial_ref_sys
     * @return ISpatial_ref_sys with primary key
     */
    public ISpatial_ref_sys newSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) {
        return new Spatial_ref_sys((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    /**
     * create new empty primary key
     * @return empty Spatial_ref_sysPK
     */
    public ISpatial_ref_sysPK newSpatial_ref_sysPK() {
        return new Spatial_ref_sysPK();
    }

    /**
     * create new primary key with given parameters
     * @param srid primary key field
     * @return new ISpatial_ref_sysPK
     */
    public ISpatial_ref_sysPK newSpatial_ref_sysPK(int srid) {
        return new Spatial_ref_sysPK(srid);
    }

    /**
     * get all Spatial_ref_sys objects from database
     * @return ArrayList of Spatial_ref_sys objects
     * @throws DBException
     */
    public ArrayList<Spatial_ref_sys> getSpatial_ref_syss() throws DBException {
        return (ArrayList<Spatial_ref_sys>)super.getEntities(EMspatial_ref_sys.SQLSelectAll);
    }

    /**
     * search Spatial_ref_sys for primary key
     * @param spatial_ref_sysPK: Spatial_ref_sys primary key
     * @return Spatial_ref_sys object
     * @throws DBException
     */
    public Spatial_ref_sys getSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return (Spatial_ref_sys)super.getEntity((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    /**
     * search spatial_ref_sys with ISpatial_ref_syssearch parameters
     * @param search ISpatial_ref_syssearch
     * @return ArrayList of Spatial_ref_sys
     * @throws DBException 
     */
    public ArrayList<Spatial_ref_sys> searchspatial_ref_syss(ISpatial_ref_syssearch search) throws DBException {
        return (ArrayList<Spatial_ref_sys>)this.search(search);
    }

    /**
     * search spatial_ref_sys with ISpatial_ref_syssearch parameters, order by orderby sql clause
     * @param search ISpatial_ref_syssearch
     * @param orderby sql order by string
     * @return ArrayList of Spatial_ref_sys
     * @throws DBException 
     */
    public ArrayList<Spatial_ref_sys> searchspatial_ref_syss(ISpatial_ref_syssearch search, String orderby) throws DBException {
        return (ArrayList<Spatial_ref_sys>)this.search(search, orderby);
    }

    /**
     * Search spatial_ref_sys in database for spatial_ref_sysPK:
     * @param spatial_ref_sysPK: Spatial_ref_sys Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSpatial_ref_sysExists(ISpatial_ref_sysPK spatial_ref_sysPK) throws DBException {
        return super.getEntityExists((Spatial_ref_sysPK)spatial_ref_sysPK);
    }

    /**
     * try to insert Spatial_ref_sys in database
     * @param spatial_ref_sys Spatial_ref_sys object
     * @throws DBException
     * @throws DataException
     */
    public void insertSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.insertEntity(spatial_ref_sys);
    }

    /**
     * check if Spatial_ref_sysPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param spatial_ref_sys Spatial_ref_sys object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        if(this.getSpatial_ref_sysExists(spatial_ref_sys.getPrimaryKey())) {
            super.updateEntity(spatial_ref_sys);
        } else {
            super.insertEntity(spatial_ref_sys);
        }
    }

    /**
     * try to update Spatial_ref_sys in database
     * @param spatial_ref_sys Spatial_ref_sys object
     * @throws DBException
     * @throws DataException
     */
    public void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException, DataException {
        super.updateEntity(spatial_ref_sys);
    }

    /**
     * try to delete Spatial_ref_sys in database
     * @param spatial_ref_sys Spatial_ref_sys object
     * @throws DBException
     */
    public void deleteSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys) throws DBException {
        cascadedeleteSpatial_ref_sys(spatial_ref_sys.getPrimaryKey());
        super.deleteEntity(spatial_ref_sys);
    }

    /**
     * check data rules in Spatial_ref_sys, throw DataException with customized message if rules do not apply
     * @param spatial_ref_sys Spatial_ref_sys object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISpatial_ref_sys spatial_ref_sys) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(spatial_ref_sys.getAuth_name()!=null && spatial_ref_sys.getAuth_name().length()>ISpatial_ref_sys.SIZE_AUTH_NAME) {
            message.append("Auth_name is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_AUTH_NAME).append("\n");
        }
        if(spatial_ref_sys.getSrtext()!=null && spatial_ref_sys.getSrtext().length()>ISpatial_ref_sys.SIZE_SRTEXT) {
            message.append("Srtext is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_SRTEXT).append("\n");
        }
        if(spatial_ref_sys.getProj4text()!=null && spatial_ref_sys.getProj4text().length()>ISpatial_ref_sys.SIZE_PROJ4TEXT) {
            message.append("Proj4text is langer dan toegestaan. Max aantal karakters: ").append(ISpatial_ref_sys.SIZE_PROJ4TEXT).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where spatial_ref_sysPK is used in a primary key
     * @param spatial_ref_sysPK: Spatial_ref_sys primary key
     */
    public void cascadedeleteSpatial_ref_sys(ISpatial_ref_sysPK spatial_ref_sysPK) {
    }


    /**
     * get all Spatial_ref_sys objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Spatial_ref_sys objects
     * @throws DBException
     */
    public ArrayList<Spatial_ref_sys> getSpatial_ref_syss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMspatial_ref_sys.SQLSelect);
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
        return (ArrayList<Spatial_ref_sys>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Spatial_ref_sys objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSpatial_ref_sys(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Spatial_ref_sys.table);
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
